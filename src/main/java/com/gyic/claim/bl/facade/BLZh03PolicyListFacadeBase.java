package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03PolicyListDto;
import com.gyic.claim.bl.action.domain.BLZh03PolicyListAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����ZH03PolicyList��ҵ���߼�����Facade����<br>
 */
public class BLZh03PolicyListFacadeBase{
    private static Logger logger = Logger.getLogger(BLZh03PolicyListFacadeBase.class);

    /**
     * ���캯��
     */
    public BLZh03PolicyListFacadeBase(){
    }

    /**
     * ����һ������
     * @param zh03PolicyListDto zh03PolicyListDto
     * @throws Exception
     */
    public void insert(Zh03PolicyListDto zh03PolicyListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blZh03PolicyListAction.insert(dbManager,zh03PolicyListDto);
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
     * @param inusreListCode InusreListCode
     * @throws Exception
     */
    public void delete(String inusreListCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blZh03PolicyListAction.delete(dbManager,inusreListCode);
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
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blZh03PolicyListAction.deleteByConditions(dbManager,conditions);
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
     * @param zh03PolicyListDto zh03PolicyListDto
     * @throws Exception
     */
    public void update(Zh03PolicyListDto zh03PolicyListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blZh03PolicyListAction.update(dbManager,zh03PolicyListDto);
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
     * @param inusreListCode InusreListCode
     * @return zh03PolicyListDto zh03PolicyListDto
     * @throws Exception
     */
    public Zh03PolicyListDto findByPrimaryKey(String inusreListCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        //����DTO
        Zh03PolicyListDto zh03PolicyListDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            zh03PolicyListDto = blZh03PolicyListAction.findByPrimaryKey(dbManager,inusreListCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return zh03PolicyListDto;
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
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blZh03PolicyListAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����zh03PolicyListDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blZh03PolicyListAction.findByConditions(dbManager,conditions);
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
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blZh03PolicyListAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findFamilyNoByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLZh03PolicyListAction blZh03PolicylistAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blZh03PolicylistAction.findFamilyNoByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
}
