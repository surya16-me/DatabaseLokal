package si.surya.databaselokal.storage;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import androidx.lifecycle.AndroidViewModel;

import java.util.List;


import si.surya.databaselokal.nodos.penghasilan;

public class PenghasilanViewModel extends AndroidViewModel {
    private PenghasilanRepository repository;
    private LiveData<List<penghasilan>> penghasilan;

    public PenghasilanViewModel(@NonNull Application application) {
        super(application);
        repository = new PenghasilanRepository(application);
        penghasilan = repository.getAllPenghasilans();
    }

    public LiveData<List<penghasilan>> getAllPenghasilans() { return penghasilan; }
    public void insert(penghasilan penghasilan) { repository.insert(penghasilan); }
}
