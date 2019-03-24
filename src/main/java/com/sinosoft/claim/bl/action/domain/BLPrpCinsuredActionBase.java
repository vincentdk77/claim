package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCinsured;
import com.sinosoft.prpall.dbsvr.cb.DBPrpCvirturlItem;
import com.sinosoft.prpall.schema.PrpCvirturlItemSchema;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcinsured���չ�ϵ�˱��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCinsuredActionBase{
    private static Log log = LogFactory.getLog(BLPrpCinsuredActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCinsuredActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCinsuredDto prpCinsuredDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCinsuredDto prpCinsuredDto) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        //�����¼
        dbPrpCinsured.insert(prpCinsuredDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        //ɾ����¼
        dbPrpCinsured.delete(policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        //������ɾ����¼
        dbPrpCinsured.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCinsuredDto prpCinsuredDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCinsuredDto prpCinsuredDto) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        //���¼�¼
        dbPrpCinsured.update(prpCinsuredDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @return prpCinsuredDto prpCinsuredDto
     * @throws Exception
     */
    public PrpCinsuredDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        //����DTO
        PrpCinsuredDto prpCinsuredDto = null;
        //��ѯ����,��ֵ��DTO
        prpCinsuredDto = dbPrpCinsured.findByPrimaryKey(policyNo, serialNo);
        return prpCinsuredDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCinsuredDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCinsured.getCount(conditions);
        collection = dbPrpCinsured.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ������ֻ��Ķ�������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCinsuredDto�ļ���
     * @throws Exception
     */
    public Collection findVirturlItemByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCinsured.getVirturlItemCount(conditions);
        
        collection = dbPrpCinsured.findVirturlItemByConditions(conditions,pageNo,rowsPerPage);
        Iterator it = collection.iterator();
        while(it.hasNext()){
        	PrpCvirturlItemSchema prpCvirturlItemSchema = (PrpCvirturlItemSchema)it.next();
        	if(prpCvirturlItemSchema.getFamilySex()==null||prpCvirturlItemSchema.getFamilySex()==""){
        		prpCvirturlItemSchema.setFamilySex("9");
        	}
        }

        
        return collection;
    }
    /**
     * ��prpcvirturlItem����ȡ���ɲ���ϱ�������
     * @param dbManager
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public Collection findViturlItemDtoByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCinsured.getVirturlItemCount(conditions);
        
        collection = dbPrpCinsured.findViturlItemDtoByConditions(conditions,pageNo,rowsPerPage);
        Iterator it = collection.iterator();
        while(it.hasNext()){
        	PrpCvirturlItemSchema prpCvirturlItemSchema = (PrpCvirturlItemSchema)it.next();
        	if(prpCvirturlItemSchema.getFamilySex()==null||prpCvirturlItemSchema.getFamilySex()==""){
        		prpCvirturlItemSchema.setFamilySex("9");
        	}
        }

        
        return collection;
    }
    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCinsured.getCount(conditions);
        return count;
    }
    
    /**
     * ��ѯ��ֲ��ũ���嵥��Ϣչʾ���¹�����Ϣ����
     * @param dbManager
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public Collection findByPlantingConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        collection = dbPrpCinsured.findByPlantingConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }
}
