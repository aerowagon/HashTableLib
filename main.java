public class Main {
    public static void main(String args[]) {
        //code key should be 8 digits
        Password password = new Password();


        //set password
        password.newPassword("#t4EESD2495(^)", "name");

        //Verify password
        System.out.println("test is true: " + password.confirmPassword("#t4EESD2495(^)","name") );
        System.out.println("test is false: " + password.confirmPassword("Notpassword","name") );

        //remove password
        password.removePassword("#t4EESD2495(^)", "name");
        System.out.println("test is false: " + password.confirmPassword("#t4EESD2495(^)", "name")  );


    }
}
