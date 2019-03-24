package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLchargeAction;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcharge-��������Ϣ���ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.375<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLchargeFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLchargeFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLchargeFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLchargeDto prpLchargeDto
     * @throws Exception
     */
    public void insert(PrpLchargeDto prpLchargeDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLchargeAction blPrpLchargeAction = new BLPrpLchargeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLchargeAction.insert(dbManager,prpLchargeDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ������ɾ��һ������
     * @param compensateNo ���������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String compensateNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLchargeAction blPrpLchargeAction = new BLPrpLchargeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLchargeAction.delete(dbManager,compensateNo, serialNo);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ������ɾ������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLchargeAction blPrpLchargeAction = new BLPrpLchargeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLchargeAction.deleteByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLchargeDto prpLchargeDto
     * @throws Exception
     */
    public void update(PrpLchargeDto prpLchargeDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLchargeAction blPrpLchargeAction = new BLPrpLchargeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLchargeAction.update(dbManager,prpLchargeDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ����������һ������
     * @param compensateNo ���������
     * @param serialNo ���
     * @return prpLchargeDto prpLchargeDto
     * @throws Exception
     */
    public PrpLchargeDto findByPrimaryKey(String compensateNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLchargeAction blPrpLchargeAction = new BLPrpLchargeAction();
        //����DTO
        PrpLchargeDto prpLchargeDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLchargeDto = blPrpLchargeAction.findByPrimaryKey(dbManager,compensateNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLchargeDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLchargeAction blPrpLchargeAction = new BLPrpLchargeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLchargeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection ����prpLchargeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLchargeAction blPrpLchargeAction = new BLPrpLchargeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLchargeAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLchargeAction blPrpLchargeAction = new BLPrpLchargeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLchargeAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    public int getMaxSerialNo(String conditions) 
    throws Exception{
    int rowCount=0;
    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    DBManager dbManager = new DBManager();
    BLPrpLchargeAction blPrpLchargeAction = new BLPrpLchargeAction();
    try{
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        rowCount = blPrpLchargeAction.getMaxSerialNo(dbManager, conditions);
    }catch(Exception exception){
        throw exception;
    }finally{
        dbManager.close();
    }
    return rowCount;
}
}
