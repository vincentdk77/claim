package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompePayFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCompePayFee;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǽ�������������Ϣ��ҵ���߼�������<br>
 */
public class BLPrpLinterCompePayFeeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompePayFeeActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCompePayFeeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterCompePayFeeDto prpLinterCompePayFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCompePayFeeDto prpLinterCompePayFeeDto)
            throws Exception{
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        //�����¼
        dbPrpLinterCompePayFee.insert(prpLinterCompePayFeeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����pk
     * @param serialNo �������pk
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        //ɾ����¼
        dbPrpLinterCompePayFee.delete(id, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        //������ɾ����¼
        dbPrpLinterCompePayFee.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterCompePayFeeDto prpLinterCompePayFeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterCompePayFeeDto prpLinterCompePayFeeDto)
            throws Exception{
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        //���¼�¼
        dbPrpLinterCompePayFee.update(prpLinterCompePayFeeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����pk
     * @param serialNo �������pk
     * @return prpLinterCompePayFeeDto prpLinterCompePayFeeDto
     * @throws Exception
     */
    public PrpLinterCompePayFeeDto findByPrimaryKey(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        //����DTO
        PrpLinterCompePayFeeDto prpLinterCompePayFeeDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterCompePayFeeDto = dbPrpLinterCompePayFee.findByPrimaryKey(id, serialNo);
        return prpLinterCompePayFeeDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCompePayFee.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterCompePayFee.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterCompePayFeeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterCompePayFee.findByConditions(conditions);
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
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCompePayFee.getCount(conditions);
        return count;
    }
}
