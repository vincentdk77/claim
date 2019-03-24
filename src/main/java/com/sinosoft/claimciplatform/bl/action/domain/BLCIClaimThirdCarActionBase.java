package com.sinosoft.claimciplatform.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.dto.domain.CIClaimThirdCarDto;
import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadLogDto;
import com.sinosoft.claimciplatform.resource.dtofactory.domain.DBCIClaimThirdCar;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����������Ϣ�ϴ�ƽ̨���߳��⸶��Ϣ���ҵ���߼�������<br>
 * ������ 2010-03-30
 */
public class BLCIClaimThirdCarActionBase {
	 private static Log logger = LogFactory.getLog(BLCIClaimThirdCarActionBase.class);

	    /**
	     * ���캯��
	     */
	    public BLCIClaimThirdCarActionBase(){
	    }

	    /**
	     * ����һ������
	     * @param dbManager DB������
	     * @param cIClaimUploadLogDto cIClaimUploadLogDto
	     * @throws Exception
	     */
	    public void insert(DBManager dbManager,CIClaimThirdCarDto ciClaimThirdCarDto)throws Exception{
	    	DBCIClaimThirdCar dbCIClaimThirdCar = new DBCIClaimThirdCar(dbManager);
	    	dbCIClaimThirdCar.insert(ciClaimThirdCarDto);
	    }
	    
	    /**
	     * ��������һ������
	     * @param dbManager DB������
	     * @param cIClaimUploadLogDto cIClaimUploadLogDto
	     * @throws Exception
	     */
	    public void insertAll(DBManager dbManager,Collection collection)throws Exception{
	    	DBCIClaimThirdCar dbCIClaimThirdCar = new DBCIClaimThirdCar(dbManager);
	    	dbCIClaimThirdCar.insertAll(collection);    	
	    }
	    /**
	     * ������ɾ��һ������
	     * @param dbManager DB������
	     * @param claimCode �������
	     * @param serialNo ���
	     * @throws Exception
	     */
	    public void delete(DBManager dbManager,String claimCode,int serialNo)
	            throws Exception{
	    	DBCIClaimThirdCar dbCIClaimThirdCar = new DBCIClaimThirdCar(dbManager);
	    	dbCIClaimThirdCar.delete(claimCode, serialNo);
	    }
	    
	    /**
	     * ������ɾ������
	     * @param dbManager DB������
	     * @param conditions ɾ������
	     * @throws Exception
	     */
	    public void deleteByConditions(DBManager dbManager,String conditions)
	            throws Exception{
	    	DBCIClaimThirdCar dbCIClaimThirdCar = new DBCIClaimThirdCar(dbManager);
	    	dbCIClaimThirdCar.deleteByConditions(conditions);
	    }
	    
	    /**
	     * ����������һ������(���������޷����)
	     * @param dbManager DB������
	     * @param cIClaimUploadLogDto cIClaimUploadLogDto
	     * @throws Exception
	     */
	    public void update(DBManager dbManager,CIClaimThirdCarDto ciClaimThirdCarDto)
	    		throws Exception{
	    	DBCIClaimThirdCar dbCIClaimThirdCar = new DBCIClaimThirdCar(dbManager);
	    	dbCIClaimThirdCar.update(ciClaimThirdCarDto);
	    }
	    
	    /**
	     * ����������һ������
	     * @param dbManager DB������
	     * @param claimCode �������
	     * @param serialNo ˳���
	     * @return CIClaimThirdCarDto ciClaimThirdCarDto
	     * @throws Exception
	     */
	    public CIClaimThirdCarDto findByPrimaryKey(DBManager dbManager,String claimCode,int serialNo)
	            throws Exception{
	    	DBCIClaimThirdCar dbCIClaimThirdCar = new DBCIClaimThirdCar(dbManager);
	    	CIClaimThirdCarDto ciClaimThirdCarDto = null;
	    	
	    	ciClaimThirdCarDto = dbCIClaimThirdCar.findByPrimaryKey(claimCode, serialNo);
	    	
	    	return ciClaimThirdCarDto;
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
	    	DBCIClaimThirdCar dbCIClaimThirdCar = new DBCIClaimThirdCar(dbManager);
	    	
	    	Collection collection = new ArrayList();

	        if(conditions.trim().length()==0){
	            conditions = "1=1";
	        }
	        int count = dbCIClaimThirdCar.getCount(SqlUtils.getWherePartForGetCount(conditions));
	        collection = dbCIClaimThirdCar.findByConditions(conditions,pageNo,rowsPerPage);
	        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	        return pageRecord;
	    }
	    
	    /**
	     * ��������ѯ��������
	     * @param dbManager DB������
	     * @param conditions ��ѯ����
	     * @return Collection ����cIClaimUploadLogDto�ļ���
	     * @throws Exception
	     */
	    public Collection findByConditions(DBManager dbManager,String conditions)
        	throws Exception{
	    	DBCIClaimThirdCar dbCIClaimThirdCar = new DBCIClaimThirdCar(dbManager);
	    	Collection collection = new ArrayList();

	        if(conditions.trim().length()==0){
	            conditions = "1=1";
	        }

	        collection = dbCIClaimThirdCar.findByConditions(conditions);
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
	    	DBCIClaimThirdCar dbCIClaimThirdCar = new DBCIClaimThirdCar(dbManager);
	    	if(conditions.trim().length()==0){
	            conditions = "1=1";
	        }

	        int count = dbCIClaimThirdCar.getCount(conditions);
	        return count;
	    }
}
