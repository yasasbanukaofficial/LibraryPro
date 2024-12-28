import java.util.Scanner;
import java.time.LocalDate;
class Example{
    // Main Method
    public static void main(String[] args) {
        loginValidator(); //Login Process
        home(); // Direct to the home page
    }
    
//Database - global access
    // Dummy Data
    static String[][] bookArray = {
        {"B001", "To Kill a Mockingbird", "Harper Lee", "Fiction", "0"},
        {"B002", "1984", "George Orwell", "Dystopian", "8"},
        {"B003", "The Great Gatsby", "F. Scott Fitzgerald", "Classic", "10"},
        {"B004", "The Catcher in the Rye", "J.D. Salinger", "Classic", "7"},
        {"B005", "Pride and Prejudice", "Jane Austen", "Romance", "4"},
        {"B006", "The Hobbit", "J.R.R. Tolkien", "Fantasy", "6"},
        {"B007", "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", "9"},
        {"B008", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", "12"},
        {"B009", "Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Fantasy", "11"},
        {"B010", "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "Fantasy", "10"},
        {"B011", "Moby-Dick", "Herman Melville", "Adventure", "3"},
        {"B012", "War and Peace", "Leo Tolstoy", "Historical", "2"},
        {"B013", "Crime and Punishment", "Fyodor Dostoevsky", "Psychological", "4"},
        {"B014", "The Brothers Karamazov", "Fyodor Dostoevsky", "Philosophical", "5"},
        {"B015", "Anna Karenina", "Leo Tolstoy", "Romance", "6"},
        {"B016", "Brave New World", "Aldous Huxley", "Dystopian", "8"},
        {"B017", "Jane Eyre", "Charlotte Bronte", "Romance", "7"},
        {"B018", "Wuthering Heights", "Emily Bronte", "Romance", "4"},
        {"B019", "The Divine Comedy", "Dante Alighieri", "Epic", "1"},
        {"B020", "Don Quixote", "Miguel de Cervantes", "Classic", "3"},
        {"B021", "Ulysses", "James Joyce", "Modernist", "2"},
        {"B022", "The Odyssey", "Homer", "Epic", "5"},
        {"B023", "The Iliad", "Homer", "Epic", "4"},
        {"B024", "A Tale of Two Cities", "Charles Dickens", "Historical", "7"},
        {"B025", "Great Expectations", "Charles Dickens", "Classic", "8"},
        {"B026", "Oliver Twist", "Charles Dickens", "Classic", "6"},
        {"B027", "Dracula", "Bram Stoker", "Horror", "5"},
        {"B028", "Frankenstein", "Mary Shelley", "Horror", "4"},
        {"B029", "The Picture of Dorian Gray", "Oscar Wilde", "Classic", "6"},
        {"B030", "The Scarlet Letter", "Nathaniel Hawthorne", "Classic", "3"},
        {"B031", "Fahrenheit 451", "Ray Bradbury", "Dystopian", "7"},
        {"B032", "The Alchemist", "Paulo Coelho", "Philosophical", "10"},
        {"B033", "One Hundred Years of Solitude", "Gabriel Garcia Marquez", "Magical Realism", "4"},
        {"B034", "Love in the Time of Cholera", "Gabriel Garcia Marquez", "Romance", "5"},
        {"B035", "The Kite Runner", "Khaled Hosseini", "Historical", "6"},
        {"B036", "A Thousand Splendid Suns", "Khaled Hosseini", "Historical", "7"},
        {"B037", "The Road", "Cormac McCarthy", "Post-apocalyptic", "3"},
        {"B038", "Life of Pi", "Yann Martel", "Adventure", "8"},
        {"B039", "The Girl with the Dragon Tattoo", "Stieg Larsson", "Mystery", "6"},
        {"B040", "The Da Vinci Code", "Dan Brown", "Thriller", "9"},
        {"B041", "Angels and Demons", "Dan Brown", "Thriller", "7"},
        {"B042", "Inferno", "Dan Brown", "Thriller", "6"},
        {"B043", "The Shining", "Stephen King", "Horror", "4"},
        {"B044", "It", "Stephen King", "Horror", "5"},
        {"B045", "Misery", "Stephen King", "Psychological", "6"},
        {"B046", "Carrie", "Stephen King", "Horror", "3"},
        {"B047", "The Stand", "Stephen King", "Post-apocalyptic", "2"},
        {"B048", "The Hunger Games", "Suzanne Collins", "Dystopian", "8"},
        {"B049", "Catching Fire", "Suzanne Collins", "Dystopian", "7"},
        {"B050", "Mockingjay", "Suzanne Collins", "Dystopian", "6"}
    };

    // Added a book count to keep track of books
    static int bookCount = bookArray.length;

    // Dummy Data
    static String memberArray  [][] = {
        {"M001", "Yasas Banuka", "0721440872", "yasas@email.com"}, {"M002", "Tehan Romesh", "0124578963", "tehan@email.com"}
    };

    //Added a member count to keep track of members
    static int memberCount = memberArray.length;

    // Dummy Data for the issueBookArray
    static String issueBooksArray [][] = {
        {"M001", "B010", "2024-11-21"}
    };

    //Added a issue count to keep track of issuing books
    static int issueBookCount = issueBooksArray.length;

    // Easier to access the scanner from any method
    private static Scanner sc = new Scanner(System.in);

// -- Login-Section-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void loginValidator() {
        // To clear the console
        clearConsole();
        //Login Validator
        while (true) {
            //Login validator header style
            System.out.println();
            System.out.println("============================================================\n");
            System.out.printf("%43s", "Welcome to LibraryPro \n");
            System.out.println("\n============================================================");
            System.out.println();
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
                delay("Authenticating");
                clearConsole();
                System.out.println("Error: Invalid username or password, Try again!");
                continue;
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
            header("Manage Books");
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
            header("Manage Books");
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
                // Resizes the array inorder to fit new data
                if(bookArray.length <= bookCount){
                    bookArray = resizeArray();
                }

                bookArray[bookCount][0] = bookId;

                System.out.println();
                System.out.print("Enter title         :    ");
                sc.nextLine(); // Consumes the left previous line
                bookArray[bookCount][1] = sc.nextLine();

                System.out.println();
                System.out.print("Enter Author        :    ");
                bookArray[bookCount][2] = sc.nextLine();

                System.out.println();
                System.out.print("Enter Genre         :    ");
                bookArray[bookCount][3] = sc.nextLine();

                System.out.println();
                System.out.print("Enter Quantity (Must be a positive value)      :    ");
                bookArray[bookCount][4] = sc.next();
                System.out.println();

                if (Integer.parseInt(bookArray[bookCount][4]) < 0) {
                    delay("Loading");
                    clearConsole();
                    System.out.println();
                    System.out.println("Error:  Quantity can't be a negative value, Try again!");
                    break;
                }

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
            header("Manage Books");
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
                    if (bookArray[i][0] != null && bookArray[i][0].equals(bookId)) {
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
                bookArray[index][1] = sc.nextLine();

                System.out.println();
                System.out.print("Enter Author        :    ");
                bookArray[index][2] = sc.nextLine();

                System.out.println();
                System.out.print("Enter Genre         :    ");
                bookArray[index][3] = sc.nextLine();

                System.out.println();
                System.out.print("Enter Quantity (Must be a positive value)      :    ");
                bookArray[index][4] = sc.next();
                System.out.println();

                if (Integer.parseInt(bookArray[index][4]) < 0) {
                    delay("Loading");
                    clearConsole();
                    System.out.println();
                    System.out.println("Error:  Quantity can't be a negative value, Try again!");
                    break;
                }

                System.out.println("\n+----------------------------------------------------------+\n");
                delay("Updating");
                System.out.println();
                clearConsole();
                System.out.println("Book details updated successfully");

                break;
            }
        }
    }

    // Can delete a certain book
    public static void deleteBook() {
        while (true) {
            header("Manage Books");
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
                    if (bookArray[i][0] != null && bookArray[i][0].equals(bookId)) {
                        index = i;
                        isExisitingBook = true;
                    }
                }
            }

            if (!isExisitingBook) {
                System.out.println("This Book ID doesn't exists, Try again please !");
                break;
            } else {
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
            }
            break;
        }
    }

    // Can search the relevant book
    public static void searchBook() {
        while (true) {
            header("Manage Books");
            System.out.println();
            System.out.println("Search Book");
            System.out.println("------------------------------------------------------------\n");

            System.out.print("Enter Book ID to search       :    ");
            String bookId = sc.next();

            int index = 0;
            boolean isExisitingBook = false;
            //Finds the BookId array
            for (int i = 0; i < bookArray.length; i++) {
                for (int j = 0; j < bookArray.length; j++) {
                    if (bookArray[i][0] != null && bookArray[i][0].equals(bookId)) {
                        index = i;
                        isExisitingBook = true;
                    }
                }
            }

            if (!isExisitingBook) {
                System.out.println("This Book doesn't exists!");
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
            System.out.println();
            
            break;
        }
    }

    // Can see every book in a tabular format
    public static void viewAllBooks() {
        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("\t\t\t\t\t\t\t\tView All Books");
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
            System.out.println();

            break;
        }
    }

