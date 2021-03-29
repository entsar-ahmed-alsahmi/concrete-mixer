package com.example.navigationdrawer_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navigationdrawer_2.Model.Model;
import com.example.navigationdrawer_2.Retrofit.ApiClient;
import com.example.navigationdrawer_2.Retrofit.ApiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    @BindView(R.id.UserNameLogin)EditText EditTextUser;
    @BindView(R.id.Password_login) EditText EditTextPassword;
    @BindView(R.id.RuleName) EditText EditRuleName;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);

    }

    public void login(View view)
    {

        Call<Model> call= apiInterface.accessInfo(EditTextUser.getText().toString());

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response)
            {
                if(response.isSuccessful() && response.body()!=null) {
                    Model model = response.body();
                    if (model.isSuccess()) {


                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t)
            {

            }
        });


        Call<Model> modelCall = apiInterface.LoginUser(EditTextUser.getText().toString(),
                EditTextPassword.getText().toString(),EditRuleName.getText().toString());
        String getUser= EditTextUser.getText().toString();
        String getRule= EditRuleName.getText().toString();

        modelCall.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response)
            {
                if(response.body()!=null)
                {
                    Model model=response.body();
                    if(model.isSuccess())
                    {
                        Toast.makeText(login.this,"Login Successfull",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(login.this,MainActivity.class);
                        intent.putExtra("user",getUser);
                        intent.putExtra("rule",getRule);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(login.this,"User not found",Toast.LENGTH_LONG).show();
                    }
                }
            }


            @Override
            public void onFailure(Call<Model> call, Throwable t)
            {
                Toast.makeText(login.this,"Error couldn't connect",Toast.LENGTH_LONG).show();

            }
        });


    }


}
