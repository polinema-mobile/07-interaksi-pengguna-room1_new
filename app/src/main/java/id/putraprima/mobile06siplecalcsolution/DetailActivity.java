package id.putraprima.mobile06siplecalcsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //1 findViewById 5 element id
        TextView namaMhs = (TextView) findViewById(R.id.Nama_mahasiswa);
        TextView nimMhs = (TextView) findViewById(R.id.nim);
//        TextView ttl = (TextView) findViewById(R.id.tanggal_lahir);
        //2 buka bundle
//        if(getIntent().getExtras()!=null) {
//            Bundle bundle = getIntent().getExtras();
//            //3 setText masing2 element ke nilai variable bundle
//            namaMhs.setText(bundle.getString("dataNama"));
//            nimMhs.setText(bundle.getInt("dataNim"));
//            ttl.setText(bundle.getString("ttl"));
//        }
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String nim = intent.getStringExtra("NIM");

        namaMhs.setText("Nama : "+name);
        nimMhs.setText("NIM   : "+nim);

    }
}