//----Members------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    // Manage Members
    public static void manageMembers() {
        int option = 0;
        while (option != 6) {
            header("Manage Members");
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
                    System.out.println();
                    System.out.println("Error:  Invalid Option, Please Try again!");
                    delay("Loading");
                    break;
            }
        }
    }

    //Adds a Member to the collection
    public static void addMember() {
        while (true) {    
            header("Manage Members");
            System.out.println();
            System.out.println("Add Member");
            System.out.println("------------------------------------------------------------\n");

            System.out.print("Enter Member ID       :    ");
            String memberId = sc.next();

            //Checks if the Member exists already
            boolean isExisistingMember = checkMemberDuplicate(memberId);
            if (isExisistingMember) {
                continue;
            } else {

                // Resizes the array inorder to fit new data
                if(memberArray.length <= memberCount){
                    memberArray = resizeMemberArray();
                }

                memberArray[memberCount][0] = memberId;
                
                System.out.println();
                System.out.print("Enter Name         :    ");
                sc.nextLine(); // Consumes the left previous line
                memberArray[memberCount][1] = sc.nextLine();

                System.out.println();
                System.out.print("Enter Contact Number        :    ");
                int memberContact = sc.nextInt();

                if (memberContact < 0100000000 || memberContact > 9999999999L) {
                    System.out.println();
                    System.out.println("Invalid phone number, Please try again!");
                    continue;  // Loop back to allow the user to input again
                }
                memberArray[memberCount][2] = Integer.toString(memberContact);

                sc.nextLine();
                System.out.println();
                System.out.print("Enter Email         :    ");
                String memberEmail = sc.nextLine();

                if (!(memberEmail.contains("@") && memberEmail.contains("."))) {
                    System.out.println();
                    System.out.println("Invalid email, Please try again!");
                    continue;
                }

                memberArray[memberCount][3] = memberEmail;
                System.out.println();

                //Increment Member count
                memberCount++;
                
                System.out.println("\n+----------------------------------------------------------+\n");
                delay("Adding");
                System.out.println();
                clearConsole();
                System.out.println("Member Successfully added to the collection");
                
                break;
            }
        }
    }

    // Updates an entered Member
    public static void updateMember() {
        while (true) {
            header("Manage Members");
            System.out.println();
            System.out.println("Update Member");
            System.out.println("------------------------------------------------------------\n");

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
                System.out.println("This Member ID doesn't exists, Try again please !");
                break;
            } else {
                System.out.println();
                System.out.print("Enter Name         :    ");
                sc.nextLine(); // Consumes the left previous line
                memberArray[index][1] = sc.nextLine();

                System.out.println();
                System.out.print("Enter Contact Number        :    ");
                int memberContact = sc.nextInt();

                if (memberContact < 0100000000 || memberContact > 9999999999L) {
                    System.out.println();
                    System.out.println("Invalid phone number, Please try again!");
                    continue;  // Loop back to allow the user to input again
                }
                memberArray[index][2] = Integer.toString(memberContact);

                sc.nextLine();
                System.out.println();
                System.out.print("Enter Email         :    ");
                String memberEmail = sc.nextLine();

                if (!(memberEmail.contains("@") && memberEmail.contains("."))) {
                    System.out.println();
                    System.out.println("Invalid email, Please try again!");
                    continue;
                }

                memberArray[index][3] = memberEmail;
                System.out.println();

                System.out.println("\n+----------------------------------------------------------+\n");
                delay("Updating");
                System.out.println();
                clearConsole();
                System.out.println("Member details updated successfully");

                break;
            }
        }
    }

    // Deleting a specific member
    public static void deleteMember() {
        while (true) {
            System.out.println();
            System.out.printf("%35s", "Manage Members");
            System.out.println("\n+==========================================================+\n");
            System.out.println();
            System.out.println("Delete Member");
            System.out.println("------------------------------------------------------------\n");

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
                System.out.println("This Member ID doesn't exists, Try again please !");
                break;
            } else {
                for (int i = index; i < memberCount - 1; i++) {
                    memberArray[i] = memberArray[i + 1];
                }
    
                memberArray[memberCount - 1] = new String[4];
                memberCount--;
    
                System.out.println("\n+----------------------------------------------------------+\n");
                delay("Deleting");
                System.out.println();
                clearConsole();
                System.out.println("Member details deleted successfully");
            }
            
            break;
        }
    }

    // Can search the details of a member
    public static void searchMember() {
        while (true) {
            header("Manage Members");
            System.out.println();
            System.out.println("Search Member");
            System.out.println("------------------------------------------------------------\n");

            System.out.print("Enter Member ID to search       :    ");
            String memberId = sc.next();

            int index = 0;
            boolean isExisistingMember = false;
            //Finds the memberId array
            for (int i = 0; i < memberArray.length; i++) {
                for (int j = 0; j < memberArray.length; j++) {
                    if (memberArray[i][0] == null) {
                        isExisistingMember= false;
                    } else if (memberArray[i][0].equals(memberId)) {
                        index = i;
                        isExisistingMember = true;
                    }
                }
            }

            if (!isExisistingMember) {
                System.out.println("This Member doesn't exists!");
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
            System.out.println();
            
            break;
        }
    }

    // View all members in tabular format
    public static void viewAllMembers() {
        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("\t\t\t\t\t\t\t\tView All Members");
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
            System.out.println();

            break;
        }
    }

