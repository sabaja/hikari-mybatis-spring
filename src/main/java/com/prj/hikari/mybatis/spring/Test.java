package com.prj.hikari.mybatis.spring;

public class Test {

	public static void main(String[] args) throws Exception {
		int[] arr = { -1, 1, 3, 3, 3, 2, 3, 2, 1, 0 };
		// int[] arr = { 2, 2, 2, 2 };
		Test t = new Test();
		System.out.println("\nperiodi: " + t.solution(arr));

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

	public int solution(int[] arr) throws Exception {
		if (arr.length < 3)
			return -1;
		final int DIFF_LEN = arr.length - 1;
		int[] diff = new int[DIFF_LEN]; // difference are
		int[] binaryArr = new int[DIFF_LEN - 1];
		int[] binaryRecurrence = new int[DIFF_LEN / 2];

		for (int i = 0; i < DIFF_LEN; i++) {
			diff[i] = arr[i] - arr[i + 1];
		}

		for (int i = 0; i < DIFF_LEN - 1; i++) {
			if (diff[i] == diff[i + 1]) {
				binaryArr[i] = 1;
			}
		}
		System.out.print("binaryArr:\t");

		print(binaryArr);
		System.out.println();
		int count = 0;
		for (int i = 0; i < binaryArr.length - 1; i++) {
			if (binaryArr[i] == binaryArr[i + 1] && binaryArr[i] == 1) {
				binaryRecurrence[count] += binaryArr[i] + binaryArr[i + 1];
			} else if (binaryArr[i] == 1) {
				binaryRecurrence[count] += binaryArr[i];
				count++;
			} else {
				// count++;
				continue;
			}
		}

		System.out.print("binary recurrence:\t");
		print(binaryRecurrence);
		int n = 0;

		for (int ele : binaryRecurrence) {
			if (ele > 0) {
				n += ele * (1 + ele) / 2;
			}
		}

		// summation
		return n ;
	}

	public void print(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%d ", A[i]);
		}
	}
}
