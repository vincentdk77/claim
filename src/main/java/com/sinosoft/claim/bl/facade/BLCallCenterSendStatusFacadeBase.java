package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.CallCenterSendStatusDto;
import com.sinosoft.claim.bl.action.domain.BLCallCenterSendStatusAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CallCenterSendStatus��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCallCenterSendStatusFacadeBase{
    private static Logger logger = Logger.getLogger(BLCallCenterSendStatusFacadeBase.class);

    /**
     * ���캯��
     */
    public BLCallCenterSendStatusFacadeBase(){
    }

    /**
     * ����һ������
     * @param callCenterSendStatusDto callCenterSendStatusDto
     * @throws Exception
     */
    public void insert(CallCenterSendStatusDto callCenterSendStatusDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //�����¼
            blCallCenterSendStatusAction.insert(dbManager,callCenterSendStatusDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            exception.printStackTrace();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ������ɾ��һ������
     * @param serial serial
     * @throws Exception
     */
    public void delete(double serial)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blCallCenterSendStatusAction.delete(dbManager,serial);
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
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blCallCenterSendStatusAction.deleteByConditions(dbManager,conditions);
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
     * @param callCenterSendStatusDto callCenterSendStatusDto
     * @throws Exception
     */
    public void update(CallCenterSendStatusDto callCenterSendStatusDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blCallCenterSendStatusAction.update(dbManager,callCenterSendStatusDto);
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
     * @param serial serial
     * @return callCenterSendStatusDto callCenterSendStatusDto
     * @throws Exception
     */
    public CallCenterSendStatusDto findByPrimaryKey(double serial)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        //����DTO
        CallCenterSendStatusDto callCenterSendStatusDto = null;
        try{
            dbManager.open("ddccDataSource");
            //��ѯ����,��ֵ��DTO
            callCenterSendStatusDto = blCallCenterSendStatusAction.findByPrimaryKey(dbManager,serial);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return callCenterSendStatusDto;
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
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        try{
            dbManager.open("ddccDataSource");
            pageRecord = blCallCenterSendStatusAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����callCenterSendStatusDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        try{
            dbManager.open("ddccDataSource");
            collection = blCallCenterSendStatusAction.findByConditions(dbManager,conditions);
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
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        try{
            dbManager.open("ddccDataSource");
            rowCount = blCallCenterSendStatusAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
