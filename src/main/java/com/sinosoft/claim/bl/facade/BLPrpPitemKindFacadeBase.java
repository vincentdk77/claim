package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpPitemKindAction;
import com.sinosoft.claim.dto.domain.PrpPitemKindDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prppitemkind���������Ϣ��ҵ���߼�����Facade����<br>
 * ������ 2004-11-22 15:24:35.593<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPitemKindFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpPitemKindFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpPitemKindFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpPitemKindDto prpPitemKindDto
     * @throws Exception
     */
    public void insert(PrpPitemKindDto prpPitemKindDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPitemKindAction blPrpPitemKindAction = new BLPrpPitemKindAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpPitemKindAction.insert(dbManager,prpPitemKindDto);
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
     * @param itemKindNo ���
     * @throws Exception
     */
    public void delete(String endorseNo,int itemKindNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPitemKindAction blPrpPitemKindAction = new BLPrpPitemKindAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpPitemKindAction.delete(dbManager,endorseNo, itemKindNo);
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
        BLPrpPitemKindAction blPrpPitemKindAction = new BLPrpPitemKindAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpPitemKindAction.deleteByConditions(dbManager,conditions);
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
     * @param prpPitemKindDto prpPitemKindDto
     * @throws Exception
     */
    public void update(PrpPitemKindDto prpPitemKindDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPitemKindAction blPrpPitemKindAction = new BLPrpPitemKindAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpPitemKindAction.update(dbManager,prpPitemKindDto);
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
     * @param itemKindNo ���
     * @return prpPitemKindDto prpPitemKindDto
     * @throws Exception
     */
    public PrpPitemKindDto findByPrimaryKey(String endorseNo,int itemKindNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPitemKindAction blPrpPitemKindAction = new BLPrpPitemKindAction();
        //����DTO
        PrpPitemKindDto prpPitemKindDto = null;
        try{
            dbManager.open("claimTempDataSource");
            //��ѯ����,��ֵ��DTO
            prpPitemKindDto = blPrpPitemKindAction.findByPrimaryKey(dbManager,endorseNo, itemKindNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpPitemKindDto;
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
        BLPrpPitemKindAction blPrpPitemKindAction = new BLPrpPitemKindAction();
        try{
            dbManager.open("claimTempDataSource");
            pageRecord = blPrpPitemKindAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpPitemKindDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpPitemKindAction blPrpPitemKindAction = new BLPrpPitemKindAction();
        try{
            dbManager.open("claimTempDataSource");
            collection = blPrpPitemKindAction.findByConditions(dbManager,conditions);
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
        BLPrpPitemKindAction blPrpPitemKindAction = new BLPrpPitemKindAction();
        try{
            dbManager.open("claimTempDataSource");
            rowCount = blPrpPitemKindAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
