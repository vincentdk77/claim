package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcompensatetgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcompensatetg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcompensate-����������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:37.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcompensatetgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcompensatetgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcompensatetgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcompensatetgDto prpLcompensatetgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcompensatetgDto prpLcompensatetgDto) throws Exception{
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
        //�����¼
        dbPrpLcompensatetg.insert(prpLcompensatetgDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param compensateNo �����������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo) throws Exception{
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
        //ɾ����¼
        dbPrpLcompensatetg.delete(compensateNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
        //������ɾ����¼
        dbPrpLcompensatetg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcompensatetgDto prpLcompensatetgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcompensatetgDto prpLcompensatetgDto) throws Exception{
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
        //���¼�¼
        dbPrpLcompensatetg.update(prpLcompensatetgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param compensateNo �����������
     * @return prpLcompensatetgDto prpLcompensatetgDto
     * @throws Exception
     */
    public PrpLcompensatetgDto findByPrimaryKey(DBManager dbManager,String compensateNo) throws Exception{
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
        //����DTO
        PrpLcompensatetgDto prpLcompensatetgDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcompensatetgDto = dbPrpLcompensatetg.findByPrimaryKey(compensateNo);
        return prpLcompensatetgDto;
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
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcompensatetg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcompensatetg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcompensatetgDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcompensatetg.findByConditions(conditions);
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
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcompensatetg.getCount(conditions);
        return count;
    }
    
    /**
     * ���������� �����嵥������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����
     * @throws Exception
     */
	public Collection findByConditionsForNXDA(DBManager dbManager,
			String conditions, int pageNo, int rowsPerPage) throws Exception{
		DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);
		Collection collection = new ArrayList();
		
		collection = dbPrpLcompensatetg.findByConditionsForNXDA(conditions, pageNo, rowsPerPage);
        return collection;
        
	}
	/**
     * ��ѯ���������������嵥�ļ�¼��
     * @param dbManager DB������
     * @return ��ѯ���������������嵥�ļ�¼��
     * @throws Exception
     */
    public int getCountForNXDA(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);

        int count = dbPrpLcompensatetg.getCountForNXDA(conditions);
        return count;
    }
    
    /**
     * ��ѯ�����嵥����Ķ��
     * @param conditions conditions
     * @return ��ѯ���������������嵥��Ķ��
     * @throws Exception 
     * @throws Exception
     */
    public double getSumSettleAreaForNXDA(DBManager dbManager, String conditions) throws Exception {
    	DBPrpLcompensatetg dbPrpLcompensatetg = new DBPrpLcompensatetg(dbManager);

    	double count = dbPrpLcompensatetg.getSumSettleAreaForNXDA(conditions);
        return count;
	}
}
