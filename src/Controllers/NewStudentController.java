package Controllers;

import Classes.Student;
import Models.DbModel;

import java.io.BufferedReader;
import java.io.IOException;

public class NewStudentController extends Controller{

    private static NewStudentController controller;

    private final static String enterName = "Enter name:";
    private final static String enterSurname = "Enter surname:";
    private final static String enterCountry = "Enter country:";
    private final static String enterCourse = "Enter course:";
    private final static String enterPerformance = "Enter performance:";
    private final static String enterStudentBook = "Enter student book: (8 numbers)";
    private final static String enterGender = "Enter gender (0 - male, 1 - female):";

    public static NewStudentController getController(BufferedReader reader) {
        if(controller==null)
            controller = new NewStudentController(reader);
        return controller;
    }

    public NewStudentController(BufferedReader reader){
        super(reader);
    }
    @Override
    public void IndexAction() throws IOException {
        Student student = new Student();
        processName(student);
        processSurname(student);
        processCountry(student);
        processCourse(student);
        processPerformance(student);
        processStudentBook(student);
        processGender(student);
        DbModel.getInstance().Write(student);
    }
    private void processName(Student student) throws IOException {
        String name;

        while(true){
            System.out.println(enterName);
            name = reader.readLine();
            if(name.matches("[a-zA-Zа-яА-Я]+")){
                break;
            }
        }
        student.setName(name);
    }
    private void processSurname(Student student) throws IOException {
        String surname;

        while(true){
            System.out.println(enterSurname);
            surname = reader.readLine();
            if(surname.matches("[a-zA-Zа-яА-Я]+")){
                break;
            }
        }
        student.setSurname(surname);
    }
    private void processCountry(Student student) throws IOException {
        String country;

        while(true){
            System.out.println(enterCountry);
            country = reader.readLine();
            if(country.matches("[a-zA-Zа-яА-Я]+")){
                break;
            }
        }
        student.setCountry(country);
    }
    private void processCourse(Student student) throws IOException {
        String course;

        while(true){
            System.out.println(enterCourse);
            course = reader.readLine();
            if(course.matches("[0-5]")){
                break;
            }
        }
        student.setCourse(Integer.parseInt(course));
    }
    private void processPerformance(Student student) throws IOException {
        String performance;

        while(true){
            System.out.println(enterPerformance);
            performance = reader.readLine();
            if(performance.matches("[a-zA-Zа-яА-Я]+")){
                break;
            }
        }
        student.setPerformance(performance);
    }
    private void processStudentBook(Student student) throws IOException {
        String book;

        while(true){
            System.out.println(enterStudentBook);
            book = reader.readLine();
            if(book.matches("[0-9]{8}")){
                break;
            }
        }
        student.setStudentBook(Integer.parseInt(book));
    }
    private void processGender(Student student) throws IOException {
        String gender;

        while(true){
            System.out.println(enterGender);
            gender = reader.readLine();
            if(gender.matches("[0-1]")){
                break;
            }
        }
        student.setGender(Integer.parseInt(gender));
    }


}
