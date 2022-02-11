
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/base/home.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Bảng điều khiển </span>
        <div class="spacer2"></div>
    </div>
    <div class="report">
        <div class="report__table">
            <label>Số lượng người cách ly mới</label>
            <div>
                <img class="bieudo" src="<%=request.getContextPath()%>/assets/img/thumb/bieudo.jpg" />
            </div>
        </div>
        <div class="report__info">
            <div class="report__info-class report__info-class__blue">
                <label class="report-label"><i class="fas fa-user"></i> Người cách ly</label>
                <ul class="report-label__info">
                    <li>Hôm nay <span>10</span></li>
                    <li>Tháng này <span>10</span></li>
                </ul>
            </div>
            
            
            <div class="report__info-class report__info-class__orange">
                <label class="report-label"><i class="fas fa-bed"></i> Sức chứa</label>
                <ul class="report-label__info">
                    <li>Hiện tại <span>10</span></li>
                    <li>Còn trống <span>10</span></li>
                    <li>Tổng <span>20</span></li>
                </ul>
            </div>
        </div>
    </div>
</div>

