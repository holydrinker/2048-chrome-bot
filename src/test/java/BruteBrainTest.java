import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

import com.example.brain.BruteBrain;
import com.example.brain.Move;

public class BruteBrainTest {
	BruteBrain brain = new BruteBrain();
	Integer[][] input = {
			{2, 4, 128, 64},
			{4, 8, 0, 2},
			{0, 2, 8, 8},
			{2, 2, 2, 2}
	};
	int[] moves = {};

	@Test
	public void testChoiceNewMoves() {
		int[] expected = {Move.DOWN, Move.RIGHT};
		int[] result = brain.choiceNewMoves(input, moves);
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
	}

}
