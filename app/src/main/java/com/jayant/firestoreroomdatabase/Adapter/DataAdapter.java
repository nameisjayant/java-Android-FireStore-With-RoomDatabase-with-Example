package com.jayant.firestoreroomdatabase.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jayant.firestoreroomdatabase.Modal.Data;
import com.jayant.firestoreroomdatabase.R;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private Context context;
    private List<Data> dataList;

    public DataAdapter(Context context, List<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.each_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
   Data data=dataList.get(position);
      holder.name.setText("Name : "+data.getName());
      holder.age.setText("Age : "+data.getAge());
      holder.experience.setText("Experience : "+data.getExprience());
    }

    public void getAllData(List<Data> dataList)
    {
        this.dataList=dataList;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class DataViewHolder extends RecyclerView.ViewHolder{
   public TextView name,age,experience;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name1);
            age=itemView.findViewById(R.id.age1);
            experience=itemView.findViewById(R.id.experience1);
        }
    }
}
