package ru.fizteh.fivt.students.piakovenko.filemap;

import ru.fizteh.fivt.students.piakovenko.shell.Commands;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Pavel
 * Date: 27.10.13
 * Time: 10:17
 * To change this template use File | Settings | File Templates.
 */
public class Size implements Commands {
    private final String name = "size";
    private DataBase db;

    public Size (DataBase dataBase) {
        db = dataBase;
    }

    public String getName() {
        return name;
    }

    public void perform(String[] args) throws IOException {
        if (db == null) {
            System.out.println("no table");
            return;
        }
        if (args.length != 1) {
            throw new IOException("Wrong number of arguments! Usage: size");
        }
        db.size();
    }
}
