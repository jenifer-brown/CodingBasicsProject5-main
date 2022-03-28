import java.util.Scanner;
import java.util.ArrayList;

public class ZipCode extends ServiceCommunicator {


    ZipCode(String zipcode) {
        setURL("http://api.zippopotam.us/us/" + zipcode);
        connect();
    }


}
