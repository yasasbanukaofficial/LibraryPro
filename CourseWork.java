import java.util.Arrays;
import java.util.Scanner;
class Example{

    //Database - global access
    static String bookArray [][] = new String[1][5];
    static int bookCount = 0;

    // Easier to access the scanner from any method
    private static Scanner sc = new Scanner(System.in);

    // Login Section
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
                            delay("Loading");
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

    // Main Menu
    public static void home() {
        int option = 0;
        while (option != 6) {
            //Home page header style
            System.out.println();
            System.out.println("+==========================================================+\n");
            System.out.printf("%43s", "Library Management System \n");
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
                    manageMembers();
                    break; 
                case 3:
                    processing("Issue Books");
                    clearConsole();
                    break;
                case 4:
                    processing("Return Books");
                    clearConsole();
                    // returnBooks();
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
                    delay("Loading");
                    break;
            }
        }

    }

//----Books------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    // Manage Books
    public static void manageBooks() {
        int option = 0;
        while (option != 6) {
            System.out.println();
            System.out.printf("%35s", "Manage Books");
            System.out.println("\n+----------------------------------------------------------+\n");
            options(1, "Add Book");
            options(2, "Update Book");
            options(3, "Delete Book");
            options(4, "Search Book");
            options(5, "View All Books");
            options(6, "Back to Home");

            System.out.println("\n+----------------------------------------------------------+\n");

            System.out.print("Please select an option (1-6):    ");
            option = sc.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    processing("Add Book");
                    clearConsole();
                    addBook();
                    break;
                case 2:
                    processing("Update Book");
                    clearConsole();
                    updateBook();
                    break; 
                case 3:
                    processing("Delete Book");
                    clearConsole();
                    deleteBook();
                    break;
                case 4:
                    processing("Search Book");
                    clearConsole();
                    break; 
                case 5:
                    processing("View All Books");
                    clearConsole();
                    break;
                case 6:
                    processing("Back to Home");
                    clearConsole();
                    break;    
            
                default:
                    clearConsole();
                    System.out.println();
                    System.out.println("Error:  Invalid Option, Please Try again!");
                    delay("Loading");
                    break;
            }
        }
    }

    //Adds a book to the collection
    public static void addBook() {
        while (true) {    
            System.out.println();
            System.out.printf("%35s", "Manage Books");
            System.out.println("\n+==========================================================+\n");
            System.out.println();
            System.out.println("Add Book");
            System.out.println("------------------------------------------------------------\n");

            System.out.print("Enter Book ID       :    ");
            String bookId = sc.next();

            //Checks if the book exists already
            boolean isExisitingBook = checkDuplicate(bookId);
            if (isExisitingBook) {
                continue;
            } else {
                System.out.println();
                System.out.print("Enter title         :    ");
                sc.nextLine(); // Consumes the left previous line
                String bookTitle = sc.nextLine();

                System.out.println();
                System.out.print("Enter Author        :    ");
                String bookAuthor = sc.nextLine();

                System.out.println();
                System.out.print("Enter Genre         :    ");
                String bookGenre = sc.nextLine();

                System.out.println();
                System.out.print("Enter Quantity      :    ");
                String qty = sc.next();
                System.out.println();

                // Resizes the array inorder to fit new data
                if(bookArray.length <= bookCount){
                    bookArray = resizeArray();
                }

                // Entering values to the array
                bookArray[bookCount][0] = bookId;
                bookArray[bookCount][1] = bookTitle;
                bookArray[bookCount][2] = bookAuthor;
                bookArray[bookCount][3] = bookGenre;
                bookArray[bookCount][4] = qty;

                //Increment book count
                bookCount++;
                

                System.out.println("\n+----------------------------------------------------------+\n");
                delay("Adding");
                System.out.println();
                clearConsole();
                System.out.println("Book Successfully added to the collection");
                
                break;
            }
        }
    }

    // Updates an entered book
    public static void updateBook() {
        while (true) {
            System.out.println();
            System.out.printf("%35s", "Manage Books");
            System.out.println("\n+==========================================================+\n");
            System.out.println();
            System.out.println("Update Book");
            System.out.println("------------------------------------------------------------\n");

            System.out.print("Enter Book ID to update       :    ");
            String bookId = sc.next();

            int index = 0;
            boolean isExisitingBook = false;
            //Finds the BookId array
            for (int i = 0; i < bookArray.length; i++) {
                for (int j = 0; j < bookArray.length; j++) {
                    if (bookArray[i][0].equals(bookId)) {
                        index = i;
                        isExisitingBook = true;
                    }
                }
            }
            
            if (!isExisitingBook) {
                System.out.println("This Book ID doesn't exists, Try again please !");
                break;
            } else {
                System.out.println();
                System.out.print("Enter title         :    ");
                sc.nextLine(); // Consumes the left previous line
                String bookTitle = sc.nextLine();

                System.out.println();
                System.out.print("Enter Author        :    ");
                String bookAuthor = sc.nextLine();

                System.out.println();
                System.out.print("Enter Genre         :    ");
                String bookGenre = sc.nextLine();

                System.out.println();
                System.out.print("Enter Quantity      :    ");
                String qty = sc.next();
                System.out.println();

                // Entering the values into the array
                bookArray[index][1] = bookTitle;
                bookArray[index][2] = bookAuthor;
                bookArray[index][3] = bookGenre;
                bookArray[index][4] = qty;

                System.out.println("\n+----------------------------------------------------------+\n");
                delay("Updating");
                System.out.println();
                clearConsole();
                System.out.println("Book details updated successfully");

                break;
            }
        }
    }

    public static void deleteBook() {
        while (true) {
            System.out.println();
            System.out.printf("%35s", "Manage Books");
            System.out.println("\n+==========================================================+\n");
            System.out.println();
            System.out.println("Delete Book");
            System.out.println("------------------------------------------------------------\n");

            System.out.print("Enter Book ID to delete       :    ");
            String bookId = sc.next();

            int index = 0;
            boolean isExisitingBook = false;
            //Finds the BookId array
            for (int i = 0; i < bookArray.length; i++) {
                for (int j = 0; j < bookArray.length; j++) {
                    if (bookArray[i][0].equals(bookId)) {
                        index = i;
                        isExisitingBook = true;
                    }
                }
            }

            for (int i = index; i < bookCount - 1; i++) {
                bookArray[i] = bookArray[i + 1];
            }

            bookArray[bookCount - 1] = new String[5];
            bookCount--;

            System.out.println("\n+----------------------------------------------------------+\n");
            delay("Deleting");
            System.out.println();
            clearConsole();
            System.out.println("Book details deleted successfully");
            
            break;
        }
    }

