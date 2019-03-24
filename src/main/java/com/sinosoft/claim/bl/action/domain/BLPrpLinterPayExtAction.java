package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayExt;

/**
 * ���Ǵ�������ӱ�------���������ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPayExtAction extends BLPrpLinterPayExtActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayExtAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPayExtAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterPayExtDto prpLinterPayExtDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterPayExtDto prpLinterPayExtDto,String mode)
            throws Exception{
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterPayExtDto[] prpLinterPayExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPayExtDto[] prpLinterPayExtDto)
            throws Exception{
        DBPrpLinterPayExt dbPrpLinterPayExt = new DBPrpLinterPayExt(dbManager);
        //�����¼
        for(int i=0;i<prpLinterPayExtDto.length;i++){
        	dbPrpLinterPayExt.insert(prpLinterPayExtDto[i]);
        }
    }
}
