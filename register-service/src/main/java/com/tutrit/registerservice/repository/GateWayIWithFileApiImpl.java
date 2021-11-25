package com.tutrit.registerservice.repository;

import com.tutrit.register.gateway.GateWayEntity;
import com.tutrit.register.gateway.GateWayI;
import com.tutrit.registerservice.bean.Slot;
import com.tutrit.registerservice.bean.User;
import com.tutrit.registerservice.config.Storage;
import com.tutrit.registerservice.exception.GateWayException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GateWayIWithFileApiImpl implements GateWayI<GateWayEntity, Long> {

    @Override
    public GateWayEntity create(GateWayEntity entity) throws IOException {
        if (!Files.exists(Storage.pathStorage)) {
            Files.createDirectories(Storage.pathStorage);
        }
        Path entityFile = Path.of(Storage.pathStorage.toString(),
                entity.getId().toString() + Storage.getExtension(entity));
        Files.createFile(entityFile);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(entityFile.toString()))) {
            oos.writeObject(entity);
        }
        return findById((Long) entity.getId()).orElseThrow(() -> new GateWayException("Entity don't create"));
    }

    @Override
    public Optional<GateWayEntity> findById(Long id) throws IOException {
        Optional<Path> entityPath = getEntityPath(id.toString());
        return entityPath.
                map(this::apply);
    }

    @Override
    public Iterable<GateWayEntity> findAll() throws IOException, ClassNotFoundException {
        List<GateWayEntity> entities = new ArrayList<>();
        List<Path> entityPaths = Files.walk(Storage.pathStorage)
                //TODO метод найдет все сохранения и User и Slot, возможно бизнес логика требует разделения.
                //.filter(path -> path.toString().endsWith(".slot"))
                .collect(Collectors.toList());
        for (Path path : entityPaths) {
            entities.add(getEntity(path));
        }
        return entities;
    }

    @Override
    public GateWayEntity update(GateWayEntity entity) throws IOException {
        delete(entity);
        return create(entity);
    }

    @Override
    public void deleteById(Long id) throws IOException {
        Optional<Path> entityPath = getEntityPath(id.toString());
        if (entityPath.isPresent()) {
            Files.delete(entityPath.get());
        }
    }

    @Override
    public void delete(GateWayEntity entity) throws IOException {
        deleteById((Long) entity.getId());
    }

    private GateWayEntity apply(Path path) {
        GateWayEntity entity = null;
        try {
            entity = getEntity(path);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return entity;
    }

    private Optional<Path> getEntityPath(String idAsString) throws IOException {
        return Files.walk(Storage.pathStorage)
                .filter(path -> path.toString().startsWith(idAsString))
                .findFirst();
    }

    private Object getReadObject(Path path) throws IOException, ClassNotFoundException {
        return new ObjectInputStream(
                new FileInputStream(path.toString()))
                .readObject();
    }

    private GateWayEntity getEntity(Path path) throws IOException, ClassNotFoundException {
        String extension = FilenameUtils.getExtension(path.toString());
        if ("user".equals(extension))
            return (User) getReadObject(path);
        if ("slot".equals(extension))
            return (Slot) getReadObject(path);
        throw new GateWayException("Entity don't create. Class for Entity not found.");
    }
}
