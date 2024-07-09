<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="headerAdmin.jsp" %>
<main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">List Product</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Product</li>
                        </ol>
                        <a href="#" class="btn btn-primary mb-3" data-bs-toggle="modal" data-bs-target="#addProductModal">Add new Product</a>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                DataTable Example
                            </div>
                            <div class="card-body">
                                <table class="table" id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Name</th>
                                            <th>Type</th>
                                            <th>image</th>
                                            <th>Old price</th>
                                            <th>New price</th>
                                            <th>Quantity</th>
                                            <th>Acction</th>
                                        </tr>
                                    </thead>
                                    <tbody>
	                                    <c:forEach items="${listP}" var="o">
										    <tr>
										        <td>${o.id}</td>
										        <td>${o.productName}</td>
										        <td>${productCategoryMap[o.id].categoryName}</td>
										        <td>
										            <img src="productImage?id=${o.id}" alt="${o.productName}" width="100" height="100"/>
										        </td>
										        <td>${o.oldPrice}</td>
										        <td ><p class="text-danger"><b>${o.unitPrice}</b></p></td>
										        <td>${o.quantity} </td>
										        <td>
										            <a href="#" class="btn btn-success m-2">Up</a>
										            <a href="${pageContext.request.contextPath}/deleteProduct?id=${o.id}" class="btn btn-danger m-2" onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này không?');">Del</a>
										        </td>
										    </tr>
										</c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <a href="${pageContext.request.contextPath}/sortProduct" class="btn btn-success">Sắp xếp</a>
                        <!-- <div style="height: 100vh"></div>
                        <div class="card mb-4"><div class="card-body">When scrolling, the navigation stays at the top of the page. This is the end of the static navigation demo.</div></div> -->
                    </div>
                </main>
<%@include file="footerAdmin.jsp" %>