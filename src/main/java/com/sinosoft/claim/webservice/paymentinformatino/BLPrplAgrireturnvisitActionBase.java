package com.sinosoft.claim.webservice.paymentinformatino;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitActionBase;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisit;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PRPLAGRIRETURNVISIT��ҵ���߼�������
 * @author Administrator
 *
 */
public class BLPrplAgrireturnvisitActionBase {
	private static Logger logger = Logger.getLogger(BLPrplAgrireturnvisitActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplAgrireturnvisitActionBase(){
    }
    
    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplagrireturnvisitDto prplagrireturnvisitDto)
            throws Exception{
        DBPrplAgrireturnvisit dbPrplAgrireturnvisit = new DBPrplAgrireturnvisit(dbManager);
        //�����¼
        dbPrplAgrireturnvisit.insert(prplagrireturnvisitDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registno,String serialno)
            throws Exception{
    	DBPrplAgrireturnvisit dbPrplAgrireturnvisit = new DBPrplAgrireturnvisit(dbManager);
        //ɾ����¼
    	dbPrplAgrireturnvisit.delete(registno, serialno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	DBPrplAgrireturnvisit dbPrplAgrireturnvisit = new DBPrplAgrireturnvisit(dbManager);
        //������ɾ����¼
    	dbPrplAgrireturnvisit.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param PrplagrireturnvisitDto PrplagrireturnvisitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplagrireturnvisitDto prplagrireturnvisitDto)
            throws Exception{
    	DBPrplAgrireturnvisit dbPrplAgrireturnvisit = new DBPrplAgrireturnvisit(dbManager);
        //���¼�¼
    	dbPrplAgrireturnvisit.update(prplagrireturnvisitDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @return PrplagrireturnvisitDto PrplagrireturnvisitDto
     * @throws Exception
     */
    public PrplagrireturnvisitDto findByPrimaryKey(DBManager dbManager,String registno,String serialno)
            throws Exception{
    	DBPrplAgrireturnvisit dbPrplreturnvisit = new DBPrplAgrireturnvisit(dbManager);
        //����DTO
        PrplagrireturnvisitDto prplagrireturnvisitDto = null;
        //��ѯ����,��ֵ��DTO
        prplagrireturnvisitDto = dbPrplreturnvisit.findByPrimaryKey(registno, serialno);
        return prplagrireturnvisitDto;
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
    	DBPrplAgrireturnvisit dbPrplAgrireturnvisit = new DBPrplAgrireturnvisit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplAgrireturnvisit.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplAgrireturnvisit.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����PrplagrireturnvisitDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	DBPrplAgrireturnvisit dbPrplAgrireturnvisit = new DBPrplAgrireturnvisit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplAgrireturnvisit.findByConditions(conditions);
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
    	DBPrplAgrireturnvisit dbPrplAgrireturnvisit = new DBPrplAgrireturnvisit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplAgrireturnvisit.getCount(conditions);
        return count;
    }
    
}
