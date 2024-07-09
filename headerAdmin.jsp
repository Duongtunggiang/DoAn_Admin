<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />

        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Mobile Smart Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="asset/css/admin.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
<!-- Modal thêm hoặc sửa chi tiết sản phẩm -->
<div class="modal fade" id="editProductDetailsModal" tabindex="-1" aria-labelledby="editProductDetailsModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editProductDetailsModalLabel">Thêm hoặc sửa chi tiết sản phẩm</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="${pageContext.request.contextPath}/editProductDetails" method="post">
          <input type="hidden" name="productId" id="modalProductId">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label for="screenTechnology">Công nghệ màn hình:</label>
                <input type="text" class="form-control" id="screenTechnology" name="screenTechnology" required>
              </div>
              <div class="form-group">
                <label for="screenResolution">Độ phân giải màn hình:</label>
                <input type="text" class="form-control" id="screenResolution" name="screenResolution" required>
              </div>
              <div class="form-group">
                <label for="glassQuality">Chất lượng kính màn hình:</label>
                <input type="text" class="form-control" id="glassQuality" name="glassQuality" required>
              </div>
              <div class="form-group">
                <label for="screenSize">Kích thước màn hình:</label>
                <input type="text" class="form-control" id="screenSize" name="screenSize" required>
              </div>
              <div class="form-group">
                <label for="rearCameraResolution">Độ phân giải camera sau:</label>
                <input type="text" class="form-control" id="rearCameraResolution" name="rearCameraResolution" required>
              </div>
              <div class="form-group">
                <label for="frontCameraResolution">Độ phân giải camera trước:</label>
                <input type="text" class="form-control" id="frontCameraResolution" name="frontCameraResolution" required>
              </div>
              <div class="form-group">
                <label for="rearCameraDetails">Chi tiết camera sau:</label>
                <input type="text" class="form-control" id="rearCameraDetails" name="rearCameraDetails" required>
              </div>
              <div class="form-group">
                <label for="videoRecordingCapability">Khả năng quay video:</label>
                <input type="text" class="form-control" id="videoRecordingCapability" name="videoRecordingCapability" required>
              </div>
              <div class="form-group">
                <label for="cameraFeatures">Tính năng camera:</label>
                <input type="text" class="form-control" id="cameraFeatures" name="cameraFeatures" required>
              </div>
            </div>
            <div class="col-md-6">
              <div class="form-group">
                <label for="processor">Vi xử lý:</label>
                <input type="text" class="form-control" id="processor" name="processor" required>
              </div>
              <div class="form-group">
                <label for="chip">Chip:</label>
                <input type="text" class="form-control" id="chip" name="chip" required>
              </div>
              <div class="form-group">
                <label for="operatingSystem">Hệ điều hành:</label>
                <input type="text" class="form-control" id="operatingSystem" name="operatingSystem" required>
              </div>
              <div class="form-group">
                <label for="ram">RAM:</label>
                <input type="text" class="form-control" id="ram" name="ram" required>
              </div>
              <div class="form-group">
                <label for="storage">Bộ nhớ trong:</label>
                <input type="text" class="form-control" id="storage" name="storage" required>
              </div>
              <div class="form-group">
                <label for="mobileNetworkSupport">Hỗ trợ mạng di động:</label>
                <input type="text" class="form-control" id="mobileNetworkSupport" name="mobileNetworkSupport" required>
              </div>
              <div class="form-group">
                <label for="wifiSupport">Kết nối WiFi:</label>
                <input type="text" class="form-control" id="wifiSupport" name="wifiSupport" required>
              </div>
              <div class="form-group">
                <label for="bluetoothSupport">Kết nối Bluetooth:</label>
                <input type="text" class="form-control" id="bluetoothSupport" name="bluetoothSupport" required>
              </div>
              <div class="form-group">
                <label for="gpsSupport">Hỗ trợ GPS:</label>
                <input type="text" class="form-control" id="gpsSupport" name="gpsSupport" required>
              </div>
              <div class="form-group">
                <label for="connectivityPorts">Cổng kết nối:</label>
                <input type="text" class="form-control" id="connectivityPorts" name="connectivityPorts" required>
              </div>
              <div class="form-group">
                <label for="batteryCapacity">Dung lượng pin:</label>
                <input type="text" class="form-control" id="batteryCapacity" name="batteryCapacity" required>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="submit" class="btn btn-primary">Lưu</button>
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>

