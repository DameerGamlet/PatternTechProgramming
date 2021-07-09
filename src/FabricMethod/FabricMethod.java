package FabricMethod;

public class FabricMethod {

    interface OS {
        void getOS();
        void DateCreate();
    }
    static class Factory {
        public OS getCurrentOS(String inputos) {
            return switch (inputos) {
                case "w" -> new windowsOS();
                case "l" -> new linuxOS();
                case "m" -> new macOS();
                default -> null;
            };
        }
    }

    static class windowsOS implements OS {
        public void getOS () {
            System.out.println(" Вы выбрали Windows. Применить для Windows");
        }
        public void DateCreate(){
            System.out.println(" Создан в 2001 году ");
        }
    }
    static class linuxOS implements OS {
        public void getOS () {
            System.out.println(" Вы выбрали Linux. Применить для Linux");
        }
        public void DateCreate(){
            System.out.println(" Создан в 2010 году ");
        }
    }
    static class macOS implements OS {
        public void getOS () {
            System.out.println(" Вы выбрали MacOS. Применить для MacOS");
        }
        public void DateCreate(){
            System.out.println(" Создан в 2007 году ");
        }
    }

    public static void main(String[] args) {
        String win = "m";
        Factory factory = new Factory();
        OS os = factory.getCurrentOS(win);
        os.getOS();
        os.DateCreate();
    }
}
