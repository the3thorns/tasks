package clases;

public class task {
    private String title, description;
    private date deadline;

    public task(String title, String description, date deadline){
        this.title = title;
        this.description = description;
        this.deadline = deadline;
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

    public String toString(){
        return ""; //Añadir
    }
}
