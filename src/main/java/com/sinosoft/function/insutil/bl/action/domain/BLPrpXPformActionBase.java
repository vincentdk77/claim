package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpXPformDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpXPform;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpxpform��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpXPformActionBase{
    private static Log log = LogFactory.getLog(BLPrpXPformActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpXPformActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpXPformDto prpXPformDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpXPformDto prpXPformDto) throws Exception{
        DBPrpXPform dbPrpXPform = new DBPrpXPform(dbManager);
        //�����¼
        dbPrpXPform.insert(prpXPformDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param endorType endortype
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String endorType) throws Exception{
        DBPrpXPform dbPrpXPform = new DBPrpXPform(dbManager);
        //ɾ����¼
        dbPrpXPform.delete(riskCode, endorType);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpXPform dbPrpXPform = new DBPrpXPform(dbManager);
        //������ɾ����¼
        dbPrpXPform.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpXPformDto prpXPformDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpXPformDto prpXPformDto) throws Exception{
        DBPrpXPform dbPrpXPform = new DBPrpXPform(dbManager);
        //���¼�¼
        dbPrpXPform.update(prpXPformDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param endorType endortype
     * @return prpXPformDto prpXPformDto
     * @throws Exception
     */
    public PrpXPformDto findByPrimaryKey(DBManager dbManager,String riskCode,String endorType) throws Exception{
        DBPrpXPform dbPrpXPform = new DBPrpXPform(dbManager);
        //����DTO
        PrpXPformDto prpXPformDto = null;
        //��ѯ����,��ֵ��DTO
        prpXPformDto = dbPrpXPform.findByPrimaryKey(riskCode, endorType);
        return prpXPformDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpXPformDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpXPform dbPrpXPform = new DBPrpXPform(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpXPform.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpXPform.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpXPformDto�ļ���
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
        DBPrpXPform dbPrpXPform = new DBPrpXPform(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpXPform.getCount(conditions);
        return count;
    }
}
