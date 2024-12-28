package telran.employees;

import java.util.Random;

public class Ranges {
    private static Random random = new Random();

    public static int getId() {
        return random.nextInt(1000, 10000);
    }

    public static int getBasicSalary() {
        return random.nextInt(5000, 50001);
    }
    
    public static float getFactor() {
        return Math.round(random.nextFloat(1.5f, 4f + Float.MIN_VALUE) * 10) / 10f;
    }
    
    public static int getWage() {
        return random.nextInt(30, 301);
    }
    
    public static int getHours() {
        return random.nextInt(1, 201);
    }

    public static float getPercent() {
        return Math.round(random.nextFloat(0.1f, 1.5f + Float.MIN_VALUE) * 10) / 10f;
    }

    public static long getSales() {
        return random.nextLong(0, Long.MAX_VALUE);
    }
}
