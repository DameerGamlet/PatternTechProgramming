package Decorator;

/*
* Декоратор — структурный шаблон проектирования, предназначенный для динамического подключения дополнительного поведения к объекту.
* Шаблон декоратор предоставляет гибкую альтернативу практике создания подклассов с целью расширения функциональности.
* */

interface Dish_and_Drink{
    String nameDish();
    int PriceFor100gram(int price);
    double Weigth(int weigth);
    int FinalyPrice();
}
class Begin implements Dish_and_Drink{

    @Override
    public String nameDish() {
        return "... Чек - меню: \n ------------------------------";
    }

    @Override
    public int PriceFor100gram(int price) {
        return 0;
    }

    @Override
    public double Weigth(int weigth) {
        return 0;
    }

    @Override
    public int FinalyPrice() {
        return 0;
    }
}

class SoupDish implements Dish_and_Drink{

    static int price;
    static double weight;
    Dish_and_Drink dish;

    public SoupDish(Dish_and_Drink dish){
        this.dish = dish;
    }

    @Override
    public String nameDish() {
        return this.dish.nameDish() + "\n- Суп";
    }
    @Override
    public int PriceFor100gram(int priceSD) {
        SoupDish.price = priceSD;
        return priceSD;
    }

    @Override
    public double Weigth(int weightHD) {
        SoupDish.weight = (double)weightHD / 100;
        return weight;
    }

    @Override
    public int FinalyPrice() {
        int finalPrice = (int)(price * weight);
        return this.dish.FinalyPrice() + finalPrice;
    }
}

class HotDish implements Dish_and_Drink{

    static int price;
    static double weigth;
    Dish_and_Drink dish;

    public HotDish(Dish_and_Drink dish){
        this.dish = dish;
    }

    @Override
    public String nameDish() {
        return this.dish.nameDish() + "\n- Горячее блюдо ";
    }

    @Override
    public int PriceFor100gram(int priceHD) {
        price = priceHD;
        return price;
    }

    @Override
    public double Weigth(int weigthHD) {
        weigth = (double)weigthHD / 100;
        return weigth;
    }

    @Override
    public int FinalyPrice() {
        int finalPrice = (int)(price * weigth);
        return this.dish.FinalyPrice() + finalPrice;
    }
}

//ВТОРОЕ
class Dessert implements Dish_and_Drink{

    static int price;
    static double weigth;
    Dish_and_Drink dish;

    public Dessert(Dish_and_Drink dish){
        this.dish = dish;
    }

    @Override
    public String nameDish() {
        return this.dish.nameDish() + "\n- Десерт ";
    }

    @Override
    public int PriceFor100gram(int priceHD) {
        price = priceHD;
        return price;
    }

    @Override
    public double Weigth(int weigthHD) {
        weigth = (double)weigthHD / 100;
        return weigth;
    }

    @Override
    public int FinalyPrice() {
        int finalPrice = (int)(price * weigth);
        return this.dish.FinalyPrice() + finalPrice;
    }
}

class Salat implements Dish_and_Drink{

    static int price;
    static double weigth;
    Dish_and_Drink dish;

    public Salat(Dish_and_Drink dish){
        this.dish = dish;
    }

    @Override
    public String nameDish() {
        return this.dish.nameDish() + "\n- Десерт ";
    }

    @Override
    public int PriceFor100gram(int priceHD) {
        price = priceHD;
        return price;
    }

    @Override
    public double Weigth(int weigthHD) {
        weigth = (double)weigthHD / 100;
        return weigth;
    }

    @Override
    public int FinalyPrice() {
        int finalPrice = (int)(price * weigth);
        return this.dish.FinalyPrice() + finalPrice;
    }
}

//НАПИТКИ
class HotDrink implements Dish_and_Drink{

    int price;
    double weigth;
    Dish_and_Drink dish;

    public HotDrink(Dish_and_Drink dish){
        this.dish = dish;
    }

    @Override
    public String nameDish() {
        return this.dish.nameDish() + "\n- Горячий напиток";
    }

    @Override
    public int PriceFor100gram(int priceHDr) {
        this.price = priceHDr;
        return priceHDr;
    }

    @Override
    public double Weigth(int weigthHDr) {
        this.weigth = (double)(weigthHDr / 100);
        return weigthHDr;
    }

    @Override
    public int FinalyPrice() {
        int finalPrice = (int)(price * weigth);
        return this.dish.FinalyPrice() + finalPrice;
    }
}
class ColdDrink implements Dish_and_Drink{

    int price;
    double weigth;
    Dish_and_Drink dish;

    public ColdDrink(Dish_and_Drink dish){
        this.dish = dish;
    }

    @Override
    public String nameDish( ) {
        return this.dish.nameDish() + "\n- Холодный напиток";
    }

    @Override
    public int PriceFor100gram(int priceCDr) {
        this.price = priceCDr;
        return priceCDr;
    }

    @Override
    public double Weigth(int weigthHDr) {
        this.weigth = (double)(weigthHDr / 100);
        return weigthHDr;
    }

    @Override
    public int FinalyPrice() {
        int finalPrice = (int)(price * weigth);
        return this.dish.FinalyPrice() + finalPrice;
    }
}

public class DecoratorPattern{
    public static void main(String[] args) {
        Dish_and_Drink menu = new Begin(); //null, 0, 0, 0
        int tempPrice;
        int tempWeigth;
        int PriceBorscht = 110;

        //добавляем первое блюдо
        menu = new SoupDish(menu);
        menu.PriceFor100gram(PriceBorscht);
        tempWeigth = 400;
        menu.Weigth(tempWeigth);

        //добавляем первое блюдо
        menu = new SoupDish(menu);
        PriceBorscht = 110;
        tempWeigth = 350;
        menu.PriceFor100gram(PriceBorscht);
        menu.Weigth(tempWeigth);

        //добавляем первое блюдо
        menu = new SoupDish(menu);
        PriceBorscht = 120;
        tempWeigth = 200;
        menu.PriceFor100gram(PriceBorscht);
        menu.Weigth(tempWeigth);

        //добавляем новое блюдо
        menu = new HotDish(menu);
        tempPrice = 180;
        tempWeigth = 700;
        menu.PriceFor100gram(tempPrice);
        menu.Weigth(tempWeigth);

        //покупаем десерт
        menu = new Dessert(menu);
        tempPrice = 150;
        tempWeigth = 150;
        menu.PriceFor100gram(tempPrice);
        menu.Weigth(tempWeigth);

        //покупаем напитки
        int priceCola = 24;
        int weigthCola = 400;
        menu = new ColdDrink(menu);
        menu.PriceFor100gram(priceCola);
        menu.Weigth(weigthCola);

        menu = new ColdDrink(menu);
        menu.PriceFor100gram(priceCola);
        menu.Weigth(weigthCola);

        menu = new ColdDrink(menu);
        menu.PriceFor100gram(priceCola);
        menu.Weigth(weigthCola);

        menu = new ColdDrink(menu);
        menu.PriceFor100gram(priceCola);
        menu.Weigth(weigthCola);

        menu = new ColdDrink(menu);
        menu.PriceFor100gram(priceCola);
        menu.Weigth(weigthCola);

        //выводим список набраных продуктов
        System.out.println(menu.nameDish());
        System.out.println("--------------------");
        //выводим финальную стоимость
        System.out.println("Итоговая цена: " + menu.FinalyPrice());
    }
}
