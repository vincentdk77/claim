package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLprepaytgAction;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLprepaytgDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLprepay-Ԥ��ǼǱ��ҵ���߼�����tgFacade����<br>
 * ������ 2005-03-18 17:53:38.468<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLprepaytgFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLprepaytgFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLprepaytgFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLprepayDto prpLprepayDto
     * @throws Exception
     */
    public void insert(PrpLprepaytgDto prpLprepaytgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLprepaytgAction.insert(dbManager,prpLprepaytgDto);
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
     * @param preCompensateNo Ԥ��ǼǺ�
     * @throws Exception
     */
    public void delete(String preCompensateNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLprepaytgAction.delete(dbManager,preCompensateNo);
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
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLprepaytgAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLprepayDto prpLprepayDto
     * @throws Exception
     */
    public void update(PrpLprepaytgDto prpLprepaytgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLprepaytgAction.update(dbManager,prpLprepaytgDto);
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
     * @param preCompensateNo Ԥ��ǼǺ�
     * @return prpLprepayDto prpLprepayDto
     * @throws Exception
     */
    public PrpLprepaytgDto findByPrimaryKey(String preCompensateNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        //����DTO
        PrpLprepaytgDto prpLprepayDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLprepayDto = blPrpLprepaytgAction.findByPrimaryKey(dbManager,preCompensateNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLprepayDto;
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
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLprepaytgAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLprepayDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLprepaytgAction.findByConditions(dbManager,conditions);
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
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLprepaytgAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
