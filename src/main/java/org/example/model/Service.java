package org.example.model;

import org.example.model.fileWriter.FileHandler;
import org.example.model.fileWriter.Writable;
import org.example.model.libraryFond.Library;
import org.example.model.libraryObjects.Book;
import org.example.model.libraryObjects.GroupItem;
import org.example.model.libraryObjects.Letter;
import org.example.model.libraryObjects.Magazine;

import java.io.IOException;
import java.util.List;

public class Service<E extends GroupItem<E>> {
    private Writable writable;
    private Library<E> library;



    public Service(Library<E> library){
        this.library = library;
    }
    public Service(){
        library = new Library<E>();
    }

    public Library<E> getActiveLibrary() {
        return library;
    }

    public void addBook(String name, String title){
        Book book = new Book(name, title);
        library.add((E) book);
    }

    public void addMagazine(String publisherName, String title) {
        Magazine magazine = new Magazine(publisherName, title);
        library.add((E) magazine);
    }

    public void addLetter(String letterAuthorName, String title) {
        Letter letter = new Letter(letterAuthorName, title);
        library.add((E) letter);
    }

    public List<E> getByName(String name) {
        return library.getByName(name);
    }

    public void save(String filename) throws IOException {
        writable = new FileHandler(filename);
        writable.saveFile(library);
    }

    public Library load(String filename) throws IOException, ClassNotFoundException {
        writable = new FileHandler(filename);
        library = writable.loadFile();
        return library;
    }

    public E getByID(String id) {
        return library.getById(Integer.valueOf(id));

    }

}

