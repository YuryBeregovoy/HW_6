import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Robot {
    public static void robotAssembly(Country country) {
        int partsInRobotCounter = 0;
        List<Integer> PartsInRobot = new ArrayList(Collections.nCopies(6, 0));
        while ((partsInRobotCounter < 6) && (Main.ProgramFinish == false)) {
            for (int i = 0; i < Factory.FACTORY_STORE.size(); i++) {
                int partInFactoryStore = Factory.FACTORY_STORE.get(i);
                int partInRobot = PartsInRobot.get(i);

                if ((partInFactoryStore > 0) && (partInRobot == 0) && (Main.ProgramFinish == false)) {
                    Factory.FACTORY_STORE.set(i, partInFactoryStore - 1);
                    PartsInRobot.set(i, 1);
                    partsInRobotCounter++;
                    System.out.println("Part " + (i + 1) + " taken by " + country + ". \t Now Army Store contain parts: "
                            + PartsInRobot.toString() + " --- (" + partsInRobotCounter + "/6)");
                    try {
                        Factory.FACTORY_STORE.wait(150);
                        Thread.sleep(250);
                        Factory.FACTORY_STORE.notifyAll();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
//                } else {
//                    System.err.println(country + ": Required parts is not available");
                }
                try {
                    Factory.FACTORY_STORE.wait(150);
                    Thread.sleep(250);
                    Factory.FACTORY_STORE.notifyAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
