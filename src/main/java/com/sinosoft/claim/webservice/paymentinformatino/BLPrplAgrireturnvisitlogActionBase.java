package com.sinosoft.claim.webservice.paymentinformatino;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitswflogActionBase;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflog;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PRPLAGRIRETURNVISITLOG��ҵ���߼�������
 * @author Administrator
 *
 */
public class BLPrplAgrireturnvisitlogActionBase {
	private static Logger logger = Logger.getLogger(BLPrplAgrireturnvisitlogActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplAgrireturnvisitlogActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param PrplAgrireturnvisitlogDto PrplAgrireturnvisitlogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplAgrireturnvisitlogDto prplagrireturnvisitlogDto)
            throws Exception{
        DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        //�����¼
        dbPrplagrireturnvisitlog.insert(prplagrireturnvisitlogDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param businessno BUSINESSNO
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessno)
            throws Exception{
    	DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        //ɾ����¼
    	dbPrplagrireturnvisitlog.delete(businessno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        //������ɾ����¼
    	dbPrplagrireturnvisitlog.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param PrplAgrireturnvisitlogDto PrplAgrireturnvisitlogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplAgrireturnvisitlogDto prplagrireturnvisitlogDto)
            throws Exception{
    	DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        //���¼�¼
    	dbPrplagrireturnvisitlog.update(prplagrireturnvisitlogDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param businessno BUSINESSNO
     * @param nodetype NODETYPE
     * @return prplagrireturnvisitlogDto prplagrireturnvisitlogDto
     * @throws Exception
     */
    public PrplAgrireturnvisitlogDto findByPrimaryKey(DBManager dbManager,String businessno)
            throws Exception{
    	DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        //����DTO
    	PrplAgrireturnvisitlogDto prplagrireturnvisitlogDto = null;
        //��ѯ����,��ֵ��DTO
    	prplagrireturnvisitlogDto = dbPrplagrireturnvisitlog.findByPrimaryKey(businessno);
        return prplagrireturnvisitlogDto;
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
    	DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplagrireturnvisitlog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplagrireturnvisitlog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����PrplAgrireturnvisitlogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplagrireturnvisitlog.findByConditions(conditions);
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
    	DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplagrireturnvisitlog.getCount(conditions);
        return count;
    }
}
