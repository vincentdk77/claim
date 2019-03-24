package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDriskDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDrisk;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrisk��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDriskActionBase{
    private static Log log = LogFactory.getLog(BLPrpDriskActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDriskActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDriskDto prpDriskDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDriskDto prpDriskDto) throws Exception{
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);
        //�����¼
        dbPrpDrisk.insert(prpDriskDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode) throws Exception{
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);
        //ɾ����¼
        dbPrpDrisk.delete(riskCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);
        //������ɾ����¼
        dbPrpDrisk.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDriskDto prpDriskDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDriskDto prpDriskDto) throws Exception{
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);
        //���¼�¼
        dbPrpDrisk.update(prpDriskDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @return prpDriskDto prpDriskDto
     * @throws Exception
     */
    public PrpDriskDto findByPrimaryKey(DBManager dbManager,String riskCode) throws Exception{
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);
        //����DTO
        PrpDriskDto prpDriskDto = null;
        //��ѯ����,��ֵ��DTO
        prpDriskDto = dbPrpDrisk.findByPrimaryKey(riskCode);
        return prpDriskDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDriskDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDrisk.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDrisk.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDriskDto�ļ���
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
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDrisk.getCount(conditions);
        return count;
    }
}
