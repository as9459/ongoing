package modele.dao;

import modele.Fac_Batiment;

import java.util.List;

public class DaoFac_Batiment implements Dao<Fac_Batiment> {

    @Override
    public void create(Fac_Batiment data) {
        DaoTest.insertFacBatiment(data);
    }

    @Override
    public void update(Fac_Batiment data) {
        DaoTest.updateFacBatiment(data);
    }

    @Override
    public void delete(Fac_Batiment data) {
        DaoTest.deleteFacBatiment(data);
    }

    @Override
    public Fac_Batiment findById(String... id) {
        // Assuming Fac_Batiment has an ID field
        if (id.length >= 1) {
            List<Fac_Batiment> facBatiments = DaoTest.selectFacBatiment(id);
            if (!facBatiments.isEmpty()) {
                return facBatiments.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Fac_Batiment> findAll() {
        return DaoTest.selectFacBatiment();
    }

}
