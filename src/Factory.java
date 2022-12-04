import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Factory {
    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_GREEN = "\u001B[32m";

    protected static final List<Integer> FACTORY_STORE = new ArrayList(Arrays.asList(0,0,0,0,0,0));

    public static void addToStore(){

        while (Main.ProgramFinish == false) {
            synchronized (FACTORY_STORE) {

                int i = RandomPart();
                int partNumber = FACTORY_STORE.get(i);
                FACTORY_STORE.set(i, partNumber + 1);

                if (Main.ProgramFinish == false) {
                    System.out.println(ANSI_GREEN + "Factory produce element: " + (i + 1) +
                            "\t FACTORY STORE contain parts:  " + FACTORY_STORE.toString() + ANSI_RESET);
                }
                try {
                    FACTORY_STORE.wait(150);
                    Thread.sleep(500);
                    Factory.FACTORY_STORE.notifyAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        Thread.currentThread().interrupt();
    }

    public static int RandomPart() {
        Random randomPart = new Random();
        return randomPart.nextInt(0, 6);
    }

}
