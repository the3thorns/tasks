import clases.*;
public class Main {
    static void texto(){
        int iter;
        iter = 5;
        String text = "Bolas: desmaius xdddd";
        String c = "";
        for (int i = 0; i < text.length() + 4; i++) {   //El cuatro es por la cantidad de caracteres adicionales respecto de text (String)
            c+="*";
        }
        c+="\n";
        c+="| " + text + " |";
        System.out.println(c);
    }
    public static void main(String[] args) {
        date d = new date(2, 2, 2010);
        task f = new task("titulo" ,"hola mundo booof", d);
        System.out.println(f.toString());
    }
}