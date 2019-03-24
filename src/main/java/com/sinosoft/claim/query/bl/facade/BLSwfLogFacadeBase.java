package com.sinosoft.claim.query.bl.facade;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gyic.claim.bl.action.domain.BLSwfLogAction;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.query.util.Constant;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfLog-��������־����������ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.703<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfLogFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfLogFacadeBase.class);

    /**
     * ���캯��
     */
    public BLSwfLogFacadeBase(){
    }

    /**
     * ����һ������
     * @param swfLogDto swfLogDto
     * @throws Exception
     */
    public void insert(SwfLogDto swfLogDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blSwfLogAction.insert(dbManager,swfLogDto);
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
     * @param flowID ���̱��
     * @param logNo ���
     * @throws Exception
     */
    public void delete(String flowID,int logNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blSwfLogAction.delete(dbManager,flowID, logNo);
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
    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blSwfLogAction.deleteByConditions(dbManager,conditions);
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
     * @param swfLogDto swfLogDto
     * @throws Exception
     */
    public void update(SwfLogDto swfLogDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blSwfLogAction.update(dbManager,swfLogDto);
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
     * @param flowID ���̱��
     * @param logNo ���
     * @return swfLogDto swfLogDto
     * @throws Exception
     */
    public SwfLogDto findByPrimaryKey(String flowID,int logNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        //����DTO
        SwfLogDto swfLogDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            swfLogDto = blSwfLogAction.findByPrimaryKey(dbManager,flowID, logNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return swfLogDto;
    }
    /**
     * �������Ų���һ������
     * @param flowID ���̱��
     * @param logNo ���
     * @return swfLogDto swfLogDto
     * @throws Exception
     */
    public SwfLogDto findByRegistNo(String registNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        //����DTO
        SwfLogDto swfLogDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            swfLogDto = blSwfLogAction.findByRegistNo(dbManager,registNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return swfLogDto;
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

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(Constant.QUERY_DATA_SOURCE);
            pageRecord = blSwfLogAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByPolicyNo(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfLogAction.findByPolicyNo(dbManager,conditions,pageNo,rowsPerPage);
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
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findCompensateListByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfLogAction.findCompensateListByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * ���¹ʺŲ�ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByComBineNo(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfLogAction.findByComBineNo(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * �������Ų�ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByRegistNo(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfLogAction.findByRegistNo(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * �������Ų�ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findBypolicyNo(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfLogAction.findBypolicyNo(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * ��������ѯ��������(��ѯת�����δת����)
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findAllStatusByConditions(String swflogConditions,String swflogStoreCondition,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(swflogConditions.trim().length()==0){
        	swflogConditions = "1=1";
        }
        if(swflogStoreCondition.trim().length()==0){
        	swflogStoreCondition = "1=1";
        }
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(Constant.QUERY_DATA_SOURCE);
            pageRecord = blSwfLogAction.findAllStatusByConditions(dbManager,swflogConditions,swflogStoreCondition,pageNo,rowsPerPage);
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
     * @return Collection ����swfLogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(Constant.QUERY_DATA_SOURCE);
            collection = blSwfLogAction.findByConditions(dbManager,conditions);
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
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blSwfLogAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    /**
     * �鿱�˻ع������ڵ�У��
     * @param flowID ���̱��
     * @param logNo ���
     * @return swfLogDto swfLogDto
     * @throws Exception
     */
    public void checkFlowID(String flowID) throws Exception{
    	DBManager dbManager = new DBManager();
    	String conditions = "Flowid = '"+flowID+"' and Nodetype= 'compp' and Nodestatus = '4' and (submittime is not null or submittime <> '')";
		
//    	StringBuffer strBuffer = new StringBuffer();
//    	strBuffer.append("select 1                                                  ");                                                         
//    	strBuffer.append("  from swflog sw                                          ");                                                         
//    	strBuffer.append(" where sw.nodeType = 'compp'                              ");                                                         
//    	strBuffer.append("   and sw.NodeStatus in ('2', '3')                        ");                                                         
//    	strBuffer.append("   and (sw.flowStatus = '1' or sw.flowStatus = '2')       ");                                                         
//    	strBuffer.append("   and sw.businessno = '"+strCompensateNo+"'        "); 
//    	
    	
    	String conditions1 = " Flowid = '"+flowID+"' and  Nodetype= 'compp' and  Nodestatus  in  ('2','3') and   (flowStatus = '1' or flowStatus = '2')  ";
    	BLSwfLogFacade  facadeSwf = new BLSwfLogFacade();
		SwfLogDto swfLogDto = new SwfLogDto();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            Collection  tion = facadeSwf.findByConditions(conditions);
    		if(tion.size() > 0){
    	        throw new UserException(1,3,"0000","������"+flowID+"�Ѿ����������ύ״̬��������ɾ��"); 
    		}
    		tion = facadeSwf.findByConditions(conditions1);
    		if(tion.size() > 0){
    	        throw new UserException(1,3,"0000","������"+flowID+"�����鴦�ں����˻ػ�������״̬������Ҫ����������ɾ������"); 
    		}
    		
    		
    	}catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    /**
     * �������Ų�ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findComBineListByCondition (String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfLogAction.findBypolicyNo(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
}
