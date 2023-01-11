-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Author : @ADING
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Jan 2023 pada 23.29
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penjualan_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_faktur`
--

CREATE TABLE `tb_faktur` (
  `NoFaktur` varchar(10) NOT NULL,
  `KodePembeli` varchar(10) NOT NULL,
  `KodeWine` varchar(10) NOT NULL,
  `Tgl` date NOT NULL,
  `Jam` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_faktur`
--

INSERT INTO `tb_faktur` (`NoFaktur`, `KodePembeli`, `KodeWine`, `Tgl`, `Jam`) VALUES
('000121', '1122', 'WS001', '2022-01-01', '15.14 '),
('000122', '1122', 'WS005', '2022-01-02', '19.01'),
('000123', '1121', 'WS002', '2022-01-03', '13.15'),
('000124', '1121', 'WS003', '2022-01-04', '22.01'),
('000125', '1123', 'WS004', '2022-01-05', '17.15'),
('000126', '1123', 'WS003', '2022-01-06', '16.45');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_login`
--

CREATE TABLE `tb_login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_login`
--

INSERT INTO `tb_login` (`username`, `password`) VALUES
('admin', '123'),
('member', '123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pembeli`
--

CREATE TABLE `tb_pembeli` (
  `Kode` varchar(20) NOT NULL,
  `Nama` varchar(30) NOT NULL,
  `Alamat` varchar(30) NOT NULL,
  `Pekerjaan` varchar(20) NOT NULL,
  `Telp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_pembeli`
--

INSERT INTO `tb_pembeli` (`Kode`, `Nama`, `Alamat`, `Pekerjaan`, `Telp`) VALUES
(' 1120', ' Ahmad Fadhiil M', 'Jl. Lemah Abang', ' Mahasiswa', ' 0881025581707'),
(' 1121', ' Rafi Ubaidillah', 'Jl. Raya Setu ', ' Mahasiswa', ' 082128754721 '),
(' 1122', ' Fery Affandi', 'Jl. Palem Hijau V', ' Mahasiswa', ' 087719312053'),
(' 1123', ' Riris Naomi G', 'Jl. Pegangsaan Raya', ' Mahasiswa', ' 081285253185');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pembelian`
--

CREATE TABLE `tb_pembelian` (
  `no_pembelian` varchar(8) NOT NULL,
  `no_faktur` varchar(10) NOT NULL,
  `tgl` date NOT NULL,
  `jam` varchar(10) NOT NULL,
  `kode_pembeli` varchar(10) NOT NULL,
  `nama_pembeli` varchar(20) NOT NULL,
  `kode_penjual` varchar(10) NOT NULL,
  `nama_penjual` varchar(20) NOT NULL,
  `kode_wine` varchar(8) NOT NULL,
  `nama_wine` varchar(20) NOT NULL,
  `merk` varchar(20) NOT NULL,
  `warna` varchar(20) NOT NULL,
  `tahun` varchar(10) NOT NULL,
  `harga` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_pembelian`
--

INSERT INTO `tb_pembelian` (`no_pembelian`, `no_faktur`, `tgl`, `jam`, `kode_pembeli`, `nama_pembeli`, `kode_penjual`, `nama_penjual`, `kode_wine`, `nama_wine`, `merk`, `warna`, `tahun`, `harga`) VALUES
('99901', '000121', '2022-01-01', '15.14', '1122', 'Fery Affandi', 'S1101', 'Ading', 'WS001', 'Red Wine', 'DA VINCI', 'Red', '1502', '380.000'),
('99902', '000122', '2022-01-02', '19.01', '1122', 'Fery Affandi', 'S1102', 'Hilda', 'WS005', 'Dragonfly Moscato', 'Hatten Dragonfly', 'Yellow', '2019', '205.000'),
('99903', '000123', '2022-01-03', '13.15', '1121', 'Rafi Ubaidillah', 'S1101', 'Ading', 'WS002', 'G7', 'The 7th Generation', 'Black', '2016', '290.000'),
('99904', '000124', '2022-01-04', '22.01', '1121', 'Rafi Ubaidillah', 'S1101', 'Ading', 'WS003', 'Plaga Sweet Rose', 'Sweet Rose', 'Pink', '2013', '240.000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_penjual`
--

CREATE TABLE `tb_penjual` (
  `Kode` varchar(20) NOT NULL,
  `Nama` varchar(30) NOT NULL,
  `Alamat` varchar(30) NOT NULL,
  `Pekerjaan` varchar(20) NOT NULL,
  `Telp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_penjual`
--

INSERT INTO `tb_penjual` (`Kode`, `Nama`, `Alamat`, `Pekerjaan`, `Telp`) VALUES
(' S1101', ' Ading', ' Lemah Abang', ' Mahasiswa', ' 0881025581707'),
(' S1102', ' Hilda', ' Pasimal', ' Mahasiswa', ' 088801200412');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_penjualan`
--

CREATE TABLE `tb_penjualan` (
  `Kode` varchar(8) NOT NULL,
  `Nama` varchar(30) NOT NULL,
  `Merk` varchar(20) NOT NULL,
  `Warna` varchar(20) NOT NULL,
  `Tahun` varchar(6) NOT NULL,
  `Harga` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_penjualan`
--

INSERT INTO `tb_penjualan` (`Kode`, `Nama`, `Merk`, `Warna`, `Tahun`, `Harga`) VALUES
('WS001', 'Red Wine', 'DA VINCI', 'Red', '1502', '380.000'),
('WS002', 'G7', 'The 7th Generation', 'Black', '2016', '290.000'),
('WS003', 'Plaga Sweet Rose', 'Sweet Rose', 'Pink', '2013', '240.000'),
('WS004', 'Rutini Collection Malbec', 'Rutini Wines', 'Black', '2019', '680.000'),
('WS005', 'Dragonfly Moscato', 'Hatten Dragonfly', 'Yellow', '2019', '205.000');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_faktur`
--
ALTER TABLE `tb_faktur`
  ADD PRIMARY KEY (`NoFaktur`);

--
-- Indeks untuk tabel `tb_pembeli`
--
ALTER TABLE `tb_pembeli`
  ADD PRIMARY KEY (`Kode`);

--
-- Indeks untuk tabel `tb_penjual`
--
ALTER TABLE `tb_penjual`
  ADD PRIMARY KEY (`Kode`);

--
-- Indeks untuk tabel `tb_penjualan`
--
ALTER TABLE `tb_penjualan`
  ADD PRIMARY KEY (`Kode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
