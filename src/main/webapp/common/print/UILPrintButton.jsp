<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<HTML>
		<HEAD>
	    	<TITLE> 理赔打印 </TITLE>
		</HEAD>
<%-- part1 --%>
		<script language='javascript'>
		function Print(Flag)
				{
				if (Flag=="1")  
					{
					fm.TitleName.value = '赔款理算书打印';
					fm.BizName.value = '赔款计算书号：';
					fm.printType.value = "Compensate";
					fm.submit();
					}
					if (Flag=="2")  
					{
					fm.TitleName.value = '现场查勘报告打印';
					fm.BizName.value = '报案号：';
					fm.printType.value = "CheckReport";
					fm.submit();
					}
					
					if (Flag=="3")  
					{
					fm.TitleName.value = '拒赔通知书打印';
					fm.BizName.value = ' 立案号：';
					fm.printType.value = "Cancel";
					fm.submit();
					}
					
					if (Flag=="4")  
					{
					fm.TitleName.value = '货运险代查勘委托书';
					fm.BizName.value = '报案号：';
					fm.printType.value = "FreightHeresyCheck";
					fm.submit();
					}
					
					if (Flag=="5")  
					{
					fm.TitleName.value = '货运险赔案终结报告书';
					fm.BizName.value = '立案号：';
					fm.printType.value = "FreightCompensateNotice";
					fm.submit();
					}
					
					if (Flag=="6")  
					{
					fm.TitleName.value = '货运险出险通知书';
					fm.BizName.value = '报案号：';
					fm.printType.value = "FreightDamageNotice";
					fm.submit();
					}
					
					if (Flag=="7") 
					{
					fm.TitleName.value = '农险补收保费';
					fm.BizName.value = '报案号：';
					fm.printType.value = "AddPremium";
					fm.submit();
					}
					
					if (Flag=="8")  
					{
					fm.TitleName.value = '理赔处理报告';
					fm.BizName.value = '立案号：';
					fm.printType.value = "ClaimDispose";
					fm.submit();
					}
					
					if (Flag=="9")  
					{
					fm.TitleName.value = '抄单打印';
					fm.BizName.value = '报案号：';
					fm.printType.value = "CopyPrint";
					fm.submit();
					}
					
					if (Flag=="10")  
					{
					fm.TitleName.value = '结案报告';
					fm.BizName.value = '立案号：';
					fm.printType.value = "ShipEndcase";
					fm.submit();
					}
					
					if (Flag=="11")  
					{
					fm.TitleName.value = '财产险赔款通知书';
					fm.BizName.value = '赔款计算书号：';
					fm.printType.value = "PropCompensateNotice";
					fm.submit();
					}
					
					if (Flag=="12")  
					{
					fm.TitleName.value = '拒赔/注销案件通知书';
					fm.BizName.value = '立案号：';
					fm.printType.value = "FreightRefuseCancel";
					fm.submit();
					}
					
					if (Flag=="23")  
					{
					fm.TitleName.value = '拒赔(注销)案件通知书';
					fm.BizName.value = '立案号：';
					fm.printType.value = "ClaimRefuse";
					fm.submit();
					}
					
					if (Flag=="13")  
					{
					fm.TitleName.value = '财产险代查勘委托书 ';
					fm.BizName.value = '赔款计算书号：';
					fm.printType.value = "PropCompensateNotice";
					fm.submit();
					}
					
					if (Flag=="14")  
					{
					fm.TitleName.value = '货运险索赔申请书';
					fm.BizName.value = '报案号：';
					fm.printType.value = "FreightClaimApply";
					fm.submit();
					}
					
					if (Flag=="15")  
					{
					fm.TitleName.value = '人身险索赔文件交接凭证';
					fm.BizName.value = '立案号：';
					fm.printType.value = "ClaimDocumentHandinCredence";
					fm.submit();
					}
					
					if (Flag=="16")  
					{
					fm.TitleName.value = '意键险调查报告打印';
					fm.BizName.value = '报案号：';
					fm.printType.value = "AcciCheck";
					fm.submit();
					}
					if (Flag=="17")  
					{
					fm.TitleName.value = '意键险二核批单打印';
					fm.BizName.value = '赔款计算书号：';
					fm.printType.value = "AcciReview";
					fm.submit();
					}
					if (Flag=="18")  
					{
					fm.TitleName.value = '意键险赔款批单打印';
					fm.BizName.value = '赔款计算书号：';
					fm.printType.value = "ReparationsList";
					fm.submit();
					}
					
					if (Flag=="19")  
					{
					fm.TitleName.value = '意键险不予立案通知书打印';
					fm.BizName.value = '报案号：';
					fm.printType.value = "AcciNotClaim";
					fm.submit();
					}
					
					if (Flag=="20")  
                    {
                        fm.TitleName.value = '赔款通知书/收据全打';
                        fm.BizName.value = '赔款计算书号：';
                        fm.printType.value = "IndemnityNotice";
                        fm.submit();
                    }
                    if (Flag=="21")  
                    {
                        fm.TitleName.value = '定损报告打印';
                        fm.BizName.value = '报案号：';
					    fm.printType.value = "CetainLossList";
                        fm.submit();
                    }
                    if (Flag=="22")  
                    {
                        fm.TitleName.value = '农险卷宗封面打印';
                        fm.BizName.value = '理算书号：';
					    fm.printType.value = "CoverPrint";
                        fm.submit();
                    }
                    if (Flag=="32")  
                    {
                        fm.TitleName.value = '农房保险B款卷宗封面打印';
                        fm.BizName.value = '理算书号：';
					    fm.printType.value = "CoverPrint";
                        fm.submit();
                    }
                    
                    
					
				}
		</script>
