import clases.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
            throws FileNotFoundException {
        agenda estudio = agenda.create("/home/the3thorns/Escritorio/tasks/tareasSRC/data.txt");
        System.out.println(estudio);
        try {
            System.out.println(estudio.getTask(0));
        }catch (TaskDoesNotExistException e){
            System.out.println("The task does not exist");
        }

    }
}