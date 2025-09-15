package app.exceptions;

public class TrainerNotFoundException extends RuntimeException {
    public TrainerNotFoundException(Long id) {
        super("Тренер с id=" + id + " не найден");
    }

    public TrainerNotFoundException(String name) {
        super("Тренер с именем '" + name + "' не найден");
    }
}
