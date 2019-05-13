package com.sweets.repositoty;

import com.sweets.entity.Entity;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDAO<Long, T extends Entity> {


    public abstract List<T> findAll() throws IOException, ClassNotFoundException;

    public abstract Optional<T> findEntityById(Long id);

    public abstract T createSweet(T entity);

    public void close(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }


}
