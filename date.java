import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class date {
    private int age;
    private int day;
    private int month;
    private int year;
    public date(){
        this.day=1;
        this.month=1;
        this.year=1;
    }
    public date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public void setDay(int day){
        this.day=day;
    }
    public int getDay(){
        return day;
    }
    public void setMonth(int month){
        this.month=month;
    }
    public int getMonth(){
        return month;
    }public void setYear(int year){
        this.year=year;
    }
    public int getYear(){
        return year;
    }
    public void age(){
        LocalDate today= LocalDate.now();
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedToday = today.format(formatter);
        StringTokenizer st_today=new StringTokenizer (formattedToday, ".");
        int[] num_today=new int[3];
        for (int i=0; i<3; i++){
            num_today[i]=Integer.parseInt(st_today.nextToken());
        }
        this.age=0;
        if (this.year<num_today[2]){
            this.age=num_today[2]-this.year;
            if (this.month>num_today[1]){
                this.age--;
            }
            if (this.month==num_today[1]){
                if (this.day>num_today[0]){
                    this.age--;
                }
            }
        }
        else if ((this.year==num_today[2]) && ((num_today[1]>this.month) || ((num_today[1]==this.month) && (num_today[0]>=this.day)))){
            this.age=0;
        }
        else {
            System.out.println("Возраст не может быть определён");
            this.age = -1;
        }
    }
    public void print_date(){
        if (this.age>=0){
            System.out.print("Возраст: ");
            if ((this.age%10==0) || (this.age%10>=5) || ((this.age%100>=11) && (this.age%100<=19))){
                System.out.println(this.age + " лет");
            }
            else if (this.age%10==1){
                System.out.println(this.age + " год");
            }
            else{
                System.out.println(this.age + " года");
            }
        }
    }
}
