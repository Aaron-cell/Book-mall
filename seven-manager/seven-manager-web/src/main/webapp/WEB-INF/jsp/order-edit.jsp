<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="orderEditForm" class="orderForm" method="post">
		<input type="hidden" name="orderId"/>
	    <table cellpadding="5">
		     <tr>                                                             
		        <input id="cc1" class="easyui-combobox" name="receiverState" data-options="
		        valueField: 'id',
		        textField: 'text',  
		        url: '/get/receiverState',    
		        onSelect: function(rec){
		        	$('#cc2').combobox('clear'); 
		        	$('#cc3').combobox('clear'); 
		            var url = '/get/receiverCity?id='+rec.id;    
		            $('#cc2').combobox('reload', url);    
        		}"/>   
				<input id="cc2" class="easyui-combobox" name="receiverCity" data-options="
				valueField:'id',
				textField:'text',
				onSelect: function(rec){    
		            var url = '/get/receiverCity?id='+rec.id;    
		            $('#cc3').combobox('reload', url);    
        		}"/>  
				<input id="cc3" class="easyui-combobox" name="receiverDistrict" data-options="valueField:'id',textField:'text'"/>  
	        </tr>
	     	<tr>
	            <td>收货地址:</td>
	            <td><input class="easyui-textbox" name="receiverAddress" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>用户真实姓名</td>
	            <td><input class="easyui-textbox" type="text" name="receiverName" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        
	         <tr>
	            <td>移动电话:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverMobile" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        	<tr>
	            <td>固定电话:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverPhone" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>邮政编码:</td>
	            <td>
	                <input class="easyui-textbox" type="text" name="receiverZip" data-options="validType:'length[1,30]'" />
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function submitForm(){
		if(!$('#itemeEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}		
		$.post("/rest/order/update",$("#orderEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','地址修改成功!','info',function(){
					$("#orderEditWindow").window('close');
					$("#orderList").datagrid("reload");
				});
			}
		});
	}
</script>
