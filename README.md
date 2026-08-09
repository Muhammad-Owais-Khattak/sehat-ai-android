# Sehat AI Android

This package is a native Android prototype with three demo roles:

## Demo accounts

### Patient
Email: `patient@sehatai.pk`  
Password: `Patient@123`

### Doctor
Email: `doctor@sehatai.pk`  
Password: `Doctor@123`

### Admin
Email: `admin@sehatai.pk`  
Password: `Admin@123`

## Patient features

- City selector:
  Peshawar, Islamabad, Rawalpindi, Lahore, Karachi, Quetta, Multan,
  Karak, Kohat, Swabi, Mardan, Charsadda
- relevant doctor-specialty selector
- opens Google Maps doctor/clinic search
- opens the hosted Sehat AI web assistant in an Android WebView
- medical emergency warning

## IMPORTANT: connect the live AI website

Deploy your Sehat AI Streamlit website first.

Then edit:

`app/build.gradle`

Find:

`buildConfigField "String", "SEHAT_WEB_URL", "\"https://example.streamlit.app\""`

Replace the example URL with your actual Streamlit URL, for example:

`buildConfigField "String", "SEHAT_WEB_URL", "\"https://sehat-ai-pakistan.streamlit.app\""`

Do NOT put the OpenAI API key directly in this Android app.
Keep the OpenAI key on your Streamlit/server side.

## Build APK automatically with GitHub

1. Create a new GitHub repository, for example `sehat-ai-android`.
2. Upload ALL contents of this folder to the repository root.
3. Open the repository's `Actions` tab.
4. Open `Build Sehat AI APK`.
5. Press `Run workflow`.
6. Wait for the green check.
7. Open the completed workflow run.
8. Under `Artifacts`, download `SehatAI-Android-APK`.
9. Extract the artifact ZIP.
10. You will get `app-debug.apk`.
11. Send `app-debug.apk` to your Android phone via WhatsApp, Google Drive, USB, etc.
12. On Android, allow "Install unknown apps" for the app you use to open the APK if Android asks.
13. Install and open Sehat AI.
14. Login using one of the demo accounts above.

## Medical / security limitations

This is a research/demo application, not a production medical system.

- Demo passwords are stored in app code and are NOT suitable for real users.
- Real Admin/Doctor/Patient accounts require secure server authentication and a database.
- The doctor dashboard is a prototype, not a live clinical record system.
- The AI assistant must not be presented as a confirmed diagnosis system.
- Do not store OpenAI/Google server API secrets directly in the APK.
