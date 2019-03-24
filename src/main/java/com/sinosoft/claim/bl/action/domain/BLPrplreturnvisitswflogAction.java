package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflog;

/**
 * ����PRPLRETURNVISITSWFLOG��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplreturnvisitswflogAction extends BLPrplreturnvisitswflogActionBase{
    private static Logger logger = Logger.getLogger(BLPrplreturnvisitswflogAction.class);

    /**
     * ���캯��
     */
    public BLPrplreturnvisitswflogAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplreturnvisitswflogDto prplreturnvisitswflogDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplreturnvisitswflogDto prplreturnvisitswflogDto,String mode)
            throws Exception{
    }

	public Double findSumprepaidBySQL(DBManager dbManager, String sql) throws Exception{
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        //�����¼
        Double sumprepaid = dbPrplreturnvisitswflog.findSumprepaidBySQL(sql);
        return sumprepaid;
    }
}
