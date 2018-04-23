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

    @SuppressWarnings("unchecked")
	public static <T> T[] concat(T[] array1, T... array2) {
        T[] array = (T[]) new Object[array1.length + array2.length];
        System.arraycopy(array1, 0, array, 0, array1.length);
        System.arraycopy(array2, 0, array, array1.length, array2.length);
        return array;
    }
}
