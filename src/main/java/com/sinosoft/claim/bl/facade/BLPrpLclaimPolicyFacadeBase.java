package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimPolicyAction;
import com.sinosoft.claim.dto.domain.PrpLclaimPolicyDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimPolicy-���������嵥���ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.593<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimPolicyFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimPolicyFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimPolicyFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLclaimPolicyDto prpLclaimPolicyDto
     * @throws Exception
     */
    public void insert(PrpLclaimPolicyDto prpLclaimPolicyDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimPolicyAction blPrpLclaimPolicyAction = new BLPrpLclaimPolicyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLclaimPolicyAction.insert(dbManager,prpLclaimPolicyDto);
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
     * @param claimNo �ⰸ��
     * @param policyNo ������
     * @throws Exception
     */
    public void delete(String claimNo,String policyNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimPolicyAction blPrpLclaimPolicyAction = new BLPrpLclaimPolicyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLclaimPolicyAction.delete(dbManager,claimNo, policyNo);
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
        BLPrpLclaimPolicyAction blPrpLclaimPolicyAction = new BLPrpLclaimPolicyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLclaimPolicyAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLclaimPolicyDto prpLclaimPolicyDto
     * @throws Exception
     */
    public void update(PrpLclaimPolicyDto prpLclaimPolicyDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimPolicyAction blPrpLclaimPolicyAction = new BLPrpLclaimPolicyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLclaimPolicyAction.update(dbManager,prpLclaimPolicyDto);
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
     * @param claimNo �ⰸ��
     * @param policyNo ������
     * @return prpLclaimPolicyDto prpLclaimPolicyDto
     * @throws Exception
     */
    public PrpLclaimPolicyDto findByPrimaryKey(String claimNo,String policyNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimPolicyAction blPrpLclaimPolicyAction = new BLPrpLclaimPolicyAction();
        //����DTO
        PrpLclaimPolicyDto prpLclaimPolicyDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLclaimPolicyDto = blPrpLclaimPolicyAction.findByPrimaryKey(dbManager,claimNo, policyNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLclaimPolicyDto;
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
        BLPrpLclaimPolicyAction blPrpLclaimPolicyAction = new BLPrpLclaimPolicyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLclaimPolicyAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLclaimPolicyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLclaimPolicyAction blPrpLclaimPolicyAction = new BLPrpLclaimPolicyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLclaimPolicyAction.findByConditions(dbManager,conditions);
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
        BLPrpLclaimPolicyAction blPrpLclaimPolicyAction = new BLPrpLclaimPolicyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLclaimPolicyAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
