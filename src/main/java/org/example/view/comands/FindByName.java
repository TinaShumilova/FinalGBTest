package org.example.view.comands;

import org.example.view.ConsoleUI;

public class FindByName extends Command {

    public FindByName(ConsoleUI consoleUI) {
        super("Find object by author's name", consoleUI);

    }

    @Override
    public void execute() {
        super.getConsoleUI().getByName();
    }
}