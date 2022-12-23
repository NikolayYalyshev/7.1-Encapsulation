package org.example.dz03;

public class Main {
	public static void main(String[] args) {
		WorkWithMoney work = new WorkWithMoney();
		Money money1;
		Money money2;
		while (true) {
			money1 = work.scanNumber("первого");
			
			boolean numberValid =
					work.init(money1); // проверка, не отрицательное
			// ли число
			if (numberValid) {
				break;
			}
		}
		while (true) {
			money2 = work.scanNumber("второго");
			boolean numberValid =
					work.init(money2); // проверка, не отрицательное
			// ли число
			if (numberValid) {
				break;
			}
		}
		
		Money.comparison(money1, money2); // сравнение чисел
		
		Money newNumberAfterPlus = money1.plus(money2); //
		// сложение
		
		money1.minus(money2); // вычитание
		
		newNumberAfterPlus.dividingSum(); // деление сумм
		
		double numerator = work.scanNumerator(); // числитель
		
		double denominator = work.scanDenominator(); // знаменатель
		
		newNumberAfterPlus.dividingSumFractionalNumber(numerator,
				denominator);
		// деление суммы на дробное число
		
		newNumberAfterPlus.multiplyingSumFractionalNumber(numerator,
				denominator);
		// умножение суммы на дробное число
		
		
	}
}
