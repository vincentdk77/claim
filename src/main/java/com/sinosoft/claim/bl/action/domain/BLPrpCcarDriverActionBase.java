package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCcarDriverDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCcarDriver;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpccardriver������ʻԱ��ϵ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCcarDriverActionBase{
    private static Log log = LogFactory.getLog(BLPrpCcarDriverActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCcarDriverActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCcarDriverDto prpCcarDriverDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCcarDriverDto prpCcarDriverDto) throws Exception{
        DBPrpCcarDriver dbPrpCcarDriver = new DBPrpCcarDriver(dbManager);
        //�����¼
        dbPrpCcarDriver.insert(prpCcarDriverDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ˳���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCcarDriver dbPrpCcarDriver = new DBPrpCcarDriver(dbManager);
        //ɾ����¼
        dbPrpCcarDriver.delete(policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCcarDriver dbPrpCcarDriver = new DBPrpCcarDriver(dbManager);
        //������ɾ����¼
        dbPrpCcarDriver.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCcarDriverDto prpCcarDriverDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCcarDriverDto prpCcarDriverDto) throws Exception{
        DBPrpCcarDriver dbPrpCcarDriver = new DBPrpCcarDriver(dbManager);
        //���¼�¼
        dbPrpCcarDriver.update(prpCcarDriverDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ˳���
     * @return prpCcarDriverDto prpCcarDriverDto
     * @throws Exception
     */
    public PrpCcarDriverDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCcarDriver dbPrpCcarDriver = new DBPrpCcarDriver(dbManager);
        //����DTO
        PrpCcarDriverDto prpCcarDriverDto = null;
        //��ѯ����,��ֵ��DTO
        prpCcarDriverDto = dbPrpCcarDriver.findByPrimaryKey(policyNo, serialNo);
        return prpCcarDriverDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCcarDriverDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCcarDriver dbPrpCcarDriver = new DBPrpCcarDriver(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCcarDriver.getCount(conditions);
        collection = dbPrpCcarDriver.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpCcarDriver dbPrpCcarDriver = new DBPrpCcarDriver(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCcarDriver.getCount(conditions);
        return count;
    }
}
