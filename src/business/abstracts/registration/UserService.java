package business.abstracts.registration;

import entity.user.User;

import java.util.Scanner;

public interface UserService {
    default void register(User user) {
        if (!checkUserInfoFormat(user)) {
            System.out.println(Response.WRONG_FORMAT);
            return;
        }
        if (!checkIsEmailAlreadyExists(user.getEmail())) {
            writeToDatabase(user);
            verificationMessage();
            //todo continue
        } else {
            System.out.println(Response.ACCOUNT_EXISTS);
            choice(user);
        }

    }

    default void login(User user) {
        if (!checkUserInfoFormat(user)) {
            System.out.println(Response.WRONG_FORMAT);
            return;
        }
        if (!checkIsEmailAlreadyExists(user.getEmail())) {
            System.out.println(Response.ACCOUNT_NOT_LOGGEDIN);
            choice(user);
            return;
        }
        if (!checkIsUserEmailAndPasswordAreCorrect(user.getEmail(), user.getPassword())) {
            System.out.println(Response.USERNAME_AND_PASSWORD_IS_WRONG);
            return;
        }
        verificationMessage();
    }


    default void choice(User user) {
        System.out.println("1)Register\n2)Login\n3)Forgot password\n4)Continiue\nEnter your choice=>");
        Scanner scanner = new Scanner(System.in);
        int op = scanner.nextInt();
        switch (op) {
            case 1: register(user); break;
            case 2: login(user); break;
            case 3: forgotPassword(user); break;
            case 4: break;
            default: System.out.println("Your choice is wrong");
        }
    }

    void forgotPassword(User user);
    void writeToDatabase(User user);
    boolean checkUserInfoFormat(User user);
    boolean checkIsUserEmailAndPasswordAreCorrect(String email, String userEmail);
    boolean checkIsEmailAlreadyExists(String email);
    void verificationMessage();
}
