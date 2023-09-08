import java.util.ArrayList;
import java.util.Scanner;

public class Client implements Play {
    private StreamingService streamingService;
    private DigitalContent currentStream;

    public Client(StreamingService streamingService) {
        this.streamingService = streamingService;
        currentStream = null;
    }


    /**
     * will return the currentlyStreamed
     * instanceVariable, which is initially set to null.
     * @return
     */
    @Override
    public DigitalContent getCurrentStream() {
        return currentStream;
    }

    /**
     * will set currentlyStreamed to the first DigitalContent
     * object returned from the matching input query in StreamingService. If there are no
     * matches, then currentlyStreamed is left unmodified
     * @param query
     */
    @Override
    public void stream(String query) {
        ArrayList<DigitalContent> match = streamingService.match(query);
        if (!match.isEmpty()) {
            currentStream = match.get(0);
        }
    }

    /**
     *  will set currentlyStreamed to null
     */
    @Override
    public void stop() {
        currentStream = null;
    }

    public static void main(String[] args) {
        StreamingService streamingService = new StreamingService();
        streamingService.add(new Film("Avengers: Endgame", "Marvel Studios", "April 26, 2019", "Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth, Scarlett Johansson, Jeremy Renner, Don Cheadle, Paul Rudd, Brie Larson, Karen Gillan"));
        streamingService.add(new Film("Titanic", "Paramount Pictures", "December 19, 1997", "Leonardo DiCaprio, Kate Winslet, Billy Zane, Kathy Bates, Frances Fisher, Bernard Hill"));
        streamingService.add(new Film("The Lord of the Rings: The Return of the King", "New Line Cinema", "December 17, 2003", "Elijah Wood, Viggo Mortensen, Ian McKellen, Liv Tyler, Orlando Bloom, Sean Astin, Cate Blanchett, Andy Serkis"));
        streamingService.add(new Film("Avatar", "20th Century Fox", "December 18, 2009", "Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang, Michelle Rodriguez"));
        streamingService.add(new Film("The Dark Knight", "Warner Bros. Pictures", "July 18, 2008", "Christian Bale, Heath Ledger, Michael Caine, Gary Oldman, Aaron Eckhart, Maggie Gyllenhaal"));
        streamingService.add(new Film("Jurassic Park", "Universal Pictures", "June 11, 1993", "Sam Neill, Laura Dern, Jeff Goldblum, Richard Attenborough, Samuel L. Jackson"));
        streamingService.add(new Film("Harry Potter and the Philosopher's Stone", "Warner Bros. Pictures", "November 16, 2001", "Daniel Radcliffe, Rupert Grint, Emma Watson, Robbie Coltrane, Richard Harris, Maggie Smith, Alan Rickman"));
        streamingService.add(new Film("The Shawshank Redemption", "Castle Rock Entertainment", "September 23, 1994", "Tim Robbins, Morgan Freeman, Bob Gunton, William Sadler"));
        streamingService.add(new Film("Inception", "Warner Bros. Pictures", "July 16, 2010", "Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page, Tom Hardy, Ken Watanabe"));
        streamingService.add(new Film("Forrest Gump", "Paramount Pictures", "July 6, 1994", "Tom Hanks, Robin Wright, Gary Sinise, Sally Field, Mykelti Williamson"));
        streamingService.add(new Music("Shape of You", "Asylum Records", "January 6, 2017", "Ed Sheeran"));
        streamingService.add(new Music("Bohemian Rhapsody", "EMI", "October 31, 1975", "Queen"));
        streamingService.add(new Music("Rolling in the Deep", "XL Recordings", "November 29, 2010", "Adele"));
        streamingService.add(new Music("Billie Jean", "Epic Records", "January 2, 1983", "Michael Jackson"));
        streamingService.add(new Music("Hey Jude", "Apple Records", "August 26, 1968", "The Beatles"));
        streamingService.add(new Music("Hotel California", "Asylum Records", "December 8, 1976", "Eagles"));
        streamingService.add(new Music("Thriller", "Epic Records", "November 30, 1982", "Michael Jackson"));
        streamingService.add(new Music("Imagine", "Apple Records", "October 11, 1971", "John Lennon"));
        streamingService.add(new Music("Uptown Funk", "RCA Records", "November 10, 2014", "Mark Ronson ft. Bruno Mars"));
        streamingService.add(new Music("Smells Like Teen Spirit", "DGC Records", "September 10, 1991", "Nirvana"));
        printMenuInterface();
        Client client = new Client(streamingService);
        Scanner sc=new Scanner(System.in);
        String input = sc.next();
        outer: while (true){
            switch (input){
                case "A":
                    System.out.println(client.streamingService.toString());
                    break;
                case "B":
                    DigitalContent digitalContent = client.getCurrentStream();
                    if (digitalContent ==null){
                        System.out.println("No digital content is streamed");
                    }else {
                        System.out.println(digitalContent);
                    }
                    break;
                case "C":
                    System.out.println("Please input a query string");
                    String s = sc.next();
                    while (true){

                        if (s==null||s.equals("")){
                            System.out.println("Please input a query string");
                            s = sc.next();
                            continue;
                        }
                        break;
                    }
                    client.stream(s);
                    digitalContent = client.getCurrentStream();
                    if (digitalContent ==null){
                        System.out.println("No digital content is matched");
                    }else {
                        System.out.println(digitalContent);
                    }
                    break ;
                case "D":
                    client.stop();
                    System.out.println("Stop playing");
                    break ;
                case "E":
                    break outer;
            }
            printMenuInterface();
            input = sc.next();
        }
    }


    // print menu interface to interact with user
    public static void printMenuInterface(){
        System.out.println("Please enter an option");
        System.out.println("A. Display Digital Content library\n" +
                "B. Display currently streaming DigitalContent\n" +
                "C. Match Digital Content to Stream\n" +
                "D. Stop streaming\n" +
                "E. Quit Client Application");

    }


}
