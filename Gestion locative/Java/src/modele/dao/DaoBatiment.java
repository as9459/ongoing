package modele.dao;

import modele.Batiment;
import modele.Diagnostic;

import java.util.List;

public class DaoBatiment implements Dao<Batiment> {

    @Override
    public void create(Batiment data) {
        DaoTest.insertBatiment(data);
    }

    @Override
    public void update(Batiment data) {
    	DaoTest.updateBatiment(data);
    }

    @Override
    public void delete(Batiment data) {
    	DaoTest.deleteBatiment(data);
    }

    @Override
    public List<Batiment> findAll() {
        return DaoTest.selectBatiment();
    }

    @Override
    public Batiment findById(String... id) {
    	if (id.length >= 1) {
    		if (DaoTest.selectBatiment(id).size() == 1) {
            	return DaoTest.selectBatiment(id).get(0);
            }
    	}
    	return null;
    }
}