package com.example.navigationdrawer_2.drawer_item;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.icu.text.IDNA;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationdrawer_2.Model.Model;
import com.example.navigationdrawer_2.R;
import com.example.navigationdrawer_2.Retrofit.ApiClient;
import com.example.navigationdrawer_2.Retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class deleteAdapter extends RecyclerView.Adapter <deleteAdapter.MyViewHolder> {

    private List<Model> models;
    private Context context;
    private ApiInterface apiInterface;

    public deleteAdapter(List<Model> models , Context context)
    {
        this.models= models;
        this.context= context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_list_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull deleteAdapter.MyViewHolder holder, int position)
    {
        holder.id.setText(models.get(position).getId());
        holder.username.setText(models.get(position).getUsername());



        holder.username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(context);
                builder.setTitle("Delete Conformation").setMessage("You sure, that you want to delete  "+holder.username.getText()+"?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
                        Call<Model> modelCall =apiInterface.deleteUser(holder.username.getText().toString());
                        modelCall.enqueue(new Callback<Model>() {
                            @Override
                            public void onResponse(Call<Model> call, Response<Model> response)
                            {
                                Toast.makeText(context,"User successfully deleted",Toast.LENGTH_LONG).show();

                            }

                            @Override
                            public void onFailure(Call<Model> call, Throwable t)
                            {
                                Toast.makeText(context,"User is not successfully deleted",Toast.LENGTH_LONG).show();

                            }
                        });
                    models.remove(position);
                    notifyItemRemoved(position);}

                        });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog= builder.create();
                alertDialog.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView id,username;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id=  itemView.findViewById(R.id.deleteID);
            username=  itemView.findViewById(R.id.deleteUserName);

        }
    }
}
