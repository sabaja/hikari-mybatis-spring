package com.prj.hikari.mybatis.spring;

import java.util.Arrays;

public class Solution {

	//MissingInteger
	public int solution(int[] A) {
		// write your code in Java SE 8
		int[] B = new int[1_000_001];
		int min = 1;
		for (int number : A) {
			if (number > 0) {
				B[number] = 1;
			}
		}
		for (int i = 1; i < B.length; i++) {
			if (B[i] == 0) {
				min = i;
				break;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 1, 3, 3, 4, 4 };
		Solution s = new Solution();
		System.out.println(s.solution1(A));

	}

	public void print(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%d ", A[i]);
		}
	}

	// OddOccurrencesInArray
	public int solution1(int[] A) {
		Arrays.sort(A);
		for (int i = 0; i < A.length - 1; i += 2) {
			if (A[i] != A[i + 1]) {
				return A[i];
			}
		}
		return A[A.length - 1];
	}

}
