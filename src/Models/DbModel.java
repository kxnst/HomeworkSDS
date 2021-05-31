package Models;

import Classes.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DbModel{

    private Lock lock;

    private List<Student> studentList = new ArrayList<Student>();
    private static String filename;

    private DbReader reader;
    private DbWriter writer;

    private static DbModel instance;


    public static void setFilename(String name){
        filename = name;
    }
    public static DbModel getInstance(){
        if(instance == null)
            instance = new DbModel();
        return instance;
    }
    private DbModel(){
        lock = new ReentrantLock();
        reader = new DbReader(filename);
        writer = new DbWriter(filename);
    }

    public DbModel setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        return this;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public synchronized void Write(Student student){
        Runnable task = () -> {
            studentList.add(student);
            try {
                lock.lock();
                Thread thread = new Thread(writer);
                thread.setName("writer");
                thread.run();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                lock.unlock();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
    public synchronized List<Student> Read(){
        Runnable task = () -> {
            try {
                lock.lock();
                Thread thread = new Thread(reader);
                thread.setName("reader");
                thread.run();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                lock.unlock();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        return studentList;
    }
}
