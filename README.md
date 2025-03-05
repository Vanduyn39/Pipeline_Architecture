# Pipeline_Architecture

## Setup database
- Tại DatabaseService.java, edit variable có comment "//change this to connect to MSSQL" để kết nối đến DB.
- Lưu ý cần MSSQL phiên bản v16, mở cổng 1433 TCP. 

## Setup RabbitMQ (Message queue)
- Cài đặt và setup RabbitMQ
- Cấu hình tên đăng nhập, cổng tại application.properties nếu setup khác mặc định.

##Truy cập trang web
http://localhost:8080
http://localhost:8080/order
