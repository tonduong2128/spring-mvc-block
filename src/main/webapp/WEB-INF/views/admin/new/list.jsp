<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new" />
<c:url var="NewURL" value="/admin-new" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài viết</title>
</head>

<body>
	<div class="main-content">
		<form action="<c:url value='/admin-new'/>" id="formSubmit"
			method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty messageResponse}">
								<div class="alert alert-${alert}">${messageResponse}</div>
							</c:if>
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
											<a flag="info"
												class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Thêm bài viết'
												href='<c:url value="/admin-new?type=edit"/>'> <span>
													<i class="fa fa-plus-circle bigger-110 purple"></i>
											</span>
											</a>
											<button id="btnDelete" type="button"
												class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Xóa bài viết'>
												<span> <i class="fa fa-trash-o bigger-110 pink"></i>
												</span>
											</button>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th><input type="checkbox" id="checkAll"
														class="checkbox-all"></th>
													<th>Tên bài viết</th>
													<th>Mô tả ngắn</th>
													<th>Thao tác</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult}">
													<tr>
														<td><input type="checkbox" class="checkbox-item"
															id="checkbox_${item.id}" value="${item.id}"></td>
														<td>${item.title}</td>
														<td>${item.shortDescription}</td>
														<td><c:url var="editURL" value="/admin-new">
																<c:param name="type" value="edit" />
																<c:param name="id" value="${item.id}" />
															</c:url> <a class="btn btn-sm btn-primary btn-edit"
															data-toggle="tooltip" title="Cập nhật bài viết"
															href='${editURL}'><i class="fa fa-pencil-square-o"
																aria-hidden="true"></i> </a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>

										<div class="text-center">
											<ul class="pagination"></ul>
										</div>

										<input type="hidden" value="" id="page" name="page" /> <input
											type="hidden" value="" id="maxPageItem" name="maxPageItem" />
										<input type="hidden" value="" id="sortName" name="sortName" />
										<input type="hidden" value="" id="sortBy" name="sortBy" /> <input
											type="hidden" value="" id="type" name="type" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script>
			const checkboxAll = document.querySelector(".checkbox-all");
			const checkboxs = Array.from(document.querySelectorAll(".checkbox-item"));
			checkboxs.forEach((checkbox)=>{
				checkbox.onclick = (e)=>{
					const checkedAll = checkboxs.some((item)=>item.checked);
					checkboxAll.checked = checkedAll;
				}
			})
			checkboxAll.onclick = (e)=>{
				const checkedAll = checkboxs.every((item)=>item.checked);
				checkboxs.forEach((checkbox)=>{
					checkbox.checked = !checkedAll;
				})
			}
		</script>
	<!-- /.main-content -->
	<script>
		const pagination = (select, option) => {
        const page =
          document.getElementById(select) ||
          document.querySelector("." + select);
        const render = (active) => {
          page.innerHTML = "";
          for (let index = 1; index <= option.total; index++) {
            const item = document.createElement("li");
            item.classList.add("page-item");
            const innerItem = document.createElement("a");
            innerItem.classList.add("page-link");
            //innerItem.setAttribute("href", "./admin-news?count=" + index+"&limit=" +option.visible);
            innerItem.innerText = index;
            item.appendChild(innerItem);
            item.onclick = (e) => {
              const url = "http://localhost:8000/api-admin/news?count="+ index +"&limit="+option.visible;
              option.onClick(url, e.target.innerText);
              render(e.target.innerText);
            };
            if (index == active) {
              item.classList.add("active");
            }
            page.appendChild(item);
          }
        };
        render(option.active);
      };
      pagination("pagination", {
        visible: ${limit},
        total: Math.ceil(${count}/${limit}),
        active: ${page},
        onClick: (url, value) => {
          fetch(url)
          .then(response => response.json())
          .then(data => 
          	{
          		const row  = document.querySelector(".rowBody");
          		row.innerHTML = "";
          		data.forEach((item, index)=>{
					row.innerHTML+=''+
						'<tr class="rowItem">'+
						'<th scope="row">' + ++index+'</th>'+
						'<td>' + item.title + '</td>' +
						'<td>'+item.shortdescription + '</td>'+
					'</tr>'
					;          			
          		})
          	}
          ); 
          },
      });
	</script>
</body>

</html>