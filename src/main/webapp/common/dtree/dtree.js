/*--------------------------------------------------|
| dTree 2.05 | www.destroydrop.com/javascript/tree/ |
|---------------------------------------------------|
| Copyright (c) 2002-2003 Geir Landr?               |
|                                                   |
| This script can be used freely as long as all     |
| copyright messages are intact.                    |
|                                                   |
| Updated: 17.04.2003                               |
|--------------------------------------------------*/
/*---------------------------------------------------------------------|
| 字段含义说明   (原作中id,pid均为Number型，经测试String型也可用)  |
|----------------------------------------------------------------------|
|1  |id            |String  |唯一ID.                                   |
|2  |pid           |String  |父ID. 根节点时为-1.                       |
|3  |name          |String  |节点的文本标签.                           |
|4  |url           |String  |节点的Url.                                |
|5  |title         |String  |节点的Title.                              |
|6  |target        |String  |节点的Target.                             |
|7  |icon          |String  |节点图标文件，没有指定时用默认的.         |
|8  |iconOpen      |String  |节点打开时的图标文件，没有指定时用默认的. |
|9  |open          |Boolean |是否节点已经打开，默认为false.            |
|10 |hasCheckBox   |Boolean |是否有checkbox,默认为没有.                |
|11 |value         |Boolean |CheckBox是否选中，hasCheckBox为true时有效.|
|12 |boundLowLevel |Boolean |属性改变时，影响所有下级节点，默认为false.|
|13 |hasRefCheckBox|Boolean |是否有参考checkbox,不可改变。默认为false. |
|14 |refValue      |Boolean |参考值.不可改变.                          |
|15 |refTitle      |String  |参考值的标题.                             |
|16 |valueReadonly |Boolean |属性值不可改变.                           |
|17 |valueByRef    |Boolean |参考值为false,则属性值不可改.             |
|----------------------------------------------------------------------*/

// Node object
function Node(id, pid, name, url, title, target, icon, iconOpen, open, hasCheckBox, value, boundLowLevel, hasRefCheckBox, refValue, refTitle, valueReadonly, valueByRef) {
  this.index = -1; //内部treeCheckBox的数组序号
  this.id = id;
  this.pid = pid;
  this.name = name;
  this.url = url;
  this.title = title;
  this.target = target;
  this.icon = icon;
  this.iconOpen = iconOpen;
  this._io = open || false;
  this._is = false;
  this._ls = false;
  this._hc = false;
  this._ai = 0;
  this._p;
  if(hasCheckBox == null){
    hasCheckBox = false;
  }
  if(hasRefCheckBox == null){
    hasRefCheckBox = false;
  }
  if(boundLowLevel == null){
    boundLowLevel = false;
  }
  if(refTitle==null){
    refTitle="";
  }
  if(valueReadonly == null){
    valueReadonly = false;
  }
  if(valueByRef == null){
    valueByRef = false;
  }
  this.hasCheckBox = hasCheckBox;
  this.hasRefCheckBox = hasRefCheckBox;
  this.boundLowLevel = boundLowLevel;
  this.refTitle = refTitle;
  this.valueReadonly = valueReadonly;
  this.valueByRef = valueByRef;
 

  if(pid=="" || pid==id){ //如果pid为""或pid=id则表示为根节点
    this.pid = -1;
  }
  if(value=="1" || this.value=="true"){
    this.value=true;
  }else if(value=="0" || this.value=="false"){
    this.value=false;
  }else{
    this.value=value;
  }
  if(refValue=="1" || this.refValue=="true"){
    this.refValue=true;
  }else if(refValue=="0" || this.refValue=="false"){
    this.refValue=false;
  }else{
    this.refValue=refValue;
  }
};

