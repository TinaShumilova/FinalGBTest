package org.example.model.libraryFond;

import org.example.model.libraryObjects.GroupItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Library<E extends GroupItem<E>> implements Serializable {
    private long objectID;
    private List<E> objectList;

    public Library(List<E> objectList){
        this.objectList=objectList;
    }

    public Library(){this(new ArrayList<>());}

    public boolean add(E obj){
        if (obj == null){
            return false;
        }
        if(!objectList.contains(obj)){
            objectList.add(obj);
            obj.setId(++objectID);
            return true;
        }
        return false;
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E obj: objectList){
            if (obj.getName().equalsIgnoreCase(name)){
                res.add(obj);
            }
        }
        return res;
    }

    public E getById(long id){
        for (E obj: objectList){
            if (obj.getId()==id){
                return obj;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Library fond contains ");
        sb.append(objectList.size());
        sb.append(" objects: \n");
        for (E obj: objectList){
            sb.append(obj);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return getInfo();
    }

}
