<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="easyui-panel" title="Nested Panel" data-options="width:'100%',minHeight:500,noheader:true,border:false" style="padding:10px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',split:false" style="width:250px;padding:5px">
            <ul id="contentCategoryTree" class="easyui-tree" data-options="url:'/item/cat/list',animate: true,method : 'GET'">
            </ul>
        </div>
        <div data-options="region:'center'" style="padding:5px">
            <table class="easyui-datagrid" id="contentList" data-options="toolbar:contentListToolbar,singleSelect:false,collapsible:true,pagination:true,method:'get',pageSize:20,url:'/content/query/list',queryParams:{categoryId:0}">
		    <thead>
		       <tr>
		    	<th data-options="field:'ck',checkbox:true"></th>
		    	<th data-options="field:'id',width:120">图书ID</th>
		        <th data-options="field:'bookName',width:150">图书名称</th>
		        <th data-options="field:'cid',width:60">叶子类目</th>
		        <th data-options="field:'author',width:80">作者</th>
		        <th data-options="field:'sellPoint',width:250">卖点</th>
		        <th data-options="field:'price',width:50,align:'right',formatter:TAOTAO.formatPrice">价格</th>
		        <th data-options="field:'num',width:40,align:'right'">库存数量</th>
		        <th data-options="field:'status',width:60,align:'center',formatter:TAOTAO.formatItemStatus">状态</th>
		        <th data-options="field:'created',width:100,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
		        <th data-options="field:'updated',width:100,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
			  </tr>
		   </thead>
		</table>
        </div>
    </div>
</div>
<script type="text/javascript">
$(function(){
	var tree = $("#contentCategoryTree");
	var datagrid = $("#contentList");
	tree.tree({
		onClick : function(node){
			if(tree.tree("isLeaf",node.target)){
				datagrid.datagrid('reload', {
					categoryId :node.id
		        });
			}
		}
	});
});
var contentListToolbar = [{
    text:'新增',
    iconCls:'icon-add',
    handler:function(){
    	var node = $("#contentCategoryTree").tree("getSelected");
    	if(!node || !$("#contentCategoryTree").tree("isLeaf",node.target)){
    		$.messager.alert('提示','新增内容必须选择一个内容分类!');
    		return ;
    	}
    	TT.createWindow({
			url : "/item-add"
		}); 
    }
},{
    text:'编辑',
    iconCls:'icon-edit',
    handler:function(){
    	var ids = TT.getSelectionsIds("#contentList");
    	if(ids.length == 0){
    		$.messager.alert('提示','必须选择一个内容才能编辑!');
    		return ;
    	}
    	if(ids.indexOf(',') > 0){
    		$.messager.alert('提示','只能选择一个内容!');
    		return ;
    	}
		TT.createWindow({
			url : "/item-content-edit",
			onLoad : function(){
				var data = $("#contentList").datagrid("getSelections")[0];
				data.priceView = TAOTAO.formatPrice(data.price);
				$("#itemeEditForm").form("load",data);
		
				// 加载商品描述
    			$.getJSON('/rest/item/query/item/desc/'+data.id,function(_data){
    				if(_data.status == 200){
    					itemEditEditor.html(_data.data.bookDesc);
    				}
    			});
    			TAOTAO.init({
    				"pics" : data.image,
    				"cid" : data.cid,
    				fun:function(node){
    					TAOTAO.changeItemParam(node, "itemeEditForm");
    				}
    			});
			}
		});    	
    }
},{
    text:'删除',
    iconCls:'icon-cancel',
    handler:function(){
    	var ids = TT.getSelectionsIds("#contentList");
    	if(ids.length == 0){
    		$.messager.alert('提示','未选中商品!');
    		return ;
    	}
    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的内容吗？',function(r){
    	    if (r){
    	    	var params = {"ids":ids};
            	$.post("/rest/item/delete",params, function(data){
        			if(data.status == 200){
        				$.messager.alert('提示','删除内容成功!',undefined,function(){
        					$("#contentList").datagrid("reload");
        				});
        			}
        		});
    	    }
    	});
    }
}];
</script>