package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDeleteRequestDto;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayDeleteRequestAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLINTERPAYDELETEQUEST��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPayDeleteRequestFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayDeleteRequestFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPayDeleteRequestFacadeBase(){
    }

    /**
     * ����һ������
     * @param pRPLINTERPAYDELETEQUESTDto pRPLINTERPAYDELETEQUESTDto
     * @throws Exception
     */
    public void insert(PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayDeleteRequestAction blPRPLINTERPAYDELETEQUESTAction = new BLPrpLinterPayDeleteRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPRPLINTERPAYDELETEQUESTAction.insert(dbManager,pRPLINTERPAYDELETEQUESTDto);
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
     * @param outId �ͻ�������
     * @throws Exception
     */
    public void delete(String outId)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayDeleteRequestAction blPRPLINTERPAYDELETEQUESTAction = new BLPrpLinterPayDeleteRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPRPLINTERPAYDELETEQUESTAction.delete(dbManager,outId);
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
        BLPrpLinterPayDeleteRequestAction blPRPLINTERPAYDELETEQUESTAction = new BLPrpLinterPayDeleteRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPRPLINTERPAYDELETEQUESTAction.deleteByConditions(dbManager,conditions);
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
     * @param pRPLINTERPAYDELETEQUESTDto pRPLINTERPAYDELETEQUESTDto
     * @throws Exception
     */
    public void update(PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayDeleteRequestAction blPRPLINTERPAYDELETEQUESTAction = new BLPrpLinterPayDeleteRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPRPLINTERPAYDELETEQUESTAction.update(dbManager,pRPLINTERPAYDELETEQUESTDto);
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
     * @param outId �ͻ�������
     * @return pRPLINTERPAYDELETEQUESTDto pRPLINTERPAYDELETEQUESTDto
     * @throws Exception
     */
    public PrpLinterPayDeleteRequestDto findByPrimaryKey(String outId)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayDeleteRequestAction blPRPLINTERPAYDELETEQUESTAction = new BLPrpLinterPayDeleteRequestAction();
        //����DTO
        PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            pRPLINTERPAYDELETEQUESTDto = blPRPLINTERPAYDELETEQUESTAction.findByPrimaryKey(dbManager,outId);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pRPLINTERPAYDELETEQUESTDto;
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
        BLPrpLinterPayDeleteRequestAction blPRPLINTERPAYDELETEQUESTAction = new BLPrpLinterPayDeleteRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPRPLINTERPAYDELETEQUESTAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����pRPLINTERPAYDELETEQUESTDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterPayDeleteRequestAction blPRPLINTERPAYDELETEQUESTAction = new BLPrpLinterPayDeleteRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPRPLINTERPAYDELETEQUESTAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterPayDeleteRequestAction blPRPLINTERPAYDELETEQUESTAction = new BLPrpLinterPayDeleteRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPRPLINTERPAYDELETEQUESTAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
