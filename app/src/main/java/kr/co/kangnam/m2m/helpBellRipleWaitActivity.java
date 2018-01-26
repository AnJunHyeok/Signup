package kr.co.kangnam.m2m;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by aks56 on 2018-01-26.
 */

public class helpBellRipleWaitActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpbell_riple_wait_layout);

        Button backBtn = (Button) findViewById(R.id.backBtn_Helpbell_Riple_Wait);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button writeBtn = (Button) findViewById(R.id.writeBtn_Helpbell_Riple_Wait);
        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), helpBellRipleCompleteActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        });
    }
}
