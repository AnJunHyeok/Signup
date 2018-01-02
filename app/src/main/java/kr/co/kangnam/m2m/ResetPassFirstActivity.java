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
import android.widget.Toast;

/**
 * Created by aks56 on 2017-12-28.
 */

public class ResetPassFirstActivity extends AppCompatActivity {
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpass_first_layout);

        Button backBtn = (Button) findViewById(R.id.backBtn_Resetpass);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0, 0);
            }
        });

        Button SendBtn = (Button) findViewById(R.id.senBtn_Resetpass);
        SendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userName = (EditText)findViewById(R.id.userNameEdit_Resetpass);
                EditText userPhone = (EditText)findViewById(R.id.phoneNumEdit_Resetpass);

                if(!userName.getText().toString().equals("") && !userPhone.getText().toString().equals("")){
                    flag = true;
                }else{
                    if(userName.getText().toString().equals("") && userPhone.getText().toString().equals(""))
                        Toast.makeText(getApplicationContext(), "이름, 핸드폰 번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    else if(userName.getText().toString().equals(""))
                        Toast.makeText(getApplicationContext(), "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                    else if(userPhone.getText().toString().equals(""))
                        Toast.makeText(getApplicationContext(), "핸드폰 번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button CertiBtn = (Button) findViewById(R.id.certiBtn_Resetpass);
        CertiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userNum = (EditText)findViewById(R.id.numEdit_Resetpass);

                if(!flag)
                    Toast.makeText(getApplicationContext(), "인증번호 발송 버튼을 입력하세요.", Toast.LENGTH_SHORT).show();
                else if(userNum.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "인증번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(getApplicationContext(), ResetPassSecondActivity.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
            }
        });

        String phoneNum = null;
        TelephonyManager telephonyManager = (TelephonyManager) getApplicationContext().getSystemService(getApplicationContext().TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
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

        EditText phoneNumEdit = (EditText)findViewById(R.id.phoneNumEdit_Resetpass);
        phoneNumEdit.setText(phoneNum);
    }

    public void onBackPressed(){
        finish();
        overridePendingTransition(0, 0);
    }
}
