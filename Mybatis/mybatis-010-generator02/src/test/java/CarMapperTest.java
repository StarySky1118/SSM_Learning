import com.zzy.generator02.mapper.CarMapper;
import com.zzy.generator02.pojo.Car;
import com.zzy.generator02.pojo.CarExample;
import com.zzy.generator02.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class CarMapperTest {
    @Test
    public void testSelectByExample() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        // QBC风格：Query By Criteria，一种面向对象的查询方式，看不到 SQL 语句

        CarExample carExample = new CarExample();
        carExample.createCriteria().andBrandLike("%宝%");

        List<Car> cars = mapper.selectByExample(carExample);
        for (Car car : cars) {
            System.out.println(car);
        }

        sqlSession.close();
    }
}
