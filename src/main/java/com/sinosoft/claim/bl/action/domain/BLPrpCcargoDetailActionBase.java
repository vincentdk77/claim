package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCcargoDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCcargoDetail;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpccargodetail�����ջ�����ϸ��Ϣ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCcargoDetailActionBase{
    private static Log log = LogFactory.getLog(BLPrpCcargoDetailActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCcargoDetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCcargoDetailDto prpCcargoDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCcargoDetailDto prpCcargoDetailDto) throws Exception{
        DBPrpCcargoDetail dbPrpCcargoDetail = new DBPrpCcargoDetail(dbManager);
        //�����¼
        dbPrpCcargoDetail.insert(prpCcargoDetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ������/Э���
     * @param batchNo ����
     * @param serialNo ˳���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int batchNo,int serialNo) throws Exception{
        DBPrpCcargoDetail dbPrpCcargoDetail = new DBPrpCcargoDetail(dbManager);
        //ɾ����¼
        dbPrpCcargoDetail.delete(policyNo, batchNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCcargoDetail dbPrpCcargoDetail = new DBPrpCcargoDetail(dbManager);
        //������ɾ����¼
        dbPrpCcargoDetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCcargoDetailDto prpCcargoDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCcargoDetailDto prpCcargoDetailDto) throws Exception{
        DBPrpCcargoDetail dbPrpCcargoDetail = new DBPrpCcargoDetail(dbManager);
        //���¼�¼
        dbPrpCcargoDetail.update(prpCcargoDetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ������/Э���
     * @param batchNo ����
     * @param serialNo ˳���
     * @return prpCcargoDetailDto prpCcargoDetailDto
     * @throws Exception
     */
    public PrpCcargoDetailDto findByPrimaryKey(DBManager dbManager,String policyNo,int batchNo,int serialNo) throws Exception{
        DBPrpCcargoDetail dbPrpCcargoDetail = new DBPrpCcargoDetail(dbManager);
        //����DTO
        PrpCcargoDetailDto prpCcargoDetailDto = null;
        //��ѯ����,��ֵ��DTO
        prpCcargoDetailDto = dbPrpCcargoDetail.findByPrimaryKey(policyNo, batchNo, serialNo);
        return prpCcargoDetailDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCcargoDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCcargoDetail dbPrpCcargoDetail = new DBPrpCcargoDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCcargoDetail.getCount(conditions);
        collection = dbPrpCcargoDetail.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCcargoDetail dbPrpCcargoDetail = new DBPrpCcargoDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCcargoDetail.getCount(conditions);
        return count;
    }
}
