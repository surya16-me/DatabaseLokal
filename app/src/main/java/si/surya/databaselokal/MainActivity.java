package si.surya.databaselokal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import si.surya.databaselokal.custom.PenghasilanAdapter;
import si.surya.databaselokal.nodos.penghasilan;
import si.surya.databaselokal.storage.PenghasilanViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PenghasilanAdapter adapter;
    private PenghasilanViewModel penghasilanViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list_data);
        adapter = new PenghasilanAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        penghasilanViewModel = ViewModelProviders.of(this).get(PenghasilanViewModel.class);
        penghasilanViewModel.getAllPenghasilans().observe(this, new Observer<List<penghasilan>>() {
            @Override
            public void onChanged(@Nullable final List<penghasilan> penghasilans) {
                // Update the cached copy of the words in the adapter.
                adapter.setPenghasilans(penghasilans);
            }
        });

        FloatingActionButton add = findViewById(R.id.fab);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,AddData.class),12345);
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 12345 && resultCode == RESULT_OK) {
            penghasilan penghasilan = data.getParcelableExtra(AddData.EXTRA_REPLY);
            penghasilanViewModel.insert(penghasilan);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "ERROR",
                    Toast.LENGTH_LONG).show();
        }
    }





}