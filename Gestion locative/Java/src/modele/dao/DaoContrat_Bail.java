package modele.dao;

import modele.Contrat_Bail;
import modele.Diagnostic;

import java.util.List;

public class DaoContrat_Bail implements Dao<Contrat_Bail> {

    @Override
    public void create(Contrat_Bail data) {
        DaoTest.insertContratBail(data);
    }

    @Override
    public void update(Contrat_Bail data) {
        DaoTest.updateContratBail(data);
    }

    @Override
    public void delete(Contrat_Bail data) {
        DaoTest.deleteContratBail(data);
    }

    @Override
    public Contrat_Bail findById(String... id) {
        if (id.length >= 1) {
            List<Contrat_Bail> contrats = DaoTest.selectContratBail(id);
            if (!contrats.isEmpty()) {
                return contrats.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Contrat_Bail> findAll() {
        return DaoTest.selectContratBail();
    }
}
