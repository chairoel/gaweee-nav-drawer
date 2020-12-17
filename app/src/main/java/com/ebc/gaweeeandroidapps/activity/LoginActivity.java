package com.ebc.gaweeeandroidapps.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;

import com.ebc.gaweeeandroidapps.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    MaterialButton mButtonLogin;
    EditText mEditUsername;
    EditText mEditPassword;
    TextInputLayout passwordTextInput;
    TextInputLayout usernameTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mButtonLogin = findViewById(R.id.btnLogin);
        mEditUsername = findViewById(R.id.etUsername);
        mEditPassword = findViewById(R.id.etPassword);
        usernameTextInput = findViewById(R.id.usernameWrapper);
        passwordTextInput = findViewById(R.id.passwordWrapper);

        mButtonLogin.setOnClickListener(v -> {
            if (!isPasswordValid(mEditPassword.getText())) {
                passwordTextInput.setError(getString(R.string.error_password));
            } else {
                passwordTextInput.setError(null); // Clear the error
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }

        });
    }

    private boolean isPasswordValid(@Nullable Editable text) {
        return text != null && text.length() >= 8;
    }

}