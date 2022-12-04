import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static boolean ProgramFinish = false;
    private static final List<Integer> WIN_COUNT = new ArrayList(Arrays.asList(0,0));

    public static void main(String[] args) throws InterruptedException {

        Thread producer = new Thread(() -> Factory.addToStore());
        Thread country1 = new Thread(() -> Army.armyStore(Country.COUNTRY1));
        Thread country2 = new Thread(() -> Army.armyStore(Country.COUNTRY2));

        producer.start();
        country1.start();
        country2.start();

        producer.join();
        country1.join();
        country2.join();

    }
}