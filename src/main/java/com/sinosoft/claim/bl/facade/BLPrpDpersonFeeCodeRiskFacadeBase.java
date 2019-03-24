package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpDpersonFeeCodeRiskAction;
import com.sinosoft.claim.dto.domain.PrpDpersonFeeCodeRiskDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpDpersonFeeCodeRisk-���˷������ֶ��ձ��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDpersonFeeCodeRiskFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDpersonFeeCodeRiskFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpDpersonFeeCodeRiskFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public void insert(PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpDpersonFeeCodeRiskAction.insert(dbManager,prpDpersonFeeCodeRiskDto);
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
     * @param feeCode ���ô���
     * @throws Exception
     */
    public void delete(String riskCode,String feeCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpDpersonFeeCodeRiskAction.delete(dbManager,riskCode, feeCode);
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
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpDpersonFeeCodeRiskAction.deleteByConditions(dbManager,conditions);
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
     * @param prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public void update(PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpDpersonFeeCodeRiskAction.update(dbManager,prpDpersonFeeCodeRiskDto);
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
     * @param feeCode ���ô���
     * @return prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public PrpDpersonFeeCodeRiskDto findByPrimaryKey(String riskCode,String feeCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        //����DTO
        PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpDpersonFeeCodeRiskDto = blPrpDpersonFeeCodeRiskAction.findByPrimaryKey(dbManager,riskCode, feeCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDpersonFeeCodeRiskDto;
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
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpDpersonFeeCodeRiskAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpDpersonFeeCodeRiskDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpDpersonFeeCodeRiskAction.findByConditions(dbManager,conditions);
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
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpDpersonFeeCodeRiskAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
