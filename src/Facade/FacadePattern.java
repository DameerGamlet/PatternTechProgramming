package Facade;

/*
* Фасад — структурный шаблон проектирования, позволяющий скрыть сложность системы путём сведения всех возможных
* внешних вызовов к одному объекту, делегирующему их соответствующим объектам системы.
* */

//кухня
class Kitchen{
    public void OnLigth(){
        System.out.println(" Включение света на кухне... ");
    }
    public void OffLigth(){
        System.out.println(" На кухне выключается свет... ");
    }

    public void onWaterWashDishes(){
        System.out.println(" Включение воды для мытья посуды... ");
    }
    public void offWaterWashDishes(){
        System.out.println(" Выключение потока воды... ");
    }

    public void onGazForGazStove(){
        System.out.println(" Включение газа для работы с плитой... ");
    }
    public void offGazForGazStove(){
        System.out.println(" Выключение подачи газа... ");
    }

    public void closeAffDoor(){
        System.out.println(" Закрытие всех дверей на кухне... ");
    }
    public void openAffDoor(){
        System.out.println(" Открытие всех дверей на кухне... ");
    }

    public void openWindowKR(){
        System.out.println(" Открыть окно на кухне... ");
    }
    public void closeWindowKR(){
        System.out.println(" Окно на кухне закрывается... ");
    }
}
//спальня
class Bedroom{
    public void OnLigthBR(){
        System.out.println(" Включение света в спальне... ");
    }
    public void OffLigthBR(){
        System.out.println(" В спальне выключается свет... ");
    }

    public void onTV(){
        System.out.println(" Включение телевизора ");
    }
    public void offTV(){
        System.out.println(" Телевизор выключается ");
    }

    public void openWindow(){
        System.out.println(" Открыть окно в спальне... ");
    }
    public void closeWindow(){
        System.out.println(" Окно в спальне закрывается... ");
    }
}
//зал
class Hall{
    public void OnLigthHL(){
        System.out.println(" Включение света в зале... ");
    }
    public void OffLigthHL(){
        System.out.println(" В зале выключается свет... ");
    }

    public void onTVhl(){
        System.out.println(" Включение телевизора ");
    }
    public void offTVhl(){
        System.out.println(" Телевизор выключается ");
    }

    public void openWindowhl(){
        System.out.println(" Открыть окно в зале... ");
    }
    public void closeWindowhl(){
        System.out.println(" Окно в зале закрывается... ");
    }
}
//ванная
class Bath{
    public void OnLigthB(){
        System.out.println(" Включение света в ванной... ");
    }
    public void OffLigthB(){
        System.out.println(" В ванной выключается свет... ");
    }

    public void openWindowB(){
        System.out.println(" Открыть окно в ванной... ");
    }
    public void closeWindowB(){
        System.out.println(" Окно в ванной закрывается... ");
    }

    public void washclothes(){
        System.out.println(" Поставить бельё стираться в стиральной машинке... ");
    }
    public void takeclothes(){
        System.out.println(" Вытащить бельё из стиралки... ");
    }

    public void PutBathroomOnDial(){
        System.out.println(" Вода для купания набиратеся... ");
    }
    public void SetBathroomOnDrain(){
        System.out.println(" Слив воды в ванной... ");
    }
}

class Facade{
    Kitchen kitchen;
    Bedroom bedroom;
    Hall hall;
    Bath bath;

    public Facade(){
        kitchen = new Kitchen();
        bedroom = new Bedroom();
        hall = new Hall();
        bath = new Bath();
        System.out.println(" ******************************** ");
    }

    public void onAllLigth(){
        System.out.println(" Оствеляем все комнаты\n------------------- ");
        kitchen.OnLigth();
        bedroom.OnLigthBR();
        hall.OnLigthHL();
        bath.OnLigthB();
        System.out.println(" ******************************** ");
    }
    public void offAllLigth(){
        System.out.println(" Гасим все лампочки\n------------------- ");
        kitchen.OffLigth();
        bedroom.OffLigthBR();
        hall.OffLigthHL();
        bath.OffLigthB();
        System.out.println(" ******************************** ");
    }
    public void closeAllWindow(){
        System.out.println(" Закрываем все окна\n------------------- ");
        kitchen.closeWindowKR();
        bedroom.closeWindow();
        hall.closeWindowhl();
        bath.closeWindowB();
        System.out.println(" ******************************** ");
    }
    public void openAllWindow(){
        System.out.println(" Проветриваем все комнаты\n------------------- ");
        kitchen.openWindowKR();
        bedroom.openWindow();
        hall.openWindowhl();
        bath.openWindowB();
        System.out.println(" ******************************** ");
    }
    public void onBathplusWash(){
        System.out.println(" Выполняем дела в ванной\n------------------- ");
        bath.PutBathroomOnDial();
        bath.washclothes();
        System.out.println(" ******************************** ");
    }
    public void offBathplusWash(){
        System.out.println(" Заканчиваем дела в ванной\n------------------- ");
        bath.SetBathroomOnDrain();
        bath.takeclothes();
        System.out.println(" ******************************** ");
    }
    public void onTV(){
        System.out.println(" Смотрим телевизоры\n------------------- ");
        hall.onTVhl();
        bedroom.onTV();
        System.out.println(" ******************************** ");
    }
    public void offTV(){
        System.out.println(" Прекращаем смотреть телевизоры\n------------------- ");
        hall.offTVhl();
        bedroom.offTV();
        System.out.println(" ******************************** ");
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        Facade hause = new Facade();
        hause.onAllLigth();
        hause.openAllWindow();
    }
}
