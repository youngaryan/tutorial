import java.time.LocalTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();

        System.out.println(localTime);
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());

        Date date = new Date();

        System.out.println(date);

    }
}
