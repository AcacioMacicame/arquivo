package org.macicame.arquivo.service;


import org.macicame.arquivo.model.MedicalFile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by acacio on 16/03/19.
 */

public interface MedicalFileService extends CrudService <MedicalFile> {

    @Query("select coalesce(max(s.nid),0) from MedicalFile s")//jpql
    Long findLastMedicalFileNid();
}