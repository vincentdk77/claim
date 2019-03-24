package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCprofitDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCprofitDetail;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcprofitdetail�Ż��ۿ���ϸ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCprofitDetailActionBase{
    private static Log log = LogFactory.getLog(BLPrpCprofitDetailActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCprofitDetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCprofitDetailDto prpCprofitDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCprofitDetailDto prpCprofitDetailDto) throws Exception{
        DBPrpCprofitDetail dbPrpCprofitDetail = new DBPrpCprofitDetail(dbManager);
        //�����¼
        dbPrpCprofitDetail.insert(prpCprofitDetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ������
     * @param profitType �Ż��ۿ�����
     * @param itemKindNo ����������
     * @param profitCode �Ż��ۿ۴���
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,String profitType,int itemKindNo,String profitCode,int serialNo) throws Exception{
        DBPrpCprofitDetail dbPrpCprofitDetail = new DBPrpCprofitDetail(dbManager);
        //ɾ����¼
        dbPrpCprofitDetail.delete(policyNo, profitType, itemKindNo, profitCode, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCprofitDetail dbPrpCprofitDetail = new DBPrpCprofitDetail(dbManager);
        //������ɾ����¼
        dbPrpCprofitDetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCprofitDetailDto prpCprofitDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCprofitDetailDto prpCprofitDetailDto) throws Exception{
        DBPrpCprofitDetail dbPrpCprofitDetail = new DBPrpCprofitDetail(dbManager);
        //���¼�¼
        dbPrpCprofitDetail.update(prpCprofitDetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ������
     * @param profitType �Ż��ۿ�����
     * @param itemKindNo ����������
     * @param profitCode �Ż��ۿ۴���
     * @param serialNo ���
     * @return prpCprofitDetailDto prpCprofitDetailDto
     * @throws Exception
     */
    public PrpCprofitDetailDto findByPrimaryKey(DBManager dbManager,String policyNo,String profitType,int itemKindNo,String profitCode,int serialNo) throws Exception{
        DBPrpCprofitDetail dbPrpCprofitDetail = new DBPrpCprofitDetail(dbManager);
        //����DTO
        PrpCprofitDetailDto prpCprofitDetailDto = null;
        //��ѯ����,��ֵ��DTO
        prpCprofitDetailDto = dbPrpCprofitDetail.findByPrimaryKey(policyNo, profitType, itemKindNo, profitCode, serialNo);
        return prpCprofitDetailDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCprofitDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCprofitDetail dbPrpCprofitDetail = new DBPrpCprofitDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCprofitDetail.getCount(conditions);
        collection = dbPrpCprofitDetail.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCprofitDetail dbPrpCprofitDetail = new DBPrpCprofitDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCprofitDetail.getCount(conditions);
        return count;
    }
}
