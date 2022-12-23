package org.example.dz03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Money {
	private long rub;
	private byte kop;
	
	public Money(long rub, byte kop) {
		this.rub = rub;
		this.kop = kop;
	}
	
	public Money(double rubDouble) {
		this.rub = (long) rubDouble;
		this.kop = (byte)(Math.round(rubDouble * 100) % 100);
	}
	
	public long getRub() {
		return rub;
	}
	
	
	public byte getKop() {
		return kop;
	}
	
	
	@Override
	public String toString() {
		if (kop >= 0 & kop <= 9) {
			return rub + ",0" + kop;
		}
		return rub + "," + kop;
	}
	
	public Money plus(Money second) { // сложение
		int kopSum = this.kop + second.kop;
		long newRub = this.rub + second.rub + kopSum / 100;
		byte newKop = (byte) (kopSum % 100);
		Money money = new Money(newRub, newKop);
		System.out.println("Сумма чисел равняется " + money.toString());
		return money;
	}
	
	public Money minus(Money second) { // вычитание
		long newRub = this.rub - second.rub;
		int kopDiff = this.kop - second.kop;
		if (kopDiff < 0) {
			newRub--;
			kopDiff += 100;
		}
		byte newKop = (byte) (kopDiff % 100);
		Money newNumberAfterMinus = new Money(newRub, newKop);
		if (newNumberAfterMinus.getRub() > 0) {
			System.out.println(
					"Разница двух чисел равна " + newNumberAfterMinus);
			return newNumberAfterMinus;
		} else {
			System.out.println(
					"При вычитании получилось отрицательное число" +
							newNumberAfterMinus);
			return newNumberAfterMinus;
		}
	}
	
	public Money dividingSum() {  // деление сумм
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите делитель для суммы: ");
		int num = scanner.nextInt(); // todo передать num как параметр и  del
		// todo scan
		long rubs = (this.rub * 100) + this.kop;
		int number = (int) (rubs / num);
		long newRub = number / 100;
		byte newKop = (byte) (number % 100);
		Money newNumberAfterDividingSum = new Money(newRub, newKop);
		System.out.println("При делении сумм получилось " +
				newNumberAfterDividingSum.toString());
		return newNumberAfterDividingSum;
	}
	
	public Money dividingSumFractionalNumber( double numerator,
											 double denominator) { //
		// деление
		// суммы на дробное число
		
		long dividend = (this.rub * 100) + this.kop;// делимое число
		double numberFormula = (dividend * denominator) / (100 * numerator);
		Money money = new Money(numberFormula);
		System.out.println(
				"При делении суммы на дробное число " + numerator + "/" +
						denominator + " получилось " + money);
		return money;
	}
	
	public Money multiplyingSumFractionalNumber(double numerator,
												double denominator) {
		//умножение суммы на дробное число
		
		long dividend = (this.rub * 100) + this.kop;// делимое число
		double numberFormula = (dividend * numerator) / (100 * denominator);
		Money money = new Money(numberFormula);
		System.out.println(
				"При умножении суммы на дробное число " + numerator + "/" +
						denominator + " получилось " + money);
		return money;
	}
	
	
	
	public static void comparison(Money first, Money second) { // сравнени
		long kop1 = first.rub * 100 + first.kop;
		long kop2 = second.rub * 100 + second.kop;
		if (kop1 == kop2){
			System.out.println("Числа одинаковые");
		} else if (kop1 < kop2){
			System.out.println("Второе число больше первого!");
		} else {
			System.out.println("Первое число больше второго!");
		}
	}
}
	
