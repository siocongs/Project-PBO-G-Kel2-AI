
# 🥅 **MetaFutsal – Web Based Futsal Booking System**

MetaFutsal adalah aplikasi web berbasis Java JSP/Servlet untuk melakukan **booking lapangan futsal secara online**.
Sistem ini dirancang agar pelanggan dapat memesan lapangan melalui scan barcode.

Proyek ini dibangun menggunakan:

* **Java JSP/Servlet**
* **Bootstrap 5**
* **MySQL**
* **Apache Tomcat**
* **Maven Project Structure**
* **OOP + Interface + MVC Pattern**

---

# 🚀 **Fitur Utama**

### ✔ 1. Login & Register

Pengguna dapat membuat akun atau masuk menggunakan email dan password.

### ✔ 2. Booking / Pemesanan Lapangan

* Memilih lapangan
* Memilih tanggal
* Memilih jam mulai
* Memilih durasi
* Otomatis menghitung total biaya

### ✔ 3. Payment

* Upload bukti pembayaran
* Pilih metode (Transfer / QRIS)
* Konfirmasi pembayaran

### ✔ 4. Struk Pembayaran

Setelah payment berhasil, user menerima struk berisi:

* Detail booking
* Harga
* Lapangan
* Tanggal & durasi

### ✔ 5. Riwayat Booking

User dapat melihat daftar seluruh pesanan sebelumnya.

### ✔ 6. Logout

Menghapus session dan kembali ke halaman login.

### ✔ 7. Notifikasi (Email + Popup)

* Notifikasi popup setelah booking berhasil
* Email notifikasi melalui SMTP (JavaMail API)

---

# 📂 **Struktur Proyek**

```
meta-futsal/
│── pom.xml
│── db.sql
│── README.md
│
├── src/main/java/com/metafutsal/
│   ├── model/
│   ├── dao/
│   ├── servlet/
│   └── util/
│
└── src/main/webapp/
    ├── login.jsp
    ├── register.jsp
    ├── home.jsp
    ├── booking.jsp
    ├── payment.jsp
    ├── receipt.jsp
    ├── history.jsp
    └── WEB-INF/web.xml
```

---

# 🛠 **Cara Install & Menjalankan**

### **1. Clone Repo**

```
git clone https://github.com/username/meta-futsal.git
cd meta-futsal
```

### **2. Import ke IDE / IntelliJ**

* File → Open → pilih folder `meta-futsal`
* Maven akan otomatis download dependencies

---

# 🗃 **3. Setup Database MySQL**

Jalankan file:

```
db.sql
```

Atau manual:

```sql
CREATE DATABASE meta_futsal;
USE meta_futsal;

CREATE TABLE users (
 id INT AUTO_INCREMENT PRIMARY KEY,
 fullname VARCHAR(100),
 email VARCHAR(150) UNIQUE,
 password VARCHAR(255)
);
```

---

# ⚙️ **4. Sesuaikan Koneksi Database**

Buka file:

`src/main/java/com/metafutsal/util/DBUtil.java`

Edit:

```java
private static final String USER = "root";
private static final String PASS = "your_mysql_password";
```

---

# 🚀 **5. Build Proyek**

```
mvn clean package
```

---

# 🌐 **6. Deploy ke Tomcat**

Copy file:

```
target/meta-futsal.war
```

Paste ke:

```
CATALINA_HOME/webapps/
```

Jalankan Tomcat:

```
./startup.sh
```

---

# 🔗 **7. Akses Program**

Buka browser:

-> **[http://localhost:8080/meta-futsal/login.jsp](http://localhost:8080/meta-futsal/login.jsp)**

---

# 🔧 **8. SMTP Email Notifikasi (Opsional)**

Set email di:

`src/main/java/com/metafutsal/util/EmailUtil.java`

Gunakan Gmail App Password.

---

# 📘 **UML Diagram**

Diagram Class, Use Case, ERD:

```
/diagram/
```


---

# 🦋 Anggota - Kelompok Metamorphosis 
Nama / NPM:
1. **Muhamad Bachtiar** - *4524210141*</br>
2. **Zaidan Dziaulfawwaz** - *4524210105*</br>
3. **Akmal Alief Ramadan** - *4524210128*</br>

Project: *MetaFutsal – Sistem Booking Lapangan Futsal*</br>
Mata Kuliah: **PBO (Pemrograman Berorientasi Objek) - G**

---

# 📝 **Lisensi**

Project ini dibuat untuk kebutuhan pembelajaran dan tugas besasr mata kuliah PBO. 
gunakan, modifikasi, atau kembangkan. Jika ingin mempublikasinya harap sertakan sumber aslinya.

