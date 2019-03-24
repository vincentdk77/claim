package com.sinosoft.claimprop.common.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropDemandDto;
import com.sinosoft.claimprop.common.bl.action.domain.BLCiClaimPropDemandAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CiClaimPropDemand��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimPropDemandFacadeBase{
    private static Logger logger = Logger.getLogger(BLCiClaimPropDemandFacadeBase.class);

    /**
     * ���캯��
     */
    public BLCiClaimPropDemandFacadeBase(){
    }

    /**
     * ����һ������
     * @param ciClaimPropDemandDto ciClaimPropDemandDto
     * @throws Exception
     */
    public void insert(CiClaimPropDemandDto ciClaimPropDemandDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //�����¼
            blCiClaimPropDemandAction.insert(dbManager,ciClaimPropDemandDto);
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
     * @param claimCode claimCode
     * @throws Exception
     */
    public void delete(String claimCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blCiClaimPropDemandAction.delete(dbManager,claimCode);
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
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blCiClaimPropDemandAction.deleteByConditions(dbManager,conditions);
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
     * @param ciClaimPropDemandDto ciClaimPropDemandDto
     * @throws Exception
     */
    public void update(CiClaimPropDemandDto ciClaimPropDemandDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blCiClaimPropDemandAction.update(dbManager,ciClaimPropDemandDto);
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
     * @param claimCode claimCode
     * @return ciClaimPropDemandDto ciClaimPropDemandDto
     * @throws Exception
     */
    public CiClaimPropDemandDto findByPrimaryKey(String claimCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        //����DTO
        CiClaimPropDemandDto ciClaimPropDemandDto = null;
        try{
            dbManager.open("daaplatformDataSource");
            //��ѯ����,��ֵ��DTO
            ciClaimPropDemandDto = blCiClaimPropDemandAction.findByPrimaryKey(dbManager,claimCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return ciClaimPropDemandDto;
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
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        try{
            dbManager.open("daaplatformDataSource");
            pageRecord = blCiClaimPropDemandAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����ciClaimPropDemandDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        try{
            dbManager.open("ddccDataSource");
            collection = blCiClaimPropDemandAction.findByConditions(dbManager,conditions);
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
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        try{
            dbManager.open("daaplatformDataSource");
            rowCount = blCiClaimPropDemandAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
