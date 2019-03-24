package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorpolicylistoriginDto;
import com.gyic.claim.bl.action.domain.BLTemblorpolicylistoriginAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORPOLICYLISTORIGIN��ҵ���߼�����Facade����<br>
 */
public class BLTemblorpolicylistoriginFacadeBase{
    private static Logger logger = Logger.getLogger(BLTemblorpolicylistoriginFacadeBase.class);

    /**
     * ���캯��
     */
    public BLTemblorpolicylistoriginFacadeBase(){
    }

    /**
     * ����һ������
     * @param temblorpolicylistoriginDto temblorpolicylistoriginDto
     * @throws Exception
     */
    public void insert(TemblorpolicylistoriginDto temblorpolicylistoriginDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorpolicylistoriginAction blTemblorpolicylistoriginAction = new BLTemblorpolicylistoriginAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blTemblorpolicylistoriginAction.insert(dbManager,temblorpolicylistoriginDto);
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
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorpolicylistoriginAction blTemblorpolicylistoriginAction = new BLTemblorpolicylistoriginAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blTemblorpolicylistoriginAction.delete(dbManager,inusrelistcode, kindcode, itemcode, address, idcard);
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
        BLTemblorpolicylistoriginAction blTemblorpolicylistoriginAction = new BLTemblorpolicylistoriginAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blTemblorpolicylistoriginAction.deleteByConditions(dbManager,conditions);
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
     * @param temblorpolicylistoriginDto temblorpolicylistoriginDto
     * @throws Exception
     */
    public void update(TemblorpolicylistoriginDto temblorpolicylistoriginDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorpolicylistoriginAction blTemblorpolicylistoriginAction = new BLTemblorpolicylistoriginAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blTemblorpolicylistoriginAction.update(dbManager,temblorpolicylistoriginDto);
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
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return temblorpolicylistoriginDto temblorpolicylistoriginDto
     * @throws Exception
     */
    public TemblorpolicylistoriginDto findByPrimaryKey(String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorpolicylistoriginAction blTemblorpolicylistoriginAction = new BLTemblorpolicylistoriginAction();
        //����DTO
        TemblorpolicylistoriginDto temblorpolicylistoriginDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            temblorpolicylistoriginDto = blTemblorpolicylistoriginAction.findByPrimaryKey(dbManager,inusrelistcode, kindcode, itemcode, address, idcard);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return temblorpolicylistoriginDto;
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
        BLTemblorpolicylistoriginAction blTemblorpolicylistoriginAction = new BLTemblorpolicylistoriginAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blTemblorpolicylistoriginAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����temblorpolicylistoriginDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLTemblorpolicylistoriginAction blTemblorpolicylistoriginAction = new BLTemblorpolicylistoriginAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blTemblorpolicylistoriginAction.findByConditions(dbManager,conditions);
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
        BLTemblorpolicylistoriginAction blTemblorpolicylistoriginAction = new BLTemblorpolicylistoriginAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blTemblorpolicylistoriginAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
