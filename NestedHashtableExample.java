import java.util.Hashtable;

public class NestedHashtableExample {
    public static void main(String[] args) {
        // Outer Hashtable to store usernames as keys
        Hashtable<String, Hashtable<String, String>> userTable = new Hashtable<>();

        // Add a user with a password
        Hashtable<String, String> user1Details = new Hashtable<>();
        user1Details.put("password", "password123");
        userTable.put("user1", user1Details);

        // Add another user with a password
        Hashtable<String, String> user2Details = new Hashtable<>();
        user2Details.put("password", "securePass456");
        userTable.put("user2", user2Details);

        // Testing the retrieval of password for a username
        String username = "user1";
        String password = getPassword(userTable, username);

        if (password != null) {
            System.out.println("Password for " + username + ": " + password);
        } else {
            System.out.println("User not found.");
        }
    }

    // Method to retrieve password
    public static String getPassword(Hashtable<String, Hashtable<String, String>> userTable, String username) {
        // Check if the username exists in the outer Hashtable
        Hashtable<String, String> userDetails = userTable.get(username);
        
        if (userDetails != null) {
            return userDetails.get("password"); // Get the password from the inner Hashtable
        } else {
            return null; // User not found
        }
    }
}
