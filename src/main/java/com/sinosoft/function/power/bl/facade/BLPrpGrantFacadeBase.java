package com.sinosoft.function.power.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.bl.action.domain.BLPrpGrantAction;
import com.sinosoft.function.power.dto.domain.PrpGrantDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpGrant ��Ȩ��¼���ҵ���߼�����Facade����<br>
 * ������ 2004-11-09 10:40:55.460<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGrantFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpGrantFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpGrantFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpGrantDto prpGrantDto
     * @throws Exception
     */
    public void insert(PrpGrantDto prpGrantDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //�����¼
            blPrpGrantAction.insert(dbManager,prpGrantDto);
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
     * @param userCode Ա������
     * @param groupCode Ȩ�����
     * @param taskCode ��Ȩ����
     * @param checkCode ��Ȩ����
     * @param grantStartDate ��Ȩ��ʼʱ��
     * @param grantEndDate ��Ȩ��ֹʱ��
     * @throws Exception
     */
    public void delete(String userCode,String groupCode,String taskCode,String checkCode,DateTime grantStartDate,DateTime grantEndDate) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpGrantAction.delete(dbManager,userCode, groupCode, taskCode, checkCode, grantStartDate, grantEndDate);
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
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpGrantAction.deleteByConditions(dbManager,conditions);
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
     * @param prpGrantDto prpGrantDto
     * @throws Exception
     */
    public void update(PrpGrantDto prpGrantDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //���¼�¼
            blPrpGrantAction.update(dbManager,prpGrantDto);
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
     * @param userCode Ա������
     * @param groupCode Ȩ�����
     * @param taskCode ��Ȩ����
     * @param checkCode ��Ȩ����
     * @param grantStartDate ��Ȩ��ʼʱ��
     * @param grantEndDate ��Ȩ��ֹʱ��
     * @return prpGrantDto prpGrantDto
     * @throws Exception
     */
    public PrpGrantDto findByPrimaryKey(String userCode,String groupCode,String taskCode,String checkCode,DateTime grantStartDate,DateTime grantEndDate) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        //����DTO
        PrpGrantDto prpGrantDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            //��ѯ����,��ֵ��DTO
            prpGrantDto = blPrpGrantAction.findByPrimaryKey(dbManager,userCode, groupCode, taskCode, checkCode, grantStartDate, grantEndDate);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpGrantDto;
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
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            pageRecord = blPrpGrantAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpGrantDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            collection = blPrpGrantAction.findByConditions(dbManager,conditions);
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
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            rowCount = blPrpGrantAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
