package DesignPatternPractice.IteratorPattern;

public class Main {
    public static void main(String[] args){
        BookShelf bookShelf = new BookShelf(2);
        bookShelf.addBook(new Book("AnyTime"));
        bookShelf.addBook(new Book("Bible"));
        bookShelf.addBook(new Book("Cherry"));

        BookIterator it = bookShelf.iterator();
        while (it.hasNext()){
            Book book = (Book)it.next();
            System.out.println(book.getName());
        }
    }
}
