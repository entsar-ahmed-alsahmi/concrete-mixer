package com.example.navigationdrawer_2.drawer_item;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.navigationdrawer_2.Model.Model;
import com.example.navigationdrawer_2.R;
import com.example.navigationdrawer_2.Retrofit.ApiClient;
import com.example.navigationdrawer_2.Retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Level2Fragment extends Fragment
{
        ApiInterface apiInterface;

    public Level2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_level2, container, false);

        Button run_level2= view.findViewById(R.id.sub_level2);

        run_level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                Call<Model> modelCall = apiInterface.level(2);

                modelCall.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response)
                    {
                        if(response.isSuccessful() && response.body()!=null)
                        {
                            Model model=response.body();
                            if(model.isSuccess())
                            {

                                Toast.makeText(getContext(),"operation successfully entered ",Toast.LENGTH_LONG).show();

                            }
                            else
                            {
                                Toast.makeText(getContext(),"operation is not successfully entered,, please try again ",Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t)
                    {
                        Toast.makeText(getContext(),"there is a problem check network ",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

             return view;
    }

}
