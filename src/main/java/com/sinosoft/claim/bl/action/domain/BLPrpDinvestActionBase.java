package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDinvestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDinvest;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdinvestͶ��������Ͷ����Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDinvestActionBase{
    private static Log log = LogFactory.getLog(BLPrpDinvestActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDinvestActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDinvestDto prpDinvestDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDinvestDto prpDinvestDto) throws Exception{
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);
        //�����¼
        dbPrpDinvest.insert(prpDinvestDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param investType Ͷ�����ʹ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String investType) throws Exception{
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);
        //ɾ����¼
        dbPrpDinvest.delete(riskCode, investType);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);
        //������ɾ����¼
        dbPrpDinvest.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDinvestDto prpDinvestDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDinvestDto prpDinvestDto) throws Exception{
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);
        //���¼�¼
        dbPrpDinvest.update(prpDinvestDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param investType Ͷ�����ʹ���
     * @return prpDinvestDto prpDinvestDto
     * @throws Exception
     */
    public PrpDinvestDto findByPrimaryKey(DBManager dbManager,String riskCode,String investType) throws Exception{
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);
        //����DTO
        PrpDinvestDto prpDinvestDto = null;
        //��ѯ����,��ֵ��DTO
        prpDinvestDto = dbPrpDinvest.findByPrimaryKey(riskCode, investType);
        return prpDinvestDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDinvestDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDinvest.getCount(conditions);
        collection = dbPrpDinvest.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDinvest.getCount(conditions);
        return count;
    }
}
