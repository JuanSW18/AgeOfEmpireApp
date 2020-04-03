package com.example.ageofempires.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ageofempires.R;
import com.example.ageofempires.data.models.Civilization;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class CivilizationAdapter extends RecyclerView.Adapter<CivilizationAdapter.CustomViewHolder> {

    private List<Civilization> list;
    private Context context;

    public CivilizationAdapter() {

    }

    public CivilizationAdapter(Context context, List<Civilization> list) {
        this.list = list;
        this.context = context;
    }

    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_civilization, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(CustomViewHolder viewHolder, int i){
        final Civilization item = list.get(i);
        String text = "";

        text = (i+1) + ".- " + item.getName();
        viewHolder.txtCivilizationName.setText(text);
    }

    @Override
    public int getItemCount() {
        return (null != list ? list.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtCivilizationName;

        public CustomViewHolder(View view) {
            super(view);
            this.txtCivilizationName = view.findViewById(R.id.itemCivilizationName);
        }
    }

}
