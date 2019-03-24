package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcompensate;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcompensate-����������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:37.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcompensateActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcompensateActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcompensateActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcompensateDto prpLcompensateDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcompensateDto prpLcompensateDto) throws Exception{
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
        //�����¼
        dbPrpLcompensate.insert(prpLcompensateDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param compensateNo �����������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo) throws Exception{
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
        //ɾ����¼
        dbPrpLcompensate.delete(compensateNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
        //������ɾ����¼
        dbPrpLcompensate.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcompensateDto prpLcompensateDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcompensateDto prpLcompensateDto) throws Exception{
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
        //���¼�¼
        dbPrpLcompensate.update(prpLcompensateDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param compensateNo �����������
     * @return prpLcompensateDto prpLcompensateDto
     * @throws Exception
     */
    public PrpLcompensateDto findByPrimaryKey(DBManager dbManager,String compensateNo) throws Exception{
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
        //����DTO
        PrpLcompensateDto prpLcompensateDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcompensateDto = dbPrpLcompensate.findByPrimaryKey(compensateNo);
        return prpLcompensateDto;
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
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcompensate.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcompensate.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcompensateDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcompensate.findByConditions(conditions);
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
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcompensate.getCount(conditions);
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
		DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);
		Collection collection = new ArrayList();
		
		collection = dbPrpLcompensate.findByConditionsForNXDA(conditions, pageNo, rowsPerPage);
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
        DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);

        int count = dbPrpLcompensate.getCountForNXDA(conditions);
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
    	DBPrpLcompensate dbPrpLcompensate = new DBPrpLcompensate(dbManager);

    	double count = dbPrpLcompensate.getSumSettleAreaForNXDA(conditions);
        return count;
	}
}
