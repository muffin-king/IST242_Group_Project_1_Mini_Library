import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<Book> library = new ArrayList<>();
        //load data TODO: fix long input on Book
        Book book0 = new Book("Clean Code", "Robert C. Martin", 2008, "Prentice Hall", 	9780132350884);
        Book book1 = new Book("Effective Java", "Joshua Bloch", 2018, "Addison-Wesley", 9780134685991);
        Book book2 = new Book ("Introduction to Algorithms", "Cormen, Leiserson, Rivest, Stein", 2009, "MIT Press", 9780262033848); //4
        Book book3 = new Book("Design Patterns", "Cormen, Leiserson, Rivest, Stein", 1994, "Addison-Wesley", 9780201633610); //3)
        Book book4 = new Book("Head First Java", "Kathy Sierra, Bert Bates", 2005, "O'Reilly", 9780596009205); //4
        Book book5 = new Book("Java Concurrency in Practice", "Goetz et al.", 2006, "Addison-Wesley", 9780321349606)); //5

        //add books to library array
        library.add(book0); //0
        library.add(book1); //1
        library.add(book2); //2
        library.add(book3); //3
        library.add(book4); //4
        library.add(book5); //5

        int libraryCount = 5; //arraylist length
        int input;

        //MENU LOOP
        do{
            System.out.println("===Menu===");
            System.out.println("1) List all\n2) Search by title\n3) Search by author \n4) Add a book\n5) Update publisher (by ISBN) \n6)  Delete book (by ISBN) \n7) Show statistics\n 0) QUIT");

            input = scnr.nextInt();

            if(input == 1){ //List all
                for(int i = 0; i < libraryCount; i++){
                    Book current = library.get(i);
                    current.toString();
                }
            }else if(input == 2){ //Search by title
                System.out.println("Enter Name: ");
                String lookFor = scnr.nextLine();
                for(int i = 0; i < libraryCount; i++){
                    Book current = library.get(i);
                    String currName = current.getName();
                    if(currName.equalsIgnoreCase(lookFor)){
                        current.toString();
                    }
                }
            }else if(input == 3){ //search by author
                System.out.println("Enter Author's Name: ");
                String lookFor = scnr.nextLine();
                for(int i = 0; i < libraryCount; i++){
                    Book current = library.get(i);
                    String currName = current.getAuthor();
                    if(currName.equalsIgnoreCase(lookFor)){
                        current.toString();
                    }
                }
            }else if(input == 4){ // add book
                String title;
                String author;
                int year;
                String publisher;
                long isbn;
                libraryCount++;
                boolean valid = false;
                do {
                    System.out.println("Enter title: ");
                    title = scnr.nextLine();
                    valid = nullValidation(title);
                }while(!valid);
                do {
                    System.out.println("Enter author: ");
                    author = scnr.nextLine();
                    valid = nullValidation(author);
                }while(!valid);
                do {
                    System.out.println("Enter year: ");
                    year = scnr.nextInt();
                    valid = yearValidation(year);
                }while(!valid);
                do{
                    System.out.println("Enter publisher: ");
                    publisher = scnr.nextLine();
                    valid = nullValidation(publisher);
                }while(!valid);
                do{
                    System.out.println("Enter publisher: ");
                    isbn = scnr.nextLong();
                    valid = isbnValidation(isbn);
                }while(!valid);

                Book add = new Book(title, author, year, publisher, isbn);
                library.add(add); /* the object can be named
                 whatever, even the same thing since we wont be accessing the name,
                 just the library location (unless im wrong lmao pls say something if so) */2
            }else if(input == 5){ //TODO: update publisher (by isbn)

            }else if(input == 6){ // delete
                System.out.println("Enter ISBN of book to delete: ");
                long lookFor = scnr.nextLong();
                for(int i = 0; i < libraryCount; i++){
                    Book current = library.get(i);
                    long currISBN = current.getISBN();
                    if(currISBN == lookFor){ //if ISBN match
                        library.remove(current); //remove object from library arraylist
                    }
                }

            }else if(input == 7){ //TODOD: show stats

            }else if(input == 0){ //QUIT
                System.exit(0);
            }

        }while(input != 0);

    }

    public static boolean yearValidation(int year){
        boolean valid = true;
        if((year < 1400) || (year > 2100)){
            valid = false;
            System.out.println("Please enter a year between 1400-2100. ");
        }
        return valid;
    }

    public static boolean nullValidation(String input){
        boolean valid = true;
        if(input.isBlank()){
            valid = false;
            System.out.println("Please enter a string. ");
        }
        return valid;
    }

    public static boolean isbnValidation(long isbn){ //TODO
        boolean valid = false;
            //ISBNs must be unique AND must be exactly 10 or 13 digits (ignore spaces/dashes)
        return valid;
    }
}
