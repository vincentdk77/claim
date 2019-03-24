package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpClimitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpClimit;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpClimit��ҵ���߼�������<br>
 * ������ 2006-06-09 15:31:32.937<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpClimitActionBase{
    private static Log logger = LogFactory.getLog(BLPrpClimitActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpClimitActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpClimitDto prpClimitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpClimitDto prpClimitDto) throws Exception{
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);
        //�����¼
        dbPrpClimit.insert(prpClimitDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo PolicyNo
     * @param limitGrade LimitGrade
     * @param limitNo LimitNo
     * @param limitType LimitType
     * @param currency Currency
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,String limitGrade,double limitNo,String limitType,String currency) throws Exception{
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);
        //ɾ����¼
        dbPrpClimit.delete(policyNo, limitGrade, limitNo, limitType, currency);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);
        //������ɾ����¼
        dbPrpClimit.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpClimitDto prpClimitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpClimitDto prpClimitDto) throws Exception{
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);
        //���¼�¼
        dbPrpClimit.update(prpClimitDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo PolicyNo
     * @param limitGrade LimitGrade
     * @param limitNo LimitNo
     * @param limitType LimitType
     * @param currency Currency
     * @return prpClimitDto prpClimitDto
     * @throws Exception
     */
    public PrpClimitDto findByPrimaryKey(DBManager dbManager,String policyNo,String limitGrade,double limitNo,String limitType,String currency) throws Exception{
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);
        //����DTO
        PrpClimitDto prpClimitDto = null;
        //��ѯ����,��ֵ��DTO
        prpClimitDto = dbPrpClimit.findByPrimaryKey(policyNo, limitGrade, limitNo, limitType, currency);
        return prpClimitDto;
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
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpClimit.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpClimit.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpClimitDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpClimit.findByConditions(conditions);
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
        DBPrpClimit dbPrpClimit = new DBPrpClimit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpClimit.getCount(conditions);
        return count;
    }
}
