package kr.co.kangnam.m2m;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by aks56 on 2018-01-26.
 */

public class helpBellRipleCompleteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpbell_riple_complete_layout);

        Button backBtn = (Button) findViewById(R.id.backBtn_Helpbell_Riple_Complete);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        LinearLayout homeBtn =  (LinearLayout) findViewById(R.id.homeBtn_Helpbell_Riple_Complete);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
