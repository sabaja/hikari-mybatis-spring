package com.prj.hikari.mybatis.spring;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		int[] arr = { -1, 1, 3, 3, 3, 2, 3, 2, 1, 0 };
		Test t = new Test();
		System.out.println(t.solution(arr));

	}

	public static int solution(String S) {
		final int ZERO_CONST = 0;
		if (null == S || "".equals(S))
			return ZERO_CONST;

		int temp, c = ZERO_CONST;
		final int num = Integer.parseInt(S, 2);
		if (num == ZERO_CONST) {
			return ZERO_CONST;
		}

		temp = num;
		while (temp >= 1) {
			if (temp % 2 == 0) {
				temp /= 2;
			} else {
				temp -= 1;
			}
			c++;
		}
		return c;
	}

	public int solution(int[] arr) {
		final int DIFF_LEN = arr.length - 1;
		int[] diff = new int[DIFF_LEN]; // difference are
		int[] binaryArr = new int[DIFF_LEN - 1];

		for (int i = 0; i < DIFF_LEN; i++) {
			diff[i] = arr[i] - arr[i + 1];
		}

		for (int i = 0; i < DIFF_LEN - 1; i++) {
			if (diff[i] == diff[i + 1]) {
				binaryArr[i] = 1;
			}
		}
		print(binaryArr);
	}

	public void print(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%d ", A[i]);
		}
	}
}
