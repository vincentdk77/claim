package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpdBankBranchDto;
import com.sinosoft.claim.bl.action.domain.BLPrpdBankBranchAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpdBankBranch��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpdBankBranchFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpdBankBranchFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpdBankBranchFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpdBankBranchDto prpdBankBranchDto
     * @throws Exception
     */
    public void insert(PrpdBankBranchDto prpdBankBranchDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpdBankBranchAction blPrpdBankBranchAction = new BLPrpdBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpdBankBranchAction.insert(dbManager,prpdBankBranchDto);
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
     * @param bank_number bank_number
     * @throws Exception
     */
    public void delete(String bank_number)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpdBankBranchAction blPrpdBankBranchAction = new BLPrpdBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpdBankBranchAction.delete(dbManager,bank_number);
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
        BLPrpdBankBranchAction blPrpdBankBranchAction = new BLPrpdBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpdBankBranchAction.deleteByConditions(dbManager,conditions);
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
     * @param prpdBankBranchDto prpdBankBranchDto
     * @throws Exception
     */
    public void update(PrpdBankBranchDto prpdBankBranchDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpdBankBranchAction blPrpdBankBranchAction = new BLPrpdBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpdBankBranchAction.update(dbManager,prpdBankBranchDto);
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
     * @param bank_number bank_number
     * @return prpdBankBranchDto prpdBankBranchDto
     * @throws Exception
     */
    public PrpdBankBranchDto findByPrimaryKey(String bank_number)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpdBankBranchAction blPrpdBankBranchAction = new BLPrpdBankBranchAction();
        //����DTO
        PrpdBankBranchDto prpdBankBranchDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpdBankBranchDto = blPrpdBankBranchAction.findByPrimaryKey(dbManager,bank_number);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpdBankBranchDto;
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
        BLPrpdBankBranchAction blPrpdBankBranchAction = new BLPrpdBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpdBankBranchAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpdBankBranchDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpdBankBranchAction blPrpdBankBranchAction = new BLPrpdBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpdBankBranchAction.findByConditions(dbManager,conditions);
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
        BLPrpdBankBranchAction blPrpdBankBranchAction = new BLPrpdBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpdBankBranchAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
