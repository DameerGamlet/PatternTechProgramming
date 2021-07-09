package AbstractFactory;

/*
* Абстрактная фабрика — порождающий шаблон проектирования, предоставляет интерфейс для создания семейств взаимосвязанных
*  или взаимозависимых объектов, не специфицируя их конкретных классов. Шаблон реализуется созданием абстрактного класса Factory,
*  который представляет собой интерфейс для создания компонентов системы (например, для оконного интерфейса он может создавать
*  окна и кнопки). Затем пишутся классы, реализующие этот интерфейс.
* */

public class AbstractFactory {
    interface PrivateHouses{
        String nameHouse();
        int AveragePriceHouse();
        String materialsHouse();
        int AverageSquareHouse();
    }
    interface Cottages{
        String nameCot();
        int AveragePriceCot();
        String materialsCot();
        int AverageSquareCot();
    }
    interface Villas{
        String nameVil();
        int AveragePriceVil();
        String materialsVil();
        int AverageSquareVil();
    }
    interface Penthouses{
        String namePent();
        int AveragePricePent();
        String materialsPent();
        int AverageSquarePent();
    }
    interface Townhouses{
        String nameTown();
        int AveragePriceTown();
        String materialsTown();
        int AverageSquareTown();
    }

    interface AbsFactoryHouses{
        PrivateHouses getPrivateHouses();
        Cottages getCottages();
        Villas getVillas();
        Penthouses getPenthouses();
        Townhouses getTownhouses();
    }

    //ДЕРЕВЯННЫЕ ДОМА
    static  class WonderHouses implements PrivateHouses{
        public String nameHouse(){
            return "Деревянный Частный дом";
        }
        public int AveragePriceHouse(){
            return 40000;
        }
        public String materialsHouse(){
            return "Дерево";
        }
        public int AverageSquareHouse(){
            return 60;
        }
    }
    static class WonderCottages implements Cottages{
        public String nameCot(){
            return "Деревянный Коттедж";
        }
        public int AveragePriceCot(){
            return 75000;
        }
        public String materialsCot(){
            return "Дерево";
        }
        public int AverageSquareCot(){
            return 130;
        }
    }
    static class WonderVillas implements Villas{
        public String nameVil(){
            return "Деревяннная Вилла";
        }
        public int AveragePriceVil(){
            return 120000;
        }
        public String materialsVil(){
            return "Дерево";
        }
        public int AverageSquareVil(){
            return 210;
        }
    }
    static class WonderPenthouses implements Penthouses{
        public String namePent(){
            return "Деревянный Пентхаус";
        }
        public int AveragePricePent(){
            return 150000;
        }
        public String materialsPent(){
            return "Дерево";
        }
        public int AverageSquarePent(){
            return 310;
        }
    }
    static class WonderTownhouses implements Townhouses{
        public String nameTown(){
            return "Деревянный Таунхаус";
        }
        public int AveragePriceTown(){
            return 300000;
        }
        public String materialsTown(){
            return "Дерево";
        }
        public int AverageSquareTown(){
            return 700;
        }
    }
    static class WonderAbsFactoryHouses implements AbsFactoryHouses{
        public PrivateHouses getPrivateHouses(){
            return new WonderHouses();
        }
        public Cottages getCottages(){
            return new WonderCottages();
        }
        public Villas getVillas(){
            return new WonderVillas();
        }
        public Penthouses getPenthouses(){
            return new WonderPenthouses();
        }
        public Townhouses getTownhouses(){
            return new WonderTownhouses();
        }
    }

