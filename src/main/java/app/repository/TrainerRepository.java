package app.repository;

import app.damain.Trainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainerRepository {

    private final Map<Long, Trainer> database = new HashMap<>();
    private long maxId;

    public Trainer save(Trainer trainer) {
        trainer.setId(++maxId);
        database.put(maxId, trainer);
        return trainer;
    }

    public List<Trainer> findAll() {
        return new ArrayList<>(database.values());
    }

    public Trainer findById(Long id) {
        return database.get(id);
    }

    public Trainer findByName(String name) {
        if (name == null) return null;
        return database.values().stream()
                .filter(t -> name.equals(t.getName()))
                .findFirst()
                .orElse(null);
    }

    public void deleteById(Long id) {
        database.remove(id);
    }
}


