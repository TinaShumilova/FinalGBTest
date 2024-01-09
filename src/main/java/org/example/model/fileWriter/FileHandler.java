package org.example.model.fileWriter;

import org.example.model.libraryFond.Library;

import java.io.*;

public class FileHandler implements Writable {
    private String filename;

    public FileHandler (String filename) {
        this.filename= filename;
    }

    public String getFilename() {
        return filename;
    }
    @Override
    public void saveFile(Library family) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(family);
        out.close();
    }
    @Override
    public Library loadFile() throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        Library tree2 = (Library) in.readObject();
        return tree2;
    }

}
