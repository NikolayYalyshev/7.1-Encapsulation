package org.example.dz03;

import java.util.Map;
import java.util.Scanner;

public class WorkWithMoney {
	
	public Money setNumbersOne () { // ввод первого числа
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите целую часть первого числа:");
		long rub = scanner.nextLong();
		System.out.println("Введите дробную часть первого числа:");
		byte kop = scanner.nextByte();
		return new Money(rub, kop);
	}
	
	public Money setNumbersTwo () { // ввод второго числа
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите целую часть второго числа:");
		long rub1 = scanner.nextLong();
		System.out.println("Введите дробную часть второго числа:");
		byte kop1 = scanner.nextByte();
		return new Money(rub1, kop1);
	}
	
	public boolean init (Money money){ // проверка чисел
		if (money.getRub() < 0 | (money.getKop() >= 100 || money.getKop() < 0)){
			System.out.println("Ошибка проверки");
			System.out.println("Денежные значения введены не корректно" +
					"Перезапустите программу и вводите только положительные " +
					"числа");
			return false;
		} else {
			System.out.println("Проверка пройдена");
			System.out.println("число " + money.toString());
			return true;
		}
	}
	
	public double numerator (){  // числитель
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите числитель дробного числа");
		double numerator = scanner.nextDouble();
		return numerator;
	}
	
	public double denominator (){  // числитель
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите знаменатель дробного числа");
		double denominator = scanner.nextDouble();
		return denominator;
	}
}
