package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLCitemKindAction;
import com.sinosoft.claim.dto.domain.PrpLCitemKindDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLCitemKind-���Ᵽ��Ͷ���ձ���ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.609<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLCitemKindFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLCitemKindFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLCitemKindFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLCitemKindDto prpLCitemKindDto
     * @throws Exception
     */
    public void insert(PrpLCitemKindDto prpLCitemKindDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLCitemKindAction.insert(dbManager,prpLCitemKindDto);
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
     * @param policyNo ��������
     * @param itemKindNo ���
     * @throws Exception
     */
    public void delete(String registNo,String policyNo,int itemKindNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLCitemKindAction.delete(dbManager,registNo, policyNo, itemKindNo);
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
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLCitemKindAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLCitemKindDto prpLCitemKindDto
     * @throws Exception
     */
    public void update(PrpLCitemKindDto prpLCitemKindDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLCitemKindAction.update(dbManager,prpLCitemKindDto);
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
     * @param policyNo ��������
     * @param itemKindNo ���
     * @return prpLCitemKindDto prpLCitemKindDto
     * @throws Exception
     */
    public PrpLCitemKindDto findByPrimaryKey(String registNo,String policyNo,int itemKindNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        //����DTO
        PrpLCitemKindDto prpLCitemKindDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLCitemKindDto = blPrpLCitemKindAction.findByPrimaryKey(dbManager,registNo, policyNo, itemKindNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLCitemKindDto;
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
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLCitemKindAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLCitemKindDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLCitemKindAction.findByConditions(dbManager,conditions);
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
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLCitemKindAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
