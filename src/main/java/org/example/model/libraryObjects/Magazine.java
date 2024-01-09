package org.example.model.libraryObjects;

import java.io.Serializable;

public class Magazine implements Serializable,GroupItem<Magazine >  {
    private long id;
    private String publishingHouse;
    private String title;

    public Magazine(String publishingHouse, String title){
        id = -1;
        this.publishingHouse = publishingHouse;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id)  {
        this.id = id;
    }

    public String getName() {
        return publishingHouse;
    }

    public void setName(String publishingHouse) {
        this.publishingHouse = publishingHouse;
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
        sb.append(", magazine's publishing house name: ");
        sb.append(publishingHouse);
        sb.append(", magazine's title: ");
        sb.append(title);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if(!(obj instanceof Magazine)){
            return false;
        }
        Magazine magazine = (Magazine) obj;
        return magazine.getId() == getId();
    }
}
