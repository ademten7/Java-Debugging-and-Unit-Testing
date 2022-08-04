package _05Challenges._02;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertArrayEquals;


public class UtilitiesTest {
    @org.junit.Test
    public void everyNthChar() throws Exception {

        Utilities utils = new Utilities();//we can put this inside the @Before to prevent redundant code
        char[] output = utils.everyNthChar(new  char[] {'h', 'e', 'l', 'l', 'o'}, 2);
        //assertEquals() does not work here because two arrays have not same reference
         assertArrayEquals(new char[] { 'e', 'l'}, output);
        char[] output2 = utils.everyNthChar(new  char[] {'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[] {'h', 'e', 'l', 'l', 'o'}, output2);
    }

    @org.junit.Test
    public void removePairs() throws Exception {
        Utilities util = new Utilities();
        //Test every scenario
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        assertNull("Did not get null returned when argument passed was null", util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));

    }

    @org.junit.Test
    public void converter() throws Exception {
        Utilities util = new Utilities();
        assertEquals(300, util.converter(10, 5));

    }

    @org.junit.Test
    public void nullIfOddLength() throws Exception {
        Utilities util = new Utilities();
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));
    }

}