package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.SaBankBranchDto;
import com.sinosoft.claim.bl.action.domain.BLSaBankBranchAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����SaBankBranch��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSaBankBranchFacadeBase{
    private static Logger logger = Logger.getLogger(BLSaBankBranchFacadeBase.class);

    /**
     * ���캯��
     */
    public BLSaBankBranchFacadeBase(){
    }

    /**
     * ����һ������
     * @param saBankBranchDto saBankBranchDto
     * @throws Exception
     */
    public void insert(SaBankBranchDto saBankBranchDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blSaBankBranchAction.insert(dbManager,saBankBranchDto);
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
     * @param bankCode bankCode
     * @throws Exception
     */
    public void delete(String bankCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blSaBankBranchAction.delete(dbManager,bankCode);
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
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blSaBankBranchAction.deleteByConditions(dbManager,conditions);
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
     * @param saBankBranchDto saBankBranchDto
     * @throws Exception
     */
    public void update(SaBankBranchDto saBankBranchDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blSaBankBranchAction.update(dbManager,saBankBranchDto);
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
     * @param bankCode bankCode
     * @return saBankBranchDto saBankBranchDto
     * @throws Exception
     */
    public SaBankBranchDto findByPrimaryKey(String bankCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        //����DTO
        SaBankBranchDto saBankBranchDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            saBankBranchDto = blSaBankBranchAction.findByPrimaryKey(dbManager,bankCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return saBankBranchDto;
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
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSaBankBranchAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����saBankBranchDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blSaBankBranchAction.findByConditions(dbManager,conditions);
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
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blSaBankBranchAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
