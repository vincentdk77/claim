package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLbackVisitTextAction;
import com.sinosoft.claim.dto.domain.PrpLbackVisitTextDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * ����PrpLbackVisitText--�طñ�ע���ҵ���߼�����Facade����<br>
 * ������ 2005-03-23 09:00:40.750<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitTextFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitTextFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLbackVisitTextFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLbackVisitTextDto prpLbackVisitTextDto
     * @throws Exception
     */
    public void insert(PrpLbackVisitTextDto prpLbackVisitTextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLbackVisitTextAction.insert(dbManager,prpLbackVisitTextDto);
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
     * @param backVisitID �ͻ��طü�¼ID
     * @param registNo ��������
     * @param backVisitType ҵ������
     * @param lineNo �����
     * @throws Exception
     */
    public void delete(int backVisitID,String registNo,String backVisitType,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLbackVisitTextAction.delete(dbManager,backVisitID, registNo, backVisitType, lineNo);
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
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLbackVisitTextAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLbackVisitTextDto prpLbackVisitTextDto
     * @throws Exception
     */
    public void update(PrpLbackVisitTextDto prpLbackVisitTextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLbackVisitTextAction.update(dbManager,prpLbackVisitTextDto);
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
     * @param backVisitID �ͻ��طü�¼ID
     * @param registNo ��������
     * @param backVisitType ҵ������
     * @param lineNo �����
     * @return prpLbackVisitTextDto prpLbackVisitTextDto
     * @throws Exception
     */
    public PrpLbackVisitTextDto findByPrimaryKey(int backVisitID,String registNo,String backVisitType,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        //����DTO
        PrpLbackVisitTextDto prpLbackVisitTextDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLbackVisitTextDto = blPrpLbackVisitTextAction.findByPrimaryKey(dbManager,backVisitID, registNo, backVisitType, lineNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLbackVisitTextDto;
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
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLbackVisitTextAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLbackVisitTextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLbackVisitTextAction.findByConditions(dbManager,conditions);
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
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLbackVisitTextAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
