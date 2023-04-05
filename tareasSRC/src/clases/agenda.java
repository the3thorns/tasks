package clases;

import java.io.File;
import java.io.FileNotFoundException;
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
    public void add(task t){
        if (nTasks == tasks.length){
            task[] n = new task[tasks.length * 2];
            for (int i = 0; i < nTasks; i++) {
                n[i] = tasks[i];
            }
            tasks = n;
        }
        tasks[nTasks] = t;
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
    public String toString(){
        String c = "";
        for (int i = 0; i < nTasks; i++) {
            c+= String.format("| #%d -> %s: DEADLINE: %S |", tasks[i].getPriority(), tasks[i].getTitle(), tasks[i].getDeadline().toString());
        }
        return c;
    }

    /**
     *      DATA.TXT FORMAT
     * __nTasks__       (int)
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

    public static agenda create(String route)
            throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(route));
        agenda res = new agenda(scanner.nextInt());

        String title, desc;
        int prior, day, month, year;
        while (scanner.hasNext()){
            prior = scanner.nextInt();
            scanner.nextLine();
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
            res.add(t);
        }
        scanner.close();
        return res;
    }
}