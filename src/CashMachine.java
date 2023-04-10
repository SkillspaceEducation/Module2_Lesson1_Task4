import java.util.Scanner;

public class CashMachine {
    private int num20;
    private int num50;
    private int num100;

    public CashMachine(int num20, int num50, int num100) {
        this.num20 = num20;
        this.num50 = num50;
        this.num100 = num100;
    }

    public void setMoney() {
        Scanner scan2 = new Scanner(System.in);
        int sum, remain;
        do {
            System.out.println("Введите количество денег. Введите ноль для выхода в основное меню");
            sum = scan2.nextInt();
            if (sum == 0) {
                break;
            } else {
                num100 = num100 + sum / 100;
                num50 = num50 + (sum - sum / 100 * 100) / 50;
                num20 = num20 + (((sum - sum / 100 * 100) % 50) / 20);
                remain = ((sum % 100) % 50) % 20;
                if (remain != 0) {
                    System.out.printf("Не удалось внести часть денег в количестве %d\n", remain);
                } else {
                    System.out.println("Сумма внесена в банкомат");
                }
                sum = 0;
            }
        } while (sum != 0);
    }

    public void getMoney() {
        Scanner scan3 = new Scanner(System.in);
        int sum, cash = 100 * num100 + 50 * num50 + 20 * num20;
        do {
            System.out.printf("""
                    Доступно купюр номиналом 100 - %d
                    Доступно купюр номиналом 50 - %d
                    Доступно купюр номиналом 20 - %d
                    """, num100, num50, num20);
            System.out.println("Введите количество денег для получения. Введите ноль для выхода в основное меню");
            sum = scan3.nextInt();
            if (sum == 0) {
                break;
            } else {
                // расчитываем количество купюр для выдачи
                if (sum < cash) {
                    if (sum >= num100 * 100) {
                        sum -= num100 * 100;
                        System.out.println("Выдано купюр номиналом 100 - " + num100);
                        num100 = 0;
                    } else {
                        num100 -= sum / 100;
                        System.out.println("Выдано купюр номиналом 100 - " + sum / 100);
                        sum -= sum / 100 * 100;
                    }

                    if (sum >= num50 * 50) {
                        sum -= num50 * 50;
                        System.out.println("Выдано купюр номиналом 50 - " + num50);
                        num50 = 0;
                    } else {
                        num50 -= sum / 50;
                        System.out.println("Выдано купюр номиналом 50 - " + sum / 50);
                        sum -= sum / 50 * 50;
                    }

                    if (sum >= num20 * 20) {
                        sum -= num20 * 20;
                        System.out.println("Выдано купюр номиналом 20 - " + num20);
                        num20 = 0;
                    } else {
                        num20 -= sum / 20;
                        System.out.println("Выдано купюр номиналом 20 - " + sum / 20);
                        sum -= sum / 20 * 20;
                    }
                    System.out.println("Получите деньги");
                    if (sum != 0) {
                        System.out.printf("Не удалось выдать количество денег %d\n", sum);
                    }
                } else {
                    System.out.println("В банкомате недостаточно денег");
                    sum = 0;
                }
            }
        } while (sum != 0);
    }
}
