package org.saltaonelove.dao;

import org.saltaonelove.dao.utils.IdGenerator;
import org.saltaonelove.dao.utils.Storage;
import org.saltaonelove.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class UserDAO {

    private static final String NAMESPACE = "user";


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

    public User save(User user) {
        if (user.getUserId() == null) {
            user.setUserId(idGenerator.nextId(NAMESPACE));
            generateUsername(user);
            generateRandomPassword(user);
        }
        storage.save(NAMESPACE, user.getUserId(), user);
        return user;
    }

    public User update(User user) {
        storage.save(NAMESPACE, user.getUserId(), user);
        return user;
    }

    public User findById(Long id) {
        return storage.findById(NAMESPACE, id);
    }

    public void delete(Long id) {
        storage.delete(NAMESPACE, id);
    }

    public List<User> findAll() {
        return storage.findAll(NAMESPACE);
    }

    private void generateUsername(User user) {
        long serial = storage.findAll(NAMESPACE).stream().filter(user::usernameEquals).count();
        if (serial != 0){
            user.setUsername(user.getUsername() + serial);
        }
    }

    private void generateRandomPassword(User user) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }

        user.setPassword(password.toString());
    }
}