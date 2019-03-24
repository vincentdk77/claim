package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLendorAction;
import com.sinosoft.claim.dto.domain.PrpLendorDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLendor��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLendorFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLendorFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLendorFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLendorDto prpLendorDto
     * @throws Exception
     */
    public void insert(PrpLendorDto prpLendorDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpLendorAction.insert(dbManager,prpLendorDto);
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
     * @param compensateNo compensateNo
     * @param policyNo policyNo
     * @param itemKindNo itemKindNo
     * @param endorType endorType
     * @throws Exception
     */
    public void delete(String compensateNo,String policyNo,int itemKindNo,String endorType)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLendorAction.delete(dbManager,compensateNo, policyNo, itemKindNo, endorType);
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
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLendorAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLendorDto prpLendorDto
     * @throws Exception
     */
    public void update(PrpLendorDto prpLendorDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLendorAction.update(dbManager,prpLendorDto);
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
     * @param compensateNo compensateNo
     * @param policyNo policyNo
     * @param itemKindNo itemKindNo
     * @param endorType endorType
     * @return prpLendorDto prpLendorDto
     * @throws Exception
     */
    public PrpLendorDto findByPrimaryKey(String compensateNo,String policyNo,int itemKindNo,String endorType)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        //����DTO
        PrpLendorDto prpLendorDto = null;
        try{
            dbManager.open("ddccDataSource");
            //��ѯ����,��ֵ��DTO
            prpLendorDto = blPrpLendorAction.findByPrimaryKey(dbManager,compensateNo, policyNo, itemKindNo, endorType);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLendorDto;
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
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        try{
            dbManager.open("ddccDataSource");
            pageRecord = blPrpLendorAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLendorDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        try{
            dbManager.open("ddccDataSource");
            collection = blPrpLendorAction.findByConditions(dbManager,conditions);
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
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        try{
            dbManager.open("ddccDataSource");
            rowCount = blPrpLendorAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
