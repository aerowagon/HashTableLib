import java.util.Scanner;

public class Main {
    private static Password AdminP = new Password(new HashTable(1, 13378008));
    Password password = new Password(new HashTable(100, 1752345));

    public static void main(String args[]) {
        init();
        

    }

    public void init() {
        addAdmin();
        userHandling();
    }

    private static void addAdmin() {
        AdminP.addPassword("GiveVictorAndJamesAs", "admin");
    }

    public void userHandling() {
        Scanner s = new Scanner(System.in);
        System.out.println("Press 0 to enter password or press 1 to manage passwords.");
        if (s.nextInt()==1) {
            System.out.println("Please input the admin password:");
            ManagePasswords(s.nextLine());
        }
        else if (s.nextInt()==0){
            checkPassword();
        }
        else {
            userHandling();
        }
    }

    public void checkPassword() {
        Scanner s = new Scanner(System.in);
        System.out.println("Put in username:");

    }
    

    public void ManagePasswords(String p) {
        Scanner s = new Scanner(System.in);

        if (AdminP.confirmPassword(p, "admin")) {
            System.out.println("You are at the password manager. Press 0 to enter a new password and 1 to delete password. Press 2 to return.");
            if (s.nextInt()==0) {
                System.out.println("New name");
                String name = s.nextLine();
                System.out.println("New password:");
                password.addPassword(s.nextLine(), name);
                ManagePasswords(p);
            }

            if (s.nextInt()==1) {
                System.out.println("Old name");
                String name = s.nextLine();
                System.out.println("Old password:");
                password.removePassword(s.nextLine(), name);
                ManagePasswords(p);
            }

            else if (s.nextInt()==3) {
                userHandling();
            }
            else {
                ManagePasswords(p);
            }
        }

        else {
            System.out.println("Incorrect Password.");
            userHandling();
        }
        
    }
}
