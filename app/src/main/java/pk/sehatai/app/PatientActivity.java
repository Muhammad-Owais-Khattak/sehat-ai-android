package pk.sehatai.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class PatientActivity extends AppCompatActivity {

    private String selectedCity = "Peshawar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView title = findViewById(R.id.title);
        TextView subtitle = findViewById(R.id.subtitle);
        LinearLayout container = findViewById(R.id.contentContainer);
        Button logout = findViewById(R.id.logoutButton);

        title.setText("Patient Dashboard");
        subtitle.setText("Symptom assistant, doctor search, and Google Maps.");

        TextView warning = text("⚠ Sehat AI is a research/educational assistant. It does not provide a confirmed medical diagnosis. Severe chest pain, major breathing difficulty, stroke-like symptoms, loss of consciousness, or uncontrolled bleeding need urgent professional care.");
        warning.setTextColor(getResources().getColor(R.color.red_700));
        container.addView(warning);

        Spinner city = new Spinner(this);
        String[] cities = {"Peshawar","Islamabad","Rawalpindi","Lahore","Karachi","Quetta","Multan","Karak","Kohat","Swabi","Mardan","Charsadda"};
        city.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cities));
        city.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                selectedCity = cities[position];
            }
            public void onNothingSelected(android.widget.AdapterView<?> parent) {}
        });
        container.addView(label("Select city"));
        container.addView(city);

        Button assistant = button("Open AI Symptom Assistant");
        assistant.setOnClickListener(v -> startActivity(new Intent(this, WebAssistantActivity.class)));
        container.addView(assistant);

        Spinner specialty = new Spinner(this);
        String[] specialties = {
            "General Physician","Cardiologist","Dermatologist","Pulmonologist",
            "Neurologist","Gastroenterologist","ENT Specialist","Pediatrician",
            "Gynecologist","Orthopedic Surgeon","Urologist","Ophthalmologist","Psychiatrist"
        };
        specialty.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, specialties));
        container.addView(label("Doctor specialty"));
        container.addView(specialty);

        Button maps = button("Find Doctor / Clinic in Google Maps");
        maps.setOnClickListener(v -> {
            String sp = specialty.getSelectedItem().toString();
            String query = sp + " doctor clinic hospital in " + selectedCity + ", Pakistan";
            String url = "https://www.google.com/maps/search/?api=1&query=" +
                    URLEncoder.encode(query, StandardCharsets.UTF_8);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });
        container.addView(maps);

        logout.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }

    private TextView label(String s) {
        TextView t = new TextView(this);
        t.setText(s);
        t.setTextSize(16);
        t.setPadding(0,18,0,6);
        return t;
    }

    private TextView text(String s) {
        TextView t = new TextView(this);
        t.setText(s);
        t.setTextSize(15);
        t.setPadding(0,10,0,18);
        return t;
    }

    private Button button(String s) {
        Button b = new Button(this);
        b.setText(s);
        b.setAllCaps(false);
        b.setMinHeight(56);
        return b;
    }
}
