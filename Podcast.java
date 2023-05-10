public class Podcast extends Content {
    private int episodeNumber;

    public Podcast(String title, String artist, int episodeNumber) {
        super(title, artist);
        this.episodeNumber = episodeNumber;
    }

    @Override
    public void play() {
        super.play();
        System.out.println("Episode: " + episodeNumber);
    }
}
