package com.umasuo.dataprocessor.application.dto;

import lombok.Data;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotNull;

/**
 * Created by umasuo on 17/3/13.
 */
@Data
public class DataProcessorView {

  private String id;

  /**
   * The Created at.
   */
  private ZonedDateTime createdAt;

  /**
   * The Last modified at.
   */
  private ZonedDateTime lastModifiedAt;

  /**
   * version used for update date check.
   */
  private Integer version;

  /**
   * the input data definition ID of the processor. so the input data can know the data structure
   * it processed.
   */
  @NotNull
  private String inputDataDefinitionId;

  /**
   * the out put data definition, define the out data structure.
   */
  @NotNull
  private String outputDataDefinitionId;

  /**
   * Save the processor script in a file which saved in our file system.
   */
  @NotNull
  private String processorScriptId;

}
