package vund.itplus.vn.ex7.Model;

public class Song {
    Artist artist;
    private String songThumb;
    private String songName;

    public Song(Artist artist, String songThumb, String songName) {
        this.artist = artist;
        this.songThumb = songThumb;
        this.songName = songName;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getSongThumb() {
        return songThumb;
    }

    public void setSongThumb(String songThumb) {
        this.songThumb = songThumb;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}