// Tree object
function dTree(objName) {
  this.config = {
    target        : null,
    folderLinks     : true,
    useSelection    : true,
    useCookies      : true,
    useLines      : true,
    useIcons      : true,
    useStatusText   : true,
    closeSameLevel    : false,
    inOrder       : false
  }
  this.icon = {
    root    : '../dtree/base.gif',
    folder    : '../dtree/folder.gif',
    folderOpen  : '../dtree/folderopen.gif',
    node    : '../dtree/page.gif',
    empty   : '../dtree/empty.gif',
    line    : '../dtree/line.gif',
    join    : '../dtree/join.gif',
    joinBottom  : '../dtree/joinbottom.gif',
    plus    : '../dtree/plus.gif',
    plusBottom  : '../dtree/plusbottom.gif',
    minus   : '../dtree/minus.gif',
    minusBottom : '../dtree/minusbottom.gif',
    nlPlus    : '../dtree/nolines_plus.gif',
    nlMinus   : '../dtree/nolines_minus.gif'
  };
  this.obj = objName;
  this.aNodes = [];
  this.aIndent = [];
  this.root = new Node(-1);
  this.selectedNode = null;
  this.selectedFound = false;
  this.completed = false;
  this.initIndex = false;
};

// Adds a new node to the node array
dTree.prototype.add = function(id, pid, name, url, title, target, icon, iconOpen, open, hasCheckBox, value, boundLowLevel, hasRefCheckBox, refValue, refTitle, valueReadonly, valueByRef) {
  this.aNodes[this.aNodes.length] = new Node(id, pid, name, url, title, target, icon, iconOpen, open, hasCheckBox, value, boundLowLevel, hasRefCheckBox, refValue, refTitle, valueReadonly, valueByRef);
};

// Open/close all nodes
dTree.prototype.openAll = function() {
  this.oAll(true);
};
dTree.prototype.closeAll = function() {
  this.oAll(false);
};

// Outputs the tree to the page
dTree.prototype.toString = function() {
  var str = '<div class="dtree">\n';
  if (document.getElementById) {
    if (this.config.useCookies) this.selectedNode = this.getSelected();
    str += this.addNode(this.root);
  } else str += 'Browser not supported.';
  str += '</div>';
  if (!this.selectedFound) this.selectedNode = null;
  this.completed = true;
  return str;
};

// Creates the tree structure
dTree.prototype.addNode = function(pNode) {
  var str = '';
  var n=0;
  if (this.config.inOrder) n = pNode._ai;
  for (n; n<this.aNodes.length; n++) {
    if (this.aNodes[n].pid == pNode.id) {
      var cn = this.aNodes[n];
      cn._p = pNode;
      cn._ai = n;
      this.setCS(cn);
      if (!cn.target && this.config.target) cn.target = this.config.target;
      if (cn._hc && !cn._io && this.config.useCookies) cn._io = this.isOpen(cn.id);
      if (!this.config.folderLinks && cn._hc) cn.url = null;
      if (this.config.useSelection && cn.id == this.selectedNode && !this.selectedFound) {
          cn._is = true;
          this.selectedNode = n;
          this.selectedFound = true;
      }
      str += this.node(cn, n);
      if (cn._ls) break;
    }
  }
  return str;
};

