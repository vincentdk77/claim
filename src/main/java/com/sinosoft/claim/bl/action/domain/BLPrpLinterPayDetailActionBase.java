package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayDetail;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǽ�����Ϣ������------�켣���ҵ���߼�������<br>
 */
public class BLPrpLinterPayDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayDetailActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPayDetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterPayDetailDto prpLinterPayDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPayDetailDto prpLinterPayDetailDto)
            throws Exception{
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
        //�����¼
        dbPrpLinterPayDetail.insert(prpLinterPayDetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����pk
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
        //ɾ����¼
        dbPrpLinterPayDetail.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
        //������ɾ����¼
        dbPrpLinterPayDetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterPayDetailDto prpLinterPayDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterPayDetailDto prpLinterPayDetailDto)
            throws Exception{
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
        //���¼�¼
        dbPrpLinterPayDetail.update(prpLinterPayDetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����pk
     * @return prpLinterPayDetailDto prpLinterPayDetailDto
     * @throws Exception
     */
    public PrpLinterPayDetailDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
        //����DTO
        PrpLinterPayDetailDto prpLinterPayDetailDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterPayDetailDto = dbPrpLinterPayDetail.findByPrimaryKey(id);
        return prpLinterPayDetailDto;
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
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPayDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterPayDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterPayDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterPayDetail.findByConditions(conditions);
        return collection;
    }
    
    public Collection findByAllOutId(DBManager dbManager,String conditions)
    throws Exception{
		DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);
		Collection collection = new ArrayList();
		
		if(conditions.trim().length()==0){
		    conditions = "1=1";
		}
		
		collection = dbPrpLinterPayDetail.findByAllOutId(conditions);
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
        DBPrpLinterPayDetail dbPrpLinterPayDetail = new DBPrpLinterPayDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPayDetail.getCount(conditions);
        return count;
    }
}
