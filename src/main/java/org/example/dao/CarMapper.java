package org.example.dao;

import org.example.models.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Car car = new Car();

        car.setId(resultSet.getInt("id"));
        car.setNumber(resultSet.getString("number"));
        car.setBrand(resultSet.getString("brand"));
        car.setModel(resultSet.getString("model"));
        car.setColor(resultSet.getString("color"));
        car.setYearOfManufacture(resultSet.getInt("year"));

        return car;
    }
}
