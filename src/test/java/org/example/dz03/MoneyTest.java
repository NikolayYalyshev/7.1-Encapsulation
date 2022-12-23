package org.example.dz03;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
	private static final ByteArrayOutputStream outContent =
			new ByteArrayOutputStream();
	private static final ByteArrayOutputStream errContent =
			new ByteArrayOutputStream();
	private static final PrintStream originalOut = System.out;
	private static final PrintStream originalErr = System.err;
	
	@BeforeAll
	public static void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
	@AfterAll
	public static void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}
	@AfterEach
	public void resetContent(){
		outContent.reset();
		errContent.reset();
	}
	
	@Test
	void comparison() {
		Money.comparison(new Money(10L,(byte) 50), new Money(10L,
				(byte) 50));
		assertEquals("Числа одинаковые\n", outContent.toString());
		outContent.reset();
		
		Money.comparison(new Money(10L,(byte) 50), new Money(10L,
				(byte) 49));
		assertEquals("Первое число больше второго!\n", outContent.toString());
		outContent.reset();
		
		Money.comparison(new Money(10L,(byte) 50), new Money(10L,
				(byte) 51));
		assertEquals("Второе число больше первого!\n", outContent.toString());
		outContent.reset();
		
		Money.comparison(new Money(9L,(byte) 50), new Money(10L,
				(byte) 49));
		assertEquals("Второе число больше первого!\n", outContent.toString());
		outContent.reset();
		
		Money.comparison(new Money(11L,(byte) 50), new Money(10L,
				(byte) 50));
		assertEquals("Первое число больше второго!\n", outContent.toString());
		outContent.reset();
	}
}