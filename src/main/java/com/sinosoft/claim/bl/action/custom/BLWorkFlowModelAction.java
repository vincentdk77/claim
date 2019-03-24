package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.WorkFlowModelDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBWorkFlowModel;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����WorkFlowModel������ģ���ҵ���߼�������<br>
 * ������ 2004-08-09 19:54:54.996<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLWorkFlowModelAction{
    private static Log logger = LogFactory.getLog(BLWorkFlowModelAction.class);

    /**
     * ���캯��
     */
    public BLWorkFlowModelAction(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param workFlowModelDto workFlowModelDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,WorkFlowModelDto workFlowModelDto) throws Exception{
      DBWorkFlowModel dbWorkFlowModel = null;
      //ҵ�����
      dbWorkFlowModel = new DBWorkFlowModel();

     //����������ӻ����޸���ô��insert
       dbWorkFlowModel.insert(dbManager,workFlowModelDto);

    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param modelNo ģ�����
     * @param pathNo ���̱߱���
     * @param conditionNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();
        //ɾ����¼
       // dbWorkFlowModel.delete(conditionNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();
        //������ɾ����¼
        //dbWorkFlowModel.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param workFlowModelDto workFlowModelDto
     * @throws Exception
     */
    public void update(DBManager dbManager,WorkFlowModelDto workFlowModelDto) throws Exception{
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();
        //���¼�¼
        //dbWorkFlowModel.update(workFlowModelDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param modelNo ģ�����
     * @param pathNo ���̱߱���
     * @param conditionNo ��������
     * @param serialNo ���
     * @return workFlowModelDto workFlowModelDto
     * @throws Exception
     */
    public WorkFlowModelDto findByPrimaryKey(DBManager dbManager,int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();
        //����DTO
        WorkFlowModelDto workFlowModelDto = null;
        //��ѯ����,��ֵ��DTO
        //workFlowModelDto = dbWorkFlowModel.findByPrimaryKey(modelNo, pathNo, conditionNo, serialNo);
        return workFlowModelDto;
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param modelNo ģ�����
     * @return workFlowModelDto workFlowModelDto
     * @throws Exception
     */
    public WorkFlowModelDto findByPrimaryKey(DBManager dbManager,int modelNo) throws Exception{
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();
        //����DTO
        WorkFlowModelDto workFlowModelDto = null;
        //��ѯ����,��ֵ��DTO
        workFlowModelDto = dbWorkFlowModel.findByPrimaryKey(dbManager,modelNo);
        return workFlowModelDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

       // int count = dbWorkFlowModel.getCount(SqlUtils.getWherePartForGetCount(conditions));
       // collection = dbWorkFlowModel.findByConditions(conditions,pageNo,rowsPerPage);
       // PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);

       PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,collection);
       return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����workFlowModelDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

     //   collection = dbWorkFlowModel.findByConditions(conditions,0,0);
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions)
        throws Exception{
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
       int count=0;
       // int count = dbWorkFlowModel.getCount(conditions);
        return count;
    }

/**
 * ȡmodelNo��
 * @param dbManager  ��������
 * @return modelNo
 * @throws SQLException
 * @throws Exception
 */
public int getModelNo(DBManager dbManager)throws SQLException,Exception
{
  DBWorkFlowModel dbWorkFlowModel= new DBWorkFlowModel();
  int modelNo=-1;
  modelNo= dbWorkFlowModel.getModelNo(dbManager) ;
  return modelNo;
}

}
