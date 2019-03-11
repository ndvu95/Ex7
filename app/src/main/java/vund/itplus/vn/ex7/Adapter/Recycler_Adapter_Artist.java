package vund.itplus.vn.ex7.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vund.itplus.vn.ex7.ListSongActivity;
import vund.itplus.vn.ex7.Model.Artist;
import vund.itplus.vn.ex7.R;

public class Recycler_Adapter_Artist extends RecyclerView.Adapter<Recycler_Adapter_Artist.ViewHolder> {
    private Context mContext;
    private List<Artist> listArtist = new ArrayList<>();

    public Recycler_Adapter_Artist(Context mContext, List<Artist> listArtist) {
        this.mContext = mContext;
        this.listArtist = listArtist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recycler_single_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final String artistName = listArtist.get(i).getArtistName();
        final String albumName= listArtist.get(i).getAlbumName();
        final String id = listArtist.get(i).getID();
        viewHolder.tvArtistName.setText(artistName);
        viewHolder.tvAlbumName.setText(albumName);
        viewHolder.imgAnh.setImageResource(listArtist.get(i).getmThumb());
        viewHolder.btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Album: "+albumName + " - Ca sỹ: "+ artistName, Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityListSong = new Intent(mContext, ListSongActivity.class);

                Artist artist = new Artist(id, listArtist.get(i).getmThumb(), artistName, albumName);
                activityListSong.putExtra("ArtistObject", artist);
                activityListSong.putExtra("ID", id);
                activityListSong.putExtra("Artist",artistName);
                mContext.startActivity(activityListSong);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listArtist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgAnh;
        TextView tvArtistName;
        TextView tvAlbumName;
        ImageButton btnMenu;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAnh = itemView.findViewById(R.id.imgThumb);
            tvArtistName = itemView.findViewById(R.id.tvArtist);
            tvAlbumName = itemView.findViewById(R.id.tvSongName);
            btnMenu = itemView.findViewById(R.id.btnMenu);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
