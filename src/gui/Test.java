package gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import form.ThongKeKPI_Form;

public class Test{
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld = LocalDate.parse("10/10/2023", dtf);
		System.out.println(dtf.format(ld));
	}
}