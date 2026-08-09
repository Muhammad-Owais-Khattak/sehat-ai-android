package pk.sehatai.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class DoctorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ((TextView)findViewById(R.id.title)).setText("Doctor Dashboard");
        ((TextView)findViewById(R.id.subtitle)).setText("Demo doctor account for the Sehat AI prototype.");
        LinearLayout c = findViewById(R.id.contentContainer);

        add(c, "Doctor Profile");
        add(c, "Name: Demo Doctor");
        add(c, "Specialty: General Physician");
        add(c, "Status: Available for prototype testing");
        add(c, "");
        add(c, "Patient Requests");
        add(c, "• No live patient requests are connected yet.");
        add(c, "• Connect a secure backend/database before real patient use.");
        add(c, "");
        add(c, "Clinical Safety");
        add(c, "AI-generated outputs are decision-support only and require professional clinical judgment.");

        findViewById(R.id.logoutButton).setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }

    private void add(LinearLayout c, String s) {
        TextView t = new TextView(this);
        t.setText(s);
        t.setTextSize(16);
        t.setPadding(0,8,0,8);
        c.addView(t);
    }
}
