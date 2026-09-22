# 🚚 Logistics Platform

### Production-Oriented Logistics & Shipment Management Backend

<p align="center">

A modular, production-oriented logistics and shipment management platform built with **Java 21**, **Spring Boot**, **Spring Security**, and **MongoDB**.

Designed around secure authentication, shipment lifecycle management, server-side pricing, tracking, controlled status transitions, delivery-agent assignment, and future logistics operations.

</p>

<p align="center">

![Java 21](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-Database-47A248?style=for-the-badge&logo=mongodb&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

</p>

<p align="center">

![JWT](https://img.shields.io/badge/JWT-Authentication-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)
![OAuth 2.0](https://img.shields.io/badge/OAuth%202.0-Google-4285F4?style=for-the-badge&logo=google&logoColor=white)
![REST API](https://img.shields.io/badge/REST-API-02569B?style=for-the-badge)
![Postman](https://img.shields.io/badge/Postman-Testing-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Git](https://img.shields.io/badge/Git-Version%20Control-F05032?style=for-the-badge&logo=git&logoColor=white)

</p>

---

## 📖 Table of Contents

- [📌 Project Overview](#-project-overview)
- [🎯 Project Goals](#-project-goals)
- [🛠️ Technology Stack](#️-technology-stack)
- [📊 Project Status](#-project-status)
- [✨ Key Features](#-key-features)
- [🔐 Authentication & Authorization](#-authentication--authorization)
- [👤 User Management](#-user-management)
- [📦 Shipment Management](#-shipment-management)
- [💰 Server-Side Pricing Engine](#-server-side-pricing-engine)
- [🧮 Price Estimation](#-price-estimation)
- [🔄 Shipment Lifecycle](#-shipment-lifecycle)
- [🧠 Status Transition Engine](#-status-transition-engine)
- [📍 Shipment Tracking](#-shipment-tracking)
- [🔎 Shipment Retrieval](#-shipment-retrieval)
- [✏️ Shipment Updates](#️-shipment-updates)
- [❌ Shipment Cancellation](#-shipment-cancellation)
- [🚚 Delivery Agent Management](#-delivery-agent-management)
- [🚛 Delivery Agent Workflow](#-delivery-agent-workflow)
- [🏢 Hub Management](#-hub-management)
- [💳 Payments & COD](#-payments--cod)
- [🔔 Notifications](#-notifications)
- [📄 Invoice & Rating](#-invoice--rating)
- [🛡️ API Security](#️-api-security)
- [🧪 Validation & Error Handling](#-validation--error-handling)
- [🧪 Testing](#-testing)
- [📡 API Overview](#-api-overview)
- [📊 Development Status](#-development-status)
- [🗺️ Development Roadmap](#️-development-roadmap)
- [🧱 Production-Oriented Engineering](#-production-oriented-engineering)
- [🏗️ Architecture](#️-architecture)
- [📁 Project Structure](#-project-structure)
- [👥 User Roles](#-user-roles)
- [🔐 Authentication Architecture](#-authentication-architecture)
- [🔑 JWT Authentication](#-jwt-authentication)
- [💰 Pricing Architecture](#-pricing-architecture)
- [🔄 Shipment Workflow Architecture](#-shipment-workflow-architecture)
- [📍 Tracking Architecture](#-tracking-architecture)
- [🚚 Delivery Assignment Architecture](#-delivery-assignment-architecture)
- [🧩 Modular Monolith Design](#-modular-monolith-design)
- [⚙️ Local Setup](#️-local-setup)
- [⚙️ Configuration](#️-configuration)
- [🧪 API Testing with Postman](#-api-testing-with-postman)
- [📡 Example API Workflow](#-example-api-workflow)
- [📈 Future Architecture](#-future-architecture)
- [📌 Current Project State](#-current-project-state)
- [📋 Feature Matrix](#-feature-matrix)
- [🧩 Business Rules](#-business-rules)
- [📈 Future Production Enhancements](#-future-production-enhancements)
- [🔍 API Design Principles](#-api-design-principles)
- [🛡️ Security Principles](#️-security-principles)
- [🧪 Error Handling Strategy](#-error-handling-strategy)
- [📝 Logging](#-logging)
- [📊 Operational Visibility](#-operational-visibility)
- [🏢 Hub Operations — Future Design](#-hub-operations--future-design)
- [💳 Payment Abstraction — Future Design](#-payment-abstraction--future-design)
- [🔔 Notification Architecture — Future Design](#-notification-architecture--future-design)
- [🗂️ Data Model Overview](#️-data-model-overview)
- [🧭 Shipment Ownership Model](#-shipment-ownership-model)
- [🔄 Shipment State Machine](#-shipment-state-machine)
- [📦 Shipment Lifecycle Example](#-shipment-lifecycle-example)
- [🧪 Example Validation Rules](#-example-validation-rules)
- [📚 Development Philosophy](#-development-philosophy)
- [🧱 Why Modular Monolith First?](#-why-modular-monolith-first)
- [📈 Scalability Direction](#-scalability-direction)
- [🧰 Development Tools](#-development-tools)
- [🖥️ Development Environment](#️-development-environment)
- [🔗 Repository](#-repository)
- [🤝 Contributing](#-contributing)
- [🔒 Security Notice](#-security-notice)
- [📄 License](#-license)
- [👤 Author](#-author)

---

# 📌 Project Overview

The **Logistics Platform** is a backend system designed to model the core operations of a modern logistics and shipment management company.

The application is intentionally implemented as a **modular monolith** using Spring Boot. It provides a foundation for customer shipment management, administrative operations, delivery-agent workflows, pricing, tracking, authentication, and future hub and payment operations.

The project is being developed with a strong focus on **production-oriented backend engineering practices** rather than implementing only basic CRUD operations.

### Core Focus Areas

- 🔐 Secure authentication and authorization
- 📦 Shipment lifecycle management
- 💰 Server-side pricing
- 🧮 Price estimation
- 📍 Shipment tracking
- 🔄 Controlled shipment status transitions
- 🚚 Delivery-agent assignment
- 👥 Role-based access control
- 🧪 API validation and testing
- 🧱 Layered backend architecture
- 🛡️ Ownership and authorization checks
- 📈 Production-oriented engineering practices

---

# 🎯 Project Goals

The platform is being built to simulate the backend architecture and business workflows of a real logistics company.

### Primary Goals

- Build a secure Java backend using modern Spring Boot practices.
- Implement a complete shipment lifecycle.
- Keep pricing logic under server control.
- Prevent unauthorized shipment manipulation.
- Implement role-based operational access.
- Maintain shipment tracking history.
- Introduce controlled delivery-agent workflows.
- Design the system so future modules can be added without rewriting the core application.
- Keep the architecture suitable for eventual production hardening.

---

# 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| ☕ **Java 21** | Backend development |
| 🌱 **Spring Boot** | Application framework |
| 🔐 **Spring Security** | Authentication and authorization |
| 🎟️ **JWT** | Access and refresh token authentication |
| 🔑 **OAuth 2.0** | Google authentication |
| 🍃 **MongoDB** | Primary database |
| 📡 **REST API** | Client-server communication |
| 📦 **Maven** | Build and dependency management |
| 🧪 **Postman** | Manual API testing |
| 📝 **SLF4J** | Application logging |
| 🌿 **Git** | Version control |
| 🐙 **GitHub** | Source-code hosting |

---

# 📊 Project Status

| Area | Status |
|---|---|
| 🔐 Authentication | ✅ Completed |
| 🛡️ Authorization | ✅ Completed |
| 👤 User Management Foundation | ✅ Completed |
| 📦 Shipment CRUD | ✅ Completed |
| 💰 Server-Side Pricing | ✅ Completed |
| 🧮 Price Estimation | ✅ Completed |
| 📍 Tracking History | ✅ Completed |
| 🔄 Status Transition Engine | ✅ Completed |
| 👨‍💼 Admin Shipment Assignment | ✅ Completed |
| 🚚 Assigned Shipment Retrieval | ✅ Completed |
| 🧪 Manual API Testing | ✅ Completed |
| 🚛 Delivery Agent Operational Workflow | 🔄 In Progress |
| 🏢 Hub Management | ⏱️ Planned |
| 💳 Payments | ⏱️ Planned |
| 🔔 Notifications | ⏱️ Planned |
| 📄 Invoices & Ratings | ⏱️ Planned |
| 📊 Reports & Audit Logging | ⏱️ Planned |
| 🧪 Automated Testing | ⏱️ Planned |
| 📚 Swagger / OpenAPI | ⏱️ Planned |
| 🐳 Dockerization | ⏱️ Planned |
| 🚀 Production Deployment | ⏱️ Planned |
| 📈 Monitoring & Observability | ⏱️ Planned |

### Status Legend

- ✅ **Completed** — Implemented and tested
- 🔄 **In Progress** — Currently being developed
- ⏱️ **Planned** — Scheduled for a future development phase

---

# ✨ Key Features

## 🔐 Authentication & Authorization

### ✅ Completed

- ✅ User registration
- ✅ User login
- ✅ Login using username or email
- ✅ BCrypt password hashing
- ✅ JWT access tokens
- ✅ JWT refresh tokens
- ✅ JWT authentication filter
- ✅ Role-based authorization
- ✅ Account enable/disable support
- ✅ Authentication-provider tracking
- ✅ Google OAuth 2.0 authentication
- ✅ Protected role-specific APIs
- ✅ Current authenticated-user resolution

### Supported Roles

- 👤 `CUSTOMER`
- 🚚 `DELIVERY_AGENT`
- 🏢 `HUB_OPERATOR`
- 🛡️ `ADMIN`

### Authentication Providers

- 🔑 `LOCAL`
- 🌐 `GOOGLE`

---

# 👤 User Management

The platform maintains user accounts with role and authentication-provider information.

### User Structure

```text
User
├── id
├── username
├── email
├── password
├── role
├── authProvider
├── providerId
├── enabled
├── createdAt
└── updatedAt
```

### Completed

- ✅ Customer registration
- ✅ Customer login
- ✅ Google login
- ✅ JWT authentication
- ✅ Delivery-agent authentication
- ✅ Admin authentication
- ✅ Role-based API protection
- ✅ Authentication-provider tracking

### Planned

- ⏱️ Admin user-management APIs
- ⏱️ User activation/deactivation APIs
- ⏱️ Profile management
- ⏱️ Password-change functionality
- ⏱️ Account recovery
- ⏱️ Delivery-agent management

---

# 📦 Shipment Management

Shipment management is one of the core implemented modules.

Customers can create shipments containing sender and receiver information, package information, delivery priority, distance, and COD selection.

### Shipment Capabilities

- ✅ Sender address
- ✅ Receiver address
- ✅ Sender details
- ✅ Receiver details
- ✅ Package weight
- ✅ Package dimensions
- ✅ Package description
- ✅ Delivery priority
- ✅ Distance
- ✅ COD selection
- ✅ Unique tracking-number generation
- ✅ Shipment creation
- ✅ Shipment retrieval
- ✅ Customer shipment retrieval
- ✅ Shipment update
- ✅ Shipment cancellation

### Shipment Structure

```text
Shipment
├── id
├── trackingNumber
├── customerId
├── senderAddress
├── receiverAddress
├── packageDetails
├── priority
├── cost
├── status
├── trackingHistory
├── assignedDeliveryAgentId
├── createdAt
└── updatedAt
```

### Example Tracking Number

```text
TRK-196B639CBBC1
```

---

# 💰 Server-Side Pricing Engine

The platform does not allow customers to submit their own final shipment price.

Instead, the final price is calculated by the backend using an active pricing configuration.

This ensures that clients cannot manipulate the final shipment cost by modifying the price in an API request.

## Pricing Architecture

```text
PricingConfig
      │
      ▼
PricingConfigRepository
      │
      ▼
PricingService
      │
      ▼
DefaultPricingService
      │
      ▼
Calculated Shipment Price
```

## Pricing Formula

```text
Base Charge
     +
Weight × Per-KG Rate
     +
Distance × Per-KM Rate
     ↓
Subtotal
     ×
Priority Multiplier
     ↓
Shipping Cost
     +
COD Handling Fee
     ↓
Final Price
```

## Priority Multipliers

| Priority | Multiplier |
|---|---:|
| `STANDARD` | 1.0× |
| `EXPRESS` | 1.5× |
| `URGENT` | 2.0× |

## Example Pricing Configuration

```text
Base Charge = ₹50
Per KG Rate = ₹20
Per KM Rate = ₹2

STANDARD = 1.0×
EXPRESS  = 1.5×
URGENT   = 2.0×

COD Fee = ₹30
```

## Example Calculation

```text
Weight   = 2.5 KG
Distance = 100 KM
Priority = STANDARD
COD      = No

₹50 + (2.5 × ₹20) + (100 × ₹2)

= ₹300
```

### Business Rule

The customer does not control the final shipping price.

The server calculates the final price using the active pricing configuration.

---

# ⚙️ Admin Pricing Configuration

Administrators can configure the active pricing rules used by the pricing engine.

### ✅ Completed APIs

| Method | Endpoint | Access |
|---|---|---|
| `POST` | `/api/admin/pricing` | `ADMIN` |
| `GET` | `/api/admin/pricing/active` | `ADMIN` |

The active pricing configuration is used by the backend for new price calculations.

---

# 🧮 Price Estimation

Customers can estimate the shipping price before creating a shipment.

### API

```http
POST /api/shipments/estimate
```

### Request

```json
{
  "weight": 2.5,
  "distanceKm": 100,
  "priority": "STANDARD",
  "cod": false
}
```

### Response

```json
{
  "estimatedPrice": 300
}
```

The same centralized `PricingService` is used during shipment creation so that pricing logic remains consistent across the application.

---

# 🔄 Shipment Lifecycle

The platform uses a centralized shipment status-transition engine.

## Main Lifecycle

```text
CREATED
   ↓
CONFIRMED
   ↓
PICKED_UP
   ↓
IN_TRANSIT
   ↓
OUT_FOR_DELIVERY
   ↓
DELIVERED
```

## Exceptional States

```text
CANCELLED
FAILED_DELIVERY
RETURNED
```

---

# 🧠 Shipment Status Transition Engine

A centralized service validates whether a shipment is allowed to move from one status to another.

## Valid Transitions

```text
CREATED
 ├──→ CONFIRMED
 └──→ CANCELLED

CONFIRMED
 └──→ PICKED_UP

PICKED_UP
 └──→ IN_TRANSIT

IN_TRANSIT
 └──→ OUT_FOR_DELIVERY

OUT_FOR_DELIVERY
 ├──→ DELIVERED
 └──→ FAILED_DELIVERY

FAILED_DELIVERY
 ├──→ OUT_FOR_DELIVERY
 └──→ RETURNED
```

## Terminal States

The following states cannot transition into another shipment state:

```text
DELIVERED
CANCELLED
RETURNED
```

### Completed

- ✅ Centralized transition validation
- ✅ Invalid-transition rejection
- ✅ Terminal-state protection
- ✅ Tracking-event creation for status changes
- ✅ Status-update API

### Status Update API

```http
PATCH /api/shipments/{shipmentId}/status
```

### Example Request

```json
{
  "status": "CONFIRMED"
}
```

Invalid transitions are rejected with a controlled `400 Bad Request` response.

---

# 📍 Shipment Tracking

The platform maintains tracking history instead of storing only the latest shipment status.

Each tracking event can contain:

- 📌 Status
- 🕒 Timestamp
- 📍 Location
- 📝 Description
- 👤 Performed By
- 📄 Notes

## Example Tracking History

```text
TRK-196B639CBBC1

✓ CREATED
  Shipment created

✓ CONFIRMED
  Shipment confirmed

✓ PICKED_UP
  Shipment picked up

✓ IN_TRANSIT
  Shipment in transit

✓ OUT_FOR_DELIVERY
  Shipment out for delivery

✓ DELIVERED
  Shipment delivered
```

### Tracking API

```http
GET /api/shipments/tracking/{trackingNumber}/history
```

This tracking-history model provides the foundation for future real-time shipment visibility.

---

# 🔎 Shipment Retrieval

### ✅ Implemented APIs

| Method | Endpoint | Purpose |
|---|---|---|
| `GET` | `/api/shipments/{id}` | Get shipment by ID |
| `GET` | `/api/shipments/tracking/{trackingNumber}` | Get shipment by tracking number |
| `GET` | `/api/shipments/tracking/{trackingNumber}/history` | Get tracking history |
| `GET` | `/api/shipments/my` | Get customer's shipments |

---

# ✏️ Shipment Updates

Customers can update shipment information during the permitted early stage of the shipment lifecycle.

### Supported Information

- ✅ Sender address
- ✅ Receiver address
- ✅ Package details
- ✅ Delivery priority

### Planned Improvements

- ⏱️ Stronger state-based update restrictions
- ⏱️ Automatic price re-estimation when price-affecting fields change
- ⏱️ Audit logging
- ⏱️ Field-level update rules

---

# ❌ Shipment Cancellation

Customers can cancel their own shipment only while it is in the `CREATED` state.

## Cancellation Flow

```text
Cancellation Request
        ↓
Find Shipment
        ↓
Verify Ownership
        ↓
Validate Status
        ↓
Set Status = CANCELLED
        ↓
Create Tracking Event
        ↓
Save Shipment
```

## Business Rules

- ✅ Customer ownership is verified
- ✅ Cancellation is restricted to the permitted state
- ✅ Shipment status becomes `CANCELLED`
- ✅ Tracking history is updated
- ✅ `CANCELLED` is treated as a terminal state

---

# 🚚 Delivery Agent Management

Delivery operations are currently being expanded.

## ✅ Delivery Agent Authentication

Delivery Agents authenticate through the existing JWT authentication system.

## ✅ View Assigned Shipments

```http
GET /api/delivery/shipments
```

The API automatically identifies the authenticated Delivery Agent and returns only shipments assigned to that agent.

The Delivery Agent does not provide their own user ID in the request.

---

# 👨‍💼 Admin Shipment Assignment

Administrators can assign shipments to Delivery Agents.

### API

```http
POST /api/admin/shipments/{shipmentId}/assign
```

### Example Request

```json
{
  "deliveryAgentId": "delivery-agent-user-id"
}
```

## Assignment Validation

The system validates:

- ✅ Shipment exists
- ✅ Delivery Agent exists
- ✅ Selected user has the `DELIVERY_AGENT` role
- ✅ Shipment is not already assigned
- ✅ Shipment is in an assignable state
- ✅ Assignment is performed by an authorized Admin

## Assignment Flow

```text
ADMIN
  │
  ▼
Select Shipment
  │
  ▼
Select Delivery Agent
  │
  ▼
Validate Assignment
  │
  ▼
assignedDeliveryAgentId
  │
  ▼
DELIVERY_AGENT
  │
  ▼
GET /api/delivery/shipments
```

---

# 🚛 Delivery Agent Workflow

## ✅ Currently Implemented

```text
Delivery Agent Login
        ↓
Admin Assignment
        ↓
View Assigned Shipments
```

## 🔄 Currently In Progress

```text
Assigned
   ↓
Accept / Reject
   ↓
Pickup
   ↓
In Transit
   ↓
Out For Delivery
   ↓
Delivery Confirmation
   ↓
Delivered
```

## 🔄 Delivery Features in Progress

- 🔄 Accept assignment
- 🔄 Reject assignment
- 🔄 Pickup confirmation
- 🔄 Delivery-progress updates
- 🔄 Delivery notes
- 🔄 Failed-delivery workflow
- 🔄 Delivery proof
- 🔄 OTP verification
- 🔄 Signature/photo proof
- 🔄 COD collection

---

# 🏢 Hub Management

Hub operations are planned as the next major logistics module.

## ⏱️ Planned Capabilities

- ⏱️ Hub CRUD
- ⏱️ Hub Operator role operations
- ⏱️ Shipment arrival scanning
- ⏱️ Shipment outbound scanning
- ⏱️ Shipment routing
- ⏱️ Local delivery assignment
- ⏱️ Hub inventory
- ⏱️ Hub-based shipment visibility

## Planned Hub Workflow

```text
Origin
  ↓
Origin Hub
  ↓
Intermediate Hub
  ↓
Destination Hub
  ↓
Delivery Agent
  ↓
Customer
```

---

# 💳 Payments & COD

The platform is designed to support both Cash on Delivery and online payments.

## ⏱️ Planned COD Lifecycle

```text
COD_PENDING
     ↓
COD_COLLECTED
     ↓
SETTLED
```

## ⏱️ Planned Online Payment Lifecycle

```text
PENDING
   ↓
PAID
   ↓
REFUNDED
```

## Failed Payment Flow

```text
PENDING
   ↓
FAILED
```

A `PaymentGateway` abstraction is planned so that a real payment provider can be integrated later without tightly coupling business logic to a specific payment provider.

---

# 🔔 Notifications

Shipment notifications are planned as part of the platform's future communication layer.

## ⏱️ Planned Notifications

- ⏱️ Shipment Created
- ⏱️ Price Confirmed
- ⏱️ Shipment Picked Up
- ⏱️ Hub Arrival
- ⏱️ Out For Delivery
- ⏱️ Delivered
- ⏱️ Failed Delivery
- ⏱️ Returned
- ⏱️ Payment / COD Updates

## Planned Notification Channels

- ⏱️ Email notifications
- ⏱️ SMS notifications
- ⏱️ Push notifications

The initial notification implementation is expected to focus on email.

---

# 📄 Invoice & Rating

## ⏱️ Invoice

Customers will eventually be able to download shipment invoices or receipts.

### Planned Invoice Information

- ⏱️ Shipment details
- ⏱️ Tracking number
- ⏱️ Customer information
- ⏱️ Origin and destination
- ⏱️ Package details
- ⏱️ Priority
- ⏱️ Shipping cost
- ⏱️ COD/payment information
- ⏱️ Invoice date

## ⏱️ Delivery Rating

After successful delivery:

```text
1–5 Star Rating
       +
Optional Feedback
```

### Planned Rule

- ⏱️ One rating per shipment

---

# 🛡️ API Security

Role-based API protection is implemented using Spring Security.

## Authentication Flow

```text
Client
  │
  ▼
Login / OAuth
  │
  ▼
Authentication
  │
  ▼
JWT Access Token
  │
  ▼
Protected API
  │
  ▼
JWT Authentication Filter
  │
  ▼
Security Context
  │
  ▼
Role Authorization
  │
  ▼
Controller
```

## Role-Based Access

| Area | Role |
|---|---|
| Authentication | Public / Authenticated |
| Customer shipment operations | `CUSTOMER` |
| Delivery operations | `DELIVERY_AGENT` |
| Administrative operations | `ADMIN` |
| Future hub operations | `HUB_OPERATOR` |

JWT authentication is applied to protected APIs.

Ownership-sensitive operations additionally validate that the authenticated user is authorized to operate on the requested resource.

---

# 🧪 Validation & Error Handling

The platform uses request DTO validation to protect API contracts and reject invalid input.

## Validation Areas

- ✅ Required fields
- ✅ Indian phone-number validation
- ✅ Indian PIN-code validation
- ✅ Positive package dimensions
- ✅ Positive package weight
- ✅ Valid shipment priority
- ✅ Valid distance
- ✅ Required shipment status
- ✅ Request DTO validation
- ✅ Centralized exception handling

## Example Validation Response

```json
{
  "message": "Validation Failed",
  "validationErrors": {
    "postalCode": "Invalid postal code"
  }
}
```

Validation errors are returned through the centralized exception-handling mechanism.

---

# 🧪 Testing

Manual API testing is currently performed using Postman throughout development.

## ✅ Tested

- ✅ Customer registration
- ✅ Customer login
- ✅ Admin login
- ✅ Delivery Agent login
- ✅ JWT authentication
- ✅ Role-based authorization
- ✅ Shipment creation
- ✅ Shipment retrieval
- ✅ Shipment update
- ✅ Shipment cancellation
- ✅ Price estimation
- ✅ Admin pricing configuration
- ✅ Tracking history
- ✅ Valid shipment status transitions
- ✅ Invalid shipment status transitions
- ✅ Admin → Delivery Agent assignment
- ✅ Delivery Agent → assigned shipment retrieval

## 🔄 Testing in Progress

- 🔄 Delivery Agent accept/reject workflow
- 🔄 Pickup workflow
- 🔄 Delivery status progression
- 🔄 Delivery confirmation
- 🔄 Failed-delivery workflow

## ⏱️ Future Testing

- ⏱️ Automated unit tests
- ⏱️ Service-layer tests
- ⏱️ Controller tests
- ⏱️ Repository tests
- ⏱️ Integration tests
- ⏱️ Security tests
- ⏱️ End-to-end workflow tests

---

# 📡 API Overview

## 🔐 Authentication APIs

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/auth/register` | Register a local user |
| `POST` | `/auth/login` | Authenticate using username/email and password |

## 📦 Customer Shipment APIs

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/shipments` | Create shipment |
| `POST` | `/api/shipments/estimate` | Estimate shipment price |
| `GET` | `/api/shipments/{id}` | Get shipment by ID |
| `GET` | `/api/shipments/my` | Get customer's shipments |
| `GET` | `/api/shipments/tracking/{trackingNumber}` | Get shipment by tracking number |
| `GET` | `/api/shipments/tracking/{trackingNumber}/history` | Get tracking history |
| `PUT` | `/api/shipments/{id}` | Update shipment |
| `PATCH` | `/api/shipments/{id}/cancel` | Cancel shipment |
| `PATCH` | `/api/shipments/{shipmentId}/status` | Update shipment status |

## 🛡️ Admin APIs

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/admin/pricing` | Create/update pricing configuration |
| `GET` | `/api/admin/pricing/active` | Get active pricing configuration |
| `POST` | `/api/admin/shipments/{shipmentId}/assign` | Assign shipment to Delivery Agent |

## 🚚 Delivery Agent APIs

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/delivery/shipments` | Retrieve shipments assigned to authenticated Delivery Agent |

Additional Delivery Agent APIs will be added as the operational workflow is implemented.

---

# 🧪 Example End-to-End Assignment Test

The currently implemented assignment flow can be represented as:

```text
Customer creates shipment
        ↓
Shipment = CREATED
        ↓
Admin assigns Delivery Agent
        ↓
assignedDeliveryAgentId saved
        ↓
Delivery Agent authenticates
        ↓
GET /api/delivery/shipments
        ↓
Assigned shipment returned
```

This verifies the relationship between shipment ownership, administrative assignment, authentication, and Delivery Agent-specific retrieval.

---

# 📊 Development Status

## 🟢 Completed Features

### 🔐 Authentication & Security

- ✅ Spring Boot project setup
- ✅ Maven configuration
- ✅ Java 21
- ✅ MongoDB configuration
- ✅ User entity
- ✅ User repository
- ✅ Local registration
- ✅ Local login
- ✅ Username/email login
- ✅ BCrypt password hashing
- ✅ JWT access token
- ✅ JWT refresh token
- ✅ JWT authentication filter
- ✅ Role-based authorization
- ✅ Customer role
- ✅ Admin role
- ✅ Delivery Agent role
- ✅ Hub Operator role foundation
- ✅ Google OAuth 2.0

### 📦 Shipment Management

- ✅ Shipment entity
- ✅ Shipment repository
- ✅ Shipment DTOs
- ✅ Address validation
- ✅ Package validation
- ✅ Shipment creation
- ✅ Tracking-number generation
- ✅ Shipment retrieval
- ✅ Customer shipment retrieval
- ✅ Shipment update
- ✅ Shipment cancellation

### 💰 Pricing

- ✅ Pricing configuration
- ✅ Admin pricing API
- ✅ Price-estimation API
- ✅ Server-side shipment pricing
- ✅ Priority-based pricing
- ✅ COD pricing foundation

### 📍 Tracking & Workflow

- ✅ Tracking history
- ✅ Tracking-event creation
- ✅ Shipment status-transition engine
- ✅ Invalid-transition validation
- ✅ Terminal-state protection
- ✅ Delivery Agent authentication
- ✅ Delivery Agent assigned-shipment retrieval
- ✅ Admin shipment assignment
- ✅ Assignment validation

### 🧪 Testing

- ✅ Postman API testing
- ✅ Authentication testing
- ✅ Authorization testing
- ✅ Shipment workflow testing
- ✅ Pricing testing
- ✅ Tracking testing
- ✅ Assignment testing

---

# 🔄 Current Development

The current development focus is the operational Delivery Agent workflow.

### 🔄 In Progress

- 🔄 Delivery Agent accept/reject
- 🔄 Pickup workflow
- 🔄 In-transit workflow
- 🔄 Out-for-delivery workflow
- 🔄 Delivery confirmation
- 🔄 Failed-delivery workflow
- 🔄 Delivery proof
- 🔄 OTP verification
- 🔄 COD collection

The goal is to connect the already implemented assignment layer with the complete physical delivery lifecycle.

---

# ⏱️ Planned Modules

## 🏢 Hub Operations

- ⏱️ Hub management
- ⏱️ Hub Operator operations
- ⏱️ Shipment hub routing
- ⏱️ Hub scan-in
- ⏱️ Hub scan-out
- ⏱️ Hub inventory
- ⏱️ Hub-based shipment visibility

## 🔎 Shipment Operations

- ⏱️ Shipment pagination
- ⏱️ Shipment search
- ⏱️ Shipment filtering
- ⏱️ Advanced tracking
- ⏱️ Improved shipment update restrictions

## 💳 Payments

- ⏱️ COD settlement
- ⏱️ Online payment gateway
- ⏱️ Payment abstraction
- ⏱️ Payment status management
- ⏱️ Refund workflow

## 🔔 Notifications

- ⏱️ Email notifications
- ⏱️ SMS notifications
- ⏱️ Push notifications
- ⏱️ Shipment event notifications

## 📄 Business Features

- ⏱️ Invoice generation
- ⏱️ PDF receipts
- ⏱️ Delivery ratings
- ⏱️ Customer feedback
- ⏱️ Admin reports
- ⏱️ Audit logging

## 🤖 Automation & Intelligence

- ⏱️ Automatic Delivery Agent assignment
- ⏱️ Maps/geocoding integration
- ⏱️ Distance calculation
- ⏱️ ETA calculation
- ⏱️ Scheduled background jobs

## 🚀 Production Hardening

- ⏱️ Swagger / OpenAPI
- ⏱️ Automated testing
- ⏱️ Dockerization
- ⏱️ Production deployment
- ⏱️ Monitoring
- ⏱️ Observability
- ⏱️ Performance optimization

---

# 🗺️ Development Roadmap

## Phase 1 — Foundation

```text
Java 21
Spring Boot
Maven
MongoDB
JWT
Google OAuth 2.0
Spring Security
Layered Architecture
```

**Status: ✅ COMPLETED**

---

## Phase 2 — Shipment Management

```text
Shipment CRUD
Validation
Tracking Number
Pricing
Price Estimation
Cancellation
Tracking History
```

**Status: ✅ COMPLETED**

---

## Phase 3 — Shipment Workflow

```text
Status Transition Engine
Tracking Events
Delivery Agent Authentication
Admin Assignment
Assigned Shipments
Assignment Validation
```

**Status: ✅ COMPLETED**

---

## Phase 4 — Delivery Operations

```text
Accept / Reject
Pickup
In Transit
Out For Delivery
Delivery Confirmation
Failed Delivery
Delivery Proof
OTP
COD Collection
```

**Status: 🔄 IN PROGRESS**

---

## Phase 5 — Hub Operations

```text
Hub Management
Hub Operators
Shipment Routing
Scan-In / Scan-Out
Hub Inventory
```

**Status: ⏱️ PLANNED**

---

## Phase 6 — Platform Features

```text
Payments
Notifications
Invoices
Ratings
Reports
Audit Logs
```

**Status: ⏱️ PLANNED**

---

## Phase 7 — Production Hardening

```text
Pagination
Search
Filtering
Swagger / OpenAPI
Automated Tests
Docker
Deployment
Monitoring
Observability
```

**Status: ⏱️ PLANNED**

---

# 🧱 Production-Oriented Engineering

The project is being developed beyond basic CRUD implementation.

## Engineering Principles

- ✅ Layered architecture
- ✅ DTO-based API contracts
- ✅ Mapper-based entity conversion
- ✅ Centralized business logic
- ✅ Role-based authorization
- ✅ JWT security
- ✅ Server-side pricing
- ✅ State-transition validation
- ✅ Ownership validation
- ✅ Input validation
- ✅ Centralized exception handling

## ⏱️ Production Hardening Goals

- ⏱️ Structured logging
- ⏱️ MongoDB indexing
- ⏱️ Pagination
- ⏱️ Search and filtering
- ⏱️ Automated testing
- ⏱️ API documentation
- ⏱️ Environment-based configuration
- ⏱️ Secure secret management
- ⏱️ Docker support
- ⏱️ Deployment readiness
- ⏱️ Monitoring and observability

---

# 🏗️ Architecture

The current application follows a layered architecture.

```text
                         ┌─────────────────────┐
                         │      REST API       │
                         └──────────┬──────────┘
                                    │
                                    ▼
                         ┌─────────────────────┐
                         │    Controllers      │
                         └──────────┬──────────┘
                                    │
                                    ▼
                         ┌─────────────────────┐
                         │      Services       │
                         │                     │
                         │ Business Logic      │
                         │ Pricing             │
                         │ Shipment Workflow   │
                         │ Authentication      │
                         └──────────┬──────────┘
                                    │
                  ┌─────────────────┼─────────────────┐
                  ▼                 ▼                 ▼
           ┌────────────┐    ┌────────────┐    ┌────────────┐
           │ Repository │    │   Mapper   │    │  Security  │
           └─────┬──────┘    └────────────┘    └────────────┘
                 │
                 ▼
           ┌────────────┐
           │  MongoDB   │
           └────────────┘
```

## Layer Responsibilities

### 🎮 Controller Layer

Responsible for:

- HTTP endpoints
- Request mapping
- Request validation
- Authentication-context access
- Response generation

### ⚙️ Service Layer

Responsible for:

- Business rules
- Pricing calculations
- Shipment workflow
- Status-transition validation
- Ownership checks
- Assignment validation
- Authentication-related business logic

### 🗄️ Repository Layer

Responsible for:

- Database access
- User queries
- Shipment queries
- Pricing-configuration queries

### 📦 DTO Layer

Responsible for:

- API request contracts
- API response contracts
- Input validation
- Separation between persistence entities and API models

### 🔐 Security Layer

Responsible for:

- JWT authentication
- Authentication filters
- Role-based authorization
- OAuth 2.0 integration
- Current-user resolution

---

# 📁 Project Structure

The application follows a conventional Spring Boot layered structure.

```text
src/
└── main/
    ├── java/
    │   └── com/
    │       └── lovish/
    │           └── logistic/
    │               └── platform/
    │                   ├── controller/
    │                   ├── service/
    │                   ├── repository/
    │                   ├── dto/
    │                   ├── entity/
    │                   ├── mapper/
    │                   ├── security/
    │                   ├── exception/
    │                   └── configuration/
    │
    └── resources/
        └── application.properties
```

Package names and individual classes may evolve as the platform continues to grow.

---

# 👥 User Roles

The platform is designed around multiple operational roles.

| Role | Responsibilities |
|---|---|
| 👤 `CUSTOMER` | Create shipments, manage permitted shipment information and track deliveries |
| 🚚 `DELIVERY_AGENT` | Handle assigned shipments and perform delivery operations |
| 🏢 `HUB_OPERATOR` | Manage hub operations and shipment movement |
| 🛡️ `ADMIN` | Manage pricing, assignments, users and operational configuration |

---

# 🔐 Authentication Architecture

## Local Authentication

```text
Registration
     ↓
Validate Request
     ↓
Hash Password
     ↓
Save User
     ↓
Login
     ↓
Verify Credentials
     ↓
Generate JWT Access + Refresh Tokens
```

## Google OAuth 2.0

```text
Client
  ↓
Google Login
  ↓
Google Authorization
  ↓
OAuth Callback
  ↓
Find / Create User
  ↓
Assign Authentication Provider
  ↓
Authenticated Application Session
```

The application tracks the authentication provider associated with each account.

---

# 🔑 JWT Authentication

Protected requests use JWT-based authentication.

```text
Client
  │
  │ Authorization: Bearer <access-token>
  ▼
JWT Authentication Filter
  │
  ▼
Validate Token
  │
  ▼
Extract User Identity
  │
  ▼
Load User
  │
  ▼
Set Security Context
  │
  ▼
Controller
```

The platform uses:

- 🔑 Access tokens
- 🔄 Refresh tokens
- 🛡️ JWT authentication filtering
- 👥 Role-based authorization

---

# 💰 Pricing Architecture

Pricing is deliberately controlled by the backend.

```text
                  ADMIN
                    │
                    ▼
          Pricing Configuration
                    │
                    ▼
          PricingConfigRepository
                    │
                    ▼
              PricingService
                    │
          ┌─────────┴─────────┐
          ▼                   ▼
     Price Estimate       Shipment Creation
          │                   │
          └─────────┬─────────┘
                    ▼
              Final Price
```

This keeps pricing logic centralized and prevents clients from directly controlling the final shipping cost.

---

# 🔄 Shipment Workflow Architecture

```text
             Shipment Created
                    │
                    ▼
                CREATED
               /       \
              /         \
             ▼           ▼
       CONFIRMED      CANCELLED
             │
             ▼
         PICKED_UP
             │
             ▼
         IN_TRANSIT
             │
             ▼
      OUT_FOR_DELIVERY
          /       \
         /         \
        ▼           ▼
   DELIVERED   FAILED_DELIVERY
                    /      \
                   /        \
                  ▼          ▼
          OUT_FOR_DELIVERY  RETURNED
```

The transition engine is responsible for enforcing valid movement between states.

---

# 📍 Tracking Architecture

Tracking history is maintained alongside the shipment's current state.

```text
Shipment
   │
   ├── Current Status
   │
   └── Tracking History
           │
           ├── Event 1
           ├── Event 2
           ├── Event 3
           ├── Event 4
           └── Event N
```

This allows the platform to preserve the shipment's operational history rather than overwriting previous states.

---

# 🚚 Delivery Assignment Architecture

```text
                    ADMIN
                      │
                      ▼
              Select Shipment
                      │
                      ▼
          Select Delivery Agent
                      │
                      ▼
            Validate Assignment
                      │
                      ▼
       assignedDeliveryAgentId
                      │
                      ▼
              Assigned Shipment
                      │
                      ▼
              DELIVERY_AGENT
                      │
                      ▼
         GET /api/delivery/shipments
```

The authenticated Delivery Agent can retrieve only shipments assigned to that account.

---

# 🧩 Modular Monolith Design

The application is intentionally kept as a modular monolith for the current development stage.

```text
                 ┌─────────────────────────────┐
                 │     Logistics Platform      │
                 │                             │
                 │  ┌───────────────────────┐  │
                 │  │ Authentication Module │  │
                 │  └───────────────────────┘  │
                 │                             │
                 │  ┌───────────────────────┐  │
                 │  │ Shipment Module       │  │
                 │  └───────────────────────┘  │
                 │                             │
                 │  ┌───────────────────────┐  │
                 │  │ Pricing Module         │  │
                 │  └───────────────────────┘  │
                 │                             │
                 │  ┌───────────────────────┐  │
                 │  │ Tracking Module        │  │
                 │  └───────────────────────┘  │
                 │                             │
                 │  ┌───────────────────────┐  │
                 │  │ Delivery Module        │  │
                 │  └───────────────────────┘  │
                 │                             │
                 │  ┌───────────────────────┐  │
                 │  │ Hub Module             │  │
                 │  └───────────────────────┘  │
                 │                             │
                 │  ┌───────────────────────┐  │
                 │  │ Payment Module         │  │
                 │  └───────────────────────┘  │
                 └─────────────────────────────┘
```

Future modules can be introduced without immediately splitting the application into multiple distributed services.

---

# ⚙️ Local Setup

## Prerequisites

Install the following tools:

- ☕ Java 21
- 📦 Maven
- 🍃 MongoDB
- 🌿 Git
- 🧪 Postman
- 🛠️ Spring Tool Suite / IntelliJ IDEA / Eclipse

## 1. Clone the Repository

```bash
git clone https://github.com/iLovishSaluja/logistics-platform.git
cd logistics-platform
```

## 2. Configure MongoDB

Make sure MongoDB is running locally or provide a MongoDB connection string through environment configuration.

Example:

```properties
spring.data.mongodb.uri=${MONGODB_URI}
```

## 3. Configure Google OAuth 2.0

Configure the Google OAuth client credentials through environment variables.

```properties
spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}
spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}
```

Do not commit real OAuth credentials to GitHub.

## 4. Configure JWT Secret

Use an environment variable for the JWT secret.

```properties
jwt.secret=${JWT_SECRET}
```

Never commit real production secrets to source control.

---

# 🏗️ Build the Project

The project includes the Maven Wrapper.

## macOS / Linux

```bash
./mvnw clean install
```

## Windows

```bat
mvnw.cmd clean install
```

---

# ▶️ Run the Application

## macOS / Linux

```bash
./mvnw spring-boot:run
```

## Windows

```bat
mvnw.cmd spring-boot:run
```

The application runs on:

```text
http://localhost:8081
```

---

# ⚙️ Configuration

Current development server port:

```properties
server.port=8081
```

Environment-specific configuration should remain outside the source code wherever possible.

## Recommended Environment Variables

```text
MONGODB_URI
GOOGLE_CLIENT_ID
GOOGLE_CLIENT_SECRET
JWT_SECRET
```

---

# 🔒 Security Configuration Guidelines

Never commit:

- ❌ MongoDB production credentials
- ❌ Google OAuth client secrets
- ❌ JWT signing secrets
- ❌ Payment-provider secrets
- ❌ API keys
- ❌ Private credentials

Use environment variables or a secure secret-management system.

---

# 🧪 API Testing with Postman

The project is currently tested manually through Postman.

A typical authenticated workflow is:

```text
Register / Login
      ↓
Receive JWT Access Token
      ↓
Add Bearer Token
      ↓
Call Protected API
      ↓
Validate Response
```

For protected APIs, use:

```text
Authorization
Type: Bearer Token
Token: <JWT_ACCESS_TOKEN>
```

---

# 📡 Example API Workflow

## Customer Flow

```text
Register
   ↓
Login
   ↓
Receive JWT
   ↓
Estimate Price
   ↓
Create Shipment
   ↓
Receive Tracking Number
   ↓
View Shipment
   ↓
Track Shipment
   ↓
Update / Cancel if permitted
```

## Admin Flow

```text
Login
   ↓
Receive JWT
   ↓
Configure Pricing
   ↓
View Active Pricing
   ↓
Select Shipment
   ↓
Assign Delivery Agent
```

## Delivery Agent Flow

```text
Login
   ↓
Receive JWT
   ↓
View Assigned Shipments
   ↓
Accept Assignment
   ↓
Pickup
   ↓
In Transit
   ↓
Out For Delivery
   ↓
Delivery Confirmation
```

The Delivery Agent operational steps after assignment are currently under development.

---

# 📈 Future Architecture

The current application is intentionally implemented as a modular monolith.

As the platform grows, individual modules could eventually be separated into independent services if operational requirements justify the added distributed-system complexity.

## Potential Future Architecture

```text
                         ┌─────────────────┐
                         │   API Gateway   │
                         └────────┬────────┘
                                  │
              ┌───────────────────┼───────────────────┐
              │                   │                   │
              ▼                   ▼                   ▼
       ┌─────────────┐     ┌─────────────┐     ┌─────────────┐
       │   Auth      │     │  Shipment   │     │   Pricing   │
       │   Service   │     │   Service   │     │   Service   │
       └──────┬──────┘     └──────┬──────┘     └──────┬──────┘
              │                   │                   │
              └───────────────────┼───────────────────┘
                                  │
              ┌───────────────────┼───────────────────┐
              │                   │                   │
              ▼                   ▼                   ▼
       ┌─────────────┐     ┌─────────────┐     ┌─────────────┐
       │     Hub     │     │  Delivery   │     │   Payment   │
       │   Service   │     │   Service   │     │   Service   │
       └──────┬──────┘     └──────┬──────┘     └──────┬──────┘
              │                   │                   │
              └───────────────────┼───────────────────┘
                                  ▼
                         ┌─────────────────┐
                         │ Notification    │
                         │    Service      │
                         └─────────────────┘
```

For V1, these capabilities remain inside a single Spring Boot application.

This keeps the project easier to develop, test, debug, and evolve before introducing unnecessary distributed-system complexity.

---

# 📌 Current Project State

The project has progressed beyond basic authentication and CRUD.

## Current Implemented Flow

```text
Authentication
      ↓
Authorization
      ↓
User Management
      ↓
Shipment Management
      ↓
Server-Side Pricing
      ↓
Price Estimation
      ↓
Shipment Cancellation
      ↓
Tracking History
      ↓
Status Transition Engine
      ↓
Delivery Agent Assignment
      ↓
Assigned Shipment Retrieval
```

## Current Development Focus

```text
Assignment
    ↓
Accept / Reject
    ↓
Pickup
    ↓
In Transit
    ↓
Out For Delivery
    ↓
Delivery Proof
    ↓
Delivered
```

---

# 📋 Feature Matrix

| Feature | Status |
|---|---|
| User Registration | ✅ Completed |
| User Login | ✅ Completed |
| Username / Email Login | ✅ Completed |
| BCrypt Password Hashing | ✅ Completed |
| JWT Access Tokens | ✅ Completed |
| JWT Refresh Tokens | ✅ Completed |
| JWT Authentication Filter | ✅ Completed |
| Role-Based Authorization | ✅ Completed |
| Google OAuth 2.0 | ✅ Completed |
| Customer Role | ✅ Completed |
| Admin Role | ✅ Completed |
| Delivery Agent Role | ✅ Completed |
| Hub Operator Role Foundation | ✅ Completed |
| Shipment Creation | ✅ Completed |
| Shipment Retrieval | ✅ Completed |
| Shipment Update | ✅ Completed |
| Shipment Cancellation | ✅ Completed |
| Tracking Number Generation | ✅ Completed |
| Address Validation | ✅ Completed |
| Package Validation | ✅ Completed |
| Pricing Configuration | ✅ Completed |
| Server-Side Pricing | ✅ Completed |
| Price Estimation | ✅ Completed |
| Tracking History | ✅ Completed |
| Tracking Events | ✅ Completed |
| Status Transition Engine | ✅ Completed |
| Invalid Transition Validation | ✅ Completed |
| Admin Shipment Assignment | ✅ Completed |
| Assignment Validation | ✅ Completed |
| Delivery Agent Assigned Shipments | ✅ Completed |
| Postman API Testing | ✅ Completed |
| Delivery Agent Accept / Reject | 🔄 In Progress |
| Pickup Workflow | 🔄 In Progress |
| In-Transit Workflow | 🔄 In Progress |
| Out-for-Delivery Workflow | 🔄 In Progress |
| Delivery Confirmation | 🔄 In Progress |
| Failed Delivery Workflow | 🔄 In Progress |
| Delivery Proof / OTP | 🔄 In Progress |
| COD Collection | 🔄 In Progress |
| Hub Management | ⏱️ Planned |
| Hub Operator Operations | ⏱️ Planned |
| Shipment Hub Routing | ⏱️ Planned |
| Hub Scan-In / Scan-Out | ⏱️ Planned |
| Shipment Pagination | ⏱️ Planned |
| Search & Filtering | ⏱️ Planned |
| Swagger / OpenAPI | ⏱️ Planned |
| Automated Testing | ⏱️ Planned |
| COD Settlement | ⏱️ Planned |
| Online Payment Gateway | ⏱️ Planned |
| Payment Abstraction | ⏱️ Planned |
| Email Notifications | ⏱️ Planned |
| SMS / Push Notifications | ⏱️ Planned |
| Invoice / PDF Receipt | ⏱️ Planned |
| Delivery Rating | ⏱️ Planned |
| Admin Reports | ⏱️ Planned |
| Audit Logging | ⏱️ Planned |
| Automatic Assignment | ⏱️ Planned |
| Maps / Geocoding | ⏱️ Planned |
| Distance Calculation | ⏱️ Planned |
| ETA Calculation | ⏱️ Planned |
| Scheduled Background Jobs | ⏱️ Planned |
| Dockerization | ⏱️ Planned |
| Production Deployment | ⏱️ Planned |
| Monitoring & Observability | ⏱️ Planned |

---

# 🧩 Business Rules

The platform is designed around explicit backend business rules rather than allowing clients to directly control sensitive operations.

## 💰 Pricing

- ✅ Final shipment price is calculated server-side.
- ✅ Customers cannot directly control the final price.
- ✅ Active pricing configuration is maintained by Admin.
- ✅ Priority affects the calculated price.
- ✅ Distance and package weight participate in pricing.

## 📦 Shipment Ownership

- ✅ Customer operations are ownership-aware.
- ✅ Authenticated users are resolved from the security context.
- ✅ Sensitive shipment operations validate the requesting user's authority.

## 🔄 Status Transitions

- ✅ Status changes are validated centrally.
- ✅ Invalid transitions are rejected.
- ✅ Terminal states cannot transition further.
- ✅ Status changes can generate tracking events.

## 🚚 Assignment

- ✅ Only authorized Admin operations can assign shipments.
- ✅ Assigned users must have the `DELIVERY_AGENT` role.
- ✅ Existing assignments are validated.
- ✅ Delivery Agents retrieve their own assigned shipments.

---

# 📈 Future Production Enhancements

The following improvements are intentionally separated from the currently implemented core.

## ⏱️ Scalability

- ⏱️ Database indexing
- ⏱️ Pagination
- ⏱️ Query optimization
- ⏱️ Caching
- ⏱️ Background processing
- ⏱️ Asynchronous events

## ⏱️ Reliability

- ⏱️ Automated testing
- ⏱️ Integration testing
- ⏱️ Health checks
- ⏱️ Retry mechanisms
- ⏱️ Failure handling
- ⏱️ Transaction boundaries where appropriate

## ⏱️ Observability

- ⏱️ Structured logging
- ⏱️ Metrics
- ⏱️ Monitoring
- ⏱️ Distributed tracing if services are separated
- ⏱️ Operational dashboards

## ⏱️ Deployment

- ⏱️ Docker
- ⏱️ Container orchestration
- ⏱️ CI/CD
- ⏱️ Cloud deployment
- ⏱️ Environment-specific configuration
- ⏱️ Secure secret management

---

# 🔍 API Design Principles

The backend follows REST-oriented API design principles.

### Principles

- ✅ Resource-oriented endpoints
- ✅ HTTP methods aligned with operations
- ✅ DTO-based request contracts
- ✅ DTO-based response contracts
- ✅ Validation at the API boundary
- ✅ Centralized exception handling
- ✅ Authentication for protected resources
- ✅ Role-based authorization
- ✅ Ownership validation
- ✅ Business-rule validation in services

---

# 🛡️ Security Principles

Security is treated as a backend responsibility.

## Implemented

- ✅ Password hashing using BCrypt
- ✅ JWT authentication
- ✅ Refresh-token support
- ✅ Spring Security authorization
- ✅ Role-based API protection
- ✅ Authenticated-user resolution
- ✅ Ownership checks
- ✅ Server-side pricing

## ⏱️ Future Security Hardening

- ⏱️ Rate limiting
- ⏱️ Token rotation improvements
- ⏱️ Security headers
- ⏱️ Audit logging
- ⏱️ Brute-force protection
- ⏱️ Secret-management integration
- ⏱️ Automated security testing

---

# 🧪 Error Handling Strategy

The application uses centralized exception handling to keep API error responses consistent.

## Error Flow

```text
Invalid Request
      ↓
DTO Validation
      ↓
Exception
      ↓
Global Exception Handler
      ↓
Structured Error Response
```

## Example

```json
{
  "message": "Validation Failed",
  "validationErrors": {
    "postalCode": "Invalid postal code"
  }
}
```

This approach keeps controllers clean and provides clients with predictable error responses.

---

# 📝 Logging

Application logging is intended to use structured logging through SLF4J rather than direct console output.

## Logging Goals

- ⏱️ Request tracing
- ⏱️ Authentication events
- ⏱️ Shipment lifecycle events
- ⏱️ Assignment events
- ⏱️ Pricing events
- ⏱️ Exception logging
- ⏱️ Operational diagnostics

Sensitive information such as passwords, JWT secrets, OAuth client secrets, and other credentials should never be logged.

---

# 📊 Operational Visibility

Future operational dashboards can expose:

- ⏱️ Total shipments
- ⏱️ Active shipments
- ⏱️ Delivered shipments
- ⏱️ Failed deliveries
- ⏱️ Returned shipments
- ⏱️ Pending assignments
- ⏱️ Delivery-agent workload
- ⏱️ Hub workload
- ⏱️ Revenue / pricing metrics
- ⏱️ COD collection status
- ⏱️ Stuck shipments

---

# 🏢 Hub Operations — Future Design

The planned hub module will introduce physical logistics-center operations.

```text
Shipment
   ↓
Origin Hub
   ↓
Scan-In
   ↓
Processing
   ↓
Scan-Out
   ↓
Destination Hub
   ↓
Delivery Agent
```

Potential responsibilities include:

- ⏱️ Shipment receiving
- ⏱️ Shipment scanning
- ⏱️ Shipment routing
- ⏱️ Local assignment
- ⏱️ Inventory visibility
- ⏱️ Hub-level tracking

---

# 💳 Payment Abstraction — Future Design

Payment integration is planned around an abstraction rather than directly coupling the business layer to a specific provider.

```text
             PaymentService
                   │
        ┌──────────┴──────────┐
        ▼                     ▼
  Online Payment          COD Payment
        │                     │
        ▼                     ▼
 PaymentGateway          COD Collection
```

This allows the implementation to support a real payment provider later without rewriting the core shipment business logic.

---

# 🔔 Notification Architecture — Future Design

```text
Shipment Event
      │
      ▼
Notification Service
      │
      ├──────────────► Email
      │
      ├──────────────► SMS
      │
      └──────────────► Push
```

Potential events include:

- ⏱️ Shipment created
- ⏱️ Shipment confirmed
- ⏱️ Shipment picked up
- ⏱️ Hub arrival
- ⏱️ Out for delivery
- ⏱️ Delivered
- ⏱️ Failed delivery
- ⏱️ Returned
- ⏱️ Payment updates

---

# 🗂️ Data Model Overview

## User

```text
User
├── id
├── username
├── email
├── password
├── role
├── authProvider
├── providerId
├── enabled
├── createdAt
└── updatedAt
```

## Shipment

```text
Shipment
├── id
├── trackingNumber
├── customerId
├── senderAddress
├── receiverAddress
├── packageDetails
├── priority
├── distance
├── cost
├── status
├── trackingHistory
├── assignedDeliveryAgentId
├── createdAt
└── updatedAt
```

---

# 🧭 Shipment Ownership Model

```text
CUSTOMER
   │
   │ owns
   ▼
SHIPMENT
   │
   ├──────────────► TRACKING HISTORY
   │
   ├──────────────► PRICING
   │
   └──────────────► DELIVERY AGENT
```

The authenticated customer is used to determine ownership-sensitive operations instead of trusting arbitrary user identifiers supplied by the client.

---

# 🔄 Shipment State Machine

| Current State | Allowed Next State |
|---|---|
| `CREATED` | `CONFIRMED`, `CANCELLED` |
| `CONFIRMED` | `PICKED_UP` |
| `PICKED_UP` | `IN_TRANSIT` |
| `IN_TRANSIT` | `OUT_FOR_DELIVERY` |
| `OUT_FOR_DELIVERY` | `DELIVERED`, `FAILED_DELIVERY` |
| `FAILED_DELIVERY` | `OUT_FOR_DELIVERY`, `RETURNED` |
| `DELIVERED` | None |
| `CANCELLED` | None |
| `RETURNED` | None |

This state machine is enforced by the centralized shipment workflow logic.

---

# 📦 Shipment Lifecycle Example

```text
1. Customer creates shipment
             ↓
2. Backend validates request
             ↓
3. Pricing service calculates cost
             ↓
4. Tracking number generated
             ↓
5. Shipment stored as CREATED
             ↓
6. Admin confirms / assigns
             ↓
7. Delivery workflow begins
             ↓
8. Shipment progresses through valid states
             ↓
9. Tracking history records events
             ↓
10. Shipment reaches DELIVERED
```

---

# 🧪 Example Validation Rules

The API validates shipment-related information before processing.

## Address

- ✅ Required fields
- ✅ Valid Indian PIN code
- ✅ Valid phone-number format where applicable

## Package

- ✅ Weight must be positive
- ✅ Length must be positive
- ✅ Width must be positive
- ✅ Height must be positive

## Shipment

- ✅ Required priority
- ✅ Valid shipment status
- ✅ Valid distance
- ✅ Ownership checks
- ✅ Assignment checks

---

# 📚 Development Philosophy

The project follows a gradual development strategy.

```text
Foundation
    ↓
Authentication
    ↓
Authorization
    ↓
CRUD
    ↓
Business Rules
    ↓
Workflow
    ↓
Operational Modules
    ↓
Testing
    ↓
Production Hardening
```

The objective is to avoid prematurely introducing complex distributed infrastructure before the core business workflows are stable.

---

# 🧱 Why Modular Monolith First?

The current architecture intentionally keeps the system inside one Spring Boot application.

### Benefits During V1 Development

- ✅ Easier local development
- ✅ Easier debugging
- ✅ Simpler deployment
- ✅ Lower operational complexity
- ✅ Faster feature development
- ✅ Easier API testing
- ✅ Clear separation of modules inside one application

Microservices can be considered later if actual scalability or organizational requirements justify them.

---

# 📈 Scalability Direction

The architecture is designed so that modules can evolve independently over time.

### Potential Future Boundaries

```text
Authentication
      │
      ├── User Management
      │
      ├── Shipment Management
      │
      ├── Pricing
      │
      ├── Delivery
      │
      ├── Hub Operations
      │
      ├── Payments
      │
      └── Notifications
```

These boundaries provide a possible path toward service decomposition without requiring microservices during the early development stages.

---

# 🧰 Development Tools

The current development workflow uses:

- ☕ Java 21
- 🌱 Spring Boot
- 🛡️ Spring Security
- 🍃 MongoDB
- 📦 Maven
- 🧪 Postman
- 🛠️ Spring Tool Suite / IDE
- 🌿 Git
- 🐙 GitHub

---

# 🖥️ Development Environment

The application is currently configured for local development.

```text
Backend
   ↓
Spring Boot
   ↓
localhost:8081
   ↓
MongoDB
```

API testing is performed using Postman.

---

# 🔗 Repository

**GitHub Repository**

https://github.com/iLovishSaluja/logistics-platform

---

# 🤝 Contributing

This project is primarily being developed as a portfolio and learning project focused on production-oriented Java backend engineering.

Suggestions, improvements, architectural discussions, and bug reports are welcome.

## Contribution Guidelines

- Keep changes focused.
- Follow the existing layered architecture.
- Keep business logic inside services.
- Use DTOs for API contracts.
- Validate API input.
- Avoid exposing persistence entities unnecessarily.
- Do not commit secrets.
- Add tests as automated testing is introduced.
- Keep documentation updated with significant feature changes.

---

# 🔒 Security Notice

If you discover a security issue:

- Do not publish sensitive credentials.
- Do not commit secrets to the repository.
- Remove accidentally exposed credentials immediately.
- Rotate compromised credentials.
- Report security concerns responsibly.

---

# 📄 License

This project is currently unlicensed and intended for personal, educational, and portfolio purposes.

A formal open-source license such as MIT may be added in the future if the project is opened for broader contributions.

---

# 👤 Author

## Lovish Saluja

**Java Backend Developer**

### Technical Focus

- ☕ Java
- 🌱 Spring Boot
- 🔐 Spring Security
- 🎟️ JWT
- 🔑 OAuth 2.0
- 🍃 MongoDB
- 📡 REST APIs
- 📦 Maven
- 🧱 Backend Architecture
- 🧠 Data Structures & Algorithms
- 🚚 Logistics Platform

<p align="center">

Building a production-oriented logistics backend with **Java 21 & Spring Boot**.

</p>

<p align="center">

Authentication → Shipment Management → Pricing → Tracking → Delivery Operations → Hub Operations → Production Hardening

</p>

<p align="center">

⭐ If you find the project interesting, consider giving the repository a star!

</p>

---

## 📌 Project Status Summary

| Category | Status |
|---|---|
| 🔐 Authentication | ✅ Completed |
| 🛡️ Authorization | ✅ Completed |
| 📦 Shipment Management | ✅ Completed |
| 💰 Pricing Engine | ✅ Completed |
| 📍 Tracking | ✅ Completed |
| 🔄 Status Workflow | ✅ Completed |
| 🚚 Delivery Assignment | ✅ Completed |
| 🧪 Manual API Testing | ✅ Completed |
| 🚛 Delivery Operations | 🔄 In Progress |
| 🏢 Hub Operations | ⏱️ Planned |
| 💳 Payments | ⏱️ Planned |
| 🔔 Notifications | ⏱️ Planned |
| 📄 Invoices & Ratings | ⏱️ Planned |
| 📊 Reports & Auditing | ⏱️ Planned |
| 📚 API Documentation | ⏱️ Planned |
| 🧪 Automated Testing | ⏱️ Planned |
| 🐳 Docker | ⏱️ Planned |
| 🚀 Deployment | ⏱️ Planned |
| 📈 Monitoring | ⏱️ Planned |

---

<p align="center">

🚚 **Logistics Platform • Java 21 • Spring Boot • MongoDB • Maven**

</p>
