package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpClimitAction;
import com.sinosoft.claim.dto.domain.PrpClimitDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpClimit��ҵ���߼�����Facade����<br>
 * ������ 2006-06-09 15:31:33.828<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpClimitFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpClimitFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpClimitFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpClimitDto prpClimitDto
     * @throws Exception
     */
    public void insert(PrpClimitDto prpClimitDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpClimitAction.insert(dbManager,prpClimitDto);
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
     * @param policyNo PolicyNo
     * @param limitGrade LimitGrade
     * @param limitNo LimitNo
     * @param limitType LimitType
     * @param currency Currency
     * @throws Exception
     */
    public void delete(String policyNo,String limitGrade,double limitNo,String limitType,String currency) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpClimitAction.delete(dbManager,policyNo, limitGrade, limitNo, limitType, currency);
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
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpClimitAction.deleteByConditions(dbManager,conditions);
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
     * @param prpClimitDto prpClimitDto
     * @throws Exception
     */
    public void update(PrpClimitDto prpClimitDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpClimitAction.update(dbManager,prpClimitDto);
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
     * @param policyNo PolicyNo
     * @param limitGrade LimitGrade
     * @param limitNo LimitNo
     * @param limitType LimitType
     * @param currency Currency
     * @return prpClimitDto prpClimitDto
     * @throws Exception
     */
    public PrpClimitDto findByPrimaryKey(String policyNo,String limitGrade,double limitNo,String limitType,String currency) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        //����DTO
        PrpClimitDto prpClimitDto = null;
        try{
            dbManager.open("claimDataSource");
            //��ѯ����,��ֵ��DTO
            prpClimitDto = blPrpClimitAction.findByPrimaryKey(dbManager,policyNo, limitGrade, limitNo, limitType, currency);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpClimitDto;
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
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blPrpClimitAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpClimitDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        try{
            dbManager.open("claimDataSource");
            collection = blPrpClimitAction.findByConditions(dbManager,conditions);
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
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blPrpClimitAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
