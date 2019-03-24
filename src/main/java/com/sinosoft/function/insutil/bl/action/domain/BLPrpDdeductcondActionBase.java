package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDdeductcondDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDdeductcond;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpddeductcond��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDdeductcondActionBase{
    private static Log log = LogFactory.getLog(BLPrpDdeductcondActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDdeductcondActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDdeductcondDto prpDdeductcondDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDdeductcondDto prpDdeductcondDto) throws Exception{
        DBPrpDdeductcond dbPrpDdeductcond = new DBPrpDdeductcond(dbManager);
        //�����¼
        dbPrpDdeductcond.insert(prpDdeductcondDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param clauseType clausetype
     * @param kindCode kindcode
     * @param deductCondCode deductcondcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String clauseType,String kindCode,String deductCondCode) throws Exception{
        DBPrpDdeductcond dbPrpDdeductcond = new DBPrpDdeductcond(dbManager);
        //ɾ����¼
        dbPrpDdeductcond.delete(riskCode, clauseType, kindCode, deductCondCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDdeductcond dbPrpDdeductcond = new DBPrpDdeductcond(dbManager);
        //������ɾ����¼
        dbPrpDdeductcond.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDdeductcondDto prpDdeductcondDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDdeductcondDto prpDdeductcondDto) throws Exception{
        DBPrpDdeductcond dbPrpDdeductcond = new DBPrpDdeductcond(dbManager);
        //���¼�¼
        dbPrpDdeductcond.update(prpDdeductcondDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param clauseType clausetype
     * @param kindCode kindcode
     * @param deductCondCode deductcondcode
     * @return prpDdeductcondDto prpDdeductcondDto
     * @throws Exception
     */
    public PrpDdeductcondDto findByPrimaryKey(DBManager dbManager,String riskCode,String clauseType,String kindCode,String deductCondCode) throws Exception{
        DBPrpDdeductcond dbPrpDdeductcond = new DBPrpDdeductcond(dbManager);
        //����DTO
        PrpDdeductcondDto prpDdeductcondDto = null;
        //��ѯ����,��ֵ��DTO
        prpDdeductcondDto = dbPrpDdeductcond.findByPrimaryKey(riskCode, clauseType, kindCode, deductCondCode);
        return prpDdeductcondDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDdeductcondDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDdeductcond dbPrpDdeductcond = new DBPrpDdeductcond(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDdeductcond.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDdeductcond.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDdeductcondDto�ļ���
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
        DBPrpDdeductcond dbPrpDdeductcond = new DBPrpDdeductcond(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDdeductcond.getCount(conditions);
        return count;
    }
}
