package com.akoca.logservice.persistence;

import com.akoca.logservice.model.ActionLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionLogRepository extends ElasticsearchRepository<ActionLog, Long> {

}
