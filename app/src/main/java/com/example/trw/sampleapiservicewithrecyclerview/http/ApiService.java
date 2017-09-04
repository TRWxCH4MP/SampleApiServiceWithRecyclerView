package com.example.trw.sampleapiservicewithrecyclerview.http;

import com.example.trw.sampleapiservicewithrecyclerview.repo.Collection;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by TRW on 25/8/2560.
 */

public interface ApiService {

    @GET("{blogId}/posts")
    Call<Collection> Repo(@Path("blogId") String blogId
                        , @Query("key") String Key
                        , @Query("maxResults") int maxResults
                        , @Query("fetchImages") boolean fetchImages);
}
