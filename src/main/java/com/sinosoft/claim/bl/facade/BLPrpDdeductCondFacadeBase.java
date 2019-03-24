package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDdeductCondAction;
import com.sinosoft.claim.dto.domain.PrpDdeductCondDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpDdeductCond-�����������ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDdeductCondFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDdeductCondFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpDdeductCondFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpDdeductCondDto prpDdeductCondDto
     * @throws Exception
     */
    public void insert(PrpDdeductCondDto prpDdeductCondDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpDdeductCondAction.insert(dbManager,prpDdeductCondDto);
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
     * @param riskCode ����
     * @param clauseType �������
     * @param kindCode �ձ����
     * @param deductCondCode ������������
     * @param dEDUCTPERIOD ����
     * @throws Exception
     */
    public void delete(String riskCode,String clauseType,String kindCode,String deductCondCode,String dEDUCTPERIOD)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpDdeductCondAction.delete(dbManager,riskCode, clauseType, kindCode, deductCondCode, dEDUCTPERIOD);
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
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpDdeductCondAction.deleteByConditions(dbManager,conditions);
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
     * @param prpDdeductCondDto prpDdeductCondDto
     * @throws Exception
     */
    public void update(PrpDdeductCondDto prpDdeductCondDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpDdeductCondAction.update(dbManager,prpDdeductCondDto);
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
     * @param riskCode ����
     * @param clauseType �������
     * @param kindCode �ձ����
     * @param deductCondCode ������������
     * @param dEDUCTPERIOD ����
     * @return prpDdeductCondDto prpDdeductCondDto
     * @throws Exception
     */
    public PrpDdeductCondDto findByPrimaryKey(String riskCode,String clauseType,String kindCode,String deductCondCode,String dEDUCTPERIOD)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        //����DTO
        PrpDdeductCondDto prpDdeductCondDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpDdeductCondDto = blPrpDdeductCondAction.findByPrimaryKey(dbManager,riskCode, clauseType, kindCode, deductCondCode, dEDUCTPERIOD);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDdeductCondDto;
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
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpDdeductCondAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpDdeductCondDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpDdeductCondAction.findByConditions(dbManager,conditions);
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
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpDdeductCondAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
