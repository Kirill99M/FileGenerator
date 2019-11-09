package ru.Kirill99m.Creator;

import ru.Kirill99m.Model.TableStructure;
import ru.Kirill99m.Model.User;

import java.util.List;

public interface Creation extends TableStructure {
    void createFile(List<User> users);
}
