package com.example.utsav.pagination;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiConfig {
    @GET("ProductList")
    Call<ProductList> getHomePageData(
            @Header("Authorization") String authkey
            , @Query("typeId") int id,@Query("nextPage") int nextPage,@Query("language") String language
    );
}
