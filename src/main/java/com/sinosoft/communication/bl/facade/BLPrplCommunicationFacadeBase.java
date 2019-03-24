package com.sinosoft.communication.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.communication.bl.action.BLPrplCommunicatOpinionAction;
import com.sinosoft.communication.bl.action.BLPrplCommunicatPersonAction;
import com.sinosoft.communication.bl.action.BLPrplCommunicationAction;
import com.sinosoft.communication.dto.custom.PrplCommunicatPersonDto;
import com.sinosoft.communication.dto.custom.PrplCommunicationDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * ����PrplCommunication��ͨ�����ҵ�����Facade��<br>
 * ������ 2013-02-20
 * 
 */
public class BLPrplCommunicationFacadeBase {
	private static Log logger = LogFactory.getLog(BLPrplCommunicationFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrplCommunicationFacadeBase(){
    }
    
    /**
     * ����һ������
     * @param prplCommunicationDto prplCommunicationDto
     * @throws Exception
     */
    public void insert(PrplCommunicationDto prplCommunicationDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrplCommunicationAction.insert(dbManager,prplCommunicationDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ����ͨ����ɾ��һ������
     * @param comunicationNo ��ͨ����
     * @throws Exception
     */
    public void delete(String comunicationNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplCommunicationAction.delete(dbManager,comunicationNo);
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
     * @param prplCommunicationDto prplCommunicationDto
     * @throws Exception
     */
    public void update(PrplCommunicationDto prplCommunicationDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplCommunicationAction.update(dbManager,prplCommunicationDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        conditions = " 1=1 " + conditions;
        DBManager dbManager = new DBManager();
        BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplCommunicationAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    /**
     * ��������ѯһ����ͨ����
     * @param conditions ��ѯ��ͨ����
     * @return PrplCommunicationDto ��ͨ��Ϣ
     * @throws Exception
     */
	public PrplCommunicationDto findByComminicationNo(String communicationNo) throws Exception{
		DBManager dbManager = new DBManager();
		PrplCommunicationDto prplCommunicationDto = null;
		BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            prplCommunicationDto = blPrplCommunicationAction.findByCommunicationNo(dbManager,communicationNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplCommunicationDto;
	}
	
	/**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        //conditions = " 1=1 " + conditions;
        if(conditions.trim().length()==0){
        	conditions = "1=1";
        }
        Collection collection = new ArrayList();
        DBManager dbManager = new DBManager();
        BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplCommunicationAction.findByConditions(dbManager,conditions);
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
        BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplCommunicationAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
