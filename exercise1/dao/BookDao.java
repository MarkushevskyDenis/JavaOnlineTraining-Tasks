package by.jonline.grow.end.exercise1.dao;

import by.jonline.grow.end.exercise1.bean.Book;
import by.jonline.grow.end.exercise1.exception.DataNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements Dao {

    private static String path = "F:\\Java-online-training\\src\\by\\jonline\\grow\\end\\exercise1\\resources\\books.txt";

    public void saveRecord(Object o) throws IOException {

        Book book = (Book) o;

        try (FileWriter w = new FileWriter(path, true);
             BufferedWriter write = new BufferedWriter(w)
        ) {

            write.write('#' + book.getName() + "\n" + book.getNote() + "\n" + "--------\n");

        }


    }

    public Object getRecord(String name) throws IOException, DataNotFoundException {
        Book book = new Book();

        try (FileReader r = new FileReader(path);
             BufferedReader read = new BufferedReader(r)
        ) {

            do {
                if (read.read() == '#') {

                    if (name.equals(read.readLine())) {

                        book.setName(name);
                        book.setNote(read.readLine());
                        return book;
                    }

                }

            } while (read.readLine() != null);

        }

        throw new DataNotFoundException("такой книги нет");
    }

    public List<Object> getRecords(int start, int end) throws IOException {

        List<Object> records = new ArrayList<>();
        int i = 1;

        try (FileReader r = new FileReader(path);
             BufferedReader read = new BufferedReader(r)
        ) {

            do {
                if (read.read() == '#') {

                    if (i >= start) {
                        records.add(new Book(read.readLine(), read.readLine()));
                    } else {
                        read.readLine();
                        read.readLine();
                    }

                    i++;
                }

            } while (read.readLine() != null && i < end);

        }

        return records;
    }
}
