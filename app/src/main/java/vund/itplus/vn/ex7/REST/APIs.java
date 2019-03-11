package vund.itplus.vn.ex7.REST;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIs {
    @GET("artists/{id}/releases")
    Call<JsonElement> getArtist(@Path("id") String ID
            , @Query("releases") String release);
}
