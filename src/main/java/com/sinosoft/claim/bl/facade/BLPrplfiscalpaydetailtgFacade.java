package com.sinosoft.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrplfiscalpaydetailtgAction;
import com.sinosoft.claim.bl.action.domain.BLPrplpayAction;
import com.sinosoft.claim.dto.domain.PrpLpayShowDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;

/**
 * ����PRPLPAY��ҵ�����tgFacade��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplfiscalpaydetailtgFacade extends BLPrplfiscalpaydetailtgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplfiscalpaydetailtgFacade.class);

    /**
     * ���캯��
     */
    public BLPrplfiscalpaydetailtgFacade(){
        super();
    }
   
    /**
     *  ����֧��״̬
     * @param vflag
     * @param serialno
     * @throws Exception
     */
    public void updateVFlag(String vflag,String serialno)
    throws Exception{
	    DBManager dbManager = new DBManager();
	    BLPrplfiscalpaydetailtgAction blPrplfiscalpaydetailAction = new BLPrplfiscalpaydetailtgAction(); 
	    try{
	        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	        dbManager.beginTransaction();
	        //���¼�¼
	        blPrplfiscalpaydetailAction.updateVFlag(dbManager,vflag,serialno);
	        dbManager.commitTransaction();
	    }catch(Exception exception){
	        dbManager.rollbackTransaction();
	        throw exception;
	    }finally{
	        dbManager.close();
	    }
	}
    
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection ����prplfiscaldetailpayDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplfiscalpaydetailtgAction blPrplfiscalpaydetailAction = new BLPrplfiscalpaydetailtgAction(); 
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            collection = blPrplfiscalpaydetailAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
}
