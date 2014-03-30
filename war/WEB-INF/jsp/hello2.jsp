<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title>
  <link href="annotator.min.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
  <input type="hidden" id="document_id" value="1">
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/><c:out value="${model.now}"/></p>
    <h3>File Contents</h3>
    <div id="content"><pre><c:out value="${model.file_content}"/></pre></div>
    
<script src="jquery.js"></script>
<script src="annotator-full.min.js"></script>
<script>
$('#content').annotator();
$('#content').annotator().annotator('setvalue',$('#document_id').val(),'rohan','2014-03-24T03:17:50');
$('#content').annotator().annotator('setupPlugins',{},{Tags:false,Filter:false});
</script>
</body>
</html>