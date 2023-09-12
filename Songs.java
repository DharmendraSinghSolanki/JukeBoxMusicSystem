package org.example;

public class Songs
{
    private int song_id;
    private String album_name;
    private String album_genre;
    private String album_artist;
    private String album_duration;
    private String album_path;

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getAlbum_genre() {
        return album_genre;
    }

    public void setAlbum_genre(String album_genre) {
        this.album_genre = album_genre;
    }

    public String getAlbum_artist() {
        return album_artist;
    }

    public void setAlbum_artist(String album_artist) {
        this.album_artist = album_artist;
    }

    public String getAlbum_duration() {
        return album_duration;
    }

    public void setAlbum_duration(String album_duration) {
        this.album_duration = album_duration;
    }

    public String getAlbum_path() {
        return album_path;
    }

    public void setAlbum_path(String album_path) {
        this.album_path = album_path;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "song_id=" + song_id +
                ", album_name='" + album_name + '\'' +
                ", album_genre='" + album_genre + '\'' +
                ", album_artist='" + album_artist + '\'' +
                ", album_duration='" + album_duration + '\'' +
                ", album_path='" + album_path + '\'' +
                '}';
    }
}
