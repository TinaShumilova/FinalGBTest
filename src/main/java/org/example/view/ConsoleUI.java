package org.example.view;

import org.example.presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Error input";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }
    @Override
    public void start() {
        System.out.println("Hello!");
        while (work){
            System.out.println(menu.menu());
            execute();
        }
    }

    public void finish(){
        System.out.println("Goodbye");
        work = false;
    }

    public void getInfo() {
        System.out.println(presenter.getInfo());
    }

    public void addBook(){
        System.out.println("Add books's title");
        String title = scanner.nextLine();
        System.out.println("Add books's author name");
        String authorName = scanner.nextLine();
        presenter.addBook(authorName, title);
    }

    public void addMagazine() {
        System.out.println("Add magazine's title");
        String title = scanner.nextLine();
        System.out.println("Add magazine's publish house");
        String publisherName = scanner.nextLine();
        presenter.addMagazine(publisherName, title);
    }

    public void addLetter() {
        System.out.println("Add letter's title");
        String title = scanner.nextLine();
        System.out.println("Add letter's author name");
        String letterAuthorName = scanner.nextLine();
        presenter.addLetter(letterAuthorName, title);

    }

    public void getByName() {
        System.out.println("Add author's name");
        String name = scanner.nextLine();
        System.out.println(presenter.getByName(name));
    }

    public void getByID() {
        System.out.println("Add object's ID");
        String id = scanner.nextLine();
        System.out.println(presenter.getByID(id));
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }
    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private boolean checkCommand(int numCommand){
        if (numCommand < menu.getSize()+1){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private void inputError(){
        System.out.println(INPUT_ERROR);
    }


    public void save() throws IOException {
        System.out.println("Add file's name");
        String filename = scanner.nextLine();
        presenter.save(filename);
        System.out.println("File is saved as "+ filename);
    }

    public void load() throws ClassNotFoundException, IOException {
        System.out.println("Write file's name");
        String filename = scanner.nextLine();
        presenter.load(filename);
    }

}
