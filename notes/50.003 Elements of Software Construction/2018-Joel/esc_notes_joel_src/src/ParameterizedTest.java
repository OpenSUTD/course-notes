import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

// include this for running parameterized tests
@RunWith(Parameterized.class)

public class ParameterizedTest {
	public int sum, a, b;
    
	// classic constructor
	public ParameterizedTest (int sum, int a, int b) { 
    	this.sum = sum; 
    	this.a = a; 
    	this.b = b; 
    }

	 // decide the list of parameters to be sent to the class
   @Parameters public static Collection<Object[]> parameters() {
        return Arrays.asList (new Object [][] {{0, 0, 0}, {2, 1, 1}}); 
    }

	 // This test is invoked for each of the parameter sent via parameters()	
   @Test public void additionTest() {
		assertEquals(sum, Sum.sum(a, b));
   }
}
