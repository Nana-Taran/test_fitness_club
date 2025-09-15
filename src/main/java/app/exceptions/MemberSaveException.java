package app.exceptions;

public class MemberSaveException extends RuntimeException {
    public MemberSaveException(String message) {
        super(message);
    }
}

