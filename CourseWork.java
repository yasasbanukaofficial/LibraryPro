import java.util.Scanner;
class Example{
    // Easier to access the scanner from any method
    private static Scanner sc = new Scanner(System.in);

    public static void options(int num, String optionTitle) {
        System.out.println("[" + num + "]" + optionTitle);   
        System.out.println();
    }

    public static void processing(String optionTitle) {
        System.out.println("Processing your request: " + optionTitle);
        System.out.println();
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
                            System.out.println("Authenticating!!!");
                            System.out.println();
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

    public static void home() {
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
            System.out.println();

            switch (option) {
                case 1:
                    processing("Manage Books");
                    clearConsole();
                    manageBooks();
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
                    clearConsole();
                    System.out.println();
                    System.out.println("Error:  Invalid Option, Please Try again!");
                    delay();
                    break;
            }
        }

    }

    public static void manageBooks() {
        while (true) {
            System.out.println();
        System.out.printf("%35s", "Manage Books");
        System.out.println("\n+----------------------------------------------------------+\n");
        options(1, "Add Book");
        options(2, "Update Book");
        options(3, "Delete Book");
        options(4, "Search Book");
        options(5, "View All Books");

        System.out.println("\n+----------------------------------------------------------+\n");

        System.out.print("Please select an option (1-6):    ");
        int option = sc.nextInt();
        System.out.println();

        switch (option) {
            case 1:
                processing("Add Book");
                clearConsole();
                break;
            case 2:
                processing("Update Book");
                clearConsole();
                break; 
            case 3:
                processing("Delete Book");
                clearConsole();
                break;
            case 4:
                processing("Search Book");
                clearConsole();
                break; 
            case 5:
                processing("View All Books");
                clearConsole();
                break;
        
            default:
                clearConsole();
                System.out.println();
                System.out.println("Error:  Invalid Option, Please Try again!");
                delay();
                break;
        }
        }
    }

    public static void main(String[] args) {
        loginValidator(); //Login Process
        home(); // Direct to the home page
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
        int delayTime = Byte.MAX_VALUE * 125; // approx:    2 seconds
        System.out.print("Loading....");
        for (int i = 0; i < delayTime; i++) {
            System.out.print("\b\b\b\b");
            System.out.print("....");

        }
    }
}