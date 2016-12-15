<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2>Jersey RESTful Web Application!</h2>

<p><a href="api/v1/baseinfo/cities">Cities.</a></p>

<p><a href="api/v1/baseinfo/cities/1">Cities State id: 1</a></p>

<p><a href="api/v1/baseinfo/city/1">City Id: 1</a></p>

<p><a href="api/v1/baseinfo/states">States.</a></p>

<p><a href="api/v1/baseinfo/state/1">State Id: 1</a></p>

<h2>Upload files</h2>

<form action="/api/v1/file/upload" enctype="multipart/form-data" method="post">
    <label>Select multiple files</label>
    <input type="file" name="files" multiple/> <br/><br/>
    <label>Select File</label>
    <input type="file" name="file2"/> <br/><br/>
    <label>Tags</label>
    <input name="tags" maxlength="10"/> <br/><br/>
    <input type="submit" title="Save"/>
</form>
</body>
</html>
