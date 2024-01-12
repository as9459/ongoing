package modele.dao;

import modele.Charges;
import modele.Diagnostic;

import java.util.List;

public class DaoCharges implements Dao<Charges> {

    @Override
    public void create(Charges data) {
        DaoTest.insertCharges(data);
    }

    @Override
    public void update(Charges data) {
        DaoTest.updateCharges(data);
    }

    @Override
    public void delete(Charges data) {
        DaoTest.deleteCharges(data);
    }

    @Override
    public Charges findById(String... id) {
        if (id.length >= 1) {
            List<Charges> charges = DaoTest.selectCharges(id);
            if (!charges.isEmpty()) {
                return charges.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Charges> findAll() {
        return DaoTest.selectCharges();
    }

}

