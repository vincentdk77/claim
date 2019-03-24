package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HousepolicylistDto;
import com.gyic.claim.bl.action.domain.BLHousepolicylistAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����HOUSEPOLICYLIST��ҵ���߼�����Facade����<br>
 */
public class BLHousepolicylistFacadeBase{
    private static Logger logger = Logger.getLogger(BLHousepolicylistFacadeBase.class);

    /**
     * ���캯��
     */
    public BLHousepolicylistFacadeBase(){
    }

    /**
     * ����һ������
     * @param housepolicylistDto housepolicylistDto
     * @throws Exception
     */
    public void insert(HousepolicylistDto housepolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHousepolicylistAction blHousepolicylistAction = new BLHousepolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blHousepolicylistAction.insert(dbManager,housepolicylistDto);
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
     * @param inusrelistcode INUSRELISTCODE
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(String inusrelistcode,String idcard)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHousepolicylistAction blHousepolicylistAction = new BLHousepolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blHousepolicylistAction.delete(dbManager,inusrelistcode, idcard);
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
        BLHousepolicylistAction blHousepolicylistAction = new BLHousepolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blHousepolicylistAction.deleteByConditions(dbManager,conditions);
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
     * @param housepolicylistDto housepolicylistDto
     * @throws Exception
     */
    public void update(HousepolicylistDto housepolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHousepolicylistAction blHousepolicylistAction = new BLHousepolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blHousepolicylistAction.update(dbManager,housepolicylistDto);
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
     * @param inusrelistcode INUSRELISTCODE
     * @param idcard IDCARD
     * @return housepolicylistDto housepolicylistDto
     * @throws Exception
     */
    public HousepolicylistDto findByPrimaryKey(String inusrelistcode,String idcard)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHousepolicylistAction blHousepolicylistAction = new BLHousepolicylistAction();
        //����DTO
        HousepolicylistDto housepolicylistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            housepolicylistDto = blHousepolicylistAction.findByPrimaryKey(dbManager,inusrelistcode, idcard);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return housepolicylistDto;
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
        BLHousepolicylistAction blHousepolicylistAction = new BLHousepolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blHousepolicylistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����housepolicylistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLHousepolicylistAction blHousepolicylistAction = new BLHousepolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blHousepolicylistAction.findByConditions(dbManager,conditions);
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
        BLHousepolicylistAction blHousepolicylistAction = new BLHousepolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blHousepolicylistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
