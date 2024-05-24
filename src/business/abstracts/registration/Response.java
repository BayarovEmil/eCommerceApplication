package business.abstracts.registration;

public enum Response {
    WRONG_FORMAT("User format is wrong"),
    ACCOUNT_EXISTS("Your account is already exists in our system"),
    ACCOUNT_NOT_LOGGEDIN("Your account not logged in our system"),
    USERNAME_AND_PASSWORD_IS_WRONG("Username and password is wrong!"),
    UNCOMPLETED_OPERATION("OOPS! This operation not completed!")
    ;


    private final String responses;


    Response(String responses) {
        this.responses = responses;
    }

    public String getResponses() {
        return responses;
    }
}
