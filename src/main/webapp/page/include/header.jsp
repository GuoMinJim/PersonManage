<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<header class="am-topbar admin-header">
    <div class="am-topbar-brand">
        <i class="am-icon-weixin"></i> <strong>WebChat</strong> <small>网页聊天室</small>
    </div>
    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>
    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
            <li class="am-dropdown" data-am-dropdown>
                <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                    ${userid} <span class="am-icon-caret-down"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="${ctx}/${userid}"><span class="am-icon-user"></span> 资料</a></li>
                    <li><a href="${ctx}/${userid}/config"><span class="am-icon-cog"></span> 设置</a></li>
                    <li><a href="${ctx}/user/logout"><span class="am-icon-power-off"></span> 注销</a></li>
                </ul>
            </li>
        </ul>
    </div>
</header>