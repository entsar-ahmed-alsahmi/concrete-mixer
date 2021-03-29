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

public class Registeration extends AppCompatActivity {

    @BindView(R.id.EditTextEmail_R) EditText EditTextEmail_R;
    @BindView(R.id.EditTextPassWord_R) EditText EditTextPassWord_R;
    @BindView(R.id.EditTextUserName) EditText EditTextUserName;
    @BindView(R.id.EditTextRule) EditText EditTextRule;

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        ButterKnife.bind(this);
    }

    public void rigesterUser_R(View view)
    {
        Call<Model> modelCall= apiInterface.rigesteruser_r(EditTextEmail_R.getText().toString(),
                EditTextPassWord_R.getText().toString(),EditTextUserName.getText().toString(),
                EditTextRule.getText().toString());

        modelCall.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response)
            {
                if(response.isSuccessful() && response.body()!=null)
                {
                    Model model=response.body();
                    if(model.isSuccess())
                    {
                        Toast.makeText(Registeration.this,"User successfully registered",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(Registeration.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else
                        {
                            Toast.makeText(Registeration.this,"User already available",Toast.LENGTH_LONG).show();
                        }
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t)
            {
                Toast.makeText(Registeration.this,"Error couldn't connect",Toast.LENGTH_LONG).show();
            }
        });
    }
}
