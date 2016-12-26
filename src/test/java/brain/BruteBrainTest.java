package brain;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.brain.BruteBrain;
import com.example.brain.Move;

public class BruteBrainTest {
	Class<?> cls;
	Object obj;
	Class<?> noparams[] = {};
	Method simulation;
	Class[] simulationParamsType = new Class[2];
	
	@Before
	public void setUp() throws Exception {
		// Setting up SIMULATION
		simulationParamsType[0] = Integer[][].class;
		simulationParamsType[1] = List.class;
		
		cls = Class.forName("com.example.brain.BruteBrain");
		obj = cls.newInstance();
		
		simulation = cls.getDeclaredMethod("simulation", (Class<?>[]) simulationParamsType);
		simulation.setAccessible(true);
	}

	@Test
	public void testChoiceNewMoves() {
		BruteBrain brain = new BruteBrain();
		
		Integer[][] input = {
				{2, 4, 128, 64},
				{4, 8, 0, 2},
				{0, 2, 8, 8},
				{2, 2, 2, 2}
		};
		int[] moves = {Move.UP, Move.RIGHT};
		int[] expected = {Move.DOWN, Move.RIGHT};
		int[] result = brain.choiceNewMoves(input, moves);
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
	}
	
	@Test
	public void simulation_1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Integer[][] simulationData = {
				{0, 0, 0, 0},
				{2, 8, 4, 16},
				{8, 2, 8, 2},
				{2, 8, 2, 4}};
		
		List<String> rankedResult = new ArrayList<String>();
		rankedResult.add("DL");
		rankedResult.add("DR");
		rankedResult.add("UR");
		rankedResult.add("UL");
		
		Object[] simulationParams = {simulationData, rankedResult};
		String result = (String) simulation.invoke(obj, simulationParams);
        assertEquals("UR", result);
	}
	
	@Test
	public void simulation_2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Integer[][] simulationData = {
				{2, 4, 128, 64},
				{4, 8, 0, 2},
				{0, 2, 8, 8},
				{2, 2, 2, 2}};
		
		List<String> rankedResult = new ArrayList<String>();
		rankedResult.add("UR");
		rankedResult.add("DR");
		rankedResult.add("UL");
		rankedResult.add("DL");
		
		Object[] simulationParams = {simulationData, rankedResult};
		String result = (String) simulation.invoke(obj, simulationParams);
        assertEquals("UR", result);
	}

}
