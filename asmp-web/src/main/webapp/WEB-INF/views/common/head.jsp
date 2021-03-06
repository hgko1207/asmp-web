<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/tagLib.jsp" %>

<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE10" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" />
	<title>방과후 학교 관리 프로그램</title>
	
	<!--begin::Web font -->
	<!-- <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet"> -->
	
	<script>
		var contextPath = "${pageContext.request.contextPath}";
	</script>
	
	<c:set var="contextName">${pageContext.request.contextPath}</c:set>
	
	<link href="${contextName}/metronic/vendors/base/vendors.bundle.css" rel="stylesheet" type="text/css" />
	<link href="${contextName}/metronic/demo/default/base/style.bundle.css" rel="stylesheet" type="text/css" />
	
	<link href="${contextName}/metronic/vendors/custom/datatables/datatables.bundle.css" rel="stylesheet" type="text/css" />
	
	<link href="${contextName}/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${contextName}/css/aside.css" rel="stylesheet" type="text/css" />
	<link href="${contextName}/css/content.css" rel="stylesheet" type="text/css" />
	
	<!----------------------------------------------------------------------------------------------------------------->
	
	<script src="${contextName}/metronic/vendors/base/vendors.bundle.js" type="text/javascript"></script>
	<script src="${contextName}/metronic/demo/default/base/scripts.bundle.js" type="text/javascript"></script>
	
	<script src="${contextName}/metronic/vendors/custom/datatables/datatables.bundle.js" type="text/javascript"></script>
	
	<script src="${contextName}/js/common.js" type="text/javascript"></script>
	<script src="${contextName}/js/table.js" type="text/javascript"></script>
	<script src="${contextName}/js/validation.js" type="text/javascript"></script>
	
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>
</head>