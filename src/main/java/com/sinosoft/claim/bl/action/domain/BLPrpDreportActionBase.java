package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDreportDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDreport;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdreport���������ļ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDreportActionBase{
    private static Log log = LogFactory.getLog(BLPrpDreportActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDreportActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDreportDto prpDreportDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDreportDto prpDreportDto) throws Exception{
        DBPrpDreport dbPrpDreport = new DBPrpDreport(dbManager);
        //�����¼
        dbPrpDreport.insert(prpDreportDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param reportCode �����
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String reportCode,int serialNo) throws Exception{
        DBPrpDreport dbPrpDreport = new DBPrpDreport(dbManager);
        //ɾ����¼
        dbPrpDreport.delete(reportCode, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDreport dbPrpDreport = new DBPrpDreport(dbManager);
        //������ɾ����¼
        dbPrpDreport.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDreportDto prpDreportDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDreportDto prpDreportDto) throws Exception{
        DBPrpDreport dbPrpDreport = new DBPrpDreport(dbManager);
        //���¼�¼
        dbPrpDreport.update(prpDreportDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param reportCode �����
     * @param serialNo ���
     * @return prpDreportDto prpDreportDto
     * @throws Exception
     */
    public PrpDreportDto findByPrimaryKey(DBManager dbManager,String reportCode,int serialNo) throws Exception{
        DBPrpDreport dbPrpDreport = new DBPrpDreport(dbManager);
        //����DTO
        PrpDreportDto prpDreportDto = null;
        //��ѯ����,��ֵ��DTO
        prpDreportDto = dbPrpDreport.findByPrimaryKey(reportCode, serialNo);
        return prpDreportDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDreportDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDreport dbPrpDreport = new DBPrpDreport(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDreport.getCount(conditions);
        collection = dbPrpDreport.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDreport dbPrpDreport = new DBPrpDreport(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDreport.getCount(conditions);
        return count;
    }
}
