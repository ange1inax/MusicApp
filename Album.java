public class Album extends Collection {
    public Album(String title) {
        super(title);
    }

    public void addContent(Content content) {
        if (content instanceof Song) {
            getContents().add(content);
        }
    }

    public void listen() {
        for (Content content : getContents()) {
            content.play();
        }
    }
}
