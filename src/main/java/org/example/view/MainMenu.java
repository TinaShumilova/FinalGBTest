package org.example.view;

import org.example.view.comands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI){
        commandList = new ArrayList<>();
        commandList.add(new GetInfo(consoleUI));
        commandList.add(new Load(consoleUI));
        commandList.add(new AddBook(consoleUI));
        commandList.add(new AddMagazine(consoleUI));
        commandList.add(new AddLetter(consoleUI));
        commandList.add(new FindByName(consoleUI));
        commandList.add(new FindByID(consoleUI));
        commandList.add(new Save(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List of commands:\n");
        for (int i = 0; i < commandList.size() ; i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
