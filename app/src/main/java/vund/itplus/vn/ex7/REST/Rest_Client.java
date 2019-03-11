package vund.itplus.vn.ex7.REST;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Rest_Client {
    private static final String BASE_API = "https://api.discogs.com/";
    private static Retrofit retrofit;

    public static APIs getApIs() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_API)
                    .addConverterFactory(GsonConverterFactory
                            .create())
                    .build();

        }
        return retrofit.create(APIs.class);
    }
}
