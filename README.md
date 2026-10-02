# 🚚 Logistics Platform

### Production-Oriented Logistics & Shipment Management Backend

<p align="center">

A modular, production-oriented logistics and shipment management platform built with **Java 21**, **Spring Boot**, **Spring Security**, and **MongoDB**.

Designed around secure authentication, shipment lifecycle management, server-side pricing, tracking, controlled status transitions, hub-based shipment operations, delivery-agent workflows, failed-delivery handling, and future logistics operations.

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
- [👨‍💼 Admin Shipment Assignment](#-admin-shipment-assignment)
- [🏢 Hub Management](#-hub-management)
- [🧑‍💼 Hub Operator Operations](#-hub-operator-operations)
- [🚛 Delivery Agent Workflow](#-delivery-agent-workflow)
- [🧾 Assignment History](#-assignment-history)
- [🧪 Delivery Attempts & Failed Delivery](#-delivery-attempts--failed-delivery)
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
- [🏢 Hub Operations — Current & Future Design](#-hub-operations--current--future-design)
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
- 🏢 Hub-based shipment operations
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
- Introduce hub-based operational ownership.
- Support controlled shipment assignment and reassignment.
- Handle failed-delivery scenarios through explicit business rules.
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
| 🚚 Delivery Agent Assignment | ✅ Completed |
| 🔄 Assignment Status Management | ✅ Completed |
| 🤝 Delivery Agent Assignment Acceptance | ✅ Completed |
| 🔁 Delivery Agent Reassignment / Retry | ✅ Completed |
| 🧾 Assignment History | ✅ Completed |
| 🧪 Delivery Attempt Tracking | ✅ Completed |
| ❌ Failed-Delivery Workflow | ✅ Completed |
| 🔢 Maximum 2 Delivery Attempts | ✅ Completed |
| 🏢 Pickup From Hub After Failed Attempts | ✅ Completed |
| 🚛 Delivery Agent Operational Workflow | ✅ Completed |
| 🧪 End-to-End Integration Testing | ✅ Completed |
| 💳 Payments / COD Collection | ⏱️ Planned |
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

### Planned

- ⏱️ Admin user-management APIs
- ⏱️ User activation/deactivation APIs
- ⏱️ Profile management
- ⏱️ Password-change functionality
- ⏱️ Account recovery
- ⏱️ Advanced delivery-agent management

---

# 📦 Shipment Management

Shipment management is one of the core implemented modules.

Customers can create shipments containing sender and receiver information, package information, delivery priority, distance, and COD selection.

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
- ✅ COD selection
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
DELIVERED
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
Normal shipment assignment / reassignment / retry
    ↓
DELIVERY_AGENT
    ↓
Pickup → In Transit → Out For Delivery
    ↓
Delivered / Failed Delivery

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
OUT_FOR_DELIVERY → DELIVERED
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

# 🚚 Delivery Agent Management

Delivery operations are now implemented around authenticated Delivery Agents and Hub Operator-controlled assignments.

## ✅ Delivery Agent Authentication

Delivery Agents authenticate through the existing JWT authentication system.

## ✅ View Assigned Shipments

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
HUB OPERATOR
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

For example:

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

# 👨‍💼 Admin Shipment Assignment

The architecture now separates **normal operational assignment** from **administrative control**.

### Normal Operational Assignment

Day-to-day shipment assignment, reassignment, and delivery retry are handled by the Hub Operator for shipments belonging to the operator's hub.

### Administrative Assignment

The existing Admin assignment capability remains available for administrative control. The planned production architecture will expose the Admin operation as an emergency/company-wide override rather than using it as the normal hub workflow.

### Current Admin API

```http
PATCH /api/admin/shipments/{shipmentId}/assign?deliveryAgentId={agentId}
```

### Assignment Validation

The system validates:

- ✅ Shipment exists
- ✅ Delivery Agent exists
- ✅ Selected user has the `DELIVERY_AGENT` role
- ✅ Shipment is not already assigned when using the normal assignment path
- ✅ Shipment is in an assignable state
- ✅ Authorized role performs the operation

---

# 🏢 Hub Management

Hub management is now implemented as an operational foundation for the logistics workflow.

## ✅ Completed Capabilities

- ✅ Hub entity
- ✅ Hub CRUD
- ✅ Active/inactive hub support
- ✅ Unique hub code validation
- ✅ Hub address management
- ✅ Hub Operator assignment to a hub
- ✅ Delivery Agent assignment to a hub
- ✅ Hub-based shipment ownership checks
- ✅ Automatic origin hub resolution
- ✅ Automatic destination hub resolution
- ✅ Current hub tracking on shipments

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

# 🧑‍💼 Hub Operator Operations

The Hub Operator is responsible for normal day-to-day shipment assignment and hub-level operational decisions.

## Authorization

Hub Operator APIs are protected using role-based authorization and additional service-level hub ownership checks.

A Hub Operator can operate only on shipments whose `currentHubId` matches the operator's assigned `hubId`.

A Hub Operator can assign only Delivery Agents who belong to the same hub.

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

# 🧪 Delivery Attempts & Failed Delivery

Failed delivery is implemented as a separate operational workflow.

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

The failure request supports a structured failure reason and optional notes.

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

# 🚛 Delivery Agent Workflow

## ✅ Implemented Workflow

```text
Delivery Agent Login
        ↓
View Assigned Shipments
        ↓
Assignment Status = PENDING
        ↓
Accept Assignment
        ↓
Assignment Status = ACCEPTED
        ↓
Pickup
        ↓
In Transit
        ↓
Out For Delivery
        ├──────────────→ Delivered
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

## Failed Delivery Workflow

```text
OUT_FOR_DELIVERY
      ↓
Delivery Agent reports failure
      ↓
DeliveryAttempt recorded
      ↓
FAILED_DELIVERY
      ↓
Hub Operator reviews
      ↓
Retry / Reassign
      ↓
OUT_FOR_DELIVERY
```

## After Two Failed Attempts

```text
FAILED_DELIVERY
      ↓
Attempt count = 2
      ↓
Hub Operator
      ↓
PICKUP_FROM_HUB
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
| Hub operations | `HUB_OPERATOR` |
| Administrative operations | `ADMIN` |

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

The core V1 shipment, hub, assignment, delivery, and failed-delivery workflows have now been integration-tested.

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

### Shipment & Pricing

- ✅ Shipment creation
- ✅ Shipment retrieval
- ✅ Shipment update
- ✅ Shipment cancellation
- ✅ Price estimation
- ✅ Admin pricing configuration
- ✅ Server-side shipment pricing
- ✅ Automatic origin hub assignment
- ✅ Automatic destination hub assignment

### Hub & Assignment

- ✅ Hub creation
- ✅ Active hub lookup
- ✅ Hub Operator assignment to hub
- ✅ Delivery Agent assignment to hub
- ✅ Hub Operator shipment assignment
- ✅ Delivery Agent assignment initialization as `PENDING`
- ✅ Delivery Agent assignment acceptance
- ✅ `PENDING → ACCEPTED` assignment transition
- ✅ Assignment ownership validation
- ✅ Hub ownership validation
- ✅ Same-hub Delivery Agent validation
- ✅ Shipment reassignment
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
- ✅ Agent assignment cleared after pickup-from-hub
- ✅ Assignment status cleared after pickup-from-hub
- ✅ Tracking history records the complete failure/pickup lifecycle

### Tracking

- ✅ Tracking history
- ✅ Tracking-event creation
- ✅ Complete lifecycle history verification
- ✅ Failed-delivery history
- ✅ Pickup-from-hub history

## 🟢 Integration Testing Status

The main V1 integration-testing target for the implemented shipment workflow is complete.

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
| `PATCH` | `/api/admin/shipments/{shipmentId}/assign?deliveryAgentId={agentId}` | Administrative shipment assignment |

## 🧑‍💼 Hub Operator APIs

| Method | Endpoint | Description |
|---|---|---|
| `PATCH` | `/api/hub/shipments/{shipmentId}/assign?deliveryAgentId={agentId}` | Assign shipment |
| `PATCH` | `/api/hub/shipments/{shipmentId}/reassign?deliveryAgentId={agentId}` | Reassign shipment |
| `PATCH` | `/api/hub/shipments/{shipmentId}/retry?deliveryAgentId={agentId}` | Retry failed delivery |
| `PATCH` | `/api/hub/shipments/{shipmentId}/pickup-from-hub` | Mark shipment available for hub pickup |

## 🚚 Delivery Agent APIs

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/delivery/shipments` | Retrieve shipments assigned to authenticated Delivery Agent |
| `PATCH` | `/api/delivery/shipments/{shipmentId}/accept` | Accept a pending shipment assignment |
| `PATCH` | `/api/delivery/shipments/{shipmentId}/reject` | Reject a pending assignment |
| `PATCH` | `/api/delivery/shipments/{shipmentId}/pickup` | Mark shipment picked up |
| `PATCH` | `/api/delivery/shipments/{shipmentId}/in-transit` | Mark shipment in transit |
| `PATCH` | `/api/delivery/shipments/{shipmentId}/out-for-delivery` | Mark shipment out for delivery |
| `PATCH` | `/api/delivery/shipments/{shipmentId}/delivered` | Mark shipment delivered |
| `PATCH` | `/api/delivery/shipments/{shipmentId}/failed-delivery` | Record failed delivery attempt |

---

# 🧪 Example End-to-End Assignment Test

The current operational assignment flow is Hub Operator-driven.

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
Hub Operator selects eligible Delivery Agent
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

This verifies the relationship between shipment ownership, hub ownership, authentication, assignment state management, and Delivery Agent-specific retrieval.

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
- ✅ Hub Operator role
- ✅ Google OAuth 2.0
- ✅ Method-level authorization with `@PreAuthorize`
- ✅ Role-specific controller protection

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
- ✅ `currentHubId`
- ✅ `destinationHubId`
- ✅ Automatic origin/destination hub mapping

### 💰 Pricing

- ✅ Pricing configuration
- ✅ Admin pricing API
- ✅ Price-estimation API
- ✅ Server-side shipment pricing
- ✅ Priority-based pricing
- ✅ COD pricing foundation

### 🏢 Hub Operations

- ✅ Hub entity
- ✅ Hub repository
- ✅ Hub CRUD
- ✅ Active/inactive hub support
- ✅ Hub code validation
- ✅ Hub Operator assignment
- ✅ Delivery Agent assignment to hub
- ✅ Hub ownership validation
- ✅ Automatic shipment hub mapping by city

### 🚚 Delivery & Assignment

- ✅ Delivery Agent authentication
- ✅ Delivery Agent assigned-shipment retrieval
- ✅ Hub Operator shipment assignment
- ✅ Shipment reassignment
- ✅ Assignment validation
- ✅ Assignment status management
- ✅ New assignments initialized as `PENDING`
- ✅ Delivery Agent assignment acceptance
- ✅ `PENDING → ACCEPTED` assignment transition
- ✅ Assignment ownership validation
- ✅ Assignment history
- ✅ Retry assignment after failed delivery

### ❌ Failed Delivery

- ✅ Failed-delivery request validation
- ✅ Structured failure reasons
- ✅ Delivery attempt entity
- ✅ Delivery attempt persistence
- ✅ Attempt counting
- ✅ Maximum 2 actual delivery attempts
- ✅ Retry restriction after 2 attempts
- ✅ `PICKUP_FROM_HUB` workflow
- ✅ Assignment clearing after pickup-from-hub
- ✅ Tracking history for failed attempts
- ✅ Tracking history for pickup-from-hub

### 📍 Tracking & Workflow

- ✅ Tracking history
- ✅ Tracking-event creation
- ✅ Shipment status-transition engine
- ✅ Invalid-transition validation
- ✅ Terminal-state protection
- ✅ Delivery lifecycle
- ✅ Failed-delivery lifecycle
- ✅ Hub pickup lifecycle

### 🧪 Testing

- ✅ Postman API testing
- ✅ Authentication testing
- ✅ Authorization testing
- ✅ Shipment workflow testing
- ✅ Pricing testing
- ✅ Hub testing
- ✅ Assignment testing
- ✅ Reassignment testing
- ✅ Retry testing
- ✅ Failed-delivery testing
- ✅ Maximum-attempt testing
- ✅ Pickup-from-hub testing
- ✅ End-to-end integration workflow testing

---

# 🔄 Current Development

The core V1 shipment, hub, assignment, delivery, and failed-delivery workflow has been implemented and integration-tested.

The next development focus is the remaining V1 business modules and production-oriented hardening.

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
Hub Operator Assignment
   ↓
Delivery Agent Acceptance
   ↓
Pickup
   ↓
In Transit
   ↓
Out For Delivery
   ├──────────────→ Delivered
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

- ⏱️ COD collection
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

## 🔎 Shipment Operations

- ⏱️ Shipment pagination
- ⏱️ Shipment search
- ⏱️ Shipment filtering
- ⏱️ Advanced public tracking
- ⏱️ Improved shipment update restrictions
- ⏱️ Field-level update rules

## 🤖 Automation & Intelligence

- ⏱️ Automatic Delivery Agent assignment
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
Assignment Validation
Assignment Status
Hub Management
Hub Staff Assignment
Automatic Origin / Destination Hub Mapping
Hub Operator Assignment
Reassignment
Assignment History
```

**Status: ✅ COMPLETED**

---

## Phase 4 — Delivery Operations

```text
Accept Assignment
Reject Assignment
Pickup
In Transit
Out For Delivery
Delivery Confirmation
Failed Delivery
Delivery Attempt Tracking
Retry / Reassignment
Maximum 2 Delivery Attempts
Pickup From Hub
```

**Status: ✅ COMPLETED**

---

## Phase 5 — Platform Features

```text
Payments
COD Collection
Notifications
Invoices
Ratings
Reports
Audit Logs
```

**Status: ⏱️ PLANNED**

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
- ✅ State-transition validation
- ✅ Ownership validation
- ✅ Assignment validation
- ✅ Assignment status management
- ✅ Hub ownership validation
- ✅ Delivery-agent hub validation
- ✅ Assignment history
- ✅ Delivery attempt tracking
- ✅ Controlled failed-delivery workflow
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
- Assignment status management
- Hub ownership validation
- Delivery attempt management
- Failed-delivery workflow
- Assignment history
- Authentication-related business logic

### 🗄️ Repository Layer

Responsible for:

- Database access
- User queries
- Shipment queries
- Pricing-configuration queries
- Hub queries
- Delivery-attempt queries
- Assignment-history queries

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
    │                   └── config/
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
| 🚚 `DELIVERY_AGENT` | Accept assignments and perform pickup/delivery operations |
| 🏢 `HUB_OPERATOR` | Operate shipments within the assigned hub, assign/reassign agents, retry deliveries, and handle pickup-from-hub |
| 🛡️ `ADMIN` | Manage users, hubs, pricing, staff-to-hub membership, and administrative overrides |

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
                DELIVERED    FAILED_DELIVERY
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

### Assignment Workflow

```text
                         HUB_OPERATOR
                              │
                              ▼
                    Select Shipment at Hub
                              │
                              ▼
                    Select Same-Hub Agent
                              │
                              ▼
                       Validate Assignment
                              │
                              ▼
                    assignmentStatus=PENDING
                              │
                    ┌─────────┴─────────┐
                    ▼                   ▼
                 ACCEPTED            REJECTED
                    │
                    ▼
             DELIVERY_AGENT
```

### Failed Delivery Workflow

```text
OUT_FOR_DELIVERY
      ↓
Delivery Agent reports failure
      ↓
DeliveryAttempt #1
      ↓
FAILED_DELIVERY
      ↓
Hub Operator retry/reassigns
      ↓
OUT_FOR_DELIVERY
      ↓
Delivery Agent reports failure
      ↓
DeliveryAttempt #2
      ↓
FAILED_DELIVERY
      ↓
PICKUP_FROM_HUB
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

Normal operational assignment is Hub Operator-driven.

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
                    HUB_OPERATOR
                           │
                           ▼
                  Select Same-Hub Agent
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
Administrative Shipment Operations
```

### Admin Assignment API

```http
PATCH /api/admin/shipments/{shipmentId}/assign?deliveryAgentId={agentId}
```

## Hub Operator Flow

```text
Login
   ↓
Receive JWT
   ↓
Operate Within Assigned Hub
   ↓
View / Select Shipment
   ↓
Assign Delivery Agent
   ↓
assignmentStatus = PENDING
   ↓
Delivery Agent Accepts
   ↓
Assignment Status = ACCEPTED
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
Assignment Status = PENDING
   ↓
Accept Assignment
   ↓
Assignment Status = ACCEPTED
   ↓
Pickup
   ↓
In Transit
   ↓
Out For Delivery
   ├──────────────→ Delivered
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

The project has progressed beyond basic authentication and CRUD into a working hub-based shipment operations workflow.

## Current Implemented Flow

```text
Authentication
      ↓
Authorization
      ↓
User Management
      ↓
Hub Management
      ↓
Hub Staff Assignment
      ↓
Shipment Management
      ↓
Server-Side Pricing
      ↓
Automatic Origin / Destination Hub Mapping
      ↓
Tracking History
      ↓
Status Transition Engine
      ↓
Hub Operator Assignment
      ↓
Assignment Status = PENDING
      ↓
Delivery Agent Retrieval
      ↓
Assignment Acceptance
      ↓
Assignment Status = ACCEPTED
      ↓
Pickup
      ↓
In Transit
      ↓
Out For Delivery
      ├──────────────→ Delivered
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

## Current Integration-Tested Branch

The complete failure branch has been manually verified through Postman and MongoDB:

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
RETRY BLOCKED
   ↓
PICKUP_FROM_HUB
```

The final tested shipment state correctly clears the delivery-agent assignment and assignment status after the maximum number of delivery attempts is reached.

## Current Development Focus

```text
Core V1 Operational Workflow
          ↓
Payments / COD
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
| Customer Role | ✅ Completed |
| Admin Role | ✅ Completed |
| Delivery Agent Role | ✅ Completed |
| Hub Operator Role | ✅ Completed |
| User-to-Hub Staff Assignment | ✅ Completed |
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
| Terminal State Protection | ✅ Completed |
| Hub CRUD | ✅ Completed |
| Active Hub Validation | ✅ Completed |
| Automatic Origin Hub Mapping | ✅ Completed |
| Automatic Destination Hub Mapping | ✅ Completed |
| Current Hub Tracking | ✅ Completed |
| Destination Hub Tracking | ✅ Completed |
| Hub Operator Shipment Assignment | ✅ Completed |
| Shipment Reassignment | ✅ Completed |
| Assignment Validation | ✅ Completed |
| Assignment Status Management | ✅ Completed |
| Delivery Agent Assigned Shipments | ✅ Completed |
| Delivery Agent Accept Assignment | ✅ Completed |
| Assignment Ownership Validation | ✅ Completed |
| Assignment History | ✅ Completed |
| Delivery Attempt Tracking | ✅ Completed |
| Failed Delivery Workflow | ✅ Completed |
| Maximum 2 Delivery Attempts | ✅ Completed |
| Retry Restriction After 2 Attempts | ✅ Completed |
| Pickup From Hub | ✅ Completed |
| Delivery Lifecycle | ✅ Completed |
| Postman API Testing | ✅ Completed |
| End-to-End Integration Testing | ✅ Completed |
| COD Collection | ⏱️ Planned |
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
- ✅ Priority affects the calculated price.
- ✅ Distance and package weight participate in pricing.
- ✅ Shipment creation recalculates the price on the server.

## 📦 Shipment Ownership

- ✅ Customer operations are ownership-aware.
- ✅ Authenticated users are resolved from the security context.
- ✅ Sensitive shipment operations validate the requesting user's authority.
- ✅ Delivery Agents can operate only on shipments assigned to them.

## 🏢 Hub Ownership

- ✅ Hub Operators are assigned to a specific hub.
- ✅ Delivery Agents are assigned to a specific hub.
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
- ✅ Delivery Agents must have the `DELIVERY_AGENT` role.
- ✅ Delivery Agents must belong to the Hub Operator's hub.
- ✅ Existing assignments are validated.
- ✅ New assignments start with `assignmentStatus = PENDING`.
- ✅ Assignment status is separate from shipment status.
- ✅ Only the Delivery Agent assigned to the shipment can accept the assignment.
- ✅ Assignment acceptance is allowed only while `assignmentStatus = PENDING`.
- ✅ Assignment acceptance changes `PENDING → ACCEPTED`.
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
- ⏱️ Expanded automated integration testing
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
- ✅ Assignment ownership validation
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
- ⏱️ Accepted assignments
- ⏱️ Delivery-agent workload
- ⏱️ Hub workload
- ⏱️ Revenue / pricing metrics
- ⏱️ COD collection status
- ⏱️ Stuck shipments

---

# 🏢 Hub Operations — Current & Future Design

Hub operations now form part of the implemented V1 foundation.

## Current V1 Hub Model

```text
                 ADMIN
                   │
          ┌────────┴────────┐
          ▼                 ▼
   HUB_OPERATOR       DELIVERY_AGENT
          │                 │
          └────────┬────────┘
                   ▼
                  HUB
                   │
                   ▼
             CURRENT HUB
                   │
                   ▼
                SHIPMENT
```

### Implemented

- ✅ Hub CRUD
- ✅ Active/inactive hubs
- ✅ Hub address and city
- ✅ Hub Operator membership
- ✅ Delivery Agent membership
- ✅ Shipment current-hub relationship
- ✅ Shipment destination-hub relationship
- ✅ Automatic city-to-hub mapping
- ✅ Same-hub Delivery Agent assignment validation
- ✅ Hub Operator shipment ownership validation

## Future Hub Operations

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
Destination / Next Hub
   ↓
Delivery Agent
```

Potential future responsibilities include:

- ⏱️ Shipment receiving/scanning
- ⏱️ Shipment outbound scanning
- ⏱️ Multi-hop hub routing
- ⏱️ Hub inventory
- ⏱️ Route management
- ⏱️ Hub-level dashboards
- ⏱️ Operational scan history

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
- ⏱️ Assignment created
- ⏱️ Assignment accepted
- ⏱️ Assignment rejected
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
├── distance
├── cost
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
   │
   ├──────────────► PRICING
   │
   ├──────────────► CURRENT HUB
   │                    │
   │                    └── HUB_OPERATOR
   │
   ├──────────────► DESTINATION HUB
   │
   └──────────────► DELIVERY AGENT ASSIGNMENT
                          │
                          ├── assignedDeliveryAgentId
                          └── assignmentStatus
```

### Operational Hub Ownership

```text
HUB_OPERATOR.hubId
        =
SHIPMENT.currentHubId
        =
DELIVERY_AGENT.hubId
```

The authenticated customer is used to determine customer ownership-sensitive operations instead of trusting arbitrary user identifiers supplied by the client.

Hub Operators additionally operate only within their assigned hub, and Delivery Agent assignment is restricted to agents belonging to that hub.

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

### Delivery Attempt State

Delivery attempts are persisted separately from the shipment status.

```text
OUT_FOR_DELIVERY
      ↓
FAILED_DELIVERY
      ↓
Attempt #1
      ↓
Retry
      ↓
OUT_FOR_DELIVERY
      ↓
FAILED_DELIVERY
      ↓
Attempt #2
      ↓
PICKUP_FROM_HUB
```

The assignment state machine and delivery-attempt tracking are separate from the shipment state machine.

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
8. Hub Operator assigns eligible same-hub Delivery Agent
             ↓
9. Assignment status becomes PENDING
             ↓
10. Delivery Agent accepts assignment
             ↓
11. Assignment status becomes ACCEPTED
             ↓
12. Shipment progresses through valid delivery states
             ↓
13. Delivery Agent reports pickup / transit / out-for-delivery
             ↓
14. Shipment is delivered
             OR
15. Delivery attempt fails
             ↓
16. DeliveryAttempt is recorded
             ↓
17. Hub Operator retries / reassigns if attempts < 2
             ↓
18. Second failure
             ↓
19. Shipment becomes available for PICKUP_FROM_HUB
             ↓
20. Tracking history preserves the complete operational timeline
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
- ✅ Assignment ownership checks
- ✅ Hub ownership checks
- ✅ Same-hub Delivery Agent validation
- ✅ Valid assignment status transitions
- ✅ Delivery-attempt limit validation
- ✅ Failed-delivery reason validation

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

The application is currently configured for local development and the core V1 operational workflow has been integration-tested.

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
| 🏢 Hub Management | ✅ Completed |
| 🗺️ Automatic Hub Mapping | ✅ Completed |
| 🚚 Delivery Assignment | ✅ Completed |
| 🔄 Assignment Status Management | ✅ Completed |
| 🧾 Assignment History | ✅ Completed |
| 🤝 Delivery Agent Assignment Acceptance | ✅ Completed |
| 🧪 Delivery Attempt Tracking | ✅ Completed |
| ❌ Failed Delivery Workflow | ✅ Completed |
| 🔁 Retry / Reassignment Workflow | ✅ Completed |
| 🏢 Pickup From Hub | ✅ Completed |
| 🚛 Delivery Operations | ✅ Completed |
| 🧪 End-to-End Integration Testing | ✅ Completed |
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
