package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorpolicylistDto;
import com.gyic.claim.bl.action.domain.BLTemblorpolicylistAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORPOLICYLIST��ҵ���߼�����Facade����<br>
 */
public class BLTemblorpolicylistFacadeBase{
    private static Logger logger = Logger.getLogger(BLTemblorpolicylistFacadeBase.class);

    /**
     * ���캯��
     */
    public BLTemblorpolicylistFacadeBase(){
    }

    /**
     * ����һ������
     * @param temblorpolicylistDto temblorpolicylistDto
     * @throws Exception
     */
    public void insert(TemblorpolicylistDto temblorpolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorpolicylistAction blTemblorpolicylistAction = new BLTemblorpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blTemblorpolicylistAction.insert(dbManager,temblorpolicylistDto);
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
        BLTemblorpolicylistAction blTemblorpolicylistAction = new BLTemblorpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blTemblorpolicylistAction.delete(dbManager,inusrelistcode, kindcode, itemcode, address, idcard);
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
        BLTemblorpolicylistAction blTemblorpolicylistAction = new BLTemblorpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blTemblorpolicylistAction.deleteByConditions(dbManager,conditions);
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
     * @param temblorpolicylistDto temblorpolicylistDto
     * @throws Exception
     */
    public void update(TemblorpolicylistDto temblorpolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorpolicylistAction blTemblorpolicylistAction = new BLTemblorpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blTemblorpolicylistAction.update(dbManager,temblorpolicylistDto);
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
     * @return temblorpolicylistDto temblorpolicylistDto
     * @throws Exception
     */
    public TemblorpolicylistDto findByPrimaryKey(String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorpolicylistAction blTemblorpolicylistAction = new BLTemblorpolicylistAction();
        //����DTO
        TemblorpolicylistDto temblorpolicylistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            temblorpolicylistDto = blTemblorpolicylistAction.findByPrimaryKey(dbManager,inusrelistcode, kindcode, itemcode, address, idcard);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return temblorpolicylistDto;
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
        BLTemblorpolicylistAction blTemblorpolicylistAction = new BLTemblorpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blTemblorpolicylistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����temblorpolicylistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLTemblorpolicylistAction blTemblorpolicylistAction = new BLTemblorpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blTemblorpolicylistAction.findByConditions(dbManager,conditions);
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
        BLTemblorpolicylistAction blTemblorpolicylistAction = new BLTemblorpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blTemblorpolicylistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
