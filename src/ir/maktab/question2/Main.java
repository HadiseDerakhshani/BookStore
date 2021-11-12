package ir.maktab.question2;

import ir.maktab.question2.model.Book;
import ir.maktab.question2.service.BookService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        BookService bookService = new BookService();
        Map<String, List<Book>> listMap = bookService.getListBook();
        System.out.println(printFrame(7));
        printLabel();
        System.out.println();
        System.out.println(printFrame(7));
        Set<Map.Entry<String, List<Book>>> entrySet = listMap.entrySet();
        for (Map.Entry<String, List<Book>> mapPrint : entrySet) {
            List<Book> bookList = mapPrint.getValue();
            String authorName = mapPrint.getKey();
            int count = 0;
            for (Book book : bookList) {
                if (count == bookList.size() - 1) {
                    System.out.print("| " + authorName + printSpace("autho"));
                    print(book);
                    System.out.println();
                    System.out.println(printFrame(7));
                    count++;
                } else {
                    System.out.print("|" + printSpace(""));
                    print(book);
                    System.out.println();
                    System.out.println("|" + printFrame(6));
                    count++;
                }
            }

        }

    }

    public static String printFrame(int count) {
        String frame = "";


        for (int i = 0; i < 7; i++) {
            if (i == 3 || i == 4)
                frame += "------------+";
            else if (i == 0 && count == 7)
                frame += "-------------+";
            else if (i == 0 && count == 6)
                frame += "            +";
            else if (i == 6)
                frame += "---------------+";
            else
                frame += "----------+";
        }
        return frame;
    }

    public static void printLabel() {
        String label = "|";
        System.out.print(label + "   Author  ");
        System.out.print(label + "   ISBN    ");
        System.out.print(label + " BookTitle");
        System.out.print(label + " PublishYear");
        System.out.print(label + "    Price   ");
        System.out.print(label + "SoldNumber");
        System.out.print(label + " SoldTotalPrice" + label);

    }

    public static String printSpace(String word) {
        int count = 9 - word.length();
        if (word.equalsIgnoreCase(""))
            count = 12;
        String space = "";
        for (int i = 0; i < count; i++)
            space += " ";
        return space + "|";
    }

    public static void print(Book book) {
        System.out.print(" " + book.getIsbn() + printSpace(String.valueOf(book.getIsbn())));
        System.out.print(" " + book.getTitle() + printSpace(book.getTitle()));
        System.out.print(" " + book.getPublishYear() + printSpace("py"));
        System.out.print(" " + book.getPrice() + printSpace("pbo"));
        System.out.print(" " + book.getSoldNumber() + printSpace(String.valueOf(book.getSoldNumber())));
        System.out.print(" " + (book.getSoldNumber() * book.getPrice()) + printSpace("t"));
    }
}
