package org.saltaonelove.dao;

import org.saltaonelove.dao.utils.IdGenerator;
import org.saltaonelove.dao.utils.Storage;
import org.saltaonelove.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TrainerDAO {
    private static final String NAMESPACE = "trainer";

    private Storage storage;
    private IdGenerator idGenerator;

    @Autowired
    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Autowired
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }


    public Trainer save(Trainer trainer) {
        if (trainer.getTrainerId() == null) {
            trainer.setTrainerId(idGenerator.nextId(NAMESPACE));
        }
        storage.save(NAMESPACE, trainer.getTrainerId(), trainer);
        return trainer;
    }

    public Trainer update(Trainer trainer) {
        storage.save(NAMESPACE, trainer.getTrainerId(), trainer);
        return trainer;
    }

    public Trainer findById(Long id) {
        return storage.findById(NAMESPACE, id);
    }

    public void delete(Long id) {
        storage.delete(NAMESPACE, id);
    }

    public List<Trainer> findAll() {
        return storage.findAll(NAMESPACE);
    }
}