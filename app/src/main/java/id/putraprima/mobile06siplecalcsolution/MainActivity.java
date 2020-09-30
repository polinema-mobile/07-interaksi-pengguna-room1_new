package id.putraprima.mobile06siplecalcsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.DatePicker;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePickerDialog picker;
    EditText edit_tanggal_lahir, edit_nama, edit_nim;
    Button btnGet,btnGet2;
    Spinner spinner;
    RadioGroup chosen;
    RadioButton rdbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1 findviewbyid btnGet = ...
        btnGet=(Button)findViewById(R.id.button);
        btnGet2=(Button)findViewById(R.id.button2);
        edit_nama=(EditText)findViewById(R.id.edit_text_nama_mahasiswa);
        edit_nim=(EditText)findViewById(R.id.edit_text_Nomor_Induk);
        edit_tanggal_lahir=(EditText) findViewById(R.id.edit_text_tanggal_lahir);
        edit_tanggal_lahir.setInputType(InputType.TYPE_NULL);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        chosen=(RadioGroup)findViewById(R.id.rdGroup1);

        edit_tanggal_lahir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                edit_tanggal_lahir.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        //2 click listener untuk button get

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v){
                String name = edit_nama.getText().toString();
                String nim = edit_nim.getText().toString();
                String tggl = edit_tanggal_lahir.getText().toString();
                String chosenOption = spinner.getSelectedItem().toString();
                int radiogrp = chosen.getCheckedRadioButtonId();
                rdbtn = (RadioButton)findViewById(radiogrp);
                String gender = rdbtn.getText().toString();


                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("NAME",name);
                intent.putExtra("NIM",nim);
                intent.putExtra("TTL",tggl);
                intent.putExtra("CHOSEN_OPTION", chosenOption);
                intent.putExtra("GENDER", gender);
                startActivity(intent);
            }
        });

        btnGet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = chosen.getCheckedRadioButtonId();
                rdbtn = (RadioButton) findViewById(selectedId);
                Mahasiswa mhs = new Mahasiswa(edit_nama.getText().toString(),
                        edit_nim.getText().toString(),edit_tanggal_lahir.getText().toString(),rdbtn.getText().toString(),spinner.getSelectedItem().toString());

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Mahasiswa", mhs);
                startActivity(intent);
            }
        });
    }
}