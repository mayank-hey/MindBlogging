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
    <link href="assests/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assests/css/profile.css" rel="stylesheet">
	
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
    
    $(document).ready(function(){
  $( "#slider" ).slider({
            value:$('#emo_score').val(),
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
    blog.post_title = $('#title').val();
	blog.post_text = $('#postblog').val();
    blog.user_name = $('#user_id').val();
 
    $.ajax({
        url: "http://localhost:8080/hd_tool/add_post.htm",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(blog),
        contentType: 'application/json',
        mimeType: 'application/json',
 
        success: function (response) {
            $('#old_posts').html("");
            $('#title').val("");
            $('#postblog').val("");
            var obj1 = JSON.stringify(response);
            var obj = JSON.parse(obj1);
            var avg_emo=0;
            for (var i = 0, len = obj.length; i < len; ++i) {
                var post = obj[i];
                if(i==0){avg_emo=post.emo_score;}
                $('#old_posts').append("<div class=\"blog-content\"><textarea readonly class=\"form-control\" resizable=\"false\" required>"+post.post_text+"</textarea><p>"+post.timestamp+"</p></div>");
            }
            $( "#slider" ).slider({
                value:avg_emo,
                min: 0,
                max: 10,
                step: 1,
                slide: function( event, ui ) {
                //$( "#emo_score" ).val( ui.value );
                }
            });

        },
        error:function(data,status,er) {
            alert("error: "+data+" status: "+status+" er:"+er);
        }
    });
}

function updatelevel() {
 
    // get inputs
    var blog = new Object();
    blog.emo_score = $('#slider').slider("value");
    blog.user_name = $('#user_id').val();
 
    $.ajax({
        url: "http://localhost:8080/hd_tool/update_post.htm",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(blog),
        contentType: 'application/json',
        mimeType: 'application/json',
 
        success: function (response) {
            $('#old_posts').html("");
            $('#title').val("");
            $('#postblog').val("");
            var obj1 = JSON.stringify(response);
            var obj = JSON.parse(obj1);
            var avg_emo=0;
            for (var i = 0, len = obj.length; i < len; ++i) {
                var post = obj[i];
                if(i==0){avg_emo=post.emo_score;}
                $('#old_posts').append("<div class=\"blog-content\"><textarea readonly class=\"form-control\" resizable=\"false\" required>"+post.post_text+"</textarea><p>"+post.timestamp+"</p></div>");
            }
            $( "#slider" ).slider({
                value:avg_emo,
                min: 0,
                max: 10,
                step: 1,
                slide: function( event, ui ) {
                //$( "#emo_score" ).val( ui.value );
                }
            });

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
				<button class="btn btn-lg btn-primary btn-block" type="button" onclick="updatelevel()">Submit</button>
			</div>
				
				<div id="old_posts" class="blog-typed">
                    <c:forEach items="${model.post_info_list}" var="current">
                        <div class="blog-content">
                            <textarea readonly class="form-control" resizable="false" required><c:out value="${current.post_text}" /></textarea>
                            <p><c:out value="${current.timestamp}" /></p>
                        </div>
                    </c:forEach>
				</div>
				
			</div>
		
			
		
			<div class="userlist">
				<ul type="none">
					<li class="user" ><div><div><label class="username userlabel">User:Gaurav</label></div><div><label class="level userlabel" style="float:left;">Level:7</label><button class="btn btn-lg btn-primary user-button" type="button">Mail!</button></div></div></li>
        			<li class="user" ><div><div><label class="username userlabel">User:Mayank</label></div><div><label class="level userlabel" style="float:left;">Level:9</label><button class="btn btn-lg btn-primary user-button" type="button">Mail!</button></div></div></li>
				</ul> 
			</div>
        <input type="hidden" id="user_id" value="${model.logged_in_user}"/>
        <input type="hidden" id="emo_score" value="${model.emo_score}"/>
		
		</form>
    </div>
</body>
</html>