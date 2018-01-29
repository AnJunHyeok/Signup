package kr.co.kangnam.m2m;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by aks56 on 2017-12-31.
 */

public class MainPageActivity extends AppCompatActivity {

    // 뒤로 가기 버튼 눌린 시간 측정
    private long lastTimeBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage_layout);

        Button menuBtn = (Button) findViewById(R.id.menuBtn_Main);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
                //옆에서 튀어나오는 효과 주기 위해서 넣었었음!
                overridePendingTransition(R.anim.anim_silde_in_left, R.anim.anim_slide_out_right);
            }
        });

        Button helpbellHelperBtn = (Button)findViewById(R.id.helpBell_Main_Help);
        helpbellHelperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), helpBellListActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        Button helpbellBtn = (Button)findViewById(R.id.helpBell_Main);
        helpbellBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 만약 장애학생일경우
                Intent intent = new Intent(getApplicationContext(), helpBellRequestActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }

    //뒤로가기를 두번 누르면 꺼지는 설정
    public void onBackPressed(){
        if (System.currentTimeMillis() - lastTimeBackPressed < 1500){
            finish();
            return;
        }
        Toast.makeText(this, "'뒤로' 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        lastTimeBackPressed = System.currentTimeMillis();
    }
}
