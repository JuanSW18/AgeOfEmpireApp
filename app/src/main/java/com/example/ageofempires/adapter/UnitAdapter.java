package com.example.ageofempires.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ageofempires.R;
import com.example.ageofempires.data.models.Unit;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.CustomViewHolder> {

    private List<Unit> list;
    private Context context;

    public UnitAdapter() {

    }

    public UnitAdapter(Context context, List<Unit> list) {
        this.list = list;
        this.context = context;
    }

    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_unit, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(CustomViewHolder viewHolder, int i){
        final Unit item = list.get(i);
        String text = "";

        text = (i+1) + ".- " + item.getName();
        viewHolder.txtUnitName.setText(text);
    }

    @Override
    public int getItemCount() {
        return (null != list ? list.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtUnitName;

        public CustomViewHolder(View view) {
            super(view);
            this.txtUnitName = view.findViewById(R.id.itemUnitName);
        }
    }

}
