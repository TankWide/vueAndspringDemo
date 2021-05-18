package com.example.demo.util;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 继承自Spring util的工具类，减少jar依赖
 *
 */
public class StringUtil extends StringUtils {

	/**
	 * 首字母变小写
	 * 
	 * @param str
	 *            字符串
	 * @return {String}
	 */
	public static String firstCharToLowerCase(String str) {
		char firstChar = str.charAt(0);
		if (firstChar >= 'A' && firstChar <= 'Z') {
			char[] arr = str.toCharArray();
			arr[0] += ('a' - 'A');
			return new String(arr);
		}
		return str;
	}

	/**
	 * 首字母变大写
	 * 
	 * @param str
	 *            字符串
	 * @return {String}
	 */
	public static String firstCharToUpperCase(String str) {
		char firstChar = str.charAt(0);
		if (firstChar >= 'a' && firstChar <= 'z') {
			char[] arr = str.toCharArray();
			arr[0] -= ('a' - 'A');
			return new String(arr);
		}
		return str;
	}

	/**
	 * Check whether the given {@code CharSequence} contains actual
	 * <em>text</em>.
	 * <p>
	 * More specifically, this method returns {@code true} if the
	 * {@code CharSequence} is not {@code null}, its length is greater than 0,
	 * and it contains at least one non-whitespace character.
	 * 
	 * <pre class="code">
	 * StringUtil.isBlank(null) = true
	 * StringUtil.isBlank("") = true
	 * StringUtil.isBlank(" ") = true
	 * StringUtil.isBlank("12345") = false
	 * StringUtil.isBlank(" 12345 ") = false
	 * </pre>
	 *
	 * @param cs
	 *            the {@code CharSequence} to check (may be {@code null})
	 * @return {@code true} if the {@code CharSequence} is not {@code null}, its
	 *         length is greater than 0, and it does not contain whitespace only
	 * @see Character#isWhitespace
	 */
	public static boolean isBlank(@Nullable final CharSequence cs) {
		return !StringUtils.hasText(cs);
	}

	/**
	 * <p>
	 * Checks if a CharSequence is not empty (""), not null and not whitespace
	 * only.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.isNotBlank(null)	  = false
	 * StringUtil.isNotBlank("")		= false
	 * StringUtil.isNotBlank(" ")	   = false
	 * StringUtil.isNotBlank("bob")	 = true
	 * StringUtil.isNotBlank("  bob  ") = true
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is not empty and not null and
	 *         not whitespace
	 * @see Character#isWhitespace
	 */
	public static boolean isNotBlank(@Nullable final CharSequence cs) {
		return StringUtils.hasText(cs);
	}

	/**
	 * 判断一个字符串是否是数字
	 * 
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {boolean}
	 */
	public static boolean isNumeric(final CharSequence cs) {
		if (StringUtil.isBlank(cs)) {
			return false;
		}
		for (int i = cs.length(); --i >= 0;) {
			int chr = cs.charAt(i);
			if (chr < 48 || chr > 57) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Convert a {@code Collection} into a delimited {@code String} (e.g., CSV).
	 * <p>
	 * Useful for {@code toString()} implementations.
	 *
	 * @param coll
	 *            the {@code Collection} to convert
	 * @return the delimited {@code String}
	 */
	public static String join(Collection<?> coll) {
		return StringUtils.collectionToCommaDelimitedString(coll);
	}

	/**
	 * Convert a {@code Collection} into a delimited {@code String} (e.g. CSV).
	 * <p>
	 * Useful for {@code toString()} implementations.
	 *
	 * @param coll
	 *            the {@code Collection} to convert
	 * @param delim
	 *            the delimiter to use (typically a ",")
	 * @return the delimited {@code String}
	 */
	public static String join(Collection<?> coll, String delim) {
		return StringUtils.collectionToDelimitedString(coll, delim);
	}

	/**
	 * Convert a {@code String} array into a comma delimited {@code String}
	 * (i.e., CSV).
	 * <p>
	 * Useful for {@code toString()} implementations.
	 *
	 * @param arr
	 *            the array to display
	 * @return the delimited {@code String}
	 */
	public static String join(Object[] arr) {
		return StringUtils.arrayToCommaDelimitedString(arr);
	}

	/**
	 * Convert a {@code String} array into a delimited {@code String} (e.g.
	 * CSV).
	 * <p>
	 * Useful for {@code toString()} implementations.
	 *
	 * @param arr
	 *            the array to display
	 * @param delim
	 *            the delimiter to use (typically a ",")
	 * @return the delimited {@code String}
	 */
	public static String join(Object[] arr, String delim) {
		return StringUtils.arrayToDelimitedString(arr, delim);
	}

	/**
	 * 生成uuid
	 *
	 * @return UUID
	 */
	public static String getRandomUUID() {
		return java.util.UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 转义HTML用于安全过滤
	 *
	 * @param html
	 *            html
	 * @return {String}
	 */
	public static String escapeHtml(String html) {
		return HtmlUtils.htmlEscape(html);
	}

	// 随机字符串
	private static final String INT_STR = "0123456789";
	private static final String STR_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final String ALL_STR = INT_STR + STR_STR;

	/**
	 * 生成的随机数类型
	 */
	public enum RandomType {
		INT, STRING, ALL;
	}

	/**
	 * 随机数生成
	 *
	 * @param count
	 *            字符长度
	 * @return 随机数
	 */
	public static String random(int count) {
		return StringUtil.random(count, RandomType.ALL);
	}

	/**
	 * 随机数生成
	 *
	 * @param count
	 *            字符长度
	 * @param randomType
	 *            随机数类别
	 * @return 随机数
	 */
	public static String random(int count, RandomType randomType) {
		if (count == 0) {
			return "";
		}
		Assert.isTrue(count > 0, "Requested random string length " + count + " is less than 0.");
		final ThreadLocalRandom random = ThreadLocalRandom.current();
		char[] buffer = new char[count];
		for (int i = 0; i < count; i++) {
			if (RandomType.INT == randomType) {
				buffer[i] = INT_STR.charAt(random.nextInt(INT_STR.length()));
			} else if (RandomType.STRING == randomType) {
				buffer[i] = STR_STR.charAt(random.nextInt(STR_STR.length()));
			} else {
				buffer[i] = ALL_STR.charAt(random.nextInt(ALL_STR.length()));
			}
		}
		return new String(buffer);
	}
}
