package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCopenCoverBalDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCopenCoverBal;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcopencoverbalЭ������¼���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCopenCoverBalActionBase{
    private static Log log = LogFactory.getLog(BLPrpCopenCoverBalActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCopenCoverBalActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCopenCoverBalDto prpCopenCoverBalDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCopenCoverBalDto prpCopenCoverBalDto) throws Exception{
        DBPrpCopenCoverBal dbPrpCopenCoverBal = new DBPrpCopenCoverBal(dbManager);
        //�����¼
        dbPrpCopenCoverBal.insert(prpCopenCoverBalDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo Э���
     * @param serialNo ˳���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCopenCoverBal dbPrpCopenCoverBal = new DBPrpCopenCoverBal(dbManager);
        //ɾ����¼
        dbPrpCopenCoverBal.delete(policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCopenCoverBal dbPrpCopenCoverBal = new DBPrpCopenCoverBal(dbManager);
        //������ɾ����¼
        dbPrpCopenCoverBal.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCopenCoverBalDto prpCopenCoverBalDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCopenCoverBalDto prpCopenCoverBalDto) throws Exception{
        DBPrpCopenCoverBal dbPrpCopenCoverBal = new DBPrpCopenCoverBal(dbManager);
        //���¼�¼
        dbPrpCopenCoverBal.update(prpCopenCoverBalDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo Э���
     * @param serialNo ˳���
     * @return prpCopenCoverBalDto prpCopenCoverBalDto
     * @throws Exception
     */
    public PrpCopenCoverBalDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCopenCoverBal dbPrpCopenCoverBal = new DBPrpCopenCoverBal(dbManager);
        //����DTO
        PrpCopenCoverBalDto prpCopenCoverBalDto = null;
        //��ѯ����,��ֵ��DTO
        prpCopenCoverBalDto = dbPrpCopenCoverBal.findByPrimaryKey(policyNo, serialNo);
        return prpCopenCoverBalDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCopenCoverBalDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCopenCoverBal dbPrpCopenCoverBal = new DBPrpCopenCoverBal(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCopenCoverBal.getCount(conditions);
        collection = dbPrpCopenCoverBal.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCopenCoverBal dbPrpCopenCoverBal = new DBPrpCopenCoverBal(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCopenCoverBal.getCount(conditions);
        return count;
    }
}
