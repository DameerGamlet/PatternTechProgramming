package Strategy;

/*
* Стратегия — поведенческий шаблон проектирования, предназначенный для определения семейства алгоритмов, инкапсуляции
* каждого из них и обеспечения их взаимозаменяемости. Это позволяет выбирать алгоритм путём определения соответствующего класса.
* Шаблон Strategy позволяет менять выбранный алгоритм независимо от объектов-клиентов, которые его используют.
*
* Применимость: когда нужно использовать разные вариации.
*               когда есть множество похожих классов
*               когда не интересуют детали реализцаии алгоритмов
*
* (+) - замена на лету - изолирует код - уход от наследования к делегированию - принцип открытости/закрытости
* (-) - усложнет код за счёт дополнительных классов - клиент должен знать в чём состоит разника между стратегиями
* */

import java.util.Scanner;

//курс валюты
interface CourseCurrencies{
    double finalValues(int countMoney);
}
class Dollar_Rub implements CourseCurrencies{
    double dollar = 77.17;
    @Override
    public double finalValues(int countdollar) {
        double finalVal = countdollar / dollar;
        int FullDollar = (int)finalVal; //доллары
        double Cente = finalVal - FullDollar; //центы

        System.out.println(" По курсу доллара в " + dollar + ": "
                + countdollar + " рублей можно получить за " + FullDollar + " долларов и "
                + String.format("%.2f",Cente).replace("0,", "") + " центов");
        return finalVal;
    }
}
class Euro_Rub implements CourseCurrencies{
    double euro = 91.78;
    @Override
    public double finalValues(int counteuro) {
        double finalVal = counteuro / euro;
        int FullEuro = (int)finalVal; //евро
        double Cente = finalVal - FullEuro; //центы
        System.out.println(" По курсу евро в " + euro + ": "
                + counteuro + " рублей можно получить за " + FullEuro + " евро и "
                + String.format("%.2f",Cente).replace("0,", "") + " центов");
        return finalVal;
    }
}
class Ukr_Rub implements CourseCurrencies{
    double hryvnia = 2.77;
    @Override    public double finalValues(int counthryvnia) {
        double finalVal = counthryvnia / hryvnia;
        System.out.println(" По курсу гривны в " + hryvnia + ": "
                + counthryvnia + " рублей можно получить за " + (int)finalVal + " гривны");
        return finalVal;
    }
}
class Cny_Rub implements CourseCurrencies{
    double yuan = 11.76;
    @Override
    public double finalValues(int countyuan) {
        double finalVal = countyuan / yuan;
        System.out.println(" По курсу юаней в " + yuan + ": "
                + countyuan + " рублей можно получить за " + (int)finalVal + " юаней");
        return finalVal;
    }
}
class Krw_Rub implements CourseCurrencies{
    double won = 68.88;
    @Override
    public double finalValues(int countwon) {
        double finalVal = countwon / won;
        System.out.println(" По курсу вон в " + won + ": "
                + countwon + " рублей можно получить за " + (int)finalVal + " вон");
        return finalVal;
    }
}
class Yen_Rub implements CourseCurrencies{
    double yen = 0.7;
    @Override
    public double finalValues(int countyen) {
        double finalVal = countyen / yen;
        System.out.println(" По курсу йен в " + yen + ": "
                + countyen + " рублей можно получить за " + (int)finalVal + " йен");
        return finalVal;
    }
}
class Byr_Rub implements CourseCurrencies{
    double whiterub = 29.2;
    @Override
    public double finalValues(int countbyr) {
        double finalVal = countbyr / whiterub;
        System.out.println(" По курсу бел.рублей в " + whiterub + ": "
                + countbyr + " рублей можно получить за " + (int)finalVal + " белорусскийх рублей");
        return finalVal;
    }
}

class ContextStrategy{
    private CourseCurrencies course;
    public ContextStrategy(){

    }
    public void setCourse(CourseCurrencies course){
        this.course = course;
    }
    public double executeResult(int countMoney){
        return course.finalValues(countMoney);
    }
}

public class Strategy {
    public static void main(String[] args) {
        ContextStrategy context = new ContextStrategy();

        System.out.println(" ... Добро пожаловать на биржу, на что вы бы хотели поменять свои рубли:? ... ");

        int switchCount = -1;
        do {
            System.out.println(" Выберите из представленного ниже списка нужный вариант: ");
            System.out.println(" 1: Доллары\n 2: Евро\n 3: Воны\n 4: Йены\n 5: Гривны\n 6: Беларусские рубли\n 7: Юани");
            System.out.print( " Выбор: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> context.setCourse(new Dollar_Rub());
                case 2 -> context.setCourse(new Euro_Rub());
                case 3 -> context.setCourse(new Krw_Rub());
                case 4 -> context.setCourse(new Yen_Rub());
                case 5 -> context.setCourse(new Ukr_Rub());
                case 6 -> context.setCourse(new Byr_Rub());
                case 7 -> context.setCourse(new Cny_Rub());
                default -> System.out.println(" Выбор такой валюты недоступен!!! ");
            }
            int count;
            double sumMoney;
            if(choice >= 1 && choice <= 7){
                System.out.print(" ... \n Введите сумму денег, которую вы хотите проверить: ");
                Scanner scannerCountMoney = new Scanner(System.in);
                count = scannerCountMoney.nextInt();
                sumMoney = context.executeResult(count);
            }
            System.out.println("\n Хотите прололжить?... \n Выберите: (yes / no)");
            Scanner scanner1 = new Scanner(System.in);
            String yesno = scanner1.nextLine();
            if(yesno.equals("yes")){
                switchCount = 1;
            }
            else {
                switchCount = 0;
            }
        } while (switchCount != 0);
    }
}