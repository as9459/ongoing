package modele.dao;

import modele.Entreprise;

import java.util.List;

public class DaoEntreprise implements Dao<Entreprise> {

    @Override
    public void create(Entreprise data) {
        DaoTest.insertEntreprise(data);
    }

    @Override
    public void update(Entreprise data) {
        DaoTest.updateEntreprise(data);
    }

    @Override
    public void delete(Entreprise data) {
        DaoTest.deleteEntreprise(data);
    }

    @Override
    public Entreprise findById(String... id) {
        // Assuming Entreprise has an ID field
        if (id.length >= 1) {
            List<Entreprise> entreprises = DaoTest.selectEntreprise(id);
            if (!entreprises.isEmpty()) {
                return entreprises.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Entreprise> findAll() {
        return DaoTest.selectEntreprise();
    }

}
