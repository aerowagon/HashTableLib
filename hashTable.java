//how many places are we expecting?
//

import java.lang.reflect.Array;

class hashArray {
    protected int[] arr;
    protected int key;

    protected hashArray(int length, int key) {
        this.arr = new int[length];
        this.key = key;
    }

    protected void place(String str) { //function to put information into hash array

    }

    protected int getNumbers(String str) {
        int i = 0;
    }

    private int hashString(String str) {
        //turn string into numbers
        String bstring = Integer.toBinaryString(getNumbers(str));

        //break into 8-bit blocks


        //hash each block with key
        //hash each block with the next block
        //convert to numbers
        //divide by 7 until <100

    }
}


public class hashTable extends hashArray {
    private hashArray hArr;

    public hashTable(int length, int key) {
        hArr = new hashArray(length, key);
    }

    public void addString(String str) {
        place(str);
    }
    
}