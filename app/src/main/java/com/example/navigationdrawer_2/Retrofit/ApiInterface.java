package com.example.navigationdrawer_2.Retrofit;

import com.example.navigationdrawer_2.Model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("loginuser.php")
    Call<Model>   LoginUser(@Field("username") String username, @Field("password") String password, @Field("permission") String Permission);


    @FormUrlEncoded
    @POST("rigester.php")
    Call<Model> rigesteruser_r(@Field("email") String email, @Field("password") String password,
                                       @Field("username") String username, @Field("rule") String Rule);

    @FormUrlEncoded
    @POST("level1.php")
    Call<Model> level(@Field("Level") int Level);

//    @FormUrlEncoded
//    @POST("level2.php")
//    Call<Model> level2(@Field("Level") int Level);
//
//    @FormUrlEncoded
//    @POST("level3.php")
//    Call<Model> level3(@Field("Level") int Level);

    @FormUrlEncoded
    @POST("AddUser.php")
    Call<Model> ADDUser(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("RestPassword.php")
    Call<Model> RestPass(@Field("CurrentPassword") String CurrentPassword, @Field("NewPassword") String NewPassword);


    @GET("user_list.php")
    Call<List<Model>> getUserList();

    @GET("accessinfo.php")
    Call<List<Model>> getAccessInfo();

    @FormUrlEncoded
    @POST("acess.php")
    Call<Model> accessInfo(@Field("username") String username);

    @GET("delete_user.php")
    Call<List<Model>> deleteUserList();

    @FormUrlEncoded
    @POST("deleteUser.php")
    Call<Model> deleteUser(@Field("username") String username);

    @FormUrlEncoded
    @POST("logout.php")
    Call<Model> logout(@Field("username") String username);

}

