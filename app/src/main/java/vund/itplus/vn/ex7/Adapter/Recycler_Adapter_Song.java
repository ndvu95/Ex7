package vund.itplus.vn.ex7.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vund.itplus.vn.ex7.Model.Song;
import vund.itplus.vn.ex7.R;

public class Recycler_Adapter_Song extends RecyclerView.Adapter<Recycler_Adapter_Song.ViewHolder> {
    private Context context;
    private List<Song> songList;

    public Recycler_Adapter_Song(Context context, List<Song> songList) {
        this.context = context;
        this.songList = songList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recycler_list_song_single_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String songName = songList.get(i).getSongName();
        String artistName = songList.get(i).getArtist().getArtistName();

        viewHolder.tvArtistName.setText(artistName);
        viewHolder.tvSongName.setText(songName);
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvSongName;
        TextView tvArtistName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvSongName = itemView.findViewById(R.id.tvSongName);
            tvArtistName = itemView.findViewById(R.id.tvArtistName);

        }
    }
}
