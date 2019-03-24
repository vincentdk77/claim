package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLscheduleMainAction;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleMain-�������������ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.546<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleMainFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleMainFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLscheduleMainFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLscheduleMainDto prpLscheduleMainDto
     * @throws Exception
     */
    public void insert(PrpLscheduleMainDto prpLscheduleMainDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLscheduleMainAction.insert(dbManager,prpLscheduleMainDto);
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
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(int scheduleID,String registNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLscheduleMainAction.delete(dbManager,scheduleID, registNo, serialNo);
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
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLscheduleMainAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLscheduleMainDto prpLscheduleMainDto
     * @throws Exception
     */
    public void update(PrpLscheduleMainDto prpLscheduleMainDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLscheduleMainAction.update(dbManager,prpLscheduleMainDto);
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
     * @param serialNo ���
     * @return prpLscheduleMainDto prpLscheduleMainDto
     * @throws Exception
     */
    public PrpLscheduleMainDto findByPrimaryKey(int scheduleID,String registNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        //����DTO
        PrpLscheduleMainDto prpLscheduleMainDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLscheduleMainDto = blPrpLscheduleMainAction.findByPrimaryKey(dbManager,scheduleID, registNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLscheduleMainDto;
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
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLscheduleMainAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLscheduleMainDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLscheduleMainAction.findByConditions(dbManager,conditions);
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
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLscheduleMainAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
