public class Army {

    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_BLUE = "\u001B[34m";

    public static void armyStore(Country country) {
        int countToWin = 0;
        synchronized (Factory.FACTORY_STORE) {
            while (countToWin < 20) {

                if (Main.ProgramFinish == true) {
                    System.out.println("\t \t" + country + " have " + countToWin + " robots: !!! L O S E !!!");
                    Thread.currentThread().interrupt();
                    return;
                }

                Robot.robotAssembly(country);

                if (Main.ProgramFinish == false) {
                    countToWin++;
                    System.out.println(ANSI_BLUE + "New robot assembled in " + country + "!!!  Total robots: " + countToWin + ANSI_RESET);
                }
            }
            System.out.println(ANSI_BLUE + "\n \n !!!! " + country + " take 20 robots and WIN!!!!!" + ANSI_RESET);
            Main.ProgramFinish = true;
            Thread.currentThread().interrupt();
        }
    }
}