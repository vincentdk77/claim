package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiTtyRecordDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiTtyRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utittyrecord��¼��¼���ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiTtyRecordActionBase{
    private static Log log = LogFactory.getLog(BLUtiTtyRecordActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiTtyRecordActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiTtyRecordDto utiTtyRecordDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiTtyRecordDto utiTtyRecordDto) throws Exception{
        DBUtiTtyRecord dbUtiTtyRecord = new DBUtiTtyRecord(dbManager);
        //�����¼
        dbUtiTtyRecord.insert(utiTtyRecordDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param sysTty ϵͳ�豸��
     * @throws Exception
     */
    public void delete(DBManager dbManager,String sysTty) throws Exception{
        DBUtiTtyRecord dbUtiTtyRecord = new DBUtiTtyRecord(dbManager);
        //ɾ����¼
        dbUtiTtyRecord.delete(sysTty);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiTtyRecord dbUtiTtyRecord = new DBUtiTtyRecord(dbManager);
        //������ɾ����¼
        dbUtiTtyRecord.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiTtyRecordDto utiTtyRecordDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiTtyRecordDto utiTtyRecordDto) throws Exception{
        DBUtiTtyRecord dbUtiTtyRecord = new DBUtiTtyRecord(dbManager);
        //���¼�¼
        dbUtiTtyRecord.update(utiTtyRecordDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param sysTty ϵͳ�豸��
     * @return utiTtyRecordDto utiTtyRecordDto
     * @throws Exception
     */
    public UtiTtyRecordDto findByPrimaryKey(DBManager dbManager,String sysTty) throws Exception{
        DBUtiTtyRecord dbUtiTtyRecord = new DBUtiTtyRecord(dbManager);
        //����DTO
        UtiTtyRecordDto utiTtyRecordDto = null;
        //��ѯ����,��ֵ��DTO
        utiTtyRecordDto = dbUtiTtyRecord.findByPrimaryKey(sysTty);
        return utiTtyRecordDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiTtyRecordDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiTtyRecord dbUtiTtyRecord = new DBUtiTtyRecord(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiTtyRecord.getCount(conditions);
        collection = dbUtiTtyRecord.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiTtyRecord dbUtiTtyRecord = new DBUtiTtyRecord(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiTtyRecord.getCount(conditions);
        return count;
    }
}
