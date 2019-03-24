package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLscheduleMainWFAction;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleMainWF��ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.765<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleMainWFFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleMainWFFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLscheduleMainWFFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLscheduleMainWFDto prpLscheduleMainWFDto
     * @throws Exception
     */
    public void insert(PrpLscheduleMainWFDto prpLscheduleMainWFDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleMainWFAction blPrpLscheduleMainWFAction = new BLPrpLscheduleMainWFAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLscheduleMainWFAction.insert(dbManager,prpLscheduleMainWFDto);
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
     * @param scheduleID ����ID
     * @param registNo ��������
     * @throws Exception
     */
    public void delete(int scheduleID,String registNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleMainWFAction blPrpLscheduleMainWFAction = new BLPrpLscheduleMainWFAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLscheduleMainWFAction.delete(dbManager,scheduleID, registNo);
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
        BLPrpLscheduleMainWFAction blPrpLscheduleMainWFAction = new BLPrpLscheduleMainWFAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLscheduleMainWFAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLscheduleMainWFDto prpLscheduleMainWFDto
     * @throws Exception
     */
    public void update(PrpLscheduleMainWFDto prpLscheduleMainWFDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleMainWFAction blPrpLscheduleMainWFAction = new BLPrpLscheduleMainWFAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLscheduleMainWFAction.update(dbManager,prpLscheduleMainWFDto);
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
     * @param scheduleID ����ID
     * @param registNo ��������
     * @return prpLscheduleMainWFDto prpLscheduleMainWFDto
     * @throws Exception
     */
    public PrpLscheduleMainWFDto findByPrimaryKey(int scheduleID,String registNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleMainWFAction blPrpLscheduleMainWFAction = new BLPrpLscheduleMainWFAction();
        //����DTO
        PrpLscheduleMainWFDto prpLscheduleMainWFDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLscheduleMainWFDto = blPrpLscheduleMainWFAction.findByPrimaryKey(dbManager,scheduleID, registNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLscheduleMainWFDto;
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
        BLPrpLscheduleMainWFAction blPrpLscheduleMainWFAction = new BLPrpLscheduleMainWFAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLscheduleMainWFAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLscheduleMainWFDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLscheduleMainWFAction blPrpLscheduleMainWFAction = new BLPrpLscheduleMainWFAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLscheduleMainWFAction.findByConditions(dbManager,conditions);
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
        BLPrpLscheduleMainWFAction blPrpLscheduleMainWFAction = new BLPrpLscheduleMainWFAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLscheduleMainWFAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
