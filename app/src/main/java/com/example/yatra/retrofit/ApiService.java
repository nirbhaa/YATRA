package com.example.yatra.retrofit;

import com.example.yatra.JSONSchemas.BikesRespose;
import com.example.yatra.JSONSchemas.BookingDelete;
import com.example.yatra.JSONSchemas.BookingModel;
import com.example.yatra.JSONSchemas.BookingUpdate.BookingUpdate;
import com.example.yatra.JSONSchemas.CategoryBikes.CategoryModel;
import com.example.yatra.JSONSchemas.Contact;
import com.example.yatra.JSONSchemas.FavoriteBike;
import com.example.yatra.JSONSchemas.FavouriteDelete;
import com.example.yatra.JSONSchemas.ForgetEmail;
import com.example.yatra.JSONSchemas.Offer.OfferModel;
import com.example.yatra.JSONSchemas.Otpverify;
import com.example.yatra.JSONSchemas.RecommdedBike.RecoomendedModel;
import com.example.yatra.JSONSchemas.ResendApi;
import com.example.yatra.JSONSchemas.Resetpassword;
import com.example.yatra.JSONSchemas.SliderImage.AdapterSlider;
import com.example.yatra.JSONSchemas.UserBokingModel.UserBookingModel;
import com.example.yatra.JSONSchemas.UserDetails.UserLoginDetails;
import com.example.yatra.JSONSchemas.UserRegister;
import com.example.yatra.JSONSchemas.favoriteBikeByUser.favoriteBikeByUser;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {


    @POST("register")
    Call<UserRegister> userRegister(
            @Query("fullname") String fullname,
            @Query("email") String email,
            @Query("password") String password,
            @Query("confirmation_password") String confirmation_password,
            @Query("address") String address,
            @Query("phone_number") String phone_number
    );

    @POST("login")
    Call<UserLoginDetails> userLogin(
            @Query(("email")) String email,
            @Query(("password")) String password

    );


    @POST("verify")
    Call<Otpverify> otpVerify(
            @Query("email") String email,
            @Query(("otp")) String otp
    );

    @POST("contact")
    Call<Contact> contact(
            @Query("full_name") String full_name,
            @Query("phone_number") String phone_number,
            @Query("email") String email,
            @Query("message") String message

    );


    @FormUrlEncoded
    @POST("bookings")
    Call<BookingModel> getbookings(
            @Field("user_id") String user_id,
            @Field("bike_id") String bike_id,
            @Field("booking_start_time") String booking_start_time,
            @Field("booking_end_time") String booking_end_time,
            @Field("total_cost") Double total_cost,
            @Field("booking_status") String progress,
            @Field("no_of_days") Integer no_of_days
    );


    @FormUrlEncoded
    @POST("bookings/{id}")
    Call<BookingUpdate>getUpdateBooking(
            @Path("id")String id,
            @Field("user_id") String user_id,
            @Field("bike_id") String bikeid,
            @Field("booking_start_time") String booking_start_time,
            @Field("booking_end_time") String booking_end_time,
            @Field("total_cost") Double total_cost,
            @Field("no_of_days") Integer no_of_days


    );


    @POST("reset")
    Call<Resetpassword> resetPassword(
            @Query("email") String email,
            @Query(("new_password")) String new_password,
            @Query(("confirm_password")) String confirm_password
    );

    @POST("resend")
    Call<ResendApi> resendOtp(
            @Query("email") String email
    );

    @POST("forgot")
    Call<ForgetEmail> forgetEmail(
            @Query(("email")) String email

    );

    @GET("bikes")
    Call<BikesRespose> getPopularBikes();

    @GET("offers")
    Call<OfferModel> getOffer();

    //    @POST("resend")
//    Call<Resend>resend(
//            @Query("full_name") String full_name ,
//            @Query("phone_number") String phone_number ,
//            @Query("email") String email ,
//            @Query("message") String message
//
//    );
    @GET("sliders")
    Call<AdapterSlider> getSliderImage();



    @POST("favourites")
    Call<FavoriteBike> storefavouritebike(
            @Query("bike_id") String bike_id,
            @Query("user_id") String user_id
    );

    @GET("recommendedbikes")
    Call<RecoomendedModel> getRecommended();


    @GET("categorybike/{categoryId}")
    Call<CategoryModel> getCategory(
            @Path("categoryId") String id
    );
    @DELETE("bookings/{id}")
    Call<BookingDelete> getdelete(
            @Path("id") String id
    );

    @DELETE("favourites/{id}")
    Call<FavouriteDelete> getFavouriteDelete(
            @Path("id") String id
    );


//    @FormUrlEncoded
//    @PUT("user/detail/{id}")
//    Call<ResponseBody> editUserInfo(
//            @Path("id") String id,
//            @Field("username") String username,
//            @Field("phone") String phone,
//            @Field("addres") String addres,
//            @Field("gender") String gender
//
//    );


    @GET("userbooking")
    Call<UserBookingModel> getUserBooking(@Header("Authorization") String token);



    @GET("userfavorites")
    Call<favoriteBikeByUser> getfavoriteBikeByUser(@Header("Authorization") String token);



}
//    @GET("userbooking") getUserBooking(@Header("Authorization")token: String): Call<UserBookingModel>