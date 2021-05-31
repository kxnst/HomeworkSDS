package Controllers;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class Controller {

    protected static BufferedReader reader;

    public Controller(BufferedReader reader1){
        reader = reader1;
    }

    public abstract void IndexAction() throws IOException;
}
