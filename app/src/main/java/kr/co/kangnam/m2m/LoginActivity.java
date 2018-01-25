package kr.co.kangnam.m2m;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by aks56 on 2017-12-27.
 */

public class LoginActivity extends AppCompatActivity {

    // 뒤로 가기 버튼 눌린 시간 측정
    private long lastTimeBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        final SharedPreferences loginInformation = getSharedPreferences("setting", 0);

        final EditText idEdit = (EditText)findViewById(R.id.idEdit_Login);
        final EditText passEdit = (EditText)findViewById(R.id.passEdit_Login);

        Switch sw = (Switch)findViewById(R.id.autoLogin_Login);

        if(!loginInformation.getString("id", "").equals("")) {
            idEdit.setText(loginInformation.getString("id", ""));
            passEdit.setText(loginInformation.getString("pass", ""));
            sw.setChecked(true);
        }

        TextView findPass = (TextView) findViewById(R.id.findPassTV_Login);
        findPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResetPassFirstActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        Button signupBtn = (Button)findViewById(R.id.signupBtn_Login);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignupSelectActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    SharedPreferences.Editor editor = loginInformation.edit();
                    editor.putString("id", idEdit.getText().toString());
                    editor.putString("pass", passEdit.getText().toString());
                    editor.commit();
                }else{
                    SharedPreferences.Editor editor = loginInformation.edit();
                    editor.putString("id", "");
                    editor.putString("pass", "");
                    editor.commit();
                }
            }
        });

        Button loginBtn = (Button)findViewById(R.id.loginBtn_Login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userId = (EditText) findViewById(R.id.idEdit_Login);
                EditText userPass = (EditText) findViewById(R.id.passEdit_Login);

                if(!userId.getText().toString().equals("") && !userPass.getText().toString().equals("")) {
                    Intent intent = new Intent(getApplicationContext(), MainPageActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }else{
                    if(userId.getText().toString().equals("") && userPass.getText().toString().equals(""))
                        Toast.makeText(getApplicationContext(), "아이디, 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    else if(userId.getText().toString().equals(""))
                        Toast.makeText(getApplicationContext(), "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
                    else if(userPass.getText().toString().equals(""))
                        Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
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
