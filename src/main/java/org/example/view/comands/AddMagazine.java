package org.example.view.comands;

import org.example.view.ConsoleUI;

public class AddMagazine extends Command {

    public AddMagazine(ConsoleUI consoleUI) {
        super("Add magazine", consoleUI);

    }

    @Override
    public void execute() {
        super.getConsoleUI().addMagazine();
    }
}