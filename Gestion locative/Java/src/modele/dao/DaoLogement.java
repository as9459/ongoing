package modele.dao;

import modele.Logement;

import java.util.List;

public class DaoLogement implements Dao<Logement> {

    @Override
    public void create(Logement data) {
        DaoTest.insertLogement(data);
    }

    @Override
    public void update(Logement data) {
        DaoTest.updateLogement(data);
    }

    @Override
    public void delete(Logement data) {
        DaoTest.deleteLogement(data);
    }

    @Override
    public Logement findById(int id) {
        // Assuming Logement has an ID field
        if (id >= 1) {
            List<Logement> logements = DaoTest.selectLogement(id);
            if (!logements.isEmpty()) {
                return logements.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Logement> findAll() {
        return DaoTest.selectLogement(0);
    }

	@Override
	public Logement findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
