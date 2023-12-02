package com.example.yatra.retrofit;

public class ApiUtil {

   // public static  String baseUrl = "http://bikerental.oxfordcollege.edu.np/api/";
    public static  String baseUrl = "http://192.168.1.66:8000/api/";

    public static ApiService getApiService(){
        return RetrofitClient.getRetrofitClient(baseUrl).create(ApiService.class);
    }
}
