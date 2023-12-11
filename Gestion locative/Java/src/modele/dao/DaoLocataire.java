package modele.dao;

import modele.Locataire;

import java.util.List;

public class DaoLocataire implements Dao<Locataire> {

    @Override
    public void create(Locataire data) {
        DaoTest.insertLocataire(data);
    }

    @Override
    public void update(Locataire data) {
        DaoTest.updateLocataire(data);
    }

    @Override
    public void delete(Locataire data) {
        DaoTest.deleteLocataire(data);
    }

    @Override
    public Locataire findById(String... id) {
        // Assuming Locataire has an ID field
        if (id.length >= 1) {
            List<Locataire> locataires = DaoTest.selectLocataire(id);
            if (!locataires.isEmpty()) {
                return locataires.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Locataire> findAll() {
        return DaoTest.selectLocataire();
    }

}
