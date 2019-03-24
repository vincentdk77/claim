package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDaccidentDeductAction;
import com.sinosoft.claim.dto.domain.PrpDaccidentDeductDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpDaccidentDeduct-�¹����������ʵ�ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDaccidentDeductFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDaccidentDeductFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpDaccidentDeductFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpDaccidentDeductDto prpDaccidentDeductDto
     * @throws Exception
     */
    public void insert(PrpDaccidentDeductDto prpDaccidentDeductDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpDaccidentDeductAction.insert(dbManager,prpDaccidentDeductDto);
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
     * @param indemnityDuty �⳥���δ���
     * @param dangerLevel ����ˮƽ
     * @param deductPeriod ����
     * @throws Exception
     */
    public void delete(String riskCode,String kindCode,String indemnityDuty,String dangerLevel,String deductPeriod)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpDaccidentDeductAction.delete(dbManager,riskCode, kindCode, indemnityDuty, dangerLevel, deductPeriod);
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
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpDaccidentDeductAction.deleteByConditions(dbManager,conditions);
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
     * @param prpDaccidentDeductDto prpDaccidentDeductDto
     * @throws Exception
     */
    public void update(PrpDaccidentDeductDto prpDaccidentDeductDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpDaccidentDeductAction.update(dbManager,prpDaccidentDeductDto);
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
     * @param indemnityDuty �⳥���δ���
     * @param dangerLevel ����ˮƽ
     * @param deductPeriod ����
     * @return prpDaccidentDeductDto prpDaccidentDeductDto
     * @throws Exception
     */
    public PrpDaccidentDeductDto findByPrimaryKey(String riskCode,String kindCode,String indemnityDuty,String dangerLevel,String deductPeriod)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        //����DTO
        PrpDaccidentDeductDto prpDaccidentDeductDto = null;
        try{
            // �������ݿ�������
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpDaccidentDeductDto = blPrpDaccidentDeductAction.findByPrimaryKey(dbManager,riskCode, kindCode, indemnityDuty, dangerLevel, deductPeriod);
            
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDaccidentDeductDto;
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
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpDaccidentDeductAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpDaccidentDeductDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpDaccidentDeductAction.findByConditions(dbManager,conditions);
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
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpDaccidentDeductAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
