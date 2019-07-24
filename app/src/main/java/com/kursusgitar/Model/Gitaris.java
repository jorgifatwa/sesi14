package com.kursusgitar.Model;

import com.google.gson.annotations.SerializedName;

public class Gitaris {

    @SerializedName("id_gitaris")
    private Integer id_gitaris;
    @SerializedName("nama_gitaris")
    private String nama_gitaris;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("umur")
    private String umur;
    @SerializedName("tingkat")
    private String tingkat;

    public Integer getId_gitaris() {
        return id_gitaris;
    }

    public void setId_gitaris(Integer id_gitaris) {
        this.id_gitaris = id_gitaris;
    }

    public String getNama_gitaris() {
        return nama_gitaris;
    }

    public void setNama_gitaris(String nama_gitaris) {
        this.nama_gitaris = nama_gitaris;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }



    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getTingkat() {
        return tingkat;
    }

    public void setTingkat(String tingkat) {
        this.tingkat = tingkat;
    }
}