<script>
  document.addEventListener('DOMContentLoaded', function() {
    var updateButtons = document.querySelectorAll('.btn-update');
    var modalProductId = document.getElementById('modalProductId');
    var screenTechnology = document.getElementById('screenTechnology');
    var screenResolution = document.getElementById('screenResolution');
    var glassQuality = document.getElementById('glassQuality');
    var screenSize = document.get
    var screenSize = document.getElementById('screenSize');
    var rearCameraResolution = document.getElementById('rearCameraResolution');
    var frontCameraResolution = document.getElementById('frontCameraResolution');
    var rearCameraDetails = document.getElementById('rearCameraDetails');
    var videoRecordingCapability = document.getElementById('videoRecordingCapability');
    var cameraFeatures = document.getElementById('cameraFeatures');
    var processor = document.getElementById('processor');
    var chip = document.getElementById('chip');
    var operatingSystem = document.getElementById('operatingSystem');
    var ram = document.getElementById('ram');
    var storage = document.getElementById('storage');
    var mobileNetworkSupport = document.getElementById('mobileNetworkSupport');
    var wifiSupport = document.getElementById('wifiSupport');
    var bluetoothSupport = document.getElementById('bluetoothSupport');
    var gpsSupport = document.getElementById('gpsSupport');
    var connectivityPorts = document.getElementById('connectivityPorts');
    var batteryCapacity = document.getElementById('batteryCapacity');
    
    updateButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            modalProductId.value = this.getAttribute('data-id');
            screenTechnology.value = this.getAttribute('data-screenTechnology');
            screenResolution.value = this.getAttribute('data-screenResolution');
            glassQuality.value = this.getAttribute('data-glassQuality');
            screenSize.value = this.getAttribute('data-screenSize');
            rearCameraResolution.value = this.getAttribute('data-rearCameraResolution');
            frontCameraResolution.value = this.getAttribute('data-frontCameraResolution');
            rearCameraDetails.value = this.getAttribute('data-rearCameraDetails');
            videoRecordingCapability.value = this.getAttribute('data-videoRecordingCapability');
            cameraFeatures.value = this.getAttribute('data-cameraFeatures');
            processor.value = this.getAttribute('data-processor');
            chip.value = this.getAttribute('data-chip');
            operatingSystem.value = this.getAttribute('data-operatingSystem');
            ram.value = this.getAttribute('data-ram');
            storage.value = this.getAttribute('data-storage');
            mobileNetworkSupport.value = this.getAttribute('data-mobileNetworkSupport');
            wifiSupport.value = this.getAttribute('data-wifiSupport');
            bluetoothSupport.value = this.getAttribute('data-bluetoothSupport');
            gpsSupport.value = this.getAttribute('data-gpsSupport');
            connectivityPorts.value = this.getAttribute('data-connectivityPorts');
            batteryCapacity.value = this.getAttribute('data-batteryCapacity');
        });
    });
});
</script>

    <!-- Modal hiển thị chi tiết sản phẩm -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Chi tiết sản phẩm</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <c:forEach items="${productDetails}" var="detail">
          <div class="row">
            <div class="col-md-6">
              <p><strong>Công nghệ màn hình:</strong> ${detail.screenTechnology}</p>
              <p><strong>Kích thước màn hình:</strong> ${detail.screenSize}</p>
              <p><strong>Chất lượng kính màn hình:</strong> ${detail.glassQuality}</p>
              <p><strong>Độ phân giải màn hình:</strong> ${detail.screenResolution}</p>
            </div>
            <div class="col-md-6">
              <p><strong>Độ phân giải camera sau:</strong> ${detail.rearCameraResolution}</p>
              <p><strong>Độ phân giải camera trước:</strong> ${detail.frontCameraResolution}</p>
              <p><strong>Tính năng camera:</strong> ${detail.cameraFeatures}</p>
              <p><strong>Khả năng quay video:</strong> ${detail.videoRecordingCapability}</p>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
              <p><strong>Vi xử lý:</strong> ${detail.processor}</p>
              <p><strong>Chip:</strong> ${detail.chip}</p>
              <p><strong>Hệ điều hành:</strong> ${detail.operatingSystem}</p>
              <p><strong>RAM:</strong> ${detail.ram}</p>
            </div>
            <div class="col-md-6">
              <p><strong>Bộ nhớ trong:</strong> ${detail.storage}</p>
              <p><strong>Hỗ trợ mạng di động:</strong> ${detail.mobileNetworkSupport}</p>
              <p><strong>Kết nối WiFi:</strong> ${detail.wifiSupport}</p>
              <p><strong>Kết nối Bluetooth:</strong> ${detail.bluetoothSupport}</p>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
              <p><strong>Hỗ trợ GPS:</strong> ${detail.gpsSupport}</p>
              <p><strong>Cổng kết nối:</strong> ${detail.connectivityPorts}</p>
              <p><strong>Dung lượng pin:</strong> ${detail.batteryCapacity}</p>
            </div>
          </div>
        </c:forEach>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
      </div>
    </div>
  </div>
