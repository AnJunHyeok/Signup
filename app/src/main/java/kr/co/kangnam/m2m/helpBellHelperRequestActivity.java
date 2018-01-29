package kr.co.kangnam.m2m;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by aks56 on 2018-01-29.
 */

public class helpBellHelperRequestActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpbell_helper_request_layout);

        Button backBtn = (Button) findViewById(R.id.backBtn_Helpbell_Helper_request);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button okBtn = (Button) findViewById(R.id.okBtn_Helpbell_Helper_request);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), helpBellSendActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        Button cancelBtn = (Button) findViewById(R.id.cancelBtn_Helpbell_Helper_request);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
