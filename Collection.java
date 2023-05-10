import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Collection implements Comparable<Collection> {
    private String title;
    private List<Content> contents;

    public Collection(String title) {
        this.title = title;
        this.contents = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void shuffle() {
        Collections.shuffle(contents);
        for (Content content : contents) {
            content.play();
        }
    }

    @Override
    public int compareTo(Collection other) {
        return Integer.compare(this.contents.size(), other.contents.size());
    }
}
