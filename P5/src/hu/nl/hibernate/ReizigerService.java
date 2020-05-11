package hu.nl.hibernate;

import java.util.List;
import hu.nl.hibernate.Reiziger;

public class ReizigerService {

    private static ReizigerService instance;

    private ReizigerDAO reizigerDAO;

    public static ReizigerService getInstance() {
        if (instance == null)
            instance = new ReizigerService();
        return instance;
    }

    public ReizigerService() {
        reizigerDAO = new ReizigerDAO();
    }

    public void persist(Reiziger entity) {
        reizigerDAO.openCurrentSessionwithTransaction();
        reizigerDAO.persist(entity);
        reizigerDAO.closeCurrentSessionwithTransaction();
    }

    public void update(Reiziger entity) {
        reizigerDAO.openCurrentSessionwithTransaction();
        reizigerDAO.update(entity);
        reizigerDAO.closeCurrentSessionwithTransaction();
    }

    public Reiziger findById(int id) {
        reizigerDAO.openCurrentSession();
        Reiziger reiziger = reizigerDAO.findById(id);
        reizigerDAO.closeCurrentSession();
        return reiziger;
    }

    public void delete(int id) {
        reizigerDAO.openCurrentSessionwithTransaction();
        Reiziger reiziger = reizigerDAO.findById(id);
        reizigerDAO.delete(reiziger);
        reizigerDAO.closeCurrentSessionwithTransaction();
    }

    public void delete(Reiziger reiziger) {
        reizigerDAO.openCurrentSessionwithTransaction();
        reizigerDAO.delete(reiziger);
        reizigerDAO.closeCurrentSessionwithTransaction();
    }

    public List<Reiziger> findAll() {
        reizigerDAO.openCurrentSession();
        List<Reiziger> reizigers = reizigerDAO.findAll();
        reizigerDAO.closeCurrentSession();
        return reizigers;
    }

    public void deleteAll() {
        reizigerDAO.openCurrentSessionwithTransaction();
        reizigerDAO.deleteAll();
        reizigerDAO.closeCurrentSessionwithTransaction();
    }

    public ReizigerDAO getReizigerDAO() {
        return reizigerDAO;
    }
}
