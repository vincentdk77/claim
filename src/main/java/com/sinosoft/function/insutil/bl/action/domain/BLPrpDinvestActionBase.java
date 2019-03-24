package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDinvestDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDinvest;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdinvest��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDinvestActionBase{
    private static Log log = LogFactory.getLog(BLPrpDinvestActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

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
     * @param riskCode riskcode
     * @param rationType rationtype
     * @param periods periods
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String rationType,int periods) throws Exception{
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);
        //ɾ����¼
        dbPrpDinvest.delete(riskCode, rationType, periods);
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
     * @param riskCode riskcode
     * @param rationType rationtype
     * @param periods periods
     * @return prpDinvestDto prpDinvestDto
     * @throws Exception
     */
    public PrpDinvestDto findByPrimaryKey(DBManager dbManager,String riskCode,String rationType,int periods) throws Exception{
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);
        //����DTO
        PrpDinvestDto prpDinvestDto = null;
        //��ѯ����,��ֵ��DTO
        prpDinvestDto = dbPrpDinvest.findByPrimaryKey(riskCode, rationType, periods);
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

        count = dbPrpDinvest.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDinvest.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDinvestDto�ļ���
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
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDinvest.getCount(conditions);
        return count;
    }
}
