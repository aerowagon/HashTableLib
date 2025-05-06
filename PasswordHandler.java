import java.util.Scanner;

public class PasswordHandler {
    Scanner s = new Scanner(System.in);
    private Password AdminP = new Password(new HashTable(1, 13378008));
    Password password = new Password(new HashTable(100, 1752345));

    public PasswordHandler() {
        getAdmin();
        userHandling();
    }

    private void getAdmin() { // get admin password
        System.out.println("Please initiate admin password:");
        AdminP.addPassword(s.nextLine(), "admin");
    }

    public void user() {
        System.out.println("Congratulations! You have logged in.");
        userHandling();
    }

    private void admin() {
        System.out.println("You are at the password manager. Press 0 to enter a new password and 1 to delete password.");
        System.out.println("Enter anything else to return.");
        int i;
        i = Integer.parseInt(s.nextLine());
        System.out.println(i);
        if (i==0) {
            addPassword();
        }

        else if (i==1) {
            deletePassword();
        }

        else {
            userHandling();
        }
    }

    public void userHandling() {
        String pwd;
        String unm;
        System.out.println("Please input username:");
        unm = s.nextLine();
        System.out.println("Please input password:");
        pwd = s.nextLine();

        if (AdminP.confirmPassword (pwd, "admin")) {
            admin();
        }

        else if (password.confirmPassword (pwd, unm)) {
            user();
        }

        else {
            System.out.println("Incorrect username or password.");
            userHandling();
        }
    }

    private void deletePassword() {
        String unm;
        String pwd;
        System.out.println("Old name:");
        unm = s.nextLine();
        System.out.println("Old password:");
        pwd = s.nextLine();
        password.removePassword(pwd,unm);
        System.out.println("Password deleted!");
        admin();
    }

    private void addPassword() {
        String pwd;
        String unm;
        System.out.println("New name:");
        unm = s.nextLine();
        System.out.println("New password:");
        pwd = s.nextLine();
        password.addPassword(pwd, unm);
        System.out.println("Password added!");
        admin();
    }

}
