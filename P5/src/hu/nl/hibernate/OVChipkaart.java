package hu.nl.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.sql.Date;

@Entity
@Table(name = "OV_CHIPKAART", uniqueConstraints = {
        @UniqueConstraint(columnNames = "KAARTNUMMER")
})
public class OVChipkaart {

    @Id
    @Column(name = "KAARTNUMMER", unique = true, nullable = false, length = 10)
    private int kaartNum;

    @Column(name = "GELDIGTOT")
    private Date geldigTot;

    @Column(name = "KLASSE", length = 1)
    private int klasse;

    @Column(name = "SALDO", length = 16, precision = 2)
    private float saldo;

    @ManyToOne(targetEntity = Reiziger.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "REIZIGERID")
    private Reiziger reiziger;

    public OVChipkaart() {
    }

    public OVChipkaart(int kaartNum, Date geldigTot, int klasse, float saldo) {
        this(kaartNum, geldigTot, klasse, saldo, null);
    }

    public OVChipkaart(int kaartNum, Date geldigTot, int klasse, float saldo, Reiziger r) {
        this.kaartNum = kaartNum;
        this.geldigTot = geldigTot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reiziger = r;
    }

    public int getKaartNummer() {
        return kaartNum;
    }

    public Date getGeldigTot() {
        return geldigTot;
    }

    public void setGeldigTot(Date geldigTot) {
        this.geldigTot = geldigTot;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setReiziger(Reiziger r) {
        this.reiziger = r;
    }

    public void setKaartNummer(int kaartNum) {
        this.kaartNum = kaartNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OVChipkaart that = (OVChipkaart) o;
        return kaartNum == that.kaartNum;
    }

    @Override
    public String toString() {
        return "OVChipkaart{" +
                "kaartNummer=" + kaartNum +
                ", geldigTot=" + geldigTot +
                ", klasse=" + klasse +
                ", saldo=" + saldo +
                '}';
    }
}