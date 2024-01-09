package org.example.model.libraryObjects;

import java.io.Serializable;

public class Book implements Serializable,GroupItem<Book> {
    private long id;
    private String nameAuthor;
    private String title;

    public Book(String nameAuthor, String title){
        id = -1;
        this.nameAuthor = nameAuthor;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id)  {
        this.id = id;
    }

    public String getName() {
        return nameAuthor;
    }

    public void setName(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(id);
        sb.append(", book's author name: ");
        sb.append(nameAuthor);
        sb.append(", book's title: ");
        sb.append(title);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if(!(obj instanceof Book)){
            return false;
        }
        Book book = (Book) obj;
        return book.getId() == getId();
    }
}
