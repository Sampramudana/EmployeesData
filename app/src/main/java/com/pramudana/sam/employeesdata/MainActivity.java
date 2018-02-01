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

public class MainActivity extends AppCompatActivity {

    EditText etUser, etFullname, etEmail, etNo, etAddress;
    Spinner spinJK;
    Button btnNext;
    String itemJK;
    String[] dataJK = new String[]{

            "Laki - Laki", "Perempuan", "Tidak Ada"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = (EditText)findViewById(R.id.etUser);
        etFullname = (EditText)findViewById(R.id.etFullname);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etAddress = (EditText)findViewById(R.id.etAddress);
        etNo = (EditText)findViewById(R.id.etNo);
        spinJK = (Spinner)findViewById(R.id.spinJK);
        btnNext = (Button)findViewById(R.id.btnNext);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataJK);
        spinJK.setAdapter(adapter);

        spinJK.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                itemJK = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sUser = etUser.getText().toString();
                String sFullname = etFullname.getText().toString();
                String sEmail = etEmail.getText().toString();
                String sNo = etNo.getText().toString();
                String sAddress = etAddress.getText().toString();

                if (sUser.isEmpty() && sFullname.isEmpty() && sEmail.isEmpty() && sNo.isEmpty() && sAddress.isEmpty()){

                    etUser.setError("Cant Not Be Empty");
                    etFullname.setError("Cant Not Be Empty");
                    etEmail.setError("Cant Not Be Empty");
                    etNo.setError("Cant Not Be Empty");
                    etAddress.setError("Cant Not Be Empty");
                }else {

                    Intent nData = new Intent(getApplicationContext(), Main2Activity.class);
                    nData.putExtra("user", sUser);
                    nData.putExtra("full", sFullname);
                    nData.putExtra("email", sEmail);
                    nData.putExtra("no", sNo);
                    nData.putExtra("address", sAddress);
                    nData.putExtra("gender", itemJK);
                    startActivity(nData);

                }
            }
        });
    }
}
