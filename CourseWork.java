//Read the README.md doc first
import java.util.Scanner;
import java.time.LocalDate;
class Example{
    //Database - global access
    static String[][] bookArray = {
        {"B001", "To Kill a Mockingbird", "Harper Lee", "Fiction", "1"},
        {"B002", "1984", "George Orwell", "Dystopian", "8"},
        {"B003", "The Great Gatsby", "F. Scott Fitzgerald", "Classic", "10"},
        {"B004", "The Catcher in the Rye", "J.D. Salinger", "Classic", "7"},
        {"B005", "Pride and Prejudice", "Jane Austen", "Romance", "4"},
        {"B006", "The Hobbit", "J.R.R. Tolkien", "Fantasy", "6"},
        {"B007", "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", "9"},
        {"B008", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", "12"},
        {"B009", "Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Fantasy", "11"},
        {"B010", "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "Fantasy", "10"}
    }; // Dummy Data
    static int bookCount = bookArray.length; // Added a book count to keep track of books

    static String memberArray  [][] = {
        {"M001", "Yasas Banuka", "0721440872", "yasas@email.com"}, {"M002", "Tehan Romesh", "0124578963", "tehan@email.com"}, {"M003", "Pahan Romesh", "0124578963", "pahan@email.com"}
    }; // Dummy Data
    static int memberCount = memberArray.length; //Added a member count to keep track of members

    static String issueBooksArray [][] = {
        {"M001", "B010", "2024-11-21"},
        {"M002", "B015", "2024-11-22"},
        {"M002", "B011", "2024-01-03"},
        {"M003", "B012", "2024-12-28"},
        {"M003", "B013", "2024-12-29"}
    }; // Dummy Data
    static int issueBookCount = issueBooksArray.length; //Added a issue count to keep track of issuing books
    
    // Main Method
    public static void main(String[] args) {
        loginValidator(); //Login Process
        home(); // Direct to the home page
    }

    private static Scanner sc = new Scanner(System.in); // Easier to access the scanner from any method

// -- Login-Section-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void loginValidator() {
        clearConsole();
        while (true) { // Validates correct login
            System.out.println("\n============================================================\n");
            System.out.printf("%43s", "Welcome to LibraryPro \n");
            System.out.println("\n============================================================\n");
            System.out.print("Enter username:   ");
            String user = sc.next();
            System.out.print("Enter password:   ");
            String pass = sc.next();
            System.out.println();

            if (user.equals("admin") && pass.equals("admin123")) {
                delay("Authenticating");
                clearConsole();
                delay("Login in");
                clearConsole();
                return;
            } else {
                message("Error: Invalid username or password, Try again!", "Authenticating");
                continue;
            }
        }
    }

    // Main Menu
    public static void home() {
        int option = 0;
        while (option != 6) {
            //Home page header style
            System.out.println("\n+==========================================================+\n");
            System.out.printf("%43s", "Library Management System \n");
            System.out.println("\n+==========================================================+\n");

            options( "Manage Books", "Manage Members", "Issue Books", "Return Books", "View Reports", "Exit");
            System.out.println("+==========================================================+\n");

            System.out.print("Please select an option (1-6):    ");
            option = sc.nextInt();

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
                    issueBook();
                    break;
                case 4:
                    processing("Return Books");
                    clearConsole();
                    returnBooks();
                    break; 
                case 5:
                    processing("View Reports");
                    clearConsole();
                    viewReports();
                    break;
                case 6:
                    processing("Exiting Application");
                    clearConsole();
                    break;   
                default:
                    clearConsole();
                    System.out.println("\nError:  Invalid Option, Please Try again!");
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
            option = optionsMenu("Books");
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
                    searchBook();
                    break; 
                case 5:
                    processing("View All Books");
                    clearConsole();
                    viewAllBooks();
                    break;
                case 6:
                    processing("Back to Home");
                    clearConsole();
                    break;    
            
                default:
                    clearConsole();
                    System.out.println("\nError:  Invalid Option, Please Try again!");
                    delay("Loading");
                    break;
            }
        }
    }

