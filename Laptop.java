import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Laptop {
    String OS;      //Критерии ноутбуков
    Integer RAM;
    String GPU;
    Integer SSD;
    Integer Serial_number;

    public HashSet<Laptop> filter (HashSet<Laptop> laptops) {   //функия фильтрации ноутбуков по критериям
        HashMap<String, Object> filtration = new HashMap<>();
        boolean flag = true;
        String input;
        String[] criterions;
        while (flag) {
            System.out.println("Введите критерий для филтьрации в формате <Criterion=Value>, для выхода введите 'q': ");
            input = in();
            if (input.equals("q")) flag = false;
            else {
                criterions = input.split("=");
                filtration.putIfAbsent(criterions[0], (Object) criterions[1]);
            }
        }
        HashSet<Laptop> result = new HashSet<>();
        for (Laptop obj : laptops) {
            if (fits(obj, filtration)) result.add(obj);
        }
        return result;
    }
    private boolean fits (Laptop laptop, HashMap<String, Object> filtration) {      //Функция проверки ноутбука на совместимость с критериями
        HashSet<String> filters = new HashSet<>(Arrays.asList("OS", "RAM", "GPU", "SSD"));
        for (String filter : filters) {
            if (filtration.containsKey(filter)) {
                Object filtrationC = filtration.get(filter);
                Object laptopC = getCriterion(laptop, filter);
                if ((!filtrationC.equals(laptopC)) && (!filtrationC.equals(null))) {
                    if (filter.equals("RAM") || filter.equals("SSD")) {
                        if (Integer.parseInt(filtrationC.toString()) > Integer.parseInt(laptopC.toString()) && (!filtrationC.equals(null))) return false;
                    }
                    else return false;
                }
            }
        }
        return true;
    }

    private Object getCriterion (Laptop lapltop, String criterion) {    //Функция получения критерия ноутбука
        if (criterion == "OS") return lapltop.OS;
        if (criterion == "RAM") return lapltop.RAM;
        if (criterion == "GPU") return lapltop.GPU;
        if (criterion == "SSD") return lapltop.SSD;
        return lapltop.Serial_number;

    }

    private String in () {      //Функиця получения данных со строки
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //scanner.close(); Открыт, потому что иначе была бы ошибка в цикле.
        return input;
    }

    public void output (Laptop laptop) {    // Функция вывода критерий ноутбука в консоль
        System.out.printf("OS: %s, RAM: %d, GPU: %s, SSD: %d, Serial number: %d\n", laptop.OS, laptop.RAM, laptop.GPU, laptop.SSD, laptop.Serial_number);
    }
}