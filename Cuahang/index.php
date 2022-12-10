<?php
    include_once('model/dbconfig.php');

    if (isset($_GET['action'])) {
        $action = $_GET['action'];
    }else{
        $action = '';
    }
    
    switch ($action) {
        case 'login':
            if (isset($_POST['login'])) {
                // username and password sent from form     
                $username = "admin";
                $password = "admin";
                if ($_POST['user'] == $username && $_POST['pass'] == $password) {
                    //tạm thời kiểm tra đăng nhập của admin tại đây
                    session_start();
                    $_SESSION['user'] = 'admin';
                    header("location: index.php?controller=admin&action=admin");
                    
                } else {
                    echo '<script>alert("Your Login Name or Password is invalid") </script>';
                }
            }
            require_once('views/admin/adminlogin.php');
            break;

        case 'logout':
            session_start();
            session_destroy();
            if (isset($_POST['login'])) {
                // username and password sent from form     
                $username = "admin";
                $password = "admin";
                if ($_POST['user'] == $username && $_POST['pass'] == $password) {
                    //tạm thời kiểm tra đăng nhập của admin tại đây
                    session_start();
                    $_SESSION['user'] = 'admin';
                    header("location: index.php?controller=admin&action=admin");
                    
                } else {
                    echo '<script>alert("Your Login Name or Password is invalid") </script>';
                }
            }
            require_once('views/admin/adminlogin.php');
            break;

        case 'admin':
            //kiểm tra đăng nhập
            session_start();
            if(!isset($_SESSION['user']) && $_SESSION['user'] != 'admin'){
                $message = "Bạn cần đăng nhập trước";
                echo "<script type='text/javascript'>alert('$message');</script>";
                echo "<script type='text/javascript'>window.location.href = 'index.php?controller=admin&action=login';</script>";
            }

            // xuất các đơn chưa duyệt ra.
            include_once('model/document/registrationDAO.php');
            $dDAO = new registrationDAO();
            $tt = 'Chờ';
            $dW = $dDAO->getForm($tt);

            require_once('views/admin/adminhome.php');
            break;

        case 'rooms':
            //quản lý phòng
            include_once('model/rooms/roomsDAO.php');
            $rooms = new roomsDAO();
            $dataR = $rooms->getDataR();
            // sửa xoá...
            require_once('views/admin/adminroom.php');
            break;

        case 'addroom':
            
            // code tiếp tại đây
            break;
        case 'employee':
            include_once('model/Employee/EmployeeDAO.php');
            $em = new EmployeeDAO();
            $dataE = $em->getAllE();
            //var_dump($dataE);

            require_once('views/admin/adminemployee.php');
            break;

        case 'customer':
            include_once('model/customer/customerDAO.php');
            $cus = new CustomerDAO();
            $dataC = $cus->getAllC();

            //var_dump($dataC);
            require_once('views/admin/admincustomer.php');
            break;

        default:
            require_once('views/admin/adminlogin.php');
            break;
    }