// Creates the node icon, url and text
dTree.prototype.node = function(node, nodeId) {
  var str = '<div class="dTreeNode">' + this.indent(node, nodeId);
  //添加CheckBox开始
  if (node.hasCheckBox){
    str += '<input type=checkbox name=\"treeCheckBox\" value=\"' + node.id + '\"';
    if ((((!this.config.folderLinks || !node.url) && node._hc)|| (this.root.id == node.id)) && node.boundLowLevel){
      str += ' onpropertychange="javascript: ' + this.obj + '.boundLowLevel(' + nodeId + ');"';
    }
    else{
      str += ' valueName= ' + node.name;
      str += ' onclick="javascript: ' + this.obj + '.singleSelect(this);"';
    }
    if (node.value == true){
      str += ' checked ';
    }
    if (node.title){
      str += ' title="' + node.title + '"';
    }
  }else{
    str += '<input type=checkbox style=\"display:none\" name=\"treeCheckBox\" value=\"' + node.id + '\"';
  }
  if(node.valueReadonly==true){
    str += ' disabled';
  }else{
    if(node.valueByRef==true && node.hasRefCheckBox==true && node.refValue==false){
      str += ' disabled';
    }
  }
  str += '>';
  //添加CheckBox结束
  if (this.config.useIcons) {
    if (!node.icon) node.icon = (this.root.id == node.pid) ? this.icon.root : ((node._hc) ? this.icon.folder : this.icon.node);
    if (!node.iconOpen) node.iconOpen = (node._hc) ? this.icon.folderOpen : this.icon.node;
    if (this.root.id == node.pid) {
      node.icon = this.icon.root;
      node.iconOpen = this.icon.root;
    }
    str += '<img id="i' + this.obj + nodeId + '" src="' + ((node._io) ? node.iconOpen : node.icon) + '" alt="" />';
  }
  /*
  if (node.url) {
    str += '<a id="s' + this.obj + nodeId + '" class="' + ((this.config.useSelection) ? ((node._is ? 'nodeSel' : 'node')) : 'node') + '" href="' + node.url + '"';
    if (node.title) str += ' title="' + node.title + '"';
    if (node.target) str += ' target="' + node.target + '"';
    if (this.config.useStatusText) str += ' onmouseover="window.status=\'' + node.name + '\';return true;" onmouseout="window.status=\'\';return true;" ';
    if (this.config.useSelection && ((node._hc && this.config.folderLinks) || !node._hc))
      str += ' onclick="javascript: ' + this.obj + '.s(' + nodeId + ');"';
    str += '>';
  }
  else if ((!this.config.folderLinks || !node.url) && node._hc && node.pid != this.root.id)
    str += '<a href="#" onclick="' + this.obj + '.o(' + nodeId + ');" class="node">';
  str += node.name;
  if (node.url || ((!this.config.folderLinks || !node.url) && node._hc)) str += '</a>';
  */
  if(this.root.id == node.pid){
    str += node.name;
  }
  else{
  	str += '<span class="nodeSpan" onclick="'+ this.obj +'.nodeSelect(this);" onmouseover="'+ this.obj +'.nodeOver(this)" onmouseout="'+ this.obj +'.nodeOut(this)" ';
  	str += 'codeValue="'+ node.id +'" codeName="'+ node.name +'">' + node.name + '</span>';
  }
  //添加查考值的CheckBox开始
  if (node.hasRefCheckBox){
    str += '<input type=checkbox name=\"treeRefCheckBox\" title="' + node.refTitle + '" disabled';
    if (node.refValue == true){
      str += ' checked ';
    }
    str += '>';
  }
  //添加查考值的CheckBox结束
  str += '</div>';
  if (node._hc) {
    str += '<div id="d' + this.obj + nodeId + '" class="clip" style="display:' + ((this.root.id == node.pid || node._io) ? 'block' : 'none') + ';">';
    str += this.addNode(node);
    str += '</div>';
  }
  this.aIndent.pop();
  return str;
};

// Adds the empty and line icons
dTree.prototype.indent = function(node, nodeId) {
  var str = '';
  if (this.root.id != node.pid) {
    for (var n=0; n<this.aIndent.length; n++)
      str += '<img src="' + ( (this.aIndent[n] == 1 && this.config.useLines) ? this.icon.line : this.icon.empty ) + '" alt="" />';
    (node._ls) ? this.aIndent.push(0) : this.aIndent.push(1);
    if (node._hc) {
      str += '<a href="#" onclick =" ' + this.obj + '.o(' + nodeId + ');"><img id="j' + this.obj + nodeId + '" src="';
      if (!this.config.useLines) str += (node._io) ? this.icon.nlMinus : this.icon.nlPlus;
      else str += ( (node._io) ? ((node._ls && this.config.useLines) ? this.icon.minusBottom : this.icon.minus) : ((node._ls && this.config.useLines) ? this.icon.plusBottom : this.icon.plus ) );
      str += '" alt="" /></a>';
    } else str += '<img src="' + ( (this.config.useLines) ? ((node._ls) ? this.icon.joinBottom : this.icon.join ) : this.icon.empty) + '" alt="" />';
  }
  return str;
};