//----Issue-Books------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void issueBook() {

        boolean isExisistingMember = false;
        int index = 0;
        boolean isExisistingBook = false;
        
        while (true) {
            header("Issue Books");
            System.out.print("1. Enter Member ID:   ");
            String memberID = sc.next();
            System.out.println();
            
            for (int i = 0; i < memberArray.length; i++) {
                if (memberArray[i][0].equals(memberID)) {
                    isExisistingMember = true;
                }
            }

            if (!isExisistingMember) {
                System.out.println();
                delay("Checking member id");
                System.out.println();
                System.out.println("This Member ID doesn't exists, Try again!");
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
                    System.out.println();
                    delay("Checking book id");
                    System.out.println();
                    System.out.println("This Book ID doesn't exists, Try again!");
                    continue;
                } else {
                    if (issueBooksArray.length <= issueBookCount) {
                        issueBooksArray = resizeIssueBookArray();
                    }

                    //Proccess
                    int qty = Integer.parseInt(bookArray[index][bookArray[index].length - 1]);
                    // Deducts the book quantity
                    if (qty <= 0) {
                        delay("Checking");
                        System.out.println();
                        System.out.println("Book Quantity is not sufficient!");
                        continue;
                    } else {
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
                        System.out.println();
                        System.out.println("Book issued successfully");
                        System.out.println("Issuing recorded in the system.");
                        System.out.println();

                        System.out.println("Remaining Book Stock:   " + bookArray[index][bookArray[index].length - 1]);
                    }
                    break;
                }
            }   
        }
    }

