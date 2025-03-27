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
        String bi = getNumbers(str);
        int hash = 
    }

    protected String getNumbers(String str) {
        String nums = "";
        for (int i = 0; i < str.length(); i++) {
            int a = (int)(str.charAt(i));
            nums = nums + String.valueOf(a);
        }
        return nums;
    }

    protected String[] splitString(String s) {
        String[] Ss = new String[s.length()/8+1];
        int scount = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.length()-i > 8) {
                Ss[scount] = s.substring(i, i+8);
            }

            else {
                Ss[scount] = s.substring(i, s.length()) + genRand(s.length()-i);
            }
        }

        return Ss;
    }

    protected String genRand(int l) {
        //sends back randomly generated numbers as a string
    }

    private int hashString(String pword) {
        //split up
        String[] Ss = splitString(pword);
        
        //use key

        for (int i = 0; i < Ss.length; i++) {
            Ss[i] = (int)Ss[i] ^ 
        }

        //break into bits and re-course
    }

}


public class hashTable extends hashArray {
    private hashArray hArr;

    public hashTable(int l, int k) {
        hArr = new hashArray(l, k);
    }

    public void addString(String str) {
        place(str);
    }
    
}