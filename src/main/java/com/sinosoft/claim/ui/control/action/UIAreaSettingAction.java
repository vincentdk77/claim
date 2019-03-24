package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.AreaSettingDto;
import com.sinosoft.claim.ui.model.AreaSettingQueryCommand;
import com.sinosoft.claim.ui.model.AreaSettingSaveCommand;
import com.sinosoft.sysframework.common.datatype.PageRecord;

public class UIAreaSettingAction {
	/**
	   * 保存区域设置
	   * @param AreaSettingDto：区域设置DTO
	   * @throws Exception
	   */
	  public void save(AreaSettingDto areaSettingDto) throws SQLException,Exception
	  {
		  AreaSettingSaveCommand  areaSettingSaveCommand = new AreaSettingSaveCommand(areaSettingDto);
		  areaSettingSaveCommand.execute();
	  }
	  
	  /**
	   * 
	   * @param conditions
	   * @param pageNo
	   * @param recordPerRecord
	   * @return
	   * @throws Exception
	   */
	  public PageRecord findByQueryConditions(String conditions,int pageNo,int recordPerRecord) throws Exception{
		  
		  AreaSettingQueryCommand areaSettingSaveCommand = new AreaSettingQueryCommand(conditions,pageNo,recordPerRecord);
		  return (PageRecord)areaSettingSaveCommand.executeCommand();
	  }

}
