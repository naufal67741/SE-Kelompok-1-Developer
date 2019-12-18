package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class OlahragaActivity extends AppCompatActivity {
    TotalKalori tk = TotalKalori.getInstance();
    private boolean isEmpty(EditText etText){
        return etText.getText().toString().trim().length() == 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olahraga);
        int totalKalori = tk.getTotalKalori();

        TextView tvTotalKalori = (TextView)findViewById(R.id.jumlahKaloriTxt);
        tvTotalKalori.setText(totalKalori+" cal");


    }

    @Override
    public void onBackPressed() {
        Toast t = Toast.makeText(getApplicationContext(),"Tidak bisa kembali!", Toast.LENGTH_LONG);
        t.show();
    }

    public void hitungKalori(View view) {
        int bakarKalori = 0;
        EditText etBerapaMenit = (EditText)findViewById(R.id.berapaMenit);
        if(isEmpty(etBerapaMenit)){
            etBerapaMenit.setError("Harap Masukkan Berat!");
            return;
        }
        int berapaMenit = Integer.parseInt(etBerapaMenit.getText().toString());
        bakarKalori = 7*berapaMenit;
        tk.setBakarKalori(bakarKalori);



        Intent i = new Intent(getApplicationContext(),ResultActivity.class);
        startActivity(i);
        finish();
    }
}
