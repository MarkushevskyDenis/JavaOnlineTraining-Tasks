package by.jonline.grow.end.exercise1.view;

import by.jonline.grow.end.exercise1.bean.Book;
import by.jonline.grow.end.exercise1.exception.DataNotFoundException;
import by.jonline.grow.end.exercise1.logic.Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class View {

    public void adminMenu() {

        int ans;
        boolean check = true;


        while (check) {

            System.out.println("1. просмотр книг\n2. поиск книг\n3. добавление книг\n4. выход");

            try {
                ans = getInt();
            } catch (NumberFormatException e) {
                System.out.println("не число");
                ans = 0;
            } catch (IOException e) {
                System.out.println("упс, что-то пошло не так");
                break;
            }
            try {


                switch (ans) {
                    case 1:
                        outBooks();
                        break;
                    case 2:
                        outBook();
                        break;
                    case 3:
                        addBook();
                        break;
                    case 4:
                        check = false;
                        break;
                    default:
                        System.out.println("такого значения нет");
                }
            } catch (IOException e) {
                System.out.println("упс, что-то пошло не так");
            }
        }

    }

    public void userMenu() {

        int ans;
        boolean check = true;


        while (check) {

            System.out.println("1. просмотр книг\n2. поиск книг\n3. выход");

            try {
                ans = getInt();
            } catch (NumberFormatException e) {
                System.out.println("не число");
                ans = 0;
            } catch (IOException e) {
                System.out.println("упс, что-то пошло не так");
                break;
            }


            try {
                switch (ans) {
                    case 1:
                        outBooks();
                        break;
                    case 2:
                        outBook();
                        break;
                    case 3:
                        check = false;
                        break;
                    default:
                        System.out.println("такого значения нет");
                }
            } catch (IOException e) {
                System.out.println("упс, что-то пошло не так");
            }

        }

    }

    public void mainMenu() {

        int ans;
        boolean check = true;

        while (check) {

            System.out.println("1. signUp\n2. signIn\n3. exit");

            try {
                ans = getInt();
            } catch (NumberFormatException e) {
                System.out.println("не число");
                ans = 0;
            } catch (IOException e) {
                System.out.println("упс, что-то пошло не так");
                break;
            }

            try {

                switch (ans) {
                    case 1:
                        signUp();
                        break;
                    case 2:
                        signIn();
                        break;
                    case 3:
                        check = false;
                        break;
                    default:
                        System.out.println("такого значения нет");
                }
            } catch (IOException e) {
                System.out.println("упс. что-то пошло не так");
            } catch (DataNotFoundException e) {
                System.out.println(e);
            }
        }
    }

    public void signUp() throws IOException {
        String login;
        String password;
        Logic logic = new Logic();

        login = getStr("enter login: ");
        password = getStr("enter password: ");

        logic.signUp(login, password);
    }

    public void signIn() throws IOException, DataNotFoundException {
        String login;
        String password;

        Logic logic = new Logic();
        login = getStr("enter login: ");
        password = getStr("enter password: ");

        logic.signIn(login, password);

        if (login.equals("admin")) {
            adminMenu();
        } else {
            userMenu();
        }

    }

    public void outBooks() throws IOException {
        Logic logic = new Logic();
        List<Object> books;
        int i = 1;
        int ans;
        boolean check = true;

        while (check) {

            books = logic.getBooks(i, i + 5);


            for (Object book : books) {
                System.out.println(book.toString());
            }

            if (books.size() != 5) {
                System.out.println("конец");
            }

            ans = getIntAns("<--1;2-->;3exit");
            switch (ans) {
                case 1:
                    if (i - 5 < 1) {
                        i = 1;
                    } else {
                        i -= 5;
                    }
                    break;
                case 2:
                    i += 5;
                    if (books.size() != 5) {
                        i -= 5;
                    }
                    break;
                case 3:
                    check = false;
                    break;
                default:
                    System.out.println("такого значения нет");
            }


        }

    }

    public void outBook() throws IOException {
        Logic logic = new Logic();
        String name;

        name = getStr("введите название книги: ");

        try {
            logic.searchBook(name);
        } catch (DataNotFoundException e) {
            System.out.println(e);
        }
    }

    public void addBook() {
        System.out.println("add");
    }


    public int getIntAns(String text) throws IOException {

        System.out.println(text);
        int ans = 0;
        boolean check = true;

        while (check) {
            try {
                ans = getInt();
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("не число");
            }
        }
        return ans;
    }

    public int getInt() throws IOException, NumberFormatException {
        int ans;
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        ans = Integer.parseInt(read.readLine());
        return ans;
    }

    public String getStr(String text) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(text);
        return read.readLine();

    }

}
