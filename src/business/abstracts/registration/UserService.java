package business.abstracts;

import entity.user.User;

import java.util.Scanner;

public interface UserService {
    default void login(User user) {
        if (checkUserInfoFormat(user)) {
            if (checkIsEmailAlreadyExists(user.getEmail())) {
                if(checkIsUserEmailAndPasswordAreCorrect(user.getEmail(),user.getEmail())) {
                    //send verification message
                    verificationMessage();
                } else {
                    System.out.println("Username and password is wrong!");
                }
            } else {
                System.out.println("Your account not logged in our system\n " +
                        "Dou you want to sign up?\n1)Yes  2)No");
                Scanner scanner = new Scanner(System.in);
                int op = scanner.nextInt();
                switch (op) {
                    case 1: register(user); break;
                    case 2: System.out.println("Welcome to our page"); break;
                    default: System.out.println("Your choice is wrong");
                }
            }
        }
        else {
            System.out.println("User information format is not correct!");
        }


    }

    default void register(User user) {
        //enter user full infos
        if (!checkUserInfoFormat(user)) {
            System.out.println("User format is wrong.Please try again.");
            return;
        }
        //check the infos is user already exists?
        if (!checkIsEmailAlreadyExists(user.getEmail())) {
            writeToDatabase(user);
            //send verification message
            verificationMessage();
        } else {
            System.out.println("Your account is already exists in our system\n" +
                    "Dou you forget your password\n 1)Forgot Password 2)Login?");
            Scanner scanner = new Scanner(System.in);
            int op = scanner.nextInt();
            switch (op) {
                case 1: forgotPassword(user); break;
                case 2: login(user); break;
                case 3: register(user); break; //FIXME: Fix it later
                default: System.out.println("Choice is wrong");
            }
        }

    }

    void forgotPassword(User user);
    void writeToDatabase(User user);
    boolean checkUserInfoFormat(User user);
    boolean checkIsUserEmailAndPasswordAreCorrect(String email, String userEmail);
    boolean checkIsEmailAlreadyExists(String email);
    void verificationMessage();
}
