package Models;

import Classes.Student;

import java.io.*;
import java.util.List;

public class DbReader implements Runnable{
    private String fileName;
    @Override
    public void run() {
        ObjectInputStream objectinputstream = null;
        try {
            FileInputStream streamIn = new FileInputStream(fileName);
            objectinputstream = new ObjectInputStream(streamIn);
            List<Student> students = (List<Student>) objectinputstream.readObject();
            DbModel.getInstance().setStudentList(students);
        } catch (Exception e){
            System.out.println(e);
        } finally {
            if(objectinputstream != null){
                try {
                    objectinputstream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public DbReader(String fileName){
        this.fileName = fileName;
    }
}
