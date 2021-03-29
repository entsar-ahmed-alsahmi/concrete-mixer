package com.example.navigationdrawer_2.drawer_item;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navigationdrawer_2.Model.Model;
import com.example.navigationdrawer_2.R;
import com.example.navigationdrawer_2.Retrofit.ApiClient;
import com.example.navigationdrawer_2.Retrofit.ApiInterface;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {


    ApiInterface apiInterface;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        EditText usernameE = view.findViewById(R.id.ADD_UserName);
        EditText passwordE = view.findViewById(R.id.ADD_PassWord);
        Button addU= view.findViewById(R.id.Add);

        addU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                apiInterface= ApiClient.getApiClient().create(ApiInterface.class);


                Call<Model> modelCall = apiInterface.ADDUser(usernameE.getText().toString(),passwordE.getText().toString());

                modelCall.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response)
                    {
                        if(response.isSuccessful() && response.body()!=null)
                        {
                            Model model=response.body();
                            if(model.isSuccess())
                            {

                                Toast.makeText(getContext(),"User successfully added ",Toast.LENGTH_LONG).show();

                            }
                            else
                            {
                                Toast.makeText(getContext(),"User is not  successfully added,, please try again ",Toast.LENGTH_LONG).show();
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
