//how many places are we expecting?
//

import java.lang.reflect.Array;
import java.util.Random;

class hashArray {
    protected String[] arr;
    protected int codeKey;
    protected int a;
    protected int b;


    protected void place(String str) { //function to put information into hash array
        String bi = getNumbers(str);
        System.out.println(bi);
        String encoded = encodeString(bi);
        int hashVal = hashInt(encoded);
        arr[hashVal] = encoded;
    }
    
    protected String[] getArray() {
        return arr;
    }

    protected int arrLength() {
        return arr.length;
    }

    //returns string of numbers where the characters were. WORKS!
    protected String getNumbers(String str) {
        String nums = "";
        for (int i = 0; i < str.length(); i++) {
            int a = (int)(str.charAt(i));
            nums = nums + String.valueOf(a);
        }
        return nums;
    }

    //splits string into 64-bit chunks
    protected String[] splitString(String s) {
        String[] Ss = new String[(s.length()/8)+1];
        int scount = 0;
        for (int i = 0; i < Ss.length; i++){
            if (s.length()-scount > 8) {
                Ss[i] = s.substring(scount, scount+8);
                scount = scount + 8;
            }

            else {
                Ss[i] = s.substring(scount, s.length()) + genRand(s.length()-scount);
            }
        }

        return Ss;
    }


    private String encodeString(String pword) {
        //split up
        String[] Ss = splitString(pword);
        String encoded="";
        long prev = 0;
        
        //use codekey to hash with current and then previous
        for (int i =0; i < Ss.length; i++) {
            long temp = Long.valueOf(Ss[i]);
            long total = temp ^ codeKey;
            if (prev != 0) {
                total = total ^ prev;
            }
            prev = total;
            encoded = encoded + String.valueOf(total);
        }

        return encoded;

    }
    
    private String genRand(int l) {
        //sends back randomly generated numbers as a string
        String nums = "";
        Random rand = new Random();

        for (int i = 0; i < l; i++) {
            int ran = rand.nextInt(26);
            nums = nums + String.valueOf(ran);
        }

        return nums;
    }
    
    
    private int hashInt(String pword) {
        String[] s = splitString(pword);
        
        long primedTotal = 0;
        
        for (int i = 0; i < s.length; i++) {
            long temp = Long.valueOf(s[i])%1453;
            
            long tot = a * temp + b;
            primedTotal = primedTotal + tot%5107;
        }
        
        System.out.println(primedTotal);
        return (int)primedTotal%arr.length;
    }
}


public class hashTable extends hashArray {
    protected hashArray hArr;

    public hashTable(int length, int codeKey) {
        this.arr = new String[length];
        this.codeKey = codeKey;

        //initialize function specific 
        Random rand = new Random();
        a = rand.nextInt(length);
        b = rand.nextInt(length);
    }
    
    public static void main(String args[]) {}

    public void addString(String str) {
        place(str);
    }

    public void removeString(String str) {
        
    }
    
}