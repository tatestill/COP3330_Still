import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    @Test
    public void testBMIunder()
    {
        double height = 70;
        double weight = 100;
        BodyMassIndex bmiTest = new BodyMassIndex(height,weight);
        double ans = bmiTest.calculateBMI();
        assertEquals(14.3, ans);
    }
    @Test
    public void testBMIaverage()
    {
        double height = 70;
        double weight = 150;
        BodyMassIndex bmiTest = new BodyMassIndex(height,weight);
        double ans = bmiTest.calculateBMI();
        assertEquals(21.5, ans);
    }
    @Test
    public void testBMIover()
    {
        double height = 70;
        double weight = 200;
        BodyMassIndex bmiTest = new BodyMassIndex(height,weight);
        double ans = bmiTest.calculateBMI();
        assertEquals(28.7, ans);
    }
    @Test
    public void testBMIobese()
    {
        double height = 70;
        double weight = 250;
        BodyMassIndex bmiTest = new BodyMassIndex(height,weight);
        double ans = bmiTest.calculateBMI();
        assertEquals(35.9, ans);
    }
    @Test
    public void testBMIunderCat()
    {
        double height = 70;
        double weight = 100;
        BodyMassIndex bmiTest = new BodyMassIndex(height,weight);
        String ans = bmiTest.categoryBMI();
        assertEquals("Underweight", ans);
    }
    @Test
    public void testBMIaverageCat()
    {
        double height = 70;
        double weight = 150;
        BodyMassIndex bmiTest = new BodyMassIndex(height,weight);
        String ans = bmiTest.categoryBMI();
        assertEquals("Normal weight", ans);
    }
    @Test
    public void testBMIoverCat()
    {
        double height = 70;
        double weight = 200;
        BodyMassIndex bmiTest = new BodyMassIndex(height,weight);
        String ans = bmiTest.categoryBMI();
        assertEquals("Overweight", ans);
    }
    @Test
    public void testBMIobeseCat()
    {
        double height = 70;
        double weight = 250;
        BodyMassIndex bmiTest = new BodyMassIndex(height,weight);
        String ans = bmiTest.categoryBMI();
        assertEquals("Obesity", ans);
    }

}