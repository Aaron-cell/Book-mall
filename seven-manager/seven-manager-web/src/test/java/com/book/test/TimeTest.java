package com.book.test;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;

public class TimeTest {
	@Test
	public void imagePath() {
		String imagePath = new DateTime().toString("/yyyy/MM/dd/");
		System.out.println(imagePath);
	}
}
