package Models;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class DbWriter implements Runnable{
    private String fileName;
    @Override
    public void run() {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(DbModel.getInstance().getStudentList());
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public DbWriter(String fileName) {
        this.fileName = fileName;
    }
}
