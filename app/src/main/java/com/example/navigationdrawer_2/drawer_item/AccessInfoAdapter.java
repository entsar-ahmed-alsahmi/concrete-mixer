package com.example.navigationdrawer_2.drawer_item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationdrawer_2.Model.Model;
import com.example.navigationdrawer_2.R;

import java.util.List;

public class AccessInfoAdapter extends RecyclerView.Adapter <AccessInfoAdapter.MyViewHolder> {

    private List<Model> models;
    private Context context;

    public AccessInfoAdapter(List<Model> models , Context context)
    {
        this.context=context;
        this.models=models;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.acessinfo_list_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccessInfoAdapter.MyViewHolder holder, int position) {

        holder.sessionNo.setText(models.get(position).getSession_No());
        holder.username.setText(models.get(position).getUsername());
        holder.permission.setText(models.get(position).getPermission());
        holder.entryTime.setText(models.get(position).getEntry_time());
        holder.exitTime.setText(models.get(position).getExit_time());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView sessionNo,username,permission,entryTime,exitTime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            sessionNo = itemView.findViewById(R.id.sessionNo);
            username = itemView.findViewById(R.id.access_username);
            permission = itemView.findViewById(R.id.access_permission);
            entryTime= itemView.findViewById(R.id.access_entryTime);
            exitTime = itemView.findViewById(R.id.access_exitTime);
        }
    }
}
