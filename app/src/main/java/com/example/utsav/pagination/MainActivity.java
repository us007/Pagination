package com.example.utsav.pagination;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Base64;
import android.util.Log;

import com.hendraanggrian.widget.PaginatedRecyclerView;

import java.io.UnsupportedEncodingException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private PaginatedRecyclerView paginatedRecyclerView;
    private int NEXT = 0;
    private List<ProductList.Data> dataList;
    private AdapterData adapterData;
    private int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paginatedRecyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        paginatedRecyclerView.setLayoutManager(gridLayoutManager);
        adapterData = new AdapterData(MainActivity.this);
        paginatedRecyclerView.setAdapter(adapterData);
        paginatedRecyclerView.setPagination(new Pagination());
        //  retrofit();
    }

/*
    private void setAdapter(List<ProductList.Data> dataList) {
        adapterData = new AdapterData(MainActivity.this, dataList);
        paginatedRecyclerView.setAdapter(adapterData);
        paginatedRecyclerView.setPagination(new Pagination());

    }
*/

    public void retrofit() {
        ApiConfig getResponse = AppConfig.ApiClient().create(ApiConfig.class);
        Call<ProductList> call = getResponse.getHomePageData(getAuthToken(), 2, NEXT, "en");
        call.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                ProductList productList = response.body();
                if (response.isSuccessful()) {
                    dataList = productList.getData();
                  //  setAdapter(dataList);
                }
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {

            }
        });

    }

    public class Pagination extends PaginatedRecyclerView.Pagination {

        @Override
        public int getPageStart() {
            return 0;
        }

        @Override
        public void onPaginate(int i) {
            ApiConfig getResponse = AppConfig.ApiClient().create(ApiConfig.class);
            Call<ProductList> call = getResponse.getHomePageData(getAuthToken(), 2, NEXT, "en");
            call.enqueue(new Callback<ProductList>() {
                @Override
                public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                    ProductList productList = response.body();
                    if (response.isSuccessful()) {
                        dataList = productList.getData();
                        page = productList.getNextPage();
                        adapterData.addAll(dataList);

                        if (page==-1){
                            notifyPaginationFinished();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ProductList> call, Throwable t) {

                }
            });

        }
    }

    public static String getAuthToken() {
        byte[] data = new byte[0];
        try {
            data = ("amit.bhavsar@tatvasoft.com" + ":" + "123456").getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }
}
