package org.example.dz03;

import java.util.Scanner;

public class Money {
	private long Rub;
	private byte Kop;
	
	public Money(long rub, byte kop) {
		this.Rub = rub;
		this.Kop = kop;
	}
	
	public long getRub() {
		return Rub;
	}
	
	public void setRub(long rub) {
		this.Rub = rub;
	}
	
	public byte getKop() {
		return Kop;
	}
	
	public void setKop(byte kop) {
		this.Kop = kop;
	}
	
	@Override
	public String toString() {
		return Rub + "," + Kop;
	}
	
	public static Money plus (Money first, Money second){ // сложение
		int kopSum = first.Kop + second.Kop;
		long newRub = first.Rub + second.Rub + kopSum/100;
		byte newKop = (byte)(kopSum % 100);
		Money money = new Money(newRub, newKop);
		System.out.println("Сумма чисел равняется " + money.toString());
		return money;
	}
	
	public static Money minus (Money first, Money second) { // вычитание
		long newRub = first.Rub - second.Rub;
		int kopDiff = first.Kop - second.Kop;
		if (kopDiff < 0) {
			newRub--;
			kopDiff += 100;
		}
		byte newKop = (byte) (kopDiff % 100);
		Money newNumberAfterMinus = new Money(newRub, newKop);
		if (newNumberAfterMinus.getRub() > 0){
			System.out.println("Разница двух чисел равна " + newNumberAfterMinus);
			return newNumberAfterMinus;
		}
			else {
			System.out.println("При вычитании получилось отрицательное " +
					"число" + newNumberAfterMinus);
				return newNumberAfterMinus;
		}
	}
	
	public static Money dividingSum (Money plus){  // деление сумм
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите делитель для суммы: ");
		int num = scanner.nextInt();
		long rubs = (plus.Rub * 100) + plus.Kop;
		int number =(int)  (rubs / num);
		long newRub =number/100;
		byte newKop = (byte) (number%100);
		Money newNumberAfterDividingSum = new Money(newRub, newKop);
		System.out.println("При делении сумм получилось " + newNumberAfterDividingSum.toString());
		return newNumberAfterDividingSum;
	}
	
	public static double dividingSumFractionalNumber (Money plus, double num1
			, double num2){ // деление суммы на дробное число
		
		long dividend = (plus.Rub*100) + plus.Kop;// делимое число
		double numberFormula =(dividend * num2) / (100 * num1);
		System.out.println("При делении суммы на дробное число " + num1 +
				"/" + num2 + " получилось " + numberFormula);
		return numberFormula;
	}
	
	public static double multiplyingSumFractionalNumber (Money plus, double numerator, double denominator){
		//умножение суммы на дробное число
		
		long dividend = (plus.Rub*100) + plus.Kop;// делимое число
		double numberFormula =(dividend * numerator) / (100 * denominator);
		System.out.println("При умножении суммы на дробное число " + numerator +
				"/" + denominator + " получилось " + numberFormula);
		return numberFormula;
	}
	
	public static void comparison (Money first, Money second){ // сравнени
		if (first.Rub > second.Rub){
			System.out.println("Первое число больше второго!");
		} else if (first.Rub == second.Rub & first.Kop > second.Kop) {
				System.out.println("Первое число больше второго!");
		} else if (first.Rub == second.Rub & first.Kop < second.Kop){
				System.out.println("Второе число больше первого");
		}
		else if (first.Rub == second.Rub & first.Kop == second.Kop){
				System.out.println("Числа одинаковые");
			}
		else {
				System.out.println("Второе число больше первого");
			}
		}
	}
	
