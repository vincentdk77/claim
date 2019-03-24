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
	 //��������
	 public void insert(DBManager dbManager,PrpLinjuryPersonDto prpLinjuryPrsonDto) throws Exception{
	        DBPrpLinjuryPerson dBPrpLinjuryPerson = new DBPrpLinjuryPerson(dbManager);
	        //�����¼
	        dBPrpLinjuryPerson.insert(prpLinjuryPrsonDto);
	    }
	 //������������
	 public void insertall(DBManager dbManager,PrpLinjuryPersonDto[] prpLinjuryPrsonDto) throws Exception{
	        DBPrpLinjuryPerson dBPrpLinjuryPerson = new DBPrpLinjuryPerson(dbManager);
	        //�����¼
	        for(int i=0;i<prpLinjuryPrsonDto.length;i++){
	        	dBPrpLinjuryPerson.insert(prpLinjuryPrsonDto[i]);
	        }
	    }
	//ɾ������
	  public void delete(DBManager dbManager,String CompensateNo) throws Exception{
		  DBPrpLinjuryPerson dBPrpLinjuryPerson = new DBPrpLinjuryPerson(dbManager);
	        //ɾ����¼
		  dBPrpLinjuryPerson.delete(CompensateNo);
	    }

	//��������
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
