# 🚚 Logistics Platform

### Production-Style Logistics & Shipment Management Backend

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT_|_OAuth2.0-red?style=for-the-badge&logo=springsecurity)
![MongoDB](https://img.shields.io/badge/MongoDB-Database-47A248?style=for-the-badge&logo=mongodb)
![Build](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven)

A production-oriented **Logistics and Shipment Management Platform** built with **Java 21, Spring Boot, Spring Security, JWT, OAuth 2.0, and MongoDB**.

The project models the backend operations of a modern logistics company, covering secure authentication, shipment management, server-side pricing, shipment tracking, controlled shipment lifecycle transitions, delivery-agent assignment, and future delivery operations.

The primary goal of this project is to build a **realistic, secure, and scalable backend system** rather than a simple CRUD application.

---

## 🧭 Project Overview

The Logistics Platform is being developed as a **modular monolith** representing the backend of a logistics company.

The platform is designed around four major operational roles:

| Role | Responsibility |
|---|---|
| 👤 `CUSTOMER` | Create and manage shipments, estimate prices, and track deliveries |
| 🚚 `DELIVERY_AGENT` | Handle assigned shipments and perform delivery operations |
| 🏢 `HUB_OPERATOR` | Manage hub operations and shipment movement |
| 🛡️ `ADMIN` | Manage users, pricing, shipment assignments, and operational configuration |

### Current Platform Flow

```text
Customer
   │
   ├── Register / Login
   │
   ├── Estimate Shipping Price
   │
   ├── Create Shipment
   │
   ▼
Shipment Created
   │
   ├── Tracking Number Generated
   ├── Server-Side Price Calculated
   └── Tracking History Created
   │
   ▼
Admin
   │
   ├── Configure Pricing
   └── Assign Delivery Agent
   │
   ▼
Delivery Agent
   │
   └── View Assigned Shipments
   │
   ▼
Delivery Operations
   │
   ├── Accept / Reject
   ├── Pickup
   ├── In Transit
   ├── Out For Delivery
   └── Delivered
