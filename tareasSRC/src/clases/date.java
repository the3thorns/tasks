package clases;

public class date {
    private int day, month, year;

    public date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof date))
            return false;
        date d = (date) other;
        return day == d.day &&
                month == d.month &&
                year == d.year;
    }

    public String toString(){
        return day + "/" + month + "/" + year;
    }
}
