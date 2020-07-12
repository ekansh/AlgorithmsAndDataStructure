package com.crackingcoding.sortingalgorithm;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int [] input= new int[] {1,5,2,6,0,8,3,4,7};
		mergesortv3(input,0, input.length);
		Arrays.stream(input).forEach(e -> System.out.print(e+" ,"));
	}
	private static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int i = 0, j = 0;
		for (int k = 0; k < c.length; k++) {
			if (i >= a.length)
				c[k] = b[j++];
			else if (j >= b.length)
				c[k] = a[i++];
			else if (a[i] <= b[j])
				c[k] = a[i++];
			else
				c[k] = b[j++];
		}
		return c;
	}

	public static int[] mergesortv1(int[] input) {
		int N = input.length;
		if (N <= 1)
			return input;
		int[] a = new int[N / 2];
		int[] b = new int[N - N / 2];
		for (int i = 0; i < a.length; i++)
			a[i] = input[i];
		for (int i = 0; i < b.length; i++)
			b[i] = input[i + N / 2];
		int[] mergesortA = mergesortv1(a);
		int[] mergesortB = mergesortv1(b);
		return merge(mergesortA,mergesortB);
	}
	public static int[] mergesortv2(int[] input) {
		int N = input.length;
		if (N <= 1)
			return input;
		int[] a = Arrays.copyOf(input, N/2);
		int[] b = Arrays.copyOfRange(input, N/2, N);
		
		int[] mergesortA = mergesortv2(a);
		int[] mergesortB = mergesortv2(b);
		return merge(mergesortA,mergesortB);
	}
	
	public static void mergesortv3(int[] input,int l, int r) {
		if (l+1>=r)
			return ;
		int mid = l+(r-l)/2;
		mergesortv3(input,l,mid);
		mergesortv3(input,mid,r);
		mergev3(input,l,mid,r);
	}
	public static void mergev3(int[] input, int l, int mid, int r) {
		int[] sortedArray= new int [r-l];
		int k=0, i =l,j=mid;
		for( ; i<mid && j<r; ) {
			if(input[i]<input[j]) {
				sortedArray[k++]=input[i++];
			}else if(input[i]>=input[j]) {
				sortedArray[k++]=input[j++];
			}
		}
		for( ; i<mid;i++) {
			sortedArray[k++]=input[i];
		}
		for( ; j<r;j++) {
			sortedArray[k++]=input[j];
		}
		k=0;
		for(int p=l ; p<r;p++) {
			input[p]=sortedArray[k++];
		}
	}
}
