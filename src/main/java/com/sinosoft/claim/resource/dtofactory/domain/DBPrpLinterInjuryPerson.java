package com.sinosoft.claim.resource.dtofactory.domain;

import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpLinterInjuryPerson extends DBPrpLinterInjuryPersonBase{
	   private static Logger logger = Logger.getLogger(DBPrpLinterInjuryPerson.class);

	    /**
	     * ���캯��
	     * @param dbManager ��Դ������
	     */
	    public DBPrpLinterInjuryPerson(DBManager dbManager){
	        super(dbManager);
	    }
}
