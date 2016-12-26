package matrix;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.brain.Matrix;

public class MatrixPrivateMethods {
	Class<?> cls;
	Object obj;
	Class<?> noparams[] = {};
	Method mirrored;
	Method transpose;
	
	Integer[][] data = { 
			{ 0, 0, 2, 2 }, 
			{ 4, 4, 4, 4 }, 
			{ 0, 0, 0, 0 }, 
			{ 8, 0, 8, 2 } };
	
	Integer[][] mirrored_data = { 
			{ 2, 2, 0, 0 }, 
			{ 4, 4, 4, 4 }, 
			{ 0, 0, 0, 0 }, 
			{ 2, 8, 0, 8 } };
	
	Integer[][] transposed_data = {
			{0, 4, 0, 8},
			{0, 4, 0, 0},
			{2, 4, 0, 8},
			{2, 4, 0, 2}
	};

	@Before
	public void setUp() throws Exception {
		cls = Class.forName("com.example.brain.Matrix");
		obj = cls.getConstructor(Integer[][].class).newInstance(data);
		
		mirrored = cls.getDeclaredMethod("mirrored", noparams);
		mirrored.setAccessible(true);
		
		transpose = cls.getDeclaredMethod("transpose", noparams);
		transpose.setAccessible(true);
	}

	@After
	public void tearDown() throws Exception {
		cls = null;
		obj = null;
		mirrored = null;
	}

	@Test
	public void test_mirrored1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Matrix newMatrix = (Matrix) mirrored.invoke(obj, noparams);
		assertEquals(newMatrix.toString(), new Matrix(mirrored_data).toString());
	}
	
	@Test
	public void test_transpose1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Matrix newMatrix = (Matrix) transpose.invoke(obj, noparams);
		assertEquals(newMatrix.toString(), new Matrix(transposed_data).toString());
	}

}
