package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLCiClaimCompelcrashAction;
import com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CIClaimCompelcrash ���⳵���������ݱ��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimCompelcrashFacadeBase{
    private static Log logger = LogFactory.getLog(BLCiClaimCompelcrashFacadeBase.class);

    /**
     * ���캯��
     */
    public BLCiClaimCompelcrashFacadeBase(){
    }

    /**
     * ����һ������
     * @param ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @throws Exception
     */
    public void insert(CiClaimCompelcrashDto ciClaimCompelcrashDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //�����¼
            blCiClaimCompelcrashAction.insert(dbManager,ciClaimCompelcrashDto);
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
     * @param registNo ������
     * @param policyNo ������
     * @throws Exception
     */
    public void delete(String registNo,String policyNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blCiClaimCompelcrashAction.delete(dbManager,registNo, policyNo);
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
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blCiClaimCompelcrashAction.deleteByConditions(dbManager,conditions);
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
     * @param ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @throws Exception
     */
    public void update(CiClaimCompelcrashDto ciClaimCompelcrashDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blCiClaimCompelcrashAction.update(dbManager,ciClaimCompelcrashDto);
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
     * @param registNo ������
     * @param policyNo ������
     * @return ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @throws Exception
     */
    public CiClaimCompelcrashDto findByPrimaryKey(String registNo,String policyNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        //����DTO
        CiClaimCompelcrashDto ciClaimCompelcrashDto = null;
        try{
            dbManager.open("claimDataSource");
            //��ѯ����,��ֵ��DTO
            ciClaimCompelcrashDto = blCiClaimCompelcrashAction.findByPrimaryKey(dbManager,registNo, policyNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return ciClaimCompelcrashDto;
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
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blCiClaimCompelcrashAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����ciClaimCompelcrashDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        try{
            dbManager.open("claimDataSource");
            collection = blCiClaimCompelcrashAction.findByConditions(dbManager,conditions);
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
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blCiClaimCompelcrashAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
