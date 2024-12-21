import java.util.Scanner;
class Example{
    // Easier to access the scanner from any method
    private static Scanner sc = new Scanner(System.in);

    public static void loginValidator() {
        //Login Style
        System.out.println();
        System.out.println("============================================================\n");
        System.out.printf("%43s", "Welcome to LibraryPro \n");
        System.out.println("\n============================================================");
        System.out.println();
        //Login Validator
        while (true) {
            System.out.print("Enter username:   ");
            String user = sc.next();
            System.out.print("Enter password:   ");
            String pass = sc.next();

            switch (user) {
                case "admin":
                    switch (pass) {
                        case "admin123":
                            System.out.println("Authenticating...");
                            clearConsole();
                            return;
                        default:
                            System.out.println();
                            System.out.println("Authenticating...");
                            System.out.println("Error:  Invalid username or password, Try again!");
                            System.out.println();
                            break;
                    }
                    break;
                default:
                    System.out.println();
                    System.out.println("Authenticating...");
                    System.out.println("Error:  Invalid username or password, Try again!");
                    System.out.println();
                    break;
            }
        }
    }
    public static void main(String[] args) {
        loginValidator();
    }


    //clearing the console
    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
        if (os.contains("Linux")) {
        System.out.print("\033\143");
        } else if (os.contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        } catch (final Exception e) {
        // Handle the exception
        System.err.println(e.getMessage());
        }
        }
}