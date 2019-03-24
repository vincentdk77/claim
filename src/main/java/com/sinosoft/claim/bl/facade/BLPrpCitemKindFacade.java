package com.sinosoft.claim.bl.facade;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpCitemKindAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcompany����������ҵ���߼�����Facade����<br>
 * ������ 2004-08-25 16:51:30.344<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCitemKindFacade{
    private static Log logger = LogFactory.getLog(BLPrpDcompanyFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpCitemKindFacade(){
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

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        Collection prpDitemKind = null ;
        DBManager dbManager = new DBManager();
        BLPrpCitemKindAction blPrpCitemKindAction = new BLPrpCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            prpDitemKind = blPrpCitemKindAction.findByConditions(dbManager,conditions,0,0);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDitemKind;
    }
    /**
     * ��������ѯ��������  �������ֻ��ı�����Ϣ
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public Collection findVirturlItemByConditions(String conditions) throws Exception{

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        Collection prpDitemKind = null ;
        DBManager dbManager = new DBManager();
        BLPrpCitemKindAction blPrpCitemKindAction = new BLPrpCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            prpDitemKind = blPrpCitemKindAction.findVirturlItemByConditions(dbManager,conditions,0,0);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDitemKind;
    }
    /**
     * ���������� �ܱ���
     * @param conditions ��ѯ����
     * @return PageRecord �ܱ���
     * @throws Exception
     */
    public double getSumAmount(String conditions) throws Exception{

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        double sumAmount = 0.00;
        DBManager dbManager = new DBManager();
        BLPrpCitemKindAction blPrpCitemKindAction = new BLPrpCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            sumAmount = blPrpCitemKindAction.getSumAmount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sumAmount;
    }
    
    public int getItemKindNo(String conditions) throws Exception{

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int itemkindno = 0;
        DBManager dbManager = new DBManager();
        BLPrpCitemKindAction blPrpCitemKindAction = new BLPrpCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            itemkindno = blPrpCitemKindAction.getItemKindNo(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return itemkindno;
    }
    public String getItemDetailName(String conditions) throws Exception{

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        String itemDetailName = "";
        DBManager dbManager = new DBManager();
        BLPrpCitemKindAction blPrpCitemKindAction = new BLPrpCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            itemDetailName = blPrpCitemKindAction.getItemDetailName(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return itemDetailName;
    }
}
