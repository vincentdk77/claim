package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplfiscalpaymainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpaymain;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplfiscalpaydetail;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplfiscalpaymain;

/**
 * ����PRPLFISCALMAINPAY��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplfiscalpaymainAction extends BLPrplfiscalpaymainActionBase{
    private static Logger logger = Logger.getLogger(BLPrplfiscalpaymainAction.class);

    /**
     * ���캯��
     */
    public BLPrplfiscalpaymainAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplfiscalmainpayDto prplfiscalmainpayDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplfiscalpaymainDto prplfiscalmainpayDto,String mode)
            throws Exception{
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
    public PageRecord findPayQueryByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrplfiscalpaymain dbPrplfiscalpaymain = new DBPrplfiscalpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplfiscalpaymain.getPayQueryCount(conditions);
        collection = dbPrplfiscalpaymain.findPayQueryByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    
    public void updateByKey(DBManager dbManager,String fiscalno, String vflag,String status)
    throws Exception {
    	DBPrplfiscalpaymain dbPrplfiscalpaymain = new DBPrplfiscalpaymain(dbManager);
		// ���¼�¼
    	dbPrplfiscalpaymain.updateByKey(fiscalno,vflag,status);
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
    public PageRecord findPaybackByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrplfiscalpaymain dbPrplfiscalpaymain = new DBPrplfiscalpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplfiscalpaymain.getPayQueryCount(conditions);
        collection = dbPrplfiscalpaymain.findPaybackByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
}
