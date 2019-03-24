package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfModelUseAction;
import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfModelUseģ��ʹ�����ã���������ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.718<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfModelUseFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfModelUseFacadeBase.class);

    /**
     * ���캯��
     */
    public BLSwfModelUseFacadeBase(){
    }

    /**
     * ����һ������
     * @param swfModelUseDto swfModelUseDto
     * @throws Exception
     */
    public void insert(SwfModelUseDto swfModelUseDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blSwfModelUseAction.insert(dbManager,swfModelUseDto);
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
     * @param modelNo ģ����
     * @param riskCode ���ִ���
     * @param comCode ���ű���
     * @throws Exception
     */
    public void delete(int modelNo,String riskCode,String comCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blSwfModelUseAction.delete(dbManager,modelNo, riskCode, comCode);
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
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blSwfModelUseAction.deleteByConditions(dbManager,conditions);
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
     * @param swfModelUseDto swfModelUseDto
     * @throws Exception
     */
    public void update(SwfModelUseDto swfModelUseDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blSwfModelUseAction.update(dbManager,swfModelUseDto);
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
     * @param modelNo ģ����
     * @param riskCode ���ִ���
     * @param comCode ���ű���
     * @return swfModelUseDto swfModelUseDto
     * @throws Exception
     */
    public SwfModelUseDto findByPrimaryKey(int modelNo,String riskCode,String comCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        //����DTO
        SwfModelUseDto swfModelUseDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            swfModelUseDto = blSwfModelUseAction.findByPrimaryKey(dbManager,modelNo, riskCode, comCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return swfModelUseDto;
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
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfModelUseAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����swfModelUseDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blSwfModelUseAction.findByConditions(dbManager,conditions);
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
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blSwfModelUseAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
