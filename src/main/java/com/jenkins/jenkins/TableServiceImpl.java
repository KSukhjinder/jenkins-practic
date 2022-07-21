package com.jenkins.jenkins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TableServiceImpl implements TableService{

    @Autowired
    TableRepo tableRepo;

    @Override
    public TableEntity save(TableEntity tableEntity) {
        TableEntity save = tableRepo.save(tableEntity);
        return save;
    }


}
