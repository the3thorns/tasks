package clases;

public class task {
    private String title, description, objectives;
    private date deadline;

    public task(String title, String description, String objectives, date deadline){
        this.title = title;
        this.description = description;
        this. objectives = objectives;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getObjectives() {
        return objectives;
    }
    public date getDeadline() {
        return deadline;
    }

    public String toString(){
        return ""; //Añadir
    }
}
