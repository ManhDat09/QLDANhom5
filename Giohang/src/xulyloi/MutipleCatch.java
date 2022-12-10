package xulyloi;

public class MutipleCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int a[] = new int[5];
			a[6] = 4/2;
			
		} catch (ArithmeticException e) {
			System.out.println("loi chia 0 da duoc xu ly");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("loi vuot khoi chi so mang da duoc xu ly");
		} catch (Exception e) {
			System.out.println("tat ca cac loi da duoc xu ly");
		}
		System.out.println("phan con lai cua chuong trinh");
	

	}

}
