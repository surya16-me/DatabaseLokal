package si.surya.databaselokal.storage;

import android.app.Application;
import androidx.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import si.surya.databaselokal.nodos.penghasilan;

public class PenghasilanRepository {

    private DataHelper dataHelper;
    private LiveData<List<penghasilan>> penghasilan;

    PenghasilanRepository (Application application){
        DataSource dataSource = DataSource.getDatabase(application);
        dataHelper = dataSource.dataHelper();
        penghasilan = dataHelper.getAllPenghasilans();
    }

    LiveData<List<penghasilan>> getAllPenghasilans() { return penghasilan; }
    public void insert (penghasilan penghasilan) { new InsertAsyncTask(dataHelper).execute(penghasilan); }

    public class InsertAsyncTask extends AsyncTask<penghasilan, Void, Void> {
        private DataHelper dataHelper;
        InsertAsyncTask(DataHelper dataHelper){ this.dataHelper = dataHelper; }
        @Override
        protected Void doInBackground(penghasilan... penghasilans) {
            dataHelper.insert(penghasilans[0]);
            return null;
        }
    }
}
