package by.jonline.grow.end.exercise1.dao;

import by.jonline.grow.end.exercise1.bean.User;
import by.jonline.grow.end.exercise1.exception.DataNotFoundException;

import java.io.*;

public class UserDao implements Dao {

    private static String path = "F:\\Java-online-training\\src\\by\\jonline\\grow\\end\\exercise1\\resources\\users.txt";

    public void saveRecord(Object o) throws IOException {

        User user = (User) o;

        try (FileWriter w = new FileWriter(path, true);
             BufferedWriter write = new BufferedWriter(w)
        ) {

            write.write('#' + user.getLogin() + "\n" + user.getPassword() + "\n" + "--------\n");

        }
    }

    public Object getRecord(String login) throws IOException, DataNotFoundException {

        User user = new User();

        try (FileReader r = new FileReader(path);
             BufferedReader read = new BufferedReader(r)
        ) {

            do {
                if (read.read() == '#') {

                    if (login.equals(read.readLine())) {

                        user.setLogin(login);
                        user.setPassword(read.readLine());
                        return user;
                    }

                }

            } while (read.readLine() != null);

        }

       throw new DataNotFoundException("такого пользователя нет");

    }

}
