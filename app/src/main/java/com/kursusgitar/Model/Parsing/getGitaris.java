package com.kursusgitar.Model.Parsing;

import com.google.gson.annotations.SerializedName;
import com.kursusgitar.Model.Gitaris;

public class getGitaris {

    @SerializedName("status")
    private Integer status;
    @SerializedName("message")
    private String message;
    @SerializedName("gitaris")
    private Gitaris gitaris;


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

    public Gitaris getGitaris() {
        return gitaris;
    }

    public void setGitaris(Gitaris gitaris) {
        this.gitaris = gitaris;
    }
}
