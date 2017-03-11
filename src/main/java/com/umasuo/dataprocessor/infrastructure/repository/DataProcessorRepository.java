package com.umasuo.dataprocessor.infrastructure.repository;

import com.umasuo.dataprocessor.domain.model.DataProcessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by umasuo on 17/2/10.
 */
@Repository
public interface DataProcessorRepository extends JpaRepository<DataProcessor, String>,
    CrudRepository<DataProcessor, String>, QueryByExampleExecutor<DataProcessor> {
}
