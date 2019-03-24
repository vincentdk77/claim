package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLcheckItemAction;
import com.sinosoft.claim.dto.domain.PrpLcheckItemDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcheckItem-�鿱�����ı���������ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.640<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckItemFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckItemFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcheckItemFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLcheckItemDto prpLcheckItemDto
     * @throws Exception
     */
    public void insert(PrpLcheckItemDto prpLcheckItemDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcheckItemAction blPrpLcheckItemAction = new BLPrpLcheckItemAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLcheckItemAction.insert(dbManager,prpLcheckItemDto);
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
     * @throws Exception
     */
    public void delete(int scheduleID,String registNo,int itemNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcheckItemAction blPrpLcheckItemAction = new BLPrpLcheckItemAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLcheckItemAction.delete(dbManager,scheduleID, registNo, itemNo);
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
        BLPrpLcheckItemAction blPrpLcheckItemAction = new BLPrpLcheckItemAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLcheckItemAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLcheckItemDto prpLcheckItemDto
     * @throws Exception
     */
    public void update(PrpLcheckItemDto prpLcheckItemDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcheckItemAction blPrpLcheckItemAction = new BLPrpLcheckItemAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLcheckItemAction.update(dbManager,prpLcheckItemDto);
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
     * @return prpLcheckItemDto prpLcheckItemDto
     * @throws Exception
     */
    public PrpLcheckItemDto findByPrimaryKey(int scheduleID,String registNo,int itemNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcheckItemAction blPrpLcheckItemAction = new BLPrpLcheckItemAction();
        //����DTO
        PrpLcheckItemDto prpLcheckItemDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLcheckItemDto = blPrpLcheckItemAction.findByPrimaryKey(dbManager,scheduleID, registNo, itemNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLcheckItemDto;
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
        BLPrpLcheckItemAction blPrpLcheckItemAction = new BLPrpLcheckItemAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLcheckItemAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLcheckItemDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcheckItemAction blPrpLcheckItemAction = new BLPrpLcheckItemAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLcheckItemAction.findByConditions(dbManager,conditions);
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
        BLPrpLcheckItemAction blPrpLcheckItemAction = new BLPrpLcheckItemAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLcheckItemAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
