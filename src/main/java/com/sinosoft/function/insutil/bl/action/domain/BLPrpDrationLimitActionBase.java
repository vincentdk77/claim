package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrationLimitDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDrationLimit;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrationlimit��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrationLimitActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrationLimitActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDrationLimitActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDrationLimitDto prpDrationLimitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDrationLimitDto prpDrationLimitDto) throws Exception{
        DBPrpDrationLimit dbPrpDrationLimit = new DBPrpDrationLimit(dbManager);
        //�����¼
        dbPrpDrationLimit.insert(prpDrationLimitDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param limitCode limitcode
     * @param rationType rationtype
     * @param kindCode kindcode
     * @param itemCode itemcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String limitCode,String rationType,String kindCode,String itemCode) throws Exception{
        DBPrpDrationLimit dbPrpDrationLimit = new DBPrpDrationLimit(dbManager);
        //ɾ����¼
        dbPrpDrationLimit.delete(riskCode, limitCode, rationType, kindCode, itemCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDrationLimit dbPrpDrationLimit = new DBPrpDrationLimit(dbManager);
        //������ɾ����¼
        dbPrpDrationLimit.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDrationLimitDto prpDrationLimitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDrationLimitDto prpDrationLimitDto) throws Exception{
        DBPrpDrationLimit dbPrpDrationLimit = new DBPrpDrationLimit(dbManager);
        //���¼�¼
        dbPrpDrationLimit.update(prpDrationLimitDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param limitCode limitcode
     * @param rationType rationtype
     * @param kindCode kindcode
     * @param itemCode itemcode
     * @return prpDrationLimitDto prpDrationLimitDto
     * @throws Exception
     */
    public PrpDrationLimitDto findByPrimaryKey(DBManager dbManager,String riskCode,String limitCode,String rationType,String kindCode,String itemCode) throws Exception{
        DBPrpDrationLimit dbPrpDrationLimit = new DBPrpDrationLimit(dbManager);
        //����DTO
        PrpDrationLimitDto prpDrationLimitDto = null;
        //��ѯ����,��ֵ��DTO
        prpDrationLimitDto = dbPrpDrationLimit.findByPrimaryKey(riskCode, limitCode, rationType, kindCode, itemCode);
        return prpDrationLimitDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDrationLimitDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDrationLimit dbPrpDrationLimit = new DBPrpDrationLimit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDrationLimit.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDrationLimit.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDrationLimitDto�ļ���
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
        DBPrpDrationLimit dbPrpDrationLimit = new DBPrpDrationLimit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDrationLimit.getCount(conditions);
        return count;
    }
}
