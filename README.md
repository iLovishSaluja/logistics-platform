# 🚚 Logistics Platform

### Production-Oriented Logistics & Shipment Management Backend

<p align="center">

A modular, production-oriented logistics and shipment management platform built with **Java 21**, **Spring Boot**, **Spring Security**, and **MongoDB**.

Designed around secure authentication, shipment lifecycle management, server-side pricing, tracking, controlled status transitions, hub-based shipment operations, delivery-agent workflows, OTP-verified delivery, failed-delivery handling, workload-balanced assignment, and a full Cash-on-Delivery (COD) collection and settlement workflow.

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
- [🏢 Hub Management](#-hub-management)
- [🏭 Hub-Based Shipment Operations](#-hub-based-shipment-operations)
- [🧑‍💼 Hub Operator Operations](#-hub-operator-operations)
- [🚚 Delivery Agent Management](#-delivery-agent-management)
- [🔄 Shipment Assignment & Reassignment](#-shipment-assignment--reassignment)
- [🤖 Automatic Assignment & Workload Balancing](#-automatic-assignment--workload-balancing)
- [👨‍💼 Admin Emergency Override](#-admin-emergency-override)
- [🧾 Assignment History](#-assignment-history)
- [🚛 Delivery Agent Workflow](#-delivery-agent-workflow)
- [🔐 OTP-Based Delivery Verification](#-otp-based-delivery-verification)
- [📈 Delivery Agent Performance Statistics](#-delivery-agent-performance-statistics)
- [🧪 Delivery Attempts & Failed Delivery](#-delivery-attempts--failed-delivery)
- [💳 Payments & COD](#-payments--cod)
- [💳 Online Payment (Razorpay)](#-online-payment-razorpay)
- [💰 Payment Data Model & Business Rules](#-payment-data-model--business-rules)
- [💵 COD Collection System](#-cod-collection-system)
- [🧾 Admin COD Settlement](#-admin-cod-settlement)
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
- [🔗 Repository](#-repository)
- [🤝 Contributing](#-contributing)
- [🔒 Security Notice](#-security-notice)
- [📄 License](#-license)
- [👤 Author](#-author)

---

# 📌 Project Overview

The **Logistics Platform** is a backend system designed to model the core operations of a modern logistics and shipment management company.

The application is intentionally implemented as a **modular monolith** using Spring Boot. It provides a foundation for customer shipment management, administrative operations, hub operations, delivery-agent workflows, pricing, tracking, authentication, and the financial COD workflow.

The project is being developed with a strong focus on **production-oriented backend engineering practices** rather than implementing only basic CRUD operations.

### Core Focus Areas

- 🔐 Secure authentication and authorization
- 📦 Shipment lifecycle management
- 💰 Server-side pricing
- 🧮 Price estimation
- 📍 Shipment tracking
- 🔄 Controlled shipment status transitions
- 🏢 Hub-based shipment operations (dispatch and receiving)
- 🚚 Delivery-agent assignment, reassignment, and workload balancing
- 🔐 OTP-based delivery verification
- 💵 COD collection and Admin settlement
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
- Keep pricing and payment amounts under server control.
- Prevent unauthorized shipment manipulation.
- Implement role-based operational access.
- Maintain shipment tracking history.
- Introduce hub-based operational ownership with dispatch and receiving.
- Support controlled, automatic, and emergency shipment assignment.
- Verify successful delivery through OTP.
- Handle failed-delivery scenarios through explicit business rules.
- Track COD money from agent collection through Admin settlement.
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
| 🏢 Hub Management | ✅ Completed |
| 🧑‍💼 Hub Staff-to-Hub Assignment | ✅ Completed |
| 🗺️ Automatic Origin/Destination Hub Mapping | ✅ Completed |
| 📤 Origin Hub Dispatch Workflow | ✅ Completed |
| 📥 Destination Hub Receiving Workflow | ✅ Completed |
| 🚚 Delivery Agent Assignment | ✅ Completed |
| 🔄 Assignment Status Management | ✅ Completed |
| 🤝 Delivery Agent Accept / Reject | ✅ Completed |
| 🔁 Reassignment / Retry | ✅ Completed |
| 🤖 Automatic Assignment (Workload Balancing) | ✅ Completed |
| 🚨 Emergency Admin Assignment Override | ✅ Completed |
| 🧾 Assignment History | ✅ Completed |
| 🧪 Delivery Attempt Tracking | ✅ Completed |
| ❌ Failed-Delivery Workflow | ✅ Completed |
| 🔢 Maximum 2 Delivery Attempts | ✅ Completed |
| 🏢 Pickup From Hub After Failed Attempts | ✅ Completed |
| 🚛 Delivery Agent Operational Workflow | ✅ Completed |
| 🔐 OTP-Based Delivery Verification | ✅ Completed |
| 📈 Delivery Agent Performance Statistics | ✅ Completed |
| 💰 Payment Data Model & Business Rules | ✅ Completed |
| 💵 COD Collection | ✅ Completed |
| 🧾 Admin COD Settlement | ✅ Completed |
| 🧪 End-to-End Integration Testing (Postman) | ✅ Completed |
| 💳 Online Payment Gateway Integration | ✅ Completed |
| 🔔 Notifications | ⏱️ Planned |
| 📄 Invoices & Ratings | ⏱️ Planned |
| 📊 Reports & Audit Logging | ⏱️ Planned |
| 🧪 Automated Tests | ⏱️ Planned |
| 📚 Swagger / OpenAPI | ⏱️ Planned |
| 🐳 Dockerization | ⏱️ Planned |
| 🚀 Production Deployment | ⏱️ Planned |
| 📈 Monitoring & Observability | ⏱️ Planned |

### Status Legend

- ✅ **Completed** — Implemented and manually integration-tested
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
- ✅ Method-level authorization using `@PreAuthorize`

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
├── hubId
├── createdAt
└── updatedAt
```

### Completed

- ✅ Customer registration
- ✅ Customer login
- ✅ Google login
- ✅ JWT authentication
- ✅ Delivery-agent authentication
- ✅ Hub Operator authentication
- ✅ Admin authentication
- ✅ Role-based API protection
- ✅ Authentication-provider tracking
- ✅ Hub membership for operational staff
- ✅ Delivery-agent performance statistics

### Planned

- ⏱️ Admin user-management APIs
- ⏱️ User activation/deactivation APIs
- ⏱️ Profile management
- ⏱️ Password-change functionality
- ⏱️ Account recovery

---

# 📦 Shipment Management

Shipment management is one of the core implemented modules.

Customers can create shipments containing sender and receiver information, package information, delivery priority, distance, shipment type, and payment method (online or COD).

The backend automatically resolves the shipment's origin and destination hubs from the sender and receiver cities using active hub records.

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
- ✅ Shipment type (`P2P`, `COMPANY_TO_PERSON`)
- ✅ Payment method (`ONLINE`, `COD`) and payer (`SENDER`, `RECEIVER`)
- ✅ COD order amount (stored separately from shipping cost)
- ✅ Unique tracking-number generation
- ✅ Shipment creation
- ✅ Shipment retrieval
- ✅ Customer shipment retrieval
- ✅ Shipment update
- ✅ Shipment cancellation
- ✅ Automatic origin hub assignment
- ✅ Automatic destination hub assignment
- ✅ Current hub tracking
- ✅ Destination hub tracking
- ✅ Delivery-agent assignment state
- ✅ Delivery attempt tracking
- ✅ Failed-delivery workflow
- ✅ Pickup-from-hub terminal workflow
- ✅ COD collection and settlement state

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
├── shipmentType
├── distance
├── cost
├── paymentMethod
├── paymentPayer
├── paymentStatus
├── codAmount
├── codCollectionStatus / collected details
├── codSettlementStatus / settlement details
├── status
├── trackingHistory
├── currentHubId
├── destinationHubId
├── assignedDeliveryAgentId
├── assignmentStatus
├── createdAt
└── updatedAt
```

### Example Tracking Number

```text
TRK-196B639CBBC1
```

### Hub Mapping Rule

During shipment creation:

```text
Sender City
    ↓
Active Origin Hub
    ↓
Shipment.currentHubId

Receiver City
    ↓
Active Destination Hub
    ↓
Shipment.destinationHubId
```

If an active hub cannot be found for either city, shipment creation is rejected instead of creating a shipment without the required hub relationship.

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
Shipping Cost (Final Price)
```

> **Note:** The current pricing model does **not** add a separate COD handling fee. The COD order amount is tracked independently from the shipping cost (see [COD Collection System](#-cod-collection-system)).

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
```

## Example Calculation

```text
Weight   = 2.5 KG
Distance = 100 KM
Priority = STANDARD

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

The platform uses a centralized shipment status-transition engine and a separate assignment workflow.

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
DELIVERED   (OTP-verified)
```

## Failed Delivery Lifecycle

```text
OUT_FOR_DELIVERY
       ↓
FAILED_DELIVERY
       ↓
Hub Operator Retry / Reassignment
       ↓
OUT_FOR_DELIVERY
       ↓
FAILED_DELIVERY
       ↓
PICKUP_FROM_HUB
```

A shipment can have a maximum of **2 actual delivery attempts**.

## Exceptional States

```text
CANCELLED
FAILED_DELIVERY
PICKUP_FROM_HUB
RETURNED
```

## Assignment Workflow

Assignment status is a separate workflow from the shipment lifecycle.

```text
Shipment Status
CREATED → CONFIRMED → PICKED_UP → IN_TRANSIT → OUT_FOR_DELIVERY → DELIVERED

Assignment Status
PENDING → ACCEPTED
        └→ REJECTED
```

`assignmentStatus` must not be treated as a replacement for `ShipmentStatus`.

## Operational Ownership

```text
HUB_OPERATOR
    ↓
Dispatch / Receive / Assign / Reassign / Retry
    ↓
DELIVERY_AGENT
    ↓
Pickup → In Transit → Out For Delivery
    ↓
Delivered (OTP) / Failed Delivery

After 2 failed delivery attempts
    ↓
HUB_OPERATOR
    ↓
PICKUP_FROM_HUB
```

---

# 🧠 Status Transition Engine

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
 ├──→ PICKUP_FROM_HUB
 └──→ RETURNED
```

## Terminal States

The following states cannot transition into another shipment state:

```text
DELIVERED
CANCELLED
PICKUP_FROM_HUB
RETURNED
```

### Completed

- ✅ Centralized transition validation
- ✅ Invalid-transition rejection
- ✅ Terminal-state protection
- ✅ Tracking-event creation for status changes
- ✅ Role-specific operational status workflow
- ✅ Failed-delivery transition support
- ✅ Pickup-from-hub transition support
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

### Role Responsibility

```text
HUB_OPERATOR
    ↓
CREATED → CONFIRMED

DELIVERY_AGENT
    ↓
CONFIRMED → PICKED_UP
PICKED_UP → IN_TRANSIT
IN_TRANSIT → OUT_FOR_DELIVERY
OUT_FOR_DELIVERY → DELIVERED   (OTP verification)
OUT_FOR_DELIVERY → FAILED_DELIVERY

HUB_OPERATOR
    ↓
FAILED_DELIVERY → OUT_FOR_DELIVERY
FAILED_DELIVERY → PICKUP_FROM_HUB
```

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

# 🏢 Hub Management

Hub management is the operational foundation for the logistics workflow.

## ✅ Completed Capabilities

- ✅ Hub entity, repository, and CRUD operations
- ✅ Create, retrieve, update, and deactivate hubs
- ✅ Hub code and address management
- ✅ Active/inactive hub support
- ✅ Unique hub code validation
- ✅ Assign Hub Operators to hubs
- ✅ Assign Delivery Agents to hubs
- ✅ Automatic origin hub mapping using the sender's city
- ✅ Automatic destination hub mapping using the receiver's city
- ✅ Store `currentHubId` and `destinationHubId` on shipments
- ✅ Validate hub ownership before operational actions
- ✅ Origin hub dispatch workflow
- ✅ Destination hub receiving workflow

### Admin Hub APIs

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/admin/hubs` | Create hub |
| `GET` | `/api/admin/hubs` | Get all hubs |
| `GET` | `/api/admin/hubs/{hubId}` | Get hub by ID |
| `PUT` | `/api/admin/hubs/{hubId}` | Update hub |
| `PATCH` | `/api/admin/hubs/{hubId}/deactivate` | Deactivate hub |
| `PATCH` | `/api/admin/hubs/{hubId}/operators/{userId}` | Assign Hub Operator |
| `PATCH` | `/api/admin/hubs/{hubId}/agents/{userId}` | Assign Delivery Agent |

### Hub Relationship

```text
                    ADMIN
                      │
          ┌───────────┴───────────┐
          ▼                       ▼
   HUB_OPERATOR            DELIVERY_AGENT
          │                       │
          └───────────┬───────────┘
                      ▼
                     HUB
                      │
                      ▼
                  SHIPMENTS
```

### Shipment Hub Mapping

```text
Sender City
    ↓
Active Hub
    ↓
currentHubId

Receiver City
    ↓
Active Hub
    ↓
destinationHubId
```

The shipment creation service rejects the request when an active hub cannot be found for the sender or receiver city.

---

# 🏭 Hub-Based Shipment Operations

Shipments are associated with hubs throughout their journey, and every hub-level action is protected by hub ownership checks.

## ✅ Completed Capabilities

- ✅ Associate shipments with their current and destination hubs
- ✅ Restrict Hub Operator operations using hub ownership
- ✅ Restrict normal assignment to eligible agents associated with the same hub
- ✅ Dispatch shipments from the origin hub
- ✅ Receive shipments at the destination hub
- ✅ Automatic hub-level Delivery Agent assignment
- ✅ Workload-aware agent selection
- ✅ Administrative override for exceptional assignment situations

## Dispatch & Receiving Flow

```text
Customer creates shipment
        ↓
Origin Hub (currentHubId = origin)
        ↓
Hub Operator dispatches from origin hub
        ↓
Shipment in transit between hubs
        ↓
Hub Operator at destination hub receives shipment
        ↓
currentHubId = destination hub
        ↓
Delivery Agent assigned (manual or automatic)
        ↓
Last-mile delivery
```

### Operational Hub Ownership

```text
HUB_OPERATOR.hubId
        =
SHIPMENT.currentHubId
        =
DELIVERY_AGENT.hubId
```

---

# 🧑‍💼 Hub Operator Operations

The Hub Operator is responsible for normal day-to-day shipment handling and hub-level operational decisions.

## Authorization

Hub Operator APIs are protected using role-based authorization and additional service-level hub ownership checks.

A Hub Operator can operate only on shipments whose `currentHubId` matches the operator's assigned `hubId`.

A Hub Operator can assign only Delivery Agents who belong to the same hub.

## Hub Operator Responsibilities

- ✅ Confirm shipments
- ✅ Dispatch shipments from the origin hub
- ✅ Receive shipments at the destination hub
- ✅ Assign, reassign, and retry deliveries
- ✅ Trigger automatic Delivery Agent assignment
- ✅ Move shipments to `PICKUP_FROM_HUB` after two failed attempts

## Assignment APIs

```http
PATCH /api/hub/shipments/{shipmentId}/assign?deliveryAgentId={deliveryAgentId}
```

```http
PATCH /api/hub/shipments/{shipmentId}/reassign?deliveryAgentId={deliveryAgentId}
```

```http
PATCH /api/hub/shipments/{shipmentId}/retry?deliveryAgentId={deliveryAgentId}
```

```http
PATCH /api/hub/shipments/{shipmentId}/pickup-from-hub
```

### Assignment Rules

- ✅ Current authenticated user must be a `HUB_OPERATOR`
- ✅ Hub Operator must be assigned to an active hub
- ✅ Shipment must belong to the operator's current hub
- ✅ Delivery Agent must have role `DELIVERY_AGENT`
- ✅ Delivery Agent must belong to the same hub
- ✅ Initial assignment starts as `PENDING`
- ✅ Reassignment prevents assigning the same agent through the normal reassign operation
- ✅ Retry may assign the same or a different agent
- ✅ Retry is allowed only after a failed delivery attempt
- ✅ Retry is blocked after 2 actual delivery attempts

---

# 🚚 Delivery Agent Management

Delivery operations are built around authenticated Delivery Agents and Hub Operator-controlled assignments.

## ✅ Completed Capabilities

- ✅ Delivery Agent role and authentication
- ✅ Retrieve shipments assigned to the authenticated Delivery Agent
- ✅ Accept or reject shipment assignments
- ✅ Separate assignment status from shipment status
- ✅ Delivery Agent pickup and delivery workflow
- ✅ Shipment status progression through transit and out-for-delivery stages
- ✅ OTP-based delivery verification
- ✅ Delivery Agent performance statistics

## View Assigned Shipments

```http
GET /api/delivery/shipments
```

The API automatically identifies the authenticated Delivery Agent and returns only shipments assigned to that agent.

The Delivery Agent does not provide their own user ID in the request.

## Assignment Status

Each shipment assignment has a separate assignment state.

### Assignment Status Values

```text
PENDING
ACCEPTED
REJECTED
```

### Assignment Flow

```text
HUB OPERATOR / AUTO-ASSIGNMENT
      ↓
Assign / Reassign
      ↓
PENDING
      ↓
DELIVERY AGENT
      ├──→ ACCEPTED
      └──→ REJECTED
```

### Important Rule

Accepting an assignment changes only the `assignmentStatus`.

It does **not** automatically change the shipment's `status`.

```text
Shipment Status:
CREATED

Assignment Status:
PENDING
   ↓
ACCEPTED
```

The shipment remains `CREATED` until the appropriate shipment-status workflow operation is performed.

---

# 🔄 Shipment Assignment & Reassignment

## ✅ Completed Capabilities

- ✅ Hub Operator-controlled shipment assignment
- ✅ Shipment reassignment to another Delivery Agent
- ✅ Validate that the Delivery Agent belongs to the appropriate hub
- ✅ Assignment status: `PENDING`, `ACCEPTED`, `REJECTED`
- ✅ Record assignment and reassignment history
- ✅ Prevent invalid or duplicate assignments through business-rule validation
- ✅ Retry a failed delivery using the same or a different agent
- ✅ Automatic Delivery Agent assignment using workload balancing
- ✅ Emergency Admin assignment override

## Assignment Paths

```text
                    Shipment needs an agent
                              │
        ┌─────────────────────┼─────────────────────┐
        ▼                     ▼                     ▼
  Manual Assign         Automatic Assign       Emergency Override
  (Hub Operator)       (Workload Balanced)          (Admin)
        │                     │                     │
        └─────────────────────┼─────────────────────┘
                              ▼
                    assignmentStatus = PENDING
                              │
                    ┌─────────┴─────────┐
                    ▼                   ▼
                 ACCEPTED            REJECTED
```

### Assignment Validation

The system validates:

- ✅ Shipment exists
- ✅ Delivery Agent exists
- ✅ Selected user has the `DELIVERY_AGENT` role
- ✅ Agent belongs to the appropriate hub (for normal assignment)
- ✅ Shipment is not already assigned when using the normal assignment path
- ✅ Shipment is in an assignable state
- ✅ Authorized role performs the operation

---

# 🤖 Automatic Assignment & Workload Balancing

The platform can select a Delivery Agent automatically instead of requiring the Hub Operator to choose one manually.

## ✅ Completed Capabilities

- ✅ Automatic hub-level Delivery Agent assignment
- ✅ Workload-aware agent selection
- ✅ Only eligible agents are considered (correct role, same hub, enabled)
- ✅ Assignments created automatically still start as `PENDING`
- ✅ Automatic assignments are recorded in assignment history

## Selection Flow

```text
Shipment at Hub
      ↓
Find eligible Delivery Agents in the same hub
      ↓
Compare current workload of each agent
      ↓
Select the agent with the lightest workload
      ↓
assignedDeliveryAgentId saved
      ↓
assignmentStatus = PENDING
      ↓
Assignment history recorded
```

This keeps work distributed across the hub's agents instead of overloading a single agent.

---

# 👨‍💼 Admin Emergency Override

Normal day-to-day assignment belongs to the Hub Operator. The Admin assignment capability is retained as an **emergency / company-wide override** for exceptional situations.

### Current Admin API

```http
PATCH /api/admin/shipments/{shipmentId}/assign?deliveryAgentId={agentId}
```

### Rules

- ✅ Restricted to the `ADMIN` role
- ✅ Delivery Agent must exist and have the `DELIVERY_AGENT` role
- ✅ Used for exceptional cases rather than the normal hub workflow
- ✅ Recorded in assignment history as `EMERGENCY_ASSIGNED`

---

# 🧾 Assignment History

Assignment changes are recorded separately from the shipment's current assignment.

## Assignment History Data

```text
AssignmentHistory
├── id
├── shipmentId
├── deliveryAgentId
├── previousDeliveryAgentId
├── performedBy
├── action
├── hubId
├── timestamp
├── reason
└── notes
```

## Supported Assignment Actions

```text
ASSIGNED
REASSIGNED
ACCEPTED
REJECTED
EMERGENCY_ASSIGNED
```

This preserves an operational audit trail of assignment and reassignment decisions instead of overwriting the previous assignment information.

---

# 🚛 Delivery Agent Workflow

## ✅ Implemented Workflow

```text
Delivery Agent Login
        ↓
View Assigned Shipments
        ↓
Assignment Status = PENDING
        ↓
Accept (or Reject) Assignment
        ↓
Assignment Status = ACCEPTED
        ↓
Pickup
        ↓
In Transit
        ↓
Out For Delivery
        ├──────────────→ Delivered (OTP verified)
        │                    ↓
        │              COD collected (if COD)
        │
        └──────────────→ Failed Delivery
                              ↓
                         Hub Operator Retry
                              ↓
                         Next Attempt
```

## Assignment Acceptance API

```http
PATCH /api/delivery/shipments/{shipmentId}/accept
```

### Acceptance Rules

- ✅ Shipment must exist
- ✅ Shipment must be assigned to a Delivery Agent
- ✅ Authenticated Delivery Agent must own the assignment
- ✅ Assignment must currently be `PENDING`
- ✅ Assignment changes from `PENDING` to `ACCEPTED`
- ✅ Shipment status is not changed by acceptance

## Delivery Status APIs

```http
PATCH /api/delivery/shipments/{shipmentId}/pickup
PATCH /api/delivery/shipments/{shipmentId}/in-transit
PATCH /api/delivery/shipments/{shipmentId}/out-for-delivery
PATCH /api/delivery/shipments/{shipmentId}/delivered
PATCH /api/delivery/shipments/{shipmentId}/failed-delivery
```

The Delivery Agent controller is explicitly protected so Delivery Agent operational APIs cannot be used by ordinary customers or Hub Operators.

---

# 🔐 OTP-Based Delivery Verification

Successful delivery is verified using a one-time password (OTP) so that a shipment cannot be marked as delivered without confirmation from the receiver.

## ✅ Completed Capabilities

- ✅ OTP-based delivery verification
- ✅ Delivery confirmation requires a valid OTP
- ✅ Only the assigned Delivery Agent can confirm delivery
- ✅ Shipment must be `OUT_FOR_DELIVERY` to be delivered
- ✅ Delivery generates a tracking event

## Verification Flow

```text
Shipment = OUT_FOR_DELIVERY
        ↓
Receiver provides OTP to the Delivery Agent
        ↓
Delivery Agent submits OTP with the delivered request
        ↓
Backend validates OTP
        ↓
Valid → Shipment = DELIVERED
Invalid → Request rejected
```

---

# 📈 Delivery Agent Performance Statistics

The platform exposes performance statistics for Delivery Agents so that operational quality and workload can be reviewed.

## ✅ Completed Capabilities

- ✅ Delivery Agent performance statistics
- ✅ Statistics are derived from persisted shipment, assignment, and delivery-attempt data
- ✅ Supports operational review of agent workload and delivery outcomes

---

# 🧪 Delivery Attempts & Failed Delivery

Failed delivery is implemented as a separate operational workflow.

## ✅ Completed Capabilities

- ✅ `DeliveryAttempt` entity and repository
- ✅ Record individual delivery attempts
- ✅ Store failure reason, timestamp, assigned agent, and attempt number
- ✅ Maximum of two actual delivery attempts
- ✅ Hub Operator can retry following a failed delivery
- ✅ Retry with the same or a different agent
- ✅ Assignment rejection does not count as a delivery attempt
- ✅ Block a third delivery attempt
- ✅ Move the shipment to `PICKUP_FROM_HUB` after two failed attempts

## Delivery Attempt Model

```text
DeliveryAttempt
├── id
├── shipmentId
├── attemptNumber
├── deliveryAgentId
├── attemptedAt
├── failureReason
└── notes
```

## Failed Delivery Reasons

```text
CUSTOMER_UNAVAILABLE
WRONG_ADDRESS
PHONE_UNREACHABLE
CUSTOMER_REFUSED
OTHER
```

## Maximum Delivery Attempts

The platform allows a maximum of **2 actual delivery attempts** per shipment.

```text
Attempt 1
   ↓
FAILED_DELIVERY
   ↓
Hub Operator decides retry
   ↓
Attempt 2
   ↓
FAILED_DELIVERY
   ↓
PICKUP_FROM_HUB
```

### Important Assignment Rule

An assignment rejection does **not** consume a delivery attempt.

If an agent rejects a retry assignment, the Hub Operator can assign another eligible agent.

The delivery attempt counter increases only when an actual delivery attempt is recorded as failed.

### Failed Delivery API

```http
PATCH /api/delivery/shipments/{shipmentId}/failed-delivery
```

### Retry API

```http
PATCH /api/hub/shipments/{shipmentId}/retry?deliveryAgentId={deliveryAgentId}
```

### Pickup From Hub API

```http
PATCH /api/hub/shipments/{shipmentId}/pickup-from-hub
```

After the second failed delivery attempt:

```text
status = PICKUP_FROM_HUB
assignedDeliveryAgentId = null
assignmentStatus = null
```

This makes the shipment available for customer collection from the designated hub.

---

# 💳 Payments & COD

The platform supports both Cash on Delivery and online payment methods. The COD collection and settlement workflow is fully implemented; real online-gateway integration is planned.

## 💳 Online Payment (Razorpay)

### ✅ Completed Features

- ✅ Razorpay order creation and payment verification
- ✅ Secure payment signature verification
- ✅ Payment status tracking and MongoDB persistence
- ✅ Razorpay webhook integration for payment events
- ✅ Admin-controlled full payment refunds
- ✅ Refund status tracking (`PENDING`, `PROCESSED`, `FAILED`)
- ✅ Refund webhook handling
- ✅ Duplicate refund prevention
- ✅ Webhook signature validation for security
- ✅ Automatic payment status synchronization between payments and shipments
- ✅ Support for online payments and Cash on Delivery (COD)

## ✅ Implemented COD Lifecycle

```text
Shipment created with COD
        ↓
codCollectionStatus = PENDING
        ↓
Delivery Agent collects cash on delivery
        ↓
codCollectionStatus = COLLECTED
        ↓
codSettlementStatus = PENDING
        ↓
Admin settles collected COD
        ↓
codSettlementStatus = SETTLED
```

## Payment Status Values

```text
PENDING
PAID
FAILED
REFUNDED
```

## ⏱️ Planned Online Payment Integration

A `PaymentGateway` abstraction is planned so that a real payment provider can be integrated later without tightly coupling business logic to a specific provider.

---

# 💰 Payment Data Model & Business Rules

## ✅ Completed

- ✅ Shipment types: `P2P`, `COMPANY_TO_PERSON`
- ✅ Payment methods: `ONLINE`, `COD`
- ✅ Payment payer: `SENDER`, `RECEIVER`
- ✅ Payment status: `PENDING`, `PAID`, `FAILED`, `REFUNDED`
- ✅ COD order amount (`codAmount`) is separate from the shipping cost
- ✅ COD collection and COD settlement are separate stages
- ✅ Backend validation is enforced instead of trusting client-provided amounts
- ✅ No additional COD handling fee in the current pricing model

## Money Separation

```text
Shipping Cost        →  calculated by PricingService
COD Order Amount     →  amount to be collected from the receiver
COD Collection       →  Delivery Agent collects cash
COD Settlement       →  Admin settles the collected amount
```

---

# 💵 COD Collection System

Delivery Agents collect COD amounts from receivers during delivery. Every collection is validated and recorded.

## ✅ Completed Capabilities

- ✅ COD supported as a shipment payment method
- ✅ `codAmount` stored separately from shipping cost
- ✅ COD collection status management:
  - `NOT_APPLICABLE`
  - `PENDING`
  - `COLLECTED`
  - `FAILED`
- ✅ Delivery Agent API to view assigned COD shipments
- ✅ Delivery Agent COD collection endpoint
- ✅ Validate the expected COD amount against the collected amount
- ✅ Record the collected amount and collection timestamp
- ✅ Record the collecting Delivery Agent ID
- ✅ Store collection notes
- ✅ Prevent duplicate COD collection
- ✅ Restrict collection to the assigned Delivery Agent
- ✅ Validate that the shipment actually uses COD

## Collection Rules

```text
Authenticated Delivery Agent
        ↓
Shipment must use COD
        ↓
Agent must be the assigned agent
        ↓
codCollectionStatus must be PENDING
        ↓
Collected amount must match expected COD amount
        ↓
Record amount, timestamp, agent ID, notes
        ↓
codCollectionStatus = COLLECTED
```

---

# 🧾 Admin COD Settlement

After agents collect COD cash, an Admin settles the collected amount. Collection and settlement are intentionally separate stages for financial traceability.

## ✅ Completed Capabilities

- ✅ COD settlement status management:
  - `NOT_APPLICABLE`
  - `PENDING`
  - `SETTLED`
- ✅ Admin API to retrieve pending COD settlements
- ✅ Admin API to settle collected COD
- ✅ Allow settlement only after COD collection
- ✅ Validate that the collected amount matches the expected amount
- ✅ Record the settlement timestamp
- ✅ Record the Admin ID responsible for settlement
- ✅ Store settlement notes
- ✅ Prevent duplicate settlement
- ✅ Restrict settlement operations to the `ADMIN` role

## Settlement Rules

```text
Admin retrieves pending settlements
        ↓
Select a collected COD shipment
        ↓
Collection must be COLLECTED
        ↓
Settlement must be PENDING (no duplicates)
        ↓
Collected amount must match expected amount
        ↓
Record timestamp, Admin ID, notes
        ↓
codSettlementStatus = SETTLED
```

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
| Delivery operations & COD collection | `DELIVERY_AGENT` |
| Hub operations | `HUB_OPERATOR` |
| Administrative operations & COD settlement | `ADMIN` |

### Defense in Depth

The application uses both URL-level and method-level authorization.

Examples include:

```java
@PreAuthorize("hasRole('DELIVERY_AGENT')")
```

and:

```java
@PreAuthorize("hasRole('HUB_OPERATOR')")
```

This ensures that role access is enforced even when a broader URL matcher allows multiple operational roles.

### Hub Ownership Authorization

Hub Operator operations additionally validate:

```text
Authenticated Hub Operator
        ↓
operator.hubId
        ↓
shipment.currentHubId
```

and Delivery Agent selection is restricted to agents assigned to the same hub.

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
- ✅ COD amount validation
- ✅ OTP validation
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

Manual API testing is performed using Postman throughout development.

The core shipment, hub, assignment, delivery, failed-delivery, and COD workflows have been integration-tested.

## ✅ Tested

### Authentication & Authorization

- ✅ Customer registration
- ✅ Customer login
- ✅ Admin login
- ✅ Delivery Agent login
- ✅ Hub Operator login
- ✅ JWT authentication
- ✅ Role-based authorization
- ✅ Role-specific controller protection
- ✅ Role-based authorization for COD operations

### Shipment & Pricing

- ✅ Shipment creation
- ✅ Shipment retrieval
- ✅ Shipment update
- ✅ Shipment cancellation
- ✅ Price estimation
- ✅ Admin pricing configuration
- ✅ Server-side shipment pricing

### Hub & Assignment

- ✅ Hub management and hub assignment workflows
- ✅ Shipment-to-hub mapping (origin and destination)
- ✅ Hub Operator and Delivery Agent assignment to hub
- ✅ Delivery Agent assignment and reassignment
- ✅ Assignment acceptance and rejection
- ✅ Assignment ownership validation
- ✅ Hub ownership validation
- ✅ Same-hub Delivery Agent validation
- ✅ Delivery retry assignment
- ✅ Assignment history recording

### Shipment Lifecycle

- ✅ `CREATED → CONFIRMED`
- ✅ `CONFIRMED → PICKED_UP`
- ✅ `PICKED_UP → IN_TRANSIT`
- ✅ `IN_TRANSIT → OUT_FOR_DELIVERY`
- ✅ `OUT_FOR_DELIVERY → DELIVERED`
- ✅ `OUT_FOR_DELIVERY → FAILED_DELIVERY`

### Failed Delivery

- ✅ First failed delivery attempt
- ✅ Delivery attempt record creation
- ✅ Hub Operator retry after first failed attempt
- ✅ Delivery Agent accepts retry assignment
- ✅ Second failed delivery attempt
- ✅ Third retry blocked after 2 actual attempts
- ✅ HTTP `400 Bad Request` for maximum-attempt protection
- ✅ `FAILED_DELIVERY → PICKUP_FROM_HUB`
- ✅ Agent assignment and assignment status cleared after pickup-from-hub
- ✅ Tracking history records the complete failure/pickup lifecycle

### COD Collection & Settlement

- ✅ COD shipment visibility for Delivery Agents
- ✅ COD collection and amount validation
- ✅ Duplicate collection protection
- ✅ Pending COD settlement retrieval
- ✅ Admin COD settlement
- ✅ Duplicate settlement protection

### Tracking

- ✅ Tracking history
- ✅ Tracking-event creation
- ✅ Complete lifecycle history verification
- ✅ Failed-delivery history
- ✅ Pickup-from-hub history

## 🟢 Integration Testing Status

The main integration-testing targets for the implemented shipment, delivery, and COD workflows are complete.

The tested failure branch was:

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
FAILED_DELIVERY #1
   ↓
RETRY
   ↓
OUT_FOR_DELIVERY
   ↓
FAILED_DELIVERY #2
   ↓
PICKUP_FROM_HUB
```

## ⏱️ Future Testing

- ⏱️ Automated unit tests
- ⏱️ Service-layer tests
- ⏱️ Controller tests
- ⏱️ Repository tests
- ⏱️ Expanded automated integration testing
- ⏱️ Security tests
- ⏱️ End-to-end test automation
- ⏱️ Load and performance testing

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
| `POST` | `/api/admin/hubs` | Create hub |
| `GET` | `/api/admin/hubs` | Get all hubs |
| `GET` | `/api/admin/hubs/{hubId}` | Get hub by ID |
| `PUT` | `/api/admin/hubs/{hubId}` | Update hub |
| `PATCH` | `/api/admin/hubs/{hubId}/deactivate` | Deactivate hub |
| `PATCH` | `/api/admin/hubs/{hubId}/operators/{userId}` | Assign Hub Operator |
| `PATCH` | `/api/admin/hubs/{hubId}/agents/{userId}` | Assign Delivery Agent |
| `PATCH` | `/api/admin/shipments/{shipmentId}/assign?deliveryAgentId={agentId}` | Emergency shipment assignment override |
| `GET` | _pending COD settlements endpoint_ | Retrieve collected COD awaiting settlement |
| `PATCH` | _COD settlement endpoint_ | Settle collected COD |

## 🧑‍💼 Hub Operator APIs

| Method | Endpoint | Description |
|---|---|---|
| `PATCH` | `/api/hub/shipments/{shipmentId}/assign?deliveryAgentId={agentId}` | Assign shipment |
| `PATCH` | `/api/hub/shipments/{shipmentId}/reassign?deliveryAgentId={agentId}` | Reassign shipment |
| `PATCH` | `/api/hub/shipments/{shipmentId}/retry?deliveryAgentId={agentId}` | Retry failed delivery |
| `PATCH` | `/api/hub/shipments/{shipmentId}/pickup-from-hub` | Mark shipment available for hub pickup |

> Dispatch, receiving, and automatic-assignment operations are also exposed to Hub Operators.

## 🚚 Delivery Agent APIs

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/delivery/shipments` | Retrieve shipments assigned to authenticated Delivery Agent |
| `PATCH` | `/api/delivery/shipments/{shipmentId}/accept` | Accept a pending shipment assignment |
| `PATCH` | `/api/delivery/shipments/{shipmentId}/reject` | Reject a pending assignment |
| `PATCH` | `/api/delivery/shipments/{shipmentId}/pickup` | Mark shipment picked up |
| `PATCH` | `/api/delivery/shipments/{shipmentId}/in-transit` | Mark shipment in transit |
| `PATCH` | `/api/delivery/shipments/{shipmentId}/out-for-delivery` | Mark shipment out for delivery |
| `PATCH` | `/api/delivery/shipments/{shipmentId}/delivered` | Mark shipment delivered (OTP verified) |
| `PATCH` | `/api/delivery/shipments/{shipmentId}/failed-delivery` | Record failed delivery attempt |
| `GET` | _assigned COD shipments endpoint_ | View assigned COD shipments |
| `PATCH` | _COD collection endpoint_ | Record COD collection |
| `GET` | _performance statistics endpoint_ | View Delivery Agent performance statistics |

---

# 🧪 Example End-to-End Assignment Test

The operational assignment flow is Hub Operator-driven (with optional automatic assignment).

```text
Customer creates shipment
        ↓
Shipment = CREATED
        ↓
Backend resolves sender city → origin hub
        ↓
Backend resolves receiver city → destination hub
        ↓
Shipment.currentHubId / destinationHubId saved
        ↓
Hub Operator authenticates
        ↓
Hub Operator selects eligible Delivery Agent (or uses auto-assignment)
        ↓
Assignment validated against Hub
        ↓
assignedDeliveryAgentId saved
        ↓
assignmentStatus = PENDING
        ↓
Delivery Agent authenticates
        ↓
GET /api/delivery/shipments
        ↓
Assigned shipment returned
        ↓
PATCH /api/delivery/shipments/{shipmentId}/accept
        ↓
Assignment ownership validated
        ↓
assignmentStatus = ACCEPTED
```

### Important

Accepting the assignment does not change the shipment lifecycle status.

```text
Shipment Status:
CREATED

Assignment Status:
PENDING
   ↓
ACCEPTED
```

---

# 📊 Development Status

## 🟢 Completed Features

### 🔐 Authentication & Security

- ✅ Spring Boot project setup, Maven configuration, Java 21
- ✅ MongoDB configuration
- ✅ User entity and repository
- ✅ Local registration and login (username/email)
- ✅ BCrypt password hashing
- ✅ JWT access and refresh tokens
- ✅ JWT authentication filter
- ✅ Role-based authorization (Customer, Admin, Delivery Agent, Hub Operator)
- ✅ Google OAuth 2.0
- ✅ Method-level authorization with `@PreAuthorize`
- ✅ Role-specific controller protection

### 📦 Shipment Management

- ✅ Shipment entity, repository, and DTOs
- ✅ Address and package validation
- ✅ Shipment creation and tracking-number generation
- ✅ Shipment retrieval, customer shipment retrieval, update, cancellation
- ✅ `currentHubId` / `destinationHubId`
- ✅ Automatic origin/destination hub mapping

### 💰 Pricing

- ✅ Pricing configuration and Admin pricing API
- ✅ Price-estimation API
- ✅ Server-side, priority-based shipment pricing

### 🏢 Hub Operations

- ✅ Hub entity, repository, and CRUD
- ✅ Active/inactive hub support and hub code validation
- ✅ Hub Operator and Delivery Agent assignment to hub
- ✅ Hub ownership validation
- ✅ Origin hub dispatch workflow
- ✅ Destination hub receiving workflow

### 🚚 Delivery & Assignment

- ✅ Delivery Agent authentication and assigned-shipment retrieval
- ✅ Hub Operator shipment assignment and reassignment
- ✅ Assignment validation and status management
- ✅ Accept / reject assignment
- ✅ Assignment history
- ✅ Retry assignment after failed delivery
- ✅ Automatic assignment using workload balancing
- ✅ Emergency Admin assignment override
- ✅ OTP-based delivery verification
- ✅ Delivery Agent performance statistics

### ❌ Failed Delivery

- ✅ Failed-delivery request validation and structured failure reasons
- ✅ Delivery attempt entity, persistence, and counting
- ✅ Maximum 2 actual delivery attempts and retry restriction
- ✅ `PICKUP_FROM_HUB` workflow and assignment clearing
- ✅ Tracking history for failed attempts and hub pickup

### 💵 Payments & COD

- ✅ Payment data model (shipment type, payment method, payer, payment status)
- ✅ COD amount stored separately from shipping cost
- ✅ COD collection workflow with amount validation and duplicate protection
- ✅ COD settlement workflow with Admin-only access and duplicate protection

### 📍 Tracking & Workflow

- ✅ Tracking history and tracking-event creation
- ✅ Shipment status-transition engine with invalid-transition validation
- ✅ Terminal-state protection
- ✅ Delivery, failed-delivery, and hub pickup lifecycles

### 🧪 Testing

- ✅ Postman API testing of authentication, authorization, shipment, pricing, hub, assignment, retry, failed-delivery, pickup-from-hub, and COD workflows
- ✅ End-to-end integration workflow testing

---

# 🔄 Current Development

The core shipment, hub, assignment, delivery, failed-delivery, and COD workflows have been implemented and integration-tested.

The next development focus is the remaining business modules (notifications, invoices, ratings, reports) and production-oriented hardening.

### Current Core Flow

```text
Customer
   ↓
Create Shipment
   ↓
Server-Side Pricing
   ↓
Automatic Origin / Destination Hub Mapping
   ↓
Origin Hub Dispatch → Destination Hub Receiving
   ↓
Hub Operator / Automatic Assignment
   ↓
Delivery Agent Acceptance
   ↓
Pickup → In Transit → Out For Delivery
   ├──────────────→ Delivered (OTP)
   │                    ↓
   │              COD Collection → Admin COD Settlement
   │
   └──────────────→ Failed Delivery
                         ↓
                    Retry / Reassign
                         ↓
                    Second Attempt
                         ↓
                  Pickup From Hub
```

---

# ⏱️ Planned Modules

## 💳 Payments

- ⏱️ Online payment gateway
- ⏱️ Payment abstraction (`PaymentGateway`)
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

## 🔎 Shipment Operations

- ⏱️ Shipment pagination
- ⏱️ Shipment search
- ⏱️ Shipment filtering
- ⏱️ Advanced public tracking
- ⏱️ Improved shipment update restrictions
- ⏱️ Field-level update rules

## 🤖 Automation & Intelligence

- ⏱️ Maps/geocoding integration
- ⏱️ Distance calculation
- ⏱️ ETA calculation
- ⏱️ Scheduled background jobs

## 🚀 Production Hardening

- ⏱️ Swagger / OpenAPI
- ⏱️ Automated testing
- ⏱️ MongoDB indexes
- ⏱️ Dockerization
- ⏱️ Production deployment
- ⏱️ Monitoring and observability
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

## Phase 3 — Hub & Shipment Workflow

```text
Status Transition Engine
Tracking Events
Hub Management
Hub Staff Assignment
Automatic Origin / Destination Hub Mapping
Origin Hub Dispatch
Destination Hub Receiving
Hub Operator Assignment
Reassignment
Automatic Assignment (Workload Balancing)
Emergency Admin Override
Assignment History
```

**Status: ✅ COMPLETED**

---

## Phase 4 — Delivery Operations

```text
Accept / Reject Assignment
Pickup
In Transit
Out For Delivery
OTP-Based Delivery Confirmation
Failed Delivery
Delivery Attempt Tracking
Retry / Reassignment
Maximum 2 Delivery Attempts
Pickup From Hub
Delivery Agent Performance Statistics
```

**Status: ✅ COMPLETED**

---

## Phase 5 — Payments & Platform Features

```text
Payment Data Model        ✅
COD Collection            ✅
Admin COD Settlement      ✅
Online Payment Gateway    ⏱️
Notifications             ⏱️
Invoices                  ⏱️
Ratings                   ⏱️
Reports                   ⏱️
Audit Logs                ⏱️
```

**Status: 🔄 IN PROGRESS** (COD workflow completed)

---

## Phase 6 — Production Hardening

```text
Pagination
Search
Filtering
Swagger / OpenAPI
Automated Tests
MongoDB Indexes
Docker
Deployment
Monitoring
Observability
```

**Status: ⏱️ PLANNED**

---

## Phase 7 — Future Scale

```text
Maps / Geocoding
ETA Calculation
Background Jobs
Event-Driven Processing
Caching
Potential Service Decomposition
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
- ✅ Server-side validation of financial amounts (COD)
- ✅ State-transition validation
- ✅ Ownership validation
- ✅ Assignment validation and status management
- ✅ Hub ownership validation
- ✅ Delivery-agent hub validation
- ✅ Assignment history
- ✅ Delivery attempt tracking
- ✅ Controlled failed-delivery workflow
- ✅ Duplicate-operation protection (COD collection and settlement)
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
                         │ Hub Operations      │
                         │ Assignment          │
                         │ COD / Payments      │
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

- HTTP endpoints
- Request mapping
- Request validation
- Authentication-context access
- Response generation

### ⚙️ Service Layer

- Business rules
- Pricing calculations
- Shipment workflow
- Status-transition validation
- Ownership checks
- Hub dispatch and receiving
- Assignment validation, automatic assignment, and status management
- Hub ownership validation
- Delivery attempt management and failed-delivery workflow
- OTP delivery verification
- COD collection and settlement
- Assignment history
- Authentication-related business logic

### 🗄️ Repository Layer

- Database access
- User, shipment, pricing-configuration, and hub queries
- Delivery-attempt and assignment-history queries

### 📦 DTO Layer

- API request and response contracts
- Input validation
- Separation between persistence entities and API models

### 🔐 Security Layer

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
    │                   └── config/
    │
    └── resources/
        └── application.properties
```

Package names and individual classes may evolve as the platform continues to grow.

---

# 👥 User Roles

| Role | Responsibilities |
|---|---|
| 👤 `CUSTOMER` | Create shipments, manage permitted shipment information and track deliveries |
| 🚚 `DELIVERY_AGENT` | Accept/reject assignments, perform pickup/delivery operations, verify delivery via OTP, collect COD |
| 🏢 `HUB_OPERATOR` | Operate shipments within the assigned hub: dispatch, receive, assign/reassign agents, retry deliveries, handle pickup-from-hub |
| 🛡️ `ADMIN` | Manage hubs, pricing, staff-to-hub membership, emergency assignment overrides, and COD settlement |

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
                         CUSTOMER
                            │
                            ▼
                    Create Shipment
                            │
                            ▼
                  Server-Side Pricing
                            │
                            ▼
              Resolve Origin / Destination Hub
                            │
                            ▼
                         CREATED
                            │
                            ▼
                       CONFIRMED
                            │
                            ▼
                       PICKED_UP
                            │
                            ▼
                       IN_TRANSIT
                            │
                            ▼
                    OUT_FOR_DELIVERY
                       /          \
                      /            \
                     ▼              ▼
          DELIVERED (OTP)    FAILED_DELIVERY
                                  │
                         ┌────────┴────────┐
                         ▼                 ▼
                    Retry / Reassign   Pickup From Hub
                         │
                         ▼
                  OUT_FOR_DELIVERY
                         │
                         ▼
                  Second Attempt
                         │
                         ▼
                  FAILED_DELIVERY
                         │
                         ▼
                  PICKUP_FROM_HUB
```

The transition engine is responsible for enforcing valid movement between shipment states.

### COD Financial Workflow

```text
Delivery Agent delivers COD shipment
          ↓
Validate agent, COD usage, and amount
          ↓
codCollectionStatus: PENDING → COLLECTED
          ↓
codSettlementStatus: PENDING
          ↓
Admin settles collected COD
          ↓
codSettlementStatus: SETTLED
```

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

Failed-delivery attempts and hub pickup decisions are also represented in the tracking history.

---

# 🚚 Delivery Assignment Architecture

Normal operational assignment is Hub Operator-driven, with optional workload-balanced automatic assignment and an Admin emergency override.

```text
                         ADMIN
                           │
                           ▼
                    Hub / Staff Setup
                           │
          ┌────────────────┴────────────────┐
          ▼                                 ▼
   HUB_OPERATOR                       DELIVERY_AGENT
          │                                 │
          │ hubId                           │ hubId
          └────────────────┬────────────────┘
                           ▼
                          HUB
                           │
                           ▼
                    Shipment.currentHubId
                           │
                           ▼
        Manual select  /  Auto (lowest workload)
                           │
                           ▼
                assignedDeliveryAgentId
                           │
                           ▼
                assignmentStatus=PENDING
                           │
                           ▼
                   DELIVERY_AGENT
                           │
                           ▼
                     ACCEPT / REJECT
```

## Assignment State Separation

```text
Shipment Status
      │
      └── CREATED / CONFIRMED / PICKED_UP / ...

Assignment Status
      │
      ├── PENDING
      │     ├── ACCEPTED
      │     └── REJECTED
      │
      └── cleared after final pickup-from-hub handling
```

## Retry Architecture

```text
FAILED_DELIVERY
      ↓
Hub Operator checks attempt count
      ↓
Attempt count < 2
      ↓
Assign same or different eligible agent
      ↓
PENDING
      ↓
Agent accepts
      ↓
OUT_FOR_DELIVERY
```

After two actual failed attempts, retry is blocked and the Hub Operator can move the shipment to `PICKUP_FROM_HUB`.

## Assignment History

Every assignment/reassignment operation can create an `AssignmentHistory` record containing the current agent, previous agent, performer, hub, action, reason, notes, and timestamp.

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
                 │  ┌───────────────────────┐  │
                 │  │ Shipment Module       │  │
                 │  └───────────────────────┘  │
                 │  ┌───────────────────────┐  │
                 │  │ Pricing Module        │  │
                 │  └───────────────────────┘  │
                 │  ┌───────────────────────┐  │
                 │  │ Tracking Module       │  │
                 │  └───────────────────────┘  │
                 │  ┌───────────────────────┐  │
                 │  │ Delivery Module       │  │
                 │  └───────────────────────┘  │
                 │  ┌───────────────────────┐  │
                 │  │ Hub Module            │  │
                 │  └───────────────────────┘  │
                 │  ┌───────────────────────┐  │
                 │  │ Payment / COD Module  │  │
                 │  └───────────────────────┘  │
                 └─────────────────────────────┘
```

Future modules can be introduced without immediately splitting the application into multiple distributed services.

---

# ⚙️ Local Setup

## Prerequisites

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

```properties
spring.data.mongodb.uri=${MONGODB_URI}
```

## 3. Configure Google OAuth 2.0

```properties
spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}
spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}
```

Do not commit real OAuth credentials to GitHub.

## 4. Configure JWT Secret

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
Create Shipment (online or COD)
   ↓
Automatic Origin / Destination Hub Mapping
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
Create / Manage Hubs
   ↓
Assign Staff to Hubs
   ↓
Emergency Shipment Assignment (if required)
   ↓
Review Pending COD Settlements
   ↓
Settle Collected COD
```

## Hub Operator Flow

```text
Login
   ↓
Receive JWT
   ↓
Operate Within Assigned Hub
   ↓
Dispatch (origin hub) / Receive (destination hub)
   ↓
Assign Delivery Agent (manual or automatic)
   ↓
assignmentStatus = PENDING
   ↓
Delivery Agent Accepts
   ↓
Manage Retry / Reassignment if Delivery Fails
   ↓
Pickup From Hub After 2 Failed Attempts
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
Pickup → In Transit → Out For Delivery
   ├──────────────→ Delivered (OTP verified)
   │                    ↓
   │              Collect COD (if COD shipment)
   │
   └──────────────→ Failed Delivery
                         ↓
                    Hub Operator Retry
                         ↓
                    Second Attempt
                         ↓
                    Pickup From Hub
```

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
              ▼                   ▼                   ▼
       ┌─────────────┐     ┌─────────────┐     ┌─────────────┐
       │   Auth      │     │  Shipment   │     │   Pricing   │
       │   Service   │     │   Service   │     │   Service   │
       └─────────────┘     └─────────────┘     └─────────────┘
              ┌───────────────────┼───────────────────┐
              ▼                   ▼                   ▼
       ┌─────────────┐     ┌─────────────┐     ┌─────────────┐
       │     Hub     │     │  Delivery   │     │   Payment   │
       │   Service   │     │   Service   │     │   Service   │
       └─────────────┘     └─────────────┘     └─────────────┘
                                  ▼
                         ┌─────────────────┐
                         │  Notification   │
                         │    Service      │
                         └─────────────────┘
```

For now, these capabilities remain inside a single Spring Boot application.

---

# 📌 Current Project State

The project has progressed beyond authentication and CRUD into a complete hub-based shipment operations and COD financial workflow.

## Current Implemented Flow

```text
Authentication → Authorization → User Management
      ↓
Hub Management → Hub Staff Assignment
      ↓
Shipment Management → Server-Side Pricing
      ↓
Automatic Origin / Destination Hub Mapping
      ↓
Tracking History → Status Transition Engine
      ↓
Origin Hub Dispatch → Destination Hub Receiving
      ↓
Hub Operator / Automatic Assignment (PENDING)
      ↓
Delivery Agent Acceptance (ACCEPTED)
      ↓
Pickup → In Transit → Out For Delivery
      ├──────────────→ Delivered (OTP)
      │                    ↓
      │              COD Collection
      │                    ↓
      │              Admin COD Settlement
      │
      └──────────────→ Failed Delivery
                           ↓
                     Delivery Attempt #1
                           ↓
                     Hub Operator Retry
                           ↓
                     Delivery Attempt #2
                           ↓
                     Pickup From Hub
```

## Current Development Focus

```text
Core Operational + COD Workflow  ✅
          ↓
Online Payments
          ↓
Invoices / Ratings
          ↓
Notifications
          ↓
Reports / Audit
          ↓
Automated Testing
          ↓
Production Hardening
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
| Method-Level Authorization | ✅ Completed |
| Google OAuth 2.0 | ✅ Completed |
| Customer / Admin / Delivery Agent / Hub Operator Roles | ✅ Completed |
| User-to-Hub Staff Assignment | ✅ Completed |
| Shipment Creation | ✅ Completed |
| Shipment Retrieval | ✅ Completed |
| Shipment Update | ✅ Completed |
| Shipment Cancellation | ✅ Completed |
| Tracking Number Generation | ✅ Completed |
| Address & Package Validation | ✅ Completed |
| Pricing Configuration | ✅ Completed |
| Server-Side Pricing | ✅ Completed |
| Price Estimation | ✅ Completed |
| Tracking History & Events | ✅ Completed |
| Status Transition Engine | ✅ Completed |
| Invalid Transition Validation | ✅ Completed |
| Terminal State Protection | ✅ Completed |
| Hub CRUD | ✅ Completed |
| Active Hub Validation | ✅ Completed |
| Automatic Origin Hub Mapping | ✅ Completed |
| Automatic Destination Hub Mapping | ✅ Completed |
| Current / Destination Hub Tracking | ✅ Completed |
| Hub Ownership Validation | ✅ Completed |
| Origin Hub Dispatch Workflow | ✅ Completed |
| Destination Hub Receiving Workflow | ✅ Completed |
| Hub Operator Shipment Assignment | ✅ Completed |
| Shipment Reassignment | ✅ Completed |
| Automatic Assignment (Workload Balancing) | ✅ Completed |
| Emergency Admin Assignment Override | ✅ Completed |
| Assignment Validation | ✅ Completed |
| Assignment Status Management | ✅ Completed |
| Delivery Agent Assigned Shipments | ✅ Completed |
| Delivery Agent Accept / Reject Assignment | ✅ Completed |
| Assignment Ownership Validation | ✅ Completed |
| Assignment History | ✅ Completed |
| Delivery Lifecycle | ✅ Completed |
| OTP-Based Delivery Verification | ✅ Completed |
| Delivery Agent Performance Statistics | ✅ Completed |
| Delivery Attempt Tracking | ✅ Completed |
| Failed Delivery Workflow | ✅ Completed |
| Maximum 2 Delivery Attempts | ✅ Completed |
| Retry Restriction After 2 Attempts | ✅ Completed |
| Pickup From Hub | ✅ Completed |
| Payment Data Model (type, method, payer, status) | ✅ Completed |
| COD Support & Separate COD Amount | ✅ Completed |
| COD Collection (Delivery Agent) | ✅ Completed |
| COD Amount Validation | ✅ Completed |
| Duplicate COD Collection Protection | ✅ Completed |
| Admin COD Settlement | ✅ Completed |
| Pending COD Settlement Retrieval | ✅ Completed |
| Duplicate Settlement Protection | ✅ Completed |
| Postman API Testing | ✅ Completed |
| End-to-End Integration Testing | ✅ Completed |
| Online Payment Gateway | ⏱️ Planned |
| Payment Abstraction | ⏱️ Planned |
| Email Notifications | ⏱️ Planned |
| SMS / Push Notifications | ⏱️ Planned |
| Invoice / PDF Receipt | ⏱️ Planned |
| Delivery Rating | ⏱️ Planned |
| Admin Reports | ⏱️ Planned |
| Audit Logging | ⏱️ Planned |
| Maps / Geocoding | ⏱️ Planned |
| Distance Calculation | ⏱️ Planned |
| ETA Calculation | ⏱️ Planned |
| Scheduled Background Jobs | ⏱️ Planned |
| Pagination | ⏱️ Planned |
| Search & Filtering | ⏱️ Planned |
| Swagger / OpenAPI | ⏱️ Planned |
| Automated Testing | ⏱️ Planned |
| MongoDB Indexing | ⏱️ Planned |
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
- ✅ Priority, distance, and package weight participate in pricing.
- ✅ Shipment creation recalculates the price on the server.
- ✅ No additional COD handling fee is charged in the current pricing model.

## 📦 Shipment Ownership

- ✅ Customer operations are ownership-aware.
- ✅ Authenticated users are resolved from the security context.
- ✅ Sensitive shipment operations validate the requesting user's authority.
- ✅ Delivery Agents can operate only on shipments assigned to them.

## 🏢 Hub Ownership

- ✅ Hub Operators and Delivery Agents are assigned to a specific hub.
- ✅ A Hub Operator can operate only on shipments whose `currentHubId` matches the operator's hub.
- ✅ A Hub Operator can assign only Delivery Agents belonging to the same hub.
- ✅ Shipment creation resolves active origin and destination hubs from sender/receiver cities.
- ✅ Shipment creation fails when a required active hub cannot be found.

## 🔄 Status Transitions

- ✅ Status changes are validated centrally.
- ✅ Invalid transitions are rejected.
- ✅ Terminal states cannot transition further.
- ✅ Status changes generate tracking events.
- ✅ Failed delivery is allowed only from `OUT_FOR_DELIVERY`.
- ✅ `PICKUP_FROM_HUB` is used after the maximum delivery-attempt limit is reached.

## 🚚 Assignment

- ✅ Normal operational assignment is controlled by the Hub Operator.
- ✅ Automatic assignment selects an eligible same-hub agent using workload balancing.
- ✅ Admin assignment is an emergency override.
- ✅ Delivery Agents must have the `DELIVERY_AGENT` role.
- ✅ Existing assignments are validated; duplicate or invalid assignments are prevented.
- ✅ New assignments start with `assignmentStatus = PENDING`.
- ✅ Assignment status is separate from shipment status.
- ✅ Only the assigned Delivery Agent can accept or reject the assignment.
- ✅ Assignment acceptance is allowed only while `assignmentStatus = PENDING`.
- ✅ Assignment acceptance does not change the shipment `status`.
- ✅ Reassignment validates the new agent and hub.
- ✅ Retry can use the same or a different eligible agent.
- ✅ Assignment rejection does not consume a delivery attempt.
- ✅ Assignment changes are recorded in assignment history.

## 🧪 Delivery Attempts

- ✅ Only actual failed delivery attempts are counted.
- ✅ A shipment can have at most 2 actual delivery attempts.
- ✅ Retry is blocked when the attempt count reaches 2.
- ✅ After the second failed attempt, the shipment can be moved to `PICKUP_FROM_HUB`.
- ✅ Final pickup-from-hub handling clears the delivery-agent assignment.

## 🔐 Delivery Verification

- ✅ Delivery confirmation is OTP-verified.
- ✅ Only the assigned Delivery Agent can confirm delivery.

## 💵 COD Collection

- ✅ Collection is allowed only for shipments that actually use COD.
- ✅ Only the assigned Delivery Agent can collect.
- ✅ The collected amount must match the expected COD amount.
- ✅ Collection can happen only once (no duplicates).
- ✅ Collection records amount, timestamp, agent ID, and notes.

## 🧾 COD Settlement

- ✅ Settlement is allowed only after COD has been collected.
- ✅ Settlement is restricted to `ADMIN`.
- ✅ The collected amount must match the expected amount.
- ✅ Settlement can happen only once (no duplicates).
- ✅ Settlement records timestamp, Admin ID, and notes.
- ✅ Collection and settlement are kept as separate stages.

---

# 📈 Future Production Enhancements

## ⏱️ Scalability

- ⏱️ Database indexing
- ⏱️ Pagination
- ⏱️ Query optimization
- ⏱️ Caching
- ⏱️ Background processing
- ⏱️ Asynchronous events

## ⏱️ Reliability

- ⏱️ Automated testing
- ⏱️ Expanded automated integration testing
- ⏱️ Health checks
- ⏱️ Retry mechanisms
- ⏱️ Failure handling
- ⏱️ Transaction boundaries where appropriate (especially for COD financial operations)

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

- ✅ Resource-oriented endpoints
- ✅ HTTP methods aligned with operations
- ✅ DTO-based request and response contracts
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
- ✅ JWT authentication and refresh-token support
- ✅ Spring Security authorization
- ✅ Role-based API protection
- ✅ Authenticated-user resolution
- ✅ Ownership checks
- ✅ Assignment ownership validation
- ✅ Server-side pricing
- ✅ Server-side validation of COD amounts (client amounts are not trusted)
- ✅ OTP-verified delivery
- ✅ Duplicate COD collection / settlement protection

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
- ⏱️ COD collection and settlement events
- ⏱️ Exception logging
- ⏱️ Operational diagnostics

Sensitive information such as passwords, JWT secrets, OAuth client secrets, OTP values, and other credentials should never be logged.

---

# 📊 Operational Visibility

Future operational dashboards can expose:

- ⏱️ Total, active, delivered, failed, and returned shipments
- ⏱️ Pending and accepted assignments
- ⏱️ Delivery-agent workload and performance
- ⏱️ Hub workload
- ⏱️ Revenue / pricing metrics
- ⏱️ COD collected vs. settled
- ⏱️ Stuck shipments

---

# 🔔 Notification Architecture — Future Design

```text
Shipment Event
      │
      ▼
Notification Service
      │
      ├──────────────► Email
      ├──────────────► SMS
      └──────────────► Push
```

Potential events include:

- ⏱️ Shipment created / confirmed / picked up
- ⏱️ Hub arrival
- ⏱️ Out for delivery
- ⏱️ Delivered
- ⏱️ Failed delivery
- ⏱️ Returned
- ⏱️ Assignment created / accepted / rejected
- ⏱️ Payment and COD updates

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
├── hubId
├── createdAt
└── updatedAt
```

`hubId` associates operational staff such as Hub Operators and Delivery Agents with the hub they are authorized to operate in.

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
├── shipmentType            (P2P | COMPANY_TO_PERSON)
├── distance
├── cost
├── paymentMethod           (ONLINE | COD)
├── paymentPayer            (SENDER | RECEIVER)
├── paymentStatus           (PENDING | PAID | FAILED | REFUNDED)
├── codAmount
├── codCollectionStatus     (NOT_APPLICABLE | PENDING | COLLECTED | FAILED)
├── collectedAmount / collectedAt / collectedBy / collectionNotes
├── codSettlementStatus     (NOT_APPLICABLE | PENDING | SETTLED)
├── settledAt / settledBy / settlementNotes
├── status
├── trackingHistory
├── currentHubId
├── destinationHubId
├── assignedDeliveryAgentId
├── assignmentStatus
├── createdAt
└── updatedAt
```

## Hub

```text
Hub
├── id
├── name
├── code
├── address
├── active
├── createdAt
└── updatedAt
```

## Delivery Attempt

```text
DeliveryAttempt
├── id
├── shipmentId
├── attemptNumber
├── deliveryAgentId
├── attemptedAt
├── failureReason
└── notes
```

## Assignment History

```text
AssignmentHistory
├── id
├── shipmentId
├── deliveryAgentId
├── previousDeliveryAgentId
├── performedBy
├── action
├── hubId
├── timestamp
├── reason
└── notes
```

### Assignment Status

```text
AssignmentStatus
├── PENDING
├── ACCEPTED
└── REJECTED
```

`AssignmentStatus` represents the state of a Delivery Agent assignment and is intentionally separate from `ShipmentStatus`.

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
   ├──────────────► PRICING / PAYMENT / COD
   ├──────────────► CURRENT HUB ── HUB_OPERATOR
   ├──────────────► DESTINATION HUB
   └──────────────► DELIVERY AGENT ASSIGNMENT
                          ├── assignedDeliveryAgentId
                          └── assignmentStatus
```

### Operational Hub Ownership

```text
HUB_OPERATOR.hubId = SHIPMENT.currentHubId = DELIVERY_AGENT.hubId
```

The authenticated customer is used to determine customer ownership-sensitive operations instead of trusting arbitrary user identifiers supplied by the client.

Hub Operators operate only within their assigned hub, and Delivery Agent assignment is restricted to agents belonging to that hub.

---

# 🔄 Shipment State Machine

| Current State | Allowed Next State |
|---|---|
| `CREATED` | `CONFIRMED`, `CANCELLED` |
| `CONFIRMED` | `PICKED_UP` |
| `PICKED_UP` | `IN_TRANSIT` |
| `IN_TRANSIT` | `OUT_FOR_DELIVERY` |
| `OUT_FOR_DELIVERY` | `DELIVERED`, `FAILED_DELIVERY` |
| `FAILED_DELIVERY` | `OUT_FOR_DELIVERY`, `PICKUP_FROM_HUB`, `RETURNED` |
| `DELIVERED` | None |
| `CANCELLED` | None |
| `PICKUP_FROM_HUB` | None |
| `RETURNED` | None |

This state machine is enforced by the centralized shipment workflow logic.

### Separate Assignment State Machine

| Current Assignment State | Allowed Next State |
|---|---|
| `PENDING` | `ACCEPTED`, `REJECTED` |
| `ACCEPTED` | None |
| `REJECTED` | None |

### Separate COD State Machines

| COD Collection State | Allowed Next State |
|---|---|
| `NOT_APPLICABLE` | None |
| `PENDING` | `COLLECTED`, `FAILED` |
| `COLLECTED` | None |

| COD Settlement State | Allowed Next State |
|---|---|
| `NOT_APPLICABLE` | None |
| `PENDING` | `SETTLED` (only after collection) |
| `SETTLED` | None |

The assignment, delivery-attempt, and COD state machines are separate from the shipment state machine.

---

# 📦 Shipment Lifecycle Example

```text
1. Customer creates shipment
             ↓
2. Backend validates request
             ↓
3. Pricing service calculates cost
             ↓
4. Backend finds active origin hub from sender city
             ↓
5. Backend finds active destination hub from receiver city
             ↓
6. Tracking number generated
             ↓
7. Shipment stored as CREATED
             ↓
8. Hub Operator confirms and dispatches from the origin hub
             ↓
9. Destination hub receives the shipment
             ↓
10. Eligible same-hub Delivery Agent assigned (manual or automatic)
             ↓
11. Assignment status becomes PENDING
             ↓
12. Delivery Agent accepts assignment (ACCEPTED)
             ↓
13. Shipment progresses: pickup → in transit → out for delivery
             ↓
14a. Delivery verified with OTP → DELIVERED
             ↓
     COD collected by agent (if COD) → Admin settles COD
             OR
14b. Delivery attempt fails
             ↓
15. DeliveryAttempt recorded
             ↓
16. Hub Operator retries / reassigns if attempts < 2
             ↓
17. Second failure
             ↓
18. Shipment becomes available for PICKUP_FROM_HUB
             ↓
19. Tracking history preserves the complete operational timeline
```

---

# 🧪 Example Validation Rules

## Address

- ✅ Required fields
- ✅ Valid Indian PIN code
- ✅ Valid phone-number format where applicable

## Package

- ✅ Weight, length, width, and height must be positive

## Shipment

- ✅ Required priority
- ✅ Valid shipment status
- ✅ Valid distance
- ✅ Ownership, assignment, and assignment-ownership checks
- ✅ Hub ownership and same-hub Delivery Agent validation
- ✅ Valid assignment status transitions
- ✅ Delivery-attempt limit validation
- ✅ Failed-delivery reason validation
- ✅ OTP validation on delivery
- ✅ COD usage, amount, and duplicate-collection validation
- ✅ Settlement-after-collection and duplicate-settlement validation

---

# 📚 Development Philosophy

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
Financial Workflow (COD)
    ↓
Testing
    ↓
Production Hardening
```

The objective is to avoid prematurely introducing complex distributed infrastructure before the core business workflows are stable.

---

# 🧱 Why Modular Monolith First?

### Benefits During Early Development

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

### Potential Future Boundaries

```text
Authentication
      │
      ├── User Management
      ├── Shipment Management
      ├── Pricing
      ├── Delivery
      ├── Hub Operations
      ├── Payments / COD
      └── Notifications
```

These boundaries provide a possible path toward service decomposition without requiring microservices during the early development stages.

---

# 🧰 Development Tools

- ☕ Java 21
- 🌱 Spring Boot
- 🛡️ Spring Security
- 🍃 MongoDB
- 📦 Maven
- 🧪 Postman
- 🛠️ Spring Tool Suite / IDE
- 🌿 Git
- 🐙 GitHub

The application is currently configured for local development:

```text
Backend → Spring Boot → localhost:8081 → MongoDB
```

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

Authentication → Shipment Management → Pricing → Tracking → Hub Operations → Delivery Operations → COD Settlement → Production Hardening

</p>

<p align="center">

⭐ If you find the project interesting, consider giving the repository a star!

</p>

---

## 📌 Project Status Summary

| Category | Status |
|---|---|
| 🔐 Authentication & Authorization | ✅ Completed |
| 📦 Shipment Management | ✅ Completed |
| 💰 Pricing Engine | ✅ Completed |
| 📍 Tracking | ✅ Completed |
| 🔄 Status Workflow | ✅ Completed |
| 🏢 Hub Management & Mapping | ✅ Completed |
| 📤📥 Hub Dispatch & Receiving | ✅ Completed |
| 🚚 Delivery Assignment & Reassignment | ✅ Completed |
| 🤖 Automatic Workload-Balanced Assignment | ✅ Completed |
| 🚨 Emergency Admin Override | ✅ Completed |
| 🧾 Assignment History | ✅ Completed |
| 🚛 Delivery Operations & OTP Verification | ✅ Completed |
| 📈 Agent Performance Statistics | ✅ Completed |
| ❌ Failed Delivery & Retry | ✅ Completed |
| 🏢 Pickup From Hub | ✅ Completed |
| 💰 Payment Data Model | ✅ Completed |
| 💵 COD Collection | ✅ Completed |
| 🧾 Admin COD Settlement | ✅ Completed |
| 🧪 End-to-End Integration Testing | ✅ Completed |
| 💳 Online Payment Gateway | ⏱️ Planned |
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
