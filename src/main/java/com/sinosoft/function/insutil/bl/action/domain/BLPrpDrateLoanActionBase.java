package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrateLoanDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDrateLoan;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrateloan��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrateLoanActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrateLoanActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDrateLoanActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDrateLoanDto prpDrateLoanDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDrateLoanDto prpDrateLoanDto) throws Exception{
        DBPrpDrateLoan dbPrpDrateLoan = new DBPrpDrateLoan(dbManager);
        //�����¼
        dbPrpDrateLoan.insert(prpDrateLoanDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param period period
     * @param riskCode riskcode
     * @param kindCode kindcode
     * @param comCode comcode
     * @param years years
     * @throws Exception
     */
    public void delete(DBManager dbManager,int period,String riskCode,String kindCode,String comCode,int years) throws Exception{
        DBPrpDrateLoan dbPrpDrateLoan = new DBPrpDrateLoan(dbManager);
        //ɾ����¼
        dbPrpDrateLoan.delete(period, riskCode, kindCode, comCode, years);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDrateLoan dbPrpDrateLoan = new DBPrpDrateLoan(dbManager);
        //������ɾ����¼
        dbPrpDrateLoan.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDrateLoanDto prpDrateLoanDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDrateLoanDto prpDrateLoanDto) throws Exception{
        DBPrpDrateLoan dbPrpDrateLoan = new DBPrpDrateLoan(dbManager);
        //���¼�¼
        dbPrpDrateLoan.update(prpDrateLoanDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param period period
     * @param riskCode riskcode
     * @param kindCode kindcode
     * @param comCode comcode
     * @param years years
     * @return prpDrateLoanDto prpDrateLoanDto
     * @throws Exception
     */
    public PrpDrateLoanDto findByPrimaryKey(DBManager dbManager,int period,String riskCode,String kindCode,String comCode,int years) throws Exception{
        DBPrpDrateLoan dbPrpDrateLoan = new DBPrpDrateLoan(dbManager);
        //����DTO
        PrpDrateLoanDto prpDrateLoanDto = null;
        //��ѯ����,��ֵ��DTO
        prpDrateLoanDto = dbPrpDrateLoan.findByPrimaryKey(period, riskCode, kindCode, comCode, years);
        return prpDrateLoanDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDrateLoanDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDrateLoan dbPrpDrateLoan = new DBPrpDrateLoan(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDrateLoan.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDrateLoan.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDrateLoanDto�ļ���
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
        DBPrpDrateLoan dbPrpDrateLoan = new DBPrpDrateLoan(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDrateLoan.getCount(conditions);
        return count;
    }
}
