package com.sweets.repositoty;

import com.sweets.entity.Sweet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SweetRepo extends AbstractDAO<Long, Sweet> {
    private static final String SQL_SELECT_ALL_SWEETS = "SELECT * FROM sweets";
    private static final String SQL_SELECT_SWEET_BY_ID = "SELECT * FROM sweets WHERE id=?";
    private static final String SQL_INSERT_SWEET =
            "INSERT INTO sweets (id, name, wrapper_weight, filling_weight, filling_name, wrapper_name) " +
                    "VALUES (DEFAULT, ?, ?, ?, ?, ?);";

    @Override
    public List<Sweet> findAll() {

        List<Sweet> sweets = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = new ConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_SWEETS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Sweet sweet = new Sweet();
                mapFields(sweet,resultSet);
                sweets.add(sweet);
                System.out.println(sweet.toString());
            }
        } catch (Exception e) {
            System.err.println("SQL exception (request or table failed): " + e);

        } finally {
            close(preparedStatement);
        }
        return sweets;
    }

    @Override
    public Optional<Sweet> findEntityById(Long id) {
        Sweet sweet = new Sweet();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = new ConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_SWEET_BY_ID);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            mapFields(sweet,resultSet);
            System.out.println(sweet);

        } catch (Exception e) {
            System.err.println("SQL exception (request or table failed): " + e);

        } finally {
            close(preparedStatement);
        }
        return Optional.ofNullable(sweet);
    }

    @Override
    public Sweet createSweet(Sweet sweet) {


        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = new ConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT_SWEET);
            preparedStatement.setString(1,sweet.getName());
            preparedStatement.setLong(2,sweet.getWrapperWeight());
            preparedStatement.setLong(3,sweet.getFillingWeight());
            preparedStatement.setString(4,sweet.getSweetFilling());
            preparedStatement.setString(5,sweet.getSweetWrapper());
            preparedStatement.execute();
        } catch (Exception e) {
            System.err.println("SQL exception (request or table failed): " + e);

        } finally {
            close(preparedStatement);
        }
        return sweet;
    }

    private Sweet mapFields(Sweet sweet, ResultSet resultSet) throws SQLException {
        sweet.setId(resultSet.getLong("id"));
        sweet.setName(resultSet.getString("name"));
        sweet.setWrapperWeight(resultSet.getLong("wrapper_weight"));
        sweet.setFillingWeight(resultSet.getLong("filling_weight"));
        sweet.setSweetFilling(resultSet.getString("filling_name"));
        sweet.setSweetWrapper(resultSet.getString("wrapper_name"));
        return sweet;
    }


}
