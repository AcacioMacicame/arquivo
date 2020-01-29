package org.macicame.arquivo.controller.viewbean;

import org.macicame.arquivo.model.base.Identifiable;
import org.macicame.arquivo.service.CrudService;
import org.macicame.arquivo.service.configs.Transactional;
import org.omnifaces.util.Messages;

import java.io.Serializable;

/**
 * Created by acacio on 15/03/19.
 */

//todo: improve after implement genericService
public abstract class CrudViewBean<T extends Identifiable> implements Serializable {

    private T selected = createNew();

    public abstract <E extends CrudService<T>> E service();
    public abstract T createNew();
    //todo: security breach when implementing authorizations, manual updates on any district can be possible by setting the id parameter
    @Transactional
    public void add(){

        if(selected.getId()!=null) {
            service().save(selected);
            newOne();

            Messages.addGlobalInfo("Actualizado com sucesso");
        }else{
            service().save(selected);
            newOne();

           Messages.addGlobalInfo("Registado com sucesso");
        }

    }

    public void newOne(){
        selected = createNew();
    }

    public Iterable<T> getAll(){
        return service().findAll();
    }

    public void setSelected(T selected) {
        this.selected = selected;
    }

    public T getSelected(){
        return selected;
    }

    @Transactional
    public void delete(T object){
        try {
            service().delete(object);

            newOne();

        }catch (IllegalArgumentException e){
        Messages.addFlashGlobalWarn("O dado está associado a outra entidade");
        }
    }

    @Transactional
    public void update(T object){
        service().save(object);
        newOne();
    }

}
