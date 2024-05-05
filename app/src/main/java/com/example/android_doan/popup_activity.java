package com.example.android_doan;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class popup_activity extends AppCompatActivity {
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_activity);

        long time = 3 * 1000;

        countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long l) {
                // không cần làm gì trong tick
            }

            @Override
            public void onFinish() {
                // chuyển sang MainActivity
                Intent intent = new Intent(popup_activity.this, MainActivity.class);
                startActivity(intent);
                finish(); // kết thúc activity hiện tại
            }
        };
        countDownTimer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // hủy bộ đếm khi activity bị hủy
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
