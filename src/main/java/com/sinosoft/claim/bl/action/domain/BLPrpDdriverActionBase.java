package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDdriverDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDdriver;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpddriver��������˾��������ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDdriverActionBase{
    private static Log log = LogFactory.getLog(BLPrpDdriverActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDdriverActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDdriverDto prpDdriverDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDdriverDto prpDdriverDto) throws Exception{
        DBPrpDdriver dbPrpDdriver = new DBPrpDdriver(dbManager);
        //�����¼
        dbPrpDdriver.insert(prpDdriverDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param drivingLicenseNo ��ʻԱ��ʻ֤����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String drivingLicenseNo) throws Exception{
        DBPrpDdriver dbPrpDdriver = new DBPrpDdriver(dbManager);
        //ɾ����¼
        dbPrpDdriver.delete(drivingLicenseNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDdriver dbPrpDdriver = new DBPrpDdriver(dbManager);
        //������ɾ����¼
        dbPrpDdriver.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDdriverDto prpDdriverDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDdriverDto prpDdriverDto) throws Exception{
        DBPrpDdriver dbPrpDdriver = new DBPrpDdriver(dbManager);
        //���¼�¼
        dbPrpDdriver.update(prpDdriverDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param drivingLicenseNo ��ʻԱ��ʻ֤����
     * @return prpDdriverDto prpDdriverDto
     * @throws Exception
     */
    public PrpDdriverDto findByPrimaryKey(DBManager dbManager,String drivingLicenseNo) throws Exception{
        DBPrpDdriver dbPrpDdriver = new DBPrpDdriver(dbManager);
        //����DTO
        PrpDdriverDto prpDdriverDto = null;
        //��ѯ����,��ֵ��DTO
        prpDdriverDto = dbPrpDdriver.findByPrimaryKey(drivingLicenseNo);
        return prpDdriverDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDdriverDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDdriver dbPrpDdriver = new DBPrpDdriver(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDdriver.getCount(conditions);
        collection = dbPrpDdriver.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDdriver dbPrpDdriver = new DBPrpDdriver(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDdriver.getCount(conditions);
        return count;
    }
}
