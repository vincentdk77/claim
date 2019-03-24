package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLcertifyDirectAction;
import com.sinosoft.claim.dto.domain.PrpLcertifyDirectDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLcertifyDirect������ָ����ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLcertifyDirectFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyDirectFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcertifyDirectFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLcertifyDirectDto prpLcertifyDirectDto
     * @throws Exception
     */
    public void insert(PrpLcertifyDirectDto prpLcertifyDirectDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyDirectAction blPrpLcertifyDirectAction = new BLPrpLcertifyDirectAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpLcertifyDirectAction.insert(dbManager,prpLcertifyDirectDto);
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
     * @param serialNo ���
     * @param lossItemCode ��Ĵ���
     * @throws Exception
     */
    public void delete(String registNo,int serialNo,String lossItemCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyDirectAction blPrpLcertifyDirectAction = new BLPrpLcertifyDirectAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLcertifyDirectAction.delete(dbManager,registNo, serialNo, lossItemCode);
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
        BLPrpLcertifyDirectAction blPrpLcertifyDirectAction = new BLPrpLcertifyDirectAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLcertifyDirectAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLcertifyDirectDto prpLcertifyDirectDto
     * @throws Exception
     */
    public void update(PrpLcertifyDirectDto prpLcertifyDirectDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyDirectAction blPrpLcertifyDirectAction = new BLPrpLcertifyDirectAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLcertifyDirectAction.update(dbManager,prpLcertifyDirectDto);
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
     * @param serialNo ���
     * @param lossItemCode ��Ĵ���
     * @return prpLcertifyDirectDto prpLcertifyDirectDto
     * @throws Exception
     */
    public PrpLcertifyDirectDto findByPrimaryKey(String registNo,int serialNo,String lossItemCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyDirectAction blPrpLcertifyDirectAction = new BLPrpLcertifyDirectAction();
        //����DTO
        PrpLcertifyDirectDto prpLcertifyDirectDto = null;
        try{
            dbManager.open("claimDataSource");
            //��ѯ����,��ֵ��DTO
            prpLcertifyDirectDto = blPrpLcertifyDirectAction.findByPrimaryKey(dbManager,registNo, serialNo, lossItemCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLcertifyDirectDto;
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
        BLPrpLcertifyDirectAction blPrpLcertifyDirectAction = new BLPrpLcertifyDirectAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blPrpLcertifyDirectAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLcertifyDirectDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcertifyDirectAction blPrpLcertifyDirectAction = new BLPrpLcertifyDirectAction();
        try{
            dbManager.open("claimDataSource");
            collection = blPrpLcertifyDirectAction.findByConditions(dbManager,conditions);
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
        BLPrpLcertifyDirectAction blPrpLcertifyDirectAction = new BLPrpLcertifyDirectAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blPrpLcertifyDirectAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
