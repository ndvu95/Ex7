package vund.itplus.vn.ex7.Model;

import java.io.Serializable;

public class Artist implements Serializable {
    private String ID;
    private int mThumb;
    private String artistName;
    private String albumName;

    public Artist(String ID, int mThumb, String artistName, String albumName) {
        this.ID = ID;
        this.mThumb = mThumb;
        this.artistName = artistName;
        this.albumName = albumName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getmThumb() {
        return mThumb;
    }

    public void setmThumb(int mThumb) {
        this.mThumb = mThumb;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
