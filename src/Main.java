import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //TODO literally everything
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<Book> library = new ArrayList<>();
        //load data
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

            }else if(input == 5){ //update publisher (by isbn)

            }else if(input == 6){ // delete

            }else if(input == 7){ // show stats

            }else if(input == 0){ //QUIT
                System.exit(0);
            }

        }while(input != 0);

    }
}
