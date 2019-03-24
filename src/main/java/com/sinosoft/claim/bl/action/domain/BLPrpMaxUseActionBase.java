package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpMaxUseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpMaxUse;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpmaxuse��֤��ʹ�õǼǱ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpMaxUseActionBase{
    private static Log log = LogFactory.getLog(BLPrpMaxUseActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpMaxUseActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpMaxUseDto prpMaxUseDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpMaxUseDto prpMaxUseDto) throws Exception{
        DBPrpMaxUse dbPrpMaxUse = new DBPrpMaxUse(dbManager);
        //�����¼
        dbPrpMaxUse.insert(prpMaxUseDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param groupNo ����
     * @param maxNo ���
     * @param tableName ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String groupNo,String maxNo,String tableName) throws Exception{
        DBPrpMaxUse dbPrpMaxUse = new DBPrpMaxUse(dbManager);
        //ɾ����¼
        dbPrpMaxUse.delete(groupNo, maxNo, tableName);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpMaxUse dbPrpMaxUse = new DBPrpMaxUse(dbManager);
        //������ɾ����¼
        dbPrpMaxUse.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpMaxUseDto prpMaxUseDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpMaxUseDto prpMaxUseDto) throws Exception{
        DBPrpMaxUse dbPrpMaxUse = new DBPrpMaxUse(dbManager);
        //���¼�¼
        dbPrpMaxUse.update(prpMaxUseDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param groupNo ����
     * @param maxNo ���
     * @param tableName ����
     * @return prpMaxUseDto prpMaxUseDto
     * @throws Exception
     */
    public PrpMaxUseDto findByPrimaryKey(DBManager dbManager,String groupNo,String maxNo,String tableName) throws Exception{
        DBPrpMaxUse dbPrpMaxUse = new DBPrpMaxUse(dbManager);
        //����DTO
        PrpMaxUseDto prpMaxUseDto = null;
        //��ѯ����,��ֵ��DTO
        prpMaxUseDto = dbPrpMaxUse.findByPrimaryKey(groupNo, maxNo, tableName);
        return prpMaxUseDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpMaxUseDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpMaxUse dbPrpMaxUse = new DBPrpMaxUse(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpMaxUse.getCount(conditions);
        collection = dbPrpMaxUse.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpMaxUse dbPrpMaxUse = new DBPrpMaxUse(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpMaxUse.getCount(conditions);
        return count;
    }
}