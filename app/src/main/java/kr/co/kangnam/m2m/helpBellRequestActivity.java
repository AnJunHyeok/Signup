package kr.co.kangnam.m2m;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by aks56 on 2018-01-26.
 */

public class helpBellRequestActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpbell_request_layout);

        Button backBtn = (Button) findViewById(R.id.backBtn_Helpbell_request);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button sendBtn = (Button) findViewById(R.id.sendBtn_Helpbell_request);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), helpBellAccessActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        });
    }
}
