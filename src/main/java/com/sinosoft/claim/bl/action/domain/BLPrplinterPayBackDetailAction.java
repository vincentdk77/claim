package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterPayBackDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplinterPayBackDetail;

/**
 * ���Ǵ�ҽ�ƽӿ�֧���˻����̹켣���ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplinterPayBackDetailAction extends BLPrplinterPayBackDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrplinterPayBackDetailAction.class);

    /**
     * ���캯��
     */
    public BLPrplinterPayBackDetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplinterPayBackDetailDto prplinterPayBackDetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplinterPayBackDetailDto prplinterPayBackDetailDto,String mode)
            throws Exception{
    }
}
