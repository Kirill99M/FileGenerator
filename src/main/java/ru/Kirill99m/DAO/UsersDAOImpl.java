package ru.Kirill99m.DAO;

import ru.Kirill99m.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersDAOImpl implements UsersDAO {
    @Override
    public List<User> getUsers() {
        Scanner in = new Scanner(System.in);
        int numberUsers = in.nextInt();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < numberUsers; i++) {
            users.add(new User());
        }
        return users;
    }
}
