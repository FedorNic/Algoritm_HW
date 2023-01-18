package Home_Tasks.HT_16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
Класс Notebook содержит поля:
Стоимость - price, double [100, 200, 300, 400, 500, 600, 700, 800]
Оперативная память - ram, integer [4, 8, 16, 20, 24, 28, 32]
Производитель - brand, enum Перечисление Brand может принимать следующие значения: Lenuvo, Asos, MacNote, Eser, Xamiou.
Сортировать нужно в этом же порядке (т.е. Lenuvo имеет наивысший приоритет).
Отсортировать по стоимости, по памяти, по перечислению (в таком порядке)
 */
public class Notebook implements Comparable<Notebook> {

    private Double price;
    private Integer ram;
    private Brand brand;

    public Notebook(Double price, Integer ram, Brand brand) {
        this.price = price;
        this.ram = ram;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return  "price = " + price +
                ", ram = " + ram +
                ", brand = " + brand +
                "\n";
    }

    @Override
    public int compareTo(Notebook o) {
        if (o.price.compareTo(this.price) == 0) {
            if (o.ram.compareTo(this.ram) == 0) {
                return this.brand.compareTo(o.brand);
            }
            return this.ram.compareTo(o.ram);
        }
        return this.price.compareTo(o.price);
    }

    public static void main(String[] args) {
        ArrayList<Notebook> notebooks = new ArrayList<Notebook>();
        double[] price = new double[]{100, 200, 300, 400, 500, 600, 700, 800};
        int[] ram = new int[]{4, 8, 16, 20, 24, 28, 32};
        for (int i = 0; i < 100; i++) {
            int priceIndex = new Random().nextInt(8);
            int ramIndex = new Random().nextInt(7);
            Brand brand = Brand.values()[new Random().nextInt(Brand.values().length)];
            notebooks.add(new Notebook(price[priceIndex], ram[ramIndex], brand));
        }

        Collections.sort(notebooks);
        System.out.println(notebooks.toString().replace("[", "").replace("]", "")
                .replace(",", ""));
    }
}

enum Brand {
    Lenuvo,
    Asos,
    MacNote,
    Eser,
    Xamiou
}