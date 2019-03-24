package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimtgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimtg;
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
public class BLPrpLclaimtgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimtgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimtgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimtgDto prpLclaimtgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimtgDto prpLclaimtgDto) throws Exception{
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);
        //�����¼
        dbPrpLclaimtg.insert(prpLclaimtgDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo) throws Exception{
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);
        //ɾ����¼
        dbPrpLclaimtg.delete(claimNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);
        //������ɾ����¼
        dbPrpLclaimtg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimtgDto prpLclaimtgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimtgDto prpLclaimtgDto) throws Exception{
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);
        //���¼�¼
        dbPrpLclaimtg.update(prpLclaimtgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ����
     * @return prpLclaimtgDto prpLclaimtgDto
     * @throws Exception
     */
    public PrpLclaimtgDto findByPrimaryKey(DBManager dbManager,String claimNo) throws Exception{
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);
        //����DTO
        PrpLclaimtgDto prpLclaimtgDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimtgDto = dbPrpLclaimtg.findByPrimaryKey(claimNo);
        return prpLclaimtgDto;
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
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimtg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        //add by zhaolu 20060803 start
        int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
        if(maxQueryCount!=0&&count>maxQueryCount){   
          throw new UserException(1,3,"0000","��ѯ�����������ϵͳ����"); 
        }
        //add by zhaolu 20060803 end 
        collection = dbPrpLclaimtg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimtgDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimtg.findByConditions(conditions);
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
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimtg.getCount(conditions);
        return count;
    }
}
