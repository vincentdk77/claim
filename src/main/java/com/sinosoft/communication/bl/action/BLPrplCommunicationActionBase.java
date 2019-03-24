package com.sinosoft.communication.bl.action;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.communication.dto.custom.PrplCommunicationDto;
import com.sinosoft.communication.resource.dtofactory.custom.DBPrplCommunication;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrplCommunicationActionBase {
	
	public BLPrplCommunicationActionBase(){
		
	}
	/**
     * ����һ������
     * @param dbManager DB������
     * @param prplCommunicationDto prplCommunicationDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplCommunicationDto prplCommunicationDto) throws Exception{
        DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);
        //�����¼
        dbPrplCommunication.insert(prplCommunicationDto);
    }

    /**
     * ����ͨ����ɾ��һ������
     * @param dbManager DB������
     * @param communicationNo ��ͨ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String communicationNo) throws Exception{
        DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);
        //ɾ����¼
        dbPrplCommunication.delete(communicationNo);
        
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
        DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);
        Collection collection = new ArrayList();

        //if(conditions.trim().length()==0){
         //   conditions = "1=1";
       // }

        int count = dbPrplCommunication.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplCommunication.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
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
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);
        Collection collection = new ArrayList();
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        //int count = dbPrplCommunication.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplCommunication.findByConditions(conditions);
        return collection;
    }
    /**
     * ��������ѯһ����ͨ����
     * @param conditions ��ѯ��ͨ����
     * @return PrplCommunicationDto ��ͨ��Ϣ
     * @throws Exception
     */
    public PrplCommunicationDto findByCommunicationNo(DBManager dbManager,String communicationNo) throws Exception{
    	DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);
    	PrplCommunicationDto prplCommunicationDto = null;
    	prplCommunicationDto = dbPrplCommunication.findByPrimaryKey(communicationNo);
    	return prplCommunicationDto;
    }
    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplCommunicatPersonDto prplCommunicatPersonDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplCommunicationDto prplCommunicationDto) throws Exception{
    	DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);
        //���¼�¼
    	dbPrplCommunication.update(prplCommunicationDto);
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
        DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplCommunication.getCount(conditions);
        return count;
    }
}
