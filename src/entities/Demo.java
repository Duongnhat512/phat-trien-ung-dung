package entities;

import java.time.LocalTime;

public class Demo {
	enum TenCaLam{
		Sang, Chieu, Toi
	}
	public static void main(String[] args) {
//		System.out.println(TenCaLam.values()[0]);
		
		CaLam caLam = new CaLam(1, LocalTime.of(7, 0, 0), LocalTime.of(15, 0, 0), 0.2);
		System.out.println(caLam.getTenCaLam());
	}
}
