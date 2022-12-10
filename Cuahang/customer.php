<?php
class customer
{
    private $maKhachHang;

    private $tenKhachHang;

    private $ngaySinh;

    private $gioiTinh;

    private $quocTich;

    private $email;

    private $soDienThoai;


    public function __construct($maKhachHang, $tenKhachHang, $ngaySinh, $gioiTinh, $quocTich, $email, $soDienThoai)
    {
        $this->maKhachHang = $maKhachHang;
        $this->tenKhachHang = $tenKhachHang;
        $this->ngaySinh = $ngaySinh;
        $this->gioiTinh = $gioiTinh;
        $this->quocTich = $quocTich;
        $this->email = $email;
        $this->soDienThoai = $soDienThoai;
    }

    /**
     * Get the value of maKhachHang
     */
    public function getMaKhachHang()
    {
        return $this->maKhachHang;
    }

    /**
     * Set the value of maKhachHang
     *
     * @return  self
     */
    public function setMaKhachHang($maKhachHang)
    {
        $this->maKhachHang = $maKhachHang;

        return $this;
    }

    /**
     * Get the value of tenKhachHang
     */
    public function getTenKhachHang()
    {
        return $this->tenKhachHang;
    }

    /**
     * Set the value of tenKhachHang
     *
     * @return  self
     */
    public function setTenKhachHang($tenKhachHang)
    {
        $this->tenKhachHang = $tenKhachHang;

        return $this;
    }

    /**
     * Get the value of ngaySinh
     */
    public function getNgaySinh()
    {
        return $this->ngaySinh;
    }

    /**
     * Set the value of ngaySinh
     *
     * @return  self
     */
    public function setNgaySinh($ngaySinh)
    {
        $this->ngaySinh = $ngaySinh;

        return $this;
    }

    /**
     * Get the value of gioiTinh
     */
    public function getGioiTinh()
    {
        return $this->gioiTinh;
    }

    /**
     * Set the value of gioiTinh
     *
     * @return  self
     */
    public function setGioiTinh($gioiTinh)
    {
        $this->gioiTinh = $gioiTinh;

        return $this;
    }

    /**
     * Get the value of quocTich
     */
    public function getQuocTich()
    {
        return $this->quocTich;
    }

    /**
     * Set the value of quocTich
     *
     * @return  self
     */
    public function setQuocTich($quocTich)
    {
        $this->quocTich = $quocTich;

        return $this;
    }

    /**
     * Get the value of email
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * Set the value of email
     *
     * @return  self
     */
    public function setEmail($email)
    {
        $this->email = $email;

        return $this;
    }

    /**
     * Get the value of soDienThoai
     */
    public function getSoDienThoai()
    {
        return $this->soDienThoai;
    }

    /**
     * Set the value of soDienThoai
     *
     * @return  self
     */
    public function setSoDienThoai($soDienThoai)
    {
        $this->soDienThoai = $soDienThoai;

        return $this;
    }
}
