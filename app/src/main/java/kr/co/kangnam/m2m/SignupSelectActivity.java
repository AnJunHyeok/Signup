package kr.co.kangnam.m2m;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by aks56 on 2017-12-31.
 */

public class SignupSelectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_select_layout);

        Button backBtn = (Button) findViewById(R.id.backBtn_Signup);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0, 0);
            }
        });

        Button disableBtn = (Button) findViewById(R.id.disable_Signup);
        disableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DisableSignupFirstActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        Button ableBtn = (Button) findViewById(R.id.able_Signup);
        ableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AbleSignupFirstActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }

    public void onBackPressed(){
        finish();
        overridePendingTransition(0, 0);
    }
}
