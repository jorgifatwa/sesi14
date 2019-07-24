package com.kursusgitar.REST;

import com.kursusgitar.Model.CRUDMessage;
import com.kursusgitar.Model.Parsing.getAllGitaris;
import com.kursusgitar.Model.Parsing.getGitaris;
import com.kursusgitar.Model.Parsing.getLogin;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface RetrofitInterface {
    @GET("_getLogin.php")
    Call<getLogin> getLogin(
            @QueryMap Map<String, String> params
    );

    @GET("_getAllGitaris.php")
    Call<getAllGitaris> getAllGitaris();

    @FormUrlEncoded
    @POST("_getGitaris.php")
    Call<getGitaris> getGitaris (
            @Field("id_gitaris") String idGitaris
    );

    @FormUrlEncoded
    @POST("_insertGitaris.php")
    Call<CRUDMessage> insertGitaris (
            @Field("nama_gitaris") String namaGitaris,
            @Field("alamat") String alamat,
            @Field("umur") String umur,
            @Field("tingkat") String tingkat
    );

    @FormUrlEncoded
    @POST("_updateGitaris.php")
    Call<CRUDMessage> editGitaris (
            @Field("id_gitaris") String idGitaris,
            @Field("nama_gitaris") String namaGitaris,
            @Field("alamat") String alamat,
            @Field("umur") String umur,
            @Field("tingkat") String tingkat
    );

    @FormUrlEncoded
    @POST("_deleteGitaris.php")
    Call<CRUDMessage> deleteGitaris (
            @Field("id_gitaris") String idGitaris
    );
}
