import com.sun.xml.internal.ws.util.StringUtils;

public abstract  class DigitalContent implements Comparable<DigitalContent> {
    private String title;
    private String publisher;
    private String release;


    /**
     * return true if the input
     * query is contained in the title or publisher or release date
     * @param query
     * @return
     */
    public boolean match(String query){
        String s = query.toLowerCase();
        return title.toLowerCase().contains(s)||publisher.toLowerCase().contains(s)||release.toLowerCase().contains(s);

    }

    /**
     *  return a string describing the digital
     * content
     * @return
     */
    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", release date='" + release + '\'';

    }

    /**
     * Compare the title so that it can be sorted by title when it is sorted by Collection.sort()
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(DigitalContent o) {
        return title.compareTo(o.title);
    }

    /**
     * Constructor of DigitalContent
     * @param title
     * @param publisher
     * @param release
     */
    public DigitalContent(String title, String publisher, String release) {
        this.title = title;
        this.publisher = publisher;
        this.release = release;
    }

    /**
     * get title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * set title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * get publisher
     * @return
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * set publisher
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * get release date
     * @return
     */
    public String getRelease() {
        return release;
    }

    /**
     * set release date
     * @param release
     */
    public void setRelease(String release) {
        this.release = release;
    }
}
