package BeanClasses;

import java.io.File;

public class LibrarianChild extends Librarian{
    private File fileName;

    public File getFileName() {
        return fileName;
    }

    public void setFileName(File fileName) {
        this.fileName = fileName;
    }
}
