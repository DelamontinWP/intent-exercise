package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    public static final String FULLNAME_KEY = "fullname";
    public static final String EMAIL_KEY = "email";
    public static final String PASSWORD_KEY = "password";
    public static final String CONFIRM_KEY = "confirm";
    public static final String HOMEPAGE_KEY = "homepage";
    public static final String ABOUT_KEY = "about";

    private EditText fullnameInput;
    private EditText emailInput;
    private EditText passwordInput;
    private EditText confirmInput;
    private EditText homepageInput;
    private EditText aboutInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullnameInput = findViewById(R.id.text_fullname);
        emailInput = findViewById(R.id.text_email);
        passwordInput = findViewById(R.id.text_password);
        confirmInput = findViewById(R.id.text_confirm_password);
        homepageInput = findViewById(R.id.text_homepage);
        aboutInput = findViewById(R.id.text_about);
    }

    public void handleProfile(View view) {
        String fullname = fullnameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String confirm = confirmInput.getText().toString();
        String homepage = homepageInput.getText().toString();
        String about = aboutInput.getText().toString();

        if(!(fullname).equals("") && !(email).equals("") && !(password).equals("") && !(confirm).equals("") && !(homepage).equals("") && !(about).equals("")){
            if((password).equals(confirm)){
                Intent intent = new Intent(this,ProfileActivity.class);
                intent.putExtra("FULLNAME_KEY", fullname);
                intent.putExtra("EMAIL_KEY", email);
                intent.putExtra("PASSWORD_KEY", password);
                intent.putExtra("CONFIRM_KEY", confirm);
                intent.putExtra("HOMEPAGE_KEY", homepage);
                intent.putExtra("ABOUT_KEY", about);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Password dan konfirmasi Password harus sama",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Data harus terisi semua",Toast.LENGTH_SHORT).show();
        }
    }
}
