<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title>
  </head>
  <body>
  <input type="hidden" id="document_id" value="1">
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/><c:out value="${model.now}"/></p>
    <h3>File Contents</h3>
    <div id="content"><pre><c:out value="${model.file_content}"/></pre></div>
    
<script src="jquery.js"></script>
<script>
    function madeAjaxCall(){

    var json_input = {"user_name" : "rsabnis", "post_title" : "test2", "post_text": "this is test2" ,"post_terms": ["test2"], "emo_score":4,"timestamp":"2011-05-24 18:52:08"};
    $.ajax({
    type: "post",
    url: "http://localhost:8080/hd_tool/add_post.htm",
    cache: false,
    contentType: 'application/json',
    data: JSON.stringify(json_input),
    success: function(response){
    $('#result').html("");
    var obj1 = JSON.stringify(response);
    var obj = JSON.parse(obj1);
    $('#result').html("Post id:- " + obj.post_id);
    },
    error: function(xhr, status, error){
    alert('Error while request..'+xhr.responseText);
    }
    });
    }
</script>
<input type="submit" value="Ajax Submit" onclick="madeAjaxCall();">
<div id="result"></div>
</body>
</html>