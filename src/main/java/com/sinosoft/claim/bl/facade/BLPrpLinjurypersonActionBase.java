package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLinjuryPersonDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinjuryPerson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinjuryPersonBase;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLinjurypersonActionBase {
	 private static Log logger = LogFactory.getLog(BLPrpLinjurypersonActionBase.class);
	 public BLPrpLinjurypersonActionBase(){
	    }
	 //插入数据
	 public void insert(DBManager dbManager,PrpLinjuryPersonDto prpLinjuryPrsonDto) throws Exception{
	        DBPrpLinjuryPerson dBPrpLinjuryPerson = new DBPrpLinjuryPerson(dbManager);
	        //插入记录
	        dBPrpLinjuryPerson.insert(prpLinjuryPrsonDto);
	    }
	 //插入数据数组
	 public void insertall(DBManager dbManager,PrpLinjuryPersonDto[] prpLinjuryPrsonDto) throws Exception{
	        DBPrpLinjuryPerson dBPrpLinjuryPerson = new DBPrpLinjuryPerson(dbManager);
	        //插入记录
	        for(int i=0;i<prpLinjuryPrsonDto.length;i++){
	        	dBPrpLinjuryPerson.insert(prpLinjuryPrsonDto[i]);
	        }
	    }
	//删除数据
	  public void delete(DBManager dbManager,String CompensateNo) throws Exception{
		  DBPrpLinjuryPerson dBPrpLinjuryPerson = new DBPrpLinjuryPerson(dbManager);
	        //删除记录
		  dBPrpLinjuryPerson.delete(CompensateNo);
	    }

	//查找数据
	   public PrpLinjuryPersonDto findByPrimaryKey(DBManager dbManager,String CompensateNo) throws Exception{
		    DBPrpLinjuryPersonBase dBPrpLinjuryPersonBase = new DBPrpLinjuryPersonBase(dbManager);
	        PrpLinjuryPersonDto prpLinjuryPersonDto = null;
	        prpLinjuryPersonDto = dBPrpLinjuryPersonBase.findByPrimaryKey(CompensateNo);
	        return prpLinjuryPersonDto;
	    }
	   
	   public Collection findByCondition(DBManager dbManager,String conditions)throws Exception{
		   DBPrpLinjuryPersonBase dBPrpLinjuryPersonBase = new DBPrpLinjuryPersonBase(dbManager);
		   Collection prpLinjuryPersonList = new ArrayList();
		   if(conditions.trim().length()==0)
			   conditions ="1=1";
		   return dBPrpLinjuryPersonBase.findByConditions(conditions);
	   }
}
