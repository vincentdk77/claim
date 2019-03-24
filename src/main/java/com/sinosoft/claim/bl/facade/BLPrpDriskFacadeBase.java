package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDriskAction;
import com.sinosoft.claim.dto.domain.PrpDriskDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrisk���ִ�����ҵ���߼�����Facade����<br>
 * ������ 2004-08-25 16:51:30.344<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDriskFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDriskFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpDriskFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpDriskDto prpDriskDto
     * @throws Exception
     */
    public void insert(PrpDriskDto prpDriskDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDriskAction blPrpDriskAction = new BLPrpDriskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpDriskAction.insert(dbManager,prpDriskDto);
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
     * @param riskCode ���ִ���
     * @throws Exception
     */
    public void delete(String riskCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDriskAction blPrpDriskAction = new BLPrpDriskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpDriskAction.delete(dbManager,riskCode);
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
        BLPrpDriskAction blPrpDriskAction = new BLPrpDriskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpDriskAction.deleteByConditions(dbManager,conditions);
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
     * @param prpDriskDto prpDriskDto
     * @throws Exception
     */
    public void update(PrpDriskDto prpDriskDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDriskAction blPrpDriskAction = new BLPrpDriskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpDriskAction.update(dbManager,prpDriskDto);
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
     * @param riskCode ���ִ���
     * @return prpDriskDto prpDriskDto
     * @throws Exception
     */
    public PrpDriskDto findByPrimaryKey(String riskCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDriskAction blPrpDriskAction = new BLPrpDriskAction();
        //����DTO
        PrpDriskDto prpDriskDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpDriskDto = blPrpDriskAction.findByPrimaryKey(dbManager,riskCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDriskDto;
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
        BLPrpDriskAction blPrpDriskAction = new BLPrpDriskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpDriskAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpDriskDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
      return findByConditions(conditions,0,0).getResult();
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
        BLPrpDriskAction blPrpDriskAction = new BLPrpDriskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpDriskAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
