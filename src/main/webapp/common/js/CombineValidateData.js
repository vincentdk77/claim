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

var CombineSchemaColumns = new Array(); //存储字段结构的数组

function schemaColumn(name,desc,dataType,allowNulls)
{
    this.name = name;
    this.desc = desc;
    this.dataType = dataType;
    this.allowNulls = allowNulls;
}
function getCombineSchemaColumn()
{
    return CombineSchemaColumns;
}

//初始化数组
var columnIndex = 0;
//标准数据
//PrpinsDB标准校验数据 .DO NOT EDIT THIS


CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLverifyLossClaimNo", "证件号码", "VARCHAR2(20)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarName", "农户姓名", "VARCHAR2(50)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarBank", "开户行名称", "VARCHAR2(50)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarAccount", "银行账号", "VARCHAR2(24)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarEarNo", "耳标号", "VARCHAR2(16)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarEstimateLoss", "赔偿金额", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLverifyLossLossesNumber", "赔付数量", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLverifyLossKillQuantity", "扑杀数量", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLverifyLossDeathQuantity", "死亡数量", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLverifyLossDamageInsured", "出险户次", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLpropSumLoss","受损金额","decimal(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLpropSumReject","剔除金额","decimal(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLcheckEstimateLoss", "预估金额", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLcheckEstimateFee", "预估费用", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLcheckCheckSite","查勘/代查勘地点","varchar(60)",false);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLcheckChecker1","查勘/代查勘人1","char(20)",false);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLcheckCheckDate","查勘/代查勘日期","DATE",false);

CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimDamageCode","出险原因代码","char(4)",false);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimDamageName","出险原因说明","varchar(100,0)",false);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossName","受损标的","varchar(120,0)",false);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossesNumber", "赔付数量", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimDamageInsured", "出险户次", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimDeathQuantity", "死亡数量", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimKillQuantity", "扑杀数量", "DECIMAL(14,2)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossKindName","险别名称","CHAR(80)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossKindCode","险别代码","CHAR(7)",false);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossCurrency","币别","CHAR(3)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossCurrencyName","币别名称","CHAR(80)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossSumClaim","预计给付金额","DECIMAL(14,2)",false);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prpLclaimLossInputDate","输入日期","DATE",true); 


CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarId_Card", "证件号码", "VARCHAR2(20)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarName", "农户姓名", "VARCHAR2(50)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarBank", "开户行名称", "VARCHAR2(50)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarAccount", "银行账号", "VARCHAR2(24)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarEarNo", "耳标号", "VARCHAR2(16)",true);
CombineSchemaColumns[columnIndex++] = new schemaColumn("prplCompensateEarEstimateLoss", "赔偿金额", "DECIMAL(14,2)",true);