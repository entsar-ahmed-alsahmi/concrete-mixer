package com.example.navigationdrawer_2.drawer_item;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class AccessInfoFragment extends Fragment {

    ApiInterface apiInterface;
    private RecyclerView recyclerViewAccess;
    private RecyclerView.LayoutManager layoutManager;
    private List<Model> models;
    private AccessInfoAdapter accessInfoAdapter;


    public AccessInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_access_info, container, false);

        recyclerViewAccess= view.findViewById(R.id.recyclerViewAccessInfo);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewAccess.setLayoutManager(layoutManager);
        recyclerViewAccess.setHasFixedSize(true);

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Model>> call= apiInterface.getAccessInfo();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                models=response.body();
                accessInfoAdapter= new AccessInfoAdapter(models,getContext());
                recyclerViewAccess.setAdapter(accessInfoAdapter);
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });


        return view;
    }

}
