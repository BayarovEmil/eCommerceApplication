package core.exception;

import java.io.IOException;

public class FileCannotBeUptadableException extends RuntimeException {
    public FileCannotBeUptadableException(String message) {
        super(message);
    }
}
