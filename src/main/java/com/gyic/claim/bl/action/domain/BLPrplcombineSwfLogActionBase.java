package com.gyic.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.gyic.claim.dto.domain.PrplcombineDto;
import com.gyic.claim.resource.dtofactory.domain.DBPrplcombine;
import com.gyic.claim.resource.dtofactory.domain.PrplcombineSwfLog;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��������ڵ�״̬���벢�������������ҵ���߼�������<br>
 */
public class BLPrplcombineSwfLogActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcombineSwfLogActionBase.class);


    /**
     * ���캯��
     */
    public BLPrplcombineSwfLogActionBase(){
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
    	PrplcombineSwfLog prplcombineSwfLog = new PrplcombineSwfLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = prplcombineSwfLog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = prplcombineSwfLog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection 
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	PrplcombineSwfLog prplcombineSwfLog = new PrplcombineSwfLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = prplcombineSwfLog.findByConditions(conditions);
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
    	PrplcombineSwfLog prplcombineSwfLog = new PrplcombineSwfLog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = prplcombineSwfLog.getCount(conditions);
        return count;
    }
}
