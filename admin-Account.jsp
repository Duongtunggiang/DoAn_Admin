<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="headerAdmin.jsp" %>
                <main>   
                    <div class="container-fluid my-5 mt-5">
                        <div class="row">
                        <div class="col-md-4">
                            <div class="card">
                            <img src="https://via.placeholder.com/150" class="card-img-top" alt="Ảnh đại diện quản trị viên">
                            <div class="card-body">
                                <h5 class="card-title">Nguyễn Văn A</h5>
                                <p class="card-text">Quản trị viên</p>
                            </div>
                            </div>
                        </div>
                        <div class="col-md-8">
                            <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Thông tin cá nhân</h5>
                                <div class="row">
                                <div class="col-md-6">
                                    <p><strong>Tên:</strong> Nguyễn Văn A</p>
                                    <p><strong>Email:</strong> nguyenvana@example.com</p>
                                    <p><strong>Điện thoại:</strong> 123-456-7890</p>
                                </div>
                                <div class="col-md-6">
                                    <p><strong>Vai trò:</strong> Quản trị viên</p>
                                    <p><strong>Đăng nhập lần cuối:</strong> 2023-06-09 15:30:00</p>
                                    <p><strong>Ngày tham gia:</strong> 2021-01-01</p>
                                </div>
                                </div>
                            </div>
                            </div>
                            <div class="card mt-4">
                            <div class="card-body">
                                <h5 class="card-title">Hoạt động</h5>
                                <ul class="list-group list-group-flush">
                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                    <div>
                                    <strong>Đã tạo 5 người dùng mới</strong>
                                    <p class="text-muted mb-0">2023-06-07 10:15:00</p>
                                    </div>
                                    <span class="badge bg-primary rounded-pill">5</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                    <div>
                                    <strong>Đã phê duyệt 10 yêu cầu đăng ký</strong>
                                    <p class="text-muted mb-0">2023-06-05 14:20:00</p>
                                    </div>
                                    <span class="badge bg-primary rounded-pill">10</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                    <div>
                                    <strong>Đã cập nhật cài đặt hệ thống</strong>
                                    <p class="text-muted mb-0">2023-06-03 09:45:00</p>
                                    </div>
                                    <span class="badge bg-primary rounded-pill">1</span>
                                </li>
                                </ul>
                            </div>
                            </div>
                        </div>
                        </div>
                    </div>
                    <div class="card-footer d-flex justify-content-end">
                        <a href="update_admin.html" class="btn btn-primary mr-2 m-2">Cập nhật</a>
                        <a href="index.html" class="btn btn-secondary m-2">Thoát</a>
                    </div>
                </main>
<%@include file="footerAdmin.jsp" %>