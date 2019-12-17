package com.example.se;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public int overallKalori;
    TotalKalori tk = TotalKalori.getInstance();
    List<Makanan> mk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView totalKaloriAwal = (TextView) findViewById(R.id.totalKaloriMenu);

        SharedPreferences sp = getSharedPreferences("loginref",MODE_PRIVATE);
        String prefGender = sp.getString("uGenderPref","");
        String prefNama = sp.getString("uNamePref","");

        ImageView ivWelcome = (ImageView) findViewById(R.id.gambarWelcome);
        if(prefGender.equalsIgnoreCase("Male")){
            ivWelcome.setImageResource(R.drawable.boy);
        }
        else{
            ivWelcome.setImageResource(R.drawable.girl);
        }

        TextView welcomeText =(TextView) findViewById(R.id.textWelcome);
        welcomeText.setText("Hello \n"+prefNama);

        mk = new ArrayList<>();
        mk.add(new Makanan("Nasi Putih","Karbohidrat","Nasi adalah beras yang telah direbus. Proses perebusan beras dikenal juga sebagai 'tim'. Penanakan diperlukan untuk membangkitkan aroma nasi dan membuatnya lebih lunak tetapi tetap terjaga konsistensinya.",129,0,R.drawable.nasiputih));
        mk.add(new Makanan("Nasi Merah","Karbohidrat","Beras adalah bagian bulir padi yang telah dipisah dari sekam. Sekam secara anatomi disebut 'palea' dan 'lemma'. Bagian isi inilah, yang berwarna putih, kemerahan, ungu, atau bahkan hitam, yang disebut beras. Kandungan beras Sebagaimana bulir serealia lain, bagian terbesar beras didominasi oleh pati.",110,0,R.drawable.nasimerah));
        mk.add(new Makanan("Ubi Jalar","Karbohidrat","Ubi jalar atau dalam bahasa Inggrisnya sweet potato adalah sejenis tanaman budidaya. Bagian yang dimanfaatkan adalah akarnya yang membentuk umbi dengan kadar gizi yang tinggi.",76,0,R.drawable.ubi));
        mk.add(new Makanan("Kentang Rebus","Karbohidrat","Kentang (Solanum tuberosum L.) adalah tanaman dari suku Solanaceae yang memiliki umbi batang yang dapat dimakan dan disebut kentang pula.",129,0,R.drawable.kentang));
        mk.add(new Makanan("Ayam Goreng","Protein","Ayam goreng Nusantara adalah hidangan Asia Tenggara yang merupakan ayam yang digoreng dalam minyak goreng. Dalam dunia internasional, istilah ayam goreng merujuk kepada ayam goreng gaya Nusantara.",161,0,R.drawable.ayamgoreng));
        mk.add(new Makanan("Dada Ayam Rebus","Protein","Dada ayam rebus adalah sumber protein yang sangat baik karena memiliki protein yang tinggi dan rendah kalori",159,0,R.drawable.dadaayamrebus));
        mk.add(new Makanan("Paha Ayam Rebus","Protein","Paha ayam rebus adalah sumber protein yang sangat baik karena memiliki protein yang tinggi dan rendah kalori",161,0,R.drawable.pahaayamrebus));
        mk.add(new Makanan("Rendang Daging Sapi","Protein","Rendang atau randang adalah masakan daging dengan bumbu rempah-rempah yang berasal dari Minangkabau. Masakan ini dihasilkan dari proses memasak yang dipanaskan berulang-ulang menggunakan santan sampai kuahnya kering sama sekali.",195,0,R.drawable.rendang));
        mk.add(new Makanan("Sayuran Rebus","Serat","Sayuran merupakan sebutan umum bagi bahan pangan asal tumbuhan yang biasanya mengandung kadar air tinggi dan dikonsumsi dalam keadaan segar atau setelah diolah secara minimal. Sebutan untuk beraneka jenis sayuran disebut sebagai sayur-sayuran atau sayur-mayur.",56,0,R.drawable.sayuran));
        mk.add(new Makanan("Jeruk","Serat","eruk atau limau adalah semua tumbuhan berbunga anggota marga Citrus dari suku Rutaceae. Anggotanya berbentuk pohon dengan buah yang berdaging dengan rasa masam yang segar, meskipun banyak di antara anggotanya yang memiliki rasa manis.",47,0,R.drawable.jeruk));
        mk.add(new Makanan("Strawberry","Serat","Stroberi atau tepatnya stroberi kebun adalah sebuah varietas stroberi yang paling banyak dikenal di dunia. Seperti spesies lain dalam genus Fragaria, buah ini berada dalam keluarga Rosaceae.",32,0,R.drawable.strawberry));
        mk.add(new Makanan("Mangga","Serat","Mangga atau mempelam adalah nama sejenis buah, demikian pula nama pohonnya. Mangga termasuk ke dalam marga Mangifera, yang terdiri dari 35-40 anggota dan suku Anacardiaceae.",65,0,R.drawable.mangga));
        mk.add(new Makanan("Melon","Serat","Melon merupakan nama buah sekaligus tanaman yang menghasilkannya, yang termasuk dalam suku labu-labuan atau Cucurbitaceae. Buahnya biasanya dimakan segar sebagai buah meja atau diiris-iris sebagai campuran es buah. Bagian yang dimakan adalah daging buah.",34,0,R.drawable.melon));

        RecyclerView rv = (RecyclerView) findViewById(R.id.id_recyclerview);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,mk);
        rv.setLayoutManager(new GridLayoutManager(this,3));
        rv.setAdapter(myAdapter);

        totalKaloriAwal.setText("Total Kalori : "+tk.getTotalKalori()+" Kkal");


    }

    public void buttonOlahraga(View view) {
        Intent i = new Intent(getApplicationContext(),OlahragaActivity.class);
        startActivity(i);
    }
}
