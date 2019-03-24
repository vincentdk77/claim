<%--
****************************************************************************
* DESC       ：机动车辆现场查勘记录打印页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-11-16
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
   <%-- 初始化 --%>
<%@include file="DAACheckNoneFormatPrintIni.jsp"%>
  
<html>    
<link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  
  <body bgcolor="#FFFFFF" >
    <!-- 标题部分 -->                                                                  
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr height=40>
        <td colspan="2" height="40" align=top align=center style=" font-family:宋体; font-size:14pt;">            
          <B>机动车辆保险事故现场查勘记录<B>
        </td>
      </tr>
      <tr height=25>
        <td align=left  style="font-family:宋体; font-size:10pt;">
          保险单号码：<%=strPolicyNo%>
        </td>
        <td align=left  style="font-family:宋体; font-size:10pt;">
          报案编号：<%=strRegistNo%>
        </td>
        <td align=left  style="font-family:宋体; font-size:10pt;">
          立案编号：<%=strClaimNo%>
        </td>
        <td>&nbsp;</td>
      </tr>
    </table>
      
    <!-- 主体部分 -->  
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      <tr> 
        <td height=25 rowspan=2 colspan="1" width="4%">保险车辆</td>
        <td height=25 colspan="1" >厂牌型号：<%=strBrandName%></td>
        <td height=25 colspan="1" >发动机号：<%=strEngineNo%></td>
        <td height=25 colspan="1" >车辆已行驶里：<%=strRunDistance%></td>
        <td height=25 colspan="2" >已使用年限：<%=strUseYears%></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >号牌号码：<%=strLicenseNo%></td>
        <td height=25 colspan="2" >车架号：<%=strFrameNo%></td>
        <td height=25 colspan="2" >初次登记日期：</td>
      </tr>
      <tr> 
        <td height=25 colspan="2" >驾驶人员姓名：</td>
        <td height=25 colspan="1" >性别：□男　□女</td>
        <td height=25 colspan="1" >年龄：</td>
        <td height=25 colspan="2" >准驾车型：□A&nbsp;&nbsp;□B&nbsp;&nbsp;□C&nbsp;&nbsp;□其它<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></td>
      </tr>
      <tr> 
        <td height=25 colspan="2" >初次领证日期：</td>
        <td height=25 colspan="4" >驾驶证号码：□&nbsp;□&nbsp;□&nbsp;□&nbsp;□&nbsp;□&nbsp;□&nbsp;□&nbsp;□&nbsp;□&nbsp;□&nbsp;□&nbsp;□&nbsp;□&nbsp;□&nbsp;□&nbsp;□&nbsp;□&nbsp;</td>
      </tr>
      <tr> 
        <td height=25 rowspan=2 colspan="1" width="4%">职业类别</td>
        <td height=25 colspan="3" >□职业驾驶员　□国家社会管理者　□企业管理人员　□私营企业主　□专业技术人员　□军人</td>
        <td height=25 colspan="2" >文化程度：□研究生及以上　□大学本科　</td>
      </tr>
      <tr> 
        <td height=25 colspan="3" >□个体工商户　□商业服务业员工　□产业工人　□农业劳动者　□办事人员　□其它</td>
        <td height=25 colspan="2" >□大专　□中专　□高中　□初中及以下</td>
      </tr>
      <tr> 
        <td height=25 colspan="2" >查勘时间：年　　月　　日　　　时</td>
        <td height=25 colspan="2" >查勘地点：</td>
        <td height=25 colspan="2" >是否是第一现场：□是　□否</td>
      </tr>
      <tr> 
        <td height=25 colspan="6" >赔案类别：□一般　□特殊（□快速处理　□玻璃　□其它）　□双代（□委托外地查勘　□外地委托查勘）</td>
      </tr>
      <tr> 
        <td height=25 colspan="3" >出险时间：年　　月　　日　　　时</td>
        <td height=25 colspan="3" >出险地点：省　　市　　县</td>
      </tr>
      <tr> 
        <td height=25 rowspan=3 colspan="1" width="4%">第三方车辆</td>
        <td height=25 colspan="1" >厂牌型号：<%=strBrandNamethird%></td>
        <td height=25 colspan="2" >号牌号码：<%=strLicenseNothird%></td>
        <td height=25 colspan="1" >是否保险：□是　□否</td>
        <td height=25 colspan="1" width="24%">车辆已行驶里程：<%=strRunDistancethird%></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >驾驶人员姓名:</td>
        <td height=25 colspan="3" >驾驶证号：□ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □</td>
        <td height=25 colspan="1" width="24%">车辆初次登记日期：</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >初次领证日期:</td>
        <td height=25 colspan="2" >准驾车型：□A&nbsp;&nbsp;□B&nbsp;&nbsp;□C&nbsp;&nbsp;□其它</td>
        <td height=25 colspan="1" >职业：</td>
        <td height=25 colspan="1" width="24%">车辆已使用年限：</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" rowspan=2 align=center>现<br>场<br>查<br>勘<br>时<br>请<br>按<br>右<br>侧<br>所<br>列<br>内<br>容<br>仔<br>细<br>查<br>验<br>并<br>认<br>真<br>完<br>整<br>填<br>写<br></td>
        <td height=25 colspan="5" >
        &nbsp;1、出险原因:  □碰撞　□倾覆　□为灾　□爆炸　□自燃　□外界物体倒塌　□外界物体坠落　<br>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; □雷击　□暴风　□暴雨　□洪水　□雹灾　□其它（&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;）<br>
        &nbsp;2、事故原因:  □制动失灵　□转向失灵　□其它机械故障　□疲劳驾驶　□超速行驶　□违章并线<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;□逆向行驶　□安全间距不够　□违章装载　□其他违章行驶　□疏忽大意、措施不当　□其它<br>
        &nbsp;3、事故所涉及险种: □车损险　□三责险　□盗抢险　□玻璃单独破碎险　□自燃损失险 <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;□车上人员责任险　□车上货物责任险　□其它（&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;）<br>
        &nbsp;4、保险车辆号牌号码、发动机号、车架号与保险单上所载明的是否相符 □是　　□否<br>
        &nbsp;5、出险时间是否在保险有效期内 □是　　□否<br>
        &nbsp;6、是否属于领导追偿案件 　□是　　□否<br>
        &nbsp;7、出险时间接近保险起讫期的，有无相应时间证明  □是　　□否<br>
        &nbsp;8、出险地点：(1)分类： □高速公路　□普通公路　□城市道路　□乡村便道和机耕路　□场院及其他<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(2)与报案人所报是否一致： □是　　□否<br>
        &nbsp;9、实际使用性质与保险单上所载明的是否一致 □是　□否<br>
        &nbsp;10、保险车辆驾驶人员情况与报案人所述是否一致 　□是　　□否<br>
        &nbsp;11、保险车辆驾驶人员的驾驶证是否有效 　□是　　□否<br>
        &nbsp;12、保险车辆驾驶人员准驾车型与实际驾驶车辆是否相符 □是　　□否<br>
        &nbsp;13、使用各种专用机械车、特种车的人员是否有国家有关部门核发的有效操作证 　□是　　　□否<br>
        &nbsp;14、驾驶营业性客车的驾驶人员是否有国家有关部门核发的有效资格证书 　□是　　□否<br>
        &nbsp;15、保险车辆驾驶人员是否为被保险人允许的驾驶人员 　□是　　　　□否<br>
        &nbsp;16、保险车辆驾驶人员是否为保险合同约定的驾驶人员 　□是　　　　□否<br>
        &nbsp;17、保险车辆加强人员是否为酒后驾车 □是　　　□否<br>
        &nbsp;18、事故车辆损失痕迹与事故事故现场痕迹是否吻合 　□是　　　□否<br>
        &nbsp;19、保险车辆安全配置情况： □安全气囊　　□ABS　□倒车雷达　□卫星定位　□其它防盗装置（）　□停车场<br>
        &nbsp;20、第三者车辆是否已向其承保公司报案、索赔 　□是　　　□否<br>
        &nbsp;21、事故是否涉及第三方人身伤亡 □是（伤<u>&nbsp;&nbsp;</u>人，亡<u>&nbsp;&nbsp;</u>人）　　　□否<br>
        &nbsp;22、事故是否涉及第三方财产损失　□是　　　□否<br>
        &nbsp;23、事故是否涉及本车上人员伤亡  □是（伤<u>&nbsp;&nbsp;</u>人，亡<u>&nbsp;&nbsp;</u>人）　　　□否<br>
        &nbsp;24、确定或预计责任划分： □全部　　□主要　□同等　□次要　□无责任　□单方肇事<br>
        &nbsp;25、保险车辆损失程度： □全部损失　　□部分损失<br>
        &nbsp;26、其它需要说明的内容： <br>
        <br>                      
        </td>
      </tr>
      <tr>
          <td colspan=5>是否属于保险责任：□是　　□不是　　□待确定（原因是：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;） 
              
          </td>
      </tr>
     </table>
     <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      <tr> 
        <td height=25 rowspan=4 colspan="1" width="4%">事故估损金额</td>
        <td height=25 colspan="7" >事故损失金额估计:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其中：车辆损失险损失：&nbsp;&nbsp;&nbsp;&nbsp;第三者损失：&nbsp;&nbsp;&nbsp;&nbsp;其它损失：&nbsp;&nbsp;&nbsp;&nbsp;</td>        
      </tr>
      <tr> 
        <td height=25 colspan="1" rowspan=3 width="4%">保险损失金额</td>
        <td height=25 colspan="1" rowspan=3 align=center width="6%">车辆损失险</td>
        <td height=25 colspan="1" rowspan=3>标的损失： <br> 施救费：<br>吊车：&nbsp;&nbsp;&nbsp;&nbsp;拖车：&nbsp;&nbsp;&nbsp;&nbsp;其它：&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td height=25 colspan="1" rowspan=3 align=center width="6%">第三者责任险</td>
        <td height=25 colspan="1" width="16%">车辆：</td>
        <td height=25 colspan="1" rowspan=3 align=center width="6%">附加险</td>
        <td height=25 colspan="1" ></td>
      </tr>
      <tr>
      <td height=25 colspan="1" width="16%">人员：</td>
      <td height=25 colspan="1" ></td>
      </tr>
      <tr>
      <td height=25 colspan="1" width="16%">财产：</td>
      <td height=25 colspan="1" ></td>
      </tr>
      <tr> 
       <td valign="top" rowspan=2 colspan=7>
         查勘人意见（包括事故经过简单描述和初步责任认定）<br><br>
         <br>
       </td>
       <td colspan="1" height="60" valign="middle" align="center">询问笔录&nbsp;&nbsp;&nbsp;&nbsp;张          
       </td>
      </tr>
      <tr>
       <td colspan="1" height="60" valign="middle" align="center">事故照片&nbsp;&nbsp;&nbsp;&nbsp;张          
       </td> 
      </tr>
    </table>
    <table border=0 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      <tr>
       <td colspan="1">&nbsp;&nbsp;说明：1、估计损失金额单位为人民币。　　2、 第三方车辆不止一辆的，可增加《机动车辆现场查勘记录》用纸。        
       </td> 
    </table>
    
      <%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
          
  </body> 
</html>
