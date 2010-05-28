import model.Domain;
import junit.framework.TestCase;


public class DomainTest extends TestCase {

	private Domain hayStack;
	private Domain needle;

	public void testA() {
		
		assertTrue(hayStack.hasSubdomain(needle));
	}

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		
		hayStack = new Domain(100, 200);
		needle = new Domain(101, 201);
	}
	
	

}
