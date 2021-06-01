package si.surya.databaselokal.storage;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import si.surya.databaselokal.nodos.penghasilan;

@Database(entities = {penghasilan.class}, version = 1)
public abstract class DataSource extends RoomDatabase {
    public abstract DataHelper dataHelper();
    private static volatile DataSource INSTANCE;
    static DataSource getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DataSource.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DataSource.class, "penghasilan")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}