    //Adds a book to the collection
    public static void addBook() {
        while (true) {    
            header("Manage Books");
            subHeader("Add Book");

            System.out.print("Enter Book ID       :    ");
            String bookId = sc.next();

            //Checks if the book exists already
            boolean isExisitingBook = checkDuplicate(bookId, bookArray);
            if (isExisitingBook) {
                message("Error:  This Book ID already exists, Please Try another one!", "Loading");
                continue;
            } else {

                System.out.println();
                System.out.print("Enter title         :    ");
                sc.nextLine(); // Consumes the left previous line
                String title= sc.nextLine();

                System.out.println();
                System.out.print("Enter Author        :    ");
                String author = sc.nextLine();

                System.out.println();
                System.out.print("Enter Genre         :    ");
                String genre = sc.nextLine();

                System.out.println();
                System.out.print("Enter Quantity (Must be a positive value)      :    ");
                String qty = sc.next();
                System.out.println();

                if (Integer.parseInt(qty) < 0) {
                    message("Error:  Quantity can't be a negative value, Try again!", "Loading");
                    break;
                }

                // Resizes the array inorder to fit new data
                if(bookArray.length <= bookCount){
                    bookArray = resizeArray(5, bookArray);
                }

                bookArray[bookCount][0] = bookId;
                bookArray[bookCount][1] = title;
                bookArray[bookCount][2] = author;
                bookArray[bookCount][3] = genre;
                bookArray[bookCount][4] = qty;

                //Increment book count
                bookCount++;

                System.out.println("\n+----------------------------------------------------------+\n");;
                message("Book Successfully added to the collection", "Adding");
                
                break;
            }
        }
    }

    // Updates an entered book
    public static void updateBook() {
        while (true) {
            header("Manage Books");
            subHeader("Update Book");

            System.out.print("Enter Book ID to update       :    ");
            String bookId = sc.next();

            int index = 0;
            boolean isExisitingBook = false;
            //Finds the BookId array
            for (int i = 0; i < bookArray.length; i++) {
                if (bookArray[i][0] != null && bookArray[i][0].equals(bookId)) {
                    index = i;
                    isExisitingBook = true;
                }
            }
            
            if (!isExisitingBook) {
                message("This Book ID doesn't exists, Try again please !", "Loading");
                break;
            } else {
                System.out.println();
                System.out.print("Enter title         :    ");
                sc.nextLine(); // Consumes the left previous line
                String title= sc.nextLine();

                System.out.println();
                System.out.print("Enter Author        :    ");
                String author = sc.nextLine();

                System.out.println();
                System.out.print("Enter Genre         :    ");
                String genre = sc.nextLine();

                System.out.println();
                System.out.print("Enter Quantity (Must be a positive value)      :    ");
                String qty = sc.next();
                System.out.println();

                if (Integer.parseInt(qty) < 0) {
                    message("Error:  Quantity can't be a negative value, Try again!", "Loading");
                    break;
                }

                bookArray[index][1] = title;
                bookArray[index][2] = author;
                bookArray[index][3] = genre;
                bookArray[index][4] = qty;

                System.out.println("\n+----------------------------------------------------------+\n");
                message("Book details updated successfully", "Updating");

                break;
            }
        }
    }

    // Can delete a certain book
    public static void deleteBook() {
        while (true) {
            header("Manage Books");
            subHeader("Delete Book");

            System.out.print("Enter Book ID to delete       :    ");
            String bookId = sc.next();

            int index = 0;
            boolean isExisitingBook = false;
            //Finds the BookId array
            for (int i = 0; i < bookArray.length; i++) {
                if (bookArray[i][0] != null && bookArray[i][0].equals(bookId)) {
                    index = i;
                    isExisitingBook = true;
                }
            }

            if (!isExisitingBook) {
                message("This Book ID doesn't exists, Try again please !", "Loading");
                break;
            } else {
                for (int i = index; i < bookCount - 1; i++) {
                    bookArray[i] = bookArray[i + 1];
                }
                bookArray[bookCount - 1] = new String[5];
                bookCount--;
    
                System.out.println("\n+----------------------------------------------------------+\n");
                message("Book details deleted successfully","Deleting");
            }
            break;
        }
    }

