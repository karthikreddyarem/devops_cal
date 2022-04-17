import calculator.calculator;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-8;
    calculator calc = new calculator();

    @Test
    public void sumTP(){
        assertEquals("sum of two int - TP",1,calc.sum(0,1),DELTA);
        assertEquals("sum of an int and double - TP",3.5,calc.sum(0.5,3),DELTA);
        assertEquals("sum of two doubles - TP",14.4,calc.sum(0.4,14),DELTA);
        assertEquals("sum of two doubles - TP",2.9,calc.sum(2.6,0.3),DELTA);
    }

    @Test
    public void sumFP(){
        assertNotEquals("Sum of two int - TP",-1,calc.sum(1,0),DELTA);
        assertNotEquals("Sum of an int and double - FP",3,calc.sum(-0.3,2),DELTA);
        assertNotEquals("Sum of two int - FP",0,calc.sum(-1,2),DELTA);
    }
    @Test
    public void sqrtTP(){
        assertEquals("Sqrt of an int - TP",2, calc.sqt(4), DELTA);
        assertEquals("Sqrt of an int - TP",2.44948974278, calc.sqt(6), DELTA);
        assertEquals("Sqrt of a double- TP",1.58113883008, calc.sqt(2.5), DELTA);
    }

    @Test
    public void sqrtFP(){
        assertNotEquals("Sqrt of an int - False Positive",2,calc.sqt(5), DELTA);
        assertNotEquals("Sqrt of an int - False Positive",5,calc.sqt(9), DELTA);
        assertNotEquals("Sqrt of a Double- False Positive", 3.8, calc.sqt(15),DELTA);
    }

    @Test
    public void factTP(){
        assertEquals("Fact of an int - True Positive",1,calc.factorial(1), DELTA);
        assertEquals("Fact of an int - True Positive",6,calc.factorial(3), DELTA);
        assertEquals("Fact of a double - True Positive",120,calc.factorial(5.0), DELTA);
    }

    @Test
    public void factFP(){
        assertNotEquals("Fact of input - FP",120,calc.factorial(6), DELTA);
        assertNotEquals("Fact of input - FP",60,calc.factorial(2.0), DELTA);
        assertNotEquals("Fact of input - FP",10,calc.factorial(1.0), DELTA);
    }

    @Test
    public void logTP(){
        assertEquals("log of - TP",1.6094379124341003,calc.log(5),DELTA );
        assertEquals("log of - TP",2.30258509299,calc.log(10),DELTA );
        assertEquals("log of - TP", 0, calc.log(1), DELTA );
    }

    @Test
    public void logFP(){
        assertNotEquals("log of - TP",1,calc.log(1),DELTA );
        assertNotEquals("log of - TP",1,calc.log(20),DELTA );
    }

    @Test
    public void timesTP(){
        assertEquals("Power of two int - TP",27,calc.times(3,3),DELTA);
        assertEquals("Power of an int and double - TP",0.0625,calc.times(0.5,4),DELTA);
        assertEquals("Power of two doubles - TP",2.2423700575,calc.times(1.4,2.4),DELTA);
        assertEquals("Power of two doubles - TP",1.6767040297,calc.times(5.6,0.3),DELTA);
    }

    @Test
    public void timesFP(){
        assertNotEquals("Power of two doubles - TP",-1,calc.times(1,0),DELTA);
        assertNotEquals("Power of an int and double - FP",9,calc.times(-1.3,2),DELTA);
        assertNotEquals("Power of two int - FP",-1,calc.times(-2,4),DELTA);
    }
}