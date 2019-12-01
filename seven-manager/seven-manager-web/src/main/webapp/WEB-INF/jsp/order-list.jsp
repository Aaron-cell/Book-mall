<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<table class="easyui-datagrid" id="orderList" title="订单列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/order/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'orderId',width:100">订单ID</th>
        	<th data-options="field:'nickname',width:80">用户昵称</th>
        	<th data-options="field:'bookId',width:130">书名</th>
        	<th data-options="field:'bookName',width:130">书名</th>
        	<th data-options="field:'price',width:70,align:'right',formatter:TAOTAO.formatPrice">价格</th>	
            <th data-options="field:'num',width:50">数量</th>
            <th data-options="field:'totalFee',width:80">图书总价</th>
            <th data-options="field:'payment',width:80">实付金额</th>
            <th data-options="field:'status',width:60,align:'center',formatter:TAOTAO.formatOrderStatus">物流状态</th>
            <th data-options="field:'createTime',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
            <th data-options="field:'updateTime',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
            <th data-options="field:'consignTime',width:130,align:'center',formatter:TAOTAO.formatDateTime">发货时间</th>
            <th data-options="field:'endTime',width:130,align:'center',formatter:TAOTAO.formatDateTime">交易完成时间</th>
        </tr>
    </thead>
</table>
<div id="orderEditWindow" class="easyui-window" title="编辑地址" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/order-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

	function getSelectionsIds(){
		var orderList = $("#orderList");
		var sels = orderList.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].id);
		}
		ids = ids.join(",");
		return ids;
	}
    
    var toolbar = [{
        text:'查看地址',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length+1 == 0){
        		$.messager.alert('提示','必须选择一个订单才能查看!');
        		return ;
        	}
        	if(ids.indexOf(',')+1 > 0){
        		$.messager.alert('提示','只能选择一个订单!');
        		return ;
        	}
        	$("#orderEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#orderList").datagrid("getSelections")[0];
        			data.priceView = TAOTAO.formatPrice(data.price);
        			$("#orderEditForm").form("load",data);
        		}
        	}).window("open");
        }
    }];
</script>