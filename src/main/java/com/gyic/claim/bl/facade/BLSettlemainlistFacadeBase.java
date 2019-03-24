package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.gyic.claim.bl.action.domain.BLSettlemainlistAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����SETTLEMAINLIST��ҵ���߼�����Facade����<br>
 */
public class BLSettlemainlistFacadeBase{
    private static Logger logger = Logger.getLogger(BLSettlemainlistFacadeBase.class);

    /**
     * ���캯��
     */
    public BLSettlemainlistFacadeBase(){
    }

    /**
     * ����һ������
     * @param settlemainlistDto settlemainlistDto
     * @throws Exception
     */
    public void insert(SettlemainlistDto settlemainlistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blSettlemainlistAction.insert(dbManager,settlemainlistDto);
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
     * @param settlelistcode SETTLELISTCODE
     * @throws Exception
     */
    public void delete(String settlelistcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blSettlemainlistAction.delete(dbManager,settlelistcode);
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
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blSettlemainlistAction.deleteByConditions(dbManager,conditions);
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
     * @param settlemainlistDto settlemainlistDto
     * @throws Exception
     */
    public void update(SettlemainlistDto settlemainlistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blSettlemainlistAction.update(dbManager,settlemainlistDto);
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
     * @param settlelistcode SETTLELISTCODE
     * @return settlemainlistDto settlemainlistDto
     * @throws Exception
     */
    public SettlemainlistDto findByPrimaryKey(String settlelistcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        //����DTO
        SettlemainlistDto settlemainlistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            settlemainlistDto = blSettlemainlistAction.findByPrimaryKey(dbManager,settlelistcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return settlemainlistDto;
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
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blSettlemainlistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����settlemainlistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blSettlemainlistAction.findByConditions(dbManager,conditions);
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
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blSettlemainlistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
        	exception.printStackTrace();
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
