package modele.dao;

import java.util.List;

public interface Dao<T> {
    public void create(T data);
    public void update(T data);
    public void delete(T data);
    public T findById(String... id);
    public List<T> findAll();
}