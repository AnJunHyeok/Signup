package kr.co.kangnam.m2m;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by aks56 on 2018-01-01.
 */

public class DisableSignupFirstActivity extends AppCompatActivity {
    boolean manFlag = false, womanFlag = false;
    int disableKind = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disablesignup_first_layout);

        final String[] strings = {"장애 유형 선택", "시각 장애", "청각 장애", "지체 장애", "지적 장애", "선택 안함"};


        ArrayAdapter spinnerAdapter = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, strings);
        Spinner spinner = (Spinner)findViewById(R.id.disableKind_DisableSignup);
        spinner.setAdapter(spinnerAdapter);

        Button backBtn = (Button) findViewById(R.id.backBtn_DisableSignup);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0, 0);
            }
        });

        //사용자의 핸드폰 자동으로 입력해주는 기능(권한 동의를 했다면!)
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

        final EditText phoneNumEdit = (EditText)findViewById(R.id.phoneNumEdit_DisableSignup);
        phoneNumEdit.setText(phoneNum);

        Button manBtn = (Button)findViewById(R.id.manBtn_DisableSignup);
        manBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manFlag = true;
                womanFlag = false;
            }
        });

        Button womanBtn = (Button)findViewById(R.id.womanBtn_DisableSignup);
        womanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                womanFlag = true;
                manFlag = false;
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                disableKind = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button signupBtn = (Button)findViewById(R.id.signupBtn_DisableSignup);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userName = (EditText)findViewById(R.id.userNameEdit_DisableSignup);
                EditText userPass = (EditText)findViewById(R.id.passEdit_DisableSignup);
                EditText userRepass = (EditText)findViewById(R.id.repassEdit_DisableSignup);
                if(userName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }else if(phoneNumEdit.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "휴대폰 인증을 진행해주세요.", Toast.LENGTH_SHORT).show();
                }else if(userPass.getText().toString().equals("") || userRepass.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                else if(userPass.getText().length() < 4)
                    Toast.makeText(getApplicationContext(), "비밀번호를 4자리 이상으로 입력해주세요.", Toast.LENGTH_SHORT).show();
                else if(!userPass.getText().toString().equals(userRepass.getText().toString()))
                    Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                else if(!manFlag && !womanFlag)
                    Toast.makeText(getApplicationContext(), "성별을 선택해주세요.", Toast.LENGTH_SHORT).show();
                else if(disableKind == 0)
                    Toast.makeText(getApplicationContext(), "장애 유형을 선택해주세요.", Toast.LENGTH_SHORT).show();
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
