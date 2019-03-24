package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcompensatehousetgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcompensatehousetg;
import java.math.*;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLCOMPENSATEHOUSE��ҵ���߼�������<br>
 */
public class BLPrplcompensatehousetgActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensatehousetgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplcompensatehousetgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplcompensatehousetgDto prplcompensatehousetgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplcompensatehousetgDto prplcompensatehousetgDto)
            throws Exception{
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
        //�����¼
        DBPrplcompensatehousetg.insert(prplcompensatehousetgDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param idcard IDCARD
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @param businessno BUSINESSNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String idcard,String registno,String nodetype,String businessno)
            throws Exception{
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
        //ɾ����¼
        DBPrplcompensatehousetg.delete(idcard, registno, nodetype, businessno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
        //������ɾ����¼
        DBPrplcompensatehousetg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplcompensatehousetgDto prplcompensatehousetgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplcompensatehousetgDto prplcompensatehousetgDto)
            throws Exception{
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
        //���¼�¼
        DBPrplcompensatehousetg.update(prplcompensatehousetgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param idcard IDCARD
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @param businessno BUSINESSNO
     * @return prplcompensatehousetgDto prplcompensatehousetgDto
     * @throws Exception
     */
    public PrplcompensatehousetgDto findByPrimaryKey(DBManager dbManager,String idcard,String registno,String nodetype,String businessno)
            throws Exception{
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
        //����DTO
        PrplcompensatehousetgDto prplcompensatehousetgDto = null;
        //��ѯ����,��ֵ��DTO
        prplcompensatehousetgDto = DBPrplcompensatehousetg.findByPrimaryKey(idcard, registno, nodetype, businessno);
        return prplcompensatehousetgDto;
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
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = DBPrplcompensatehousetg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = DBPrplcompensatehousetg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplcompensatehousetgDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = DBPrplcompensatehousetg.findByConditions(conditions);
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
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = DBPrplcompensatehousetg.getCount(conditions);
        return count;
    }
    
    public BigDecimal getSumCompensate(DBManager dbManager,String idcard,String policyno) 
    throws Exception{
    DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
    BigDecimal sum = DBPrplcompensatehousetg.getSumCompensate(idcard,policyno);
    return sum;
}
    
    
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getInprocessCount(DBManager dbManager,String policyno,String idcard) 
        throws Exception{
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);

        int count = DBPrplcompensatehousetg.getInprocessCount(policyno,idcard);
        return count;
    }
}
