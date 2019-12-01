<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	 <ul id="contentCategory" class="easyui-tree">
    </ul>
</div>
<div id="contentCategoryMenu" class="easyui-menu" style="width:120px;" data-options="onClick:menuHandler">
    <div data-options="iconCls:'icon-add',name:'add'">添加</div>
    <div data-options="iconCls:'icon-remove',name:'rename'">重命名</div>
    <div class="menu-sep"></div>
    <div data-options="iconCls:'icon-remove',name:'delete'">删除</div>
</div>
<script type="text/javascript">
$(function(){    
	$("#contentCategory").tree({    //通过ID选择器创建一个树
		url : '/item/cat/list',		//跳转到后台的路径
		animate: true,				
		method : "GET",				//方法是get请求
		onContextMenu: function(e,node){
            e.preventDefault();
            $(this).tree('select',node.target);
            $('#contentCategoryMenu').menu('show',{
                left: e.pageX,
                top: e.pageY
            });
        },
        
        
        
        onAfterEdit : function(node){
        	var _tree = $(this);
        	if(node.id == 0){
        		// 新增节点
        		$.post("/item/cat/create",{parentId:node.parentId,name:node.text},function(data){
        			if(data.status == 200){   //状态码=200，就是成功的
        				_tree.tree("update",{
            				target : node.target,
            				id : data.data.id
            			});
        			}else{
        				$.messager.alert('提示','创建'+node.text+' 分类失败!');
        			}
        		});
        	}else{
        		//更新节点
        		$.post("/item/cat/update",{id:node.id,name:node.text});
        	}
        }
	});
});




function menuHandler(item){
	var tree = $("#contentCategory");
	var node = tree.tree("getSelected");
	if(item.name === "add"){
		tree.tree('append', {
            parent: (node?node.target:null),
            data: [{
                text: '新建分类',
                id : 0,
                parentId : node.id
            }]
        }); 
		//重命名
		var _node = tree.tree('find',0);
		tree.tree("select",_node.target).tree('beginEdit',_node.target);
	}else if(item.name === "rename"){
		tree.tree('beginEdit',node.target);
		//删除
	}else if(item.name === "delete"){
		$.messager.confirm('确认','确定删除名为 '+node.text+' 的分类吗？',function(r){
			if(r){
				$.post("/item/cat/delete",{parentId:node.parentId,id:node.id},function(data){
					if(data.status == 200){
						tree.tree("remove",node.target);
        			}else{
        				$.messager.alert('提示','目录下有子目录或者商品，导致删除失败！');
        			}
				});	
			}
		});
	}
}
</script>