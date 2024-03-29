package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    TotalKalori tk = TotalKalori.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        int a;

        TextView tvTotalKalori = (TextView)findViewById(R.id.resultTotalKalori);
        TextView tvSisaKalori = (TextView)findViewById(R.id.resultSisaKalori);
        TextView tvBakarKalori = (TextView)findViewById(R.id.resultBakarKalori);

//        int totalKaloriResult = Integer.parseInt(tvTotalKalori.getText().toString());
//        int bakarKaloriResult = Integer.parseInt(tvBakarKalori.getText().toString());
//        int sisaKaloriResult = Integer.parseInt(tvSisaKalori.getText().toString());

        tvTotalKalori.setText(tk.getTotalKalori()+" calories");
        tvSisaKalori.setText(tk.getSisaKalori()+" CAL");
        tvBakarKalori.setText(tk.getBakarKalori()+" calories");

    }

    @Override
    public void onBackPressed() {
        Toast t = Toast.makeText(getApplicationContext(),"Tidak bisa kembali!", Toast.LENGTH_LONG);
        t.show();
    }

    public void babay(View view) {
        Intent i = new Intent(getApplicationContext(), ExitActivity.class);
        startActivity(i);
    }
}
