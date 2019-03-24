package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLCItemCarDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLCItemCar;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLCItemCar-���Ᵽ�����������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLCItemCarActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLCItemCarActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLCItemCarActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLCItemCarDto prpLCItemCarDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLCItemCarDto prpLCItemCarDto) throws Exception{
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);
        //�����¼
        dbPrpLCItemCar.insert(prpLCItemCarDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param policyNo ��������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String policyNo) throws Exception{
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);
        //ɾ����¼
        dbPrpLCItemCar.delete(registNo, policyNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);
        //������ɾ����¼
        dbPrpLCItemCar.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLCItemCarDto prpLCItemCarDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLCItemCarDto prpLCItemCarDto) throws Exception{
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);
        //���¼�¼
        dbPrpLCItemCar.update(prpLCItemCarDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param policyNo ��������
     * @return prpLCItemCarDto prpLCItemCarDto
     * @throws Exception
     */
    public PrpLCItemCarDto findByPrimaryKey(DBManager dbManager,String registNo,String policyNo) throws Exception{
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);
        //����DTO
        PrpLCItemCarDto prpLCItemCarDto = null;
        //��ѯ����,��ֵ��DTO
        prpLCItemCarDto = dbPrpLCItemCar.findByPrimaryKey(registNo, policyNo);
        return prpLCItemCarDto;
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
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLCItemCar.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLCItemCar.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLCItemCarDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLCItemCar.findByConditions(conditions);
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
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLCItemCar.getCount(conditions);
        return count;
    }
}
