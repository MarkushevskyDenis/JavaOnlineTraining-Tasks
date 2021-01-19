package by.jonline.grow.end.exercise1.bean;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {

    private String name;
    private String note;

    public Book() {
    }

    public Book(String name, String note) {
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(note, book.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, note);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
