package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.bl.action.domain.BLHerdpolicylistAction;
import com.gyic.claim.bl.action.domain.BLPlantingpolicylistAction;
import com.gyic.claim.dto.domain.PlantingpolicylistDto;

/**
 * ����PLANTINGPOLICYLIST��ҵ�����Facade��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPlantingpolicylistFacade extends BLPlantingpolicylistFacadeBase{
    private static Logger logger = Logger.getLogger(BLPlantingpolicylistFacade.class);

    /**
     * ���캯��
     */
    public BLPlantingpolicylistFacade(){
        super();
    }
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findPlantingByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPlantingpolicylistAction blPlantingpolicylistAction = new BLPlantingpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blPlantingpolicylistAction.findPlantingByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * ��ѯ��ũ�գ���ֲ���嵥��Ϣ
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public PageRecord findNewPlantingByConditions(String conditions,int pageNo,int rowsPerPage)
    throws Exception{
    PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    DBManager dbManager = new DBManager();
    BLPlantingpolicylistAction blPlantingpolicylistAction = new BLPlantingpolicylistAction();
    try{
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        pageRecord = blPlantingpolicylistAction.findNewPlantingByConditions(dbManager,conditions,pageNo,rowsPerPage);
    }catch(Exception exception){
        throw exception;
    }finally{
        dbManager.close();
    }
    return pageRecord;
}
}
