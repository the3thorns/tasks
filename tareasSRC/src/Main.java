import clases.*;
import clases.exceptions.CorruptedAgendaException;
import clases.exceptions.TaskDoesNotExistException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void press(){
        Scanner press = new Scanner(System.in);
        System.out.println("Presiona 1: ");
        int a = press.nextInt();
        while (a != 1){
            System.out.println("Presiona 1: ");
            a = press.nextInt();
        }
    }
    public static void main(String[] args)
            throws FileNotFoundException,
            TaskDoesNotExistException,
            CorruptedAgendaException {
        agenda estudio = new agenda();
        estudio.load("/home/the3thorns/Escritorio/tasks/tareasSRC/data.txt");
        System.out.println(estudio);
        date d = new date(26, 6, 2026);
        task t = new task("prueba", "¿Se guarda?", d, 2);
        estudio.add(t);
        System.out.println(estudio.getNTasks());
        System.out.println(estudio.toString());
        System.out.println(estudio.getTask(0).toString());
        System.out.println(estudio.getNTasks());
    }
}