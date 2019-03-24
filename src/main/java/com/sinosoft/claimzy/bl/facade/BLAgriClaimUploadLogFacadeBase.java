package com.sinosoft.claimzy.bl.facade;

import java.sql.ResultSet;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

import com.sinosoft.claimzy.bl.action.domain.BLAgriClaimUploadLogAction;
import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����AGRICLAIMUPLOADLOG��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLAgriClaimUploadLogFacadeBase{
    private static Logger logger = Logger.getLogger(BLAgriClaimUploadLogFacadeBase.class);

    /**
     * ���캯��
     */
    public BLAgriClaimUploadLogFacadeBase(){
    }
    
    
    /**
     * �������ڻ�ȡflag
     * @throws Exception 
     */
//    public int query() throws Exception{
//    	DBManager dbManager = new DBManager();
//    	int number=0;
//    	try{
//           dbManager.open(AppConfig.get("sysconst.DBJNDI"));
//           dbManager.beginTransaction();
//           String str = "Select MAX(flag) from agriclaimuploadlog";
//           dbManager.prepareStatement(str);
//           ResultSet resultSet = dbManager.executePreparedQuery();
//           number = dbManager.getInt(resultSet,1);
//           dbManager.commitTransaction();
//        }catch(Exception exception){
//           dbManager.rollbackTransaction();
//            throw exception;
//        }finally{
//           dbManager.close();
//        }
		
//		return number;
//    }
    
   
    /**
     * ����һ������
     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public void insert(AgriClaimUploadLogDto agriClaimUploadLogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blAgriClaimUploadLogAction.insert(dbManager,agriClaimUploadLogDto);
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
     * @param claimCode �������
     * @throws Exception
     */
    public void delete(String claimCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blAgriClaimUploadLogAction.delete(dbManager,claimCode);
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
        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blAgriClaimUploadLogAction.deleteByConditions(dbManager,conditions);
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
     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public void update(AgriClaimUploadLogDto agriClaimUploadLogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blAgriClaimUploadLogAction.update(dbManager,agriClaimUploadLogDto);
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
     * @param claimCode �������
     * @return agriClaimUploadLogDto agriClaimUploadLogDto
     * @throws Exception
     */
    public AgriClaimUploadLogDto findByPrimaryKey(String claimCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
        //����DTO
        AgriClaimUploadLogDto agriClaimUploadLogDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            agriClaimUploadLogDto = blAgriClaimUploadLogAction.findByPrimaryKey(dbManager,claimCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return agriClaimUploadLogDto;
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
        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blAgriClaimUploadLogAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����agriClaimUploadLogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blAgriClaimUploadLogAction.findByConditions(dbManager,conditions);
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
        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blAgriClaimUploadLogAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
