package org.macicame.arquivo.service;

import org.macicame.arquivo.model.Province;

/**
 * Created by acacio on 16/03/19.
 */

public interface ProvinceService extends CrudService <Province> {

    Province findByCodeOrName(String code, String name);
}