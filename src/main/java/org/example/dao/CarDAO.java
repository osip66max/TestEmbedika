package org.example.dao;

import org.example.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Car> index() {
        return jdbcTemplate.query("SELECT * FROM car", new CarMapper());
    }

    public Car show(int id) {
        return jdbcTemplate.query("SELECT * FROM car WHERE id=?", new CarMapper(), id)
                .stream().findAny().orElse(null);
    }

    public void save(Car car) {
        jdbcTemplate.update("INSERT INTO car VALUES(1, ?, ?, ?, ?, ?)", car.getNumber(), car.getBrand(),
                car.getModel(), car.getColor(), car.getYearOfManufacture());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM car WHERE id=?", id);
    }

    public int getCount() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM car", Integer.class);
    }
}
