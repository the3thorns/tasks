package clases;

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
}
