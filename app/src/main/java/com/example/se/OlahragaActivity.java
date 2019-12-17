package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OlahragaActivity extends AppCompatActivity {
    TotalKalori tk = TotalKalori.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olahraga);
        int totalKalori = tk.getTotalKalori();

        TextView tvTotalKalori = (TextView)findViewById(R.id.jumlahKaloriTxt);
        tvTotalKalori.setText(totalKalori+" cal");


    }

    public void hitungKalori(View view) {
        int bakarKalori = 0;
        EditText etBerapaMenit = (EditText)findViewById(R.id.berapaMenit);
        int berapaMenit = Integer.parseInt(etBerapaMenit.getText().toString());
        bakarKalori = 7*berapaMenit;
        tk.setBakarKalori(bakarKalori);

        Intent i = new Intent(getApplicationContext(),ResultActivity.class);
        startActivity(i);
        finish();
    }
}
