package org.macicame.arquivo.controller.viewbean;

import org.macicame.arquivo.model.*;
import org.macicame.arquivo.service.MedicalFileService;
import org.macicame.arquivo.service.configs.Transactional;
import org.primefaces.event.FlowEvent;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

/**
 * Created by acacio on 16/03/19.
 */

@ViewScoped
@Named
public class MedicalFileViewBean extends CrudViewBean<MedicalFile> {
    @Inject
    MedicalFileService service;

    private MedicalFile medicalFile;

    private boolean skip;

    @Override
    public MedicalFileService service() {
        return service;
    }

    @Override
    public MedicalFile createNew() {
        return new MedicalFile();
    }

    @Override
    @Transactional
    public void add() {
        Long lastCode = service.findLastMedicalFileNid();
        Long longCode= lastCode+1;
        String code = String.format("%04d", longCode);

        getSelected().setNid(code);
        getSelected().setIssueDateProcessNid(new Date());

        super.add();
        refresh();
    }

    @Override
    @Transactional
    public void newOne() {
        super.newOne();
        refresh();
    }

    public void refresh() {
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        context.renderResponse();
    }

    public void details(ActionEvent event){
        medicalFile = (MedicalFile) event.getComponent().getAttributes().get("selectedMedicalFile");
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public List<MaritalStatus> getAllMaritalStatus(){
        return MaritalStatus.getAll();
    }

    public List<Gender> getAllGenders(){
        return Gender.getAll();
    }

    public List<Breed> getAllBreeds(){
        return Breed.getAll();
    }

    public List<DocumentType> getAllDocumentTypes(){
        return DocumentType.getAll();
    }

    public MedicalFile getMedicalFile() {
        return medicalFile;
    }

    public void setMedicalFile(MedicalFile medicalFile) {
        this.medicalFile = medicalFile;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }
}

