<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- sidebar start -->
<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
        <ul class="am-list admin-sidebar-list">
            <li><a href="${ctx}/chat"><span class="am-icon-commenting"></span> 聊天</a></li>
            <li><a href="${ctx}/${userid}" class="am-cf"><span class="am-icon-book"></span> 个人信息<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li class="admin-parent">
                <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-cogs"></span> 设置 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
                    <li><a href="${ctx}/${userid}/config"><span class="am-icon-group"></span> 个人设置</a></li>
                    <li><a href="${ctx}/system-setting"><span class="am-icon-cog"></span> 系统设置</a></li>
                </ul>
            </li>
            <li><a href="${ctx}/${userid}/log"><span class="am-icon-inbox"></span> 系统日志<span class="am-badge am-badge-secondary am-margin-right am-fr">24</span></a></li>
            <li><a href="${ctx}/help"><span class="am-icon-globe"></span> 帮助</a></li>
            <li><a href="${ctx}/about"><span class="am-icon-leaf"></span> 关于</a></li>
            <li><a href="${ctx}/user/logout"><span class="am-icon-sign-out"></span> 注销</a></li>
        </ul>
        <div class="am-panel am-panel-default admin-sidebar-panel">
            <div class="am-panel-bd">
                <p><span class="am-icon-tag"></span> Welcome</p>
                <p>欢迎使用WebChat聊天室~</p>
            </div>
        </div>
    </div>
</div>
<!-- sidebar end -->