package org.example.view.comands;

import org.example.view.ConsoleUI;

public class FindByID extends Command {

    public FindByID(ConsoleUI consoleUI) {
        super("Find object by ID", consoleUI);

    }

    @Override
    public void execute() {
        super.getConsoleUI().getByID();
    }
}