package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCitemCar;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcitem_car�������ձ����Ϣ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCitemCarActionBase{
    private static Log log = LogFactory.getLog(BLPrpCitemCarActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCitemCarActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param PrpCitemCarDto PrpCitemCarDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCitemCarDto PrpCitemCarDto) throws Exception{
        DBPrpCitemCar dbPrpCitemCar = new DBPrpCitemCar(dbManager);
        //�����¼
        dbPrpCitemCar.insert(PrpCitemCarDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param itemNo ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int itemNo) throws Exception{
        DBPrpCitemCar dbPrpCitemCar = new DBPrpCitemCar(dbManager);
        //ɾ����¼
        dbPrpCitemCar.delete(policyNo, itemNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCitemCar dbPrpCitemCar = new DBPrpCitemCar(dbManager);
        //������ɾ����¼
        dbPrpCitemCar.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param PrpCitemCarDto PrpCitemCarDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCitemCarDto PrpCitemCarDto) throws Exception{
        DBPrpCitemCar dbPrpCitemCar = new DBPrpCitemCar(dbManager);
        //���¼�¼
        dbPrpCitemCar.update(PrpCitemCarDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param itemNo ������
     * @return PrpCitemCarDto PrpCitemCarDto
     * @throws Exception
     */
    public PrpCitemCarDto findByPrimaryKey(DBManager dbManager,String policyNo,int itemNo) throws Exception{
        DBPrpCitemCar dbPrpCitemCar = new DBPrpCitemCar(dbManager);
        //����DTO
        PrpCitemCarDto PrpCitemCarDto = null;
        //��ѯ����,��ֵ��DTO
        PrpCitemCarDto = dbPrpCitemCar.findByPrimaryKey(policyNo, itemNo);
        return PrpCitemCarDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����PrpCitemCarDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCitemCar dbPrpCitemCar = new DBPrpCitemCar(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCitemCar.getCount(conditions);
        collection = dbPrpCitemCar.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCitemCar dbPrpCitemCar = new DBPrpCitemCar(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCitemCar.getCount(conditions);
        return count;
    }
}
