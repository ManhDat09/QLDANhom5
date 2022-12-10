package crud.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khoangsan")
public class Khoangsan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long maks_quang;
	
	@Column(name = "tenkhoangsan")
	private String tenKhoangSan;
	
	@Column(name = "tenmoks")
	private String tenMoKS;
	
	@Column(name = "truluong")
	private float truLuong;

	@Column(name = "diachimoks")
	private String diaChiMoKS;
	
	public Khoangsan() {
		
	}

	public long getMaks_quang() {
		return maks_quang;
	}

	public void setMaks_quang(long maks_quang) {
		this.maks_quang = maks_quang;
	}

	public String getTenKhoangSan() {
		return tenKhoangSan;
	}

	public void setTenKhoangSan(String tenKhoangSan) {
		this.tenKhoangSan = tenKhoangSan;
	}

	public String getTenMoKS() {
		return tenMoKS;
	}

	public void setTenMoKS(String tenMoKS) {
		this.tenMoKS = tenMoKS;
	}

	public float getTruLuong() {
		return truLuong;
	}

	public void setTruLuong(float truLuong) {
		this.truLuong = truLuong;
	}

	public String getDiaChiMoKS() {
		return diaChiMoKS;
	}

	public void setDiaChiMoKS(String diaChiMoKS) {
		this.diaChiMoKS = diaChiMoKS;
	}

	public Khoangsan(String tenKhoangSan, String tenMoKS, float truLuong, String diaChiMoKS) {
		super();
		this.tenKhoangSan = tenKhoangSan;
		this.tenMoKS = tenMoKS;
		this.truLuong = truLuong;
		this.diaChiMoKS = diaChiMoKS;
	}

	@Override
	public String toString() {
		return "Khoangsan [maks_quang=" + maks_quang + ", tenKhoangSan=" + tenKhoangSan + ", tenMoKS=" + tenMoKS
				+ ", truLuong=" + truLuong + ", diaChiMoKS=" + diaChiMoKS + "]";
	}

	

}

