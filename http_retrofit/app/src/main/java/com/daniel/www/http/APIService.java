package com.daniel.www.http;

import com.daniel.www.entity.LoginResponse;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by Daniel on 2017/1/3.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("user/login")
    Call<LoginResponse> postLogin(@Header("Token") String token,
                                  @FieldMap Map<String, String> map);


    @FormUrlEncoded
    @Headers("Token token")
    @POST("user/login")
    Call<LoginResponse> postLogind(@FieldMap Map<String, String> map);

    /**
     * 用戶信息
     *
     * @param lanCode
     * @param userid
     * @return
     */
    @GET("user/{id}/info")
    Call<LoginResponse> getUserInfo(@Header("Accept-Language") String lanCode,
                                    @Header("Authorization") String authorization,
                                    @Path("id") String userid,
                                    @QueryMap Map<String, String> params);

    /**
     * 修改name
     *
     * @param lanCode
     * @param authorization
     * @param id
     * @return
     */
    @PUT("user/{id}")
    Call<LoginResponse> putUpdateName(@Header("Accept-Language") String lanCode,
                                      @Header("Authorization") String authorization,
                                      @Path("id") String id,
                                      @Body RequestBody requestBody);
}
