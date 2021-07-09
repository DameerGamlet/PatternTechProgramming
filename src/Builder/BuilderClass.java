package Builder;

/*
* Строитель — порождающий шаблон проектирования, который предоставляет способ создания составного объекта.
* Предназначен для решения проблемы антипаттерна «Телескопический конструктор».
* */

public class BuilderClass {
    static class PC{
        int price = 0;
        public void buildBase(){
            System.out.println("Ставим корпус");
            price += 3000;
        }
        public void buildMotherBoard(){
            System.out.println("Устанавливаем материнскую плату");
            price += 6000;
        }
        public void buildGraphicsCard(){
            System.out.println("Устанавливаем видеокарту");
            price += 22500;
        }
        public void buildCPU(){
            System.out.println("Устанавливаем процессор");
            price += 11000;
        }
        public void buildRAM(){
            System.out.println("Устанавливаем оперативную память");
            price += 3600;
        }
        public void buildRGBlight(){
            System.out.println("Устанавливаем подсветку");
            price += 2000;
        }
        public void buildFansOnBase(){
            System.out.println("Устанавливаем дополнительные вентиляторы на корпус");
            price += 4000;
        }
        public void buildCouler(Cooler cooler){
            System.out.println(cooler.getTypeCouler());
            price += cooler.getPriceCooler();
        }
        public void buildMemory(Memory memory){
            System.out.println(memory.getMemotyType());
            price += memory.getPriceMemory();
        }
        public  void Price(){
            System.out.println("Средняя стоимость ПК: " + price);
        }
    }
    interface Memory{
        String getMemotyType();
        int getPriceMemory();
    }
    interface Cooler{
        String getTypeCouler();
        int getPriceCooler();
    }
    static class SSDmemory implements Memory{
        @Override
        public String getMemotyType() {
            return "Установлен гибкий диск SSD";
        }
        public  int getPriceMemory(){
            return 5000;
        }
    }
    static class HDDmemory implements Memory{
        @Override
        public String getMemotyType() {
            return "Установлен жёсткий диск HDD";
        }
        public  int getPriceMemory(){
            return 3000;
        }
    }
    static class HDD_SSDmemory implements Memory{
        @Override
        public String getMemotyType() {
            return "Установлен жёсткий диск HDD вместе с гибким диском SSD";
        }
        public  int getPriceMemory(){
            return 8000;
        }
    }

    static class StandartCooler implements Cooler{
        @Override
        public String getTypeCouler() {
            return "Установлено стандартное охлаждение";
        }
        public  int getPriceCooler(){
            return 1500;
        }
    }
    static class WaterCooler implements Cooler{
        @Override
        public String getTypeCouler() {
            return "Установлено водяное охлаждение";
        }
        public  int getPriceCooler(){
            return 7000;
        }
    }

    //------------------------------------------

    abstract static class AbsBuilder {
        protected PC pc;
        public abstract PC buildPC();
    }

    static class StandartPC extends AbsBuilder{
        public StandartPC(){
            pc = new PC();
        }
        public PC buildPC(){
            pc.buildBase();
            pc.buildMotherBoard();
            pc.buildGraphicsCard();
            pc.buildCPU();
            pc.buildRAM();
            Memory memory = new HDDmemory();
            pc.buildMemory(memory);
            Cooler cooler = new StandartCooler();
            pc.buildCouler(cooler);
            pc.Price();
            return pc;
        }
    }

    static class GamePC extends AbsBuilder{
        public GamePC(){
            pc = new PC();
        }
        public PC buildPC(){
            pc.buildBase();
            pc.buildMotherBoard();
            pc.buildGraphicsCard();
            pc.buildCPU();
            pc.buildRAM();
            Memory memory = new HDD_SSDmemory();
            pc.buildMemory(memory);
            Cooler cooler = new WaterCooler();
            pc.buildCouler(cooler);
            pc.buildFansOnBase();
            pc.buildRGBlight();
            pc.Price();
            return pc;
        }
    }

    static class BuilderPC {
        private AbsBuilder builder;

        public BuilderPC(int i){
            if(i == 1){
                builder = new StandartPC();
            }
            else if (i == 2){
                builder = new GamePC();
            }
        }
        public void BuilderPC(){
            builder.buildPC();
        }
    }

    public static void main(String[] args) {
        BuilderPC StandPC = new BuilderPC(1);
        BuilderPC gamePC = new BuilderPC(2);

        int j = 2;

        if(j == 1){
            System.out.println("Страндартный ПК");
            StandPC.BuilderPC();
        }
        else if (j == 2){
            System.out.println("Игровой ПК");
            gamePC.BuilderPC();
        }
    }
}
