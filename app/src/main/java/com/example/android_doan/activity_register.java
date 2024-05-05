package com.example.android_doan;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_register extends AppCompatActivity {

    private EditText edtUsername, edtPhone, edtEmail, edtPassword, edtConfirmPassword;
    private Button btnRegister;

    private TextView textViewLogin; // Sửa từ Button thành TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtUsername = findViewById(R.id.edit_username);
        edtPhone = findViewById(R.id.edit_phone);
        edtEmail = findViewById(R.id.edit_email);
        edtPassword = findViewById(R.id.edit_password);
        edtConfirmPassword = findViewById(R.id.edit_confirm_password);
        btnRegister = findViewById(R.id.button_Register);
        textViewLogin = findViewById(R.id.textViewLogin); // Thay đổi từ Button thành TextView

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến màn hình đăng ký khi nhấn vào "Đăng ký"
                Intent intent = new Intent(activity_register.this, MainActivity.class);
                startActivity(intent);
            }
        });

        String text = "Đã có tài khoản? Đăng nhập";
        SpannableString spannableString = new SpannableString(text);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                // Xử lý khi người dùng nhấn vào "Đăng nhập" trong đoạn text
                Intent intent = new Intent(activity_register.this, MainActivity.class);
                startActivity(intent);
            }
        };
        spannableString.setSpan(clickableSpan, text.indexOf("Đăng nhập"), text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textViewLogin.setText(spannableString);
        textViewLogin.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void register() {
        String username = edtUsername.getText().toString();
        String phone = edtPhone.getText().toString();
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        String confirmPassword = edtConfirmPassword.getText().toString();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO: Perform registration process here (e.g., send data to server, save to local database)

        // Once registration is successful, you can navigate to another activity
        // For example:
        startActivity(new Intent(activity_register.this, MainActivity.class));
        finish(); // Optional: Close the current activity
    }
}
