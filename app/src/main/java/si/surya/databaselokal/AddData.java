package si.surya.databaselokal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import si.surya.databaselokal.nodos.penghasilan;

public class AddData extends AppCompatActivity implements View.OnClickListener{

    public static final String EXTRA_REPLY = "si.surya.REPLY";
    EditText tanggal,pengkot,penghar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        findViewById(R.id.button).setOnClickListener(this);
        tanggal = findViewById(R.id.edittext1);
        pengkot = findViewById(R.id.edittext2);
        penghar = findViewById(R.id.edittext3);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.button){
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(tanggal.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String tanggalN = tanggal.getText().toString();
                int pengkotN = Integer.valueOf(pengkot.getText().toString());
                int pengharN = Integer.valueOf(penghar.getText().toString());
                replyIntent.putExtra(EXTRA_REPLY, new penghasilan(0,tanggalN,pengkotN,pengharN));
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        }
    }

}
