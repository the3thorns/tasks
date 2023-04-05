package clases;

import clases.exceptions.CorruptedAgendaException;
import clases.exceptions.PriorityConflictException;
import clases.exceptions.TaskDoesNotExistException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class agenda {
    private task[] tasks;
    private int nTasks;
    public agenda(){
        tasks = new task[10];
        nTasks = 0;
    }
    public agenda(int len){
        tasks = new task[len];
        nTasks = 0;
    }
    public void add(task t)
            throws PriorityConflictException {
        if (tasks[t.getPriority() - 1] != null)
            throw new PriorityConflictException();
        if (nTasks == tasks.length){
            task[] n = new task[tasks.length + 1];
            for (int i = 0; i < nTasks; i++) {
                n[i] = tasks[i];
            }
            tasks = n;
        }
        tasks[t.getPriority() - 1] = t;
        nTasks++;
    }
    public void delete(int pos){
        task[] aux = new task[tasks.length];
        int auxPos = 0;
        for (int i = 0; i < nTasks; i++) {
            if (i == pos){
                continue;
            }
            aux[i] = tasks[i];
            auxPos++;
        }
        tasks = aux;
    }
    public task getTask(int pos)
            throws TaskDoesNotExistException {
        if (tasks[pos] == null || pos >= nTasks)
            throw new TaskDoesNotExistException();
        return tasks[pos];
    }
    public int getLength(){
        return tasks.length;
    }
    public void changePriority(int prior1, int prior2) {
        tasks[prior1 - 1].setPriority(prior2);
        tasks[prior2 - 1].setPriority(prior1);
        task aux = tasks[prior1 - 1];
        tasks[prior1 - 1] = tasks[prior2 - 1];
        tasks[prior2 - 1] = aux;
    }
    public int getNTasks(){
        return nTasks;
    }
    public String toString(){
        String c = "";
        for (int i = 0; i < nTasks; i++) {
            if (tasks[i] != null)
                c+= String.format("| #%d -> %s: DEADLINE: %S |  ", tasks[i].getPriority(), tasks[i].getTitle(), tasks[i].getDeadline().toString());
        }
        return c;
    }
    public static void create(String route){
        try{
            File obj = new File(route);
            if (obj.createNewFile())
                System.out.println("New agenda created!!");
        }catch (IOException e){
            System.out.println("An error occurred");
        }
    }
    public void load(String route)
            throws FileNotFoundException,
            CorruptedAgendaException, PriorityConflictException {
        Scanner scanner = new Scanner(new File(route));

        String title, desc;
        int prior, day, month, year;

        while (scanner.hasNext()){
            prior = scanner.nextInt();
            scanner.nextLine();
            if (tasks[prior + 1] != null)
                throw new CorruptedAgendaException();
            //System.out.println(prior);
            title = scanner.next();
            scanner.nextLine();
            //System.out.println(title);
            desc = scanner.nextLine();
            //System.out.println(desc);
            day = scanner.nextInt();
            scanner.nextLine();
            //System.out.println(day);
            month = scanner.nextInt();
            scanner.nextLine();
            //System.out.println(month);
            year = scanner.nextInt();
            //System.out.println(year);

            date d = new date(day, month, year);
            task t = new task(title, desc, d, prior);
            this.add(t);
        }
        scanner.close();
    }
    public void save(String route) {
        String c = "";
        for (int i = 0; i < nTasks; i++) {
            c += String.format("%d\n%s\n%s\n%d\n%d\n%d\n",tasks[i].getPriority(),tasks[i].getTitle(), tasks[i].getDescription(),
                    tasks[i].getDeadline().getDay(),tasks[i].getDeadline().getMonth(), tasks[i].getDeadline().getYear());
        }
        try{
            FileWriter saver = new FileWriter(route);
            saver.write(c);
            saver.close();
        }catch (IOException e) {
            System.out.println("An error occurred");
        }


    }
    /**
     *      DATA.TXT FORMAT
     * __nTasks__       (int) -> Deprecated
     *    SPECIFIC TASK FORMAT
     * **************************
     *| __priority__    (int)   |
     *|__title__        (String)|
     *| __description__ (String)|
     *| __day__         (int)   |
     *| __month__       (int)   |
     *| __year__        (int)   |
     * **************************
     *
     */
}