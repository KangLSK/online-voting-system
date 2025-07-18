# 🗳️ 線上投票系統 Online Voting System

本專案是一個三層式線上投票系統，採用前後端分離架構，提供投票項目管理與使用者投票功能，並具備交易一致性與資安保護機制。

---

## 📁 專案結構

```
online-voting-system/
├── vote-system-backend/                # Spring Boot 後端
│   ├── controller/         # 展示層 Controller
│   ├── service/            # 業務邏輯層 Service
│   ├── repository/         # 資料存取層 DAO
│   ├── dto/                # 資料傳輸物件
│   └── VotingApplication.java
├── vote-system-frontend              # Vue.js 前端
│   ├── components/
│   ├── views/
│   └── App.vue
├── DB/                     # 資料庫腳本
│   ├── schema.sql          # DDL 建表語句
│   ├── procedure.sql       # Stored Procedures
│   └── seed-data.sql       # 初始資料
└── README.md
```

---

## ⚙️ 技術棧

- **Frontend:** Vue.js 3, Vite, Axios
- **Backend:** Spring Boot, RESTful API, Gradle
- **Database:** MySQL 
- **Others:** Stored Procedure, Transaction 控制, SQL Injection / XSS 防禦

---

## 🎯 功能說明

### ✅ 管理員功能（後台）
- 顯示所有投票項目
- 新增投票項目
- 更新或刪除投票項目（擇一實作）

### 🧑‍🤝‍🧑 使用者功能（前台）
- 顯示所有可投票項目及票數
- 多選投票（同時可對多個項目投票）

---

## 🔐 資安設計

- ✅ 使用 **Stored Procedure** 防止 SQL Injection
- ✅ 於前後端加強 XSS 過濾與轉譯
- ✅ 使用 Spring Transaction 控制資料一致性

---

## 🚀 部署與執行

### 1️⃣ 資料庫初始化


1. 匯入資料表與程序：
   ```
   \DB\ddl.sql
   \DB\sq.sql
 
   ```

---

### 2️⃣ 後端啟動

```bash
cd vote-system-backend
./mvnw spring-boot:run
# 或者使用 Gradle：
# ./gradlew bootRun
```

---

### 3️⃣ 前端啟動

```bash
cd vote-system-frontend
npm install
npm run dev
```

---

## 📌 API 文件（RESTful）

| 方法 | 路徑 | 功能描述 |
|------|------|----------|
| GET | `/api/items` | 取得所有投票項目與票數 |
| POST | `/api/items` | 新增投票項目 |
| DELETE | `/api/items/{id}` | 刪除投票項目 |
| POST | `/api/vote` | 送出使用者投票（支援多選） |

---



---

## 🛡️ 安全提示

- 禁止在程式中撰寫原始 SQL 語句，統一使用儲存程序呼叫
- 所有輸入欄位應透過 HTML escape 避免 XSS
- 所有涉及兩個以上資料表的異動請使用 `@Transactional` 保證一致性

---

## 📂 資料庫腳本位置

- `DB/ddl.sql`：建表語句（DDL）
- `DB/sp.sql`：所有儲存程序定義


---

