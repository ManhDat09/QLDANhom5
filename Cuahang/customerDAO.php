<?php
    class CustomerDAO{
        public function getDataC($id)
        {
            $table = 'khachhang';
            $row = 'makhachhang';
            $db = new Database();
            $db->connect();
            return $db->getDataID($table, $id, $row);
        }

        public function getAllC()
        {
            $db = new Database();
            $db->connect();
            return $db->getAllData('khachhang');
        }
    }

?>