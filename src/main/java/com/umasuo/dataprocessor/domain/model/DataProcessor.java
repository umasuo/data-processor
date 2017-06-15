package com.umasuo.dataprocessor.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by umasuo on 17/3/11.
 * Data processor relations between
 */
@Entity
@Table(name = "data_processor")
@Setter
@Getter
public class DataProcessor {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private String id;

  /**
   * The Created at.
   */
  @CreatedDate
  private Long createdAt;

  /**
   * The Last modified at.
   */
  @LastModifiedDate
  private Long lastModifiedAt;

  /**
   * version used for update date check.
   */
  private Integer version;

  /**
   * the input data definition ID of the processor. so the input data can know the data structure
   * it processed.
   */
  private String inputDataDefinitionId;

  /**
   * the out put data definition, define the out data structure.
   */
  private String outputDataDefinitionId;

  /**
   * Save the processor script in a file which saved in our file system.
   */
  private String processorScriptId;

}
