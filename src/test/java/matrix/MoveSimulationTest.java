package matrix;
import static org.junit.Assert.*;
import org.junit.Test;

import com.example.brain.Matrix;

public class MoveSimulationTest {
	
	@Test
	public void test1() {
		Integer[][] data = {
				{0, 0, 2, 2},
				{4, 4, 4, 4},
				{0, 0, 0, 0},
				{8, 0, 8, 2}
		};
		Matrix matrix = new Matrix(data);
		
		Integer[][] data_ok = {
				{0, 0, 0, 4},
				{0, 0, 8, 8},
				{0, 0, 0, 0},
				{0, 0, 16, 2}
		};
		Matrix matrix_ok = new Matrix(data_ok);
		
		assertEquals(matrix.shiftRight().toString(), matrix_ok.toString());
	}
	
	@Test
	public void test2() {
		Integer[][] data = {
				{0, 0, 2, 2},
				{4, 4, 4, 4},
				{0, 0, 0, 0},
				{8, 0, 8, 2}
		};
		Matrix matrix = new Matrix(data);
		
		Integer[][] data_ok = {
				{4, 0, 0, 0},
				{8, 8, 0, 0},
				{0, 0, 0, 0},
				{16, 2, 0, 0}
		};
		Matrix matrix_ok = new Matrix(data_ok);
		
		assertEquals(matrix.shiftLeft().toString(), matrix_ok.toString());
	}
	
}
