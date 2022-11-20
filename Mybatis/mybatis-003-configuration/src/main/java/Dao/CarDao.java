package Dao;

import org.apache.ibatis.session.SqlSession;
import pojo.Car;
import utils.MybatisUtils;

import java.util.ArrayList;
import java.util.List;

public class CarDao {
    /**
     * 插入记录
     */
    public void insertCar(Car car) {
        SqlSession sqlSession = null;

        try {
            sqlSession = MybatisUtils.openSession(); // 开启事务

            // 执行业务
            int count = sqlSession.insert("insertCar", car);
            System.out.println(count > 0 ? "添加成功！" : "添加失败");

            // 事务提交
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
            // 事务回滚
            sqlSession.rollback();
        } finally {
            // 关闭资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 通过 id 删除汽车记录
     * @param id 汽车 id
     */
    public void deleteCarById(Integer id) {
        SqlSession sqlSession = null;

        try {
            sqlSession = MybatisUtils.openSession(); // 开启事务

            // 执行业务
            int count = sqlSession.delete("deleteCarById", id);
            System.out.println(count > 0 ? "删除成功！" : "删除失败");

            // 事务提交
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
            // 事务回滚
            sqlSession.rollback();
        } finally {
            // 关闭资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 更新车记录
     * @param car pojo 对象
     */
    public void updateCar(Car car) {
        SqlSession sqlSession = null;

        try {
            sqlSession = MybatisUtils.openSession(); // 开启事务

            // 执行业务
            int count = sqlSession.update("updateCarById", car);
            System.out.println(count > 0 ? "更新成功！" : "更新失败");

            // 事务提交
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
            // 事务回滚
            sqlSession.rollback();
        } finally {
            // 关闭资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 根据 id 查询车辆信息并封装为对象
     * @param id 车辆 id
     * @return 车辆对象
     */
    public Car queryById(Integer id) {
        SqlSession sqlSession = null;
        Car car = null;

        try {
            sqlSession = MybatisUtils.openSession(); // 开启事务

            // 执行业务
            car = sqlSession.selectOne("selectById", id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        return car;
    }

    /**
     * 查询所有汽车信息
     * @return pojo 对象列表
     */
    public List<Car> queryAllCars() {
        SqlSession sqlSession = null;
        List<Car> cars = new ArrayList<>();

        try {
            sqlSession = MybatisUtils.openSession(); // 开启事务

            // 执行业务
            cars = sqlSession.selectList("selectAll");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        return cars;
    }
}