    //КАМЕННЫЕ ДОМА
    static class StoneHouses implements PrivateHouses{
        public String nameHouse(){
            return "Каменный Частный дом";
        }
        public int AveragePriceHouse(){
            return 55000;
        }
        public String materialsHouse(){
            return "Камень";
        }
        public int AverageSquareHouse(){
            return 80;
        }
    }
    static class StoneCottages implements Cottages{
        public String nameCot(){
            return "Каменный Коттедж";
        }
        public int AveragePriceCot(){
            return 91000;
        }
        public String materialsCot(){
            return "Камень";
        }
        public int AverageSquareCot(){
            return 150;
        }
    }
    static class StoneVillas implements Villas{
        public String nameVil(){
            return "Каменная Вилла";
        }
        public int AveragePriceVil(){
            return 135500;
        }
        public String materialsVil(){
            return "Камень";
        }
        public int AverageSquareVil(){
            return 230;
        }
    }
    static class StonePenthouses implements Penthouses{
        public String namePent(){
            return "Каменный Пентхаус";
        }
        public int AveragePricePent(){
            return 200000;
        }
        public String materialsPent(){
            return "Камень";
        }
        public int AverageSquarePent(){
            return 350;
        }
    }
    static class StoneTownhouses implements Townhouses{
        public String nameTown(){
            return "Каменный Таунхаус";
        }
        public int AveragePriceTown(){
            return 385000;
        }
        public String materialsTown(){
            return "Камень";
        }
        public int AverageSquareTown(){
            return 900;
        }
    }
    static class StoneAbsFactoryHouses implements AbsFactoryHouses{

        public PrivateHouses getPrivateHouses(){
            return new StoneHouses();
        }
        public Cottages getCottages(){
            return new StoneCottages();
        }
        public Villas getVillas(){
            return new StoneVillas();
        }
        public Penthouses getPenthouses(){
            return new StonePenthouses();
        }
        public Townhouses getTownhouses(){
            return new StoneTownhouses();
        }
    }
    //БЕТОННЫЕ ДОМА
    static class ConcreteHouses implements PrivateHouses{
        public String nameHouse(){
            return "Бетонный Частный дом";
        }
        public int AveragePriceHouse(){
            return 50000;
        }
        public String materialsHouse(){
            return "Бетон-цемент";
        }
        public int AverageSquareHouse(){
            return 75;
        }
    }
    static class ConcreteCottages implements Cottages{
        public String nameCot(){
            return "Бетонный Коттедж";
        }
        public int AveragePriceCot(){
            return 88000;
        }
        public String materialsCot(){
            return "Бетон-цемент";
        }
        public int AverageSquareCot(){
            return 135;
        }
    }
    static class ConcreteVillas implements Villas{
        public String nameVil(){
            return "Бетонный Вилла";
        }
        public int AveragePriceVil(){
            return 128000;
        }
        public String materialsVil(){
            return "Бетон-цемент";
        }
        public int AverageSquareVil(){
            return 210;
        }
    }
    static class ConcretePenthouses implements Penthouses{
        public String namePent(){
            return "Бетонный Пентхаус";
        }
        public int AveragePricePent(){
            return 192000;
        }
        public String materialsPent(){
            return "Бетон-цемент";
        }
        public int AverageSquarePent(){
            return 335;
        }
    }
    static class ConcreteTownhouses implements Townhouses{
        public String nameTown(){
            return "Бетонный Таунхаус";
        }
        public int AveragePriceTown(){
            return 360000;
        }
        public String materialsTown(){
            return "Бетон-цемент";
        }
        public int AverageSquareTown(){
            return 800;
        }
    }
    static class ConcreteAbsFactoryHouses implements AbsFactoryHouses{

        public PrivateHouses getPrivateHouses(){
            return new ConcreteHouses();
        }
        public Cottages getCottages(){
            return new ConcreteCottages();
        }
        public Villas getVillas(){
            return new ConcreteVillas();
        }
        public Penthouses getPenthouses(){
            return new ConcretePenthouses();
        }
        public Townhouses getTownhouses(){
            return new ConcreteTownhouses();
        }
    }

