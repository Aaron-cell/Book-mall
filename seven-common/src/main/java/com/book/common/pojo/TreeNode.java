package com.book.common.pojo;
/**
 * tree控件的实体类
 * @ClassName: TreeNode
 * @Title: TreeNode
 * @author:
 * @date: 2019年8月18日
 */
public class TreeNode {
	//绑定节点的标识符
	private long id;
	//显示的节点文本 即类名
	private String text;
	//节点状态  closed：该节点已关闭 open：该节点已打开
	private String state;
	
	public TreeNode(long id, String text, String state) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
	}

	public TreeNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
