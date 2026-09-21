# 🚚 Logistics Platform

### Production-Style Logistics & Shipment Management Platform

A production-oriented backend platform designed to simulate a real-world logistics and shipment management system — covering customer authentication, shipment creation, server-side pricing, shipment tracking, operational workflows, delivery management, hubs, notifications, payments and more.

Built with **Java 21, Spring Boot, Spring Security, JWT, OAuth 2.0, MongoDB and REST APIs**, with a strong focus on clean architecture, secure business workflows, validation, maintainability and production-oriented backend engineering.

---

## 📌 Project Overview

The **Logistics Platform** is a modular monolithic backend designed to model the core operations of a modern logistics company.

The platform is being developed around four primary operational roles:

| Role                | Responsibility                                                         |
| ------------------- | ---------------------------------------------------------------------- |
| 👤 `CUSTOMER`       | Create and manage shipments, track deliveries and manage profile       |
| 🚚 `DELIVERY_AGENT` | Handle assigned deliveries and update delivery progress                |
| 🏢 `HUB_OPERATOR`   | Manage hub operations, shipment scans and local routing                |
| 🛡️ `ADMIN`         | Manage users, pricing, hubs, assignments and operational configuration |

The long-term shipment workflow is:

```text
Customer
   │
   ▼
Create Shipment
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
Hub Processing
   │
   ▼
OUT_FOR_DELIVERY
   │
   ▼
DELIVERED
```

Exceptional states:

```text
CANCELLED
FAILED_DELIVERY
RETURNED
```

---

# ✨ Key Features

## 🔐 Authentication & Authorization

The authentication system provides secure account management and protected APIs.

### Implemented

* User registration
* User login
* Login using username or email
* JWT access tokens
* JWT refresh tokens
* JWT authentication filter
* BCrypt password hashing
* Role-based authorization
* Account enable/disable
* Authentication provider tracking
* Google OAuth 2.0 authentication
* Separate local and Google authentication flows
* Protected admin endpoints
* Current authenticated user resolution

### Supported Roles

```text
CUSTOMER
DELIVERY_AGENT
HUB_OPERATOR
ADMIN
```

### Authentication Providers

```text
LOCAL
GOOGLE
```

---

# 👤 User Management

## Implemented

Customers can:

* Register an account
* Login using username or email
* Login using Google
* Receive JWT access and refresh tokens
* Access protected customer APIs
* View their profile
* Create shipments associated with their account

The platform stores the authentication provider and role for each user.

Example:

```text
User
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

### Planned

* Admin user management
* Activate/deactivate users
* Delivery-agent management
* Hub-operator management
* Profile update
* Password change
* Account recovery

---

# 📦 Shipment Management

Shipment management is one of the core implemented modules.

## Implemented

Customers can create shipments containing:

* Sender address
* Receiver address
* Sender details
* Receiver details
* Package weight
* Package dimensions
* Package description
* Delivery priority
* Distance
* COD selection

Every shipment receives a unique tracking number.

Example:

```text
TRK-6ACAD1D4D371
```

The shipment stores:

```text
Shipment
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

---

# 💰 Pricing Engine

The platform uses a dedicated backend pricing engine rather than allowing customers to submit their own final shipping price.

### Pricing Architecture

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
Shipment Price
```

### Current Pricing Formula

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
COD Handling Fee (if applicable)
     ↓
Final Price
```

### Current Priority Multipliers

```text
STANDARD → 1.0×
EXPRESS  → 1.5×
URGENT   → 2.0×
```

### Example Configuration

```text
Base Charge       = ₹50
Per KG Rate       = ₹20
Per KM Rate       = ₹2
STANDARD          = 1.0×
EXPRESS           = 1.5×
URGENT            = 2.0×
COD Handling Fee  = ₹30
```

For example:

```text
Weight       = 2.5 KG
Distance     = 100 KM
Priority     = STANDARD
COD          = No

₹50 + (2.5 × ₹20) + (100 × ₹2)

= ₹300
```

### Important Business Rule

The customer **does not control the final price**.

The server calculates the price using the currently active pricing configuration.

This prevents clients from manipulating the shipment cost through the API.

---

# ⚙️ Admin Pricing Configuration

Administrators can configure the active pricing rules.

### Implemented APIs

| Method | Endpoint                    | Access  | Status        |
| ------ | --------------------------- | ------- | ------------- |
| `POST` | `/api/admin/pricing`        | `ADMIN` | ✅ Implemented |
| `GET`  | `/api/admin/pricing/active` | `ADMIN` | ✅ Implemented |

