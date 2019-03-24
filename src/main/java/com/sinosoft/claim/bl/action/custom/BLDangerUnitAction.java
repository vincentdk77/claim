package com.sinosoft.claim.bl.action.custom;

import java.util.ArrayList;
import java.util.List;


import com.sinosoft.claim.resource.dtofactory.custom.DBDangerUnit;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��ѯΣ�յ�λ��Ϣ��BL��
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>@createdate 2011-01-17</p>
 * @Author  :��Ԫ��Ŀ��
 * @version 1.0
 */
public class BLDangerUnitAction{

    /**
     * ���캯��
     */
    public BLDangerUnitAction(){
    }


    public List getPrpCdangerUnit(DBManager dbManager,String policyNo,String itemKindNo) throws Exception{

    	List list = new ArrayList();
        DBDangerUnit dbDangerUnit   = new DBDangerUnit(dbManager);
        list=  dbDangerUnit.getPrpCdangerUnit(policyNo,itemKindNo);
        return list;
    }
    
    
    public List getCompensatePrpCdangerUnit(DBManager dbManager,String policyNo,String kingCodeList) throws Exception{

    	List list = new ArrayList();
        DBDangerUnit dbDangerUnit   = new DBDangerUnit(dbManager);
        list=  dbDangerUnit.getCompensatePrpCdangerUnit(policyNo,kingCodeList);
        return list;
    }
    
    public List getPrpPdangerUnit(DBManager dbManager,String registNo,String policyNo,String itemKindNo) throws Exception{

    	List list = new ArrayList();
       DBDangerUnit dbDangerUnit   = new DBDangerUnit(dbManager);
       list=  dbDangerUnit.getPrpPdangerUnit(registNo,policyNo, itemKindNo);
       return list;
   }
   

    
    
    
    public List getCompensatePrpPdangerUnit(DBManager dbManager,String registNo,String policyNo,String kingCodeList) throws Exception{

    	List list = new ArrayList();
       DBDangerUnit dbDangerUnit   = new DBDangerUnit(dbManager);
       list=  dbDangerUnit.getCompensatePrpPdangerUnit(registNo,policyNo,kingCodeList);
       return list;
   }
    
    
    
    public List getPrpLdangerUnit(DBManager dbManager,String certino) throws Exception{

    	List list = new ArrayList();
       DBDangerUnit dbDangerUnit   = new DBDangerUnit(dbManager);
       list=  dbDangerUnit.getPrpLdangerUnit(certino);
       return list;
   }
   
}
