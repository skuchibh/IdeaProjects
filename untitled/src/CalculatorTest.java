import static org.junit.Assert.*;

/**
 * Created by Surya Vamsi on 17-Jan-17.
 */
public class CalculatorTest {

    public void evaluatesExpression(){
        Calculator calculator=new Calculator();
        int sum=calculator.evaluate("1+2+9");
        assertEquals(12,sum);
    }
}