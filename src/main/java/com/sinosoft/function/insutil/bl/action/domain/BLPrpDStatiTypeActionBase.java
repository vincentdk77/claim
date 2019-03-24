package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDStatiTypeDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDStatiType;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdstatitype��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDStatiTypeActionBase{
    private static Log log = LogFactory.getLog(BLPrpDStatiTypeActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDStatiTypeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDStatiTypeDto prpDStatiTypeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDStatiTypeDto prpDStatiTypeDto) throws Exception{
        DBPrpDStatiType dbPrpDStatiType = new DBPrpDStatiType(dbManager);
        //�����¼
        dbPrpDStatiType.insert(prpDStatiTypeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param kindCode kindcode
     * @param belongType belongtype
     * @param validDate validdate
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String kindCode,String belongType,DateTime validDate) throws Exception{
        DBPrpDStatiType dbPrpDStatiType = new DBPrpDStatiType(dbManager);
        //ɾ����¼
        dbPrpDStatiType.delete(riskCode, kindCode, belongType, validDate);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDStatiType dbPrpDStatiType = new DBPrpDStatiType(dbManager);
        //������ɾ����¼
        dbPrpDStatiType.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDStatiTypeDto prpDStatiTypeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDStatiTypeDto prpDStatiTypeDto) throws Exception{
        DBPrpDStatiType dbPrpDStatiType = new DBPrpDStatiType(dbManager);
        //���¼�¼
        dbPrpDStatiType.update(prpDStatiTypeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param kindCode kindcode
     * @param belongType belongtype
     * @param validDate validdate
     * @return prpDStatiTypeDto prpDStatiTypeDto
     * @throws Exception
     */
    public PrpDStatiTypeDto findByPrimaryKey(DBManager dbManager,String riskCode,String kindCode,String belongType,DateTime validDate) throws Exception{
        DBPrpDStatiType dbPrpDStatiType = new DBPrpDStatiType(dbManager);
        //����DTO
        PrpDStatiTypeDto prpDStatiTypeDto = null;
        //��ѯ����,��ֵ��DTO
        prpDStatiTypeDto = dbPrpDStatiType.findByPrimaryKey(riskCode, kindCode, belongType, validDate);
        return prpDStatiTypeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDStatiTypeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDStatiType dbPrpDStatiType = new DBPrpDStatiType(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDStatiType.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDStatiType.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDStatiTypeDto�ļ���
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
        DBPrpDStatiType dbPrpDStatiType = new DBPrpDStatiType(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDStatiType.getCount(conditions);
        return count;
    }
}
