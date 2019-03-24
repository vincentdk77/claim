package com.sinosoft.claim.resource.dtofactory.custom;

import com.sinosoft.claim.dto.custom.AreaSettingDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplareasetting;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class DBAreaSetting {
	
	public void insert(DBManager dbManager,AreaSettingDto areaSettingDto) throws Exception{
		 if(areaSettingDto.getPrplareasettingDtoList() != null){
			 new DBPrplareasetting(dbManager).insertAll(areaSettingDto.getPrplareasettingDtoList());
		 }
	 }
	
	/**
	  * ɾ����������
	  * @param dbManager
	  * @param id
	 * @throws Exception 
	  */
	 public void delete(DBManager dbManager,String id) throws Exception{
		 String condition = " handlercode = '" + StringUtils.rightTrim(id) + "'";
		    //ʾ��δ���
		    String statement = " DELETE FROM prplAreaSetting Where " + condition ;
		    dbManager.executeUpdate(statement);
	 }

}
