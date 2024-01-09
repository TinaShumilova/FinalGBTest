package org.example.model.fileWriter;

import org.example.model.libraryFond.Library;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writable {
    void saveFile(Library library) throws IOException;
    Library loadFile() throws FileNotFoundException, ClassNotFoundException, IOException;

}
