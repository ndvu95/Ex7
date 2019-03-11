package vund.itplus.vn.ex7;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.JsonElement;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vund.itplus.vn.ex7.Adapter.Recycler_Adapter_Artist;
import vund.itplus.vn.ex7.Model.Artist;
import vund.itplus.vn.ex7.REST.Rest_Client;

public class MainActivity extends AppCompatActivity  {
    private static String releases = "releases";
    ArrayList<Artist> artistList;
    Recycler_Adapter_Artist adapter;
    RecyclerView mRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler = (RecyclerView)findViewById(R.id.recyclerList);
        artistList =new ArrayList<>();

        artistList.add(new Artist("1124645", R.drawable.taylor, "Taylor Swift","Reputation"));
        artistList.add(new Artist("125992", R.drawable.avril, "Avril Lavigne","Let Go"));
        artistList.add(new Artist("819015", R.drawable.adele, "Adele","Cover Stories"));
        artistList.add(new Artist("1642600", R.drawable.selena, "Selena Gomez","For You"));
        artistList.add(new Artist("2710776", R.drawable.carly, "Carly Rae Jepsen","Emotion"));
        artistList.add(new Artist("201543", R.drawable.kelly, "Kelly Clarkson","Meaning Of Life"));

        adapter = new Recycler_Adapter_Artist(getApplicationContext(),artistList);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            mRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        }else{
            mRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
        }


        mRecycler.setAdapter(adapter);


        //getData();
    }

//    private void getData() {
//
//        Call<JsonElement> call = Rest_Client.getApIs().getArtist("1124645", releases);
//        call.enqueue(new Callback<JsonElement>() {
//            @Override
//            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
//                JsonElement jsonElement= response.body();
//
//
//                //JsonObject jsonRoot = jsonElement.getAsJsonObject();
//                if(jsonElement != null){
//                    Log.d("TAGGGGG", ""+ jsonElement.toString());
//                }else{
//                    Log.d("TAGGGGG", "null");
//                }
////
////                JsonArray release = jsonRoot.getAsJsonArray("releases");
////
////                JsonObject songObject = release.getAsJsonObject();
////                String status = songObject.get("status").toString();
////
////                Log.d("TAGGGG", ""+ status);
//            }
//
//            @Override
//            public void onFailure(Call<JsonElement> call, Throwable t) {
//
//            }
//        });
//    }
}
