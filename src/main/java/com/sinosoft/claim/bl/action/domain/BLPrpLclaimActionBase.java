package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaim-����������Ϣ���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:37.953<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimDto prpLclaimDto) throws Exception{
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
        //�����¼
        dbPrpLclaim.insert(prpLclaimDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo) throws Exception{
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
        //ɾ����¼
        dbPrpLclaim.delete(claimNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
        //������ɾ����¼
        dbPrpLclaim.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimDto prpLclaimDto) throws Exception{
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
        //���¼�¼
        dbPrpLclaim.update(prpLclaimDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ����
     * @return prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public PrpLclaimDto findByPrimaryKey(DBManager dbManager,String claimNo) throws Exception{
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
        //����DTO
        PrpLclaimDto prpLclaimDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimDto = dbPrpLclaim.findByPrimaryKey(claimNo);
        return prpLclaimDto;
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
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaim.getCount(SqlUtils.getWherePartForGetCount(conditions));
        //add by zhaolu 20060803 start
        int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
        if(maxQueryCount!=0&&count>maxQueryCount){   
          throw new UserException(1,3,"0000","��ѯ�����������ϵͳ����"); 
        }
        //add by zhaolu 20060803 end 
        collection = dbPrpLclaim.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaim.findByConditions(conditions);
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
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaim.getCount(conditions);
        return count;
    }
}
