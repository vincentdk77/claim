package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCfeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCfee;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcfee��������ѱ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCfeeActionBase{
    private static Log log = LogFactory.getLog(BLPrpCfeeActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCfeeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCfeeDto prpCfeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCfeeDto prpCfeeDto) throws Exception{
        DBPrpCfee dbPrpCfee = new DBPrpCfee(dbManager);
        //�����¼
        dbPrpCfee.insert(prpCfeeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param currency �ұ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,String currency) throws Exception{
        DBPrpCfee dbPrpCfee = new DBPrpCfee(dbManager);
        //ɾ����¼
        dbPrpCfee.delete(policyNo, currency);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCfee dbPrpCfee = new DBPrpCfee(dbManager);
        //������ɾ����¼
        dbPrpCfee.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCfeeDto prpCfeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCfeeDto prpCfeeDto) throws Exception{
        DBPrpCfee dbPrpCfee = new DBPrpCfee(dbManager);
        //���¼�¼
        dbPrpCfee.update(prpCfeeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param currency �ұ����
     * @return prpCfeeDto prpCfeeDto
     * @throws Exception
     */
    public PrpCfeeDto findByPrimaryKey(DBManager dbManager,String policyNo,String currency) throws Exception{
        DBPrpCfee dbPrpCfee = new DBPrpCfee(dbManager);
        //����DTO
        PrpCfeeDto prpCfeeDto = null;
        //��ѯ����,��ֵ��DTO
        prpCfeeDto = dbPrpCfee.findByPrimaryKey(policyNo, currency);
        return prpCfeeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCfeeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCfee dbPrpCfee = new DBPrpCfee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCfee.getCount(conditions);
        collection = dbPrpCfee.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCfee dbPrpCfee = new DBPrpCfee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCfee.getCount(conditions);
        return count;
    }
}
