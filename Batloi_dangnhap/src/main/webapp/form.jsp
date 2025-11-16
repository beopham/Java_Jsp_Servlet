<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Mua Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

    <style>
        .khung {
            width: 800px;
            background-color: rgb(197, 197, 198);
            margin: 20px auto;
            padding: 20px;
            border-radius: 8px;
        }

        .theinput {
            margin-bottom: 20px;
        }
    </style>
</head>

<body>

    <div class="khung">
        <form action="batloi_dangnhap" method="post">
            <h3 class="text-center mb-4">Đăng Nhập Ví Dụ</h3>
            <div class="row">
                <div class="col-6">
                    <input type="text" class="form-control theinput" name="hoten" placeholder="Họ Và Tên" value="${hoten}">
                    <div>
                        <span style="color:red;">${batloi_hoten}</span>
                                <span style="color:red;">${batloi_nhapsaiten}</span>
               
                    </div>
                </div>
                <div class="col-6">
                    <input type="email" class="form-control theinput" name="email" placeholder="Email" value="${email}">
                    <div>
                        <span style="color:red;">${batloi_email}</span>
                         <span style="color:red;">${batloi_nhapsaiemail}</span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-6">
                    <input type="date" class="form-control theinput" name="ngaysinh" value="${ngaysinh}">
                    <div>
                        <span style="color:red;">${batloi_ngaysinh}</span>
                    </div>
                </div>
                <div class="col-6">
                    <input type="password" class="form-control theinput" name="mk" placeholder="Mật Khẩu" value="${mk}">
                    <div>
                        <span style="color:red;">${batloi_mk}</span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-6">
                    <select class="form-select theinput" name="sothich" > 
                       <option value="" ${empty sothich ? 'selected' : ''} disabled>Chọn sở thích</option>
				        <option value="Ngủ" ${sothich == 'Ngủ' ? 'selected' : ''}>Ngủ</option>
				        <option value="Chơi Game" ${sothich == 'Chơi Game' ? 'selected' : ''}>Chơi Game</option>
				        <option value="Lái Xe Máy Đi Dạo" ${sothich == 'Lái Xe Máy Đi Dạo' ? 'selected' : ''}>Lái Xe Máy Đi Dạo</option>
                    </select>
                    <div>
                        <span style="color:red;">${batloi_st}</span>
                    </div>
                </div>
                <div class="col-6">
                    <input type="text" id="typeNumber" class="form-control theinput" name="sl" placeholder="Số lượng" value="${sl}">
                    <div>
                        <span style="color:red;">${batloi_sl}</span>
                         <span style="color:red;">${batloi_nhapsaisl}</span>
                           <span style="color:red;">${batloi_bang0}</span>
           
                    </div>
                </div>
            </div>

            <div class="row ">
              <div class="col-6">
			    <div class="form-check">
			        <input class="form-check-input" 
			               type="radio" 
			               name="gioitinh" 
			               id="radioDefault1" 
			               value="Nam" 
			               ${gioitinh == 'Nam' ? 'checked' : ''}>
			        <label class="form-check-label" for="radioDefault1">
			            Nam
			        </label>
			    </div>
			    
			    <div class="form-check">
			        <input class="form-check-input" 
			               type="radio" 
			               name="gioitinh" 
			               id="radioDefault2" 
			               value="Nữ" 
			               ${gioitinh == 'Nữ' ? 'checked' : ''}>
			        <label class="form-check-label" for="radioDefault2">
			            Nữ
			        </label>
			    </div>
			      <div>
			        <span style="color:red;">${batloi_gioitinh}</span>
			    </div>
			 </div>
			 
			 <div class="col-6">
			 		<input type="tel" class="form-control theinput" name="sdt" placeholder="Số Điện Thoại" maxlength="10" value="${sdt}"> 
                    <div>
                        <span style="color:red;">${batloi_sdt}</span>
                         <span style="color:red;">${batloi_sdt_klaso}</span>
                               <span style="color:red;">${batloi_sdt_klaso0}</span>
                                 <span style="color:red;">${batloi_sdt_klas10}</span>
                               
  
                    </div>
                </div>
		  </div>
  
<div class="row "> 
            	<div class="col-12">
                    <div class="text-center">
                        <button type="submit" class="btn btn-danger">OK</button>
                    </div>
                </div>
            </div>

        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>

    </body>

</html>