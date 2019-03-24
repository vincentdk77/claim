package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLkindItemAction;
import com.sinosoft.claim.dto.domain.PrpLkindItemDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǳб��ձ��ı��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLkindItemFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLkindItemFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLkindItemFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLkindItemDto prpLkindItemDto
     * @throws Exception
     */
    public void insert(PrpLkindItemDto prpLkindItemDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpLkindItemAction.insert(dbManager,prpLkindItemDto);
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
     * @param riskCode ���ִ���
     * @param kindCode �ձ����
     * @param itemCode �����Ŀ����
     * @throws Exception
     */
    public void delete(String riskCode,String kindCode,String itemCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLkindItemAction.delete(dbManager,riskCode, kindCode, itemCode);
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
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLkindItemAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLkindItemDto prpLkindItemDto
     * @throws Exception
     */
    public void update(PrpLkindItemDto prpLkindItemDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLkindItemAction.update(dbManager,prpLkindItemDto);
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
     * @param riskCode ���ִ���
     * @param kindCode �ձ����
     * @param itemCode �����Ŀ����
     * @return prpLkindItemDto prpLkindItemDto
     * @throws Exception
     */
    public PrpLkindItemDto findByPrimaryKey(String riskCode,String kindCode,String itemCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        //����DTO
        PrpLkindItemDto prpLkindItemDto = null;
        try{
            dbManager.open("claimDataSource");
            //��ѯ����,��ֵ��DTO
            prpLkindItemDto = blPrpLkindItemAction.findByPrimaryKey(dbManager,riskCode, kindCode, itemCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLkindItemDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blPrpLkindItemAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLkindItemDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        try{
            dbManager.open("claimDataSource");
            collection = blPrpLkindItemAction.findByConditions(dbManager,conditions);
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
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blPrpLkindItemAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