// Checks if a node has any children and if it is the last sibling
dTree.prototype.setCS = function(node) {
  var lastId;
  for (var n=0; n<this.aNodes.length; n++) {
    if (this.aNodes[n].pid == node.id) node._hc = true;
    if (this.aNodes[n].pid == node.pid) lastId = this.aNodes[n].id;
  }
  if (lastId==node.id) node._ls = true;
};

// Returns the selected node
dTree.prototype.getSelected = function() {
  var sn = this.getCookie('cs' + this.obj);
  return (sn) ? sn : null;
};

// Highlights the selected node
dTree.prototype.s = function(id) {
  if (!this.config.useSelection) return;
  var cn = this.aNodes[id];
  if (cn._hc && !this.config.folderLinks) return;
  if (this.selectedNode != id) {
    if (this.selectedNode || this.selectedNode==0) {
      eOld = document.getElementById("s" + this.obj + this.selectedNode);
      eOld.className = "node";
    }
    eNew = document.getElementById("s" + this.obj + id);
    eNew.className = "nodeSel";
    this.selectedNode = id;
    if (this.config.useCookies) this.setCookie('cs' + this.obj, cn.id);
  }
  if(setPosition){
  	setPosition(cn);
  }
};

// Toggle Open or close
dTree.prototype.o = function(id) {
  var cn = this.aNodes[id];
  this.nodeStatus(!cn._io, id, cn._ls);
  cn._io = !cn._io;
  if (this.config.closeSameLevel) this.closeLevel(cn);
  if (this.config.useCookies) this.updateCookie();
};

// Open or close all nodes
dTree.prototype.oAll = function(status) {
  for (var n=0; n<this.aNodes.length; n++) {
    if (this.aNodes[n]._hc && this.aNodes[n].pid != this.root.id) {
      this.nodeStatus(status, n, this.aNodes[n]._ls)
      this.aNodes[n]._io = status;
    }
  }
  if (this.config.useCookies) this.updateCookie();
};

// Opens the tree to a specific node
dTree.prototype.openTo = function(nId, bSelect, bFirst) {
  if (!bFirst) {
    for (var n=0; n<this.aNodes.length; n++) {
      if (this.aNodes[n].id == nId) {
        nId=n;
        break;
      }
    }
  }
  var cn=this.aNodes[nId];
  if (cn.pid==this.root.id || !cn._p) return;
  cn._io = true;
  cn._is = bSelect;
  if (this.completed && cn._hc) this.nodeStatus(true, cn._ai, cn._ls);
  if (this.completed && bSelect) this.s(cn._ai);
  else if (bSelect) this._sn=cn._ai;
  this.openTo(cn._p._ai, false, true);
};

// Closes all nodes on the same level as certain node
dTree.prototype.closeLevel = function(node) {
  for (var n=0; n<this.aNodes.length; n++) {
    if (this.aNodes[n].pid == node.pid && this.aNodes[n].id != node.id && this.aNodes[n]._hc) {
      this.nodeStatus(false, n, this.aNodes[n]._ls);
      this.aNodes[n]._io = false;
      this.closeAllChildren(this.aNodes[n]);
    }
  }
}

// Closes all children of a node
dTree.prototype.closeAllChildren = function(node) {
  for (var n=0; n<this.aNodes.length; n++) {
    if (this.aNodes[n].pid == node.id && this.aNodes[n]._hc) {
      if (this.aNodes[n]._io) this.nodeStatus(false, n, this.aNodes[n]._ls);
      this.aNodes[n]._io = false;
      this.closeAllChildren(this.aNodes[n]);
    }
  }
}

// Change the status of a node(open or closed)
dTree.prototype.nodeStatus = function(status, id, bottom) {
  eDiv  = document.getElementById('d' + this.obj + id);
  eJoin = document.getElementById('j' + this.obj + id);
  if (this.config.useIcons) {
    eIcon = document.getElementById('i' + this.obj + id);
    eIcon.src = (status) ? this.aNodes[id].iconOpen : this.aNodes[id].icon;
  }
  eJoin.src = (this.config.useLines)?
  ((status)?((bottom)?this.icon.minusBottom:this.icon.minus):((bottom)?this.icon.plusBottom:this.icon.plus)):
  ((status)?this.icon.nlMinus:this.icon.nlPlus);
  eDiv.style.display = (status) ? 'block': 'none';
};


