package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLqualityCheckAction;
import com.sinosoft.claim.dto.domain.PrpLqualityCheckDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLqualityCheck-�����������ݱ��ҵ���߼�����Facade����<br>
 * ������ 2005-04-14 15:56:47.984<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLqualityCheckFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLqualityCheckFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLqualityCheckFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLqualityCheckDto prpLqualityCheckDto
     * @throws Exception
     */
    public void insert(PrpLqualityCheckDto prpLqualityCheckDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpLqualityCheckAction.insert(dbManager,prpLqualityCheckDto);
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
     * @param registNo ��������
     * @param qualityCheckType ҵ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String registNo,String qualityCheckType,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLqualityCheckAction.delete(dbManager,registNo, qualityCheckType, serialNo);
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
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLqualityCheckAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLqualityCheckDto prpLqualityCheckDto
     * @throws Exception
     */
    public void update(PrpLqualityCheckDto prpLqualityCheckDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLqualityCheckAction.update(dbManager,prpLqualityCheckDto);
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
     * @param registNo ��������
     * @param qualityCheckType ҵ������
     * @param serialNo ���
     * @return prpLqualityCheckDto prpLqualityCheckDto
     * @throws Exception
     */
    public PrpLqualityCheckDto findByPrimaryKey(String registNo,String qualityCheckType,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        //����DTO
        PrpLqualityCheckDto prpLqualityCheckDto = null;
        try{
            dbManager.open("claimDataSource");
            //��ѯ����,��ֵ��DTO
            prpLqualityCheckDto = blPrpLqualityCheckAction.findByPrimaryKey(dbManager,registNo, qualityCheckType, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLqualityCheckDto;
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
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blPrpLqualityCheckAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLqualityCheckDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        try{
            dbManager.open("claimDataSource");
            collection = blPrpLqualityCheckAction.findByConditions(dbManager,conditions);
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
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blPrpLqualityCheckAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
