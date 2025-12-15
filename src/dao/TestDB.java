package dao;


public class TestDB {
	public static void main(String[] args) {
		try {
			DBConnection.getConnection();
			System.out.println("Ket noi SQL thanh cong");
		} catch (Exception e) {
			System.out.println("Ket noi that bai");
			e.printStackTrace();
		}
	}

}
