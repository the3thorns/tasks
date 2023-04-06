
import clases.*;
import clases.exceptions.CorruptedAgendaException;
import clases.exceptions.PriorityConflictException;
import clases.exceptions.TaskDoesNotExistException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void taskCreatorWizard(agenda agen){
        Scanner creator = new Scanner(System.in);
        String t, des;
        int d, m, a, prior;
        System.out.println("Inserta la prioridad de tu tarea: ");
        prior = creator.nextInt();
        creator.nextLine();
        System.out.println("Inserta un título para la tarea: ");
        t = creator.nextLine();
        System.out.println("Inserta una descripción: ");
        des = creator.nextLine();
        System.out.println("\nInserta la fecha");
        System.out.println("Día: ");
        d = creator.nextInt();
        creator.nextLine();
        System.out.println("Mes: ");
        m = creator.nextInt();
        creator.nextLine();
        System.out.println("Año: ");
        a = creator.nextInt();
        creator.nextLine();

        date dat = new date(d, m, a);
        task tas = new task(t, des, dat, prior);
        try {
            agen.add(tas);
        }catch (PriorityConflictException e){
            System.out.println("// CONFLICTO DE PRIORIDADES DETECTADO //");
            System.out.println("// ANULANDO OPERACIÓN //\n");
        }
    }
    public static void agendaWorkOpen(String ag)
            throws CorruptedAgendaException,
            FileNotFoundException,
            TaskDoesNotExistException,
            PriorityConflictException {
        Scanner work = new Scanner(System.in);
        int workEntry = 0;
        int pr1, pr2;
        System.out.println("//ABRIENDO//");
        agenda a = new agenda();
        a.load("/home/the3thorns/Escritorio/tasks/agendaData/" + ag + ".txt");
        System.out.println("//AGENDA ABIERTA SIN ERRORES//\n");
        while (workEntry != 6) {
            System.out.println("\t1- Ver agenda");
            System.out.println("\t2- Ver tarea");
            System.out.println("\t3- Cambiar prioridad de tareas ½");
            System.out.println("\t4- Añadir tarea (+)");
            System.out.println("\t5- Finalizar tarea (-)");
            System.out.println("\t6- Guardar y cerrar agenda ←");
            System.out.print("»»»»»»\t");
            workEntry = work.nextInt();

            switch (workEntry) {
                case 1:
                    System.out.println(a);
                    break;
                case 2:
                    System.out.println("Inserta prioridad de la tarea: ");
                    System.out.println(a.getTask(work.nextInt() - 1));
                    break;
                case 3:

                    break;
                case 4:
                    taskCreatorWizard(a);
                    break;
                case 5:
                    System.out.println("Inserta prioridad de la tarea: ");
                    a.delete(work.nextInt()); //no funciona
                    break;
            }
        }
        System.out.println("// GUARDANDO AGENDA EN " + "/home/the3thorns/Escritorio/tasks/agendaData/" + ag + ".txt //");
        a.save("/home/the3thorns/Escritorio/tasks/agendaData/" + ag + ".txt");
    }
    public static void main(String[] args)
            throws FileNotFoundException,
            TaskDoesNotExistException,
            CorruptedAgendaException,
            PriorityConflictException {

        Scanner entry = new Scanner(System.in);
        int userEntry = 0;
        System.out.println("¡BIENVENDIO AL MANEJADOR DE AGENDAS POR CONSOLA!");
        while (userEntry != 5){
            System.out.println("Selecciona una de las opciones disponibles");
            System.out.println("\t1- Abre la última agenda usada →");
            System.out.println("\t2- Abre una agenda");
            System.out.println("\t3- Crea una agenda (+)");
            System.out.println("\t4- Borra una agenda (-)");
            System.out.println("\t5- Sal del programa ←");
            System.out.print("»»»»»»\t");
            userEntry = entry.nextInt();
            switch (userEntry) {
                case 1:
                    System.out.println("WORK IN PROGRESS");
                    agendaWorkOpen("");     //Implementar última agenda abierta Ub: ultimaagenda.txt
                    break;
                case 2:
                    System.out.println("¿Qué agenda quieres abrir?");
                    agendaWorkOpen(entry.next());
                    break;
                case 3:
                    System.out.println("WORK IN PROGRESS");     //Crear agenda
                    break;
                case 4:
                    System.out.println("WORK IN PROGRESS");     //Borrar agenda
                    break;
            }
        }
        System.out.println("// CERRANDO EL PROGRAMA //");
    }
}