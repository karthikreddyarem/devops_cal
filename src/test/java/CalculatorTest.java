import calculator.calculator;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-15;
    calculator calc = new calculator();

    @Test
    public void squarerootTruePositive(){
        assertEquals("Square root of an int - True Positive",2, calc.sqt(4), DELTA);
        assertEquals("Square root of a double- True Positive",1.8708286933869707, calc.sqt(3.5), DELTA);
    }

    @Test
    public void squarerootFalsePositive(){
        assertNotEquals("Square root of an int - False Positive",2,calc.sqt(5), DELTA);
        assertNotEquals("Square root of a Double- False Positive", 5.7, calc.sqt(30),DELTA);
    }

    @Test
    public void factorialTruePositive(){
        assertEquals("Factorial of an int - True Positive",2,calc.factorial(2), DELTA);
        assertEquals("Factorial of a double - True Positive",24,calc.factorial(4.0), DELTA);
    }

    @Test
    public void factorialFalsePositive(){
        assertNotEquals("Factorial of an int - False Positive",120,calc.factorial(6), DELTA);
        assertNotEquals("Factorial of a double - False Positive",720,calc.factorial(4.0), DELTA);
    }

    @Test
    public void logTruePositive(){
        assertEquals("Log- True Positive",1.6094379124341003,calc.log(5),DELTA );
        assertEquals("Log - TruePositive",4.04305126783455,calc.log(57),DELTA );
        assertEquals("Log - True Positive", 0, calc.log(1), DELTA );
    }

    @Test
    public void logFalsePositive(){
        assertNotEquals("Log- True Positive",1,calc.log(1),DELTA );
        assertNotEquals("Log - TruePositive",1,calc.log(10),DELTA );
    }

    @Test
    public void powerTruePositive(){
        assertEquals("Power of two int - True Positive",8,calc.power(2,3),DELTA);
        assertEquals("Power of an int and double - True Positive",12.166999999999998,calc.power(2.3,3),DELTA);
        assertEquals("Power of two doubles - True Positive",18.45216910555504,calc.power(2.3,3.5),DELTA);
    }

    @Test
    public void powerFalsePositive(){
        assertNotEquals("Power of two doubles - True Positive",-1,calc.power(1,0),DELTA);
        assertNotEquals("Power of an int and double - False Positive",9,calc.power(-2.3,3),DELTA);
        assertNotEquals("Power of two int - False Positive",-1,calc.power(-1,2),DELTA);
    }
}