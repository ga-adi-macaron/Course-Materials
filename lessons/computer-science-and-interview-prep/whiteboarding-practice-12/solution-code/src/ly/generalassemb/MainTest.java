package ly.generalassemb;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test the static methods of the Main class
 *
 * Created by charlie on 12/16/16.
 */
public class MainTest {

    @Test
    public void testReverseArray() {
        Byte[] emptyArray = new Byte[0];
        Main.reverseArray(emptyArray);
        Assert.assertArrayEquals(new Byte[0], emptyArray);

        Integer[] intArray = new Integer[]{1, 2, 3};
        Main.reverseArray(intArray);
        Assert.assertArrayEquals(new Integer[]{3, 2, 1}, intArray);

        Character[] charArray = new Character[]{'H', 'e', 'l', 'l', 'o'};
        Main.reverseArray(charArray);
        Assert.assertArrayEquals(new Character[]{'o', 'l', 'l', 'e', 'H'}, charArray);
    }

    @Test
    public void testFindFirstNonRepeatedChar() {
        Assert.assertEquals('a', Main.findFirstNonRepeatedChar(new char[]{'a', 'b', 'c'}));
        Assert.assertEquals('b', Main.findFirstNonRepeatedChar(new char[]{'a', 'b', 'a', 'c'}));
        Assert.assertEquals('c', Main.findFirstNonRepeatedChar(new char[]{'a', 'b', 'c', 'b', 'a'}));
        Assert.assertEquals(Character.MIN_VALUE, Main.findFirstNonRepeatedChar(new char[0]));
    }

    @Test
    public void testFindMissingNumber() {
        int[] nums = new int[99];

        // skip 43
        populateArray(nums, 43);
        Assert.assertEquals(43, Main.findMissingNumber(nums));

        // skip 99
        populateArray(nums, 99);
        Assert.assertEquals(99, Main.findMissingNumber(nums));

        // skip 1
        populateArray(nums, 1);
        Assert.assertEquals(1, Main.findMissingNumber(nums));

        // skip 100
        populateArray(nums, 100);
        Assert.assertEquals(100, Main.findMissingNumber(nums));
    }

    private void populateArray(int[] nums, int missingNum) {
        int value = 0;
        for (int i = 0; i < 99; i++) {
            value ++;
            if (value == missingNum) {
                value++;
            }
            nums[i] = value;
        }
    }

    @Test
    public void testFindDifferentNumber() {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{1, 2, 3, 6, 5};
        Assert.assertEquals(6, Main.findDifferentNumber(a, b));
    }

    @Test
    public void testFindSecondHighestNumber() {
        int[] nums = new int[]{5, 4, 8, 2, 7, 1, 10};
        Assert.assertEquals(8, Main.findSecondHighestNumber(nums));
    }
}
