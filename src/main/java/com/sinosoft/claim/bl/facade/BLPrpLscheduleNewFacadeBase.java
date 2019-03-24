package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLscheduleNewAction;
import com.sinosoft.claim.dto.domain.PrpLscheduleNewDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleNew-�°���������ʾ��(����)��ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.625<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleNewFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleNewFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLscheduleNewFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLscheduleNewDto prpLscheduleNewDto
     * @throws Exception
     */
    public void insert(PrpLscheduleNewDto prpLscheduleNewDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleNewAction blPrpLscheduleNewAction = new BLPrpLscheduleNewAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLscheduleNewAction.insert(dbManager,prpLscheduleNewDto);
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
     * @param registNo ���������
     * @param surveyNo �Ѳ鿱����
     * @throws Exception
     */
    public void delete(String registNo,int surveyNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleNewAction blPrpLscheduleNewAction = new BLPrpLscheduleNewAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLscheduleNewAction.delete(dbManager,registNo, surveyNo);
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
        BLPrpLscheduleNewAction blPrpLscheduleNewAction = new BLPrpLscheduleNewAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLscheduleNewAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLscheduleNewDto prpLscheduleNewDto
     * @throws Exception
     */
    public void update(PrpLscheduleNewDto prpLscheduleNewDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleNewAction blPrpLscheduleNewAction = new BLPrpLscheduleNewAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLscheduleNewAction.update(dbManager,prpLscheduleNewDto);
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
     * @param registNo ���������
     * @param surveyNo �Ѳ鿱����
     * @return prpLscheduleNewDto prpLscheduleNewDto
     * @throws Exception
     */
    public PrpLscheduleNewDto findByPrimaryKey(String registNo,int surveyNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleNewAction blPrpLscheduleNewAction = new BLPrpLscheduleNewAction();
        //����DTO
        PrpLscheduleNewDto prpLscheduleNewDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLscheduleNewDto = blPrpLscheduleNewAction.findByPrimaryKey(dbManager,registNo, surveyNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLscheduleNewDto;
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
        BLPrpLscheduleNewAction blPrpLscheduleNewAction = new BLPrpLscheduleNewAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLscheduleNewAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLscheduleNewDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLscheduleNewAction blPrpLscheduleNewAction = new BLPrpLscheduleNewAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLscheduleNewAction.findByConditions(dbManager,conditions);
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
        BLPrpLscheduleNewAction blPrpLscheduleNewAction = new BLPrpLscheduleNewAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLscheduleNewAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
