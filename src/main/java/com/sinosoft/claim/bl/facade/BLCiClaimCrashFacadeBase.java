package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLCiClaimCrashAction;
import com.sinosoft.claim.dto.domain.CiClaimCrashDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CIClaimCrash ���������¼��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimCrashFacadeBase{
    private static Log logger = LogFactory.getLog(BLCiClaimCrashFacadeBase.class);

    /**
     * ���캯��
     */
    public BLCiClaimCrashFacadeBase(){
    }

    /**
     * ����һ������
     * @param ciClaimCrashDto ciClaimCrashDto
     * @throws Exception
     */
    public void insert(CiClaimCrashDto ciClaimCrashDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //�����¼
            blCiClaimCrashAction.insert(dbManager,ciClaimCrashDto);
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
     * @param policyNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blCiClaimCrashAction.delete(dbManager,policyNo, serialNo);
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
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blCiClaimCrashAction.deleteByConditions(dbManager,conditions);
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
     * @param ciClaimCrashDto ciClaimCrashDto
     * @throws Exception
     */
    public void update(CiClaimCrashDto ciClaimCrashDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blCiClaimCrashAction.update(dbManager,ciClaimCrashDto);
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
     * @param policyNo ������
     * @param serialNo ���
     * @return ciClaimCrashDto ciClaimCrashDto
     * @throws Exception
     */
    public CiClaimCrashDto findByPrimaryKey(String policyNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        //����DTO
        CiClaimCrashDto ciClaimCrashDto = null;
        try{
            dbManager.open("claimDataSource");
            //��ѯ����,��ֵ��DTO
            ciClaimCrashDto = blCiClaimCrashAction.findByPrimaryKey(dbManager,policyNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return ciClaimCrashDto;
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
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blCiClaimCrashAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����ciClaimCrashDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        try{
            dbManager.open("claimDataSource");
            collection = blCiClaimCrashAction.findByConditions(dbManager,conditions);
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
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blCiClaimCrashAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
