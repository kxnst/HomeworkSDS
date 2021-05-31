package Controllers;

import Classes.Student;
import Models.DbModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ReadStudentsController extends Controller{

    private static ReadStudentsController controller;

    private static BufferedReader reader;

    public static ReadStudentsController getController(BufferedReader reader) {
        if(controller==null)
            controller = new ReadStudentsController(reader);
        return controller;
    }
    public ReadStudentsController(BufferedReader reader){
        super(reader);

    }

    @Override
    public void IndexAction() throws IOException {
        List<Student> students = DbModel.getInstance().Read();
        for (Student student: students) {
            System.out.println(student);
        }
    }
}
