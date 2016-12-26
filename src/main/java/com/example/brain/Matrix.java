package com.example.brain;

import java.util.Arrays;

public class Matrix implements Comparable{
	private Integer[][] input;
	private int rows;
	private int columns;
	
	public Matrix(Integer[][] input) {
		this.input = input;
		this.rows = input.length;
		this.columns = input[0].length;
	}
	
	public Matrix() {
		this.input = new Integer[0][0];
	}
	
	public Matrix shiftRight() {
		Integer[][] tmp = input.clone();
		for(int row = 0; row < input.length; row++) {
			tmp[row] = rowMerge(tmp[row]);
		}
		return new Matrix(tmp);
	}
	
	// Wrapping for method below 
	public Integer[] rowMerge(Integer[] tmp){
		return singleRowMerge(tmp, 0);
	}
	
	// Merge a row's cells from left to ride
	private Integer[] singleRowMerge (Integer[] tmp, int idx) {
		if(idx == tmp.length - 1)
			return tmp;
		
		if(tmp[idx + 1] == 0) {
			tmp[idx + 1] = tmp[idx];
			for(int i = idx; i > 0; i--)
				tmp[i] = tmp[i - 1];
			tmp[0] = 0;
		} else if (tmp[idx + 1] == tmp[idx]) {
			tmp[idx + 1] = tmp[idx + 1] * 2;
			for(int i = idx; i > 0; i--)
				tmp[i] = tmp[i - 1];
			tmp[0] = 0;
		} 
		
		return singleRowMerge(tmp, idx + 1);
	}
	
	@Override
	public String toString() {
		String result = "[";
		for(Integer[] row : input){
			result += Arrays.toString(row);
		}
		result += "]";
		return result;
	}

	public int compareTo(Object arg0) {
		Matrix other = (Matrix) arg0;
		return this.toString().compareTo(other.toString());
	}
	
}
