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

public class Main2Activity extends AppCompatActivity {

    EditText etLasted, etLpk;
    Spinner spinDidik, spinMajor;
    Button btnNxt;
    String itemDidik;
    String itemMajor;
    String ambilUser, ambilFull, ambilNo, ambilEmail, ambilAddress, ambilGender;
    String[] dataDidik = new String[]{

            "SD", "SMP", "SMK", "D3", "S1", "S2"
    };
    String[] dataMajor = new String[]{

            "RPL", "TKJ", "Robotic", "Multimedia"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent a1 = getIntent();
        ambilUser = a1.getStringExtra("user");
        ambilFull = a1.getStringExtra("full");
        ambilNo = a1.getStringExtra("no");
        ambilEmail = a1.getStringExtra("email");
        ambilAddress = a1.getStringExtra("address");
        ambilGender = a1.getStringExtra("gender");

        spinDidik = (Spinner)findViewById(R.id.spinDidik);
        spinMajor = (Spinner)findViewById(R.id.spinMajor);
        etLasted = (EditText)findViewById(R.id.etLastEd);
        etLpk = (EditText)findViewById(R.id.etLpk);
        btnNxt = (Button)findViewById(R.id.btnNxt);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataDidik);
        spinDidik.setAdapter(adapter);

        spinDidik.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                itemDidik = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataMajor);
        spinMajor.setAdapter(adapter1);

        spinMajor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                itemMajor = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sLastEd = etLasted.getText().toString();
                String sLpk = etLpk.getText().toString();

                if (sLastEd.isEmpty() && sLpk.isEmpty()){

                    etLasted.setError("Cant Not Be Empty");
                    etLpk.setError("Cant Not Be Empty");

                }else {

                    Intent nDatas = new Intent(getApplicationContext(), Main3Activity.class);
                    nDatas.putExtra("lasted", sLastEd);
                    nDatas.putExtra("lpk", sLpk);
                    nDatas.putExtra("didik", itemDidik);
                    nDatas.putExtra("major", itemMajor);
                    nDatas.putExtra("user", ambilUser);
                    nDatas.putExtra("full", ambilFull);
                    nDatas.putExtra("email", ambilEmail);
                    nDatas.putExtra("no", ambilNo);
                    nDatas.putExtra("address", ambilAddress);
                    nDatas.putExtra("gender", ambilGender);
                    startActivity(nDatas);

                }
            }
        });
    }
}
