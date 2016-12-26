package com.example.brain;

import java.util.Arrays;
import java.util.Collections;

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
	
	public Matrix shiftLeft() {
		return this.mirrored().shiftRight().mirrored();
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
	
	// Generate mirrored matrix
	private Matrix mirrored() {
		Integer[][] newData = new Integer[input.length][input[0].length];
		for(int i = 0; i < input.length; i++) {
			Integer[] row = input[i];
			Integer[] tmp = new Integer[row.length];
			for(int j = 0; j < row.length; j++){
				tmp[j] = row[row.length - 1 - j];
				newData[i] = tmp;
			}
		}
		return new Matrix(newData);
	}
	
	private Matrix transpose() {
		Integer[][] tmp = new Integer[input[0].length][input.length];
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[0].length; j++) {
				tmp[j][i] = input[i][j];
			}
		}
		return new Matrix(tmp);
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
