import Controllers.Controller;
import Controllers.NewStudentController;
import Controllers.ReadStudentsController;
import Models.DbModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static DbModel dbModel;
    private static final String enterFile = "Enter DB file name";
    private static final String menu = "Actions:\r\n 1 - Get list of students\r\n 2 - Create new student\r\n 3 - Exit";

    private static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        while(true){
            System.out.println(enterFile);
            reader = new BufferedReader(
                    new InputStreamReader(System.in));
            String name = reader.readLine();
            if(name.length()!=0){
                File db= new File("src/Models", name);
                DbModel.setFilename(name);
                dbModel = DbModel.getInstance();
                try{
                    if(!db.exists())
                        db.createNewFile();
                } catch (Exception e){}
                break;
            }
        }
        DbModel.getInstance().Read();
        Run();
    }
    public static void Run() throws IOException{
        System.out.println(menu);
        String command = reader.readLine();
        boolean exit = false;
        switch (command) {
            case "1":
                Controller controller = ReadStudentsController.getController(reader);
                controller.IndexAction();
                break;
            case "2":
                Controller controller1 = NewStudentController.getController(reader);
                controller1.IndexAction();
                break;
            case "3":
                exit = true;
                break;
        }
        if(!exit)
            Run();
    }
}
