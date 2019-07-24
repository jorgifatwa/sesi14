package com.kursusgitar.Model.Parsing;

import com.google.gson.annotations.SerializedName;
import com.kursusgitar.Model.Gitaris;

import java.util.List;

public class getAllGitaris {

    @SerializedName("status")
    private Integer status;
    @SerializedName("message")
    private String message;
    @SerializedName("gitaris")
    private List<Gitaris> gitaris;

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

    public List<Gitaris> getGitaris() {
        return gitaris;
    }

    public void setGitaris(List<Gitaris> gitaris) {
        this.gitaris = gitaris;
    }
}
