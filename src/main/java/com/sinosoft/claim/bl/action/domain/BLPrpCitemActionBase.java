package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCitem;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcitem���ձ����Ŀ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCitemActionBase{
    private static Log log = LogFactory.getLog(BLPrpCitemActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCitemActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCitemDto prpCitemDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCitemDto prpCitemDto) throws Exception{
        DBPrpCitem dbPrpCitem = new DBPrpCitem(dbManager);
        //�����¼
        dbPrpCitem.insert(prpCitemDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param itemNo ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int itemNo) throws Exception{
        DBPrpCitem dbPrpCitem = new DBPrpCitem(dbManager);
        //ɾ����¼
        dbPrpCitem.delete(policyNo, itemNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCitem dbPrpCitem = new DBPrpCitem(dbManager);
        //������ɾ����¼
        dbPrpCitem.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCitemDto prpCitemDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCitemDto prpCitemDto) throws Exception{
        DBPrpCitem dbPrpCitem = new DBPrpCitem(dbManager);
        //���¼�¼
        dbPrpCitem.update(prpCitemDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param itemNo ������
     * @return prpCitemDto prpCitemDto
     * @throws Exception
     */
    public PrpCitemDto findByPrimaryKey(DBManager dbManager,String policyNo,int itemNo) throws Exception{
        DBPrpCitem dbPrpCitem = new DBPrpCitem(dbManager);
        //����DTO
        PrpCitemDto prpCitemDto = null;
        //��ѯ����,��ֵ��DTO
        prpCitemDto = dbPrpCitem.findByPrimaryKey(policyNo, itemNo);
        return prpCitemDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCitemDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCitem dbPrpCitem = new DBPrpCitem(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCitem.getCount(conditions);
        collection = dbPrpCitem.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCitem dbPrpCitem = new DBPrpCitem(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCitem.getCount(conditions);
        return count;
    }
}