When a new pricing configuration is created:

```text
Old Active Configuration
          ↓
       inactive
          ↓
New Configuration
          ↓
        active
```

This allows the system to maintain historical pricing configurations while having only one active configuration at a time.

---

# 🧮 Price Estimation

Customers can calculate an estimated shipment price before creating a shipment.

### Implemented API

```http
POST /api/shipments/estimate
```

Example request:

```json
{
    "weight": 2.5,
    "distanceKm": 100,
    "priority": "STANDARD",
    "cod": false
}
```

Example response:

```json
{
    "estimatedPrice": 300
}
```

The same pricing service is used during actual shipment creation so that pricing logic is centralized.

---

# 🔄 Shipment Lifecycle

The platform is designed around a controlled shipment state machine.

### Main Lifecycle

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

### Exceptional States

```text
CANCELLED
FAILED_DELIVERY
RETURNED
```

### Current Cancellation Rule

A customer can cancel a shipment **only while its current status is `CREATED`**.

```text
CREATED
   │
   ├──────────────► CANCELLED
   │
   └──────────────► Normal shipment lifecycle
```

Once cancelled:

```text
CANCELLED
```

is treated as a terminal state and should not continue through the normal delivery lifecycle.

### Planned

* Centralized shipment status transition validation
* Admin status override
* Hub-based transitions
* Delivery-agent transitions
* Failed delivery workflow
* Return workflow
* Rescheduling

---

# 📍 Shipment Tracking

The platform maintains a **tracking history**, rather than storing only the latest shipment status.

Each tracking event can contain:

* Status
* Timestamp
* Location
* Description
* Performed by
* Notes

Example:

```text
TRK-6ACAD1D4D371

✓ CREATED
  Shipment created
  Yamunanagar
  22 Sep 2026

✓ CANCELLED
  Shipment cancelled
  Yamunanagar
  22 Sep 2026
```

### Implemented Tracking API

```http
GET /api/shipments/tracking/{trackingNumber}/history
```

Example response:

```json
{
    "trackingNumber": "TRK-6ACAD1D4D371",
    "status": "CANCELLED",
    "trackingHistory": [
        {
            "status": "CREATED",
            "timestamp": "2026-09-22T00:04:46.715",
            "location": "Yamunanagar",
            "description": "Shipment created",
            "performedBy": "customer"
        },
        {
            "status": "CANCELLED",
            "timestamp": "2026-09-22T00:05:40.285",
            "location": "Yamunanagar",
            "description": "Shipment cancelled",
            "performedBy": "customer"
        }
    ]
}
```

This event-based approach provides a foundation for future real-time shipment tracking.

---

# 🔎 Shipment Retrieval & Customer Shipments

### Implemented

Shipment retrieval APIs include:

| Method | Endpoint                                           | Purpose                                |
| ------ | -------------------------------------------------- | -------------------------------------- |
| `GET`  | `/api/shipments/{id}`                              | Get shipment by ID                     |
| `GET`  | `/api/shipments/tracking/{trackingNumber}`         | Get shipment by tracking number        |
| `GET`  | `/api/shipments/tracking/{trackingNumber}/history` | Get tracking history                   |
| `GET`  | `/api/shipments/my`                                | Get authenticated customer's shipments |

### Planned

* Pagination
* Status filtering
* Date filtering
* Search
* Sorting
* Customer shipment history improvements

---

# ✏️ Shipment Updates

Customers can update shipment information while the shipment is still in the appropriate early lifecycle state.

Supported shipment information includes:

* Sender address
* Receiver address
* Package details
* Priority

### Planned Improvements

* Stronger state-based update restrictions
* Price re-estimation when price-affecting fields change
* Audit logging for updates
* Field-level update rules

---

# ❌ Shipment Cancellation

Customers can cancel their own shipment while its status is:

```text
CREATED
```

The cancellation process:

```text
Request Cancellation
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
        ↓
Return Response
```

The cancellation is also recorded in tracking history.

---

# 🚚 Delivery Agent Management

The platform will support delivery agents responsible for the final-mile delivery process.

### Planned Capabilities

* Delivery-agent login
* View assigned shipments
* View delivery queue
* Accept assignment
* Reject assignment
* Confirm pickup
* Mark shipment in transit
* Mark out for delivery
* Mark delivered
* Add delivery notes
* Report failed delivery
* Submit delivery proof
* Collect COD
* View personal delivery statistics

