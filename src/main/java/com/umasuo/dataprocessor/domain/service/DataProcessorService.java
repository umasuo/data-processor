package com.umasuo.dataprocessor.domain.service;

import com.umasuo.dataprocessor.domain.model.DataProcessor;
import com.umasuo.dataprocessor.infrastructure.repository.DataProcessorRepository;
import com.umasuo.exception.AlreadyExistException;
import com.umasuo.exception.NotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by umasuo on 17/3/11.
 */
@Service
public class DataProcessorService {

  /**
   * logger.
   */
  private final static Logger logger = LoggerFactory.getLogger(DataProcessorService.class);

  /**
   * data processor repository.
   */
  @Autowired
  private DataProcessorRepository repository;

  /**
   * create data processor.
   *
   * @return
   */
  public DataProcessor create(DataProcessor processor) {
    logger.debug("CreateDataProcessor: processor: {}", processor);
    Assert.notNull(processor);
    Assert.notNull(processor.getInputDataDefinitionId());
    Assert.notNull(processor.getOutputDataDefinitionId());
    Assert.notNull(processor.getProcessorScriptId());

    Example<DataProcessor> example = Example.of(processor);
    DataProcessor dataInDb = repository.findOne(example);
    if (dataInDb != null) {
      throw new AlreadyExistException("The Data Processor already exist.");
    }
    dataInDb = repository.save(processor);

    logger.debug("CreateDataProcessor: processor in db: {}", dataInDb);
    return dataInDb;
  }


  /**
   * get processor by id.
   *
   * @param id
   * @return
   */
  public DataProcessor get(String id) {
    logger.debug("GetDataProcessor: id: {}", id);
    Assert.notNull(id);

    DataProcessor dataProcessor = repository.findOne(id);
    if (dataProcessor == null) {
      throw new NotExistException("The Data Processor not exist.");
    }

    logger.debug("GetDataProcessor: processor: {}", dataProcessor);
    return dataProcessor;
  }
}
