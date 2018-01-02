package kr.co.kangnam.m2m;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by aks56 on 2017-12-31.
 */

public class AbleSignupFirstActivity extends AppCompatActivity {

    boolean sendFlag = false, certiFlag = false;
    boolean manFlag = false, womanFlag = false;
    boolean helpFlag = false, carFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ablesignup_first_layout);

        Button backBtn = (Button) findViewById(R.id.backBtn_AbleSignup);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0, 0);
            }
        });

        String phoneNum = null;
        TelephonyManager telephonyManager = (TelephonyManager) getApplicationContext().getSystemService(getApplicationContext().TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
        }else{
            phoneNum = telephonyManager.getLine1Number();
        }

        final EditText phoneNumEdit = (EditText)findViewById(R.id.phoneNumEdit_AbleSignup);
        final EditText numEdit = (EditText)findViewById(R.id.numEdit_AbleSignup);

        phoneNumEdit.setText(phoneNum);

        final Button sendBtn = (Button)findViewById(R.id.sendBtn_AbleSignup);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(phoneNumEdit.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "핸드폰 번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                else
                    sendFlag = true;
            }
        });

        Button certiBtn = (Button)findViewById(R.id.certiBtn_AbleSignup);
        certiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!sendFlag)
                    Toast.makeText(getApplicationContext(), "인증번호 발송 버튼을 눌러주세요.", Toast.LENGTH_SHORT).show();
                else if(numEdit.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "인증번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                else
                    certiFlag = true;
            }
        });

        RadioGroup genderRG = (RadioGroup)findViewById(R.id.genderRG_AbleSignup);
        genderRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.manRB_AbleSignup){
                    manFlag = true;
                    womanFlag = false;
                }else if(i == R.id.womanRB_AbleSignup){
                    womanFlag = true;
                    manFlag = false;
                }
            }
        });

        final RadioGroup helpRG = (RadioGroup)findViewById(R.id.helpKind_AbleSignup);
        helpRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.helpRB_AbleSignup){
                    helpFlag = true;
                    carFlag = false;
                }else if(i == R.id.helpCarRB_AbleSignup){
                    carFlag = true;
                    helpFlag = false;
                }
            }
        });

        Button signupBtn = (Button)findViewById(R.id.signupBtn_AbleSignup);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userName = (EditText)findViewById(R.id.userNameEdit_AbleSignup);
                EditText userPass = (EditText)findViewById(R.id.passEdit_AbleSignup);
                EditText userRepass = (EditText)findViewById(R.id.repassEdit_AbleSignup);

                if(userName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }else if(!certiFlag){
                    Toast.makeText(getApplicationContext(), "휴대폰 인증을 진행해주세요.", Toast.LENGTH_SHORT).show();
                }else if(userPass.getText().toString().equals("") || userRepass.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                else if(userPass.getText().length() < 4)
                    Toast.makeText(getApplicationContext(), "비밀번호를 4자리 이상으로 입력해주세요.", Toast.LENGTH_SHORT).show();
                else if(!userPass.getText().toString().equals(userRepass.getText().toString()))
                    Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                else if(!manFlag && !womanFlag)
                    Toast.makeText(getApplicationContext(), "성별을 선택해주세요.", Toast.LENGTH_SHORT).show();
                else if(!helpFlag && !carFlag)
                    Toast.makeText(getApplicationContext(), "유형을 선택해주세요.", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
            }
        });
    }

    public void onBackPressed(){
        finish();
        overridePendingTransition(0, 0);
    }
}
