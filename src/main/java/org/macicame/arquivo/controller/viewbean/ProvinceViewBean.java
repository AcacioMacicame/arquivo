package org.macicame.arquivo.controller.viewbean;


import org.macicame.arquivo.model.Province;
import org.macicame.arquivo.service.ProvinceService;
import org.macicame.arquivo.service.configs.Transactional;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by acacio on 16/03/19.
 */

@ViewScoped
@Named
public class ProvinceViewBean extends CrudViewBean<Province> {
    @Inject
    ProvinceService service;

    @Override
    public ProvinceService service() {
        return service;
    }

    @Override
    public Province createNew() {
        return new Province();
    }

}

