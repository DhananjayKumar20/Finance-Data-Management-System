
<div align="center">

# 💰 Dhananjay — Finance Data Processing and Access Control Backend

### *A production-grade, role-based financial data management syetm*
### *Built for Zorvyn FinTech · Spring Boot · PostgreSQL · JWT · Swagger · Pagination*

<br/>

[![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14+-336791?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![JWT](https://img.shields.io/badge/JWT-Secured-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)](https://jwt.io/)
[![Swagger](https://img.shields.io/badge/Swagger-UI-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)](https://swagger.io/)
[![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](LICENSE)

<br/>

> 🏦 **Dhananjay** (Sanskrit: *धनंजय* — "Winner of Wealth") is a clean, scalable REST API for tracking income, expenses, and financial analytics — secured with JWT, enforced by role-based access control, fully documented via Swagger UI, and built for production with paginated endpoints across every module.

<br/>

> 📋 **Submitted for:** *Finance Data Processing and Access Control Backend* — Zorvyn [Assignment]
> 👨‍💻 **Candidate:** Dhananjay Kumar &nbsp;|&nbsp; 📧 dk7248357945@gmail.com

</div>

---

## 📑 Table of Contents

- [🎯 Project Overview](#-project-overview)
- [📋 Assignment Coverage](#-assignment-coverage)
- [🛠️ Tech Stack](#%EF%B8%8F-tech-stack)
- [✨ Features](#-features)
- [👥 Role System](#-role-system)
- [🏗️ Architecture](#%EF%B8%8F-architecture)
- [🗄️ Database Schema](#%EF%B8%8F-database-schema)
- [🚀 Setup Instructions](#-setup-instructions)
- [🔧 Application Configuration](#-application-configuration)
- [📖 Swagger UI Documentation](#-swagger-ui-documentation)
- [📚 API Reference](#-api-reference)
- [🧪 Complete API Test Examples](#-complete-api-test-examples)
- [⚠️ Error Handling](#%EF%B8%8F-error-handling)
- [🔒 Security](#-security)
- [💡 Assumptions & Design Decisions](#-assumptions--design-decisions)
- [🤝 Contributing](#-contributing)

---

## 🎯 Project Overview

**Dhananjay Financial Data Management Syetm** is a Spring Boot application built to manage financial records and deliver real-time analytics dashboards with enterprise-grade security and clean RESTful design.

```
💡 Track INCOME & EXPENSES  ·  📊 Visualize Category/Monthly/Weekly Trends
👮 Role-Based Access Control  ·  📄 Paginated Every Endpoint  ·  🔐 JWT Secured
📖 Swagger UI Docs  ·  🧹 Structured Error Responses  ·  🗄️ PostgreSQL Persistence
```

### 🔑 Key Capabilities

| Capability | Description |
|---|---|
| 🔐 **JWT Authentication** | Stateless token-based signup & login (7-day expiry) |
| 🛡️ **RBAC** | Three roles: `VIEWER`, `ANALYST`, `ADMIN` |
| 💸 **Financial Records** | Full CRUD for `INCOME` & `EXPENSE` entries |
| 📊 **Dashboard Analytics** | Summary, Category Totals, Monthly & Weekly Trends |
| 📄 **Pagination Everywhere** | Every list endpoint is paginated & sortable |
| 📖 **Swagger / OpenAPI 3** | Interactive API docs at `/swagger-ui.html` |
| 🧹 **Clean Error Handling** | Structured JSON error responses across all layers |

---

## 📋 Assignment Coverage

This project fully satisfies all **Core Requirements** and several **Optional Enhancements** from the Zorvyn assignment.

### ✅ Core Requirements

| Requirement | Status | Implementation |
|---|:---:|---|
| 👤 **User & Role Management** | ✅ Done | `UserController` + `UserServiceImpl` — CRUD, role assignment, status toggle |
| 💸 **Financial Records Management** | ✅ Done | `FinancialController` + `FinancialServiceImpl` — full CRUD + multi-field filter |
| 📊 **Dashboard Summary APIs** | ✅ Done | `DashboardController` + `DashboardServiceImpl` — 5 analytics endpoints |
| 🔒 **Access Control Logic** | ✅ Done | Service-layer RBAC checks (`checkAdmin`, `checkAnalystOrAdmin`, `checkAllRolesAccess`) |
| ✔️ **Validation & Error Handling** | ✅ Done | Custom exceptions + structured JSON error responses |
| 🗄️ **Data Persistence** | ✅ Done | PostgreSQL via Spring Data JPA with `ddl-auto=update` |

### 🌟 Optional Enhancements Implemented

| Enhancement | Status | Detail |
|---|:---:|---|
| 🔐 **JWT Authentication** | ✅ Done | HS512-signed tokens, 7-day expiry, stateless sessions |
| 📄 **Pagination** | ✅ Done | All list endpoints — `page`, `size`, `sortBy` with `PaginatedResponse<T>` |
| 🔍 **Filter / Search Support** | ✅ Done | Filter by `type`, `category`, `startDate`, `endDate` |
| 📖 **API Documentation** | ✅ Done | Swagger UI via SpringDoc OpenAPI 2.x |
| 🏗️ **Clean Architecture** | ✅ Done | Strict Controller → Service → Repository separation |

---

## 🛠️ Tech Stack

### 🖥️ Language & Runtime

- **Java 21** — Modern Java with streams, sealed types, and records

### 📦 Frameworks & Libraries

| Technology | Version | Purpose |
|---|---|---|
| ☘️ Spring Boot | 3.x | Core application framework |
| 🗃️ Spring Data JPA | 3.x | ORM & paginated repository support |
| 🔒 Spring Security | 3.x | Authentication & role-based authorization |
| 🌐 Spring Web MVC | 3.x | RESTful controller layer |
| 🪄 Lombok | Latest | `@Builder`, `@RequiredArgsConstructor`, `@Data` |
| 🔑 JJWT | 0.11.5 | JWT token generation & validation (HS512) |
| 📖 SpringDoc OpenAPI | 2.x | Swagger UI & OpenAPI 3 documentation |

### 🗄️ Database

- **PostgreSQL 14+** — Primary relational database

### ⚙️ DevOps & Tooling

- **Maven** — Build & dependency management
- **Postman / Swagger UI** — API testing & interactive documentation
- **IntelliJ IDEA** — Primary IDE
- **Git / GitHub** — Version control

---

## ✨ Features

### 🔐 Authentication Module (`/api/auth`)

- ✅ User registration with role assignment (`VIEWER`, `ANALYST`, `ADMIN`)
- ✅ Secure login with BCrypt password verification
- ✅ JWT token generation on successful auth (7-day validity)
- ✅ Null/empty field validation at service layer
- ✅ Duplicate email prevention

### 💸 Financial Records Module (`/api/records`)

- ✅ **Create** financial records *(ADMIN only)*
- ✅ **Read all** records with pagination & sorting *(All roles)*
- ✅ **Read by ID** *(All roles)*
- ✅ **Update** records *(ADMIN only)*
- ✅ **Delete** records *(ADMIN only)*
- ✅ **Filter** by `type`, `category`, `startDate`, `endDate` *(All roles)*

### 📊 Dashboard Module (`/api/dashboard`)

- ✅ **Overall Summary** — Total income, expenses, net balance, record count *(All roles)*
- ✅ **Category Totals** — Grouped totals per category, filterable by type *(ANALYST, ADMIN)*
- ✅ **Monthly Trends** — Income vs expense for all 12 months of a year *(ANALYST, ADMIN)*
- ✅ **Weekly Trends** — Week-by-week breakdown for any month/year *(ANALYST, ADMIN)*
- ✅ **Recent Activity** — Latest N records sorted by creation time *(All roles)*

### 👤 User Management Module (`/api/users`)

- ✅ **Get all users** with pagination *(ADMIN only)*
- ✅ **Get user by ID** *(ADMIN only)*
- ✅ **Update user role** — Promote/demote between `VIEWER`, `ANALYST`, `ADMIN` *(ADMIN only)*
- ✅ **Update user status** — Toggle `ACTIVE` / `INACTIVE` *(ADMIN only)*

### 📄 Pagination & Sorting

- ✅ All list endpoints accept `page`, `size`, `sortBy` query params
- ✅ 1-indexed pages (human-friendly `page=1` maps to 0-based internally)
- ✅ Standardized `PaginatedResponse<T>` wrapper on every paginated endpoint
- ✅ DB-level pagination for raw records; in-memory `PageImpl` for computed trends

---

## 👥 Role System

```
┌──────────────────────────────────────────────────────────────────────┐
│                          ROLE HIERARCHY                              │
│                                                                      │
│   👁️  VIEWER   ────▶  View records · Summary · Recent Activity       │
│   📊 ANALYST  ────▶  VIEWER + Category Totals · Monthly · Weekly    │
│   🔑  ADMIN   ────▶  ANALYST + Create/Update/Delete Records         │
│                       + Manage Users · Roles · Statuses             │
└──────────────────────────────────────────────────────────────────────┘
```

| Endpoint | 👁️ VIEWER | 📊 ANALYST | 🔑 ADMIN |
|---|:---:|:---:|:---:|
| `POST /api/auth/signup` | ✅ | ✅ | ✅ |
| `POST /api/auth/login` | ✅ | ✅ | ✅ |
| `GET /api/records` | ✅ | ✅ | ✅ |
| `GET /api/records/{id}` | ✅ | ✅ | ✅ |
| `GET /api/records/filter` | ✅ | ✅ | ✅ |
| `POST /api/records` | ❌ | ❌ | ✅ |
| `PUT /api/records/{id}` | ❌ | ❌ | ✅ |
| `DELETE /api/records/{id}` | ❌ | ❌ | ✅ |
| `GET /api/dashboard/summary` | ✅ | ✅ | ✅ |
| `GET /api/dashboard/recent-activity` | ✅ | ✅ | ✅ |
| `GET /api/dashboard/category-totals` | ❌ | ✅ | ✅ |
| `GET /api/dashboard/monthly-trends` | ❌ | ✅ | ✅ |
| `GET /api/dashboard/weekly-trends` | ❌ | ✅ | ✅ |
| `GET /api/users` | ❌ | ❌ | ✅ |
| `GET /api/users/{id}` | ❌ | ❌ | ✅ |
| `PATCH /api/users/{id}/role` | ❌ | ❌ | ✅ |
| `PATCH /api/users/{id}/status` | ❌ | ❌ | ✅ |

---

## 🏗️ Architecture

### 🖼️ System Architecture Diagram

```
┌──────────────────────────────────────────────────────────────────────┐
│             REST Client  (Postman / Swagger UI / Frontend)           │
└──────────────────────────────┬───────────────────────────────────────┘
                               │  HTTP Request + Bearer Token
                               ▼
┌──────────────────────────────────────────────────────────────────────┐
│                  🔐 JWT Authentication Filter                        │
│       Validates token · Extracts email · Sets SecurityContext        │
└──────────┬────────────────┬──────────────────┬───────────────────────┘
           │                │                  │
           ▼                ▼                  ▼
  ┌──────────────┐  ┌────────────────────┐  ┌──────────────────────┐
  │  AuthCtrl    │  │  FinancialCtrl     │  │  UserController      │
  │ /api/auth    │  │  /api/records      │  │  /api/users          │
  └──────┬───────┘  └────────┬───────────┘  └──────────┬───────────┘
         │                   │                          │
         ▼                   ▼                          ▼
  ┌─────────────┐  ┌──────────────────┐    ┌──────────────────────┐
  │ AuthService │  │ FinancialService  │    │    UserService       │
  │ • Validate  │  │ • CRUD Logic     │    │ • RBAC Checks        │
  │ • BCrypt    │  │ • Pagination     │    │ • Role/Status Mgmt   │
  │ • JWT Gen   │  │ • Filter Logic   │    │ • DB Pagination      │
  └─────────────┘  └──────────────────┘    └──────────────────────┘
                          │
                          ▼
              ┌───────────────────────┐
              │  DashboardController  │
              │  /api/dashboard       │
              └──────────┬────────────┘
                         ▼
              ┌───────────────────────┐
              │  DashboardService     │
              │ • Summary Aggregation │
              │ • Category Grouping   │
              │ • Monthly 12-pt Trend │
              │ • Weekly 4-pt Trend   │
              │ • Recent Activity     │
              └──────────┬────────────┘
                         │
         ┌───────────────┴──────────────────┐
         ▼                                  ▼
┌─────────────────────┐         ┌─────────────────────┐
│ FinancialRecord     │         │   User Repository   │
│ Repository (JPA)    │         │   (JPA + Pageable)  │
└──────────┬──────────┘         └──────────┬──────────┘
           └──────────────┬────────────────┘
                          ▼
               ┌─────────────────────┐
               │    PostgreSQL DB     │
               │  • users            │
               │  • financial_record │
               └─────────────────────┘
```

### 🧱 Layer Responsibilities

**🌐 Controller Layer**
- Extracts JWT email via `getEmailFromRequest()` from `Authorization` header
- Converts human-friendly `page=1` to 0-based index before passing to service
- Wraps all paginated results in `PaginatedResponse.from(page)`
- Zero business logic — pure HTTP boundary

**⚙️ Service Layer**
- Validates user existence via `getUserByEmail(email)`
- Enforces RBAC: `checkAdmin()`, `checkAnalystOrAdmin()`, `checkAllRolesAccess()`
- Executes all business logic: filtering, aggregating, grouping, trend calculation
- Returns `Page<DTO>` for all list operations

**🗄️ Repository Layer**
- Extends `JpaRepository` — provides `findAll(Pageable)` natively
- DB-level pagination used for `FinancialRecord` and `User` raw queries
- In-memory `PageImpl` slicing for computed/aggregated DTOs (trends, category totals)

**🔒 Security Layer**
- `JwtAuthenticationFilter` runs on every protected request
- Extracts and validates Bearer token from `Authorization` header
- Loads `UserDetails` from DB and sets `SecurityContextHolder`

---

## 🗄️ Database Schema

### 👤 `users` Table

```sql
CREATE TABLE users (
  id          BIGSERIAL    PRIMARY KEY,
  email       VARCHAR(255) NOT NULL UNIQUE,
  name        VARCHAR(255),
  password    VARCHAR(255) NOT NULL,
  user_type   VARCHAR(50),                    -- VIEWER | ANALYST | ADMIN
  user_status VARCHAR(50)  DEFAULT 'ACTIVE',  -- ACTIVE | INACTIVE
  created_at  TIMESTAMP    NOT NULL,
  updated_at  TIMESTAMP
);
```

| Column | Type | Constraints | Description |
|---|---|---|---|
| `id` | BIGSERIAL | PK | Auto-generated primary key |
| `email` | VARCHAR(255) | NOT NULL, UNIQUE | Login identifier |
| `name` | VARCHAR(255) | — | Display name |
| `password` | VARCHAR(255) | NOT NULL | BCrypt-encoded |
| `user_type` | VARCHAR(50) | — | `VIEWER` / `ANALYST` / `ADMIN` |
| `user_status` | VARCHAR(50) | DEFAULT ACTIVE | `ACTIVE` / `INACTIVE` |
| `created_at` | TIMESTAMP | NOT NULL, immutable | Creation timestamp |
| `updated_at` | TIMESTAMP | — | Last modified timestamp |

---

### 💸 `financial_record` Table

```sql
CREATE TABLE financial_record (
  id         BIGSERIAL     PRIMARY KEY,
  amount     NUMERIC(19,2) NOT NULL,
  type       VARCHAR(50)   NOT NULL,  -- INCOME | EXPENSE
  category   VARCHAR(255),
  date       DATE,
  notes      TEXT,
  created_by VARCHAR(255),
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);
```

| Column | Type | Description |
|---|---|---|
| `id` | BIGSERIAL | Auto-generated PK |
| `amount` | NUMERIC(19,2) | Monetary value |
| `type` | VARCHAR(50) | `INCOME` / `EXPENSE` |
| `category` | VARCHAR(255) | e.g. Salary, Food, Rent |
| `date` | DATE | Transaction date |
| `notes` | TEXT | Optional description |
| `created_by` | VARCHAR(255) | ID of the creator user |
| `created_at` | TIMESTAMP | Record creation timestamp |
| `updated_at` | TIMESTAMP | Last update timestamp |

---

### 🔢 Enumerations

```java
enum UserType   { VIEWER, ANALYST, ADMIN }   // 🔵 Controls API access level
enum UserStatus { ACTIVE, INACTIVE }          // 🟢 User lifecycle state
enum RecordType { INCOME, EXPENSE }           // 🟡 Financial entry direction
```

---

## 🚀 Setup Instructions

### ✅ Prerequisites

| Requirement | Minimum Version |
|---|---|
| ☕ JDK | 21 |
| 📦 Maven | 3.6+ |
| 🐘 PostgreSQL | 14+ |
| 🔧 Git | Latest |

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/DhananjayKumar20/dhananjay-finance-api.git
cd dhananjay-finance-api
```

### 2️⃣ Create the PostgreSQL Database

Connect to PostgreSQL and run:

```sql
CREATE DATABASE management;
```

> 💡 The database name must be `management` to match the default `application.properties`.

### 3️⃣ Configure `application.properties`

Edit `src/main/resources/application.properties` — see full config in the next section.

### 4️⃣ Build & Run

```bash
# Clean build (skip tests for quick start)
mvn clean install -DskipTests

# Run the application
mvn spring-boot:run
```

### 5️⃣ Verify the Application is Running

```
✅ Application starts on:  http://localhost:8080
📖 Swagger UI available:   http://localhost:8080/swagger-ui.html
📄 OpenAPI JSON at:        http://localhost:8080/v3/api-docs
```

---

## 🔧 Application Configuration

Place this as `src/main/resources/application.properties`:

```properties
# ── App Name ──────────────────────────────────────────────────────────
spring.application.name=dhananjay

# ── PostgreSQL Database ───────────────────────────────────────────────
spring.datasource.url=jdbc:postgresql://localhost:5432/db_name
spring.datasource.username=postgres
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver

# ── JPA / Hibernate ───────────────────────────────────────────────────
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# ── Swagger / OpenAPI ─────────────────────────────────────────────────
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.enabled=true

# ── JWT ───────────────────────────────────────────────────────────────
jwt.secret=${JWT_SECRET}
jwt.expiration-ms=604800000
# 604800000 ms = 7 days token validity
```

> ⚠️ **Security Note:** Never commit real credentials to a public repository. Use environment variables or a `.env` file in production environments.

---

## 📖 Swagger UI Documentation

This project includes full **interactive API documentation** via SpringDoc OpenAPI 2.x. You can browse, authorize with JWT, and test every endpoint directly in the browser — no Postman required.

### 🌐 Access URLs

| Resource | URL |
|---|---|
| 🖥️ Swagger UI (Interactive) | `http://localhost:8080/swagger-ui.html` |
| 📄 OpenAPI JSON Spec | `http://localhost:8080/v3/api-docs` |

---

### 🔐 Step-by-Step: How to Use Swagger UI with JWT

#### 🟢 Step 1 — Open Swagger UI

Navigate to `http://localhost:8080/swagger-ui.html` in your browser.

You will see all API groups listed:

```
📁 auth-controller       →  POST /signup, POST /login
📁 financial-controller  →  GET/POST/PUT/DELETE /api/records
📁 dashboard-controller  →  GET /api/dashboard/*
📁 user-controller       →  GET/PATCH /api/users
```

---

#### 🟢 Step 2 — Get Your JWT Token

Expand **`auth-controller`** → Click **`POST /api/auth/login`** → Click **"Try it out"**

Enter the request body:

```json
{
  "email": "dhananjay@zorvyn.com",
  "password": "admin@123"
}
```

Click **Execute**. From the response, copy the value of `"token"`:

```json
{
  "name": "Dhananjay Kumar",
  "email": "dhananjay@zorvyn.com",
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOi...",
  "message": "Login successful"
}
```

---

#### 🟢 Step 3 — Authorize in Swagger UI

Click the **🔒 Authorize** button at the **top right** of the Swagger page.

In the popup dialog that appears, type:

```
Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOi...
```

> ⚠️ **Critical:** You **must** prefix the token with `Bearer ` (capital B + one space). Without this, authorization will fail.

Click **Authorize** → then **Close**.

---

#### 🟢 Step 4 — Test Any Protected Endpoint

All endpoints now carry your JWT automatically in the header. You will see a **closed lock icon 🔒** on each endpoint confirming it's authorized.

Pick any endpoint → Click **"Try it out"** → Fill in parameters → Click **Execute**.

The response will render inline with status code, headers, and body.

---

#### 🟢 Step 5 — Test Unauthorized Access

To test 401/403 responses:

Click **🔒 Authorize** → Click **Logout** → Click **Close** → Execute any protected endpoint.

You will receive a `401 Unauthorized` response, confirming security is working correctly.

---

#### 🟢 Step 6 — Switch Between Roles

Sign up with different `userType` values (`VIEWER`, `ANALYST`, `ADMIN`), log in as each, and use their respective tokens in Swagger to observe role-based behavior.

For example — calling `GET /api/dashboard/category-totals` with a `VIEWER` token will return `403 Forbidden`.

---

### 📋 Swagger UI — API Groups Overview

| Group | Endpoints | Accessible By |
|---|---|---|
| 🔐 `auth-controller` | `POST /signup`, `POST /login` | Public |
| 💸 `financial-controller` | `GET/POST/PUT/DELETE /api/records`, `GET /filter` | ALL (write: ADMIN only) |
| 📊 `dashboard-controller` | `GET /summary`, `/category-totals`, `/monthly-trends`, `/weekly-trends`, `/recent-activity` | ALL / ANALYST+ |
| 👤 `user-controller` | `GET /users`, `GET /users/{id}`, `PATCH /role`, `PATCH /status` | ADMIN only |

---

## 📚 API Reference

### 🔗 Base URL

```
http://localhost:8080
```

### 🔑 Authentication Header *(all protected endpoints)*

```
Authorization: Bearer <your_jwt_token>
```

---

### 🔐 Auth — `/api/auth`

| Method | Endpoint | Auth | Description |
|---|---|:---:|---|
| `POST` | `/api/auth/signup` | ❌ Public | Register a new user with a role |
| `POST` | `/api/auth/login` | ❌ Public | Login and receive a JWT token |

---

### 💸 Financial Records — `/api/records`

| Method | Endpoint | Auth | Role | Description |
|---|---|:---:|---|---|
| `POST` | `/api/records` | ✅ | ADMIN | Create a new financial record |
| `GET` | `/api/records` | ✅ | ALL | Get all records (paginated) |
| `GET` | `/api/records/{id}` | ✅ | ALL | Get single record by ID |
| `PUT` | `/api/records/{id}` | ✅ | ADMIN | Update a record |
| `DELETE` | `/api/records/{id}` | ✅ | ADMIN | Delete a record |
| `GET` | `/api/records/filter` | ✅ | ALL | Filter records by criteria |

**Pagination query params — `GET /api/records`:**

| Param | Default | Description |
|---|---|---|
| `page` | `1` | Page number (1-indexed) |
| `size` | `10` | Records per page |
| `sortBy` | `id` | Sort field — always descending |

**Filter query params — `GET /api/records/filter`:**

| Param | Type | Example | Description |
|---|---|---|---|
| `type` | String | `INCOME` | Filter by record type |
| `category` | String | `Food` | Case-insensitive category match |
| `startDate` | LocalDate | `2025-01-01` | Inclusive start date |
| `endDate` | LocalDate | `2025-12-31` | Inclusive end date |

---

### 📊 Dashboard — `/api/dashboard`

| Method | Endpoint | Auth | Role | Description |
|---|---|:---:|---|---|
| `GET` | `/api/dashboard/summary` | ✅ | ALL | Total income, expenses, net balance, record count |
| `GET` | `/api/dashboard/category-totals` | ✅ | ANALYST, ADMIN | Grouped totals by category |
| `GET` | `/api/dashboard/monthly-trends` | ✅ | ANALYST, ADMIN | Monthly income vs expense for a year |
| `GET` | `/api/dashboard/weekly-trends` | ✅ | ANALYST, ADMIN | Week-by-week for a month/year |
| `GET` | `/api/dashboard/recent-activity` | ✅ | ALL | Latest N records by creation time |

**Query params per dashboard endpoint:**

| Endpoint | Required | Optional | Defaults |
|---|---|---|---|
| `summary` | — | — | — |
| `category-totals` | — | `type`, `page`, `size`, `sortBy` | `page=1`, `size=10`, `sortBy=category` |
| `monthly-trends` | `year` | `page`, `size`, `sortBy` | `page=1`, `size=12`, `sortBy=month` |
| `weekly-trends` | `month`, `year` | `page`, `size`, `sortBy` | `page=1`, `size=4`, `sortBy=week` |
| `recent-activity` | — | `page`, `size`, `sortBy` | `page=1`, `size=5`, `sortBy=createdAt` |

---

### 👤 User Management — `/api/users`

| Method | Endpoint | Auth | Role | Description |
|---|---|:---:|---|---|
| `GET` | `/api/users` | ✅ | ADMIN | Get all users (paginated) |
| `GET` | `/api/users/{id}` | ✅ | ADMIN | Get a user by ID |
| `PATCH` | `/api/users/{id}/role` | ✅ | ADMIN | Update user's role |
| `PATCH` | `/api/users/{id}/status` | ✅ | ADMIN | Update user's status |

**Pagination params — `GET /api/users`:**

| Param | Default | Description |
|---|---|---|
| `page` | `1` | Page number (1-indexed) |
| `size` | `10` | Users per page |
| `sortBy` | `id` | Sort field — descending |

---

## 🧪 Complete API Test Examples

Follow these tests **in sequence** to fully exercise the system. Start with an empty database for clean results.

---

### 🔐 Test 1 — Register an ADMIN User

**`POST http://localhost:8080/api/auth/signup`**

```json
// Request Body
{
  "name": "Dhananjay Kumar",
  "email": "dhananjay@zorvyn.com",
  "password": "admin@123",
  "userType": "ADMIN"
}
```

```json
// ✅ Response 200 OK
{
  "name": "Dhananjay Kumar",
  "email": "dhananjay@zorvyn.com",
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkaGFuYW5qYXlAem9ydnlu...",
  "message": "Signup successful"
}
```

> 📌 **Save this token — it is your ADMIN token** for all write operations and user management.

---

### 🔐 Test 2 — Register an ANALYST User

**`POST http://localhost:8080/api/auth/signup`**

```json
// Request Body
{
  "name": "Riya Sharma",
  "email": "riya@zorvyn.com",
  "password": "analyst@123",
  "userType": "ANALYST"
}
```

```json
// ✅ Response 200 OK
{
  "name": "Riya Sharma",
  "email": "riya@zorvyn.com",
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyaXlhQHpvcnZ5bi5...",
  "message": "Signup successful"
}
```

---

### 🔐 Test 3 — Register a VIEWER User

**`POST http://localhost:8080/api/auth/signup`**

```json
// Request Body
{
  "name": "Arjun Mehta",
  "email": "arjun@zorvyn.com",
  "password": "viewer@123",
  "userType": "VIEWER"
}
```

```json
// ✅ Response 200 OK
{
  "name": "Arjun Mehta",
  "email": "arjun@zorvyn.com",
  "token": "eyJhbGciOiJIUzUxMiJ9...",
  "message": "Signup successful"
}
```

---

### 🔐 Test 4 — Login

**`POST http://localhost:8080/api/auth/login`**

```json
// Request Body
{
  "email": "dhananjay@zorvyn.com",
  "password": "admin@123"
}
```

```json
// ✅ Response 200 OK
{
  "name": "Dhananjay Kumar",
  "email": "dhananjay@zorvyn.com",
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkaGFuYW5qYXlAem9ydnlu...",
  "message": "Login successful"
}
```

---

### 🔐 Test 5 — Signup Validation: Duplicate Email

**`POST http://localhost:8080/api/auth/signup`** *(same email again)*

```json
// Request Body
{
  "name": "Test User",
  "email": "dhananjay@zorvyn.com",
  "password": "test@123",
  "userType": "VIEWER"
}
```

```json
// ❌ Response 401
{
  "status": 401,
  "message": "User already exists with email: dhananjay@zorvyn.com",
  "timestamp": "2025-04-04T10:00:00"
}
```

---

### 💸 Test 6 — Create Financial Records (ADMIN)

**`POST http://localhost:8080/api/records`**
**Header:** `Authorization: Bearer <ADMIN_TOKEN>`

Run each of the following requests individually:

```json
// Record 1 — Salary Income
{
  "amount": 75000.00,
  "recordType": "INCOME",
  "category": "Salary",
  "date": "2025-04-01",
  "notes": "April salary credit"
}
```

```json
// ✅ Response 200 OK
{
  "id": 1,
  "amount": 75000.00,
  "recordType": "INCOME",
  "category": "Salary",
  "date": "2025-04-01",
  "notes": "April salary credit",
  "createdBy": "1",
  "createdAt": "2025-04-01T10:00:00",
  "updatedAt": "2025-04-01T10:00:00"
}
```

```json
// Record 2 — Rent Expense
{
  "amount": 18000.00,
  "recordType": "EXPENSE",
  "category": "Rent",
  "date": "2025-04-02",
  "notes": "April house rent"
}
```

```json
// Record 3 — Food Expense
{
  "amount": 3500.00,
  "recordType": "EXPENSE",
  "category": "Food",
  "date": "2025-04-05",
  "notes": "Weekly groceries"
}
```

```json
// Record 4 — Freelance Income (March)
{
  "amount": 25000.00,
  "recordType": "INCOME",
  "category": "Freelance",
  "date": "2025-03-15",
  "notes": "Web project payment"
}
```

```json
// Record 5 — Transport Expense
{
  "amount": 2200.00,
  "recordType": "EXPENSE",
  "category": "Transport",
  "date": "2025-04-10",
  "notes": "Monthly cab pass"
}
```

---

### 💸 Test 7 — Create Record: Invalid Type (Validation Error)

**`POST http://localhost:8080/api/records`**
**Header:** `Authorization: Bearer <ADMIN_TOKEN>`

```json
// Request Body — invalid recordType
{
  "amount": 5000.00,
  "recordType": "SALARY",
  "category": "Bonus",
  "date": "2025-04-01",
  "notes": "This should fail"
}
```

```json
// ❌ Response 400
{
  "status": 400,
  "message": "Invalid type: SALARY. Allowed: INCOME, EXPENSE",
  "timestamp": "2025-04-04T10:00:00"
}
```

---

### 💸 Test 8 — Create Record as VIEWER (Access Denied)

**`POST http://localhost:8080/api/records`**
**Header:** `Authorization: Bearer <VIEWER_TOKEN>`

```json
// Request Body
{
  "amount": 1000.00,
  "recordType": "INCOME",
  "category": "Other",
  "date": "2025-04-01",
  "notes": "Viewer trying to create"
}
```

```json
// ❌ Response 403
{
  "status": 403,
  "message": "Only admin allowed",
  "timestamp": "2025-04-04T10:00:00"
}
```

---

### 💸 Test 9 — Get All Records (Paginated)

**`GET http://localhost:8080/api/records?page=1&size=3&sortBy=id`**
**Header:** `Authorization: Bearer <ANY_TOKEN>`

```json
// ✅ Response 200 OK
{
  "content": [
    {
      "id": 5,
      "amount": 2200.00,
      "recordType": "EXPENSE",
      "category": "Transport",
      "date": "2025-04-10",
      "notes": "Monthly cab pass",
      "createdBy": "1",
      "createdAt": "2025-04-10T11:00:00",
      "updatedAt": "2025-04-10T11:00:00"
    },
    {
      "id": 4,
      "amount": 25000.00,
      "recordType": "INCOME",
      "category": "Freelance",
      "date": "2025-03-15",
      "notes": "Web project payment",
      "createdBy": "1",
      "createdAt": "2025-03-15T09:00:00",
      "updatedAt": "2025-03-15T09:00:00"
    },
    {
      "id": 3,
      "amount": 3500.00,
      "recordType": "EXPENSE",
      "category": "Food",
      "date": "2025-04-05",
      "notes": "Weekly groceries",
      "createdBy": "1",
      "createdAt": "2025-04-05T14:00:00",
      "updatedAt": "2025-04-05T14:00:00"
    }
  ],
  "pageNumber": 1,
  "pageSize": 3,
  "totalElements": 5,
  "totalPages": 2,
  "isLast": false
}
```

---

### 💸 Test 10 — Get Record by ID

**`GET http://localhost:8080/api/records/1`**
**Header:** `Authorization: Bearer <ANY_TOKEN>`

```json
// ✅ Response 200 OK
{
  "id": 1,
  "amount": 75000.00,
  "recordType": "INCOME",
  "category": "Salary",
  "date": "2025-04-01",
  "notes": "April salary credit",
  "createdBy": "1",
  "createdAt": "2025-04-01T10:00:00",
  "updatedAt": "2025-04-01T10:00:00"
}
```

---

### 💸 Test 11 — Get Record by Invalid ID

**`GET http://localhost:8080/api/records/999`**
**Header:** `Authorization: Bearer <ANY_TOKEN>`

```json
// ❌ Response 400
{
  "status": 400,
  "message": "Record not found",
  "timestamp": "2025-04-04T10:00:00"
}
```

---

### 💸 Test 12 — Update a Record (ADMIN)

**`PUT http://localhost:8080/api/records/3`**
**Header:** `Authorization: Bearer <ADMIN_TOKEN>`

```json
// Request Body
{
  "amount": 4200.00,
  "recordType": "EXPENSE",
  "category": "Food",
  "date": "2025-04-05",
  "notes": "Grocery + dining update"
}
```

```json
// ✅ Response 200 OK
{
  "id": 3,
  "amount": 4200.00,
  "recordType": "EXPENSE",
  "category": "Food",
  "date": "2025-04-05",
  "notes": "Grocery + dining update",
  "createdBy": "1",
  "createdAt": "2025-04-05T14:00:00",
  "updatedAt": "2025-04-12T09:30:00"
}
```

---

### 💸 Test 13 — Filter Records by Type

**`GET http://localhost:8080/api/records/filter?type=EXPENSE`**
**Header:** `Authorization: Bearer <ANY_TOKEN>`

```json
// ✅ Response 200 OK
[
  { "id": 2, "amount": 18000.00, "recordType": "EXPENSE", "category": "Rent",      "date": "2025-04-02", ... },
  { "id": 3, "amount": 4200.00,  "recordType": "EXPENSE", "category": "Food",      "date": "2025-04-05", ... },
  { "id": 5, "amount": 2200.00,  "recordType": "EXPENSE", "category": "Transport", "date": "2025-04-10", ... }
]
```

**Filter by category:**

**`GET http://localhost:8080/api/records/filter?type=EXPENSE&category=Food`**

```json
// ✅ Response 200 OK
[
  {
    "id": 3,
    "amount": 4200.00,
    "recordType": "EXPENSE",
    "category": "Food",
    "date": "2025-04-05",
    "notes": "Grocery + dining update",
    "createdBy": "1",
    "createdAt": "2025-04-05T14:00:00",
    "updatedAt": "2025-04-12T09:30:00"
  }
]
```

**Filter by date range:**

**`GET http://localhost:8080/api/records/filter?startDate=2025-04-01&endDate=2025-04-30`**

```json
// ✅ Response 200 OK
[
  { "id": 1, "amount": 75000.00, "recordType": "INCOME",  "category": "Salary",    "date": "2025-04-01", ... },
  { "id": 2, "amount": 18000.00, "recordType": "EXPENSE", "category": "Rent",      "date": "2025-04-02", ... },
  { "id": 3, "amount": 4200.00,  "recordType": "EXPENSE", "category": "Food",      "date": "2025-04-05", ... },
  { "id": 5, "amount": 2200.00,  "recordType": "EXPENSE", "category": "Transport", "date": "2025-04-10", ... }
]
```

---

### 💸 Test 14 — Delete a Record (ADMIN)

**`DELETE http://localhost:8080/api/records/5`**
**Header:** `Authorization: Bearer <ADMIN_TOKEN>`

```
// ✅ Response 200 OK
"Record deleted successfully"
```

---

### 📊 Test 15 — Dashboard Summary (All Roles)

**`GET http://localhost:8080/api/dashboard/summary`**
**Header:** `Authorization: Bearer <ANY_TOKEN>`

```json
// ✅ Response 200 OK
{
  "totalIncome": 100000.00,
  "totalExpenses": 24700.00,
  "netBalance": 75300.00,
  "totalRecords": 4
}
```

---

### 📊 Test 16 — Category Totals (ANALYST / ADMIN)

**`GET http://localhost:8080/api/dashboard/category-totals?page=1&size=10`**
**Header:** `Authorization: Bearer <ANALYST_OR_ADMIN_TOKEN>`

```json
// ✅ Response 200 OK
{
  "content": [
    { "category": "Food",      "total": 4200.00,  "count": 1 },
    { "category": "Freelance", "total": 25000.00, "count": 1 },
    { "category": "Rent",      "total": 18000.00, "count": 1 },
    { "category": "Salary",    "total": 75000.00, "count": 1 }
  ],
  "pageNumber": 1,
  "pageSize": 10,
  "totalElements": 4,
  "totalPages": 1,
  "isLast": true
}
```

**Filter by EXPENSE only:**

**`GET http://localhost:8080/api/dashboard/category-totals?type=EXPENSE&page=1&size=10`**

```json
// ✅ Response 200 OK
{
  "content": [
    { "category": "Food", "total": 4200.00, "count": 1 },
    { "category": "Rent", "total": 18000.00, "count": 1 }
  ],
  "pageNumber": 1,
  "pageSize": 10,
  "totalElements": 2,
  "totalPages": 1,
  "isLast": true
}
```

---

### 📊 Test 17 — Category Totals as VIEWER (Access Denied)

**`GET http://localhost:8080/api/dashboard/category-totals?page=1&size=10`**
**Header:** `Authorization: Bearer <VIEWER_TOKEN>`

```json
// ❌ Response 403
{
  "status": 403,
  "message": "Access denied. Only ANALYST and ADMIN allowed",
  "timestamp": "2025-04-04T10:00:00"
}
```

---

### 📊 Test 18 — Monthly Trends

**`GET http://localhost:8080/api/dashboard/monthly-trends?year=2025&page=1&size=12`**
**Header:** `Authorization: Bearer <ANALYST_OR_ADMIN_TOKEN>`

```json
// ✅ Response 200 OK
{
  "content": [
    { "month": "January",   "income": 0.00,     "expense": 0.00,     "net": 0.00     },
    { "month": "February",  "income": 0.00,     "expense": 0.00,     "net": 0.00     },
    { "month": "March",     "income": 25000.00, "expense": 0.00,     "net": 25000.00 },
    { "month": "April",     "income": 75000.00, "expense": 22200.00, "net": 52800.00 },
    { "month": "May",       "income": 0.00,     "expense": 0.00,     "net": 0.00     },
    { "month": "June",      "income": 0.00,     "expense": 0.00,     "net": 0.00     },
    { "month": "July",      "income": 0.00,     "expense": 0.00,     "net": 0.00     },
    { "month": "August",    "income": 0.00,     "expense": 0.00,     "net": 0.00     },
    { "month": "September", "income": 0.00,     "expense": 0.00,     "net": 0.00     },
    { "month": "October",   "income": 0.00,     "expense": 0.00,     "net": 0.00     },
    { "month": "November",  "income": 0.00,     "expense": 0.00,     "net": 0.00     },
    { "month": "December",  "income": 0.00,     "expense": 0.00,     "net": 0.00     }
  ],
  "pageNumber": 1,
  "pageSize": 12,
  "totalElements": 12,
  "totalPages": 1,
  "isLast": true
}
```

---

### 📊 Test 19 — Weekly Trends

**`GET http://localhost:8080/api/dashboard/weekly-trends?month=4&year=2025&page=1&size=4`**
**Header:** `Authorization: Bearer <ANALYST_OR_ADMIN_TOKEN>`

```json
// ✅ Response 200 OK
{
  "content": [
    { "week": "Week 1 (Day 1-7)",   "income": 75000.00, "expense": 18000.00, "net": 57000.00 },
    { "week": "Week 2 (Day 8-14)",  "income": 0.00,     "expense": 2200.00,  "net": -2200.00 },
    { "week": "Week 3 (Day 15-21)", "income": 0.00,     "expense": 0.00,     "net": 0.00     },
    { "week": "Week 4 (Day 22-31)", "income": 0.00,     "expense": 0.00,     "net": 0.00     }
  ],
  "pageNumber": 1,
  "pageSize": 4,
  "totalElements": 4,
  "totalPages": 1,
  "isLast": true
}
```

---

### 📊 Test 20 — Recent Activity

**`GET http://localhost:8080/api/dashboard/recent-activity?page=1&size=3&sortBy=createdAt`**
**Header:** `Authorization: Bearer <ANY_TOKEN>`

```json
// ✅ Response 200 OK
{
  "content": [
    {
      "id": 3,
      "amount": 4200.00,
      "recordType": "EXPENSE",
      "category": "Food",
      "date": "2025-04-05",
      "notes": "Grocery + dining update",
      "createdAt": "2025-04-05T14:00:00"
    },
    {
      "id": 2,
      "amount": 18000.00,
      "recordType": "EXPENSE",
      "category": "Rent",
      "date": "2025-04-02",
      "notes": "April house rent",
      "createdAt": "2025-04-02T10:00:00"
    },
    {
      "id": 1,
      "amount": 75000.00,
      "recordType": "INCOME",
      "category": "Salary",
      "date": "2025-04-01",
      "notes": "April salary credit",
      "createdAt": "2025-04-01T10:00:00"
    }
  ],
  "pageNumber": 1,
  "pageSize": 3,
  "totalElements": 4,
  "totalPages": 2,
  "isLast": false
}
```

---

### 👤 Test 21 — Get All Users (ADMIN)

**`GET http://localhost:8080/api/users?page=1&size=10&sortBy=id`**
**Header:** `Authorization: Bearer <ADMIN_TOKEN>`

```json
// ✅ Response 200 OK
{
  "content": [
    {
      "id": 3,
      "name": "Arjun Mehta",
      "email": "arjun@zorvyn.com",
      "userType": "VIEWER",
      "status": "ACTIVE",
      "createdAt": "2025-04-01T10:05:00",
      "updatedAt": "2025-04-01T10:05:00"
    },
    {
      "id": 2,
      "name": "Riya Sharma",
      "email": "riya@zorvyn.com",
      "userType": "ANALYST",
      "status": "ACTIVE",
      "createdAt": "2025-04-01T10:02:00",
      "updatedAt": "2025-04-01T10:02:00"
    },
    {
      "id": 1,
      "name": "Dhananjay Kumar",
      "email": "dhananjay@zorvyn.com",
      "userType": "ADMIN",
      "status": "ACTIVE",
      "createdAt": "2025-04-01T10:00:00",
      "updatedAt": "2025-04-01T10:00:00"
    }
  ],
  "pageNumber": 1,
  "pageSize": 10,
  "totalElements": 3,
  "totalPages": 1,
  "isLast": true
}
```

---

### 👤 Test 22 — Get All Users as ANALYST (Access Denied)

**`GET http://localhost:8080/api/users?page=1&size=10`**
**Header:** `Authorization: Bearer <ANALYST_TOKEN>`

```json
// ❌ Response 403
{
  "status": 403,
  "message": "Only admin can get All Users",
  "timestamp": "2025-04-04T10:00:00"
}
```

---

### 👤 Test 23 — Get User by ID

**`GET http://localhost:8080/api/users/2`**
**Header:** `Authorization: Bearer <ADMIN_TOKEN>`

```json
// ✅ Response 200 OK
{
  "id": 2,
  "name": "Riya Sharma",
  "email": "riya@zorvyn.com",
  "userType": "ANALYST",
  "status": "ACTIVE",
  "createdAt": "2025-04-01T10:02:00",
  "updatedAt": "2025-04-01T10:02:00"
}
```

---

### 👤 Test 24 — Update User Role

**`PATCH http://localhost:8080/api/users/3/role`**
**Header:** `Authorization: Bearer <ADMIN_TOKEN>`

```json
// Request Body — promote VIEWER to ANALYST
{
  "userType": "ANALYST"
}
```

```json
// ✅ Response 200 OK
{
  "id": 3,
  "name": "Arjun Mehta",
  "email": "arjun@zorvyn.com",
  "userType": "ANALYST",
  "status": "ACTIVE",
  "createdAt": "2025-04-01T10:05:00",
  "updatedAt": "2025-04-12T11:30:00"
}
```

**Invalid role value:**

```json
// Request Body
{ "userType": "SUPERADMIN" }
```

```json
// ❌ Response 400
{
  "status": 400,
  "message": "Invalid user type: SUPERADMIN. Allowed values: VIEWER, ANALYST, ADMIN",
  "timestamp": "2025-04-04T10:00:00"
}
```

---

### 👤 Test 25 — Update User Status

**`PATCH http://localhost:8080/api/users/3/status`**
**Header:** `Authorization: Bearer <ADMIN_TOKEN>`

```json
// Request Body
{
  "status": "INACTIVE"
}
```

```json
// ✅ Response 200 OK
{
  "id": 3,
  "name": "Arjun Mehta",
  "email": "arjun@zorvyn.com",
  "userType": "ANALYST",
  "status": "INACTIVE",
  "createdAt": "2025-04-01T10:05:00",
  "updatedAt": "2025-04-12T11:45:00"
}
```

**Invalid status value:**

```json
// Request Body
{ "status": "BANNED" }
```

```json
// ❌ Response 400
{
  "status": 400,
  "message": "Invalid status: BANNED. Allowed values: ACTIVE, INACTIVE",
  "timestamp": "2025-04-04T10:00:00"
}
```

---

### 🔒 Test 26 — Access Without Token (Unauthorized)

**`GET http://localhost:8080/api/records`**
*(No Authorization header)*

```json
// ❌ Response 401
{
  "status": 401,
  "message": "JWT token missing",
  "timestamp": "2025-04-04T10:00:00"
}
```

---

## ⚠️ Error Handling

### 📐 Standard Error Response Format

Every error from this API follows the same structure:

```json
{
  "status": 404,
  "message": "User not found",
  "timestamp": "2025-04-04T10:00:00"
}
```

### 🔴 HTTP Status Code Reference

| Status | Icon | Meaning | When It Occurs |
|---|:---:|---|---|
| `200 OK` | ✅ | Success | All successful GET, POST, PUT, PATCH, DELETE |
| `400 Bad Request` | ❌ | Invalid input | Invalid enum value, empty required field, record not found |
| `401 Unauthorized` | 🔒 | Auth failed | Missing, expired, or invalid JWT token |
| `403 Forbidden` | 🚫 | Insufficient permissions | User's role does not permit the action |
| `404 Not Found` | 🔍 | Resource missing | User not found by ID or email |
| `500 Internal Server Error` | 💥 | Unexpected failure | Unhandled runtime exceptions |

### 🧩 Custom Exception Classes

| Exception Class | HTTP Status | Trigger Scenario |
|---|---|---|
| `AuthenticationException` | `401` | Invalid credentials, duplicate signup email |
| `AccessDeniedException` | `403` | Role not permitted for the requested operation |
| `UserNotFoundException` | `404` | Email or user ID does not exist in database |
| `BadRequestException` | `400` | Invalid enum, missing required field, record not found |

---

## 🔒 Security

### JWT Authentication Flow

```
1. 📤 Client → POST /api/auth/login { email, password }
2. 🔍 Server validates credentials from DB (BCrypt.matches)
3. 🎟️  Server generates JWT signed with HS512 (7-day expiry)
4. 📥 Client receives and stores the token
5. 🔁 Every subsequent request must include:
       Authorization: Bearer <token>
6. 🛡️  JwtAuthenticationFilter runs on each request:
       → Extracts Bearer token from Authorization header
       → Validates signature integrity and expiry
       → Loads UserDetails from DB by email (subject claim)
       → Sets authentication in SecurityContextHolder
7. ✅ Request proceeds to controller if token is valid
   ❌ Returns 401 Unauthorized if missing, invalid, or expired
```

### JWT Configuration

```properties
jwt.secret=9aF$kL8#pQ2!xY7vT@rZ5mN3bH6dS1Wc   # HS512 signing key
jwt.expiration-ms=604800000                       # 7 days = 604,800,000 ms
```

### Spring Security Role Integration

```java
// User entity — implements Spring Security UserDetails
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(() -> "ROLE_" + userType.name());
    // Exposes: "ROLE_VIEWER", "ROLE_ANALYST", "ROLE_ADMIN"
}
```

---

## 💡 Assumptions & Design Decisions

| Decision | Reasoning |
|---|---|
| **Service-layer RBAC** | Keeps access control explicit and readable — no hidden annotation magic, easy to audit |
| **3 roles: VIEWER, ANALYST, ADMIN** | Naturally maps to assignment requirements: read-only users, analytics consumers, and full managers |
| **`UserStatus` field (ACTIVE/INACTIVE)** | Enables soft-disabling users without deleting data — admin retains full audit trail |
| **In-memory `PageImpl` for computed trends** | Monthly/Weekly trends are aggregated DTOs — cannot be paginated at DB level; `PageImpl` is the correct Spring Data approach |
| **DB-level pagination for raw records** | `FinancialRecord` and `User` raw list queries use `Pageable` in the repository for performance |
| **1-indexed pages (`page=1`)** | More intuitive for API consumers; converted to 0-based index internally before service call |
| **`createdBy` stored as String** | Keeps the `FinancialRecord` entity decoupled from a hard foreign-key constraint while maintaining creator traceability |
| **BCrypt password encoding** | Industry-standard one-way hashing — passwords are never stored or transmitted as plain text |
| **JWT expiry 7 days** | Balances security and convenience for a dashboard system where users return daily |
| **`ddl-auto=update`** | Schema auto-managed by Hibernate — appropriate for development and assignment evaluation |
| **No `@PreAuthorize` annotations** | Access checks are in service methods — makes it easy to see authorization logic in one place without scanning annotations across classes |

---

## 🤝 Contributing

Contributions are welcome! 🎉

### Steps to Contribute

**1. Fork & Clone**

```bash
git clone https://github.com/DhananjayKumar20/dhananjay-finance-api.git
cd dhananjay-finance-api
```

**2. Create a Feature Branch**

```bash
git checkout -b feature/your-feature-name
```

**3. Make Changes & Commit**

```bash
git add .
git commit -m "feat: describe your change clearly"
```

**4. Push & Open a Pull Request**

```bash
git push origin feature/your-feature-name
```

### 📏 Code Guidelines

- Strict layered architecture: Controller → Service → Repository
- Never put business logic in controllers
- Validate all input at the service layer
- Use `@Builder` + `@RequiredArgsConstructor` — no manual constructors
- Every list endpoint must return `Page<T>` wrapped in `PaginatedResponse<T>`
- Always use custom exception classes — never throw raw `RuntimeException`
- Commit with conventional prefix: `feat:`, `fix:`, `refactor:`, `docs:`

---

<div align="center">

---

**📅 Last Updated:** April 2026 &nbsp;|&nbsp; **🔖 Version:** 2.1.0 &nbsp;|&nbsp; **👨‍💻 Author:** Dhananjay Kumar

*Built with ❤️ using Spring Boot · Secured with 🔐 JWT · Powered by 🐘 PostgreSQL · Documented with 📖 Swagger*

[![GitHub](https://img.shields.io/badge/GitHub-DhananjayKumar20-181717?style=flat-square&logo=github)](https://github.com/DhananjayKumar20)
&nbsp;
[![Email](https://img.shields.io/badge/Email-dk7248357945%40gmail.com-D14836?style=flat-square&logo=gmail&logoColor=white)](mailto:dk7248357945@gmail.com)

---

*📋 Submitted to Zorvyn Assignment Portal — Finance Data Processing and Access Control Backend — Deadline: Mon 06 Apr 2026*

</div>
