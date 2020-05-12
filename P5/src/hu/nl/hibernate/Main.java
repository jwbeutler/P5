package hu.nl.hibernate;

import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("ConstantConditions")
public class Main {
    public static void main(String[] args) throws SQLException, ParseException {
        OVChipkaart OV = OVChipkaartService.getInstance().findById(79625);
        System.out.println("Get OVChipkaart (KAARTNUMMER=79625)");
        System.out.println(OV);

        System.out.println("\nGet Reiziger by ID 4");
        ReizigerService.getInstance().getReizigerDAO().openCurrentSession();
        Reiziger r = ReizigerService.getInstance().getReizigerDAO().findById(4);
        System.out.println(r);

        System.out.println("\nGet OVChipkaarten by Reiziger ID 4");
        for (OVChipkaart kaart : r.getOVChipkaarten()) {
            System.out.println(kaart);
        }

        System.out.println("\nUpdate Reiziger ID 4, achternaam to Test");
        r.setAchternaam("Test");
        ReizigerService.getInstance().getReizigerDAO().update(r);
        ReizigerService.getInstance().getReizigerDAO().closeCurrentSession();

        System.out.println("\nSet Reiziger ID 4, original achternaam");
        r = ReizigerService.getInstance().findById(4);
        r.setAchternaam("Memari");
        ReizigerService.getInstance().update(r);

        boolean create = true;
        boolean delete = true;

        if (create) {
            System.out.println("Create Reiziger with OVChipkaart");
            Reiziger Hein = new Reiziger(96, "Hein", "", "Beutler", java.sql.Date.valueOf("1997-03-10"));

            OVChipkaart Hein_OV = new OVChipkaart(9595, java.sql.Date.valueOf("2020-12-31"), 1, 500f, Hein);
            Hein.setOVChipkaarten(new ArrayList<>(Collections.singletonList(Hein_OV)));

            ReizigerService.getInstance().persist(Hein);

            System.out.println("Newly created Reiziger ID 96 from DB");
            r = ReizigerService.getInstance().findById(96);
            System.out.println(r);
        }

        if (delete) {
            System.out.println("Delete Reiziger ID 96");
            ReizigerService.getInstance().delete(r);

            r = ReizigerService.getInstance().findById(6);

            if (r == null) {
                System.out.println("Reiziger ID 96 deleted");
            } else {
                System.out.println("Reiziger ID 6 was not deleted");
            }
        }

        System.out.println("Shutdown");
        HibernateUtil.shutdown();
    }
}