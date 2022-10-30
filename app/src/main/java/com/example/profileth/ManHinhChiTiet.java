package com.example.profileth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.DatabaseMetaData;

public class ManHinhChiTiet extends AppCompatActivity {
    TextView ten,mota;
    ImageView anh;
    LinearLayout BTback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chi_tiet);
        //anh xa
        anh =  (ImageView) findViewById(R.id.ctAnh);
        ten = (TextView) findViewById(R.id.ctTen);
        mota = (TextView) findViewById(R.id.ctGia);
        BTback = (LinearLayout) findViewById(R.id.back);

        //khoi tạo intent
        Intent it = getIntent();

        //Nhan du lieu
        Bundle bd = it.getBundleExtra("dulieu");

        String tens = bd.getString("ten");
        String motas = bd.getString("mota");
        int anhs = bd.getInt("anh");

        ten.setText(tens);
        mota.setText(motas);
        anh.setImageResource(anhs);

        //su kien back
        BTback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ManHinhChiTiet.this,LvMonAn_fragment.class);
                startActivity(i);
            }
        });

    }
}