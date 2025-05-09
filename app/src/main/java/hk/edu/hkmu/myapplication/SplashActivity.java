package hk.edu.hkmu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        ImageView splashImage = findViewById(R.id.splash_image);
        splashImage.setImageResource(R.drawable.kmbblack); // 使用您的 PNG 文件名

        // 延遲 3 秒後轉到主活動
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // 結束 SplashActivity
            }
        }, 2000); // 3秒
    }
}