    // Can search the relevant book
    public static void searchBook() {
        while (true) {
            header("Manage Books");
            subHeader("Search Book");

            System.out.print("Enter Book ID to search       :    ");
            String bookId = sc.next();

            int index = 0;
            boolean isExisitingBook = false;
            //Finds the BookId array
            for (int i = 0; i < bookArray.length; i++) {
                if (bookArray[i][0] != null && bookArray[i][0].equals(bookId)) {
                    index = i;
                    isExisitingBook = true;
                }
            }

            if (!isExisitingBook) {
                message("This Book doesn't exists!, Try again", "Loading");
                break;
            } else {
                System.out.println("\n+----------------------------------------------------------+\n");
                System.out.print("Searching book  :   ");
                delay(bookId);
                System.out.println();
                clearConsole();
                System.out.println("Success! Book Found");

                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%-3s", "|");
                System.out.printf("%-10s","Book Id");
                System.out.printf("%-10s", "|");
                System.out.printf("%-35s","Book Title");
                System.out.printf("%-10s", "|");
                System.out.printf("%-21s","Book Author");
                System.out.printf("%-10s", "|");
                System.out.printf("%-21s","Book Genre");
                System.out.printf("%-10s", "|");
                System.out.printf("%-21s","Book Quantity");
                System.out.printf("%s", "|\n");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");

                for (int i = 0; i < bookArray[index].length; i++) {
                    System.out.printf("%-3s", "|");
                    if (i == 0) {
                        System.out.printf("%-10s", bookArray[index][i] == null ? "" : bookArray[index][i]);
                    } else if (i == 1) {
                        System.out.printf("%-42s", bookArray[index][i] == null ? "" : bookArray[index][i]);
                    } else {
                        System.out.printf("%-28s", bookArray[index][i] == null ? "" : bookArray[index][i]);
                    }
                }
                System.out.printf("%s", "|\n");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
            }            
            break;
        }
    }

    // Can see every book in a tabular format
    public static void viewAllBooks() {
        while (true) {
            System.out.println("\n\t\t\t\t\t\t\t\tView All Books");
            System.out.println("========================================================================================================================================================\n");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-3s", "|");
            System.out.printf("%-10s","Book Id");
            System.out.printf("%-10s", "|");
            System.out.printf("%-38s","Book Title");
            System.out.printf("%-10s", "|");
            System.out.printf("%-20s","Book Author");
            System.out.printf("%-10s", "|");
            System.out.printf("%-20s","Book Genre");
            System.out.printf("%-10s", "|");
            System.out.printf("%-20s","Book Quantity");
            System.out.printf("%s", "|\n");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");

                for (int i = 0; i < bookArray.length; i++) {
                    for (int j = 0; j < bookArray[i].length; j++) {
                        System.out.printf("%-5s", "|");

                        if (j == 0) {
                            System.out.printf("%-8s", bookArray[i][j] == null ? "" : bookArray[i][j]);
                        } else if (j == 1) {
                            System.out.printf("%-43s", bookArray[i][j] == null ? "" : bookArray[i][j]);
                        } else {
                            System.out.printf("%-25s", bookArray[i][j] == null ? "" : bookArray[i][j]);
                        }

                    }
                    System.out.printf("%s", "|\n");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
                }

            System.out.print("| Total Book Count:   " + bookCount);
            System.out.printf("%129s", "|\n");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
            break;
        }
    }
//----Members------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Manage Members
    public static void manageMembers() {
        int option = 0;
        while (option != 6) {
            option = optionsMenu("Members");

            switch (option) {
                case 1:
                    processing("Add Member");
                    clearConsole();
                    addMember();
                    break;
                case 2:
                    processing("Update Member");
                    clearConsole();
                    updateMember();
                    break; 
                case 3:
                    processing("Delete Member");
                    clearConsole();
                    deleteMember();
                    break;
                case 4:
                    processing("Search Member");
                    clearConsole();
                    searchMember();
                    break; 
                case 5:
                    processing("View All Members");
                    clearConsole();
                    viewAllMembers();
                    break;
                case 6:
                    processing("Back to Home");
                    clearConsole();
                    break;    
            
                default:
                    clearConsole();
                    System.out.println("\nError:  Invalid Option, Please Try again!");
                    delay("Loading");
                    break;
            }
        }
    }

