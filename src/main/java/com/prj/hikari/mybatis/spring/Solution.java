package com.prj.hikari.mybatis.spring;

public class Solution {

	public int solution(int[] A) {
		final int MAX = A.length;
		int[] register = new int[MAX];
		int ret = 1;
		for (int i : A) {
			if (i < 0)
				break;
			register[i - 1] = 1;
		}

		for (int i = 0; i < MAX; i++) {
			if (register[i] == 0) {
				ret = i + 1;
				break;
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		int[] A = { -1, -3 };
		Solution s = new Solution();
		System.out.println("\n" + s.solution(A));

	}

	public void print(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%d ", A[i]);
		}
	}
}
