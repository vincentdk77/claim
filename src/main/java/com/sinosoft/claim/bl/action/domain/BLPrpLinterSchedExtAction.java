package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterSchedExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterSchedExt;

/**
 * ���ǲ���˵����Ϣ��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterSchedExtAction extends BLPrpLinterSchedExtActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterSchedExtAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterSchedExtAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterSchedExtDto prpLinterSchedExtDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterSchedExtDto prpLinterSchedExtDto,String mode)
            throws Exception{
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterSchedExtDto[] prpLinterSchedExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterSchedExtDto[] prpLinterSchedExtDto)
            throws Exception{
        DBPrpLinterSchedExt dbPrpLinterSchedExt = new DBPrpLinterSchedExt(dbManager);
        //�����¼
        for(int i=0;i<prpLinterSchedExtDto.length;i++){
        	dbPrpLinterSchedExt.insert(prpLinterSchedExtDto[i]);
        }
    }
}
