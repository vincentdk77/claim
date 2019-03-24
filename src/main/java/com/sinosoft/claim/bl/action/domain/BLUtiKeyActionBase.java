package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiKeyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiKey;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utikey��ֵ��Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiKeyActionBase{
    private static Log log = LogFactory.getLog(BLUtiKeyActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiKeyActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiKeyDto utiKeyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiKeyDto utiKeyDto) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        //�����¼
        dbUtiKey.insert(utiKeyDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param tableName ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String tableName) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        //ɾ����¼
        dbUtiKey.delete(tableName);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        //������ɾ����¼
        dbUtiKey.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiKeyDto utiKeyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiKeyDto utiKeyDto) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        //���¼�¼
        dbUtiKey.update(utiKeyDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param tableName ����
     * @return utiKeyDto utiKeyDto
     * @throws Exception
     */
    public UtiKeyDto findByPrimaryKey(DBManager dbManager,String tableName) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        //����DTO
        UtiKeyDto utiKeyDto = null;
        //��ѯ����,��ֵ��DTO
        utiKeyDto = dbUtiKey.findByPrimaryKey(tableName);
        return utiKeyDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiKeyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiKey.getCount(conditions);
        collection = dbUtiKey.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiKey.getCount(conditions);
        return count;
    }
}
