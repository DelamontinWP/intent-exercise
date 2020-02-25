package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static id.ac.polinema.intentexercise.RegisterActivity.ABOUT_KEY;
import static id.ac.polinema.intentexercise.RegisterActivity.EMAIL_KEY;
import static id.ac.polinema.intentexercise.RegisterActivity.FULLNAME_KEY;
import static id.ac.polinema.intentexercise.RegisterActivity.HOMEPAGE_KEY;

public class ProfileActivity extends AppCompatActivity {

    private TextView fullname;
    private TextView email;
    private TextView homepage;
    private TextView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        about =findViewById(R.id.label_about);
        fullname =findViewById(R.id.label_fullname);
        email =findViewById(R.id.label_email);
        homepage =findViewById(R.id.label_homepage);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String fullnameText = bundle.getString("FULLNAME_KEY");
            String emailText = bundle.getString("EMAIL_KEY");
            String homepageText = bundle.getString("HOMEPAGE_KEY");
            String aboutText = bundle.getString("ABOUT_KEY");

            fullname.setText(fullnameText);
            email.setText(emailText);
            homepage.setText(homepageText);
            about.setText(aboutText);
        }
    }

    public void homepage(View view) {
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String homepageText = bundle.getString("HOMEPAGE_KEY");
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+homepageText));
            startActivity(intent);
        }
    }
}
