package a2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestWordleUtils {

	@Test
	public void test01a_replace() {
		// method args
		String s = "A";
		int index = 0;
		char c = 'B';
		
		// expected answer
		String exp = "B";
		
		// run test
		assertEquals(exp, WordleUtils.replace(s, index, c));
	}

	@Test
	public void test01b_replace() {
		// method args
		String s = "GUMBO";
		int index = 0;
		char c = 'J';
		
		// expected answer
		String exp = "JUMBO";
		
		// run test
		assertEquals(exp, WordleUtils.replace(s, index, c));
	}
	
	@Test
	public void test01c_replace() {
		// method args
		String s = "JIMBO";
		int index = 1;
		char c = 'U';
		
		// expected answer
		String exp = "JUMBO";
		
		// run test
		assertEquals(exp, WordleUtils.replace(s, index, c));
	}
	
	@Test
	public void test01d_replace_throws() {
		String s = "JIMBO";
		int index = -1;
		char c = 'U';
		try {
			WordleUtils.replace(s, index, c);
			fail("IndexOutOfBoundsException expected for index = " + index);
		}
		catch(IndexOutOfBoundsException x){
			// expected result
		}
		
		
	}
	
	@Test
	public void test02a_isGreen() {
		String guess = "GREEN";
		String ans = "COLOR";
		
		ArrayList<Boolean> exp = new ArrayList<>();
		for (int i = 0; i < guess.length(); i++) {
			exp.add(false);
		}
		assertEquals(exp, WordleUtils.isGreen(guess, ans));
		
	}
	
	@Test
	public void test01_lab_isGreen() {
		String guess = "MORALS";
		String ans = "COLOR";
		
		try {
			WordleUtils.isGreen(guess, ans);
			fail("IllegalArgumentException expected");
		}
		catch(IllegalArgumentException x) {
			//expected result
		}
	}
	
	@Test
	public void test02_lab_isYellow() {
		String guess = "KAYAK";
		String ans = "WHACK";
		
		ArrayList<Boolean> exp = new ArrayList<>();
		for (int i = 0; i < guess.length(); i++) {
			
			if (i==1) {
				exp.add(true);
			}
			
			else {
				exp.add(false);
			}
		}
		assertEquals(exp, WordleUtils.isYellow(guess, ans));
	}
	
	@Test
	public void test03_lab_getColors() {
		String guess = "INLET";
		String ans = "INSET";
		
		WordleColor g = WordleColor.GREEN;
		WordleColor gray = WordleColor.GRAY;
		WordleColor y = WordleColor.YELLOW;
		
		ArrayList<WordleColor> exp = new ArrayList<>();
		
		for (int i = 0; i < guess.length()-1; i++) {
			if (i == 2) {
				exp.add(gray);
			}
			exp.add(g);
		}
		
		assertEquals(exp, WordleUtils.getColors(guess, ans));
	}
}
