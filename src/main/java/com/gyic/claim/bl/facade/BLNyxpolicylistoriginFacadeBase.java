package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxpolicylistoriginDto;
import com.gyic.claim.bl.action.domain.BLNyxpolicylistoriginAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXPOLICYLISTORIGIN��ҵ���߼�����Facade����<br>
 */
public class BLNyxpolicylistoriginFacadeBase{
    private static Logger logger = Logger.getLogger(BLNyxpolicylistoriginFacadeBase.class);

    /**
     * ���캯��
     */
    public BLNyxpolicylistoriginFacadeBase(){
    }

    /**
     * ����һ������
     * @param nyxpolicylistoriginDto nyxpolicylistoriginDto
     * @throws Exception
     */
    public void insert(NyxpolicylistoriginDto nyxpolicylistoriginDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxpolicylistoriginAction blNyxpolicylistoriginAction = new BLNyxpolicylistoriginAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blNyxpolicylistoriginAction.insert(dbManager,nyxpolicylistoriginDto);
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
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @throws Exception
     */
    public void delete(String inusrelistcode,String businessno,String kindcode,String itemcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxpolicylistoriginAction blNyxpolicylistoriginAction = new BLNyxpolicylistoriginAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blNyxpolicylistoriginAction.delete(dbManager,inusrelistcode, businessno, kindcode, itemcode);
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
        BLNyxpolicylistoriginAction blNyxpolicylistoriginAction = new BLNyxpolicylistoriginAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blNyxpolicylistoriginAction.deleteByConditions(dbManager,conditions);
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
     * @param nyxpolicylistoriginDto nyxpolicylistoriginDto
     * @throws Exception
     */
    public void update(NyxpolicylistoriginDto nyxpolicylistoriginDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxpolicylistoriginAction blNyxpolicylistoriginAction = new BLNyxpolicylistoriginAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blNyxpolicylistoriginAction.update(dbManager,nyxpolicylistoriginDto);
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
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return nyxpolicylistoriginDto nyxpolicylistoriginDto
     * @throws Exception
     */
    public NyxpolicylistoriginDto findByPrimaryKey(String inusrelistcode,String businessno,String kindcode,String itemcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxpolicylistoriginAction blNyxpolicylistoriginAction = new BLNyxpolicylistoriginAction();
        //����DTO
        NyxpolicylistoriginDto nyxpolicylistoriginDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            nyxpolicylistoriginDto = blNyxpolicylistoriginAction.findByPrimaryKey(dbManager,inusrelistcode, businessno, kindcode, itemcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return nyxpolicylistoriginDto;
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
        BLNyxpolicylistoriginAction blNyxpolicylistoriginAction = new BLNyxpolicylistoriginAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blNyxpolicylistoriginAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����nyxpolicylistoriginDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLNyxpolicylistoriginAction blNyxpolicylistoriginAction = new BLNyxpolicylistoriginAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blNyxpolicylistoriginAction.findByConditions(dbManager,conditions);
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
        BLNyxpolicylistoriginAction blNyxpolicylistoriginAction = new BLNyxpolicylistoriginAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blNyxpolicylistoriginAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