//----Issue-Books------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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
                System.out.println();
                delay("Checking book id");
                System.out.println();
                System.out.println("This Book is not issued, Try again!");
                continue;
            } else {
                System.out.print("2. Enter Member ID:   ");
                String memberID = sc.next();
                System.out.println();

                if (issueBooksArray[index][0] != null && issueBooksArray[index][0].equals(memberID)) {
                    isExisistingMember = true;
                }

                if (!isExisistingMember) {
                    System.out.println();
                    delay("Checking member id");
                    System.out.println();
                    System.out.println("This Member didn't bought any books with the id of "+ bookID +", Try again!");
                    continue;
                } else {
                    String dueDateInput = issueBooksArray[index][2];

                    // Gets Current Date
                    LocalDate today = LocalDate.now();
                    //Converts the due date into a proper format
                    LocalDate dueDate = LocalDate.parse(dueDateInput);

                    int differenceInDays = today.getDayOfMonth() - dueDate.getDayOfMonth();

                    //Deletes the current details in the array once returned
                    for (int i = index; i < issueBookCount - 1; i++) {
                        issueBooksArray[i] = issueBooksArray[i + 1];
                    }
                    issueBooksArray[issueBookCount - 1] = new String[3];
                    issueBookCount--;

                    //Calculates the fine
                    double fine = 0.0;

                    for (int i = 0; i <= differenceInDays; i++) {
                        fine += 50.0;
                    }

                    System.out.println("\n+----------------------------------------------------------+\n");
                    delay("Returning");
                    System.out.println();

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

    // Outputs a designed header
    public static void header(String title) {
        System.out.println();
        System.out.printf("%35s", title);
        System.out.println("\n+==========================================================+\n");
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

    // Increases the size of the arrays
    public static String [][] resizeArray() {
        String newArray[][] = new String[bookArray.length + 1][5];
        for (int i = 0; i < bookArray.length; i++) {
            newArray[i] = bookArray[i];
        }
        return newArray;
    }  

    public static String [][] resizeMemberArray() {
        String newArray[][] = new String[memberArray.length + 1][4];
        for (int i = 0; i < memberArray.length; i++) {
            newArray[i] = memberArray[i];
        }
        return newArray;
    }    

    public static String [][] resizeIssueBookArray() {
        String newArray[][] = new String[issueBooksArray.length + 1][4];
        for (int i = 0; i < issueBooksArray.length; i++) {
            newArray[i] = issueBooksArray[i];
        }
        return newArray;
    }

    // Check duplicates in both arrays
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
    public static boolean checkMemberDuplicate(String memberId) {
        //Checks if the book exists already
        boolean isExisistingMembers = false;
        for (int i = 0; i < memberCount; i++) {
            if (memberArray[i][0].equals(memberId)) {
                isExisistingMembers = true;
                System.out.println();
                delay("Loading");
                clearConsole();
                System.out.println();
                System.out.println("Error:  The Member ID already exists, Please Try another one!");
                System.out.println();
            }
        }
        return isExisistingMembers;
    }
}