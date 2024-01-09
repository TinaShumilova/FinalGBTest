package org.example.view.comands;

import org.example.view.ConsoleUI;

public class Finish extends Command{

    public Finish(ConsoleUI consoleUI){
        super("Finish", consoleUI);

    }
    @Override
    public void execute(){
        super.getConsoleUI().finish();
    }
}
