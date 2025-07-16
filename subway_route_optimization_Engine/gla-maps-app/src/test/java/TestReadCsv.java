import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TestReadCsv {
    private ReadCsv reader;
    @Before
    public void setUp(){
        reader = new ReadCsv();
    }

    @Test
    public void testReadFile(){
        assertNotNull("Fail", reader.readFile("plan.csv"));
    }
}
