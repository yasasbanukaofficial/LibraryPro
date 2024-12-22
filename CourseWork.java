import java.util.Scanner;
class Example{
    // Easier to access the scanner from any method
    private static Scanner sc = new Scanner(System.in);

    public static void options(int num, String optionTitle) {
        System.out.println("[" + num + "]" + optionTitle);   
    }

    public static void processing(String optionTitle) {
        System.out.print("Processing your request: " + optionTitle + "...");
        delay();
    }

    public static void loginValidator() {
        // To clear the console
        clearConsole();
        //Login validator header style
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
                            System.out.println();
                            System.out.print("Authenticating...");
                            delay();
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

    public static void homePage() {
        int option = 0;
        while (option != 6) {
            //Home page header style
            System.out.println();
            System.out.println("+==========================================================+\n");
            System.out.printf("%43s", "Library Managemet System \n");
            System.out.println("\n+==========================================================+");
            System.out.println();

            options(1, "Manage Books");
            options(2, "Manage Members");
            options(3, "Issue Books");
            options(4, "Return Books");
            options(5, "View Reports");
            options(6, "Exit");

            System.out.println("+==========================================================+\n");

            System.out.print("Please select an option (1-6):    ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    processing("Manage Books");
                    clearConsole();
                    break;
                case 2:
                    processing("Manage Members");
                    clearConsole();
                    break; 
                case 3:
                    processing("Issue Books");
                    clearConsole();
                    break;
                case 4:
                    processing("Return Books");
                    clearConsole();
                    break; 
                case 5:
                    processing("View Reports");
                    clearConsole();
                    break;
                case 6:
                    processing("Exiting Application");
                    clearConsole();
                    break;   
            
                default:
                    System.out.println("Error:  Invalid Option, Please Try again!");
                    clearConsole();
                    break;
            }
        }

    }

    public static void main(String[] args) {
        loginValidator(); //Login Process
        homePage(); // Direct to the home page
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
    // add a delay affect 
    public static void delay() {
        int delayTime = Byte.MAX_VALUE * 75 ; // approx:    2 seconds
        for (int i = 0; i < delayTime; i++) {
            System.out.print("\b\b");
            System.out.print("..");
        }
    }
}