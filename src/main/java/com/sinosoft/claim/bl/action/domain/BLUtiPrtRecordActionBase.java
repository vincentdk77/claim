package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPrtRecordDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiPrtRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiprtrecord��ӡ��¼���ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPrtRecordActionBase{
    private static Log log = LogFactory.getLog(BLUtiPrtRecordActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiPrtRecordActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiPrtRecordDto utiPrtRecordDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiPrtRecordDto utiPrtRecordDto) throws Exception{
        DBUtiPrtRecord dbUtiPrtRecord = new DBUtiPrtRecord(dbManager);
        //�����¼
        dbUtiPrtRecord.insert(utiPrtRecordDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param certiNo ���ݺ�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiNo) throws Exception{
        DBUtiPrtRecord dbUtiPrtRecord = new DBUtiPrtRecord(dbManager);
        //ɾ����¼
        dbUtiPrtRecord.delete(certiNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiPrtRecord dbUtiPrtRecord = new DBUtiPrtRecord(dbManager);
        //������ɾ����¼
        dbUtiPrtRecord.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiPrtRecordDto utiPrtRecordDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiPrtRecordDto utiPrtRecordDto) throws Exception{
        DBUtiPrtRecord dbUtiPrtRecord = new DBUtiPrtRecord(dbManager);
        //���¼�¼
        dbUtiPrtRecord.update(utiPrtRecordDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param certiNo ���ݺ�
     * @return utiPrtRecordDto utiPrtRecordDto
     * @throws Exception
     */
    public UtiPrtRecordDto findByPrimaryKey(DBManager dbManager,String certiNo) throws Exception{
        DBUtiPrtRecord dbUtiPrtRecord = new DBUtiPrtRecord(dbManager);
        //����DTO
        UtiPrtRecordDto utiPrtRecordDto = null;
        //��ѯ����,��ֵ��DTO
        utiPrtRecordDto = dbUtiPrtRecord.findByPrimaryKey(certiNo);
        return utiPrtRecordDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiPrtRecordDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiPrtRecord dbUtiPrtRecord = new DBUtiPrtRecord(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiPrtRecord.getCount(conditions);
        collection = dbUtiPrtRecord.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiPrtRecord dbUtiPrtRecord = new DBUtiPrtRecord(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiPrtRecord.getCount(conditions);
        return count;
    }
}
