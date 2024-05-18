package pojo;

public class Duck {
    private String name;
    private int age;
    private static int count = 0;

    public Duck(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    public static boolean canCreateMoreDucks() {
        return count < 10;
    }

    public String getName() {
        return name;
    }

    public boolean canDrinkAlcohol() {
        return age >= 18;
    }
}