    //Adds a Member to the collection
    public static void addMember() {
        while (true) {    
            header("Manage Members");
            subHeader("Add Member");

            System.out.print("Enter Member ID       :    ");
            String memberId = sc.next();

            //Checks if the Member exists already
            boolean isExisistingMember = checkDuplicate(memberId, memberArray);
            if (isExisistingMember) {
                message("Error:  This Member ID already exists, Please Try another one!", "Loading");
                continue;
            } else {
                
                System.out.println();
                System.out.print("Enter Name         :    ");
                sc.nextLine(); // Consumes the left previous line
                String name = sc.nextLine();

                System.out.println();
                System.out.print("Enter Contact Number        :    ");
                int memberContact = sc.nextInt();

                if (!isValidPhoneNum(memberContact)) {
                    continue;
                }

                sc.nextLine();
                System.out.println();
                System.out.print("Enter Email         :    ");
                String memberEmail = sc.nextLine();

                if (!isValidEmail(memberEmail)) {
                    continue;
                }
                
                // Resizes the array inorder to fit new data
                if(memberArray.length <= memberCount){
                    memberArray = resizeArray(4, memberArray);
                }

                memberArray[memberCount][0] = memberId;
                memberArray[memberCount][1] = name;
                memberArray[memberCount][2] = Integer.toString(memberContact);
                memberArray[memberCount][3] = memberEmail;
                System.out.println();


                //Increment Member count
                memberCount++;
                
                System.out.println("\n+----------------------------------------------------------+\n");
                message("Member Successfully added to the collection", "Adding");
                break;
            }
        }
    }

    // Updates an entered Member
    public static void updateMember() {
        while (true) {
            header("Manage Members");
            subHeader("Update Member");

            System.out.print("Enter Member ID to update       :    ");
            String memberId = sc.next();

            int index = 0;
            boolean isExisistingMember = false;
            //Finds the memberId array
            for (int i = 0; i < memberArray.length; i++) {
                if (memberArray[i][0] != null && memberArray[i][0].equals(memberId)) {
                    index = i;
                    isExisistingMember = true;
                    break;  // Found the member, no need to continue the loop
                }
            }
            
            
            if (!isExisistingMember) {
                message("This Member ID doesn't exists, Try again please !", "Loading");
                break;
            } else {System.out.println();
                System.out.print("Enter Name         :    ");
                sc.nextLine(); // Consumes the left previous line
                String name = sc.nextLine();

                System.out.println();
                System.out.print("Enter Contact Number        :    ");
                int memberContact = sc.nextInt();

                if (!isValidPhoneNum(memberContact)){
                    continue;
                }

                sc.nextLine();
                System.out.println();
                System.out.print("Enter Email         :    ");
                String memberEmail = sc.nextLine();

                if (!isValidEmail(memberEmail)) {
                    continue;
                }

                memberArray[index][1] = name;
                memberArray[index][2] = Integer.toString(memberContact);
                memberArray[index][3] = memberEmail;
                System.out.println();

                System.out.println("\n+----------------------------------------------------------+\n");
                message("Member details updated successfully", "Updating");
                break;
            }
        }
    }

    // Deleting a specific member
    public static void deleteMember() {
        while (true) {
            header("Manage Members");
            subHeader("Delete Member");

            System.out.print("Enter Member ID to delete       :    ");
            String memberId = sc.next();

            int index = 0;
            boolean isExisistingMember = false;
            //Finds the memberId array
            for (int i = 0; i < memberArray.length; i++) {
                if (memberArray[i][0] != null && memberArray[i][0].equals(memberId)) {
                    index = i;
                    isExisistingMember = true;
                    break;  // Found the member, no need to continue the loop
                }
            }
            

            if (!isExisistingMember) {
                message("This Member ID doesn't exists, Try again please !", "Loading");
                break;
            } else {
                for (int i = index; i < memberCount - 1; i++) {
                    memberArray[i] = memberArray[i + 1];
                }
    
                memberArray[memberCount - 1] = new String[4];
                memberCount--;
    
                System.out.println("\n+----------------------------------------------------------+\n");
                message("Member details deleted successfully", "Deleting");
            }
            break;
        }
    }

