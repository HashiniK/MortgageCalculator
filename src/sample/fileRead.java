package sample;

import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileRead {
    public static TextArea readfile(String filename, TextArea lbltext) throws FileNotFoundException {

        Scanner scanner= new Scanner(new File(filename));
        while (scanner.hasNext()){
            String line1 = scanner.nextLine();
            lbltext.appendText(line1+"\n");
        }
        scanner.close();
        return lbltext;
    }

}
