package com.tr2016.hederkosher;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by dnzl on 14.01.17.
 */

public interface ApiInterface {
    @GET("/address")
    Observable<List<Address>> getAllAddresses();

    @POST("/address")
    Observable<Address> createAddress(@Body Address address);


    @GET("/group/{id}/Addresss")
    Observable<List<Address>> groupList(@Path("id") int groupId, @Query("sort") String sort);

}
