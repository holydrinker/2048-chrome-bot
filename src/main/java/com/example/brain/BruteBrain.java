package com.example.brain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BruteBrain implements Brain {
	private static int count = 0;
	private static int[] moves = { Move.UP, Move.LEFT };
	private static int previousMove = moves[1];
	private static Matrix previousState = new Matrix();;

	public int computeNextMove(Integer[][] input) {
		Matrix state = new Matrix(input); 
		
		// Logger...
		System.out.println("move: " + Arrays.toString(moves));
		System.out.println(previousState.toString());
		System.out.println(state.toString());
		System.out.println(count);
		
		// Check if we are in a deadlock
		if(state.compareTo(previousState) == 0) 
			count++;
		else
			count = 0;
		previousState = state;
		
		// Compute next move
		if (count < 2) { // no deadlock
			if (previousMove == moves[1]) {
				previousMove = moves[0];
				return moves[0];
			} else if (previousMove == moves[0]) {
				previousMove = moves[1];
				return moves[1];
			}
		} else { // deadlock
			moves = choiceNewMoves(input, moves);
			previousMove = moves[0];
			count = 0;
			return moves[0];
		}

		return -1;
	}

	/**
	 * Split the matrix in 4 quadrants. Every quadrant correspond to a pair of direction (i.e. first quad correspond to [UP, LEFT])
	 * Compute the weight of every quadrant (ignoring the quad corresponding to the previous direction).
	 * Descending sorting of every quadrant based on their weights.
	 * Simulate if the choosen direction 'd' can do two moves changing state at least one time.
	 * If it can do it, we choose 'd' as new direction
	 * Otherwise, choose another direction in the direction available and repeat the simulation.
	 * 
	 * @param matrix
	 * @param moves
	 * @return The heaviest of the quadrants
	 */
	public int[] choiceNewMoves(Integer[][] matrix, int[] moves) {
		// Compute weights
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("UL", matrix[0][0] + matrix[0][1] + matrix[1][0] + matrix[1][1]);
		map.put("UR", matrix[0][2] + matrix[0][3] + matrix[1][2] + matrix[1][3]);
		map.put("DL", matrix[2][0] + matrix[2][1] + matrix[3][0] + matrix[3][1]);
		map.put("DR", matrix[2][2] + matrix[2][3] + matrix[3][2] + matrix[3][3]);
		
		// Remove previous direction
		if(moves[0] == Move.UP && moves[1] == Move.LEFT) map.remove("UL");
		else if(moves[0] == Move.UP && moves[1] == Move.RIGHT) map.remove("UR");
		else if(moves[0] == Move.DOWN && moves[1] == Move.LEFT) map.remove("DL");
		else if(moves[0] == Move.DOWN && moves[1] == Move.RIGHT) map.remove("DR");
		
		// Descending sorting
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>(new ValueComparator(map));
		sortedMap.putAll(map);
		
		List<String> keys = new ArrayList<String>();
		keys.addAll(sortedMap.keySet());
		String result = keys.get(0);
		
		// Decoding result
		if(result.equals("UL")){
			int[] res = {Move.UP, Move.LEFT};
			return res;
		}
		if(result.equals("DL")){
			int[] res = {Move.DOWN, Move.LEFT};
			return res;
		}
		if(result.equals("UR")){
			int[] res = {Move.UP, Move.RIGHT};
			return res;
		}
		if(result.equals("DR")){
			int[] res = {Move.DOWN, Move.RIGHT};
			return res;
		}
			
		return null;
	}

	@SuppressWarnings("unused")
	private class ValueComparator implements Comparator<String>{
		private Map<String, Integer> base;
		@SuppressWarnings("unused")
		public ValueComparator(final Map<String, Integer> base) {
			this.base = base;
		}
		public int compare(String o1, String o2) {
			if(base.get(o1) < base.get(o2)) return 1;
			else if (base.get(o1) > base.get(o2)) return -1;
			else return 0;
		}
	}
}
