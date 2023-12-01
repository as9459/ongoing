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
    public Batiment findById(int id) {
        if (id >= 1) {
            List<Batiment> batiments = DaoTest.selectBatiment(id);
            if (!batiments.isEmpty()) {
                return batiments.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Batiment> findAll() {
        return DaoTest.selectBatiment(0);
    }

	@Override
	public Batiment findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}