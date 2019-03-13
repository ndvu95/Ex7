package vund.itplus.vn.ex7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vund.itplus.vn.ex7.Adapter.Recycler_Adapter_Song;
import vund.itplus.vn.ex7.Model.Artist;
import vund.itplus.vn.ex7.Model.Song;
import vund.itplus.vn.ex7.REST.Rest_Client;

public class ListSongActivity extends AppCompatActivity {
    Artist artist;
    Bundle bundle;
    private static String releases = "releases";
    private String id;

    private TextView tvArtist;
    private RecyclerView mRecycler;
    private ArrayList<Song> songArrayList;
    private Recycler_Adapter_Song adapter_song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_song);
        bundle = getIntent().getExtras();
        id = getIntent().getStringExtra("ID");

        artist = (Artist) getIntent().getSerializableExtra("ArtistObject");


        initUI();
        tvArtist.setText(artist.getArtistName());
        getData();


    }

    private void initUI() {
        tvArtist = (TextView) findViewById(R.id.tvAlbum);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerSong);
    }

    private void getData() {

        songArrayList = new ArrayList<>();
        Call<JsonElement> call = Rest_Client.getApIs().getArtist(id, releases);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                JsonElement jsonElement = response.body();

                JsonObject jsonRoot = jsonElement.getAsJsonObject();

                JsonArray release = jsonRoot.getAsJsonArray("releases");
                for (int i = 0; i < release.size(); i++) {

                    JsonObject songObject = (JsonObject) release.get(i);
                    String title = songObject.get("title").getAsString();
                    songArrayList.add(new Song(artist, "", title));

                }

                adapter_song = new Recycler_Adapter_Song(getApplicationContext(), songArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                mRecycler.setLayoutManager(linearLayoutManager);
                mRecycler.setAdapter(adapter_song);
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {

            }
        });
    }

    public void clickBack(View view) {
        finish();
    }
}
