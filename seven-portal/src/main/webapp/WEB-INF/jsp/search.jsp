<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<title>图书搜索</title>
<%@ include file="indexbanner.jsp"%>
</head>
<body>
	<div class="content content-nav-base commodity-content">
		<div class="commod-cont-wrap">
			<div class="commod-cont w1200 layui-clear">			 
			<div class="right-cont"></div>              
				<div class="product-list-box" id="product-list-box">
					<div class="product-list-cont w1200">
						<div class="product-item-box layui-clear" id="list-cont">
							 <c:forEach items="${list}" var="bookSolr">
           						 <div class="list-item">
									<a href="/book/details?id=${bookSolr.id }"><img src="${bookSolr.image }"height="180" width="150"></a>
									<p>${bookSolr.bookName }</p>
									<span>￥${bookSolr.price/100 }</span>
								</div>
  							</c:forEach>			
						</div>
					</div>
					<!-- //pager是根标签所有的分页标签都在它里面 其中url是你点击页码需要请求的action相当于form表单action ///items是获取数据库中记录总数  pager正是根据这个值来进行计算页码的 export是变量意义-->							
							<!-- maxPageItems每页最多显示几条maxIndexPages最多显示几个页码默认二者都是10 -->
							<pg:pager url="/search/book" items="${count}"  export="currentPageNumber=pageNumber" maxPageItems="10" maxIndexPages="5">								<!-- //param用于给后台传递数据参数，形式使用url参数向后台发送 -->
	                			 <pg:param name="q" value="${queryString }"/> 
	                			<%--  //fist是首页标签${pageUrl}是固定写法它的值形如Selstudent?pager.offset=0 --%>
	                			<!-- 表示发送一个pager.offset=0的参数给后台。用于数据库从指针为0开始查询 -->
								<pg:first>
									<!-- c:if用于判断当前页是否是第一页如果是则首页无法点击 -->										
									<font size="3"color="black"><a <c:if test="${currentPageNumber!=pageNumber}"> href="${pageUrl}" </c:if>>首页</a></font>
								</pg:first>
								<!-- //以下与首页类似 -->
								<pg:prev>
									<font size="3"color="black"><a href="${pageUrl}">前页</a></font>
								</pg:prev>
								<pg:pages>
									<c:choose>
										<c:when test="${currentPageNumber eq pageNumber}">
											<font size="3"color="red">${pageNumber }</font>
										</c:when>
										<c:otherwise>	
											<font size="3"color="black"><a href="${pageUrl}">${pageNumber }</a></font>
										</c:otherwise>
									</c:choose>
								</pg:pages>
								<pg:next>
									<font size="3"color="black"><a href="${pageUrl}" >后页</a></font>
								</pg:next>
								<pg:last>
									<font size="3"color="black"><a <c:if test="${currentPageNumber!=pageNumber}"> href="${pageUrl}" </c:if>>尾页</a></font>					
								</pg:last>
							</pg:pager>
				</div>
				
			</div>
		</div>
		</div>
		<!-- 模版引擎导入 -->
		<script type="text/html" id="demo">
              {{# layui.each(d.menu.milk.content,function(index,item){}}    
                <div class="item">
                  <div class="img">
                    <a href="javascript:;"><img src="{{item.img}}"></a>
                  </div>
                  <div class="text">
                    <p class="title"></p>
                    <p class="price">
                      <span class="pri">{{item.pri}}</span>
                      <span class="nub">{{item.nub}}</span>
                    </p>
                  </div>
                </div>
              {{# }); }}
            </script>
		<div id="demo0" style="text-align: center;"></div>
	</div>
	</div>
	</div>
	</div>
	</div>
	<script>
		layui.config({
			base : '${pageContext.request.contextPath}/static/js/' //你存放新模块的目录，注意，不是layui的模块目录
		}).use([ 'mm', 'laypage', 'jquery' ], function() {
			var laypage = layui.laypage, $ = layui.$, mm = layui.mm;
			laypage.render({
				elem : 'demo0',
				count : 100
			//数据总数
			});

		 // 模版引擎导入
			  var html = demo.innerHTML;
			  var listCont = document.getElementById('list-cont');
			  console.log(layui.router("#/about.html"))
			 mm.request({
			     url: '../json/commodity.json',
			     success : function(res){
			       console.log(res)
			      listCont.innerHTML = mm.renderHtml(html,res)
			     },
			     error: function(res){
			       console.log(res);
			     }
			   }) 

			$('.sort a').on('click', function() {
				$(this).addClass('active').siblings().removeClass('active');
			})
			$('.list-box dt').on('click', function() {
				if ($(this).attr('off')) {
					$(this).removeClass('active').siblings('dd').show()
					$(this).attr('off', '')
				} else {
					$(this).addClass('active').siblings('dd').hide()
					$(this).attr('off', true)
				}
			})

		});
	</script>
	<%@ include file="foot.jsp"%>

</body>
</html>