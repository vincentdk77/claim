package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCshipDriverDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCshipDriver;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcshipdriver�����մ�Ա��Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCshipDriverActionBase{
    private static Log log = LogFactory.getLog(BLPrpCshipDriverActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCshipDriverActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCshipDriverDto prpCshipDriverDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCshipDriverDto prpCshipDriverDto) throws Exception{
        DBPrpCshipDriver dbPrpCshipDriver = new DBPrpCshipDriver(dbManager);
        //�����¼
        dbPrpCshipDriver.insert(prpCshipDriverDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo Ͷ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCshipDriver dbPrpCshipDriver = new DBPrpCshipDriver(dbManager);
        //ɾ����¼
        dbPrpCshipDriver.delete(policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCshipDriver dbPrpCshipDriver = new DBPrpCshipDriver(dbManager);
        //������ɾ����¼
        dbPrpCshipDriver.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCshipDriverDto prpCshipDriverDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCshipDriverDto prpCshipDriverDto) throws Exception{
        DBPrpCshipDriver dbPrpCshipDriver = new DBPrpCshipDriver(dbManager);
        //���¼�¼
        dbPrpCshipDriver.update(prpCshipDriverDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo Ͷ��������
     * @param serialNo ���
     * @return prpCshipDriverDto prpCshipDriverDto
     * @throws Exception
     */
    public PrpCshipDriverDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCshipDriver dbPrpCshipDriver = new DBPrpCshipDriver(dbManager);
        //����DTO
        PrpCshipDriverDto prpCshipDriverDto = null;
        //��ѯ����,��ֵ��DTO
        prpCshipDriverDto = dbPrpCshipDriver.findByPrimaryKey(policyNo, serialNo);
        return prpCshipDriverDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCshipDriverDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCshipDriver dbPrpCshipDriver = new DBPrpCshipDriver(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCshipDriver.getCount(conditions);
        collection = dbPrpCshipDriver.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCshipDriver dbPrpCshipDriver = new DBPrpCshipDriver(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCshipDriver.getCount(conditions);
        return count;
    }
}
