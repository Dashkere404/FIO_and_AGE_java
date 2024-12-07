import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class MainString {
    public static void main(String args[]){
        fio Fio=new fio();
        System.out.println("Введите свои ФИО");
        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                String fio = sc.nextLine();
                if (fio.matches(".*\\d.*")) {
                    throw new IllegalArgumentException("Ввод должен содержать только слова.");
                }
                StringTokenizer st = new StringTokenizer(fio, " ");
                String[] FIO=new String[3];
                for (int i=0; i<3; i++){
                    FIO[i]=st.nextToken();
                }
                Fio.setName(FIO[0]);
                Fio.setSurname(FIO[1]);
                Fio.setPatronymic(FIO[2]);
                break;
            }
            catch (NoSuchElementException ne){
                System.err.println("ФИО не может быть пустым");
                System.out.println("Введите свои ФИО");
            }
            catch(IllegalArgumentException ie){
                System.err.println("Ошибка: " + ie.getMessage());
                System.out.println("Введите свои ФИО");
            }
        }
        date DATE=new date();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату в формате: ДД.ММ.ГГГГ");
        while (true) {
            String date_born = sc.nextLine();
            try {
                String pattern="dd.MM.yyyy";
                DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
                LocalDate tmp = LocalDate.parse(date_born, format);
                if (tmp.getDayOfMonth() != Integer.parseInt(date_born.split("\\.")[0])) {
                    throw new DateTimeParseException("", "", 0);
                }
                DATE.setDay(tmp.getDayOfMonth());
                DATE.setMonth(tmp.getMonthValue());
                DATE.setYear(tmp.getYear());
                DATE.age();
                break;
            }
            catch(DateTimeParseException e){
                System.err.println("Такой даты не существует");
                System.out.println("Введите дату в формате: ДД.ММ.ГГГГ");
            }
            catch (NumberFormatException ne) {
                System.err.println("Пожалуйста, введите дату в формате ДД.ММ.ГГГГ");
                System.out.println("Введите дату в формате: ДД.ММ.ГГГГ");
            }
            catch (InputMismatchException e) {
                System.err.println("Ошибка: Неверный ввод. Пожалуйста, введите корректные данные.");
                System.out.println("Введите дату в формате: ДД.ММ.ГГГГ");
            }
            catch (NoSuchElementException ne){
                System.err.println("Дата не может быть пустой");
                System.out.println("Введите дату в формате: ДД.ММ.ГГГГ");
            }
        }
        Fio.print_fio();
        DATE.print_date();
    }
}
