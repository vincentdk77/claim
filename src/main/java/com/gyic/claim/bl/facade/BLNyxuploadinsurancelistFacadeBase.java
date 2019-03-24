package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxuploadinsurancelistDto;
import com.gyic.claim.bl.action.domain.BLNyxuploadinsurancelistAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXUPLOADINSURANCELIST��ҵ���߼�����Facade����<br>
 */
public class BLNyxuploadinsurancelistFacadeBase{
    private static Logger logger = Logger.getLogger(BLNyxuploadinsurancelistFacadeBase.class);

    /**
     * ���캯��
     */
    public BLNyxuploadinsurancelistFacadeBase(){
    }

    /**
     * ����һ������
     * @param nyxuploadinsurancelistDto nyxuploadinsurancelistDto
     * @throws Exception
     */
    public void insert(NyxuploadinsurancelistDto nyxuploadinsurancelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxuploadinsurancelistAction blNyxuploadinsurancelistAction = new BLNyxuploadinsurancelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blNyxuploadinsurancelistAction.insert(dbManager,nyxuploadinsurancelistDto);
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
     * @param mulchtype MULCHTYPE
     * @throws Exception
     */
    public void delete(String inusrelistcode,String businessno,String mulchtype)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxuploadinsurancelistAction blNyxuploadinsurancelistAction = new BLNyxuploadinsurancelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blNyxuploadinsurancelistAction.delete(dbManager,inusrelistcode, businessno, mulchtype);
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
        BLNyxuploadinsurancelistAction blNyxuploadinsurancelistAction = new BLNyxuploadinsurancelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blNyxuploadinsurancelistAction.deleteByConditions(dbManager,conditions);
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
     * @param nyxuploadinsurancelistDto nyxuploadinsurancelistDto
     * @throws Exception
     */
    public void update(NyxuploadinsurancelistDto nyxuploadinsurancelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxuploadinsurancelistAction blNyxuploadinsurancelistAction = new BLNyxuploadinsurancelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blNyxuploadinsurancelistAction.update(dbManager,nyxuploadinsurancelistDto);
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
     * @param mulchtype MULCHTYPE
     * @return nyxuploadinsurancelistDto nyxuploadinsurancelistDto
     * @throws Exception
     */
    public NyxuploadinsurancelistDto findByPrimaryKey(String inusrelistcode,String businessno,String mulchtype)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxuploadinsurancelistAction blNyxuploadinsurancelistAction = new BLNyxuploadinsurancelistAction();
        //����DTO
        NyxuploadinsurancelistDto nyxuploadinsurancelistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            nyxuploadinsurancelistDto = blNyxuploadinsurancelistAction.findByPrimaryKey(dbManager,inusrelistcode, businessno, mulchtype);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return nyxuploadinsurancelistDto;
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
        BLNyxuploadinsurancelistAction blNyxuploadinsurancelistAction = new BLNyxuploadinsurancelistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blNyxuploadinsurancelistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����nyxuploadinsurancelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLNyxuploadinsurancelistAction blNyxuploadinsurancelistAction = new BLNyxuploadinsurancelistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blNyxuploadinsurancelistAction.findByConditions(dbManager,conditions);
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
        BLNyxuploadinsurancelistAction blNyxuploadinsurancelistAction = new BLNyxuploadinsurancelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blNyxuploadinsurancelistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
