package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLpayHisAction;
import com.sinosoft.claim.dto.domain.PrpLpayHisDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����prpLpayHis��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayHisFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayHisFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpayHisFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public void insert(PrpLpayHisDto prpLpayHisDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLpayHisAction.insert(dbManager,prpLpayHisDto);
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
     * @param serialNo serialNo
     * @param serialNo2 serialNo2
     * @throws Exception
     */
    public void delete(String serialNo,String serialNo2)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLpayHisAction.delete(dbManager,serialNo, serialNo2);
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
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLpayHisAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public void update(PrpLpayHisDto prpLpayHisDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpayHisAction.update(dbManager,prpLpayHisDto);
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
     * @param serialNo serialNo
     * @param serialNo2 serialNo2
     * @return prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public PrpLpayHisDto findByPrimaryKey(String serialNo,String serialNo2)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        //����DTO
        PrpLpayHisDto prpLpayHisDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLpayHisDto = blPrpLpayHisAction.findByPrimaryKey(dbManager,serialNo, serialNo2);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLpayHisDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpayHisAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLpayHisDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpayHisAction.findByConditions(dbManager,conditions);
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
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLpayHisAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
