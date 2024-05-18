package pojo;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class TestDuck {
    @Test
    public void testDuckCanDrinkAlcohol() {
        Duck duck = new Duck("Donald", 5);
        assertEquals("Donald", duck.getName());
        assertFalse(duck.canDrinkAlcohol());

        // change age and check if duck can drink alcohol
        // But I don't want to create a setter for this
        // Use reflection API to change the age
        try {
            Class<Duck> duckClass = Duck.class;
            Field ageField = duckClass.getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.setInt(duck, 20);
        }
        catch (Exception e) {
            e.printStackTrace();
            assert false;
        }

        assertTrue(duck.canDrinkAlcohol());

    }

    @Test
    public void testDuckCanCreateMoreDucks() {
        // Instead of creating more ducks
        // I will use reflection API to change the count
        Duck duck = new Duck("Donald", 5);
        assertTrue(Duck.canCreateMoreDucks());

        // Also assert count was 1
        // But I don't want to create a getter for this
        try {
            Class<Duck> duckClass = Duck.class;
            Field countField = duckClass.getDeclaredField("count");
            countField.setAccessible(true);

            // Don't need to pass an instance as count is static
            Object countObject = countField.get(null);
            int count  = (int) countObject;
            assertEquals(1, count);
        }
        catch (Exception e) {
            e.printStackTrace();
            assert false;
        }
    }

    @Test
    public void testDuckCannotCreateMoreDucks() {
        // Instead of creating more ducks
        // I will use reflection API to change the count
        for (int i=0; i<10; i++) {
            Duck duck = new Duck("Donald", 5);
        }

        assertFalse(Duck.canCreateMoreDucks());

        // Also assert count was 1
        // But I don't want to create a getter for this
        try {
            Class<Duck> duckClass = Duck.class;
            Field countField = duckClass.getDeclaredField("count");
            countField.setAccessible(true);

            // Don't need to pass an instance as count is static
            Object countObject = countField.get(null);
            int count  = (int) countObject;
            assertEquals(10, count);
        }
        catch (Exception e) {
            e.printStackTrace();
            assert false;
        }
    }
}
