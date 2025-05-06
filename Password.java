import java.util.LinkedList;


public class Password {

    HashTable hA;

    LinkedList<Node>[] passwordStorage = new LinkedList[13];
    int location = 0;



    public Password(HashTable hT){
        this.hA = hT;

    }

    public void addPassword(String word, String name) {
        this.location = nameTwoNumber(name) % 13;

        String hashedWord = hA.addString(word);

        if (passwordStorage[location] == null) {
            passwordStorage[location] = new LinkedList<>();
        }
        
        Node passwordNode = new Node(hashedWord, name);

        passwordStorage[location].add(passwordNode);
    }

    public boolean confirmPassword(String word, String name){
        String hashedWord = hA.addString(word);
        int length = passwordStorage[location].size();

        for (int i = 0; i <length  ; i++) {
            if( name.equals(passwordStorage[location].get(i).getName()) ) {
                if (hashedWord.equals(passwordStorage[location].get(i).getHashvalue() )  ) {
                    return true;
                }
            }
        }
        return false;
    }

    public void removePassword(String word, String name){
        String hashedWord = hA.addString(word);
        int length = passwordStorage[location].size();

        for (int i = 0; i <length  ; i++) {
            if( name.equals(passwordStorage[location].get(i).getName()) ) {
                if (hashedWord.equals(passwordStorage[location].get(i).getHashvalue())) {
                    passwordStorage[location].remove(i);
                }
            }
        }

    }

    private int nameTwoNumber(String name){
        int a = (int) name.charAt(0);
        return a;
    }

}
 class Node{
    String name;
    String hashvalue;

     public Node(String hashedWord, String name) {
         this.name = name;
         this.hashvalue = hashedWord;
     }

    public String getName(){
        return name;
    }

    public String getHashvalue(){
        return hashvalue;
    }
     // Used to change name
    public void setName(){

    }
    // Used to change hashvalue
    public void setHashvalue(){

    }

}
