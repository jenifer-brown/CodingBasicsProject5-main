import java.util.Scanner;
import java.util.ArrayList;

public class ZipCode {

    private String zipcode;

    ZipCode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void getResults(ServiceCommunicator sc) {
        String res = sc.getResults("http://api.zippopotam.us/us/" + this.zipcode);
        if (res != null) {
            System.out.println(res);
        }
    }

    public static void main(String args[]) {
        ServiceCommunicator sc =  new ServiceCommunicator();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the 5 digit zipcodes separated by spaces");
        String codes = input.nextLine();
        ArrayList<String> zipcodes = new ArrayList<>();
        try (Scanner scan = new Scanner(codes)) {
            scan.useDelimiter(" ");
            while (scan.hasNext()) {
                String str = scan.next();
                if (str.matches("\\d{5}")) {
                    zipcodes.add(str);
                }
            }
        }

        for (String s : zipcodes) {
            ZipCode zippy = new ZipCode(s);
            zippy.getResults(sc);
        }

    }
}
