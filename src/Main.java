import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        char c;
        CashMachine cashMachine = new CashMachine(10, 10, 10);
        do {
            System.out.println("Введите команду. Для вывода списка команд введите i. Для завершения работы введите q");
            c = scan1.next().charAt(0);
            switch (c) {
                case 'q' -> System.out.println("Завершение работы");
                case 's' -> cashMachine.setMoney();
                case 'g' -> cashMachine.getMoney();
                case 'i' -> System.out.println("""
                        Список команд
                        s - снять деньги
                        g - внести деньги
                        i - список команд
                        q - завершение работы""");
                default -> System.out.println("Неизвестная команда");
            }
        } while (c != 'q');
        scan1.close();
    }
}