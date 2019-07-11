package com.prj.hikari.mybatis.spring;

import java.util.Arrays;

public class Solution {

	// MissingInteger
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

	// CyclicRotation
	public int[] solution2(int[] A, int K) {
		final int A_LEN = A.length;
		int arrTemp[] = new int[A_LEN - 1];
		int tempNum = 0;
		for (int k = 0; k < K; k++) {
			tempNum = A[A_LEN - 1];
			arrTemp = Arrays.copyOfRange(A, 0, A_LEN - 1);
//			print(arrTemp);
//			System.out.println();
			for (int i = 0; i < A_LEN; i++) {
				if (i == 0) {
					A[i] = tempNum;
				} else {
					A[i] = arrTemp[i - 1];
				}
			}
		}
		return A;
	}

	// CyclicRotation
	public int[] solution3(int[] A, int K) {
		if()
		int[] shiftedArray = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			if (i + K >= A.length)
				shiftedArray[(i + K) % A.length] = A[i];
			else
				shiftedArray[i + K] = A[i];
		}
		return shiftedArray;
	}

	public static void main(String[] args) {
		int[] A = { 3, 8, 9, 7, 6 };
		Solution s = new Solution();
//		
		s.print(s.solution3(A, 4));

	}

}
