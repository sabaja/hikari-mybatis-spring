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
	// A non-empty array A consisting of N integers is given. The array contains an
	// odd number of elements, and each element of the array can be paired with
	// another element that has the same value, except for one element that is left
	// unpaired
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
	// An array A consisting of N integers is given. Rotation of the array means
	// that each element is shifted right by one index, and the last element of the
	// array is moved to the first place
	public int[] solution2(int[] A, int K) {
		final int A_LEN = A.length;
		int arrTemp[] = new int[A_LEN - 1];
		int tempNum = 0;
		for (int k = 0; k < K; k++) {
			tempNum = A[A_LEN - 1];
			arrTemp = Arrays.copyOfRange(A, 0, A_LEN - 1);
			// print(arrTemp);
			// System.out.println();
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
	// An array A consisting of N integers is given. Rotation of the array means
	// that each element is shifted right by one index, and the last element of the
	// array is moved to the first place
	public int[] solution3(int[] A, int K) {
		int[] shiftedArray = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			if (i + K >= A.length)
				shiftedArray[(i + K) % A.length] = A[i];
			else
				shiftedArray[i + K] = A[i];
		}
		return shiftedArray;
	}

	// FrogJmp
	// A small frog wants to get to the other side of the road.
	public int solution4(int X, int Y, int D) {
		return (int) Math.ceil((double) (Y - X) / (double) D);
	}

	// BinaryGap
	// A binary gap within a positive integer N is any maximal sequence of
	// consecutive zeros that is surrounded by ones at both ends in the binary
	// representation of N.
	public int solution5(int N) {
		N >>>= Integer.numberOfTrailingZeros(N);
		int steps = 0;
		while ((N & (N + 1)) != 0) {
			N |= N >>> 1;
			steps++;
		}
		return steps;
	}

	public static void main(String[] args) {
		int[] A = { 3, 8, 9, 7, 6 };
		Solution s = new Solution();
		//
		s.print(s.solution3(A, 4));

	}

}
