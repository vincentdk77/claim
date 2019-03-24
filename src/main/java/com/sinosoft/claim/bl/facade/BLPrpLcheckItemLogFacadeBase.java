package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLcheckItemLogAction;
import com.sinosoft.claim.dto.domain.PrpLcheckItemLogDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcheckItemLog-�鿱������Ϣ������־���ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.750<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckItemLogFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckItemLogFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcheckItemLogFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLcheckItemLogDto prpLcheckItemLogDto
     * @throws Exception
     */
    public void insert(PrpLcheckItemLogDto prpLcheckItemLogDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcheckItemLogAction blPrpLcheckItemLogAction = new BLPrpLcheckItemLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLcheckItemLogAction.insert(dbManager,prpLcheckItemLogDto);
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
     * @param itemNo ������
     * @param serialNo �������
     * @throws Exception
     */
    public void delete(int scheduleID,String registNo,double itemNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcheckItemLogAction blPrpLcheckItemLogAction = new BLPrpLcheckItemLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLcheckItemLogAction.delete(dbManager,scheduleID, registNo, itemNo, serialNo);
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
        BLPrpLcheckItemLogAction blPrpLcheckItemLogAction = new BLPrpLcheckItemLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLcheckItemLogAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLcheckItemLogDto prpLcheckItemLogDto
     * @throws Exception
     */
    public void update(PrpLcheckItemLogDto prpLcheckItemLogDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcheckItemLogAction blPrpLcheckItemLogAction = new BLPrpLcheckItemLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLcheckItemLogAction.update(dbManager,prpLcheckItemLogDto);
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
     * @param itemNo ������
     * @param serialNo �������
     * @return prpLcheckItemLogDto prpLcheckItemLogDto
     * @throws Exception
     */
    public PrpLcheckItemLogDto findByPrimaryKey(int scheduleID,String registNo,double itemNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcheckItemLogAction blPrpLcheckItemLogAction = new BLPrpLcheckItemLogAction();
        //����DTO
        PrpLcheckItemLogDto prpLcheckItemLogDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLcheckItemLogDto = blPrpLcheckItemLogAction.findByPrimaryKey(dbManager,scheduleID, registNo, itemNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLcheckItemLogDto;
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
        BLPrpLcheckItemLogAction blPrpLcheckItemLogAction = new BLPrpLcheckItemLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLcheckItemLogAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLcheckItemLogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcheckItemLogAction blPrpLcheckItemLogAction = new BLPrpLcheckItemLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLcheckItemLogAction.findByConditions(dbManager,conditions);
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
        BLPrpLcheckItemLogAction blPrpLcheckItemLogAction = new BLPrpLcheckItemLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLcheckItemLogAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
