import javafx.application.Platform;

import java.util.ArrayList;
import java.util.Collections;

public class StreamingService {

    private ArrayList<DigitalContent> digitalContents;

    /**
     * a default constructor to initialise the
     * ArrayList.
     */
    public StreamingService() {
        this.digitalContents = new ArrayList<>();
    }

    /**
     * takes a DigitalContent object to add to the list
     * @param digitalContent
     */
    public void add(DigitalContent digitalContent){
        if (digitalContent==null) {
            throw  new NullPointerException("digitalContent");
        }

        this.digitalContents.add(digitalContent);
    }

    /**
     * method which invokes match on each DigitalContent object. If matching, it is added to an
     * ArrayList to be returned
     * @param query
     * @return
     */
    public ArrayList<DigitalContent> match(String query){
        ArrayList<DigitalContent> matchContents = new ArrayList<>();
        for (DigitalContent digitalContent : digitalContents) {
            if (digitalContent.match(query)){
                matchContents.add(digitalContent);
            }
        }
        return matchContents;
    }

    /**
     * returns a string of all DigitalContent stored by the StreamingService,
     * sorted by title
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<DigitalContent> result = new ArrayList<>(digitalContents);

        Collections.sort(result);
        for (DigitalContent digitalContent : result) {
            stringBuilder.append(digitalContent).append("\n");
        }
        return stringBuilder.toString();
    }
}
