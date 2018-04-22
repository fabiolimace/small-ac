package com.github.small.ac.other;

import java.util.Collection;
import java.util.UUID;

public class BasicUtil {

	public BasicUtil() {
		// TODO Auto-generated constructor stub
	}

	public static UUID getUUID() {
		return UUID.randomUUID();
	}

	public static boolean isEmpty(Collection<?> list) {
		return ((list == null) || (list.isEmpty()));
	}

	public static boolean isNotEmpty(Collection<?> list) {
		return (!(isEmpty(list)));
	}

	public static boolean isIn(Collection<?> list, Object object) {
		if (isNotEmpty(list) && isNotNull(object))
			return list.contains(object);

		return false;
	}

	public static boolean isNotIn(Collection<?> list, Object object) {
		return (!(isIn(list, object)));
	}

	private static boolean isNull(Object object) {
		return (object == null);
	}

	private static boolean isNotNull(Object object) {
		return (!(isNull(object)));
	}
}
