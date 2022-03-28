import java.util.ArrayList;
import java.util.Scanner;

public class Television extends ServiceCommunicator {
    private ServiceCommunicator sc;

    Television(String show) {
        setURL("http://api.tvmaze.com/singlesearch/shows?q=" + show);
        hyphenate();
        connect();
    }

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        ArrayList<String> shows = new ArrayList<>();

        while (true) {
            System.out.println("Enter the name of the TV show");
            System.out.println("Or type 'q' to quit");
            String ans = input.nextLine();
            if (!ans.equals("q")) {
                shows.add(ans);
            } else { break; }
        }

        for (String str : shows) {
            Television tv = new Television(str);
            System.out.println(tv.get());
        }

    }

}
