package org.example.dz03;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		WorkWithMoney work = new WorkWithMoney();
		Money m1 = work.setNumbersOne();
		boolean one = work.init(m1); // проверка, не отрицательное
		// ли число
		
		Money m2 = work.setNumbersTwo();
		boolean two = work.init(m2); // проверка, не отрицательное
		// ли число
		
		if (one & two){
			
			Money.comparison(m1, m2); // сравнение чисел
			
			Money newNumberAfterPlus = Money.plus(m1, m2); // сложение
			
			Money.minus(m1, m2); // вычитание
			
			Money.dividingSum(newNumberAfterPlus); // деление сумм
			
			double numerator = work.numerator(); // числитель
			
			double denominator = work.denominator(); // знаменатель
			
			Money.dividingSumFractionalNumber(newNumberAfterPlus, numerator, denominator);
			// деление суммы на дробное число
			
			Money.multiplyingSumFractionalNumber(newNumberAfterPlus, numerator,
					denominator);
			// умножение суммы на дробное число
			
		}
	}
}
