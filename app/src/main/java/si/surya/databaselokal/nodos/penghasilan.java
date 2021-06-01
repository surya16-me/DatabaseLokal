package si.surya.databaselokal.nodos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;


@Entity(tableName = "penghasilan")
public class penghasilan implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "tanggal")
    private String tanggal;

    @ColumnInfo(name = "pkotor")
    private int pkotor;

    @ColumnInfo(name = "phari")
    private int phari;

    public penghasilan(int id, String tanggal, int pkotor, int phari){
        this.id = id;
        this.tanggal = tanggal;
        this.pkotor = pkotor;
        this.phari = phari;
    }

    protected penghasilan(Parcel in) {
        id = in.readInt();
        tanggal = in.readString();
        pkotor = in.readInt();
        phari = in.readInt();
    }

    public static final Creator<penghasilan> CREATOR = new Creator<penghasilan>() {
        @Override
        public penghasilan createFromParcel(Parcel in) {
            return new penghasilan(in);
        }

        @Override
        public penghasilan[] newArray(int size) {
            return new penghasilan[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public int getPkotor() {
        return pkotor;
    }

    public int getPhari() {
        return phari;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(tanggal);
        parcel.writeInt(pkotor);
        parcel.writeInt(phari);

    }
}
