package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDreportDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDreport;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdreport��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDreportActionBase{
    private static Log log = LogFactory.getLog(BLPrpDreportActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

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
     * @param reportCode reportcode
     * @param serialNo serialno
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
     * @param reportCode reportcode
     * @param serialNo serialno
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

        count = dbPrpDreport.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDreport.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDreportDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0);
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getCount(){
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpDreport dbPrpDreport = new DBPrpDreport(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDreport.getCount(conditions);
        return count;
    }
}
