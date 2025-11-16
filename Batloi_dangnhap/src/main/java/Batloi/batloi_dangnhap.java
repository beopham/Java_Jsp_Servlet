package Batloi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class batloi_dangnhap
 */
@WebServlet("/batloi_dangnhap")
public class batloi_dangnhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public batloi_dangnhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Dùng cho dữ liệu NHẬN TỪ form (method POST)
				request.setCharacterEncoding("UTF-8");	
				// Dùng cho dữ liệu TRẢ VỀ trình duyệt
				response.setContentType("text/html; charset=UTF-8");
				String hoten=request.getParameter("hoten");
				String email=request.getParameter("email");
				String mk=request.getParameter("mk");
				String sothich=request.getParameter("sothich");
				String sl=request.getParameter("sl");
				String gioitinh=request.getParameter("gioitinh");
				String ngaysinh=request.getParameter("ngaysinh");
				String sdt=request.getParameter("sdt");
			    
				
				String url="";
				boolean coloi=false;
				
				// SỬA: Định nghĩa regex ở đầu
				String regexTen = "^[\\p{L}\\s]+$";	
				String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";	
				String regexSo = "^[0-9]+$";
				String regexSoDuong = "^[1-9][0-9]*$"; // Regex cho số dương > 0
				String regexSdt = "^[0-9]{10}$"; 
				String regexSdtn ="^0[0-9]{9}$"; 
				// SỬA 1: Gộp toàn bộ logic cho "hoten" vào 1 khối
				// Khối này phải bắt đầu bằng "if"
				if(hoten==null || hoten.trim().isEmpty())
				{
					request.setAttribute("batloi_hoten", "Bạn k đc để trống ô họ tên");
					coloi=true;
				}
				// Dùng "else if" để kiểm tra regex CHỈ KHI "hoten" không trống
				else if(!hoten.trim().matches(regexTen))
				{
					// SỬA: Dùng chung 1 tên lỗi "batloi_hoten" cho dễ hiển thị
					request.setAttribute("batloi_nhapsaihoten", "Bạn nhập k đúng họ tên (chỉ chứa chữ cái, dấu cách)");
					coloi=true;
				}

				// SỬA 2: Gộp toàn bộ logic cho "email" vào 1 khối
				// Khối này BẮT BUỘC phải bắt đầu bằng "if" (không phải "else if")
				if(email==null || email.trim().isEmpty())
				{
					request.setAttribute("batloi_email", "Bạn k đc để trống email");
					coloi=true;
				}
				else if(!email.trim().matches(regexEmail))
				{
					// SỬA: Dùng chung 1 tên lỗi "batloi_email"
					request.setAttribute("batloi_nhapsaiemail", "Bạn nhập k đúng định dạng email");
					coloi=true;
				}

				// SỬA 3: Các trường còn lại, mỗi trường đều phải bắt đầu bằng "if"
				if(mk==null || mk.trim().isEmpty())
				{
					request.setAttribute("batloi_mk", "Bạn k đc để trống mật khẩu");
					coloi=true;
				}
				
				if(sothich==null || sothich.trim().isEmpty())
				{
					request.setAttribute("batloi_st", "Bạn k đc để trống sở thích");
					coloi=true;
				}
				
				if(sl==null || sl.trim().isEmpty())
				{
					request.setAttribute("batloi_sl", "Bạn k đc để trống số lượng");
					coloi=true;
				}
				else if (!sl.trim().matches(regexSo))
				{
					request.setAttribute("batloi_nhapsaisl", "Bạn k đúng định dạng số lượng");
				    coloi=true;	
				}
				else if (!sl.trim().matches(regexSoDuong))
				{
					request.setAttribute("batloi_bang0", "Bạn phải nhập số lượng lớn hơn 0");
				    coloi=true;	
				}
				
				if(gioitinh==null || gioitinh.trim().isEmpty())
				{
					request.setAttribute("batloi_gioitinh", "Bạn k đc để trống giới tính");
					coloi=true;
				}
				
				if(ngaysinh==null || ngaysinh.trim().isEmpty())
				{
					request.setAttribute("batloi_ngaysinh", "Bạn k đc để trống ngày sinh");
					coloi=true;
				}
				
				if(sdt==null || sdt.trim().isEmpty())
				{
					request.setAttribute("batloi_sdt", "Bạn k đc để trống số điện thoại");
					coloi=true;
				}
				else if(!sdt.trim().matches(regexSo))
				{
					request.setAttribute("batloi_sdt_klaso", "Bạn phải nhập số điện thoại là số");
					coloi=true;
				}
				else if(!sdt.trim().matches(regexSdt))
				{
					request.setAttribute("batloi_sdt_klas10", "số điện thoại phải là 10 số");
					coloi=true;
				}
				else if(!sdt.trim().matches(regexSdtn))
				{
					request.setAttribute("batloi_sdt_klaso0", "số điện thoại phải bắt đầu là số 0");
					coloi=true;
				}
				// điều chuyển url
				if(coloi==true)
				{
					url+="form.jsp";
				}
				else	
				{
			        url+="tc.jsp";
				}
				
				// 2. In ra console để kiểm tra (sout)
				System.out.println("--- Dữ liệu nhận từ form ---");
				System.out.println("Họ tên: " + hoten);
				System.out.println("Email: " + email);
				System.out.println("Mật khẩu: " + mk);
				System.out.println("Sở thích (value): " + sothich);
				System.out.println("Số lượng: " + sl);
				System.out.println("Giới tính: " + gioitinh);
				System.out.println("Ngày sinh: " + ngaysinh);
				System.out.println("Số điện thoại: " + sdt);
				System.out.println("-----------------------------");
				
				// lấy ra giá trị nhập 
				request.setAttribute("hoten", hoten);
				request.setAttribute("email",email);
				request.setAttribute("mk", mk);
				request.setAttribute("sothich", sothich);
				request.setAttribute("sl", sl);
				request.setAttribute("ngaysinh",ngaysinh);
				// SỬA 4: Sửa lỗi gõ sai "gioiinh" -> "gioitinh"
				request.setAttribute("gioitinh", gioitinh);
				request.setAttribute("sdt", sdt);
				
		        RequestDispatcher rd=request.getRequestDispatcher(url);
		        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
