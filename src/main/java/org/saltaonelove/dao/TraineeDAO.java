package org.saltaonelove.dao;

import org.saltaonelove.dao.utils.IdGenerator;
import org.saltaonelove.dao.utils.Storage;
import org.saltaonelove.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TraineeDAO {

    private static final String NAMESPACE = "trainee";
    @Autowired
    private Storage storage;
    private IdGenerator idGenerator;

    @Autowired
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public Trainee save(Trainee trainee) {
        if (trainee.getTraineeId() == null) {
            trainee.setUserId(idGenerator.nextId("user"));
            trainee.setTraineeId(idGenerator.nextId(NAMESPACE));
        }
        storage.save(NAMESPACE, trainee.getTraineeId(), trainee);
        return trainee;
    }

    public Trainee update(Trainee trainee) {
        storage.save(NAMESPACE, trainee.getTraineeId(), trainee);
        return trainee;
    }

    public Trainee findById(Long id) {
        return storage.findById(NAMESPACE, id);
    }

    public void delete(Long id) {
        storage.delete(NAMESPACE, id);
    }

    public List<Trainee> findAll() {
        return storage.findAll(NAMESPACE);
    }
}