package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDrateDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDrate;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrate��׼���ʱ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrateActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrateActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

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
     * @param serialNo ���
     * @param riskCode ���ִ���
     * @param rateCode ���ʴ���
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
     * @param serialNo ���
     * @param riskCode ���ִ���
     * @param rateCode ���ʴ���
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

        rowCount = dbPrpDrate.getCount(conditions);
        collection = dbPrpDrate.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDrate dbPrpDrate = new DBPrpDrate(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDrate.getCount(conditions);
        return count;
    }
}
