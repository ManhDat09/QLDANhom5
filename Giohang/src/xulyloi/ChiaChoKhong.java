package xulyloi;

public class ChiaChoKhong {
	
	public void chia() {
		int n1 = 20;
		int n2 = 0;
		try{
		System.out.println(n1+"/"+n2+"="+(n1/n2));
		} catch(ArithmeticException e) {
			System.out.println("Error:" +e.getMessage());
		}
		finally {
			System.out.println("Nhung viec can thuc hien ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChiaChoKhong ch = new ChiaChoKhong();
		ch.chia();
		System.out.println("Quay lai tu ham main1");

	}

}