---

# 🏢 Hub Management

Hubs will represent physical logistics facilities through which shipments move.

Example:

```text
Origin Hub
    ↓
Intermediate Hub
    ↓
Destination Hub
    ↓
Local Delivery
```

### Planned Capabilities

* Hub CRUD
* Hub operator management
* Shipment arrival scan
* Shipment departure scan
* Hub inventory
* Shipment routing
* Next-hub assignment
* Local delivery-agent assignment
* Hub performance statistics

---

# 👨‍💼 Admin Operations

Administrators will control platform-level operational configuration.

### Implemented

* Admin authentication
* Admin role authorization
* Admin pricing configuration
* Active pricing configuration retrieval

### Planned

* User management
* Shipment management
* Hub CRUD
* Delivery-agent management
* Hub-operator management
* Manual shipment assignment
* Delivery-agent reassignment
* Shipment monitoring
* Operational reports
* Audit logs
* Failed/stuck shipment monitoring
* Pricing configuration management improvements

---

# 🗺️ Maps & Distance Integration

The current V1 pricing flow accepts `distanceKm` as an input.

A future maps integration will allow the platform to calculate distance dynamically.

Planned workflow:

```text
Pickup Address
       ↓
Geocoding Service
       ↓
Latitude / Longitude

Delivery Address
       ↓
Geocoding Service
       ↓
Latitude / Longitude

       ↓
Distance / Route Calculation
       ↓
Distance
       ↓
Pricing Engine
```

Potential future integrations include:

* Geocoding
* Distance calculation
* Route calculation
* ETA estimation
* Delivery-agent location tracking

---

# ⏱️ Estimated Delivery Time

A future ETA engine will calculate estimated delivery times using factors such as:

* Distance
* Shipment priority
* Hub processing time
* Current shipment status
* Delivery workflow
* Operational delays

Example:

```text
Shipment
   ↓
Distance
   +
Priority
   +
Hub Processing
   +
Delivery Stage
   ↓
Estimated Delivery Time
```

---

# 💳 Payments & COD

Payment functionality is planned as a dedicated module.

## COD

Planned COD lifecycle:

```text
COD_PENDING
     ↓
COD_COLLECTED
     ↓
SETTLED
```

## Online Payments

The architecture will use a payment abstraction:

```text
PaymentGateway
      │
      ├── Mock/Test Gateway
      │
      └── Future Real Gateway
```

Planned online payment states:

```text
PENDING
PAID
FAILED
REFUNDED
```

This allows a real payment provider to be integrated later without tightly coupling payment logic to shipment services.

---

# 📧 Notifications

Important shipment events will eventually generate notifications.

Planned events:

```text
Shipment Created
       ↓
Price Confirmed
       ↓
Shipment Picked Up
       ↓
Hub Arrival
       ↓
Out for Delivery
       ↓
Delivered
```

Additional notifications:

```text
Failed Delivery
Returned Shipment
COD Collected
Payment Successful
Payment Failed
```

Email will be implemented first, with SMS/push notifications considered for future versions.

---

# 🧾 Invoice & Receipt

Customers will eventually be able to download a shipment invoice/receipt.

The invoice will contain:

* Customer details
* Tracking number
* Sender
* Receiver
* Package details
* Priority
* Shipping cost
* COD information
* Payment information
* Shipment date

Planned output:

```text
PDF Invoice
```

---

# ⭐ Delivery Rating

After successful delivery, customers will be able to rate their delivery experience.

Planned functionality:

```text
Rating: 1–5 Stars
Feedback: Optional
```

Business rule:

```text
Only DELIVERED shipments
        ↓
Customer can rate
        ↓
One rating per shipment
```

---

# 🔎 Search & Filtering

Operational search and filtering will be introduced as the shipment dataset grows.

Planned filters:

* Tracking number
* Customer
* Shipment status
* Hub
* Delivery agent
* Priority
* Date range

MongoDB indexes will be added for frequently queried fields.

---

# ⏰ Scheduled Background Jobs

Spring scheduled jobs will support background operational tasks.

Planned jobs include:

* Detect delayed shipments
* Detect stuck shipments
* Monitor overdue deliveries
* Send delayed-shipment notifications
* Update ETA information
* Monitor pending COD settlement
* Generate periodic operational reports

---

# 📊 Reports & Analytics

