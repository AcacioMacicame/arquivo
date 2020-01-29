package org.macicame.arquivo.service;

import org.macicame.arquivo.model.base.Identifiable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by acacio on 15/03/19.
 */
public interface CrudService<T extends Identifiable> extends CrudRepository<T, Long> {
}
