import java.util.Scanner;

public class Driver {
    private MusicLibrary musicLibrary;
    private Scanner scanner;

    public Driver() {
        this.musicLibrary = new MusicLibrary();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();
            executeChoice(choice);
        } while (choice != 7);
    }

    private void printMenu() {
        System.out.println("Welcome to AngJonIfy Music Streaming App.");
        System.out.println("Select an option:");
        System.out.println("1. Create a Listener account");
        System.out.println("2. List all Playlists and Albums and their contents");
        System.out.println("3. Add songs to an existing Playlist");
        System.out.println("4. Shuffle an existing Playlist or listen to an Album");
        System.out.println("5. Add a song or podcast to favorites");
        System.out.println("6. Export all of a listener’s favorites out to a file in ascending order by times streamed");
        System.out.println("7. Create an Artist account");
        System.out.println("8. Exit");
    }

    private void executeChoice(int choice) {
        switch (choice) {
            case 1:
                createListenerAccount();
                break;
            case 2:
                listAllCollections();
                break;
            case 3:
                addSongsToPlaylist();
                break;
            case 4:
                shufflePlaylistOrListenToAlbum();
                break;
            case 5:
                addContentToFavorites();
                break;
            case 6:
                exportFavoritesToFile();
                break;
            case 7:
                createArtistAccount();
                break;
            case 8:
                System.out.println("Exiting program...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private void createListenerAccount() {
        System.out.println("Enter listener name or ID:");
        String listenerName = scanner.next();
        musicLibrary.createListener(listenerName);
        System.out.println("Listener account created successfully!");
    }

    private void createArtistAccount() {
      System.out.println("Enter artist name or ID:");
      String artistName = scanner.next();
      musicLibrary.createArtist(artistName);
      System.out.println("Artist account created successfully!");
    }

    private void listAllCollections() {
        musicLibrary.listAllCollections();
    }

    private void addSongsToPlaylist() {
        System.out.println("Enter playlist title:");
        String playlistTitle = scanner.next();
        System.out.println("Enter song title:");
        String songTitle = scanner.next();
        System.out.println("Enter artist name:");
        String artistName = scanner.next();
        musicLibrary.addSongToPlaylist(playlistTitle, new Song(songTitle, artistName));
        System.out.println("Song added to playlist successfully!");
    }

    private void shufflePlaylistOrListenToAlbum() {
        System.out.println("Enter playlist/album title:");
        String collectionTitle = scanner.next();
        Collection collection = musicLibrary.getCollectionByTitle(collectionTitle);
        if (collection == null) {
            System.out.println("Collection not found.");
            return;
        }
        if (collection instanceof Playlist) {
            ((Playlist) collection).shuffle();
        } else if (collection instanceof Album) {
            ((Album) collection).listen();
        }
    }

    private void addContentToFavorites() {
        System.out.println("Enter listener name or ID:");
        String listenerName = scanner.next();
        Listener listener = musicLibrary.getListenerByName(listenerName);
        if (listener == null) {
            System.out.println("Listener not found.");
            return;
        }
        System.out.println("Enter content type (song/podcast):");
        String contentType = scanner.next();
        System.out.println("Enter content title:");
        String contentTitle = scanner.next();
        System.out.println("Enter artist name:");
        String artistName = scanner.next();
        Content content;
        if (contentType.equals("song")) {
            content = new Song(contentTitle, artistName);
        } else if (contentType.equals("podcast")) {
            System.out.println("Enter episode number:");
            int episodeNumber = scanner.nextInt();
            content = new Podcast(contentTitle, artistName, episodeNumber);
        } else {
            System.out.println("Invalid content type.");
            return;
        }
        listener.favorite(content);
        System.out.println(contentType + " favorited successfully!");
    }

    private void exportFavoritesToFile() {
        System.out.println("Enter listener name or ID:");
        String listenerName = scanner.next();
        Listener listener = musicLibrary.getListenerByName(listenerName);
        if (listener == null) {
            System.out.println("Listener not found.");
            return;
        }
        System.out.println("Enter file path:");
        String filePath = scanner.next();
        musicLibrary.exportFavoritesToFile(listener, filePath);
        System.out.println("Favorites exported successfully!");
    }
}
