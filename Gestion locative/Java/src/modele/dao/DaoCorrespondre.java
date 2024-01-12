package modele.dao;

import modele.Correspondre;
import modele.Diagnostic;

import java.util.List;

public class DaoCorrespondre implements Dao<Correspondre> {

    @Override
    public void create(Correspondre data) {
        DaoTest.insertCorrespondre(data);
    }

    @Override
    public void update(Correspondre data) {
        DaoTest.updateCorrespondre(data);
    }

    @Override
    public void delete(Correspondre data) {
        DaoTest.deleteCorrespondre(data);
    }

    @Override
    public Correspondre findById(String... id) {
        // Assuming Correspondre has an ID field
        if (id.length >= 1) {
            List<Correspondre> correspondres = DaoTest.selectCorrespondre(id);
            if (!correspondres.isEmpty()) {
                return correspondres.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Correspondre> findAll() {
        return DaoTest.selectCorrespondre();
    }

}
