package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxpolicylistDto;
import com.gyic.claim.bl.action.domain.BLNyxpolicylistAction;
import com.gyic.claim.bl.action.domain.BLPlanting31PolicyListAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXPOLICYLIST��ҵ���߼�����Facade����<br>
 */
public class BLNyxpolicylistFacadeBase{
    private static Logger logger = Logger.getLogger(BLNyxpolicylistFacadeBase.class);

    /**
     * ���캯��
     */
    public BLNyxpolicylistFacadeBase(){
    }

    /**
     * ����һ������
     * @param nyxpolicylistDto nyxpolicylistDto
     * @throws Exception
     */
    public void insert(NyxpolicylistDto nyxpolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blNyxpolicylistAction.insert(dbManager,nyxpolicylistDto);
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
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blNyxpolicylistAction.delete(dbManager,inusrelistcode, businessno, kindcode, itemcode);
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
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blNyxpolicylistAction.deleteByConditions(dbManager,conditions);
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
     * @param nyxpolicylistDto nyxpolicylistDto
     * @throws Exception
     */
    public void update(NyxpolicylistDto nyxpolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blNyxpolicylistAction.update(dbManager,nyxpolicylistDto);
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
     * @return nyxpolicylistDto nyxpolicylistDto
     * @throws Exception
     */
    public NyxpolicylistDto findByPrimaryKey(String inusrelistcode,String businessno,String kindcode,String itemcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        //����DTO
        NyxpolicylistDto nyxpolicylistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            nyxpolicylistDto = blNyxpolicylistAction.findByPrimaryKey(dbManager,inusrelistcode, businessno, kindcode, itemcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return nyxpolicylistDto;
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
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blNyxpolicylistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����nyxpolicylistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blNyxpolicylistAction.findByConditions(dbManager,conditions);
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
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blNyxpolicylistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @param fieldName �ֶ���
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public double getSum(String conditions, String fieldName)
        throws Exception{
        double sum=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blNyxpolicylistAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
}
