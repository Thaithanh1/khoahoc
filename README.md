Thiết kế các api phục vụ cho việc gửi dữ liệu lên front-end
Bảng loại khóa học: 
Thêm, sửa, xóa các loại khóa học
Bảng khóa học: 
Thêm, sửa, xóa, hiển thị danh sách khóa học
Tìm kiếm khóa học theo tên
Phân trang dữ liệu cho bảng khóa học theo danh sách khóa học và theo các trang được tìm kiếm
Số lượng học viên tự động cập nhật sau khi có học viên đăng kí và tình trạng là đang học, học xong và chưa hoàn thành
Trường thời gian học có kiểu int, toàn bộ các trường là bắt buộc
Bảng học viên:
Thêm, sửa, xóa, hiển thị danh sách học viên
Tìm kiếm học viên theo tên, và mail
Phân trang dữ liệu cho bảng học viên theo danh sách học viên và theo danh sách học viên được tìm kiếm
Trường email, số điện thoại là duy nhất, nếu đã tồn tại trả về các lỗi tương ứng để gửi lên front-end
Trường họ tên tự động định dạng trước khi lưu, trường hình ảnh lưu trữ địa chỉ của ảnh
Bảng tình trạng học: 
Thêm, sửa, xóa, hiển thị các tình trạng học
Thêm 4 tình trạng học Chờ duyệt, Đang học chính, Học xong, Chưa hoàn thành
Chờ duyệt: Học viên thực hiện đăng ký tuy nhiên quản lý chưa xác nhận phiếu đăng ký
Đang học chính: Phiếu đăng ký của học viên được quản lý chấp nhận
Học xong: Thời gian kết thúc < thời gian hiện tại
Chưa hoàn thành: Với TH học viên nghỉ giữa chừng, quản lý có thể chỉnh tình trạng học sang Chưa hoàn thành, đồng thời ngắt việc tự động cập nhật trạng thái sang Học xong.
Bảng đăng ký học:  
Ngày đăng ký tự động cập nhật, ngày bắt đầu được tính từ ngày tình trạng học là đang học chính, ngày kết thúc tính bằng ngày bắt đầu + thời gian học trong bảng khóa học
Thêm, sửa, xóa, hiển thị đăng ký học 
Phân trang hiển thị đăng ký học
Các dữ liệu đăng ký chỉ được tự động cập nhật khi các bảng khác đã tồn tại, đăng ký học sẽ được thêm khi mà học viên đăng ký thành công
Bảng quyền hạn: 
Thêm, sửa, xóa, hiển thị các quyền hạn
Phân trang để hiển thị các kiểu quyền hạn
Bảng tài khoản: 
Thêm, sửa, xóa, hiển thị các tài khoản
Tìm tài khoản theo tên tài khoản
Phân trang cho danh sách tài khoản và danh sách các tài khoản tim kiếm
Tên tài khoản là duy nhất trước khi tạo, mật khẩu phải có chữ số và kí tự đặc biệt
Bảng loại bài viết: 
Thêm, sửa, xóa, hiển thị danh sách bài viết
Phân trang cho loại bài viết
Bảng chủ đề: 
Thêm, sửa, xóa, hiển thị các chủ đề
Phân trang hiển thị danh sách chủ đề
Các trường là bắt buộc
Bảng bài viết:   
Thêm, sửa, xóa, hiển thị danh sách bài viết
Tìm kiểm bài viết theo tên bài viết
Phân trang dữ liệu cho danh sách bài viết và các bài viết tìm kiếm được
Trường thời gian tạo tự cập nhât, toàn bộ các trường dữ liệu là bắt buộc, trường hình ảnh chứa địa chỉ của ảnh