The platform will eventually provide operational reporting.

Planned metrics:

| Metric                 | Purpose                 |
| ---------------------- | ----------------------- |
| Shipments / Day        | Shipment volume         |
| Revenue                | Financial performance   |
| Delivery Success Rate  | Delivery quality        |
| Failed Delivery Rate   | Operational issues      |
| Average Delivery Time  | Delivery efficiency     |
| Agent Performance      | Delivery-agent analysis |
| Hub Performance        | Hub operations          |
| COD Collected          | COD monitoring          |
| Pending COD Settlement | Settlement monitoring   |

---

# 📝 Audit Logging

A production-oriented audit system will record important operational actions.

Example:

```text
WHO
 ↓
WHAT
 ↓
WHEN
 ↓
WHERE / CONTEXT
```

Example audit event:

```text
Admin
  ↓
Changed shipment assignment
  ↓
22 Sep 2026 14:30
  ↓
Shipment TRK-XXXXXXXXXX
```

Planned audit events include:

* Status changes
* User management
* Pricing changes
* Shipment reassignment
* Hub operations
* Admin overrides

---

# 🏗️ Architecture

The project follows a **modular monolithic architecture**.

```text
                       Client / Frontend
                              │
                              ▼
                         REST APIs
                              │
             ┌────────────────┼────────────────┐
             │                │                │
             ▼                ▼                ▼
       Authentication      Shipments        Admin
             │                │                │
       ┌─────┴─────┐     ┌────┴────┐      ┌───┴────┐
       │           │     │         │      │        │
      JWT       Google  Pricing  Tracking Users  Config
                         │         │
                         └────┬────┘
                              │
                              ▼
                           MongoDB
```

The project intentionally uses a **modular monolith for V1** instead of immediately splitting the system into microservices.

This keeps development and deployment manageable while maintaining clear domain boundaries that can be separated into services later if required.

---

# 🧩 Backend Architecture

The backend follows a layered architecture:

```text
Controller
     ↓
Service
     ↓
Repository
     ↓
MongoDB
```

Supporting layers:

```text
DTO
Mapper
Entity
Enum
Security
OAuth
Configuration
Validation
Exception Handling
```

Business logic is kept inside services instead of controllers.

---

# 📁 Project Structure

```text
src/
└── main/
    ├── java/
    │   └── com/lovish/logistic/platform/
    │
    │       ├── config/
    │       ├── controller/
    │       ├── dto/
    │       ├── entity/
    │       ├── enums/
    │       ├── exception/
    │       ├── mapper/
    │       ├── oauth/
    │       ├── repository/
    │       ├── security/
    │       └── service/
    │
    └── resources/
        └── application.properties
```

The structure will evolve as additional modules are introduced.

---

# 🛡️ Security

Security is a core part of the platform.

### Implemented

* Spring Security
* JWT authentication
* JWT request filtering
* BCrypt password hashing
* Google OAuth 2.0
* Role-based authorization
* Protected REST endpoints
* Account enabled/disabled support
* Input validation
* Authentication provider tracking
* Current-user resolution

### Planned Security Improvements

* Refresh-token rotation
* Token revocation
* Rate limiting
* Security headers
* More granular permissions
* Audit logging
* Production secret management
* Security-focused integration tests

Sensitive credentials should never be committed to GitHub.

Example environment-based configuration:

```properties
spring.data.mongodb.uri=${MONGODB_URI}

spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}

spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}

jwt.secret=${JWT_SECRET}
```

---

# 🔑 JWT Authentication Flow

```text
Login
  ↓
Validate Credentials
  ↓
Load User
  ↓
Generate Access Token
  ↓
Generate Refresh Token
  ↓
Return Authentication Response
```

Protected request:

```text
Client
  ↓
Authorization: Bearer <JWT>
  ↓
JwtAuthenticationFilter
  ↓
Extract Username
  ↓
Load User
  ↓
Validate JWT
  ↓
Create Authentication
  ↓
Check Authorization
  ↓
Allow / Reject Request
```

---

# 🌐 Google OAuth 2.0 Flow

```text
Client
   ↓
/oauth2/authorization/google
   ↓
Google Authentication
   ↓
Google Callback
   ↓
OAuth Success Handler
   ↓
Find Existing User
   │
   ├── Existing User
   │
   └── New User
          ↓
     Create Customer
          ↓
    GOOGLE Provider
          ↓
      Generate JWT
          ↓
     Authentication
```

