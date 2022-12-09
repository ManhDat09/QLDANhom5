package quanly.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "t_khoangsan")
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Maks")
    private int Madt;

    @Column(name = "Tenkhoangsan")
    private String Tendt;

    @Column(name = "Tenmoks")
    private String Tenmoks;

    @Column(name = "Truluong")
    private int Truluong;


    public Entity() {

    }

    public Entity(int madt, String tendt, String tenmoks, int truluong) {
        Madt = madt;
        Tendt = tendt;
        Tenmoks = tenmoks;
        Truluong = truluong;

    }

    public String getTenmoks() {
        return Tenmoks;
    }

    public void setTenmoks(String tenmoks) {
        Tenmoks = tenmoks;
    }

    public int getTruluong() {
        return Truluong;
    }

    public void setTruluong(int truluong) {
        Truluong = truluong;
    }

    public int getMadt() {
        return Madt;
    }

    public void setMadt(int madt) {
        Madt = madt;
    }

    public String getTendt() {
        return Tendt;
    }

    public void setTendt(String tendt) {
        Tendt = tendt;
    }


}