</div>
    
    <!-- Modal -->
    <div class="modal fade" id="addProductModal" tabindex="-1" aria-labelledby="addProductModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addProductModalLabel">Thêm sản phẩm mới</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="${pageContext.request.contextPath}/addProduct" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="productName">Tên sản phẩm:</label>
                            <input type="text" class="form-control" id="productName" name="productName" required>
                        </div>
                        <div class="form-group">
                            <label for="img">Thêm ảnh:</label>
                            <input type="file" class="form-control" id="img" name="img" required>
                        </div>
                        <div class="form-group">
                            <label for="unitPrice">Đơn giá:</label>
                            <input type="number" class="form-control" id="unitPrice" name="unitPrice" required>
                        </div>
                        <div class="form-group">
                            <label for="oldPrice">Đơn giá cũ:</label>
                            <input type="number" class="form-control" id="oldPrice" name="oldPrice" required>
                        </div>
                        <div class="form-group">
                            <label for="cid">Danh mục sản phẩm:</label>
                            <select class="form-control" id="cid" name="cid" required style="z-index: 999">
                                <c:forEach var="category" items="${ListC}">
                                    <option value="${category.id}">${category.categoryName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="quantity">Số lượng:</label>
                            <input type="number" class="form-control" id="quantity" name="quantity" required>
                        </div>
                        <button type="submit" class="btn btn-primary m-2">Lưu</button>
                        <button type="button" class="btn btn-secondary m-2" data-bs-dismiss="modal">Đóng</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.html">Start Bootstrap</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/admin-login.jsp">Login</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/admin-Account.jsp">Activity Log</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="${pageContext.request.contextPath}/admin.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Product
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/admin-product">Product</a>
                                    <a class="nav-link" href="${pageContext.request.contextPath}/admin-detail">Detail Product</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Pages
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Authentication
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/admin-login.jsp">Login</a>
                                            <a class="nav-link" href="#">Register</a>
                                            <a class="nav-link" href="#">Forgot Password</a>
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Error
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/401.jsp">401 Page</a>
                                            <a class="nav-link" href="${pageContext.request.contextPath}/404.jsp">404 Page</a>
                                            <a class="nav-link" href="${pageContext.request.contextPath}/500.jsp">500 Page</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseOther" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Other
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseOther" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/admin-order.jsp">Order</a>
                                    <a class="nav-link" href="${pageContext.request.contextPath}/admin-customer.jsp">Customer</a>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">Addons</div>
                            <a class="nav-link" href="${pageContext.request.contextPath}/admin-chart.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Charts
                            </a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/admin-login.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Tables
                            </a>
                            <div class="sb-sidenav-menu-heading">Setting</div>
                            <a class="nav-link" href="${pageContext.request.contextPath}/admin-setting.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-gear"></i></div>
                                Setting
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">