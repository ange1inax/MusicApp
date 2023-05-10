public class Playlist extends Collection {
    public Playlist(String title) {
        super(title);
    }

    public void addContent(Content content) {
        getContents().add(content);
    }

    public void removeContent(Content content) {
        getContents().remove(content);
    }
}
