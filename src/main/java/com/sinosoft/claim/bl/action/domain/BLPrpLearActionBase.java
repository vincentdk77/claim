package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLearDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLear;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLearActionBase {
	 private static Log logger = LogFactory.getLog(BLPrpLearActionBase.class);
	
	public BLPrpLearActionBase() {
	}


	/**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLearDto prpLearDto) throws Exception{
        DBPrpLear dbPrpLear = new DBPrpLear(dbManager);
        //�����¼
        dbPrpLear.insert(prpLearDto);
    }
    
    /**
     * ��������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo) throws Exception{
    	DBPrpLear dbPrpLear = new DBPrpLear(dbManager);
        //ɾ����¼
    	dbPrpLear.delete(registNo);
    } 
    
    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
    	DBPrpLear dbPrpLear = new DBPrpLear(dbManager);
        //������ɾ����¼
    	dbPrpLear.deleteByConditions(conditions);
    }
    
    /**
     * �������Ÿ���һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLearDto prpLearDto) throws Exception{
    	DBPrpLear dbPrpLear = new DBPrpLear(dbManager);
        //���¼�¼
    	dbPrpLear.update(prpLearDto);
    }
    
    /**
     * �������Ų���һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ����
     * @return prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public PrpLearDto findByRegistNo(DBManager dbManager,String registNo) throws Exception{
        DBPrpLear dbPrpLear = new DBPrpLear(dbManager);
        //����DTO
        PrpLearDto prpLearDto = null;
        //��ѯ����,��ֵ��DTO
        prpLearDto = dbPrpLear.findByRegistNo(registNo);
        return prpLearDto;
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
        DBPrpLear dbPrpLear = new DBPrpLear(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLear.getCount(SqlUtils.getWherePartForGetCount(conditions));
        //add by zhaolu 20060803 start
        int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
        if(maxQueryCount!=0&&count>maxQueryCount){   
          throw new UserException(1,3,"0000","��ѯ�����������ϵͳ����"); 
        }
        //add by zhaolu 20060803 end 
        collection = dbPrpLear.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    
    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLear dbPrpLear = new DBPrpLear(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLear.findByConditions(conditions);
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
        DBPrpLear dbPrpLear = new DBPrpLear(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLear.getCount(conditions);
        return count;
    }
    
	
}
