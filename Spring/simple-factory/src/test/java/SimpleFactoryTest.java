import com.zzy.simple.factory.PhoneFactory;
import com.zzy.simple.product.Phone;
import org.junit.Test;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        Phone iqooNeo3 = PhoneFactory.getPhone("IQOONeo3");
        iqooNeo3.logo();
    }

    @Test
    public void test1() {

    }
}
