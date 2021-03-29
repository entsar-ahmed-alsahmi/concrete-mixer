package com.example.navigationdrawer_2.drawer_item;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.navigationdrawer_2.Model.Model;
import com.example.navigationdrawer_2.R;
import com.example.navigationdrawer_2.Retrofit.ApiClient;
import com.example.navigationdrawer_2.Retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment
{
    ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Model> models;
    private Adapter adapter;
    private Context context= getContext();


    public UserListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_user_list, container, false);

//        Button show = view.findViewById(R.id.userShow);
//        show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                Intent intent = new Intent(getContext(), ListActivity.class);
//                startActivity(intent);
//
//            }
//        });
       recyclerView =  view.findViewById(R.id.recyclerView);
       layoutManager = new LinearLayoutManager(getActivity());
       recyclerView.setLayoutManager(layoutManager);
      recyclerView.setHasFixedSize(true);

       apiInterface= ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Model>> call= apiInterface.getUserList();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response)
            {
                models= response.body();
                adapter = new Adapter(models,getContext());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });

        return view;
    }

}
