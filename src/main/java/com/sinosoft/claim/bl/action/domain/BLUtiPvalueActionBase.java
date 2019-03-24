package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPvalueDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiPvalue;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utipvalue��֤��ӡ���ݵ�ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPvalueActionBase{
    private static Log log = LogFactory.getLog(BLUtiPvalueActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiPvalueActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiPvalueDto utiPvalueDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiPvalueDto utiPvalueDto) throws Exception{
        DBUtiPvalue dbUtiPvalue = new DBUtiPvalue(dbManager);
        //�����¼
        dbUtiPvalue.insert(utiPvalueDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param ttyName �ն˺�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String ttyName) throws Exception{
        DBUtiPvalue dbUtiPvalue = new DBUtiPvalue(dbManager);
        //ɾ����¼
        dbUtiPvalue.delete(ttyName);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiPvalue dbUtiPvalue = new DBUtiPvalue(dbManager);
        //������ɾ����¼
        dbUtiPvalue.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiPvalueDto utiPvalueDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiPvalueDto utiPvalueDto) throws Exception{
        DBUtiPvalue dbUtiPvalue = new DBUtiPvalue(dbManager);
        //���¼�¼
        dbUtiPvalue.update(utiPvalueDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param ttyName �ն˺�
     * @return utiPvalueDto utiPvalueDto
     * @throws Exception
     */
    public UtiPvalueDto findByPrimaryKey(DBManager dbManager,String ttyName) throws Exception{
        DBUtiPvalue dbUtiPvalue = new DBUtiPvalue(dbManager);
        //����DTO
        UtiPvalueDto utiPvalueDto = null;
        //��ѯ����,��ֵ��DTO
        utiPvalueDto = dbUtiPvalue.findByPrimaryKey(ttyName);
        return utiPvalueDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiPvalueDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiPvalue dbUtiPvalue = new DBUtiPvalue(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiPvalue.getCount(conditions);
        collection = dbUtiPvalue.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiPvalue dbUtiPvalue = new DBUtiPvalue(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiPvalue.getCount(conditions);
        return count;
    }
}
