package Adapter;

/*
* Адаптер — структурный шаблон проектирования, предназначенный для организации использования функций
*  объекта, недоступного для модификации, через специально созданный интерфейс.
* */

interface AirDelivery{
    public void airDel();
    public int timeDayAirDelivary();
}
interface RoadDelivery{
    public void roadDelivary();
    public int timeDayRoadDelivary();

}
interface ShipDelivary{
    public void shipDelivary();
    public int timeDayShipDelivary();
}

class AirD implements AirDelivery{

    @Override
    public void airDel() {
        System.out.println(" Delivery is carried out by plane ");
        //Доставка осуществляется с помощью самолёта
    }

    @Override
    public int timeDayAirDelivary() {
        return 5;
        //доставка занимает в среднем 5 дней
    }
}

class RoadD implements RoadDelivery{

    @Override
    public void roadDelivary() {
        System.out.println(" Delivery is carried out using land transport ");
    }

    @Override
    public int timeDayRoadDelivary() {
        return 30;
        //доставка занимает в среднем 30 дней
    }
}

class ShipD implements ShipDelivary{

    @Override
    public void shipDelivary() {
        System.out.println(" Delivery is carried out by ship ");
    }

    @Override
    public int timeDayShipDelivary() {
        return 21;
        //доставка занимает в среднем 30 дней
    }
}

class AdapterRoad_Air implements RoadDelivery{

    AirD air;

    public AdapterRoad_Air(AirD air){
        this.air = air;
    }

    @Override
    public void roadDelivary() {
        air.airDel();
    }

    @Override
    public int timeDayRoadDelivary() {
        return air.timeDayAirDelivary();
    }
}
class AdapterRoad_Ship implements RoadDelivery{

    ShipD ship;

    public AdapterRoad_Ship(ShipD ship){
        this.ship = ship;
    }

    @Override
    public void roadDelivary() {
        ship.shipDelivary();
    }

    @Override
    public int timeDayRoadDelivary() {
        return ship.timeDayShipDelivary();
    }
}

public class Adapter {
    public static void main(String[] args) {
        //пример, где в роли доставщика создаём наземный транспорт, а
        //потом через адаптер преобразуем её в доставки по воздуху
        System.out.println(  );
        RoadDelivery road_a = new AdapterRoad_Air(new AirD());
        road_a.roadDelivary();
        System.out.println( " Доставка осуществляется за " +  road_a.timeDayRoadDelivary() + " дней");

        //пример, где в роли доставщика создаём наземный транспорт, а
        //потом через адаптер преобразуем её в доставки по воде
        System.out.println(  );
        RoadDelivery road_s = new AdapterRoad_Ship(new ShipD());
        road_s.roadDelivary();
        System.out.println( " Доставка осуществляется за " +  road_s.timeDayRoadDelivary() + " дней");
    }
}