---

# 🗄️ Database

## MongoDB

MongoDB is used as the primary database.

Current and planned collections include:

```text
users
pricing_config
shipments
hubs
notifications
payments
audit_logs
```

The exact collection structure will evolve as each module is implemented.

### Current Shipment Data Model

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
 ├── trackingHistory[]
 ├── assignedDeliveryAgentId
 ├── createdAt
 └── updatedAt
```

---

# 📡 API Overview

## 🔐 Authentication APIs

| Method | Endpoint                       | Access         | Status        |
| ------ | ------------------------------ | -------------- | ------------- |
| `POST` | `/auth/register`               | Public         | ✅ Implemented |
| `POST` | `/auth/login`                  | Public         | ✅ Implemented |
| `GET`  | `/oauth2/authorization/google` | Public         | ✅ Implemented |
| `GET`  | `/login/oauth2/code/google`    | OAuth Callback | ✅ Implemented |

---

## 📦 Shipment APIs

| Method  | Endpoint                                           | Access        | Status        |
| ------- | -------------------------------------------------- | ------------- | ------------- |
| `POST`  | `/api/shipments`                                   | CUSTOMER      | ✅ Implemented |
| `POST`  | `/api/shipments/estimate`                          | CUSTOMER      | ✅ Implemented |
| `GET`   | `/api/shipments/{id}`                              | Authenticated | ✅ Implemented |
| `GET`   | `/api/shipments/tracking/{trackingNumber}`         | Authenticated | ✅ Implemented |
| `GET`   | `/api/shipments/tracking/{trackingNumber}/history` | Authenticated | ✅ Implemented |
| `GET`   | `/api/shipments/my`                                | CUSTOMER      | ✅ Implemented |
| `PUT`   | `/api/shipments/{id}`                              | CUSTOMER      | ✅ Implemented |
| `PATCH` | `/api/shipments/{id}/cancel`                       | CUSTOMER      | ✅ Implemented |

---

## 💰 Admin Pricing APIs

| Method | Endpoint                    | Access | Status        |
| ------ | --------------------------- | ------ | ------------- |
| `POST` | `/api/admin/pricing`        | ADMIN  | ✅ Implemented |
| `GET`  | `/api/admin/pricing/active` | ADMIN  | ✅ Implemented |

---

## 🏢 Hub APIs

| Method   | Endpoint               | Access | Status    |
| -------- | ---------------------- | ------ | --------- |
| `POST`   | `/api/admin/hubs`      | ADMIN  | ⬜ Planned |
| `GET`    | `/api/admin/hubs`      | ADMIN  | ⬜ Planned |
| `PUT`    | `/api/admin/hubs/{id}` | ADMIN  | ⬜ Planned |
| `DELETE` | `/api/admin/hubs/{id}` | ADMIN  | ⬜ Planned |

---

## 🚚 Delivery APIs

| Method  | Endpoint                              | Access         | Status    |
| ------- | ------------------------------------- | -------------- | --------- |
| `GET`   | `/api/delivery/shipments`             | DELIVERY_AGENT | ⬜ Planned |
| `PATCH` | `/api/delivery/shipments/{id}/accept` | DELIVERY_AGENT | ⬜ Planned |
| `PATCH` | `/api/delivery/shipments/{id}/status` | DELIVERY_AGENT | ⬜ Planned |
| `POST`  | `/api/delivery/shipments/{id}/notes`  | DELIVERY_AGENT | ⬜ Planned |

> API endpoints will continue to evolve as additional modules are implemented.

---

# 📊 Development Status

## 🟢 Completed

| Module / Feature              | Status     |
| ----------------------------- | ---------- |
| Spring Boot Project Setup     | ✅ Complete |
| Maven Configuration           | ✅ Complete |
| Java 21                       | ✅ Complete |
| MongoDB Configuration         | ✅ Complete |
| User Entity                   | ✅ Complete |
| User Repository               | ✅ Complete |
| Local Registration            | ✅ Complete |
| Local Login                   | ✅ Complete |
| Username / Email Login        | ✅ Complete |
| BCrypt Password Hashing       | ✅ Complete |
| JWT Access Token              | ✅ Complete |
| JWT Refresh Token             | ✅ Complete |
| JWT Authentication Filter     | ✅ Complete |
| Role-Based Authorization      | ✅ Complete |
| `CUSTOMER` Role               | ✅ Complete |
| `ADMIN` Role                  | ✅ Complete |
| `DELIVERY_AGENT` Role         | ✅ Complete |
| `HUB_OPERATOR` Role           | ✅ Complete |
| `LOCAL` Auth Provider         | ✅ Complete |
| `GOOGLE` Auth Provider        | ✅ Complete |
| Google OAuth 2.0              | ✅ Complete |
| Shipment Entity               | ✅ Complete |
| Shipment Repository           | ✅ Complete |
| Shipment DTOs                 | ✅ Complete |
| Address Validation            | ✅ Complete |
| Package Validation            | ✅ Complete |
| Shipment Creation             | ✅ Complete |
| Tracking Number Generation    | ✅ Complete |
| Shipment Price Calculation    | ✅ Complete |
| Pricing Configuration         | ✅ Complete |
| Active Pricing Configuration  | ✅ Complete |
| Admin Pricing API             | ✅ Complete |
| Price Estimate API            | ✅ Complete |
| Shipment Retrieval            | ✅ Complete |
| Customer Shipment Retrieval   | ✅ Complete |
| Shipment Update               | ✅ Complete |
| Shipment Cancellation         | ✅ Complete |
| Tracking History              | ✅ Complete |
| Tracking Event Creation       | ✅ Complete |
| Shipment Ownership Validation | ✅ Complete |
| Postman API Testing           | ✅ Complete |

---

# 🟡 In Progress / Next Development Phase

| Module / Feature                       | Status         |
| -------------------------------------- | -------------- |
| Shipment Status Transition Engine      | 🚧 In Progress |
| Global Exception Handling Improvements | 🚧 In Progress |
| Comprehensive Automated Testing        | 🚧 In Progress |
| API Documentation / Swagger            | 🚧 In Progress |
| MongoDB Indexing                       | 🚧 In Progress |
| Shipment Pagination                    | 🚧 In Progress |
| Shipment Search & Filtering            | 🚧 In Progress |

---

# 🔵 Planned Features

| Module / Feature             | Status    |
| ---------------------------- | --------- |
| Hub Management               | ⬜ Planned |
| Hub Operator Operations      | ⬜ Planned |
| Shipment Hub Routing         | ⬜ Planned |
| Shipment Scan-In / Scan-Out  | ⬜ Planned |
| Delivery Agent Assignment    | ⬜ Planned |
| Delivery Agent Workflow      | ⬜ Planned |
| Failed Delivery Management   | ⬜ Planned |
| Return Shipment Workflow     | ⬜ Planned |
| Delivery Proof / OTP         | ⬜ Planned |
| COD Collection               | ⬜ Planned |
| COD Settlement               | ⬜ Planned |
| Online Payment Gateway       | ⬜ Planned |
| Payment Abstraction          | ⬜ Planned |
| Maps / Geocoding Integration | ⬜ Planned |
| Distance Calculation         | ⬜ Planned |
| ETA Calculation              | ⬜ Planned |
| Email Notifications          | ⬜ Planned |
| SMS / Push Notifications     | ⬜ Planned |
| Invoice / PDF Receipt        | ⬜ Planned |
| Delivery Rating              | ⬜ Planned |
| Admin Reports                | ⬜ Planned |
| Audit Logging                | ⬜ Planned |
| Scheduled Background Jobs    | ⬜ Planned |
| Auto Assignment              | ⬜ Planned |
| Operational Monitoring       | ⬜ Planned |
| Dockerization                | ⬜ Planned |
| Production Deployment        | ⬜ Planned |

---

# 🧪 Testing Strategy

Testing is performed throughout development rather than being postponed until the end.

## Authentication Testing

Planned and implemented scenarios include:

* Registration validation
* Duplicate username
* Duplicate email
* Invalid credentials
* JWT validation
* Expired JWT
* Role authorization
* Google OAuth
* Disabled users

## Shipment Testing

Testing includes:

* Shipment creation
* Address validation
* Package validation
* Price estimation
* Server-side pricing
* Tracking number generation
* Shipment retrieval
* Shipment ownership
* Shipment update
* Shipment cancellation
* Tracking history

## Planned Operational Testing

* Status transition validation
* Hub operations
* Agent assignment
* Delivery workflow
* Failed delivery
* COD
* Payment processing
* Notifications

---

# 📮 API Testing with Postman

Postman is used for manual API testing during development.

Example authentication request:

```http
POST /auth/login
```

Protected APIs use:

```http
Authorization: Bearer <access-token>
```

Example pricing request:

```http
POST /api/shipments/estimate
```

Example tracking request:

```http
GET /api/shipments/tracking/{trackingNumber}/history
```

Postman collections will evolve alongside the API.

---

# 🧱 Production-Oriented Engineering Goals

The project is being developed with production-oriented engineering practices rather than only implementing basic CRUD operations.

Key goals include:

* Layered architecture
* Separation of concerns
* DTO-based API contracts
* Mapper-based entity conversion
* Centralized business logic
* Role-based authorization
* Server-side validation
* Exception handling
* Logging
* MongoDB indexes
* Pagination
* Search and filtering
* API documentation
* Automated testing
* Environment-based configuration
* Secure secret management
* Docker support
* Deployment readiness
* Monitoring and operational visibility

---

# ⚙️ Local Setup

## Prerequisites

Install:

* Java 21
* Maven
* MongoDB
* Git
* Postman
* Spring Tool Suite / IntelliJ IDEA / Eclipse

---

## Clone the Repository

```bash
git clone https://github.com/iLovishSaluja/logistics-platform.git
cd logistics-platform
```

---

## Configure Environment Variables

Do not commit real credentials or secrets to GitHub.

Example:

```properties
spring.data.mongodb.uri=${MONGODB_URI}

spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}

spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}

jwt.secret=${JWT_SECRET}
```

---

## Build the Project

Using Maven Wrapper:

```bash
mvnw clean install
```

On Windows:

```bash
mvnw.cmd clean install
```

---

## Run the Project

```bash
mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The Logistics Platform runs on:

```text
http://localhost:8081
```

---

# 🔧 Configuration

The application is configured to run independently from other local backend projects.

Current development port:

```properties
server.port=8081
```

The project is designed to keep environment-specific configuration outside the source code wherever possible.

---

# 📈 Future Architecture

The current architecture is intentionally a modular monolith.

As the platform grows, individual modules could eventually be separated into independent services if required.

Potential future services:

```text
API Gateway
     │
     ├── Authentication Service
     ├── Shipment Service
     ├── Pricing Service
     ├── Tracking Service
     ├── Hub Service
     ├── Delivery Service
     ├── Payment Service
     ├── Notification Service
     └── Reporting Service
```

For V1, however, these modules remain inside a single Spring Boot application to reduce unnecessary operational complexity.

---

# 🗺️ Development Roadmap

```text
Phase 1
───────
Project Setup
Authentication
JWT
Google OAuth
Security
        ✅

Phase 2
───────
Shipment Management
Pricing
Price Estimation
Tracking History
Cancellation
        ✅

Phase 3
───────
Status Transition Engine
Pagination
Filtering
Search
Swagger
Testing
        🚧

Phase 4
───────
Hubs
Hub Operators
Delivery Agents
Assignments
        ⬜

Phase 5
───────
COD
Payments
Notifications
Invoice
Rating
        ⬜

Phase 6
───────
Maps
Distance
ETA
Reports
Audit Logs
Scheduled Jobs
        ⬜

Phase 7
───────
Docker
Deployment
Monitoring
Production Hardening
        ⬜
```

---

# 📌 Current Project State

The project has progressed beyond basic authentication.

The current backend already contains working implementations for:

```text
Authentication
       ↓
Authorization
       ↓
User Management
       ↓
Shipment Management
       ↓
Pricing Configuration
       ↓
Price Estimation
       ↓
Shipment Pricing
       ↓
Shipment Cancellation
       ↓
Tracking History
```

The next development phase focuses on turning these foundations into a more complete operational logistics platform through **status transition enforcement, pagination, search/filtering, hubs, delivery-agent workflows, testing and API documentation**.

---

# 🤝 Contributing

This project is primarily being developed as a portfolio and learning project focused on production-oriented Java backend engineering.

Suggestions, issues and improvements are welcome.

---

# 📄 License

This project is currently unlicensed and intended for personal/educational and portfolio purposes.

A formal open-source license such as MIT can be added in the future if required.

---

# 👤 Author

**Lovish Saluja**

### Java Backend Developer

```text
Java
Spring Boot
Spring Security
MongoDB
REST APIs
JWT
OAuth 2.0
```

---

<p align="center">

### 🚚 Logistics Platform

**Building a production-style logistics backend with Java & Spring Boot.**

⭐ If you find the project interesting, consider giving it a star!

</p>
