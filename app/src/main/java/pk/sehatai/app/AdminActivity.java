package pk.sehatai.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ((TextView)findViewById(R.id.title)).setText("Admin Dashboard");
        ((TextView)findViewById(R.id.subtitle)).setText("Prototype administration panel.");
        LinearLayout c = findViewById(R.id.contentContainer);

        add(c, "System Overview");
        add(c, "• Demo patients: 1");
        add(c, "• Demo doctors: 1");
        add(c, "• Supported cities: 12");
        add(c, "• Roles: Admin / Doctor / Patient");
        add(c, "");
        add(c, "Admin Functions");
        add(c, "• Review user roles");
        add(c, "• Manage future doctor records");
        add(c, "• Manage future patient records");
        add(c, "• Monitor system configuration");
        add(c, "");
        add(c, "Important: this APK stores only demo credentials locally. Use a secure authenticated backend before real deployment.");

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
