package com.example.utsav.pagination;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.AdapterHolder> {
    private Context context;
    private List<ProductList.Data> dataList;

    public AdapterData(Context context) {
        this.context = context;
        this.dataList = new ArrayList<>();
    }
    public void add(ProductList.Data r) {
        dataList.add(r);
        notifyItemInserted(dataList.size() - 1);
    }

    public void addAll(List<ProductList.Data> moveResults) {
        for (ProductList.Data result : moveResults) {
            add(result);
        }
    }
    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_tv_row,parent,false);
        return new AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, int position) {
        ProductList.Data data=dataList.get(position);
holder.textView.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        if (dataList != null)
            return dataList.size();
        else return 0;
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public AdapterHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_show);
        }
    }
}
