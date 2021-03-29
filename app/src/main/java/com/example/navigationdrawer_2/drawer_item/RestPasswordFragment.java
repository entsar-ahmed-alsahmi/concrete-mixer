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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestPasswordFragment extends Fragment {

    ApiInterface apiInterface;

    public RestPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rest_password, container, false);
        EditText currentpass= view.findViewById(R.id.Current_password);
        EditText newpass= view.findViewById(R.id.New_password);
        EditText confirmpass= view.findViewById(R.id.Confirm_Password);
        Button buttRest= view.findViewById(R.id.Rest_password);

        buttRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(newpass.getText().toString().equalsIgnoreCase(confirmpass.getText().toString()))
                {
                    apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
                    Call<Model> modelCall = apiInterface.RestPass(currentpass.getText().toString(),confirmpass.getText()
                    .toString());

                    modelCall.enqueue(new Callback<Model>() {
                        @Override
                        public void onResponse(Call<Model> call, Response<Model> response)
                        {
                            if(response.isSuccessful() && response.body()!=null)
                            {
                                Model model=response.body();
                                if(model.isSuccess())
                                {

                                    Toast.makeText(getContext(),"Password successfully Rest  ",Toast.LENGTH_LONG).show();

                                }
                                else
                                {
                                    Toast.makeText(getContext(),"Password is not  successfully Rest ,, please try again ",Toast.LENGTH_LONG).show();
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
                else
                    {
                        Toast.makeText(getContext(),"New Password is not the same ",Toast.LENGTH_LONG).show();
                    }

            }
        });

        return view;
    }

}
