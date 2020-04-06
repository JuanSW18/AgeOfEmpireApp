package com.example.ageofempires.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ageofempires.R;
import com.example.ageofempires.data.models.Technology;
import com.example.ageofempires.data.models.Unit;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class TechnologyAdapter extends RecyclerView.Adapter<TechnologyAdapter.CustomViewHolder> {

    private List<Technology> list;
    private Context context;

    public TechnologyAdapter() {
    }

    public TechnologyAdapter(Context context, List<Technology> list) {
        this.list = list;
        this.context = context;
    }

    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_technology, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(CustomViewHolder viewHolder, int i){
        final Technology item = list.get(i);
        String text = "";

        text = (i+1) + ".- " + item.getName();
        viewHolder.txtTechnologyName.setText(text);
    }

    @Override
    public int getItemCount() {
        return (null != list ? list.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtTechnologyName;

        public CustomViewHolder(View view) {
            super(view);
            this.txtTechnologyName = view.findViewById(R.id.itemTechnologyName);
        }
    }

}