    public static void main(String[] args) {
        String materials = "камень"; //"дерево"; //"бетон";

        AbsFactoryHouses absFact = null;

        switch (materials) {
            case "дерево":
                absFact = new WonderAbsFactoryHouses();
                break;
            case "камень":
                absFact = new StoneAbsFactoryHouses();
                break;
            case "бетон":
                absFact = new ConcreteAbsFactoryHouses();
                break;
            default:
                System.out.println("Вы ввели некоректный материал!!!");
                break;
        }
        PrivateHouses prHouse = absFact.getPrivateHouses();
        Cottages cott = absFact.getCottages();
        Villas vill = absFact.getVillas();
        Penthouses pent = absFact.getPenthouses();
        Townhouses town = absFact.getTownhouses();

        int choice = 2;

        switch (choice) {
            case 1 -> {
                System.out.println("Название дома: "        + prHouse.nameHouse());
                System.out.println("Средняя площадь дома: " + prHouse.AverageSquareHouse());
                System.out.println("Средняя цена дома: "    + prHouse.AveragePriceHouse());
                System.out.println("Основной материал: "    + prHouse.materialsHouse());
            }
            case 2 -> {
                System.out.println("Название дома: "        + cott.nameCot());
                System.out.println("Средняя площадь дома: " + cott.AverageSquareCot());
                System.out.println("Средняя цена дома: "    + cott.AveragePriceCot());
                System.out.println("Основной материал: "    + cott.materialsCot());
            }
            case 3 -> {
                System.out.println("Название дома: "        + vill.nameVil());
                System.out.println("Средняя площадь дома: " + vill.AverageSquareVil());
                System.out.println("Средняя цена дома: "    + vill.AveragePriceVil());
                System.out.println("Основной материал: "    + vill.materialsVil());
            }
            case 4 -> {
                System.out.println("Название дома: "        + pent.namePent());
                System.out.println("Средняя площадь дома: " + pent.AverageSquarePent());
                System.out.println("Средняя цена дома: "    + pent.AveragePricePent());
                System.out.println("Основной материал: "    + pent.materialsPent());
            }
            case 5 -> {
                System.out.println("Название дома: "        + town.nameTown());
                System.out.println("Средняя площадь дома: " + town.AverageSquareTown());
                System.out.println("Средняя цена дома: "    + town.AveragePriceTown());
                System.out.println("Основной материал: "    + town.materialsTown());
            }
            case 0 ->{
                System.out.println("Название дома: "        + prHouse.nameHouse());
                System.out.println("Средняя площадь дома: " + prHouse.AverageSquareHouse());
                System.out.println("Средняя цена дома: "    + prHouse.AveragePriceHouse());
                System.out.println("Основной материал: "    + prHouse.materialsHouse());
                System.out.println();
                System.out.println("Название дома: "        + cott.nameCot());
                System.out.println("Средняя площадь дома: " + cott.AverageSquareCot());
                System.out.println("Средняя цена дома: "    + cott.AveragePriceCot());
                System.out.println("Основной материал: "    + cott.materialsCot());
                System.out.println();
                System.out.println("Название дома: "        + vill.nameVil());
                System.out.println("Средняя площадь дома: " + vill.AverageSquareVil());
                System.out.println("Средняя цена дома: "    + vill.AveragePriceVil());
                System.out.println("Основной материал: "    + vill.materialsVil());
                System.out.println();
                System.out.println("Название дома: "        + pent.namePent());
                System.out.println("Средняя площадь дома: " + pent.AverageSquarePent());
                System.out.println("Средняя цена дома: "    + pent.AveragePricePent());
                System.out.println("Основной материал: "    + pent.materialsPent());
                System.out.println();
                System.out.println("Название дома: "        + town.nameTown());
                System.out.println("Средняя площадь дома: " + town.AverageSquareTown());
                System.out.println("Средняя цена дома: "    + town.AveragePriceTown());
                System.out.println("Основной материал: "    + town.materialsTown());
            }
            default -> {
                System.out.println("Номер такого дома не существует!!!");
            }
        }





    }
}
