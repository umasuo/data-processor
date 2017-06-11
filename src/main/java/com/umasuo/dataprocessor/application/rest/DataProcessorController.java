package com.umasuo.dataprocessor.application.rest;

import com.umasuo.dataprocessor.application.dto.DataProcessorView;
import com.umasuo.dataprocessor.application.dto.mapper.DataProcessorMapper;
import com.umasuo.dataprocessor.domain.model.DataProcessor;
import com.umasuo.dataprocessor.domain.service.DataProcessorService;
import com.umasuo.dataprocessor.infrastructure.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by umasuo on 17/3/13.
 */
@RestController
public class DataProcessorController {

  /**
   * logger.
   */
  private final static Logger logger = LoggerFactory.getLogger(DataProcessorController.class);

  @Autowired
  private transient DataProcessorService dataProcessorService;

  /**
   * create a data processor.
   *
   * @param dataProcessorView
   */
  @PostMapping(value = Router.DATA_PROCESSOR_ROOT)
  public void createProcessor(@RequestBody @Valid DataProcessorView dataProcessorView) {
    logger.info("CreateDataProcessor: view: {}", dataProcessorView);

    DataProcessor processor = DataProcessorMapper.viewToModel(dataProcessorView);
    DataProcessor processorInDb = dataProcessorService.create(processor);

    logger.info("CreateDataProcessor: processorInDb: {}", processorInDb);
  }

  /**
   * get a processor with id.
   *
   * @param id String
   * @return
   */
  @GetMapping(value = Router.DATA_PROCESSOR_WITH_ID)
  public DataProcessorView get(@PathVariable String id) {
    logger.info("GetDataProcessor: id: {}", id);

    DataProcessor processor = dataProcessorService.get(id);

    logger.info("GetDataProcessor: processorInDb: {}", processor);
    return DataProcessorMapper.modelToView(processor);
  }
}
