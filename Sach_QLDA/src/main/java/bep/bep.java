package bep;

public class bep {
	private int mabep;
	private String tenbep;
	private float soluong;
	private String Nhasanxuat;
	private float Tonkho;
	private float SoNambaohanh;
	
	public void bep_buimanhdat(String tenbep,float soluong, String Nhasanxuat, float Tonkho, float SoNambaohanh ) {
	    this.mabep = mabep;
		this.tenbep = tenbep;
	    this.soluong = soluong;
	    this.Nhasanxuat = Nhasanxuat;
	    this.Tonkho = Tonkho;
	    this.SoNambaohanh = SoNambaohanh;
	}
	public void bep_buimanhdat(int mabep, String tenbep,float soluong, String Nhasanxuat, float Tonkho, float SoNambaohanh ) {
	    this.tenbep = tenbep;
	    this.soluong = soluong;
	    this.Nhasanxuat = Nhasanxuat;
	    this.Tonkho = Tonkho;
	    this.SoNambaohanh = SoNambaohanh;
	}
	public int getmabep() {
	       return mabep;
	}
	public void setmabep(int mabep) {
	       this.mabep = mabep;
	}
	public String gettenbep() {
	       return tenbep;
	}
	public void settenbep(String tenbep) {
	       this.tenbep = tenbep;
	}
	public float getsoluong() {
	       return soluong;
	}
	public void setsoluong(float soluong) {
	       this.soluong = soluong;
	}
	public String getNhasanxuat() {
	       return Nhasanxuat;
	}
	public void setNhasanxuat(String Nhasanxuat) {
	       this.Nhasanxuat = Nhasanxuat;
	}
	public float getTonkho() {
	       return Tonkho;
	}
	public void setTonkho(float Tonkho) {
	       this.Tonkho = Tonkho;
	}
	public float getSoNambaohanh() {
	       return SoNambaohanh;
	}
	public void setSoNambaohanh(float SoNambaohanh) {
	       this.SoNambaohanh = SoNambaohanh;
	}
	@Override
	public String toString() {
	      return "bep_buimanhdat [mabep=" + mabep + ", tenbep=" + tenbep + ", soluong=" + soluong + ", Nhasanxuat=" + Nhasanxuat + ", Tonkho=" + Tonkho +", SoNambaohanh="+ SoNambaohanh +"]";
	}

}


