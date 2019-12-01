<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <script type="text/javascript">
        function qq(value,name){
        	
	        $.post("/user/seek/"+name,{value : value});
	        $("#itemParamList").datagrid("reload");
        }
    </script>
    <input id="ss" class="easyui-searchbox" style="width:300px"
        data-options="searcher:qq,prompt:'Please Input Value',menu:'#mm'"></input>
    <div id="mm" style="width:120px">
        <div data-options="name:'nickname',iconCls:'icon-ok'">用户昵称</div>
        <div data-options="name:'username',iconCls:'icon-man'">用户名</div>
    </div>
<table class="easyui-datagrid" id="itemParamList" title="用户列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/user/list',method:'get',pageSize:30,toolbar:itemParamListToolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60">ID</th>
        	<th data-options="field:'nickname',width:100">用户昵称</th>
        	<th data-options="field:'username',width:100">用户名</th>
        	<th data-options="field:'phone',width:100">电话</th>
        	<th data-options="field:'email',width:150">邮箱</th>
        	<th data-options="field:'status',width:60,align:'center',formatter:TAOTAO.formatItemStatus">状态</th>
            <th data-options="field:'created',width:150,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
            <th data-options="field:'updated',width:150,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
        </tr>
    </thead>
</table>
<script>
	function formatItemParamData(value , index){
		var json = JSON.parse(value);
		var array = [];
		$.each(json,function(i,e){
			array.push(e.group);
		});
		return array.join(",");
	}

    function getSelectionsIds(){
    	var itemList = $("#itemParamList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var itemParamListToolbar = ['-',{
        text:'不启用',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中用户!');
        		return ;
        	}
        	$.messager.confirm('确认','确定不启用ID为 '+ids+' 的用户吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/user/instock",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','用户状态修改成功!',undefined,function(){
            					$("#itemParamList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },{
        text:'启用',
        iconCls:'icon-ok',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中用户!');
        		return ;
        	}
        	$.messager.confirm('确认','确定启用ID为 '+ids+' 的用户吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/user/reshelf",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','用户状态修改成功!',undefined,function(){
            					$("#itemParamList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>