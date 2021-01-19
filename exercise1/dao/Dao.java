package by.jonline.grow.end.exercise1.dao;

import by.jonline.grow.end.exercise1.exception.DataNotFoundException;

import java.io.IOException;

public interface Dao {

    void saveRecord(Object o) throws  IOException;
    Object getRecord(String name) throws IOException, DataNotFoundException;

}
