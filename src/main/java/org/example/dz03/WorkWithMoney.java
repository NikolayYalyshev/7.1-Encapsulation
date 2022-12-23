package org.example.dz03;

import java.util.Scanner;

public class WorkWithMoney {
	private Scanner scanner = new Scanner(System.in);
	
	public Money scanNumber(String number) { // ввод первого
		// числа
		System.out.println("Введите целую часть " + number + " числа:");
		long rub = scanner.nextLong();
		byte kop;
		while (true) {
			System.out.println("Введите дробную часть " + number + " числа:");
			Byte kop2 = scanKop();
			if (kop2 != null) {
				kop = kop2;
				break;
			}
		}
		return new Money(rub, kop);
	}
	
	private Byte scanKop() {
		byte kop;
		try {
			kop = scanner.nextByte();
			if (kop < 0 || kop >= 100) {
				System.out.println("Копеек не может быть больше 100");
				return null;
			} else {
				return kop;
			}
		} catch (Exception e) {
			System.out.println("Недопустимое кол-во копеек");
			scanner = new Scanner(System.in);
		}
		return null;
	}
	
	public boolean init(Money money) { // проверка чисел
		if (money.getRub() < 0 |
				(money.getKop() >= 100 || money.getKop() < 0)) {
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
	
	public double scanNumerator() {  // числитель
		System.out.println("Введите числитель дробного числа");
		double numerator = scanner.nextDouble();
		return numerator;
	}
	
	public double scanDenominator() {  // знаменатель
		System.out.println("Введите знаменатель дробного числа");
		double denominator = scanner.nextDouble();
		return denominator;
	}
}
