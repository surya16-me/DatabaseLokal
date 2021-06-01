package si.surya.databaselokal.storage;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import si.surya.databaselokal.nodos.penghasilan;

@Dao
public interface DataHelper {
    @Insert
    void insert(penghasilan penghasilan);

    @Update
    void update(penghasilan penghasilan);

    @Query("DELETE FROM penghasilan")
    void deleteAll();

    @Query("SELECT * from penghasilan ORDER BY id ASC")
    LiveData<List<penghasilan>> getAllPenghasilans();
}
