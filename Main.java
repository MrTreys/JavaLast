import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Laptop lap1 = new Laptop();     //Ввод ноутбуков (можно добавить еще)
        lap1.OS = "Windows";
        lap1.RAM = 16;
        lap1.GPU = "RTX 4060";
        lap1.SSD = 256;
        lap1.Serial_number = 312794125;

        Laptop lap2 = new Laptop();
        lap2.OS = "Windows";
        lap2.RAM = 8;
        lap2.GPU = "GTX 1660S";
        lap2.SSD = 256;
        lap2.Serial_number = 637815;

        Laptop lap3 = new Laptop();
        lap3.OS = "Linux";
        lap3.RAM = 16;
        lap3.GPU = "RX 7800XT";
        lap3.SSD = 512;
        lap3.Serial_number = 8235134;

        Laptop lap4 = new Laptop();
        lap4.OS = "Windows";
        lap4.RAM = 32;
        lap4.GPU = "RTX 4060";
        lap4.SSD = 1024;
        lap4.Serial_number = 373285;

        Laptop lap5 = new Laptop();
        lap5.OS = "Linux";
        lap5.RAM = 8;
        lap5.GPU = "GTX 1660S";
        lap5.SSD = 128;
        lap5.Serial_number = 1275327;

        HashSet<Laptop> laps = new HashSet<>(Arrays.asList(lap1, lap2, lap3, lap4, lap5));      //Создание множества ноутбуков
        HashSet<Laptop> filtered = lap1.filter(laps);       //Фильтрация
        for (Laptop lap : filtered) lap.output(lap);        //Вывод
    }
}
