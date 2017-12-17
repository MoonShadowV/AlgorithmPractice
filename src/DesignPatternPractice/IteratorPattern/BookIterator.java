package DesignPatternPractice.IteratorPattern;

public class BookIterator implements Iterator {
    private BookShelf bookShelf;
    private static int index = 0;

    public BookIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getSize();
    }

    @Override
    public Object next() {
        return bookShelf.getBook(index++);
    }
}
