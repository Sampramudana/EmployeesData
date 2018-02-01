package com.pramudana.sam.employeesdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView txtUser, txtFullname, txtEmail, txtGender, txtNo, txtAddress, txtDidik,
            txtLpk, txtLast, txtMajor, txtMom, txtDad, txtWife, txtChild, txtTotalGaji, txtgajiTunjang, txtGaji;
    String endUser, endFull, endEmail, endGender, endNo, endAddress, endDidik, endLpk, endMajor, endMom, endDad
            , endWife, endChild, endFams, endLast;
    int gaji, jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent end = getIntent();
        endUser = end.getStringExtra("user");
        endFull = end.getStringExtra("full");
        endEmail = end.getStringExtra("email");
        endGender = end.getStringExtra("gender");
        endNo = end.getStringExtra("no");
        endAddress = end.getStringExtra("address");
        endLast = end.getStringExtra("lasted");
        endDidik = end.getStringExtra("didik");
        endLpk = end.getStringExtra("lpk");
        endMajor = end.getStringExtra("major");
        endMom = end.getStringExtra("mom");
        endDad = end.getStringExtra("dad");
        endWife = end.getStringExtra("wife");
        endChild = end.getStringExtra("child");
        endFams = end.getStringExtra("keluarga");

        txtUser = (TextView)findViewById(R.id.txtUser);
        txtFullname = (TextView)findViewById(R.id.txtFullname);
        txtEmail = (TextView)findViewById(R.id.txtEmail);
        txtGender = (TextView)findViewById(R.id.txtGender);
        txtNo = (TextView)findViewById(R.id.txtNo);
        txtAddress = (TextView)findViewById(R.id.txtAddress);
        txtLast = (TextView)findViewById(R.id.txtLast);
        txtDidik = (TextView)findViewById(R.id.txtDidik);
        txtLpk = (TextView)findViewById(R.id.txtLpk);
        txtMajor = (TextView)findViewById(R.id.txtMajor);
        txtMom = (TextView)findViewById(R.id.txtMom);
        txtDad = (TextView)findViewById(R.id.txtDad);
        txtWife = (TextView)findViewById(R.id.txtWife);
        txtChild = (TextView)findViewById(R.id.txtChild);
        txtTotalGaji = (TextView)findViewById(R.id.txtTotalgaji);
        txtgajiTunjang = (TextView)findViewById(R.id.txtGajiTunjang);
        txtGaji = (TextView)findViewById(R.id.txtGaji);

        if (endDidik.equalsIgnoreCase("SD")){
            gaji = 1000000;
        }else if (endDidik.equalsIgnoreCase("SMP")){
            gaji = 2000000;
        }else if (endDidik.equalsIgnoreCase("SMK")){
            gaji = 2500000;
        }else if (endDidik.equalsIgnoreCase("D3")){
            gaji = 2700000;
        }else if (endDidik.equalsIgnoreCase("S1")){
            gaji = 3000000;
        }else if (endDidik.equalsIgnoreCase("S2")){
            gaji = 5000000;
        }

        if (endFams.equalsIgnoreCase("Sudah") && (endChild.equalsIgnoreCase("Belum Punya"))){
            jumlah = 700000;
        }else if (endFams.equalsIgnoreCase("Sudah") && (endChild.equalsIgnoreCase("1"))){
            jumlah = 1000000;
        }else if (endFams.equalsIgnoreCase("Sudah") && (endChild.equalsIgnoreCase("2"))){
            jumlah = 2000000;
        }else  if (endFams.equalsIgnoreCase("Sudah") && (endChild.equalsIgnoreCase("3"))){
            jumlah = 3000000;
        }

        int jumlaah = gaji + jumlah;

        txtUser.setText("Username : " + endUser);
        txtFullname.setText("Fullname : " + endFull);
        txtEmail.setText("Email : " + endEmail);
        txtGender.setText("Gender : " + endGender);
        txtNo.setText("No Telp : " + endNo);
        txtAddress.setText("Address : " + endAddress);
        txtLast.setText("Last Education : " + endLast);
        txtDidik.setText("Tingkat Pendidikan : " + endDidik);
        txtLpk.setText("IPK : " + endLpk);
        txtMajor.setText("Tingkat : " + endMajor);
        txtMom.setText("Nama Ibu : " + endMom);
        txtDad.setText("Nama Bapak : " + endDad);
        txtWife.setText("Nama Istri : " + endWife);
        txtChild.setText("Jumlah Anak : " + endChild);

        txtTotalGaji.setText("Gaji Pokok Anda : " + gaji);
        txtgajiTunjang.setText("Gaji Tunjangan Anda : " + jumlah);
        txtGaji.setText("Total Gaji : Rp. " + jumlaah);
    }
}
