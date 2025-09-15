package app.controller;

import app.damain.Trainer;
import app.service.TrainerService;

import java.util.List;

public class TrainerController {

    private final TrainerService service = TrainerService.getInstance();

    // Сохранить тренера
    public Trainer save(String name) {
        Trainer trainer = new Trainer();
        trainer.setName(name);
        return service.save(trainer);
    }

    // Получить всех активных тренеров
    public List<Trainer> getAll() {
        return service.getAllActiveTrainers();
    }

    // Получить активного тренера по ID
    public Trainer getById(Long id) {
        return service.getActiveTrainerById(id);
    }

    // Удалить тренера по ID
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    // Удалить тренера по имени
    public void deleteByName(String name) {
        service.deleteByName(name);
    }

    // Восстановить тренера по ID
    public void restoreById(Long id) {
        service.restoreById(id);
    }

    // Восстановить тренера по имени
    public void restoreByName(String name) {
        service.restoreByName(name);
    }
}
