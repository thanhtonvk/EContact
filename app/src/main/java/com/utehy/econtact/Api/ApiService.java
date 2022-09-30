package com.utehy.econtact.Api;

import static com.utehy.econtact.Tools.Common.BASE_URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utehy.econtact.Models.ResponseDiem;
import com.utehy.econtact.Tools.Common;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
    OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer " + Common.TOKEN).build();
            return chain.proceed(request);
        }
    }).build();
    ApiService api = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build().create(ApiService.class);

    @FormUrlEncoded
    @POST("token")
    Call<Map<String, Object>> login(@FieldMap Map<String, String> body);


    @POST("adapter/execute")
    Call<Map<String, Object>> executeAdapter(@Body RequestBody params);


    @POST("adapter/execute")
    Call<ResponseDiem> executeAdapter2(@Body String params);

}
