package pk.sehatai.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

public class LoginActivity extends AppCompatActivity {

    private final Map<String, String> passwords = new HashMap<>();
    private final Map<String, String> roles = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Spinner roleSpinner = findViewById(R.id.roleSpinner);
        EditText email = findViewById(R.id.emailInput);
        EditText password = findViewById(R.id.passwordInput);
        Button login = findViewById(R.id.loginButton);
        TextView demo = findViewById(R.id.demoCredentials);

        String[] roleItems = {"Patient", "Doctor", "Admin"};
        roleSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, roleItems));

        addAccount("patient@sehatai.pk", "Patient@123", "Patient");
        addAccount("doctor@sehatai.pk", "Doctor@123", "Doctor");
        addAccount("admin@sehatai.pk", "Admin@123", "Admin");

        demo.setText("Demo logins:\n\nPatient: patient@sehatai.pk / Patient@123\nDoctor: doctor@sehatai.pk / Doctor@123\nAdmin: admin@sehatai.pk / Admin@123");

        login.setOnClickListener(v -> {
            String e = email.getText().toString().trim().toLowerCase();
            String p = password.getText().toString();
            String selectedRole = roleSpinner.getSelectedItem().toString();

            if (passwords.containsKey(e) && passwords.get(e).equals(p) && roles.get(e).equals(selectedRole)) {
                Class<?> target = PatientActivity.class;
                if ("Doctor".equals(selectedRole)) target = DoctorActivity.class;
                if ("Admin".equals(selectedRole)) target = AdminActivity.class;
                startActivity(new Intent(this, target));
            } else {
                Toast.makeText(this, "Invalid email, password, or selected role.", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addAccount(String email, String password, String role) {
        passwords.put(email, password);
        roles.put(email, role);
    }
}
