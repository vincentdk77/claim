package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLreplevyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplreplevyȨ��ת�ü�׷���ǼǱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLreplevyAction extends BLPrpLreplevyActionBase{
    private static Log log = LogFactory.getLog(BLPrpLreplevyAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLreplevyAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLreplevyDto prpLreplevyDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLreplevyDto prpLreplevyDto,String mode) throws Exception{
    }
}
