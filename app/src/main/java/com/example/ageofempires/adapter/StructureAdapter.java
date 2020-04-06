package com.example.ageofempires.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ageofempires.R;
import com.example.ageofempires.data.models.Structure;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class StructureAdapter extends RecyclerView.Adapter<StructureAdapter.CustomViewHolder> {

    private List<Structure> list;
    private Context context;

    public StructureAdapter() {

    }

    public StructureAdapter(Context context, List<Structure> list) {
        this.list = list;
        this.context = context;
    }

    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_structure, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(CustomViewHolder viewHolder, int i){
        final Structure item = list.get(i);
        String text = "";

        text = (i+1) + ".- " + item.getName();
        viewHolder.txtStructureName.setText(text);
    }

    @Override
    public int getItemCount() {
        return (null != list ? list.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtStructureName;

        public CustomViewHolder(View view) {
            super(view);
            this.txtStructureName = view.findViewById(R.id.itemStructureName);
        }
    }

}
