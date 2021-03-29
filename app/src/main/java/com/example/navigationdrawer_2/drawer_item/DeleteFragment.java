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
public class DeleteFragment extends Fragment {

    ApiInterface apiInterface;
    private RecyclerView recyclerViewDelete;
    private RecyclerView.LayoutManager layoutManager;
    private List<Model> models;
    private deleteAdapter deleteAdapter;


    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_delete, container, false);

        recyclerViewDelete = view.findViewById(R.id.recyclerViewDelete);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewDelete.setLayoutManager(layoutManager);
        recyclerViewDelete.setHasFixedSize(true);

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Model>> call = apiInterface.deleteUserList();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response)
            {
                models=response.body();
                deleteAdapter = new deleteAdapter(models,getContext());
                recyclerViewDelete.setAdapter(deleteAdapter);

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });


        return view;
    }

}
