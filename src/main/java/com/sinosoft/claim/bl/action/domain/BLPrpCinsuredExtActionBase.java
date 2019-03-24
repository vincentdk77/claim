package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCinsuredExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCinsuredExt;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcinsuredext��ϵ����չ��Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCinsuredExtActionBase{
    private static Log log = LogFactory.getLog(BLPrpCinsuredExtActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCinsuredExtActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCinsuredExtDto prpCinsuredExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCinsuredExtDto prpCinsuredExtDto) throws Exception{
        DBPrpCinsuredExt dbPrpCinsuredExt = new DBPrpCinsuredExt(dbManager);
        //�����¼
        dbPrpCinsuredExt.insert(prpCinsuredExtDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @param columnName �����ֶ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo,String columnName) throws Exception{
        DBPrpCinsuredExt dbPrpCinsuredExt = new DBPrpCinsuredExt(dbManager);
        //ɾ����¼
        dbPrpCinsuredExt.delete(policyNo, serialNo, columnName);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCinsuredExt dbPrpCinsuredExt = new DBPrpCinsuredExt(dbManager);
        //������ɾ����¼
        dbPrpCinsuredExt.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCinsuredExtDto prpCinsuredExtDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCinsuredExtDto prpCinsuredExtDto) throws Exception{
        DBPrpCinsuredExt dbPrpCinsuredExt = new DBPrpCinsuredExt(dbManager);
        //���¼�¼
        dbPrpCinsuredExt.update(prpCinsuredExtDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @param columnName �����ֶ���
     * @return prpCinsuredExtDto prpCinsuredExtDto
     * @throws Exception
     */
    public PrpCinsuredExtDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo,String columnName) throws Exception{
        DBPrpCinsuredExt dbPrpCinsuredExt = new DBPrpCinsuredExt(dbManager);
        //����DTO
        PrpCinsuredExtDto prpCinsuredExtDto = null;
        //��ѯ����,��ֵ��DTO
        prpCinsuredExtDto = dbPrpCinsuredExt.findByPrimaryKey(policyNo, serialNo, columnName);
        return prpCinsuredExtDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCinsuredExtDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCinsuredExt dbPrpCinsuredExt = new DBPrpCinsuredExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCinsuredExt.getCount(conditions);
        collection = dbPrpCinsuredExt.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCinsuredExt dbPrpCinsuredExt = new DBPrpCinsuredExt(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCinsuredExt.getCount(conditions);
        return count;
    }
}
