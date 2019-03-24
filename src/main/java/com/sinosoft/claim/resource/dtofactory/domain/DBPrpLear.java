package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLearDto;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpLear extends DBPrpLearBase{
	
	private static Log logger = LogFactory.getLog(DBPrpLear.class);
	
	
	public DBPrpLear(DBManager dbManager) {
		super(dbManager);
	}
 
  
	//Ð£Ñé¶ú±êºÅ
	public Collection checkEarNo(String condition)throws Exception{
		String strSQL = "SELECT earNo,registNo FROM PrpLear WHERE  validStatus= '1'" + condition;
		ArrayList earDtoList = new ArrayList();
		PrpLearDto earDtoSQL = null;
		
	    dbManager.prepareStatement(strSQL);
		ResultSet resultSet = dbManager.executePreparedQuery();
		 while(resultSet.next())
		 {
			 earDtoSQL = new PrpLearDto();
			 earDtoSQL.setEarNo(resultSet.getString("earNo"));
			 earDtoSQL.setRegistNo(resultSet.getString("registNo"));
			 earDtoList.add(earDtoSQL);
		 }
		 dbManager.executePreparedUpdate();
		 resultSet.close();
		return earDtoList;
	}
}
