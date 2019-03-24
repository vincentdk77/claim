package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PrplcombineDto;
import com.gyic.claim.resource.dtofactory.domain.DBPrplcombine;

/**
 * ����PRPLCOMBINE��ҵ�����)չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplcombineAction extends BLPrplcombineActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcombineAction.class);

    /**
     * ���캯��
     */
    public BLPrplcombineAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplcombineDto prplcombineDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplcombineDto prplcombineDto,String mode)
            throws Exception{
    }
}
