	<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="headerAdmin.jsp" %>
	<main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">List Detail Product</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Detail Product</li>
                        </ol>
                        <!-- <a href="#" class=" btn btn-primary mb-3">Thêm sản phẩm</a> -->
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                DataTable Example
                            </div>
                            <div class="card-body">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Name</th>
                                            <th>Screen Technology</th>
                                            <th>Screen Resolution</th>
                                            <th>Screen Size</th>
                                            <th>Ram</th>
                                            <th>Chip</th>
                                            <th>Acction</th>
                                        </tr>
                                    </thead>
                                    <tbody>
	                                    <c:forEach items="${listP}" var="o">
							                <tr>
							                    <td>${o.id}</td>
							                    <td>${o.productName}</td>
							                    <td>${productDetails.screenTechnology}</td>
							                    <td>${productDetails.screenResolution}</td>
							                    <td>${productDetails.screenSize}</td>
							                    <td>${productDetails.ram}</td>
							                    <td>${productDetails.chip}</td>
							                    <td>
							                        <!-- Nút để mở modal hiển thị chi tiết sản phẩm -->
<a href="#" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal">Xem chi tiết</a>

<!-- Nút để mở modal thêm hoặc sửa chi tiết sản phẩm -->
<a href="#" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#editProductDetailsModal">Update</a>

							                    </td>
							                </tr>
							            </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        
                        </div>
                        <!-- <div style="height: 100vh"></div>
                        <div class="card mb-4"><div class="card-body">When scrolling, the navigation stays at the top of the page. This is the end of the static navigation demo.</div></div> -->
                    </div>
                </main>
                <%@include file="footerAdmin.jsp" %>