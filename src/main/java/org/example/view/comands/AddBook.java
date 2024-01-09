package org.example.view.comands;

import org.example.view.ConsoleUI;

public class AddBook extends Command {

    public AddBook(ConsoleUI consoleUI) {
        super("Add Book", consoleUI);

    }

    @Override
    public void execute() {
        super.getConsoleUI().addBook();
    }
}
