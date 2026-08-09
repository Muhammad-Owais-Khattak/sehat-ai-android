package pk.sehatai.app;

import android.os.Bundle;
import android.webkit.*;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class WebAssistantActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView web = findViewById(R.id.webView);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setDomStorageEnabled(true);
        web.setWebViewClient(new WebViewClient());

        String url = BuildConfig.SEHAT_WEB_URL;
        if (url.contains("example.streamlit.app")) {
            String html = "<html><body style='font-family:sans-serif;padding:24px'>" +
                    "<h2>Sehat AI Assistant</h2>" +
                    "<p>Your Android app is installed correctly.</p>" +
                    "<p>To connect the live OpenAI symptom assistant, deploy your Sehat AI Streamlit website and replace <b>SEHAT_WEB_URL</b> in <code>app/build.gradle</code> with your public Streamlit URL, then build the APK again.</p>" +
                    "<p><b>Safety:</b> This prototype does not provide a confirmed medical diagnosis.</p>" +
                    "</body></html>";
            web.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
        } else {
            web.loadUrl(url);
        }
    }
}
