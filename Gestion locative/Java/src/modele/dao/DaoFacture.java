package modele.dao;

import modele.Facture;

import java.util.List;

public class DaoFacture implements Dao<Facture> {

    @Override
    public void create(Facture data) {
        DaoTest.insertFacture(data);
    }

    @Override
    public void update(Facture data) {
        DaoTest.updateFacture(data);
    }

    @Override
    public void delete(Facture data) {
        DaoTest.deleteFacture(data);
    }

    @Override
    public Facture findById(int id) {
        // Assuming Facture has an ID field
        if (id >= 1) {
            List<Facture> factures = DaoTest.selectFacture(id);
            if (!factures.isEmpty()) {
                return factures.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Facture> findAll() {
        return DaoTest.selectFacture(0);
    }

	@Override
	public Facture findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
