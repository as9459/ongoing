package modele.dao;

import java.util.List;

import modele.Diagnostic;

public class DaoDiagnostic implements Dao<Diagnostic> {

    @Override
    public void create(Diagnostic data) {
        DaoTest.insertDiagnostic(data);
    }

    @Override
    public void update(Diagnostic data) {
        DaoTest.updateDiagnostic(data);
    }

    @Override
    public void delete(Diagnostic data) {
        DaoTest.deleteDiagnostic(data);
    }

    @Override
    public Diagnostic findById(String id) {
        // Assuming Diagnostic has an ID field
        if (id.length() >= 1) {
            List<Diagnostic> Diagnostics = DaoTest.selectDiagnostic(id);
            if (!Diagnostics.isEmpty()) {
                return Diagnostics.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Diagnostic> findAll() {
        return DaoTest.selectDiagnostic();
    }

	@Override
	public Diagnostic findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
