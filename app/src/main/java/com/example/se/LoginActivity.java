package com.example.se;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    Boolean saveLogin;
    private boolean isEmpty(EditText etText){
        return etText.getText().toString().trim().length() == 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void suksesLogin(View view) {
        EditText etNamaUser = (EditText) findViewById(R.id.loginNama);
        EditText etUmurUser = (EditText) findViewById(R.id.loginUmur);
        EditText etGenderUser = (EditText) findViewById(R.id.loginGender);
        EditText etTinggiUser = (EditText) findViewById(R.id.loginTinggi);
        EditText etBeratUser = (EditText) findViewById(R.id.loginBerat);
        int flag=0;
//        if(isEmpty(etUmurUser) || isEmpty(etTinggiUser) || isEmpty(etBeratUser)){
//            return;
//        }

        if(isEmpty(etUmurUser)){
            etUmurUser.setError("Harap Masukkan Umur!");
            return;
        }
        if(isEmpty(etTinggiUser)){
            etTinggiUser.setError("Harap Masukkan Tinggi!");
            return;
        }
        if(isEmpty(etBeratUser)){
            etBeratUser.setError("Harap Masukkan Berat!");
            return;
        }

        sp = getSharedPreferences("loginref",MODE_PRIVATE);
        editor = sp.edit();

        String isiNamaUser = etNamaUser.getText().toString();
        String isiGenderUser = etGenderUser.getText().toString();
        int isiUmurUser = Integer.parseInt(etUmurUser.getText().toString());
        int isiTinggiUser = Integer.parseInt(etTinggiUser.getText().toString());
        int isiBeratUser = Integer.parseInt(etBeratUser.getText().toString());

        if(TextUtils.isEmpty(isiNamaUser) ){
            etNamaUser.setError("Harap Masukkan Nama!");
            flag = 1;
            return;
        }
        if(TextUtils.isEmpty(isiGenderUser)){
            etGenderUser.setError("Harap Masukkan Gender!");
            flag = 1;
            return;
        }
        if(!isiGenderUser.equalsIgnoreCase("Male")&& !isiGenderUser.equalsIgnoreCase("Female")){
            etGenderUser.setError("Gender harus [Female/Male]");
            return;
        }
        if(isiUmurUser == 0){
            etUmurUser.setError("Harap Masukkan Umur!");
            flag = 1;
            return;
        }


        if(isiBeratUser == 0){
            etBeratUser.setError("Harap Masukkan Berat!");
            flag = 1;
            return;
        }
        if(isiTinggiUser == 0){
            etTinggiUser.setError("Harap Masukkan Tinggi!");
            flag = 1;
            return;
        }


        Intent i = new Intent(this, MainActivity.class);
//        i.putExtra("uName", isiNamaUser);
//        i.putExtra("uGender",isiGenderUser);
//        i.putExtra("uUmur",isiUmurUser);
//        i.putExtra("uTinggi",isiTinggiUser);
//        i.putExtra("uBerat",isiBeratUser);
        String prefNama = etNamaUser.getText().toString().trim();
        String prefGender = etGenderUser.getText().toString().trim();
        editor.putString("uNamePref",prefNama);
        editor.putString("uGenderPref",prefGender);
        editor.apply();

        startActivity(i);

    }
}
