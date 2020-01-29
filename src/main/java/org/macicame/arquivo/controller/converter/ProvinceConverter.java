package org.macicame.arquivo.controller.converter;

import org.macicame.arquivo.model.Province;
import org.macicame.arquivo.service.ProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by acacio on 16/03/19.
 */

@FacesConverter(forClass = Province.class)
@Named
public class ProvinceConverter implements Converter {

    private final Logger logger = LoggerFactory.getLogger(ProvinceConverter.class);

    @Inject
    private ProvinceService service;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Province province = service.findById(Long.valueOf(value)).get();
            return province;
        }catch (Exception e){
            logger.warn("",e);
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            return ((Province) value).getId().toString();
        }
        return null;
    }
}