    // Can search the details of a member
    public static void searchMember() {
        while (true) {
            header("Manage Members");
            subHeader("Search Member");

            System.out.print("Enter Member ID to search       :    ");
            String memberId = sc.next();

            int index = 0;
            boolean isExisistingMember = false;
            //Finds the memberId array
            for (int i = 0; i < memberArray.length; i++) {
                if (memberArray[i][0] != null && memberArray[i][0].equals(memberId)) {
                    index = i;
                    isExisistingMember = true;
                }
            }

            if (!isExisistingMember) {
                message("This Member doesn't exists!", "Loading");
                break;
            } else {
                System.out.println("\n+----------------------------------------------------------+\n");
                System.out.print("Searching Member  :   ");
                delay(memberId);
                System.out.println();
                clearConsole();
                System.out.println("Success! Member Found");

                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%-3s", "|");
                System.out.printf("%-10s","Member Id");
                System.out.printf("%-10s", "|");
                System.out.printf("%-38s","Member Name");
                System.out.printf("%-10s", "|");
                System.out.printf("%-35s","Member Contact Number");
                System.out.printf("%-10s", "|");
                System.out.printf("%-35s","Member Email");
                System.out.printf("%s", "|\n");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");

                for (int j = 0; j < 1; j++) {
                    System.out.printf("%-5s", "|");
                    System.out.printf("%-8s", memberArray[index][j]);
                }
                for (int j = 1; j < 2; j++) {
                    System.out.printf("%-5s", "|");
                    System.out.printf("%-43s", memberArray[index][j]);
                }
                for (int j = 2; j < memberArray[index].length; j++) {
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-35s", memberArray[index][j]);
                }

                System.out.printf("%s", "|\n");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
            break;
        }
    }

    // View all members in tabular format
    public static void viewAllMembers() {
        while (true) {
            System.out.println("\n\t\t\t\t\t\t\t\tView All Members");
            System.out.println("========================================================================================================================================================\n");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-3s", "|");
            System.out.printf("%-10s","Member Id");
            System.out.printf("%-10s", "|");
            System.out.printf("%-38s","Member Name");
            System.out.printf("%-10s", "|");
            System.out.printf("%-35s","Member Contact Number");
            System.out.printf("%-10s", "|");
            System.out.printf("%-35s","Member Email");
            System.out.printf("%s", "|\n");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");

            for (int i = 0; i < memberArray.length; i++) {
                for (int j = 0; j < memberArray[i].length; j++) {
                    System.out.printf("%-5s", "|");
                    // Condition is placed to clear out null texts when displaying and also for spacing
                    if (j == 0) {
                        System.out.printf("%-8s", memberArray[i][j] == null ? "" : memberArray[i][j]);
                    } else if (j ==1) {
                        System.out.printf("%-43s", memberArray[i][j] == null ? "" : memberArray[i][j]);
                    } else {
                        System.out.printf("%-40s", memberArray[i][j] == null ? "" : memberArray[i][j]);
                    }
                }
                System.out.printf("%s", "|\n");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
            System.out.print("| Total Member Count:   " + memberCount);
            System.out.printf("%128s", "|\n");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
            break;
        }
    }

//----Issue-Books------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void issueBook() {

        boolean isExisistingMember = false, isExisistingBook = false;
        int index = 0;
        
        while (true) {
            header("Issue Books");

            System.out.print("1. Enter Member ID:   ");
            String memberID = sc.next();
            System.out.println();
            
            for (String [] member : memberArray) {
                if (member[0].equals(memberID)) {
                    isExisistingMember = true;
                }
            }

            if (!isExisistingMember) {
                message("This Member ID doesn't exists, Try again!", "Checking Member ID");
                continue;
            } else {
                System.out.print("2. Enter Book ID:   ");
                String bookID = sc.next();
                System.out.println();

                for (int i = 0; i < bookArray.length; i++) {
                    if (bookArray[i][0].equals(bookID)) {
                        index = i;
                        isExisistingBook = true;
                    }
                }

                if (!isExisistingBook) {
                    message("This Book ID doesn't exists, Try again!", "Checking Book ID");
                    continue;
                } else {
                    // Resizes the array inorder to fit new data
                    if (issueBooksArray.length <= issueBookCount) {
                        issueBooksArray = resizeArray(3, issueBooksArray);
                    }

                    boolean isIssuedPreviously = false;
                    for (int i = 0; i < issueBooksArray.length; i++) {
                        if ((issueBooksArray[i][0] != null && issueBooksArray[i][1] != null) && (issueBooksArray[i][0].equals(memberID) && issueBooksArray[i][1].equals(bookID))) {
                            isIssuedPreviously = true;
                            break;
                        }
                    }

                    if (isIssuedPreviously) {
                        message("This book has already been issued to this member, If returned visit return books section.", "Checking database");
                        System.out.println("Do you want to ?\n");
                        options("Visit return books section", "Issue another book", "Go back");
                        System.out.print("Your choice:    ");
                        int option = sc.nextInt();
                        switch (option) {
                            case 1:
                                processing("Loading");
                                clearConsole();
                                returnBooks();
                                break;
                            case 2:
                                processing("Loading");
                                clearConsole();
                                break;
                            case 3:
                                processing("Going back");
                                clearConsole();
                                return;
                            default:
                                message("Invalid option, try again!", "Re-Loading");
                                clearConsole();
                                break;
                        }
                        return; // Ends the loop so it will direct to the main menu without continuing
                    }
                    //Proccess
                    int qty = Integer.parseInt(bookArray[index][bookArray[index].length - 1]);
                    // Deducts the book quantity
                    if (qty <= 0) {
                        message("Book Quantity is not sufficient!", "Checking quantity");
                        continue;
                    }

                    System.out.print("3. Due Date  (yyyy-mm-dd):   ");
                    String dueDate = sc.next();
                    System.out.println("\n+----------------------------------------------------------+\n");
                    // Reducing book quantity count
                    qty--;
                    bookArray[index][bookArray[index].length - 1] = Integer.toString(qty);
                    // Adding values to the issueBooksArray
                    issueBooksArray[issueBookCount][0] = memberID;
                    issueBooksArray[issueBookCount][1] = bookID;
                    issueBooksArray[issueBookCount][2] = dueDate;
                    issueBookCount++;
                    delay("Issuing Book");
                    System.out.println("\nBook issued successfully");
                    System.out.println("Issuing recorded in the system.");
                    System.out.println("\nRemaining Book Stock:   " + bookArray[index][bookArray[index].length - 1]);

                }
                    break;
            }
        }   
    }
//----Return-Books------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void returnBooks() {

        boolean isExisistingMember = false;
        int index = 0;
        boolean isExisistingBook = false;
        
        while (true) {
            header("Return Books");
            System.out.print("1. Enter Book ID:   ");
            String bookID = sc.next();
            System.out.println();
            
            for (int i = 0; i < issueBooksArray.length; i++) {
                if (issueBooksArray[i][1] != null && issueBooksArray[i][1].equals(bookID)) {
                    index = i;
                    isExisistingBook = true;
                }
            }

            if (!isExisistingBook) {
                message("This Book is not issued, Try again!", "Checking Book ID");
                continue;
            } else {
                System.out.print("2. Enter Member ID:   ");
                String memberID = sc.next();
                System.out.println();

                if (issueBooksArray[index][0] != null && issueBooksArray[index][0].equals(memberID)) {
                    isExisistingMember = true;
                }

                if (!isExisistingMember) {
                    message("This Member didn't bought any books with the id of "+ bookID +", Try again!", "Checking Member ID");
                    continue;
                } else {
                    String dueDate = issueBooksArray[index][2];
                    // Gets Current Date
                    LocalDate today = LocalDate.now();
                    double fine = fineCal(dueDate);

                    for (int i = index; i < issueBookCount - 1; i++) {
                        issueBooksArray[i] = issueBooksArray[i + 1]; //Deletes the current details in the array once returned
                    }

                    issueBooksArray[issueBookCount - 1] = new String[3];
                    issueBookCount--;

                    System.out.println("\n+----------------------------------------------------------+\n");
                    delay("Returning");
                    clearConsole();
                    System.out.println("Book Successfully Returned");
                    System.out.println("\t\t\t\t\t\t\t\tInformation of the returned book");
                    System.out.println("=======================================================================================================================================================");

                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", "Member");
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", "Book ID");
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", "Due Date");
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", "Current Date");
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", "Overdue Fine");
                    System.out.println("|");

                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", memberID);
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", bookID);
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", dueDate);
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", today);
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", fine);
                    System.out.println("|");
                    System.out.println("=======================================================================================================================================================\n");

                    break;
                }
            }   
        }
    }
    
//----View-Reports------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void viewReports() {
        header("Reports - Library Pro");
        options("Overdue Books", "Books Issued Per Member", "Back to Home");
        System.out.println("\n+----------------------------------------------------------+\n");
        System.out.print("Select an option: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                processing("Checking Overdue Books");
                clearConsole();
                overdueBooks();
                break;
            case 2:
                processing("Checking Books Issued");
                clearConsole();
                booksIssued();
                break;    
            case 3:
                processing("Going back");
                clearConsole();
                return;    
            default:
                clearConsole();
                System.out.println("\nError:  Invalid Option, Please Try again!");
                delay("Loading");
                break;
        }
    }
