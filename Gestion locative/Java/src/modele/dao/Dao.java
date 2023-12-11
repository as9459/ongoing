package modele.dao;

import java.util.List;

import modele.Batiment;
import modele.Diagnostic;

public interface Dao<T> {
    public void create(T data);
    public void update(T data);
    public void delete(T data);
    public List<T> findAll();
    public T findById(String[] id);
}