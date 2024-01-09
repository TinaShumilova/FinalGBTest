package org.example.view.comands;

import org.example.view.ConsoleUI;

public class AddLetter extends Command {

    public AddLetter(ConsoleUI consoleUI) {
        super("Add letter", consoleUI);

    }

    @Override
    public void execute() {
        super.getConsoleUI().addLetter();
    }
}