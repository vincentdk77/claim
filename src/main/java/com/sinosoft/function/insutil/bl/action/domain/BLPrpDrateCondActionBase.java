package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrateCondDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDrateCond;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdratecond��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrateCondActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrateCondActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDrateCondActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDrateCondDto prpDrateCondDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDrateCondDto prpDrateCondDto) throws Exception{
        DBPrpDrateCond dbPrpDrateCond = new DBPrpDrateCond(dbManager);
        //�����¼
        dbPrpDrateCond.insert(prpDrateCondDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param ratePeriod rateperiod
     * @param condCode condcode
     * @param valueCode valuecode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,int ratePeriod,String condCode,String valueCode) throws Exception{
        DBPrpDrateCond dbPrpDrateCond = new DBPrpDrateCond(dbManager);
        //ɾ����¼
        dbPrpDrateCond.delete(riskCode, ratePeriod, condCode, valueCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDrateCond dbPrpDrateCond = new DBPrpDrateCond(dbManager);
        //������ɾ����¼
        dbPrpDrateCond.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDrateCondDto prpDrateCondDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDrateCondDto prpDrateCondDto) throws Exception{
        DBPrpDrateCond dbPrpDrateCond = new DBPrpDrateCond(dbManager);
        //���¼�¼
        dbPrpDrateCond.update(prpDrateCondDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param ratePeriod rateperiod
     * @param condCode condcode
     * @param valueCode valuecode
     * @return prpDrateCondDto prpDrateCondDto
     * @throws Exception
     */
    public PrpDrateCondDto findByPrimaryKey(DBManager dbManager,String riskCode,int ratePeriod,String condCode,String valueCode) throws Exception{
        DBPrpDrateCond dbPrpDrateCond = new DBPrpDrateCond(dbManager);
        //����DTO
        PrpDrateCondDto prpDrateCondDto = null;
        //��ѯ����,��ֵ��DTO
        prpDrateCondDto = dbPrpDrateCond.findByPrimaryKey(riskCode, ratePeriod, condCode, valueCode);
        return prpDrateCondDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDrateCondDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDrateCond dbPrpDrateCond = new DBPrpDrateCond(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDrateCond.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDrateCond.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDrateCondDto�ļ���
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
        DBPrpDrateCond dbPrpDrateCond = new DBPrpDrateCond(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDrateCond.getCount(conditions);
        return count;
    }
}