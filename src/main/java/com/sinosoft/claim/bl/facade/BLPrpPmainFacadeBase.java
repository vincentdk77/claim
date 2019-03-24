package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpPmainAction;
import com.sinosoft.claim.dto.domain.PrpPmainDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prppmain���ı�����Ϣ���ҵ���߼�����Facade����<br>
 * ������ 2004-11-22 15:24:35.171<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPmainFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpPmainFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpPmainFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpPmainDto prpPmainDto
     * @throws Exception
     */
    public void insert(PrpPmainDto prpPmainDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPmainAction blPrpPmainAction = new BLPrpPmainAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpPmainAction.insert(dbManager,prpPmainDto);
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
     * @param endorseNo ��������
     * @throws Exception
     */
    public void delete(String endorseNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPmainAction blPrpPmainAction = new BLPrpPmainAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpPmainAction.delete(dbManager,endorseNo);
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
        BLPrpPmainAction blPrpPmainAction = new BLPrpPmainAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpPmainAction.deleteByConditions(dbManager,conditions);
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
     * @param prpPmainDto prpPmainDto
     * @throws Exception
     */
    public void update(PrpPmainDto prpPmainDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPmainAction blPrpPmainAction = new BLPrpPmainAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpPmainAction.update(dbManager,prpPmainDto);
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
     * @param endorseNo ��������
     * @return prpPmainDto prpPmainDto
     * @throws Exception
     */
    public PrpPmainDto findByPrimaryKey(String endorseNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPmainAction blPrpPmainAction = new BLPrpPmainAction();
        //����DTO
        PrpPmainDto prpPmainDto = null;
        try{
            dbManager.open("claimTempDataSource");
            //��ѯ����,��ֵ��DTO
            prpPmainDto = blPrpPmainAction.findByPrimaryKey(dbManager,endorseNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpPmainDto;
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
        BLPrpPmainAction blPrpPmainAction = new BLPrpPmainAction();
        try{
            dbManager.open("claimTempDataSource");
            pageRecord = blPrpPmainAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpPmainDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpPmainAction blPrpPmainAction = new BLPrpPmainAction();
        try{
            dbManager.open("claimTempDataSource");
            collection = blPrpPmainAction.findByConditions(dbManager,conditions);
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
        BLPrpPmainAction blPrpPmainAction = new BLPrpPmainAction();
        try{
            dbManager.open("claimTempDataSource");
            rowCount = blPrpPmainAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
