package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.MessageReceiveLogDto;
import com.sinosoft.claim.bl.action.domain.BLMessageReceiveLogAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����MessageReceiveLog��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLMessageReceiveLogFacadeBase{
    private static Logger logger = Logger.getLogger(BLMessageReceiveLogFacadeBase.class);

    /**
     * ���캯��
     */
    public BLMessageReceiveLogFacadeBase(){
    }

    /**
     * ����һ������
     * @param messageReceiveLogDto messageReceiveLogDto
     * @throws Exception
     */
    public void insert(MessageReceiveLogDto messageReceiveLogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //�����¼
            blMessageReceiveLogAction.insert(dbManager,messageReceiveLogDto);
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
     * @param ruleCode RuleCode
     * @param month Month
     * @throws Exception
     */
    public void delete(String ruleCode,String month)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blMessageReceiveLogAction.delete(dbManager,ruleCode, month);
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
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blMessageReceiveLogAction.deleteByConditions(dbManager,conditions);
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
     * @param messageReceiveLogDto messageReceiveLogDto
     * @throws Exception
     */
    public void update(MessageReceiveLogDto messageReceiveLogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blMessageReceiveLogAction.update(dbManager,messageReceiveLogDto);
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
     * @param ruleCode RuleCode
     * @param month Month
     * @return messageReceiveLogDto messageReceiveLogDto
     * @throws Exception
     */
    public MessageReceiveLogDto findByPrimaryKey(String ruleCode,String month)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        //����DTO
        MessageReceiveLogDto messageReceiveLogDto = null;
        try{
            dbManager.open("claimDataSource");
            //��ѯ����,��ֵ��DTO
            messageReceiveLogDto = blMessageReceiveLogAction.findByPrimaryKey(dbManager,ruleCode, month);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return messageReceiveLogDto;
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
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blMessageReceiveLogAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����messageReceiveLogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        try{
            dbManager.open("claimDataSource");
            collection = blMessageReceiveLogAction.findByConditions(dbManager,conditions);
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
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blMessageReceiveLogAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
