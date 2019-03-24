package com.sinosoft.function.power.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpDriskDto;
import com.sinosoft.function.power.resource.dtofactory.domain.DBPrpDrisk;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDrisk���ִ�����ҵ���߼�������<br>
 * ������ 2004-11-09 10:40:54.669<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDriskActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDriskActionBase.class);

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
     * @param riskCode ���ִ���
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
     * @param conditions ɾ������
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
     * @param riskCode ���ִ���
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
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDrisk.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDrisk.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDriskDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpDrisk.findByConditions(conditions);
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
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
