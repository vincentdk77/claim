//
//Generate By
//
//JTools (Version 1.0.0.1)
//(C) Copyright Zhouxianli 2003.  All rights reserved.
//Visit http://www.jtools.org
//
//Any qustion mail zhouxianli@126.com
//Generate at 2003-10-16 10:37:55
//
//

/**
 * 基本数据校验
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author zhouxianli
 * @version 1.0
 */
/**
    结构为 字段名，字段描述，类型，是否允许为空
           4项都是必需的
 */

var schemaColumns = new Array(); //存储字段结构的数组

function schemaColumn(name,desc,dataType,allowNulls)
{
    this.name = name;
    this.desc = desc;
    this.dataType = dataType;
    this.allowNulls = allowNulls;
}

function getSchemaColumn(name)
{
    for(var i=0;i<schemaColumns.length;i++)
    {
        if(name==schemaColumns[i].name)
            return schemaColumns[i];
    }
    return null;
}

//初始化数组
var columnIndex = 0;
//标准数据
//PrpinsDB标准校验数据 .DO NOT EDIT THIS


schemaColumns[columnIndex++] = new schemaColumn("prpLclaimDamageCode","出险原因代码","char(4)",false);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimDamageName","出险原因说明","varchar(100,0)",false);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossName","受损标的","varchar(120,0)",false);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossesNumber", "赔付数量", "DECIMAL(14,2)",true);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimDamageInsured", "出险户次", "DECIMAL(14,2)",true);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimDeathQuantity", "死亡数量", "DECIMAL(14,2)",true);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimKillQuantity", "扑杀数量", "DECIMAL(14,2)",true);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossKindName","险别名称","CHAR(80)",true);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossKindCode","险别代码","CHAR(7)",false);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossCurrency","币别","CHAR(3)",true);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossCurrencyName","币别名称","CHAR(80)",true);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossSumClaim","预计给付金额","DECIMAL(14,2)",false);
schemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossInputDate","输入日期","DATE",true); 


schemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarId_Card", "证件号码", "VARCHAR2(20)",true);
schemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarName", "农户姓名", "VARCHAR2(50)",true);
schemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarBank", "开户行名称", "VARCHAR2(50)",true);
schemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarAccount", "银行账号", "VARCHAR2(24)",true);
schemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarEarNo", "耳标号", "VARCHAR2(16)",true);
schemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarEstimateLoss", "赔偿金额", "DECIMAL(14,2)",true);