package com.umasuo.dataprocessor.application.dto.map;

import com.umasuo.dataprocessor.application.dto.DataProcessorView;
import com.umasuo.dataprocessor.domain.model.DataProcessor;

/**
 * Created by umasuo on 17/3/13.
 */
public class DataProcessorMapper {

  public static DataProcessor viewToModel(DataProcessorView view) {
    DataProcessor model = null;
    if (view != null) {
      model = new DataProcessor();
      model.setId(view.getId());
      model.setCreatedAt(view.getCreatedAt());
      model.setLastModifiedAt(view.getLastModifiedAt());
      model.setVersion(view.getVersion());
      model.setInputDataDefinitionId(view.getInputDataDefinitionId());
      model.setOutputDataDefinitionId(view.getOutputDataDefinitionId());
      model.setProcessorScriptId(view.getProcessorScriptId());
    }
    return model;
  }

  public static DataProcessorView modelToView(DataProcessor model) {
    DataProcessorView view = null;
    if (model != null) {
      view = new DataProcessorView();
      view.setId(model.getId());
      view.setCreatedAt(model.getCreatedAt());
      view.setLastModifiedAt(model.getLastModifiedAt());
      view.setVersion(model.getVersion());
      view.setInputDataDefinitionId(model.getInputDataDefinitionId());
      view.setOutputDataDefinitionId(model.getOutputDataDefinitionId());
      view.setProcessorScriptId(model.getProcessorScriptId());
    }
    return view;
  }
}
