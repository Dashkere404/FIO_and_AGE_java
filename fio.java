
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class fio {
    private String name;
    private String surname;
    private String patronymic;
    public fio(){
        this.name="Иван";
        this.surname="Иванов";
        this.patronymic="Иванович";
    }
    public fio(String name, String surname, String patronymic) {
        this.name=name;
        this.surname=surname;
        this.patronymic=patronymic;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName() {
        return this.name;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public String getSurname() {
        return this.surname;
    }public void setPatronymic(String patronymic){
        this.patronymic=patronymic;
    }
    public String getPatronymic() {
        return this.patronymic;
    }
    public void print_fio(){
        System.out.println(this.name + " " + this.surname.charAt(0) + "." + this.patronymic.charAt(0) + ".");
        if (this.patronymic.endsWith("ч")){
            System.out.println("Пол: мужской");
        }
        else if (this.patronymic.endsWith("а")){
            System.out.println("Пол: женский");
        }
        else {
            System.out.println("Пол определить не удалось");
        }
    }

}