// [Cookie] Clears a cookie
dTree.prototype.clearCookie = function() {
  var now = new Date();
  var yesterday = new Date(now.getTime() - 1000 * 60 * 60 * 24);
  this.setCookie('co'+this.obj, 'cookieValue', yesterday);
  this.setCookie('cs'+this.obj, 'cookieValue', yesterday);
};

// [Cookie] Sets value in a cookie
dTree.prototype.setCookie = function(cookieName, cookieValue, expires, path, domain, secure) {
  document.cookie =
    escape(cookieName) + '=' + escape(cookieValue)
    + (expires ? '; expires=' + expires.toGMTString() : '')
    + (path ? '; path=' + path : '')
    + (domain ? '; domain=' + domain : '')
    + (secure ? '; secure' : '');
};

// [Cookie] Gets a value from a cookie
dTree.prototype.getCookie = function(cookieName) {
  var cookieValue = '';
  var posName = document.cookie.indexOf(escape(cookieName) + '=');
  if (posName != -1) {
    var posValue = posName + (escape(cookieName) + '=').length;
    var endPos = document.cookie.indexOf(';', posValue);
    if (endPos != -1) cookieValue = unescape(document.cookie.substring(posValue, endPos));
    else cookieValue = unescape(document.cookie.substring(posValue));
  }
  return (cookieValue);
};

// [Cookie] Returns ids of open nodes as a string
dTree.prototype.updateCookie = function() {
  var str = '';
  for (var n=0; n<this.aNodes.length; n++) {
    if (this.aNodes[n]._io && this.aNodes[n].pid != this.root.id) {
      if (str) str += '.';
      str += this.aNodes[n].id;
    }
  }
  this.setCookie('co' + this.obj, str);
};

// [Cookie] Checks if a node id is in a cookie
dTree.prototype.isOpen = function(id) {
  var aOpen = this.getCookie('co' + this.obj).split('.');
  for (var n=0; n<aOpen.length; n++)
    if (aOpen[n] == id) return true;
  return false;
};

// If Push and pop is not implemented by the browser
if (!Array.prototype.push) {
  Array.prototype.push = function array_push() {
    for(var i=0;i<arguments.length;i++)
      this[this.length]=arguments[i];
    return this.length;
  }
};
if (!Array.prototype.pop) {
  Array.prototype.pop = function array_pop() {
    lastElement = this[this.length-1];
    this.length = Math.max(this.length-1,0);
    return lastElement;
  }
};

dTree.prototype.boundLowLevel=function(id){
  if(this.initIndex == false){
    for(var i=0;i<fm.treeCheckBox.length;i++){
      var value = fm.treeCheckBox[i].value;
      for (var n=0; n<this.aNodes.length; n++) {
        if(this.aNodes[n].id==value){
          this.aNodes[n].index = i;
          break;
        }
      }
    }
    this.initIndex = true;
  }
  var node = this.aNodes[id];
  for (var n=0; n<this.aNodes.length; n++) {
    if (this.aNodes[n].pid == node.id && this.aNodes[n].id != node.id) {
      if(fm.treeCheckBox[this.aNodes[n].index].disabled==false){
        fm.treeCheckBox[this.aNodes[n].index].checked=fm.treeCheckBox[node.index].checked;
      }
    }
  }
};
dTree.prototype.singleSelect=function(checkBox){
    for(var i=0;i<fm.treeCheckBox.length;i++){
      if(fm.treeCheckBox[i] != checkBox){
         fm.treeCheckBox[i].checked = false;
      }
    }
}
dTree.prototype.nodeSelect = function(span){
	var comCode = "";
	var comName = "";
	comCode = span.codeValue;
	comName = span.codeName;
	window.returnValue = comCode + "#" + comName;
	window.close();
}
dTree.prototype.nodeOver = function(span){
	span.className = "nodeSpanOver";
}
dTree.prototype.nodeOut = function(span){
	span.className = "nodeSpan";
}