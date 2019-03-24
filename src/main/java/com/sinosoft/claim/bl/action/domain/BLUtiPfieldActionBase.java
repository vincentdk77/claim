package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPfieldDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiPfield;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utipfield��֤��ӡ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPfieldActionBase{
    private static Log log = LogFactory.getLog(BLUtiPfieldActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiPfieldActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiPfieldDto utiPfieldDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiPfieldDto utiPfieldDto) throws Exception{
        DBUtiPfield dbUtiPfield = new DBUtiPfield(dbManager);
        //�����¼
        dbUtiPfield.insert(utiPfieldDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param fileName �ļ�����
     * @param labelNo ���(��ʽ���)
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fileName,String labelNo) throws Exception{
        DBUtiPfield dbUtiPfield = new DBUtiPfield(dbManager);
        //ɾ����¼
        dbUtiPfield.delete(fileName, labelNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiPfield dbUtiPfield = new DBUtiPfield(dbManager);
        //������ɾ����¼
        dbUtiPfield.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiPfieldDto utiPfieldDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiPfieldDto utiPfieldDto) throws Exception{
        DBUtiPfield dbUtiPfield = new DBUtiPfield(dbManager);
        //���¼�¼
        dbUtiPfield.update(utiPfieldDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param fileName �ļ�����
     * @param labelNo ���(��ʽ���)
     * @return utiPfieldDto utiPfieldDto
     * @throws Exception
     */
    public UtiPfieldDto findByPrimaryKey(DBManager dbManager,String fileName,String labelNo) throws Exception{
        DBUtiPfield dbUtiPfield = new DBUtiPfield(dbManager);
        //����DTO
        UtiPfieldDto utiPfieldDto = null;
        //��ѯ����,��ֵ��DTO
        utiPfieldDto = dbUtiPfield.findByPrimaryKey(fileName, labelNo);
        return utiPfieldDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiPfieldDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiPfield dbUtiPfield = new DBUtiPfield(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiPfield.getCount(conditions);
        collection = dbUtiPfield.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiPfield dbUtiPfield = new DBUtiPfield(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiPfield.getCount(conditions);
        return count;
    }
}
