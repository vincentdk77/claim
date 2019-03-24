package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJprofitCondDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJprofitCond;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjprofitcond�Ż��������ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJprofitCondActionBase{
    private static Log log = LogFactory.getLog(BLPrpJprofitCondActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpJprofitCondActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpJprofitCondDto prpJprofitCondDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJprofitCondDto prpJprofitCondDto) throws Exception{
        DBPrpJprofitCond dbPrpJprofitCond = new DBPrpJprofitCond(dbManager);
        //�����¼
        dbPrpJprofitCond.insert(prpJprofitCondDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ���յ��Ŵ�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo) throws Exception{
        DBPrpJprofitCond dbPrpJprofitCond = new DBPrpJprofitCond(dbManager);
        //ɾ����¼
        dbPrpJprofitCond.delete(policyNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJprofitCond dbPrpJprofitCond = new DBPrpJprofitCond(dbManager);
        //������ɾ����¼
        dbPrpJprofitCond.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpJprofitCondDto prpJprofitCondDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJprofitCondDto prpJprofitCondDto) throws Exception{
        DBPrpJprofitCond dbPrpJprofitCond = new DBPrpJprofitCond(dbManager);
        //���¼�¼
        dbPrpJprofitCond.update(prpJprofitCondDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ���յ��Ŵ�
     * @return prpJprofitCondDto prpJprofitCondDto
     * @throws Exception
     */
    public PrpJprofitCondDto findByPrimaryKey(DBManager dbManager,String policyNo) throws Exception{
        DBPrpJprofitCond dbPrpJprofitCond = new DBPrpJprofitCond(dbManager);
        //����DTO
        PrpJprofitCondDto prpJprofitCondDto = null;
        //��ѯ����,��ֵ��DTO
        prpJprofitCondDto = dbPrpJprofitCond.findByPrimaryKey(policyNo);
        return prpJprofitCondDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpJprofitCondDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJprofitCond dbPrpJprofitCond = new DBPrpJprofitCond(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJprofitCond.getCount(conditions);
        collection = dbPrpJprofitCond.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJprofitCond dbPrpJprofitCond = new DBPrpJprofitCond(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJprofitCond.getCount(conditions);
        return count;
    }
}