//----Members------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Manage Members
    public static void manageMembers() {
        int option = 0;
        while (option != 6) {
            System.out.println();
            System.out.printf("%35s", "Manage Members");
            System.out.println("\n+----------------------------------------------------------+\n");
            options(1, "Add Member");
            options(2, "Update Member");
            options(3, "Delete Member");
            options(4, "Search Member");
            options(5, "View All Members");
            options(6, "Back to Home");

            System.out.println("\n+----------------------------------------------------------+\n");

            System.out.print("Please select an option (1-6):    ");
            option = sc.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    processing("Add Member");
                    clearConsole();
                    break;
                case 2:
                    processing("Update Member");
                    clearConsole();
                    break; 
                case 3:
                    processing("Delete Member");
                    clearConsole();
                    break;
                case 4:
                    processing("Search Member");
                    clearConsole();
                    break; 
                case 5:
                    processing("View All Members");
                    clearConsole();
                    break;
                case 6:
                    processing("Back to Home");
                    clearConsole();
                    break;    
            
                default:
                    clearConsole();
                    System.out.println();
                    System.out.println("Error:  Invalid Option, Please Try again!");
                    delay("Loading");
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
    public static void delay(String word) {
        int delayTime = Byte.MAX_VALUE * 125; // approx:    2 seconds
        System.out.print(word + "....");
        for (int i = 0; i < delayTime; i++) {
            System.out.print("\b\b\b\b");
            System.out.print("....");

        }
    }

    // Outputs the options in a formatted way
    public static void options(int num, String optionTitle) {
        System.out.println("[" + num + "] " + optionTitle);   
        System.out.println();
    }

    // Outputs the navaigation to the user
    public static void processing(String optionTitle) {
        System.out.println("Processing your request: " + optionTitle);
        System.out.println();
        delay("Loading");
    }

    // Increases the size of the array
    public static String [][] resizeArray() {
        String newArray[][] = new String[bookArray.length + 1][5];
        for (int i = 0; i < bookArray.length; i++) {
            newArray[i] = bookArray[i];
        }
        return newArray;
    }    

    public static boolean checkDuplicate(String bookId) {
        //Checks if the book exists already
        boolean isExisitingBook = false;
        for (int i = 0; i < bookCount; i++) {
            if (bookArray[i][0].equals(bookId)) {
                isExisitingBook = true;
                System.out.println();
                delay("Loading");
                clearConsole();
                System.out.println();
                System.out.println("Error:  The Book ID already exists, Please Try another one!");
                System.out.println();
            }
        }
        return isExisitingBook;
    }
}