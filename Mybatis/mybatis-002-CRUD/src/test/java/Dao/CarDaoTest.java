package Dao;

import org.junit.Test;
import pojo.Car;

import java.math.BigDecimal;
import java.util.List;

public class CarDaoTest {
    CarDao carDao = new CarDao();


    @Test
    public void testInsertCar() {
        Car car = new Car(null, "1103", "IQOO neo3", BigDecimal.valueOf(20), "2022-11-09", "燃油车");

        carDao.insertCar(car);
    }

    @Test
    public void testDeleteCarById() {
        carDao.deleteCarById(175);
    }

    @Test
    public void testUpdateCar() {
        Car car = new Car(182, "1103", "IQOO neo5", BigDecimal.valueOf(20), "2022-11-09", "燃油车");

        carDao.updateCar(car);
    }

    @Test
    public void testQueryById() {
        Car car = carDao.queryById(1);
        System.out.println(car);
    }

    @Test
    public void testQueryAllCars() {
        List<Car> cars = carDao.queryAllCars();

        for (Car car : cars) {
            System.out.println(car);
        }
    }

}