package ir.maktab.question2.model;


import lombok.Data;

import java.util.Objects;

@Data
public class Book {
    private int id;
    private String authorName;
    private int isbn;
    private String title;
    private int publishYear;
    private int price;
    private int soldNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && isbn == book.isbn && publishYear == book.publishYear && price == book.price && soldNumber == book.soldNumber && Objects.equals(authorName, book.authorName) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorName, isbn, title, publishYear, price, soldNumber);
    }

    @Override
    public String toString() {
        return "Book{" +
                ", authorName='" + authorName + '\'' +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                ", publishYear=" + publishYear +
                ", price=" + price +
                ", soldNumber=" + soldNumber +
                '}';
    }

   /* @Override
    public int compareTo(Book book) {
        return Integer.compare(publishYear,book.getPublishYear()*-1);
    }*/
}
