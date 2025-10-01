import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Book> library = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        //load data
        //load data
        Book book0 = new Book("Clean Code", "Robert C. Martin", 2008, "Prentice Hall", "9780132350884");
        Book book1 = new Book("Effective Java", "Joshua Bloch", 2018, "Addison-Wesley", "9780134685991");
        Book book2 = new Book ("Introduction to Algorithms", "Cormen, Leiserson, Rivest, Stein", 2009, "MIT Press", "9780262033848"); //4
        Book book3 = new Book("Design Patterns", "Cormen, Leiserson, Rivest, Stein", 1994, "Addison-Wesley", "9780201633610"); //3)
        Book book4 = new Book("Head First Java", "Kathy Sierra, Bert Bates", 2005, "O'Reilly", "9780596009205"); //4
        Book book5 = new Book("Java Concurrency in Practice", "Goetz et al.", 2006, "Addison-Wesley", "9780321349606"); //5
        //add books to library array
        library.add(book0); //0
        library.add(book1); //1
        library.add(book2); //2
        library.add(book3); //3
        library.add(book4); //4
        library.add(book5); //5

        //didn't need libraryCount = library.size()
        //instead just use library.size() for every instance of libraryCount

        int input;

        //MENU LOOP
        do{

            System.out.println("\n===Menu===");
            System.out.println("1) List all\n2) Search by title\n3) Search by author \n4) Add a book\n5) Update publisher (by ISBN) \n6) Delete book (by ISBN) \n7) Show statistics\n0) QUIT");
            System.out.print("Enter your choice: ");
            input = scnr.nextInt();
            scnr.nextLine();
            System.out.println();
            if(input == 1){ //List all
                for(int i = 0; i < library.size(); i++){
                    Book current = library.get(i);
                    System.out.println(current);
                }
            }else if(input == 2){ //Search by title
                System.out.print("Enter Name: ");
                String lookFor = scnr.nextLine();
                for(int i = 0; i < library.size(); i++){
                    Book current = library.get(i);
                    String currName = current.getName();
                    if(currName.equalsIgnoreCase(lookFor)){
                        System.out.println(current);
                    }
                }
            }else if(input == 3){ //search by author
                System.out.println("Enter Author's Name: ");
                String lookFor = scnr.nextLine();
                for(int i = 0; i < library.size(); i++){
                    Book current = library.get(i);
                    String currName = current.getAuthor();
                    if(currName.equalsIgnoreCase(lookFor)){
                        System.out.println(current);
                    }
                }
            }else if(input == 4){ // add book
                String title;
                String author;
                int year;
                String publisher;
                String isbn;

                boolean valid = false;


                do {
                    System.out.print("Enter title: ");
                    title = scnr.nextLine();
                    valid = nullValidation(title);
                }while(!valid);
                do {
                    System.out.print("Enter author: ");
                    author = scnr.nextLine();
                    valid = nullValidation(author);
                }while(!valid);
                do {
                    System.out.print("Enter year: ");
                    year = scnr.nextInt();
                    scnr.nextLine();
                    valid = yearValidation(year);
                }while(!valid);
                do{
                    System.out.print("Enter publisher: ");
                    publisher = scnr.nextLine();
                    valid = nullValidation(publisher);
                }while(!valid);
                do{
                    System.out.print("Enter ISBN: ");
                    isbn = scnr.nextLine();
                    valid = isbnValidation(isbn);
                }while(!valid);



                Book add = new Book(title, author, year, publisher, isbn);
                library.add(add);
            }else if(input == 5){ //TODO: update publisher (by isbn)
                System.out.print("Enter ISBN of book to update: ");
                String isbnInput = scnr.nextLine();
                String cleanISBN = isbnInput.replaceAll("[-\\s]", ""); //cleans isbn from user
                boolean found = false;

                for (Book b: library){
                    if (b.getISBN().equals(cleanISBN)){
                        found = true;
                        System.out.print("Enter the new publisher: ");
                        String newPublisher = scnr.nextLine();

                        while (newPublisher.isBlank()){ //makes sure the user actually inputs something
                            System.out.print("Please enter the new publisher, cannot be blank");
                            newPublisher = scnr.nextLine();
                        }

                        b.setPublisher(newPublisher); //replaces old publisher with new one
                        System.out.println("Publisher update success!");
                    }
                }
                if (!found){
                    System.out.println("ISBN is not in the library, please try again or make sure its already in the library!");
                }



            }else if(input == 6){ // delete

                System.out.print("Enter ISBN of book to delete: ");
                String lookFor = scnr.nextLine().replaceAll("[-\\s]","");

                boolean found = false;

                for(int i = 0; i < library.size(); i++){
                    Book current = library.get(i);
                    if(current.getISBN().equals(lookFor)) {
                        library.remove(i);
                        found = true;
                        System.out.println("Book deleted successfully!");

                    }
                }
                if(!found){
                    System.out.print("No book found with that ISBN please try again or make sure the ISBN is correct.");
                }

            } else if(input == 7) { // stats

                int earliest = book0.getYear();
                int latest = book0.getYear();
                for(Book book : library) {
                    if(book.getYear() < earliest) earliest = book.getYear();
                    if(book.getYear() > latest) latest = book.getYear();
                }

                System.out.println("Earliest publication year: " + earliest);
                System.out.println("Latest publication year: " + latest);

                ArrayList<String> publishers = new ArrayList<>();
                for(Book book : library) {
                    if(!publishers.contains(book.getPublisher())) {
                        publishers.add(book.getPublisher());
                        int count = 0;
                        for (Book bookB : library) {
                            if (bookB.getPublisher().equalsIgnoreCase(book.getPublisher())) {
                                count++;
                            }
                        }
                        System.out.println(book.getPublisher() + ": " + count + " book(s)");
                    }
                }

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

    public static boolean isbnValidation(String isbn){ //TODO
        boolean valid = false;
        int step1 = 0;
        //ISBNs must be unique AND must be exactly 10 or 13 digits (ignore spaces/dashes)
        if(isbn.length() == 10 || isbn.length() == 13){
            step1 = 1;
        }
        for (int i = 0; i < library.size(); i++) {
            Book current = library.get(i);
            String currISBN = current.getISBN();
            if(currISBN.equalsIgnoreCase(isbn)){
                return false;
            }
        }
        if(step1 == 1){
            valid = true;
        }
        return valid;
    }
}
