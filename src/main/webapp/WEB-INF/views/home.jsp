<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="../css/customer.css">
</head>
<body>
    <div class="form">
    <div class="title">Customer Information</div>
    <div class="subtitle">Please Fill the form below!</div>

    <form action="/processData" method="post" enctype="multipart/form-data">
        <div class="input-container ic1">
            <input id="firstname" class="input"  type="text" name="firstName" placeholder=" "/>
            <div class="cut"></div>
            <label for="firstname" class="placeholder">First name</label>
        </div>
        <div class="input-container ic2">
                <input  id="lastname" class="input" placeholder=" " type="text" name="lastName"/>
            <div class="cut"></div>
            <label for="lastname" class="placeholder">Last name</label>
        </div>
        <div class="input-container ic2">
                <input id="email" class="input" placeholder=" " type="date" name="dateOfBirth"/>
            <div class="cut cut-short"></div>
            <label for="email" class="placeholder">Date</label>
        </div>

              <input type="file" class="upload" name="myFile"><div class="uploadFile"><--  Upload file</div>
              <input type="submit" class="submit"  value="submit"/>
    </form>
    </div>

</body>
</html>