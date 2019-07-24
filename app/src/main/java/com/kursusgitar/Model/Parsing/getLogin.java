package com.kursusgitar.Model.Parsing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kursusgitar.Model.Login;

public class getLogin {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("login")
    @Expose
    private Login login;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
