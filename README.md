# 💰 Simple Expense Tracker App

A lightweight Java EE web application that allows users to log and track their personal expenses securely. Designed with a clean 3-tier architecture (Presentation, Business, and Persistence layers), the application supports role-based access, JPQL-based reporting, and basic admin capabilities.

---

## 📐 Architecture Overview

**Type**: 3-Tier Java EE Application  
**Technologies**:
- **Frontend**: JSP
- **Business Layer**: Stateless EJBs
- **Persistence Layer**: JPA with JPQL
- **Security**: Container-managed form-based authentication (JAAS/web.xml)

---

## 👤 Roles

- **USER**: Can register, log in, and manage their own expenses.
- **ADMIN**: Can view all users, manage categories, and audit expenses.

---

## ✨ Features

### 🔒 Authentication & Authorization
- Secure login with form-based auth
- Role-based access: `USER`, `ADMIN`
<!-- - Pages are protected by `web.xml` security constraints and `@RolesAllowed` -->

### 🧾 Expense Tracking (USER)
- Add/edit/delete expense entries
- Filter expenses by date range or category
- View daily/weekly/monthly summaries

### 🛠 Admin Panel (ADMIN)
- View all users and their expenses
- Manage global expense categories
- Access aggregate reports


## 🧾 Entity Overview

### `User`
- `username` (PK)
- `password`
- `role`: `USER` or `ADMIN`

### `Expense`
- `id` (PK)
- `amount`
- `description`
- `date`
- `category` (FK to `Category`)
- `user` (FK to `User`)

### `Category`
- `id` (PK)
- `name`
- `isGlobal` (boolean) — for admin-defined vs user-defined

---
