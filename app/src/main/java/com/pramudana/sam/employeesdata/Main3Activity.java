package com.pramudana.sam.employeesdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    EditText etMom, etDad, etWife;
    Button btnSubmit;
    Spinner spinChild, spinFams;
    TextView jmlh;
    String itemChild;
    String itemFams;
    String ambillasted, ambilLpk, ambilDidik, ambilMajor, user1, full1, email1, no1, address1, gender1;
    String[] dataChild = new String[]{

            "Belum Punya", "1", "2", "3"
    };
    String[] dataFams = new String[]{

            "Belum", "Sudah"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent a2 = getIntent();
        ambillasted = a2.getStringExtra("lasted");
        ambilLpk = a2.getStringExtra("lpk");
        ambilDidik = a2.getStringExtra("didik");
        ambilMajor = a2.getStringExtra("major");
        user1 = a2.getStringExtra("user");
        full1 = a2.getStringExtra("full");
        email1 = a2.getStringExtra("email");
        no1 = a2.getStringExtra("no");
        address1 = a2.getStringExtra("address");
        gender1 = a2.getStringExtra("gender");

        spinChild = (Spinner)findViewById(R.id.spinChild);
        spinFams = (Spinner)findViewById(R.id.spinFams);
        etMom = (EditText)findViewById(R.id.etMom);
        etDad = (EditText)findViewById(R.id.etDad);
        etWife = (EditText)findViewById(R.id.etWife);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        jmlh = (TextView)findViewById(R.id.jmlh);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataFams);
        spinFams.setAdapter(adapter);

        spinFams.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                itemFams = parent.getItemAtPosition(position).toString();

                if (itemFams == "Sudah"){

                    jmlh.setVisibility(View.VISIBLE);
                    spinChild.setVisibility(View.VISIBLE);
                    etWife.setVisibility(View.VISIBLE);

                }else if (itemFams == "Belum"){

                    jmlh.setVisibility(View.GONE);
                    spinChild.setVisibility(View.GONE);
                    etWife.setVisibility(View.GONE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataChild);
        spinChild.setAdapter(adapter1);

        spinChild.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                itemChild = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sMom = etMom.getText().toString();
                String sDad = etDad.getText().toString();
                String sWife = etWife.getText().toString();

                if (sMom.isEmpty() && sDad.isEmpty() && sWife.isEmpty()){

                    etMom.setError("Cant Not Be Empty");
                    etDad.setError("Cant Not Be Empty");
                    etWife.setError("Cant Not Be Empty");

                }else {

                    Intent nFile = new Intent(getApplicationContext(), ResultActivity.class);
                    nFile.putExtra("mom", sMom);
                    nFile.putExtra("dad", sDad);
                    nFile.putExtra("wife", sWife);
                    nFile.putExtra("child", itemChild);
                    nFile.putExtra("keluarga", itemFams);
                    nFile.putExtra("lasted", ambillasted);
                    nFile.putExtra("lpk", ambilLpk);
                    nFile.putExtra("didik", ambilDidik);
                    nFile.putExtra("major", ambilMajor);
                    nFile.putExtra("user", user1);
                    nFile.putExtra("full", full1);
                    nFile.putExtra("email", email1);
                    nFile.putExtra("no", no1);
                    nFile.putExtra("address", address1);
                    nFile.putExtra("gender", gender1);
                    startActivity(nFile);
                }

            }
        });
    }
}
