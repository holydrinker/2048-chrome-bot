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
	
	void slideLeft(){
	
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
