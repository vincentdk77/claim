package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisit;

/**
 * ����PRPLRETURNVISIT��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplreturnvisitAction extends BLPrplreturnvisitActionBase{
    private static Logger logger = Logger.getLogger(BLPrplreturnvisitAction.class);

    /**
     * ���캯��
     */
    public BLPrplreturnvisitAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplreturnvisitDto prplreturnvisitDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplreturnvisitDto prplreturnvisitDto,String mode)
            throws Exception{
    }
}
