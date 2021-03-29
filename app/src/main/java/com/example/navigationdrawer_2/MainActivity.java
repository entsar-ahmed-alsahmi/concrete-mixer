package com.example.navigationdrawer_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navigationdrawer_2.Model.Model;
import com.example.navigationdrawer_2.Retrofit.ApiClient;
import com.example.navigationdrawer_2.Retrofit.ApiInterface;
import com.example.navigationdrawer_2.drawer_item.AccessInfoFragment;
import com.example.navigationdrawer_2.drawer_item.AddUserFragment;
import com.example.navigationdrawer_2.drawer_item.ContactUsFragment;
import com.example.navigationdrawer_2.drawer_item.DeleteFragment;
import com.example.navigationdrawer_2.drawer_item.HomeFragment;
import com.example.navigationdrawer_2.drawer_item.Level2Fragment;
import com.example.navigationdrawer_2.drawer_item.Level3Fragment;
import com.example.navigationdrawer_2.drawer_item.RestPasswordFragment;
import com.example.navigationdrawer_2.drawer_item.UserListFragment;
import com.example.navigationdrawer_2.drawer_item.level1Fragment;
import com.google.android.material.navigation.NavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ApiInterface apiInterface;




    //    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle Toogle;
//    private NavigationView navigationView;
    TextView textUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textUser=findViewById(R.id.getUserName);

        //MenuItem itemAddUser= findViewById(R.id.nav_add_user);

        String type = getIntent().getExtras().getString("user");
            //String rule = getIntent().getExtras().getString("rule");

//            if(rule == "user")
//            {
//                itemAddUser.isChecked();
//            }





//
        drawerLayout=findViewById(R.id.Drawer);
        navigationView=findViewById(R.id.Drawer_nav);
        navigationView.setNavigationItemSelectedListener(this);
        View header= navigationView.getHeaderView(0);
        textUser= header.findViewById(R.id.getUserName);
        textUser.setText(type);
        navigationView.bringToFront();
        Toogle=new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(Toogle);
        Toogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(Toogle.onOptionsItemSelected(item))
//            return true;
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//        switch (menuItem .getItemId())
//        {
//            case R.id.nav_level1 :
//                Intent intent= new Intent(MainActivity.this,com.example.navigationdrawer_2.drawer_item.level1.class);
//                startActivity(intent);
//                break;
//        }
//        return true;
//    }
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(Toogle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment= null;


        String rule = getIntent().getExtras().getString("rule");
        String type = getIntent().getExtras().getString("user");



        switch (menuItem .getItemId())
        {
            case R.id.nav_level1:
                fragment= new level1Fragment();
                loadfragment(fragment);
                setTitle("Level 1");
                break;

            case R.id.nav_level2:
                fragment= new Level2Fragment();
                loadfragment(fragment);
                setTitle("Level 2");
                break;

            case R.id.nav_level3:
                fragment = new Level3Fragment();
                loadfragment(fragment);
                setTitle("Level 3");
                break;
            case R.id.nav_add_user:
                if(rule.equalsIgnoreCase("user")){
                    menuItem.setEnabled(false);
                    break; }
                else{
                fragment = new AddUserFragment();
                loadfragment(fragment);
                    setTitle("Add User");
                break;}
            case R.id.nav_rest_password:
                fragment= new RestPasswordFragment();
                loadfragment(fragment);
                setTitle("Rest Password");
                break;

            case R.id.nav_user_list:
                if(rule.equalsIgnoreCase("user")){
                    menuItem.setEnabled(false);
                    break; }
                else{
                fragment = new UserListFragment();
                loadfragment(fragment);
                    setTitle("User List");
                break;}

            case R.id.nav_delete_user:
                if(rule.equalsIgnoreCase("user")){
                    menuItem.setEnabled(false);
                    break; }
                else{
                fragment = new DeleteFragment();
                loadfragment(fragment);
                    setTitle("Delete User");
                break;}

            case  R.id.nav_home:
                fragment= new HomeFragment();
                loadfragment(fragment);
                setTitle("Home");
                break;

            case R.id.nav_about_us:
                fragment= new ContactUsFragment();
                loadfragment(fragment);
                setTitle("About Us");
                break;
            case R.id.nav_access_info:
                if(rule.equalsIgnoreCase("user")){
                    menuItem.setEnabled(false);
                    break; }
                else{
                fragment= new AccessInfoFragment();
                loadfragment(fragment);
                setTitle("Access Information");
                break;}
            case R.id.nav_logout:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Confirmation PopUp!").
                        setMessage("You sure, that you want to logout?");
                builder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i = new Intent(getApplicationContext(),
                                        login.class);
                                startActivity(i);
                                apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
                                Call<Model> call =apiInterface.logout(type);
                                call.enqueue(new Callback<Model>() {
                                    @Override
                                    public void onResponse(Call<Model> call, Response<Model> response) {
                                        if(response.isSuccessful() && response.body()!=null) {
                                            Model model = response.body();
                                            if (model.isSuccess()) {


                                            } else {

                                            }
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Model> call, Throwable t) {

                                    }
                                });
                                finish();
                            }
                        });
                builder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();

                break;


        }
        return true;
    }

    private void loadfragment(Fragment fragment)
    {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        fragmentTransaction.addToBackStack(null);
    }
}