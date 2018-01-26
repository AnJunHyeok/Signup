package kr.co.kangnam.m2m;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by aks56 on 2018-01-26.
 */

public class helpBellAccessActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpbell_access_layout);

        Button backBtn = (Button) findViewById(R.id.backBtn_Helpbell_Access);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button accessBtn = (Button) findViewById(R.id.AccessBtn_Helpbell_Access);
        accessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), helpBellRipleWaitActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        });

        Button cancelBtn = (Button) findViewById(R.id.CancelBtn_Helpbell_Access);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
