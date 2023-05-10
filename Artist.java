import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String artistName;
    private boolean isArtist;
    private List<Song> songs;
    private List<Album> albums;

    public Artist(String artistName) {
        this.artistName = artistName;
        this.songs = new ArrayList<>();
        this.albums = new ArrayList<>();
        setIsArtist(true);
    }

    public String getArtistName() {
      return artistName;
    }
    public boolean getIsArtist() {
        return isArtist;
    }

    public void setIsArtist(boolean isArtist) {
        this.isArtist = isArtist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public void removeAlbum(Album album) {
        albums.remove(album);
    }
}

