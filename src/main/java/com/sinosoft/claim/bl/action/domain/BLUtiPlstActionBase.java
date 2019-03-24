package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPlstDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiPlst;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiplst�嵥��Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPlstActionBase{
    private static Log log = LogFactory.getLog(BLUtiPlstActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiPlstActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiPlstDto utiPlstDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiPlstDto utiPlstDto) throws Exception{
        DBUtiPlst dbUtiPlst = new DBUtiPlst(dbManager);
        //�����¼
        dbUtiPlst.insert(utiPlstDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param fileName �ļ�����
     * @param labelNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fileName,String labelNo) throws Exception{
        DBUtiPlst dbUtiPlst = new DBUtiPlst(dbManager);
        //ɾ����¼
        dbUtiPlst.delete(fileName, labelNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiPlst dbUtiPlst = new DBUtiPlst(dbManager);
        //������ɾ����¼
        dbUtiPlst.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiPlstDto utiPlstDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiPlstDto utiPlstDto) throws Exception{
        DBUtiPlst dbUtiPlst = new DBUtiPlst(dbManager);
        //���¼�¼
        dbUtiPlst.update(utiPlstDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param fileName �ļ�����
     * @param labelNo ���
     * @return utiPlstDto utiPlstDto
     * @throws Exception
     */
    public UtiPlstDto findByPrimaryKey(DBManager dbManager,String fileName,String labelNo) throws Exception{
        DBUtiPlst dbUtiPlst = new DBUtiPlst(dbManager);
        //����DTO
        UtiPlstDto utiPlstDto = null;
        //��ѯ����,��ֵ��DTO
        utiPlstDto = dbUtiPlst.findByPrimaryKey(fileName, labelNo);
        return utiPlstDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiPlstDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiPlst dbUtiPlst = new DBUtiPlst(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiPlst.getCount(conditions);
        collection = dbUtiPlst.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiPlst dbUtiPlst = new DBUtiPlst(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiPlst.getCount(conditions);
        return count;
    }
}
