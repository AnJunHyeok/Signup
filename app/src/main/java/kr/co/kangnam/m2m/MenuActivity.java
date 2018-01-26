package kr.co.kangnam.m2m;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by aks56 on 2017-12-31.
 */

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        Button backBtn = (Button) findViewById(R.id.backBtn_Menu);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                //왼쪽으로 들어가는 효과 넣으려고 추가 했었음!
                overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
            }
        });
    }

    public void onBackPressed(){
        finish();
        //왼쪽으로 들어가는 효과 넣으려고 추가 했었음!
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
    }
}
