package clases;

public class task {
    private String title, description;
    private date deadline;
    private int priority;

    public task(String title, String description, date deadline, int priority){
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public date getDeadline() {
        return deadline;
    }
    public int getPriority() {
        return priority;
    }

    private int biggestLenght(){
        return Math.max(Math.max(title.length() + 8, description.length() + 13), deadline.toString().length() + 7);
    }

    public String toString(){
        String res = "";
        int biggest = biggestLenght();
        for (int i = 0; i < biggest + 4; i++) {
            res+="*";
        }
        res+= "\n" + String.format("| TITLE: %-" + (biggest -7)  +"s |\n", title) +
                String.format("| DESCRIPTION: %-"+ (biggest - 13) + "s |\n", description) +
                String.format("| DATE: %-" + (biggest - 6) + "s |\n", deadline.toString()) +
                res + "\n";

        return res;
    }
}