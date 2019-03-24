package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimGradetgAction;
import com.sinosoft.claim.dto.domain.PrpLclaimGradeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimGradetgDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * ����PrpLclaimGrade--����ҵ��Ȩ�ޱ�(����)��ҵ���߼�����tgFacade����<br>
 * ������ 2005-04-19 09:24:24.500<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimGradetgFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimGradetgFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimGradetgFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLclaimGradeDto prpLclaimGradeDto
     * @throws Exception
     */
    public void insert(PrpLclaimGradetgDto prpLclaimGradetgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        try{
            
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLclaimGradetgAction.insert(dbManager,prpLclaimGradetgDto);
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
     * @param userCode Ա������
     * @param taskCode �������
     * @throws Exception
     */
    public void delete(String userCode,String taskCode,String configPara) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLclaimGradetgAction.delete(dbManager,userCode, taskCode,configPara);
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
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLclaimGradetgAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLclaimGradeDto prpLclaimGradeDto
     * @throws Exception
     */
    public void update(PrpLclaimGradetgDto prpLclaimGradetgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLclaimGradetgAction.update(dbManager,prpLclaimGradetgDto);
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
     * @param userCode Ա������
     * @param taskCode �������
     * @return prpLclaimGradeDto prpLclaimGradeDto
     * @throws Exception
     */
    public PrpLclaimGradetgDto findByPrimaryKey(String userCode,String taskCode,String configPara) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        //����DTO
        PrpLclaimGradetgDto prpLclaimGradetgDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLclaimGradetgDto = blPrpLclaimGradetgAction.findByPrimaryKey(dbManager,userCode, taskCode,configPara);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLclaimGradetgDto;
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
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLclaimGradetgAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLclaimGradeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLclaimGradetgAction.findByConditions(dbManager,conditions);
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
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLclaimGradetgAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
