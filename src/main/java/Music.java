import java.util.ArrayList;
import java.util.Scanner;

public class Music extends ServiceCommunicator {

    Music(String song) {
        setURL("https://itunes.apple.com/search?term=" + song + "&limit=1");
        hyphenate();
        connect();
    }

}
