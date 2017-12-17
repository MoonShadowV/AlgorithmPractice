package DesignPatternPractice.IteratorPattern;

import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Aggregate {
    private List<Book> books;

    public BookShelf(int length) {
        this.books = new ArrayList<Book>(length);
    }

    public Book getBook(int index){
        return this.books.get(index);
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public int getSize(){
        return this.books.size();
    }

    @Override
    public BookIterator iterator() {
        return new BookIterator(this);
    }

}
