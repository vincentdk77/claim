package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLFirstVeriOpinionAction;
import com.sinosoft.claim.dto.domain.PrpLFirstVeriOpinionDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǳ���������ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLFirstVeriOpinionFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLFirstVeriOpinionFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLFirstVeriOpinionFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @throws Exception
     */
    public void insert(PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLFirstVeriOpinionAction blPrpLFirstVeriOpinionAction = new BLPrpLFirstVeriOpinionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLFirstVeriOpinionAction.insert(dbManager,prpLFirstVeriOpinionDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    /**
     * �����������
     * @param prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @throws Exception
     */
    public void insertAll(Collection<PrpLFirstVeriOpinionDto> prpLFirstVeriOpinionDtos)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLFirstVeriOpinionAction blPrpLFirstVeriOpinionAction = new BLPrpLFirstVeriOpinionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLFirstVeriOpinionAction.insertAll(dbManager,prpLFirstVeriOpinionDtos);
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
     * @param registNo ������
     * @throws Exception
     */
    public void delete(String registNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLFirstVeriOpinionAction blPrpLFirstVeriOpinionAction = new BLPrpLFirstVeriOpinionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLFirstVeriOpinionAction.delete(dbManager,registNo);
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
        BLPrpLFirstVeriOpinionAction blPrpLFirstVeriOpinionAction = new BLPrpLFirstVeriOpinionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLFirstVeriOpinionAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @throws Exception
     */
    public void update(PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLFirstVeriOpinionAction blPrpLFirstVeriOpinionAction = new BLPrpLFirstVeriOpinionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLFirstVeriOpinionAction.update(dbManager,prpLFirstVeriOpinionDto);
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
     * @param registNo ������
     * @return prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @throws Exception
     */
    public PrpLFirstVeriOpinionDto findByPrimaryKey(String registNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLFirstVeriOpinionAction blPrpLFirstVeriOpinionAction = new BLPrpLFirstVeriOpinionAction();
        //����DTO
        PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLFirstVeriOpinionDto = blPrpLFirstVeriOpinionAction.findByPrimaryKey(dbManager,registNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLFirstVeriOpinionDto;
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
        BLPrpLFirstVeriOpinionAction blPrpLFirstVeriOpinionAction = new BLPrpLFirstVeriOpinionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLFirstVeriOpinionAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLFirstVeriOpinionDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLFirstVeriOpinionAction blPrpLFirstVeriOpinionAction = new BLPrpLFirstVeriOpinionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLFirstVeriOpinionAction.findByConditions(dbManager,conditions);
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
        BLPrpLFirstVeriOpinionAction blPrpLFirstVeriOpinionAction = new BLPrpLFirstVeriOpinionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLFirstVeriOpinionAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
