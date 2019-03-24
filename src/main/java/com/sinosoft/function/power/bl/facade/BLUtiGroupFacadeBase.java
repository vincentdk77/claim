package com.sinosoft.function.power.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.bl.action.domain.BLUtiGroupAction;
import com.sinosoft.function.power.dto.domain.UtiGroupDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����UtiGroup  Ȩ����ű��ҵ���߼�����Facade����<br>
 * ������ 2004-11-09 10:40:55.450<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiGroupFacadeBase{
    private static Log logger = LogFactory.getLog(BLUtiGroupFacadeBase.class);

    /**
     * ���캯��
     */
    public BLUtiGroupFacadeBase(){
    }

    /**
     * ����һ������
     * @param utiGroupDto utiGroupDto
     * @throws Exception
     */
    public void insert(UtiGroupDto utiGroupDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //�����¼
            blUtiGroupAction.insert(dbManager,utiGroupDto);
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
     * @param groupCode Ȩ����Ŵ���
     * @throws Exception
     */
    public void delete(String groupCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //ɾ����¼
            blUtiGroupAction.delete(dbManager,groupCode);
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
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //������ɾ����¼
            blUtiGroupAction.deleteByConditions(dbManager,conditions);
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
     * @param utiGroupDto utiGroupDto
     * @throws Exception
     */
    public void update(UtiGroupDto utiGroupDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //���¼�¼
            blUtiGroupAction.update(dbManager,utiGroupDto);
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
     * @param groupCode Ȩ����Ŵ���
     * @return utiGroupDto utiGroupDto
     * @throws Exception
     */
    public UtiGroupDto findByPrimaryKey(String groupCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        //����DTO
        UtiGroupDto utiGroupDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            //��ѯ����,��ֵ��DTO
            utiGroupDto = blUtiGroupAction.findByPrimaryKey(dbManager,groupCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return utiGroupDto;
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
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            pageRecord = blUtiGroupAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����utiGroupDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            collection = blUtiGroupAction.findByConditions(dbManager,conditions);
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
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            rowCount = blUtiGroupAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
