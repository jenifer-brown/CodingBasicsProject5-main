import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        Scanner input;
        ServiceCommunicator sc = new ServiceCommunicator();
        ArrayList<String> COMMANDS = new ArrayList<>();
        COMMANDS.add("zipcode");
        COMMANDS.add("tv show");
        COMMANDS.add("song");

            while (true) {
                System.out.println("Please enter one of the following commands: ");
                System.out.println(COMMANDS.toString());
                System.out.print("Command> ");
                input = new Scanner(System.in);
                String cmd = input.next().toLowerCase();

                while (!COMMANDS.contains(cmd)) {
                    System.out.println("Please enter a valid command");
                    System.out.println(COMMANDS.toString());
                    System.out.print("Command> ");
                    cmd = input.next().toLowerCase();
                }

                System.out.print("Which " + cmd + " do you need information about?: ");
                Scanner input2 = new Scanner(System.in);
                String request = input2.nextLine();

                System.out.println("Command [" + cmd + "] " + "Info [" + request + "]");

                switch (cmd) {
                    case "zipcode": sc = new ZipCode(request);
                    break;
                    case "tv show": sc = new Television(request);
                    break;
                    case "song": sc = new Music(request);
                    break;

                }

                System.out.println("Here is your information: ");
                System.out.println(sc.get());

                System.out.println("Would you like to find more information? y/n");
                String ans = input.next();
                if (ans.equals("n")) {
                    System.out.println("Thank you for using MyApp. Goodbye!");
                    break;
                }
            }
    }
}
