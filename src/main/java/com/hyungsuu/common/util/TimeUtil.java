package com.hyungsuu.common.util;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.RandomStringGenerator;

public class TimeUtil {

	public static long getCurrentTimewithMillis() {
		Date date = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

	public static String getDateFormatyyyyMMddHHmmssSSSS() {
		return new SimpleDateFormat("yyyMMddHHmmssSSSS").format(new Date());
	}

	public static String getRandomNum(int count) {

		if (count < 0)
			count = 6;

		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', '9').get();

		return generator.generate(count);
	}

	public static String getDateAndRandom() {

		return getDateFormatyyyyMMddHHmmssSSSS() + getRandomNum(6);
	}

	/**
	 * 자릿수(digit) 만큼 랜덤한 숫자를 반환 받습니다.
	 *
	 * @param length 자릿수
	 * @return 랜덤한 숫자
	 */
	public static int generateRandomNum(int length) {
		SecureRandom secureRandom = new SecureRandom();
		int upperLimit = (int) Math.pow(10, length);
		return secureRandom.nextInt(upperLimit);
	}

	/**
	 * 시작 범위(start)와 종료 범위(end) 값을 받아서 랜덤한 숫자를 반환 받습니다.
	 *
	 * @param start 시작 범위
	 * @param end   종료 범위
	 * @return 랜덤한 숫자
	 */
	public static int generateRangeRandomNum(int start, int end) {
		SecureRandom secureRandom = new SecureRandom();
		return start + secureRandom.nextInt(end + 1);
	}

	/**
	 * 자릿수(length) 만큼 랜덤한 문자열을 대문자/소문자에 따라 반환 받습니다.
	 *
	 * @param length      자릿수
	 * @param isUpperCase 대문자 여부
	 * @return 랜덤한 문자열
	 */
	public static String generateRandomStr(int length, boolean isUpperCase) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		SecureRandom secureRandom = new SecureRandom();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(alphabet.charAt(secureRandom.nextInt(alphabet.length())));
		}
		return isUpperCase ? sb.toString().toUpperCase() : sb.toString().toLowerCase();
	}

	/**
	 * 자릿수(length) 만큼 랜덤한 숫자 + 문자 조합을 대문자/소문자에 따라 반환 받습니다.
	 *
	 * @param length      자릿수
	 * @param isUpperCase 대문자 여부
	 * @return 랜덤한 숫자 + 문자 조합의 문자열
	 */
	public static String generateRandomMixStr(int length, boolean isUpperCase) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			sb.append(characters.charAt(index));
		}
		return isUpperCase ? sb.toString() : sb.toString().toLowerCase();
	}

	public static void main(String[] args) {
		String str = getDateAndRandom();
		String str1 = RandomStringUtils.randomNumeric(10);
//    	String str = getDateFormatyyyyMMddHHmmssSSSS();
		String str4 = getRandomNum(6);
		long milliseconds = System.currentTimeMillis();
		long milliseconds2 = System.currentTimeMillis() + 5000;

		Date date1 = new java.sql.Timestamp(milliseconds);
		Date date2 = new java.sql.Timestamp(milliseconds2);
		long newmilliseconds = date1.getTime();
		long newmilliseconds2 = date2.getTime();

		System.out.println(str4);
		System.out.println(milliseconds);
		System.out.println(milliseconds2);
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(newmilliseconds);
		System.out.println(newmilliseconds2);
	}
}
