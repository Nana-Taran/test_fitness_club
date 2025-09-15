package app.exceptions;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(Long id) {
        super("Пользователь с id=" + id + " не найден");
    }

    public MemberNotFoundException(String name) {
        super("Пользователь с именем '" + name + "' не найден");
    }
}

