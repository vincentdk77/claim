package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrateDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDrate;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrate��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrateActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrateActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDrateActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDrateDto prpDrateDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDrateDto prpDrateDto) throws Exception{
        DBPrpDrate dbPrpDrate = new DBPrpDrate(dbManager);
        //�����¼
        dbPrpDrate.insert(prpDrateDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param serialNo serialno
     * @param riskCode riskcode
     * @param rateCode ratecode
     * @throws Exception
     */
    public void delete(DBManager dbManager,int serialNo,String riskCode,String rateCode) throws Exception{
        DBPrpDrate dbPrpDrate = new DBPrpDrate(dbManager);
        //ɾ����¼
        dbPrpDrate.delete(serialNo, riskCode, rateCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDrate dbPrpDrate = new DBPrpDrate(dbManager);
        //������ɾ����¼
        dbPrpDrate.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDrateDto prpDrateDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDrateDto prpDrateDto) throws Exception{
        DBPrpDrate dbPrpDrate = new DBPrpDrate(dbManager);
        //���¼�¼
        dbPrpDrate.update(prpDrateDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param serialNo serialno
     * @param riskCode riskcode
     * @param rateCode ratecode
     * @return prpDrateDto prpDrateDto
     * @throws Exception
     */
    public PrpDrateDto findByPrimaryKey(DBManager dbManager,int serialNo,String riskCode,String rateCode) throws Exception{
        DBPrpDrate dbPrpDrate = new DBPrpDrate(dbManager);
        //����DTO
        PrpDrateDto prpDrateDto = null;
        //��ѯ����,��ֵ��DTO
        prpDrateDto = dbPrpDrate.findByPrimaryKey(serialNo, riskCode, rateCode);
        return prpDrateDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDrateDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDrate dbPrpDrate = new DBPrpDrate(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDrate.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDrate.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDrateDto�ļ���
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
        DBPrpDrate dbPrpDrate = new DBPrpDrate(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDrate.getCount(conditions);
        return count;
    }
}
