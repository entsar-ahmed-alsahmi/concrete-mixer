package com.example.navigationdrawer_2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//import java.time.format.DateTimeFormatter;

public class Model {

    @Expose
    @SerializedName("created_by")
    private String created_by;

    @Expose
    @SerializedName("session_No")
    private String session_No;

    @Expose
    @SerializedName("permission")
    private String permission;

    @Expose
    @SerializedName("entry_time")
    private String entry_time;

    @Expose
    @SerializedName("exit_time")
    private String exit_time;


    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("password")
    private String password;

    @Expose
    @SerializedName("created_at")
    private String created_at;

    @Expose
    @SerializedName("success")
    private boolean success;

    @Expose
    @SerializedName("massege")
    private String massege;


    public String getSession_No() {
        return session_No;
    }

    public void setSession_No(String session_No) {
        this.session_No = session_No;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(String entry_time) {
        this.entry_time = entry_time;
    }

    public String getExit_time() {
        return exit_time;
    }

    public void setExit_time(String exit_time) {
        this.exit_time = exit_time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMassege() {
        return massege;
    }

    public void setMassege(String massege) {
        this.massege = massege;
    }
}
