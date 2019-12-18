package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Makanan_Activity extends AppCompatActivity {

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    private TextView tvNama, tvKategori, tvKalori, tvDeskripsi;
    private ImageView ivThumbnail;
    private EditText etQty;
    int qtyMakanan;
    int kaloriMakanan;
    TotalKalori tk = TotalKalori.getInstance();
    MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_);

        tvNama = (TextView) findViewById(R.id.txtNama);
        tvKategori = (TextView) findViewById(R.id.txtKategori);
        tvDeskripsi = (TextView) findViewById(R.id.txtDescription);
        tvKalori = (TextView) findViewById(R.id.txtKalori);
        ivThumbnail = (ImageView) findViewById(R.id.makananThumbnail);
        etQty = (EditText) findViewById(R.id.inputQty);


        Intent i = getIntent();
        String namaMakanan = i.getExtras().getString("namaMakanan");
        String kategoriMakanan = i.getExtras().getString("kategoriMakanan");
        String deskripsiMakanan = i.getExtras().getString("deskripsiMakanan");
        kaloriMakanan = i.getExtras().getInt("kaloriMakanan");
        int thumbnailMakanan = i.getExtras().getInt("thumbnailMakanan");


        tvNama.setText(namaMakanan);
        tvKategori.setText("Kategori : " + kategoriMakanan);
        tvKalori.setText("Jumlah Kalori : " + String.valueOf(kaloriMakanan) + " Kcal");
        tvDeskripsi.setText(deskripsiMakanan);
        ivThumbnail.setImageResource(thumbnailMakanan);


    }

    public void buttonTest(View view) {
        etQty = (EditText) findViewById(R.id.inputQty);
        if (isEmpty(etQty)) {
            return;
        }
        qtyMakanan = Integer.parseInt(etQty.getText().toString());
        if(qtyMakanan == 0){
            etQty.setError("Harap Masukkan Qty!");
            return;
        }
        int overallKaloriTemp = 0;
        int totalKalori = 0;
        if (qtyMakanan != 0) {
            totalKalori = qtyMakanan * kaloriMakanan;
            tk.tambahKalori(totalKalori);
            Toast toast = Toast.makeText(getApplicationContext(), "Jumlah Kalori : " + totalKalori, Toast.LENGTH_LONG);
            toast.show();
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("kaloriTotal", totalKalori);
            startActivity(i);
        } else {
            Toast gagalInputData = Toast.makeText(getApplicationContext(), "Harap masukkan data!", Toast.LENGTH_LONG);
            gagalInputData.show();
        }

    }


}
