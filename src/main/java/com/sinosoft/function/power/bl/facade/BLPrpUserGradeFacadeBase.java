package com.sinosoft.function.power.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.bl.action.domain.BLPrpUserGradeAction;
import com.sinosoft.function.power.dto.domain.PrpUserGradeDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpUserGrade Ա��Ȩ�ޱ��ҵ���߼�����Facade����<br>
 * ������ 2004-11-09 10:40:55.450<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUserGradeFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpUserGradeFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpUserGradeFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void insert(PrpUserGradeDto prpUserGradeDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //�����¼
            blPrpUserGradeAction.insert(dbManager,prpUserGradeDto);
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
     * @param groupCode Ȩ����Ŵ���
     * @param taskCode �������
     * @param checkCode Ȩ�޼������
     * @throws Exception
     */
    public void delete(String userCode,String groupCode,String taskCode,String checkCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpUserGradeAction.delete(dbManager,userCode, groupCode, taskCode, checkCode);
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
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpUserGradeAction.deleteByConditions(dbManager,conditions);
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
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void update(PrpUserGradeDto prpUserGradeDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //���¼�¼
            blPrpUserGradeAction.update(dbManager,prpUserGradeDto);
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
     * @param groupCode Ȩ����Ŵ���
     * @param taskCode �������
     * @param checkCode Ȩ�޼������
     * @return prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public PrpUserGradeDto findByPrimaryKey(String userCode,String groupCode,String taskCode,String checkCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        //����DTO
        PrpUserGradeDto prpUserGradeDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            //��ѯ����,��ֵ��DTO
            prpUserGradeDto = blPrpUserGradeAction.findByPrimaryKey(dbManager,userCode, groupCode, taskCode, checkCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpUserGradeDto;
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
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            pageRecord = blPrpUserGradeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpUserGradeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            collection = blPrpUserGradeAction.findByConditions(dbManager,conditions);
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
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            rowCount = blPrpUserGradeAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
