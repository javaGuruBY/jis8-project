package com.tutrit.registerservice.repository;

import com.tutrit.registerservice.bean.Entity;

/**
 * @author Denis Kaydunov
 */
public interface GateWay<Entity, D> extends CrudRepository<Entity, D> {
}
