package com.example.navigationdrawer_2.drawer_item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationdrawer_2.Model.Model;
import com.example.navigationdrawer_2.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter <Adapter.MyViewHolder>
{
    private List<Model> models;
    private Context context;

    public Adapter(List<Model> models , Context context)
    {
        this.models= models;
        this.context= context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.id.setText(models.get(position).getId());
        holder.username.setText(models.get(position).getUsername());
        holder.password.setText(models.get(position).getPassword());
        holder.created_by.setText(models.get(position).getCreated_by());
        holder.created_at.setText(models.get(position).getCreated_at());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView id,username,password,created_by,created_at;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id=  itemView.findViewById(R.id.user_list_id);
            username=  itemView.findViewById(R.id.user_list_username);
            password=  itemView.findViewById(R.id.user_list_password);
            created_by=  itemView.findViewById(R.id.user_list_createdBy);
            created_at= itemView.findViewById(R.id.user_list_createdAt);
        }
    }
}
