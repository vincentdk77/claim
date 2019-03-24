package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpMaxNoDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpMaxNo;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpmaxno��֤�ű��ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpMaxNoActionBase{
    private static Log log = LogFactory.getLog(BLPrpMaxNoActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpMaxNoActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpMaxNoDto prpMaxNoDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpMaxNoDto prpMaxNoDto) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        //�����¼
        dbPrpMaxNo.insert(prpMaxNoDto);
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
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        //ɾ����¼
        dbPrpMaxNo.delete(groupNo, maxNo, tableName);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        //������ɾ����¼
        dbPrpMaxNo.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpMaxNoDto prpMaxNoDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpMaxNoDto prpMaxNoDto) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        //���¼�¼
        dbPrpMaxNo.update(prpMaxNoDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param groupNo ����
     * @param maxNo ���
     * @param tableName ����
     * @return prpMaxNoDto prpMaxNoDto
     * @throws Exception
     */
    public PrpMaxNoDto findByPrimaryKey(DBManager dbManager,String groupNo,String maxNo,String tableName) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        //����DTO
        PrpMaxNoDto prpMaxNoDto = null;
        //��ѯ����,��ֵ��DTO
        prpMaxNoDto = dbPrpMaxNo.findByPrimaryKey(groupNo, maxNo, tableName);
        return prpMaxNoDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpMaxNoDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpMaxNo.getCount(conditions);
        collection = dbPrpMaxNo.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpMaxNo.getCount(conditions);
        return count;
    }
}
