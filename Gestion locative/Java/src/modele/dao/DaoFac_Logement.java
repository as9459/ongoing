package modele.dao;

import modele.Fac_Logement;

import java.util.List;

public class DaoFac_Logement implements Dao<Fac_Logement> {

    @Override
    public void create(Fac_Logement data) {
        DaoTest.insertFacLogement(data);
    }

    @Override
    public void update(Fac_Logement data) {
        DaoTest.updateFacLogement(data);
    }

    @Override
    public void delete(Fac_Logement data) {
        DaoTest.deleteFacLogement(data);
    }

    @Override
    public Fac_Logement findById(int id) {
        // Assuming Fac_Logement has an ID field
        if (id >= 1) {
            List<Fac_Logement> facLogements = DaoTest.selectFacLogement(id);
            if (!facLogements.isEmpty()) {
                return facLogements.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Fac_Logement> findAll() {
        return DaoTest.selectFacLogement(0);
    }

	@Override
	public Fac_Logement findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
