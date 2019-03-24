package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLEdaUserAction;
import com.sinosoft.claim.dto.domain.EdaUserDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdaUser-��ϯԱ��Ϣ���ҵ���߼�����Facade����<br>
 * ������ 2005-06-22 14:57:12.464<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaUserFacadeBase{
    private static Log logger = LogFactory.getLog(BLEdaUserFacadeBase.class);

    /**
     * ���캯��
     */
    public BLEdaUserFacadeBase(){
    }

    /**
     * ����һ������
     * @param edaUserDto edaUserDto
     * @throws Exception
     */
    public void insert(EdaUserDto edaUserDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        try{
            
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blEdaUserAction.insert(dbManager,edaUserDto);
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
     * @param edaUserCode ��ϯԱ����
     * @throws Exception
     */
    public void delete(String edaUserCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blEdaUserAction.delete(dbManager,edaUserCode);
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
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blEdaUserAction.deleteByConditions(dbManager,conditions);
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
     * @param edaUserDto edaUserDto
     * @throws Exception
     */
    public void update(EdaUserDto edaUserDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blEdaUserAction.update(dbManager,edaUserDto);
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
     * @param edaUserCode ��ϯԱ����
     * @return edaUserDto edaUserDto
     * @throws Exception
     */
    public EdaUserDto findByPrimaryKey(String edaUserCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        //����DTO
        EdaUserDto edaUserDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
           
            edaUserDto = blEdaUserAction.findByPrimaryKey(dbManager,edaUserCode);
           
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return edaUserDto;
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
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blEdaUserAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����edaUserDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blEdaUserAction.findByConditions(dbManager,conditions);
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
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        try{
             dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blEdaUserAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
