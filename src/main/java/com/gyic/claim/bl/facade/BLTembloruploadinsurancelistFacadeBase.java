package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TembloruploadinsurancelistDto;
import com.gyic.claim.bl.action.domain.BLTembloruploadinsurancelistAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORUPLOADINSURANCELIST��ҵ���߼�����Facade����<br>
 */
public class BLTembloruploadinsurancelistFacadeBase{
    private static Logger logger = Logger.getLogger(BLTembloruploadinsurancelistFacadeBase.class);

    /**
     * ���캯��
     */
    public BLTembloruploadinsurancelistFacadeBase(){
    }

    /**
     * ����һ������
     * @param tembloruploadinsurancelistDto tembloruploadinsurancelistDto
     * @throws Exception
     */
    public void insert(TembloruploadinsurancelistDto tembloruploadinsurancelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTembloruploadinsurancelistAction blTembloruploadinsurancelistAction = new BLTembloruploadinsurancelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blTembloruploadinsurancelistAction.insert(dbManager,tembloruploadinsurancelistDto);
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
     * @param address ADDRESS
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(String inusrelistcode,String address,String idcard)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTembloruploadinsurancelistAction blTembloruploadinsurancelistAction = new BLTembloruploadinsurancelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blTembloruploadinsurancelistAction.delete(dbManager,inusrelistcode, address, idcard);
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
        BLTembloruploadinsurancelistAction blTembloruploadinsurancelistAction = new BLTembloruploadinsurancelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blTembloruploadinsurancelistAction.deleteByConditions(dbManager,conditions);
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
     * @param tembloruploadinsurancelistDto tembloruploadinsurancelistDto
     * @throws Exception
     */
    public void update(TembloruploadinsurancelistDto tembloruploadinsurancelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTembloruploadinsurancelistAction blTembloruploadinsurancelistAction = new BLTembloruploadinsurancelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blTembloruploadinsurancelistAction.update(dbManager,tembloruploadinsurancelistDto);
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
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return tembloruploadinsurancelistDto tembloruploadinsurancelistDto
     * @throws Exception
     */
    public TembloruploadinsurancelistDto findByPrimaryKey(String inusrelistcode,String address,String idcard)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTembloruploadinsurancelistAction blTembloruploadinsurancelistAction = new BLTembloruploadinsurancelistAction();
        //����DTO
        TembloruploadinsurancelistDto tembloruploadinsurancelistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            tembloruploadinsurancelistDto = blTembloruploadinsurancelistAction.findByPrimaryKey(dbManager,inusrelistcode, address, idcard);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return tembloruploadinsurancelistDto;
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
        BLTembloruploadinsurancelistAction blTembloruploadinsurancelistAction = new BLTembloruploadinsurancelistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blTembloruploadinsurancelistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����tembloruploadinsurancelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLTembloruploadinsurancelistAction blTembloruploadinsurancelistAction = new BLTembloruploadinsurancelistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blTembloruploadinsurancelistAction.findByConditions(dbManager,conditions);
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
        BLTembloruploadinsurancelistAction blTembloruploadinsurancelistAction = new BLTembloruploadinsurancelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blTembloruploadinsurancelistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
