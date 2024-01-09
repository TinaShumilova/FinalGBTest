package org.example.presenter;

import org.example.model.Service;
import org.example.model.libraryFond.Library;
import org.example.model.libraryObjects.Book;
import org.example.view.View;

import java.io.IOException;
import java.util.List;

public class Presenter<E> {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public Library<Book> getInfo() {
        return service.getActiveLibrary();
    }

    public void addBook(String authorName, String title) {
        service.addBook(authorName, title);
    }

    public void addMagazine(String publisherName, String title) {
        service.addMagazine(publisherName, title);
    }

    public void addLetter(String letterAuthorName, String title) {
        service.addLetter(letterAuthorName, title);
    }

    public List<E> getByName(String name) {
        return service.getByName(name);
    }

    public void save(String filename) throws IOException {
        service.save(filename);
    }

    public void load(String filename) throws IOException, ClassNotFoundException {
        service.load(filename);
    }

    public E getByID(String id) {
        return (E) service.getByID(id);
    }

}