<%-- part2 --%>
	<BODY>
	<form name="fm" action="/claim/common/print/UILPrintButtonNextInput.jsp" method="post" >
		<input type=hidden name="TitleName" >
		<input type=hidden name="BizName" >
		<input type=hidden name="printType" >
		<input type=hidden name="TypeNo" >
<table border="0" align="center" cellpadding="10" cellspacing="10"
	class="common">

	<tr>
        <td colspan=4 class="formtitle" id="TitleName">目录</td>
    </tr>
    <tr>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="案卷目录" alt="案卷目录" class="longbutton" onclick="">
        </td>        
        <td class=bigbutton id="">
            <Input name="buttonCoverText" type="button" value="农险赔案卷宗封面" alt="农险赔案卷宗封面" class="longbutton" onclick="Print('22')">
        </td>
        <td class=bigbutton id="">
            <Input name="buttonCoverText" type="button" value="农房保险赔案卷宗封面" alt="农房保险B款赔案卷宗封面" class="longbutton" onclick="Print('32')">
        </td>
        
    </tr>
    <tr>
        <td colspan=4 class="formtitle" id="TitleName">内部流转资料</td>
    </tr>
    <tr>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="案卷流转单" alt="案卷流转单" class="longbutton" onclick="">
        </td>        
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="超权限赔案审批表" alt="超权限赔案审批表" class="longbutton" onclick="">
        </td>  
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="重大案件报告表" alt="重大案件报告表" class="longbutton" onclick="">
        </td>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="代查勘委托书" alt="代查勘委托书" class="longbutton" onclick="">
        </td>  
    </tr>
    <tr>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="现场查勘报告打印" alt="现场查勘报告打印" class="longbutton" onclick="Print('2')">
        </td>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonCetainLoss" type="button" value="定损报告打印" alt="定损报告打印" class="longbutton" onclick="Print('21')">
        </td>
    </tr>
    <tr>
        <td colspan=4 class="formtitle" id="TitleName">赔案理算资料</td>
    </tr>
    <tr>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="赔款理算书打印" alt="赔款理算书打印" class="longbutton" onclick="Print('1')">
        </td>  
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="预付赔款报告书" alt="预付赔款报告书" class="longbutton" onclick="">
        </td> 
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="拒赔（注销）案件报告" alt="拒赔（注销）案件报告" class="longbutton" onclick="">
        </td>  
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="核损报告" alt="核损报告" class="longbutton" onclick="">
        </td>
    </tr>
    <tr>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="结案报告" alt="结案报告" class="longbutton" onclick="Print('10')">
        </td>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="产险及养殖险查勘报告" alt="产险及养殖险查勘报告" class="longbutton" onclick="">
        </td>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="人身险及种植险调查报告" alt="人身险及种植险调查报告" class="longbutton" onclick="">
        </td>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="照片粘贴页" alt="照片粘贴页" class="longbutton" onclick="">
        </td>
    </tr>
    <tr>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="单证粘贴页" alt="单证粘贴页" class="longbutton" onclick="">
        </td>
        
    </tr>
    <tr>
        <td colspan=4 class="formtitle" id="TitleName">赔付单据</td>
    </tr>
    <tr>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="赔款收据" alt="赔款收据" class="longbutton" onclick="Print('20')">
        </td>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="拒赔（注销）通知书" alt="拒赔（注销）通知书" class="longbutton" onclick="Print('12')">
        </td>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="拒赔（注销）案件通知书" alt="拒赔（注销）案件通知书" class="longbutton" onclick="Print('23')">
        </td>
    </tr>
    <tr>
        <td colspan=4 class="formtitle" id="TitleName">承保资料</td>
    </tr>
    <tr>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="保单抄件" alt="保单抄件" class="longbutton" onclick="Print('9')">
        </td>
    </tr> 
    <tr>
        <td colspan=4 class="formtitle" id="TitleName">客户索赔资料</td>
    </tr>
    <tr>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="非人身险出险通知书" alt="非人身险出险通知书" class="longbutton" onclick="">
        </td>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="人身险给付申请书" alt="人身险给付申请书" class="longbutton" onclick="">
        </td>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="预付申请书" alt="预付申请书" class="longbutton" onclick="">
        </td>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="赔款协议书" alt="赔款协议书" class="longbutton" onclick="">
        </td>
    </tr>
    <tr>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="索赔资料清单" alt=""索赔资料清单"" class="longbutton" onclick="">
        </td>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="财产损失清单" alt="财产损失清单" class="longbutton" onclick="">
        </td>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="授权委托书" alt="授权委托书" class="longbutton" onclick="">
        </td>
        <td class=bigbutton id="lpcalebook">
            <Input name="buttonInsureText" type="button" value="权益转让书" alt="权益转让书" class="longbutton" onclick="">
        </td>
    </tr><!--
	<tr>
		<td colspan=4 class="formtitle" id="TitleName"></td>
	</tr>
	<tr>
		<td class=bigbutton id="lpcalebook"><Input
			name="buttonInsureText" type="button" value="货运险代查勘委托书"
			alt="货运险代查勘委托书" src="/claim/images/BgLongButton.gif"
			onclick="Print('4')"></td>
		<td class=bigbutton id="lpcalebook"><Input
			name="buttonInsureText" type="button" value="货运险赔案终结报告书"
			alt=" 货运险赔案终结报告书" src="/claim/images/BgLongButton.gif"
			onclick="Print('5')"></td>
		<td class=bigbutton id="lpcalebook"><Input
			name="buttonInsureText" type="button" value="货运险出险通知书"
			alt=" 货运险出险通知书" src="/claim/images/BgLongButton.gif"
			onclick="Print('6')"></td>
		<td class=bigbutton id="lpcalebook"><Input
			name="buttonInsureText" type="button"
			value="&nbsp;&nbsp;农险补收保费&nbsp;&nbsp;" alt="补收保费"
			src="/claim/images/BgLongButton.gif" onclick="Print('7')"></td>
	</tr>
	<tr>
		<td class=bigbutton id="lpcalebook"><Input
			name="buttonInsureText" type="button" value=" 理赔处理报告 " alt=" 理赔处理报告 "
			src="/claim/images/BgLongButton.gif" onclick="Print('8')"></td>
		<td class=bigbutton id="lpcalebook"><Input
			name="buttonInsureText" type="button"
			value=" &nbsp;&nbsp&nbsp;&nbsp;抄单打印&nbsp;&nbsp;&nbsp;&nbsp; "
			alt=" &nbsp;&nbsp;抄单打印&nbsp;&nbsp; "
			src="/claim/images/BgLongButton.gif" onclick="Print('9')"></td>
		<td class=bigbutton id="lpcalebook"><Input
			name="buttonInsureText" type="button" value="财产险赔款通知书" alt="财产险赔款通知书"
			src="/claim/images/BgLongButton.gif" onclick="Print('11')">
		</td>
		<td class=bigbutton id="lpcalebook"><Input
			name="buttonInsureText" type="button" value="拒赔/注销案件通知书"
			alt="拒赔/注销案件通知书" src="/claim/images/BgLongButton.gif"
			onclick="Print('12')"></td>
	</tr>
	<tr>
		<%--    <td class=bigbutton id="lpcalebook">
						<Input name="buttonInsureText"  type="button" value="财产险代查勘委托书 " alt="财产险代查勘委托书" 
						src="/claim/images/BgLongButton.gif" onclick="Print('13')" >
				    </td>
				--%>
		<td class=bigbutton id="lpcalebook"><Input
			name="buttonInsureText" type="button" value="货运险索赔申请书 "
			alt=" 货运险索赔申请书" src="/claim/images/BgLongButton.gif"
			onclick="Print('14')"></td>
		<td class=bigbutton id="lpcalebook"><Input
			name="buttonInsureText" type="button" value="人身险索赔文件交接凭证"
			alt="人身险索赔文件交接凭证" src="/claim/images/BgLongButton.gif"
			onclick="Print('15')"></td>

		<td class=bigbutton id="lpcalebook"><Input
			name="buttonInsureText" type="button" value="意键险调查报告打印"
			alt=" 意键险调查报告打印" src="/claim/images/BgLongButton.gif"
			onclick="Print('16')"></td>
		<td class=bigbutton id="lpcalebook"><Input
			name="buttonInsureText" type="button" value="意键险二核批单打印"
			alt="意键险二核批单打印" src="/claim/images/BgLongButton.gif"
			onclick="Print('17')"></td>
	</tr>
	<tr>
		<td class=bigbutton id="lpcalebook"><Input
			name="buttonInsureText" type="button" value="意键险赔款批单打印  "
			alt="意键险赔款批单打印" src="/claim/images/BgLongButton.gif"
			onclick="Print('18')"></td>

		<td class=bigbutton id="lpcalebook"><Input
			name="buttonInsureText" type="button" value="不予立案通知书打印"
			alt="不予立案通知书打印" src="/claim/images/BgLongButton.gif"
			onclick="Print('19')"></td>

		<td class=bigbutton id="lpcalebook"><Input
			name="buttonInsureText" type="button" value="赔款通知书/收据全打"
			alt="赔款通知书/收据全打" src="/claim/images/BgLongButton.gif"
			onclick="Print('20')"></td>
	</tr>
--></table>
</form>
	</BODY>
</HTML>