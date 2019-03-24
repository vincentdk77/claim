package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLsalvationAction;
import com.sinosoft.claim.dto.domain.PrpLsalvationDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLsalvation-��Լ�������ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.546<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLsalvationFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLsalvationFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLsalvationFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLsalvationDto prpLsalvationDto
     * @throws Exception
     */
    public void insert(PrpLsalvationDto prpLsalvationDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLsalvationAction blPrpLsalvationAction = new BLPrpLsalvationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLsalvationAction.insert(dbManager,prpLsalvationDto);
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
     * @param registNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String registNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLsalvationAction blPrpLsalvationAction = new BLPrpLsalvationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLsalvationAction.delete(dbManager,registNo, serialNo);
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
        BLPrpLsalvationAction blPrpLsalvationAction = new BLPrpLsalvationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLsalvationAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLsalvationDto prpLsalvationDto
     * @throws Exception
     */
    public void update(PrpLsalvationDto prpLsalvationDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLsalvationAction blPrpLsalvationAction = new BLPrpLsalvationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLsalvationAction.update(dbManager,prpLsalvationDto);
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
     * @param registNo ������
     * @param serialNo ���
     * @return prpLsalvationDto prpLsalvationDto
     * @throws Exception
     */
    public PrpLsalvationDto findByPrimaryKey(String registNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLsalvationAction blPrpLsalvationAction = new BLPrpLsalvationAction();
        //����DTO
        PrpLsalvationDto prpLsalvationDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLsalvationDto = blPrpLsalvationAction.findByPrimaryKey(dbManager,registNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLsalvationDto;
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
        BLPrpLsalvationAction blPrpLsalvationAction = new BLPrpLsalvationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLsalvationAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLsalvationDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLsalvationAction blPrpLsalvationAction = new BLPrpLsalvationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLsalvationAction.findByConditions(dbManager,conditions);
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
        BLPrpLsalvationAction blPrpLsalvationAction = new BLPrpLsalvationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLsalvationAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
