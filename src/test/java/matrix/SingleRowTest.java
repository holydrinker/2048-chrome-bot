package matrix;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

import com.example.brain.Matrix;

public class SingleRowTest {
	Matrix matrix = new Matrix();

	@Test
	public void test1() {
		Integer[] row = {0, 0, 2, 2};
		Integer[] row_ok = {0, 0, 0, 4};
		assertEquals(Arrays.toString(matrix.rowMerge(row)), Arrays.toString(row_ok));
	}
	
	@Test
	public void test2() {
		Integer[] row = {2, 2, 2, 2};
		Integer[] row_ok = {0, 0, 4, 4};
		assertEquals(Arrays.toString(matrix.rowMerge(row)), Arrays.toString(row_ok));
	}
	
	@Test
	public void test3() {
		Integer[] row = {8, 2, 0, 2};
		Integer[] row_ok = {0, 0, 8, 4};
		assertEquals(Arrays.toString(matrix.rowMerge(row)), Arrays.toString(row_ok));
	}
	
	@Test
	public void test4() {
		Integer[] row = {0, 0, 0, 0};
		Integer[] row_ok = {0, 0, 0, 0};
		assertEquals(Arrays.toString(matrix.rowMerge(row)), Arrays.toString(row_ok));
	}
	
	@Test
	public void test5() {
		Integer[] row = {8, 2, 4, 2};
		Integer[] row_ok = {8, 2, 4, 2};
		assertEquals(Arrays.toString(matrix.rowMerge(row)), Arrays.toString(row_ok));
	}

}
