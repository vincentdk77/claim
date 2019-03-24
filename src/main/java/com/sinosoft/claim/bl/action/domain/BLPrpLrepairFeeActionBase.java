package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrepairFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrepairFee;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLrepairFee-��������嵥(�޸�)��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.093<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLrepairFeeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLrepairFeeActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLrepairFeeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLrepairFeeDto prpLrepairFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLrepairFeeDto prpLrepairFeeDto) throws Exception{
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);
        //�����¼
        dbPrpLrepairFee.insert(prpLrepairFeeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param serialNo ���
     * @param registNo ��������
     * @param lossItemCode ��Ĵ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,int serialNo,String registNo,String lossItemCode) throws Exception{
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);
        //ɾ����¼
        dbPrpLrepairFee.delete(serialNo, registNo, lossItemCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);
        //������ɾ����¼
        dbPrpLrepairFee.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLrepairFeeDto prpLrepairFeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLrepairFeeDto prpLrepairFeeDto) throws Exception{
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);
        //���¼�¼
        dbPrpLrepairFee.update(prpLrepairFeeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param serialNo ���
     * @param registNo ��������
     * @param lossItemCode ��Ĵ���
     * @return prpLrepairFeeDto prpLrepairFeeDto
     * @throws Exception
     */
    public PrpLrepairFeeDto findByPrimaryKey(DBManager dbManager,int serialNo,String registNo,String lossItemCode) throws Exception{
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);
        //����DTO
        PrpLrepairFeeDto prpLrepairFeeDto = null;
        //��ѯ����,��ֵ��DTO
        prpLrepairFeeDto = dbPrpLrepairFee.findByPrimaryKey(serialNo, registNo, lossItemCode);
        return prpLrepairFeeDto;
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
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLrepairFee.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLrepairFee.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLrepairFeeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLrepairFee.findByConditions(conditions);
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
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLrepairFee.getCount(conditions);
        return count;
    }
}
