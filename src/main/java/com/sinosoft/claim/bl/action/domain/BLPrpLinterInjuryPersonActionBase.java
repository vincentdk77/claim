package com.sinosoft.claim.bl.action.domain;

import java.util.Collection;

import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterInjuryPerson;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLinterInjuryPersonActionBase {
	private static Logger logger = Logger.getLogger(BLPrplinterrelationActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterInjuryPersonActionBase(){
    }
    
    //��������
    public void insert(DBManager dbManager,PrpLinterInjuryPersonDto prpLinterInjuryPersonDto)
    	throws Exception{
    	DBPrpLinterInjuryPerson dbPrpLinterInjuryPerson = new DBPrpLinterInjuryPerson(dbManager);
		//�����¼
    	dbPrpLinterInjuryPerson.insert(prpLinterInjuryPersonDto);
	}
    //������������
    public void insertall(DBManager dbManager,PrpLinterInjuryPersonDto[] prpLinterInjuryPersonDto)
    	throws Exception{
    	DBPrpLinterInjuryPerson dbPrpLinterInjuryPerson = new DBPrpLinterInjuryPerson(dbManager);
		//�����¼
		for(int i=0;i<prpLinterInjuryPersonDto.length;i++){
			dbPrpLinterInjuryPerson.insert(prpLinterInjuryPersonDto[i]);
		}
    }
    
    public Collection findByConditions(DBManager dbManager,String conditions)throws Exception{
    	DBPrpLinterInjuryPerson dbPrpLinterInjuryPerson = new DBPrpLinterInjuryPerson(dbManager);
    	return dbPrpLinterInjuryPerson.findByConditions(conditions);
    }
}
