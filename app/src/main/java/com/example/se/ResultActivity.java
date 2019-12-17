package com.example.se;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    TotalKalori tk = TotalKalori.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

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
}
