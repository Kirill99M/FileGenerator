package ru.Kirill99m.Creator;

import ru.Kirill99m.DAO.UsersDAO;
import ru.Kirill99m.DAO.UsersDAOImpl;
import ru.Kirill99m.Model.User;

import java.util.List;

public class Creator {
    public static void main(String[] args) {
        UsersDAO usersRepository = new UsersDAOImpl();
        List<User> users = usersRepository.getUsers();
        ExcelCreator excelCreator = new ExcelCreator();
        PdfCreator pdfCreator = new PdfCreator();
        excelCreator.createFile(users);
        pdfCreator.createFile(users);
    }
}
