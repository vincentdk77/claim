package com.sinosoft.claim.bl.action.domain;

import java.util.Collection;

import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterInjuryPerson;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLinterInjuryPersonActionBase {
	private static Logger logger = Logger.getLogger(BLPrplinterrelationActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterInjuryPersonActionBase(){
    }
    
    //插入数据
    public void insert(DBManager dbManager,PrpLinterInjuryPersonDto prpLinterInjuryPersonDto)
    	throws Exception{
    	DBPrpLinterInjuryPerson dbPrpLinterInjuryPerson = new DBPrpLinterInjuryPerson(dbManager);
		//插入记录
    	dbPrpLinterInjuryPerson.insert(prpLinterInjuryPersonDto);
	}
    //插入数据数组
    public void insertall(DBManager dbManager,PrpLinterInjuryPersonDto[] prpLinterInjuryPersonDto)
    	throws Exception{
    	DBPrpLinterInjuryPerson dbPrpLinterInjuryPerson = new DBPrpLinterInjuryPerson(dbManager);
		//插入记录
		for(int i=0;i<prpLinterInjuryPersonDto.length;i++){
			dbPrpLinterInjuryPerson.insert(prpLinterInjuryPersonDto[i]);
		}
    }
    
    public Collection findByConditions(DBManager dbManager,String conditions)throws Exception{
    	DBPrpLinterInjuryPerson dbPrpLinterInjuryPerson = new DBPrpLinterInjuryPerson(dbManager);
    	return dbPrpLinterInjuryPerson.findByConditions(conditions);
    }
}
