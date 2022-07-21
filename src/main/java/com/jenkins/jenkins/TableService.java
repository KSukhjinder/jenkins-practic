package com.jenkins.jenkins;

import org.springframework.stereotype.Service;

@Service
public interface TableService {

    TableEntity save(TableEntity tableEntity);

}
