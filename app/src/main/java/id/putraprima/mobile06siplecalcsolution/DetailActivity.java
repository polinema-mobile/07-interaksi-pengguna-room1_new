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
        TextView ttl = (TextView) findViewById(R.id.tanggal_lahir);
        TextView gender = (TextView) findViewById(R.id.kelamin);
        TextView jurusan = (TextView)findViewById(R.id.jurusan);

        Intent intent = getIntent();
        Mahasiswa mhs = intent.getParcelableExtra("Mahasiswa");

        namaMhs.setText( mhs.getNama());
        nimMhs.setText(mhs.getNim());
        ttl.setText(mhs.getTanggalLahir());
        gender.setText (mhs.getJenisKelamin());
        jurusan.setText(mhs.getJurusan());

    }
}