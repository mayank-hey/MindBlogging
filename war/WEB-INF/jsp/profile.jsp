    <%@ include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html>
<!-- saved from url=(0043)http://codefusionlab.com/slider_steps2.html -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.8.20/themes/base/jquery-ui.css" type="text/css" media="all" />
	
	<!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="profile.css" rel="stylesheet">
	
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
    <script src="http://code.jquery.com/ui/1.8.20/jquery-ui.min.js" type="text/javascript"></script>
    <script>


    $(function() {

        $( "#slider" ).slider({
            value:1,
            min: 0,
            max: 10,
            step: 1,
            slide: function( event, ui ) {
                //$( "#emo_score" ).val( ui.value );
            }
        });
    });
	
	function sendBlogData() {
 
    // get inputs
    var blog = new Object();
    blog.title = $('#title').val();
	blog.postblog = $('#postblog').val();
 
    $.ajax({
        url: "jsonservlet",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(blog),
        contentType: 'application/json',
        mimeType: 'application/json',
 
        success: function (data) {
			window.location.replace(http://localhost:8080/hd_tool/profile.html)
        },
        error:function(data,status,er) {
            alert("error: "+data+" status: "+status+" er:"+er);
        }
    });
}
    </script>

    </head>
  <body>
	<div class="container">
		<form class="form-profile" role="form">
		
			<div class="blog">
				<div class="blog-title">
					<input type="email" id="title" name="title" class="form-control" placeholder="Give a title!" required autofocus/>	
				</div>
			
				<div class="blog-content">
					<textarea class="form-control" id="postblog" name="postblog" rows="3" placeholder="Type your post here!" resizable="false" required></textarea>
				</div>
				
				<div class="blog-button">
					<button class="btn btn-lg btn-primary btn-block blog-button" type="button" onclick="sendBlogData()">Post</button>
				</div>
				
				<div class="blog-typed">
                    <c:forEach items="${model.post_info_list}" var="current">
                        <tr>
                            <td><c:out value="${current.post_text}" /><td>
                            <td><c:out value="${current.timestamp}" /><td>
                        </tr>
                    </c:forEach>
				</div>
				
			</div>
		
			<div class="slide">
				<p>
					<label for="amount">Your current level:</label>
				</p>

				<div id="slider" class="ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all">
					<a class="ui-slider-handle ui-state-default ui-corner-all" href="http://codefusionlab.com/slider_steps2.html#" style="left: 40%; "></a>
				</div>

				<div class="steps-2">
					<span class="tick">|<br>0</span>
					<span class="tick" style="left: 10%;">|<br>1</span>
					<span class="tick" style="left: 20%;">|<br>2</span>
					<span class="tick" style="left: 30%;">|<br>3</span>
					<span class="tick" style="left: 40%;">|<br>4</span>
					<span class="tick" style="left: 50%;">|<br>5</span>
					<span class="tick" style="left: 60%;">|<br>6</span>
					<span class="tick" style="left: 70%;">|<br>7</span>
					<span class="tick" style="left: 80%;">|<br>8</span>
					<span class="tick" style="left: 90%;">|<br>9</span>
					<span class="tick" style="left: 100%;">|<br>10</span>
				</div>

			</div>
		
			<div class="submit">
				<button class="btn btn-lg btn-primary btn-block" type="submitbutton">Submit</button>
			</div>
		
			<div class="userlist">
				<ul type="none">
					<li class="user" ><div><div><label class="username userlabel">User:username</label></div><div><label class="level userlabel" style="float:left;">Level:7</label><button class="btn btn-lg btn-primary user-button" type="button">Mail!</button></div></div></li>
					<li class="user" ><div><div><label class="username userlabel">User:username</label></div><div><label class="level userlabel" style="float:left;">Level:7</label><button class="btn btn-lg btn-primary user-button" type="button">Mail!</button></div></div></li>
					<li class="user" ><div><div><label class="username userlabel">User:username</label></div><div><label class="level userlabel" style="float:left;">Level:7</label><button class="btn btn-lg btn-primary user-button" type="button">Mail!</button></div></div></li>
					<li class="user" ><div><div><label class="username userlabel">User:username</label></div><div><label class="level userlabel" style="float:left;">Level:7</label><button class="btn btn-lg btn-primary user-button" type="button">Mail!</button></div></div></li>
					<li class="user" ><div><div><label class="username userlabel">User:username</label></div><div><label class="level userlabel" style="float:left;">Level:7</label><button class="btn btn-lg btn-primary user-button" type="button">Mail!</button></div></div></li>
				</ul> 
			</div>
		
		</form>
    </div>
</body>
</html>