package kr.co.kangnam.m2m;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by aks56 on 2017-12-31.
 */

public class ResetPassSecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpass_second_layout);

        Button backBtn = (Button) findViewById(R.id.backBtn_Resetpass);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0, 0);
            }
        });

        Button changeBtn = (Button)findViewById(R.id.changeBtn_Resetpass);
        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText passEdit = (EditText)findViewById(R.id.newPassEdit_Resetpass);
                EditText repassEdit = (EditText)findViewById(R.id.repassEdit_Resetpass);

                if(!passEdit.getText().toString().equals("") && !repassEdit.getText().toString().equals("")) {
                    if(passEdit.getText().length() < 4)
                        Toast.makeText(getApplicationContext(), "비밀번호를 4자리 이상으로 입력해주세요.", Toast.LENGTH_SHORT).show();
                    else if (!passEdit.getText().toString().equals(repassEdit.getText().toString()))
                        Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    else {
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                    }
                }else
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void onBackPressed(){
        finish();
        overridePendingTransition(0, 0);
    }
}
