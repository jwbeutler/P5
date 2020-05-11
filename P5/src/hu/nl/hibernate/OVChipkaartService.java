package hu.nl.hibernate;

import java.util.List;
import hu.nl.hibernate.OVChipkaart;

public class OVChipkaartService {

    private static OVChipkaartService instance;

    private OVChipkaartDAO OVChipkaartDAO;

    public static OVChipkaartService getInstance() {
        if (instance == null)
            instance = new OVChipkaartService();
        return instance;
    }

    public OVChipkaartService() {
        OVChipkaartDAO = new OVChipkaartDAO();
    }

    public void persist(OVChipkaart entity) {
        OVChipkaartDAO.openCurrentSessionwithTransaction();
        OVChipkaartDAO.persist(entity);
        OVChipkaartDAO.closeCurrentSessionwithTransaction();
    }

    public void update(OVChipkaart entity) {
        OVChipkaartDAO.openCurrentSessionwithTransaction();
        OVChipkaartDAO.update(entity);
        OVChipkaartDAO.closeCurrentSessionwithTransaction();
    }

    public OVChipkaart findById(int id) {
        OVChipkaartDAO.openCurrentSession();
        OVChipkaart ovChipkaart = OVChipkaartDAO.findById(id);
        OVChipkaartDAO.closeCurrentSession();
        return ovChipkaart;
    }

    public void delete(int id) {
        OVChipkaartDAO.openCurrentSessionwithTransaction();
        OVChipkaart ovChipkaart = OVChipkaartDAO.findById(id);
        OVChipkaartDAO.delete(ovChipkaart);
        OVChipkaartDAO.closeCurrentSessionwithTransaction();
    }

    public void delete(OVChipkaart ovChipkaart) {
        OVChipkaartDAO.openCurrentSessionwithTransaction();
        OVChipkaartDAO.delete(ovChipkaart);
        OVChipkaartDAO.closeCurrentSessionwithTransaction();
    }

    public List<OVChipkaart> findAll() {
        OVChipkaartDAO.openCurrentSession();
        List<OVChipkaart> ovChipkaarts = OVChipkaartDAO.findAll();
        OVChipkaartDAO.closeCurrentSession();
        return ovChipkaarts;
    }

    public void deleteAll() {
        OVChipkaartDAO.openCurrentSessionwithTransaction();
        OVChipkaartDAO.deleteAll();
        OVChipkaartDAO.closeCurrentSessionwithTransaction();
    }

    public OVChipkaartDAO getOvChipkaartDao() {
        return OVChipkaartDAO;
    }
}