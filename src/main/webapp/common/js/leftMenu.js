	/**
		���ܣ�ͬmaingo�������ԭmaingo�����д��ڵ�һ��Ǳ�ڵ�BUG��
		˵����ԭmaingo��BUG�ǣ��������˵���FuncID���Ȳ���1λ��2λ��4λʱ����˽ű���������µ���ʧ�ܣ�
		��д�ˣ��϶���
		��дʱ�䣺2006-1-11
	*/
    function maingo_new(p_Id, doWhat, strName, linkTo, p_station, p_level2Id, p_level1Id) {
        var linkHtml = "��ҳ";
        linkHtml = linkHtml+" > "+document.all(p_level1Id+"font").value+" > "+document.all(p_level2Id+"font").value+" > ";
        linkHtml = linkHtml+strName;

        top.fraTitle.setCommand(linkHtml);

        if(linkTo != "") {
            if(linkTo == "help/main.htm")
            {
                //window.open(linkTo,"help");
            }
              else
            {
                top.fraInterface.location = linkTo;                
            }
        }
    } 
    function maingo(p_Id, doWhat, strName, linkTo, p_station) {
	    /**
	    	ע�⣺�˺�������һ��Ǳ�ڵ�BUG��
	    	�����������˵���FuncID���Ȳ���1λ��2λ��4λʱ����˽ű���������µ���ʧ�ܣ�
	    	ԭ���ڱ��ű����Ǹ���p_Id�ĵ�һλ��ǰ��λ��������������˵��Ĳ˵����ƣ������������˵��ĳ��Ȳ���1λ��2λʱ��������
	    	�������������µĵĺ���maingo_new��
	    */
	    //alert("p_Id="+p_Id+"|doWhat="+doWhat+"|strName="+strName+"|linkTo="+linkTo+"|p_station="+p_station);
        var linkHtml = "��ҳ";
        //linkHtml = document.all(p_Id.substring(0,1)+"font").value+" --"+document.all(p_Id.substring(0,2)+"font").value+" --";
        //linkHtml = linkHtml+"<font ID='"+p_Id+"font' color='#000000' onClick="+"\""+"maingo('"+p_Id+"','"+p_Id+"','"+strName+"','"+linkTo+"','"+p_Id+"')"+"\""+">"+strName+"</font>";
        //linkHtml = linkHtml+"<font onClick=alert('sdfsdf')>sdf</font>";
        //alert("::::::"+linkHtml);
        //linkHtml = document.all(p_Id.substring(0,1)+"font").value+" --"+document.all(p_Id.substring(0,2)+"font").value+" --"+"<font ID='"+p_Id+"font' color='#000000' onClick="+"\""+"maingo('"+p_Id+"','"+p_Id+"','"+strName+"','"+linkTo+"','"+p_Id+"')"+"\""+">"+strName+"</font>";

        //document.all(document.all.checkedId.value+"font").color = "#000000";
//        document.all.checkedId.value = p_Id;
//        document.all.checkedName.value = strName;
        //document.all(p_Id+"font").color = "#ff0000";


        linkHtml = linkHtml+" > "+document.all(p_Id.substring(0,1)+"font").value+" > "+document.all(p_Id.substring(0,2)+"font").value+" > ";
        linkHtml = linkHtml+strName;
//        top.fraTitle.categoryList.innerHTML=linkHtml;
        top.fraTitle.setCommand(linkHtml);

        if(linkTo != "") {
            if(linkTo == "help/main.htm")
            {
                //window.open(linkTo,"help");
            }
              else
            {
                top.fraInterface.location = linkTo;
                //top.fraAddress.location = "stationAddress.jsp?station=" + p_station;
            }
        }
    }
      function clickEvent(p_obj, strOpenUrl, strCloseUrl) {
        var strAddUrl = "/claim/images/treeAdd.gif";
        var strSubtractUrl = "/claim/images/treeSubtract.gif";
        if(document.all(p_obj.id+"p").style.display == "none") {
            document.all(p_obj.id+"p").style.display = "";
            //document.all(p_obj.id).src = strSubtractUrl;
            //document.all(p_obj.id+"II").src = strOpenUrl;
        }
        else {
            document.all(p_obj.id+"p").style.display = "none";
            //document.all(p_obj.id).src = strAddUrl;
            //document.all(p_obj.id+"II").src = strCloseUrl;
        }
    }

     function clickEventtwo(ifEnd) {
        var strCloseUrl = "/claim/images/tree_folderclass2.gif";
        var strOpenUrl = "/claim/images/tree_folderclass2open.gif";

        var strAddUrl = "/claim/images/tree_Tplus.gif";
        if(ifEnd == "true") {
            strAddUrl = "/claim/images/tree_Lplus.gif";
        }
        var strSubtractUrl = "/claim/images/tree_Tminus.gif";
        if(ifEnd == "true") {
            strSubtractUrl = "/claim/images/tree_Lminus.gif";
        }

        if(document.all(window.event.srcElement.id+"p").style.display == "none") {
            document.all(window.event.srcElement.id+"p").style.display = "";
            //document.all(window.event.srcElement.id).src = strSubtractUrl;
            //document.all(window.event.srcElement.id+"II").src = strOpenUrl;
        }
        else {
            document.all(window.event.srcElement.id+"p").style.display = "none";
            //document.all(window.event.srcElement.id).src = strAddUrl;
            //document.all(window.event.srcElement.id+"II").src = strCloseUrl;
        }
    }