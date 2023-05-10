import java.util.ArrayList;
import java.util.List;

public class Listener {
    private String name;
    private List<Content> favoriteContents;

    public Listener(String name) {
        this.name = name;
        this.favoriteContents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void favorite(Content content) {
        favoriteContents.add(content);
    }

    public List<Content> getFavoriteContents() {
        return favoriteContents;
    }
}
