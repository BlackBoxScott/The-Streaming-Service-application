public class Music extends DigitalContent {

    private String artistName;

    /**
     * Music constructor
     * @param title
     * @param publisher
     * @param release
     * @param artistName
     */
    public Music(String title, String publisher, String release,String artistName) {
        super(title, publisher, release);
        this.artistName=artistName;
    }

    /**
     * get the artist's name of the music
     * @return
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * set artist's name
     * @param artistName
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    /**
     * return true if the input
     * query is contained in the title or publisher or release date or artist's name
     * @param query
     * @return
     */
    @Override
    public boolean match(String query) {
        return super.match(query)||artistName.toLowerCase().contains(query.toLowerCase());
    }


    /**
     * supplement to the supers' to string result by adding artistName
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "artistName='" + artistName + '\'' ;
    }
}
