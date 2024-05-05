package com.example.android_doan;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private TextView textViewRegister; // Sửa từ Button thành TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewRegister = findViewById(R.id.textViewRegister); // Thay đổi từ Button thành TextView

        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến màn hình đăng ký khi nhấn vào "Đăng ký"
                Intent intent = new Intent(MainActivity.this, activity_register.class);
                startActivity(intent);
            }
        });

        String text = "Chưa có tài khoản? Đăng ký";
        SpannableString spannableString = new SpannableString(text);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                // Xử lý khi người dùng nhấn vào "Đăng ký" trong đoạn text
                Intent intent = new Intent(MainActivity.this, activity_register.class);
                startActivity(intent);
            }
        };
        spannableString.setSpan(clickableSpan, text.indexOf("Đăng ký"), text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textViewRegister.setText(spannableString);
        textViewRegister.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
