package modele.dao;

import modele.Garant;

import java.util.List;

public class DaoGarant implements Dao<Garant> {

    @Override
    public void create(Garant data) {
        DaoTest.insertGarant(data);
    }

    @Override
    public void update(Garant data) {
        DaoTest.updateGarant(data);
    }

    @Override
    public void delete(Garant data) {
        DaoTest.deleteGarant(data);
    }

    @Override
    public Garant findById(int id) {
        // Assuming Garant has an ID field
        if (id >= 1) {
            List<Garant> garants = DaoTest.selectGarant(id);
            if (!garants.isEmpty()) {
                return garants.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Garant> findAll() {
        return DaoTest.selectGarant(0);
    }

	@Override
	public Garant findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
