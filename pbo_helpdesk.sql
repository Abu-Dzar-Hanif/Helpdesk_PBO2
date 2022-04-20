-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Jan 2022 pada 14.03
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo_helpdesk`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `divisi`
--

CREATE TABLE `divisi` (
  `kd_divisi` varchar(11) NOT NULL,
  `nama_div` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `divisi`
--

INSERT INTO `divisi` (`kd_divisi`, `nama_div`) VALUES
('01', 'IT'),
('02', 'Admin'),
('03', 'HRD');

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `kd_karyawan` varchar(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `gender` enum('laki-laki','perempuan') NOT NULL,
  `kd_divisi` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`kd_karyawan`, `nama`, `gender`, `kd_divisi`) VALUES
('0122001', 'admin helpdesk', 'laki-laki', '01'),
('0122002', 'staff admin', 'perempuan', '02'),
('0122003', 'yolanda', 'perempuan', '03'),
('0122004', 'subki', 'laki-laki', '02');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tiket`
--

CREATE TABLE `tiket` (
  `kd_tiket` varchar(11) NOT NULL,
  `kd_karyawan` varchar(11) NOT NULL,
  `keluhan` text NOT NULL,
  `tgl_buat` date NOT NULL,
  `tgl_selesai` date DEFAULT NULL,
  `status` varchar(11) NOT NULL,
  `petugas` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tiket`
--

INSERT INTO `tiket` (`kd_tiket`, `kd_karyawan`, `keluhan`, `tgl_buat`, `tgl_selesai`, `status`, `petugas`) VALUES
('TI2201001', '0122002', 'keyborad rusak', '2022-01-16', NULL, 'on proses', 'abu dzar'),
('TI2201002', '0122003', 'komputer saya lemot', '2022-01-16', '2022-01-17', 'done', 'anu dzar'),
('TI2201003', '0122004', 'key board rusak', '2022-01-21', NULL, 'on proses', 'hanif');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `kd_karyawan` varchar(11) NOT NULL,
  `username` varchar(11) NOT NULL,
  `password` varchar(11) NOT NULL,
  `level` enum('admin','user') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `kd_karyawan`, `username`, `password`, `level`) VALUES
(1, '0122001', 'admin', '12345', 'admin'),
(2, '0122002', 'adminstaf', '12345', 'user'),
(3, '0122003', 'yolanda', '12345', 'user'),
(4, '0122004', 'subki', '12345', 'user');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `divisi`
--
ALTER TABLE `divisi`
  ADD PRIMARY KEY (`kd_divisi`);

--
-- Indeks untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`kd_karyawan`);

--
-- Indeks untuk tabel `tiket`
--
ALTER TABLE `tiket`
  ADD PRIMARY KEY (`kd_tiket`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
