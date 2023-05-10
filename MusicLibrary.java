import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MusicLibrary {
    private List<Listener> listeners;
    private List<Artist> artists;
    private List<Song> songs;
    private List<Podcast> podcasts;
    private List<Playlist> playlists;
    private List<Album> albums;

    public MusicLibrary() {
        this.listeners = new ArrayList<>();
        this.artists = new ArrayList<>();
        this.songs = new ArrayList<>();
        this.podcasts = new ArrayList<>();
        this.playlists = new ArrayList<>();
        this.albums = new ArrayList<>();

        // populate with default content
        Song song1 = new Song("Song 1", "Artist 1");
        Song song2 = new Song("Song 2", "Artist 2");
        Song song3 = new Song("Song 3", "Artist 3");
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);

        Podcast podcast1 = new Podcast("Podcast 1", "Podcaster 1", 1);
        Podcast podcast2 = new Podcast("Podcast 2", "Podcaster 2", 1);
        Podcast podcast3 = new Podcast("Podcast 3", "Podcaster 3", 1);
        podcasts.add(podcast1);
        podcasts.add(podcast2);
        podcasts.add(podcast3);

        Playlist playlist1 = new Playlist("Playlist 1");
        playlist1.addContent(song1);
        playlist1.addContent(song2);
        playlist1.addContent(podcast1);
        playlists.add(playlist1);

        Album album1 = new Album("Album 1");
        album1.addContent(song1);
        album1.addContent(song2);
        album1.addContent(song3);
        albums.add(album1);
    }

    public void createListener(String name) {
        listeners.add(new Listener(name));
    }

    public Listener getListenerByName(String name) {
        for (Listener listener : listeners) {
            if (listener.getName().equals(name)) {
                return listener;
            }
        }
        return null;
    }

    public void createArtist(String artistName) {
      artists.add(new Artist(artistName));
    }
    public Artist getArtistByName(String artistName){
      for (Artist artist : artists) {
        if (artist.getArtistName().equals(artistName)) {
          return artist;
        }
      }
      return null;
    }
    public void listAllCollections() {
        System.out.println("Playlists:");
        for (Playlist playlist : playlists) {
            System.out.println(playlist.getTitle());
            for (Content content : playlist.getContents()) {
                System.out.println("\\t" + content.getTitle() + " by " + content.getArtist());
            }
        }

        System.out.println("Albums:");
        for (Album album : albums) {
            System.out.println(album.getTitle());
            for (Content content : album.getContents()) {
                System.out.println("\\t" + content.getTitle() + " by " + content.getArtist());
            }
        }
    }

    public void addSongToPlaylist(String playlistTitle, Song song) {
        Playlist playlist = (Playlist) getCollectionByTitle(playlistTitle);
        if (playlist == null) {
            System.out.println("Playlist not found.");
            return;
        }
        playlist.addContent(song);
    }

    public Collection getCollectionByTitle(String title) {
        for (Playlist playlist : playlists) {
            if (playlist.getTitle().equals(title)) {
                return playlist;
            }
        }
        for (Album album : albums) {
            if (album.getTitle().equals(title)) {
                return album;
            }
        }
        return null;
    }

    public void exportFavoritesToFile(Listener listener, String filePath) {
        List<Content> favoriteContents = listener.getFavoriteContents();
        Collections.sort(favoriteContents);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Content content : favoriteContents) {
                writer.write(content.getTitle() + " by " + content.getArtist() + " - " + content.getTimesStreamed() + " streams");
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error exporting favorites to file.");
        }
    }
}
