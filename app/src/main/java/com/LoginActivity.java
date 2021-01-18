package com;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // open empty window
        setContentView(R.layout.activity_login);// load data

        Button loginBtn = findViewById(R.id.loginBtn); // get needed elements from xml file (view file)
        Button registerBtn = findViewById(R.id.registerBtn);

        final EditText userName = findViewById(R.id.userName);
        final EditText password = findViewById(R.id.password);
        final CheckBox rememberMe = findViewById(R.id.remember_me);

        final User user = new User(LoginActivity.this);
        rememberMe.setChecked(user.getRemembermeKey());

        if(rememberMe.isChecked()){
            userName.setText(user.getUsernameKey(), TextView.BufferType.EDITABLE);
            password.setText(user.getUsernameKey(), TextView.BufferType.EDITABLE);
        } else {
            userName.setText("", TextView.BufferType.EDITABLE);
            password.setText("", TextView.BufferType.EDITABLE);
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName2 = userName.getText().toString();
                String password2 = password.getText().toString();

                userName.setError(null);
                password.setError(null);

                if(Validation.isCredentialsValid(userName2)&& Validation.isCredentialsValid(password2)) {
                   user.setUsernameKey(userName2);
                   user.setPasswordKey(password2);
                   if(rememberMe.isChecked()){
                       user.setRemembermeKey(true);
                   } else {
                       user.setRemembermeKey(false);
                   }
                    // Intention to go in search window                       from     --------->   to
                    Intent goToSearchActivity = new Intent(LoginActivity.this, SearchActivity.class);
                    // going to search window, action.
                    startActivity(goToSearchActivity);
                } else {
                    userName.setError(getResources().getString(R.string.login_invalid_credentials_message));
                    userName.requestFocus();
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intention to go in search window                       from     --------->   to
                Intent goToRegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                // going to register window, action.
                startActivity(goToRegisterActivity);
            }
        });
    }

}
 /*Toast.makeText(LoginActivity.this,
                        "Prisijungimo vardo: "  +  userName2 + "\n" +
                        "Slatptazodis: " + password2,
                        Toast.LENGTH_SHORT).show();*/