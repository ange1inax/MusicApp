Full Name(s): Angelina ----, Jonathan -------
Student ID(s): 
Chapman Email(s): adieu@chapman.edu , vergonio@chapman.edu
Course number and section: CPSC-231-03
Assignment number: MP4 - Music App

# Music Streaming App

The Music Streaming App is a Java program that simulates a music library. Users can create and manage playlists and albums, add songs and podcasts to their favorites, and export their favorites to a file.

## Class Names:
- Album
- Artist
- Collection
- Content
- Driver
- Listener
- MusicLibrary
- Playlist
- Podcast
- Song

## Files

The program is organized into several files:

### MusicLibrary.java

- `createUser(String name, String type)`: Creates a new user with the specified name and type.
- `getUserByName(String name)`: Returns the user with the specified name.
- `addCollection(Collection collection)`: Adds a new collection to the music library.
- `getCollectionByTitle(String title)`: Returns the collection with the specified title.
- `listAllCollections()`: Lists all available collections.
- `addContentToFavorites(String listenerName, Content content)`: Adds a song or podcast to a listener's favorites.
- `exportFavoritesToFile(String listenerName, String fileName)`: Exports a listener's favorites to a file.

### Song.java

- `getTitle()`: Returns the song title.
- `getArtist()`: Returns the song artist.

### Podcast.java

- `getTitle()`: Returns the podcast title.
- `getArtist()`: Returns the podcast artist.
- `getEpisodeNumber()`: Returns the podcast episode number.

### Content.java

An abstract class that represents content (either a song or a podcast episode) and

### Collection.java

An abstract class that represents a collection of content (either a playlist or an album).

### Playlist.java

- `getSongs()`: Returns the list of songs in the playlist.
- `addSong(Song song)`: Adds a song to the playlist.
- `removeSong(Song song)`: Removes a song from the playlist.
- `shuffle()`: Shuffles the songs in the playlist.

### Album.java

- `getSongs()`: Returns the list of songs in the album.
- `addSong(Song song)`: Adds a song to the album.
- `removeSong(Song song)`: Removes a song from the album.
- `listen()`: Plays the album.

### User.java

An abstract class that represents a user of the music library.

### Listener.java

- `getFavorites()`: Returns the list of the listener's favorite songs and podcasts.
- `favorite(Content content)`: Adds a song or podcast to the listener's favorites.

### Artist.java

A class that represents an artist.

## Usage

To run the program, compile and run the `MusicLibrary.java` file. The program will prompt the user for input and display output accordingly.

### Commands

The following commands are available:

- **create user**: Creates a new user. The user can be either a listener or an artist.
- **add collection**: Adds a new collection to the music library. The collection can be either a playlist or an album.
- **list collections**: Lists all available collections.
- **favorite content**: Adds a song or podcast to a listener's favorites.
- **export favorites**: Exports a listener's favorites to a file.
- **quit**: Quits the program.

### Examples

To create a new user, enter the following command:

```
create user

```

The program will prompt the user for the user's name and type (either "listener" or "artist").

To add a new collection, enter the following command:

```
add collection

```

The program will prompt the user for the collection's type (either "playlist" or "album") and title.

To list all available collections, enter the following command:

```
list collections

```

The program will display a list of all available collections.

To favorite a song or podcast, enter the following command:

```
favorite content

```

The program will prompt the user for the listener's name, the content type (either "song" or "podcast"), the content title, and the artist name.

To export a listener's favorites to a file, enter the following command:

```
export favorites

```

The program will prompt the user for the listener's name and the file name.
