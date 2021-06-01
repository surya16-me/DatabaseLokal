package si.surya.databaselokal.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import si.surya.databaselokal.R;
import si.surya.databaselokal.nodos.penghasilan;

public class PenghasilanAdapter extends RecyclerView.Adapter<PenghasilanAdapter.Viewholder>{
    private List<penghasilan> penghasilanList; // Cached
    private LayoutInflater inflater;

    public PenghasilanAdapter(Context context){ this.inflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new Viewholder(inflater.inflate(R.layout.list_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  PenghasilanAdapter.Viewholder viewHolder, int i) {
        if(penghasilanList != null){
            penghasilan item = penghasilanList.get(i);
            viewHolder.tanggal.setText(item.getTanggal());
            viewHolder.pengkot.setText(String.valueOf(item.getPkotor()));
            viewHolder.penghar.setText(String.valueOf(item.getPhari()));

        }

    }

    public void setPenghasilans(List<penghasilan> penghasilans){
        penghasilanList = penghasilans;
        notifyDataSetChanged();
    }

    public void addPenghasilan(penghasilan penghasilans){
        penghasilanList.add(penghasilans);
        notifyDataSetChanged();
    }

    penghasilan getPenghasilan(int position){
        return penghasilanList.get(position);
    }

    @Override
    public int getItemCount() {
        if (penghasilanList != null)
            return penghasilanList.size();
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView tanggal, pengkot, penghar;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tanggal = itemView.findViewById(R.id.tanggal);
            pengkot = itemView.findViewById(R.id.pengkor);
            penghar = itemView.findViewById(R.id.penghar);

        }
    }
}
