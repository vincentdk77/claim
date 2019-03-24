package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCcarDeviceDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCcarDevice;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpccardeviceͶ�������������豸��Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCcarDeviceActionBase{
    private static Log log = LogFactory.getLog(BLPrpCcarDeviceActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCcarDeviceActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCcarDeviceDto prpCcarDeviceDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCcarDeviceDto prpCcarDeviceDto) throws Exception{
        DBPrpCcarDevice dbPrpCcarDevice = new DBPrpCcarDevice(dbManager);
        //�����¼
        dbPrpCcarDevice.insert(prpCcarDeviceDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ���յ�����
     * @param serialNo ˳���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCcarDevice dbPrpCcarDevice = new DBPrpCcarDevice(dbManager);
        //ɾ����¼
        dbPrpCcarDevice.delete(policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCcarDevice dbPrpCcarDevice = new DBPrpCcarDevice(dbManager);
        //������ɾ����¼
        dbPrpCcarDevice.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCcarDeviceDto prpCcarDeviceDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCcarDeviceDto prpCcarDeviceDto) throws Exception{
        DBPrpCcarDevice dbPrpCcarDevice = new DBPrpCcarDevice(dbManager);
        //���¼�¼
        dbPrpCcarDevice.update(prpCcarDeviceDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ���յ�����
     * @param serialNo ˳���
     * @return prpCcarDeviceDto prpCcarDeviceDto
     * @throws Exception
     */
    public PrpCcarDeviceDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCcarDevice dbPrpCcarDevice = new DBPrpCcarDevice(dbManager);
        //����DTO
        PrpCcarDeviceDto prpCcarDeviceDto = null;
        //��ѯ����,��ֵ��DTO
        prpCcarDeviceDto = dbPrpCcarDevice.findByPrimaryKey(policyNo, serialNo);
        return prpCcarDeviceDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCcarDeviceDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCcarDevice dbPrpCcarDevice = new DBPrpCcarDevice(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCcarDevice.getCount(conditions);
        collection = dbPrpCcarDevice.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCcarDevice dbPrpCcarDevice = new DBPrpCcarDevice(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCcarDevice.getCount(conditions);
        return count;
    }
}
