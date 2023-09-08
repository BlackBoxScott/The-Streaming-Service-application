public class Film extends DigitalContent{

    private String castMembers;

    /**
     * Film constructor
     * @param title
     * @param publisher
     * @param release
     * @param castMembers
     */
    public Film(String title, String publisher, String release,String castMembers) {
        super(title, publisher, release);
        this.castMembers=castMembers;
    }

    /**
     * get cast members of the film
     * @return
     */
    public String getCastMembers() {
        return castMembers;
    }

    /**
     * set cast members of the film
     * @param castMembers
     */
    public void setCastMembers(String castMembers) {
        this.castMembers = castMembers;
    }

    /**
     * supplement to the supers' to string result by adding caseMember
     * @return
     */
    @Override
    public String toString() {
        return super.toString()+ ", cast members='" + castMembers + '\'';
    }

    /**
     * return true if the input
     * query is contained in the title or publisher or release date or cast members
     * @param query
     * @return
     */
    @Override
    public boolean match(String query) {
        return super.match(query)||castMembers.toLowerCase().contains(query.toLowerCase());
    }
}