//----Overdue-Books------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void overdueBooks() {
        int option = 0;
        while (option != 1) {
            header("Overdue Books");

            for (int i = 0; i < issueBooksArray.length; i++) {
                if (issueBooksArray[i][0] == null) {
                    continue; // This skips the deleted inputs
                }

                String dueDateInput = issueBooksArray[i][2];
                LocalDate today = LocalDate.now(); // // Gets Current Date
                double fine = fineCal(dueDateInput);
                int daysOverdue = (int) fine / 50;

                if (fine > 0) {
                    System.out.println("=====================================================================================================================================================================================");

                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", "Member");
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", "Book ID");
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", "Due Date");
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", "Current Date");
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", "Days Overdue");
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", "Overdue Fine");
                    System.out.println("|");
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", issueBooksArray[i][0]);
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", issueBooksArray[i][1]);
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", issueBooksArray[i][2]);
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", today);
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", daysOverdue);
                    System.out.printf("%-10s", "|");
                    System.out.printf("%-20s", fine);
                    System.out.println("|");
                    System.out.println("=====================================================================================================================================================================================\n");
            
                }
            }
            break;
        }

            System.out.println("Do you want to ?");
            options("Go Back to Main Menu");
            System.out.print("Your choice:  ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    processing("Going back");
                    clearConsole();
                    return;
                default:
                    clearConsole();
                    System.out.println("\nError:  Invalid Option, Please Try again!");
                    delay("Loading");
                    break;
            }
        }
    
