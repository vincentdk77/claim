package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLmenuAction;
import com.sinosoft.claim.dto.domain.PrpLmenuDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
    
/**  
 * ����PrpLmenu-�˵���(����)��ҵ���߼�����Facade����<br>
 * ������ 2005-05-08 15:15:54.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLmenuFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLmenuFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLmenuFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLmenuDto prpLmenuDto
     * @throws Exception
     */
    public void insert(PrpLmenuDto prpLmenuDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLmenuAction.insert(dbManager,prpLmenuDto);
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
     * @param funcID �˵����ܴ���
     * @throws Exception
     */
    public void delete(String funcID) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLmenuAction.delete(dbManager,funcID);
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
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLmenuAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLmenuDto prpLmenuDto
     * @throws Exception
     */
    public void update(PrpLmenuDto prpLmenuDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLmenuAction.update(dbManager,prpLmenuDto);
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
     * @param funcID �˵����ܴ���
     * @return prpLmenuDto prpLmenuDto
     * @throws Exception
     */
    public PrpLmenuDto findByPrimaryKey(String funcID) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        //����DTO
        PrpLmenuDto prpLmenuDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLmenuDto = blPrpLmenuAction.findByPrimaryKey(dbManager,funcID);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLmenuDto;
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
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLmenuAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLmenuDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLmenuAction.findByConditions(dbManager,conditions);
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
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLmenuAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