//----Books-Issued-Per-Member------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void booksIssued() {
        int option = 0;
        while (option != 1) {
            header("Books Issued Per Member");
            System.out.println("==================================================================");

            System.out.printf("%-10s", "|");
            System.out.printf("%-20s", "Member ID");
            System.out.printf("%-10s", "|");
            System.out.printf("%-25s", "Total Books Issued");
            System.out.println("|");
            
            for (int i = 0; i < issueBooksArray.length; i++) {
                int index = -1;
                String memberID = issueBooksArray[i][0];
                int count = 0;

                //Finds the duplicates and store the recent duplicate index in the variable index
                for (int j = 0; j < issueBooksArray.length; j++) {
                    if (issueBooksArray[j][0] != null && issueBooksArray[j][0].equals(memberID)) {
                        count++;
                        index = j;
                    }
                }
                
                if (index != i){
                    continue; // Skips duplicates
                }

                System.out.println("------------------------------------------------------------------");
                System.out.printf("%-10s", "|");
                System.out.printf("%-20s", memberID);
                System.out.printf("%-10s", "|");
                System.out.printf("%-25s", count);
                System.out.println("|");
            }
            System.out.println("==================================================================");

            System.out.println("Do you want to ?");
            options("Go Back to Main Menu");
            System.out.print("Your choice:  ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    processing("Going back");
                    clearConsole();
                    return;
                default:
                    clearConsole();
                    System.out.println("\nError:  Invalid Option, Please Try again!");
                    delay("Loading");
                    break;
            }
        }
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
        System.err.println(e.getMessage()); // Handle the exception
        }
    }

    // add a delay affect 
    public static void delay(String word) {
        int delayTime = Byte.MAX_VALUE * 100; // approx:    2 seconds
        System.out.print(word + "....");
        for (int i = 0; i < delayTime; i++) {
            System.out.print("\b\b\b\b");
            System.out.print("....");
        }
    }

    // Outputs a designed header
    public static void header(String title) {
        System.out.println();
        System.out.printf("%35s", title);
        System.out.println("\n+==========================================================+\n");
    }

    //Outputs a designed sub header
    public static void subHeader(String title) {
        System.out.println("\n" + title);
        System.out.println("------------------------------------------------------------\n");
    }

    public static void options(String... titles) {
        for (int i = 0; i < titles.length; i++) {
            System.out.println("[" + (i + 1) + "] " + titles[i] + "\n");
        }
    }

    // Outputs a desinged options menu
    public static int optionsMenu(String optionTitle) {
        header("Manage " + optionTitle);
        options("Add " + optionTitle, "Update " + optionTitle, "Delete " + optionTitle, "Search " + optionTitle, "View All " + optionTitle, "Back to Home");
        System.out.println("\n+----------------------------------------------------------+\n");
        System.out.print("Please select an option (1-6):    ");

        return sc.nextInt();
    }

    // Outputs the navaigation to the user
    public static void processing(String optionTitle) {
        System.out.println("Processing your request: " + optionTitle + "\n");
        delay("Loading");
    }

    // Increases the size of the arrays
    public static String [][] resizeArray(int fields, String array [][]) {
        String newArray[][] = new String[array.length + 1][fields];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    // Outputs a specific error message
    public static void message(String message, String loadmessage) {
        System.out.println();
        delay(loadmessage);
        clearConsole();
        System.out.println("\n" + message);
        System.out.println();
    }

    //Validates phone number
    public static boolean isValidPhoneNum(int contact) {
        if (contact < 0100000000 || contact > 9999999999L) {
            message("Invalid phone number, Please try again!", "Loading");
            return false;
        }
        return true;
    }

    //Validates user email
    public static boolean isValidEmail(String email) {
        if (!(email.contains("@") && email.contains("."))) {
            message("Invalid email, Please try again!", "Loading");
            return false;
        }
        return true;
    }

    // Check duplicates in both arrays
    public static boolean checkDuplicate(String id, String array [][]) {
        boolean isExisisting = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] != null && array[i][0].equals(id)) {
                isExisisting = true;
            }
        }
        return isExisisting;
    }
    // Calculates the fine 
    public static double fineCal(String dueDateInput) {

        LocalDate today = LocalDate.now();
        LocalDate dueDateWithYear = LocalDate.parse(dueDateInput);

        int dueYear = dueDateWithYear.getYear(), dueMonth = dueDateWithYear.getMonthValue(), dueDate =  dueDateWithYear.getDayOfMonth();
        int currentYear = today.getYear(), currentMonth = today.getMonthValue(), currentDate =  today.getDayOfMonth();
    
        // Constants
        int finePerDay = 50;
        int daysInMonth = 30; //Default
        switch (dueMonth) {
            case 1,3,5,7,8,10,12:
                daysInMonth = 31;
                break;
            case 2,4,6,9,11:
                daysInMonth = 30;
                break;
            default:
                break;
        }
    
        // Calculate difference in years, months, and days
        int yearDifference = currentYear - dueYear;
        int monthDifference = (yearDifference * 12) + (currentMonth - dueMonth);
        int dayDifference = (monthDifference * daysInMonth) + (currentDate - dueDate);
    
        // Calculate total fine
        if (dayDifference > 0){
            return dayDifference * finePerDay;
        }

        return 0.0;
    }

    
}