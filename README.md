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

  📚 Table of Contents

-- 🎯 Project Overview
-- ✨ Highlights
-- 🛠️ Technology Stack
-- 🏗️ Architecture
-- 👥 User Roles
-- 🔐 Authentication & Authorization
-- 👤 User Management
-- 📦 Shipment Management
-- 💰 Server-Side Pricing
-- 🧮 Price Estimation
-- 🔄 Shipment Lifecycle
-- 🧠 Status Transition Engine
-- 📍 Shipment Tracking
-- 🔎 Shipment Retrieval
-- ✏️ Shipment Updates
-- ❌ Shipment Cancellation
-- 🚚 Delivery Agent Management
-- 🚛 Delivery Agent Workflow
-- 🏢 Hub Management
-- 💳 Payments & COD
-- 🔔 Notifications
-- 📄 Invoice & Rating
-- 🔐 API Security
-- 🧪 Validation & Error Handling
-- 🧪 Testing
-- 📡 API Overview
-- 📊 Development Status
-- 🚧 Current Development
-- ⏱️ Planned Features
-- 🗺️ Development Roadmap
-- 🧱 Production Engineering
-- ⚙️ Local Setup
-- 🔧 Configuration
-- 📈 Future Architecture
-- 📌 Current Project State
-- 🤝 Contributing
-- 📄 License
-- 👤 Author

🎯 Project Overview

Logistics Platform is a backend-focused logistics and shipment management system designed as a modular monolith.

The project focuses on implementing the core backend capabilities required by a modern logistics company while maintaining clean separation between:

-- API controllers
-- Business services
-- Data repositories
-- DTOs
-- Mapping logic
-- Security
-- Validation
-- Exception handling
-- Shipment workflow
-- Pricing logic

The platform currently provides functionality for:

-- Secure user authentication
-- JWT access and refresh tokens
-- Google OAuth 2.0 authentication
-- Role-based authorization
-- Shipment creation and management
-- Tracking-number generation
-- Server-side shipment pricing
-- Price estimation
-- Shipment cancellation
-- Shipment tracking history
-- Controlled shipment status transitions
-- Delivery-agent assignment
-- Delivery-agent assigned-shipment retrieval
-- Centralized validation
-- Centralized exception handling
-- Manual API testing through Postman

The architecture is intentionally kept as a modular monolith for V1.

This avoids unnecessary distributed-system complexity while allowing the project to evolve into a larger logistics platform.

✨ Highlights

<div align="center">

Area	Status
🔐 Authentication	🟢 Completed
🛡️ Authorization	🟢 Completed
📦 Shipment Management	🟢 Completed
💰 Server-Side Pricing	🟢 Completed
🧮 Price Estimation	🟢 Completed
📍 Tracking History	🟢 Completed
🔄 Status Transition Engine	🟢 Completed
🚚 Delivery-Agent Assignment	🟢 Completed
🚛 Delivery Operations	🔄 In Progress
🏢 Hub Operations	⏱️ Planned
💳 Payments	⏱️ Planned
🔔 Notifications	⏱️ Planned
📄 Invoices	⏱️ Planned
⭐ Ratings	⏱️ Planned
🧪 Automated Testing	⏱️ Planned
🐳 Dockerization	⏱️ Planned
📊 Monitoring	⏱️ Planned

</div>

🛠️ Technology Stack
Backend

-- ☕ Java 21 — Primary backend language
-- 🌱 Spring Boot — Application framework
-- 🔐 Spring Security — Authentication and authorization
-- 🎟️ JWT — Access and refresh token authentication
-- 🔑 OAuth 2.0 — Google authentication
-- 📡 REST APIs — Client-server communication
-- 📦 Maven — Build and dependency management
-- 📝 SLF4J — Application logging

Database

-- 🍃 MongoDB — Primary database
-- 📑 MongoDB repositories — Data access layer
-- 🔎 Repository-based querying — Shipment and user retrieval

Development & Testing

-- 🧪 Postman — API testing
-- 🛠️ Spring Tool Suite / IntelliJ IDEA / Eclipse — Development
-- 🐙 Git / GitHub — Version control

Frontend Integration

-- ⚛️ React — Planned frontend/client integration
-- 📡 REST APIs — Backend communication layer

React is represented as a future client integration. The current repository is primarily a Spring Boot backend.

🏗️ Architecture

The application follows a layered architecture.

                         ┌──────────────────────────┐
                         │        Client            │
                         │                          │
                         │ React / Postman / Other  │
                         └────────────┬─────────────┘
                                      │
                                      ▼
                         ┌──────────────────────────┐
                         │        REST API          │
                         └────────────┬─────────────┘
                                      │
                                      ▼
                         ┌──────────────────────────┐
                         │      Controllers         │
                         │                          │
                         │ Request / Response       │
                         │ Validation / Routing     │
                         └────────────┬─────────────┘
                                      │
                                      ▼
                         ┌──────────────────────────┐
                         │        Services          │
                         │                          │
                         │ Business Logic            │
                         │ Pricing                   │
                         │ Shipment Workflow         │
                         │ Authentication            │
                         └────────────┬─────────────┘
                                      │
                    ┌─────────────────┼─────────────────┐
                    │                 │                 │
                    ▼                 ▼                 ▼
          ┌────────────────┐ ┌────────────────┐ ┌────────────────┐
          │  Repositories  │ │    Mappers     │ │    Security    │
          │                │ │                │ │                │
          │ Data Access    │ │ DTO Conversion │ │ JWT / OAuth    │
          └───────┬────────┘ └────────────────┘ └────────────────┘
                  │
                  ▼
          ┌────────────────┐
          │    MongoDB     │
          │                │
          │ Persistent     │
          │ Data           │
          └────────────────┘
🧱 Layer Responsibilities
Controller Layer

Responsible for:

-- HTTP endpoints
-- Request mapping
-- Request validation
-- Authentication context access
-- Response generation

Service Layer

Responsible for:

-- Business rules
-- Pricing calculations
-- Shipment workflow
-- Status transition validation
-- Ownership checks
-- Assignment validation
-- Authentication-related business logic

Repository Layer

Responsible for:

-- Database access
-- User queries
-- Shipment queries
-- Pricing configuration queries

DTO Layer

Responsible for:

-- API request contracts
-- API response contracts
-- Input validation
-- Separation between persistence entities and API models

Security Layer

Responsible for:

-- JWT authentication
-- JWT refresh tokens
-- Google OAuth 2.0
-- Role-based authorization
-- Current-user resolution
-- Protected API access

👥 User Roles

The platform is designed around four operational roles.

Role	Responsibility
👤 CUSTOMER	Create, manage and track shipments
🚚 DELIVERY_AGENT	Handle assigned shipments and delivery operations
🏢 HUB_OPERATOR	Manage hub operations and shipment movement
🛡️ ADMIN	Manage users, pricing, assignments and configuration
🔐 Authentication & Authorization

Authentication is implemented using a combination of:

-- Local username/email authentication
-- BCrypt password hashing
-- JWT access tokens
-- JWT refresh tokens
-- JWT authentication filter
-- Google OAuth 2.0
-- Role-based authorization

🟢 Completed Authentication Features

-- ✅ User registration
-- ✅ User login
-- ✅ Login using username or email
-- ✅ JWT access tokens
-- ✅ JWT refresh tokens
-- ✅ JWT authentication filter
-- ✅ BCrypt password hashing
-- ✅ Role-based authorization
-- ✅ Account enable/disable
-- ✅ Authentication-provider tracking
-- ✅ Google OAuth 2.0 authentication
-- ✅ Protected role-specific APIs
-- ✅ Current authenticated-user resolution

🔑 Authentication Providers

Currently supported:

LOCAL
GOOGLE

The user model stores the authentication provider and provider-specific identifier.

Example:

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
👤 User Management

The platform maintains user accounts containing authentication, authorization and account-state information.

🟢 Completed

-- ✅ Customer registration
-- ✅ Customer login
-- ✅ Google login
-- ✅ JWT authentication
-- ✅ Delivery-agent authentication
-- ✅ Admin authentication
-- ✅ Role-based API protection
-- ✅ Authentication-provider separation

⏱️ Planned

-- ⏱️ Admin user-management APIs
-- ⏱️ User activation/deactivation APIs
-- ⏱️ Profile management
-- ⏱️ Password change
-- ⏱️ Account recovery
-- ⏱️ Advanced delivery-agent management

📦 Shipment Management

Shipment management is one of the core implemented modules.

A shipment contains information such as:

-- Sender address
-- Receiver address
-- Sender details
-- Receiver details
-- Package weight
-- Package dimensions
-- Package description
-- Delivery priority
-- Distance
-- COD selection
-- Calculated cost
-- Current shipment status
-- Tracking history
-- Assigned delivery agent
-- Creation timestamp
-- Update timestamp

Every shipment receives a unique tracking number.

Example:

TRK-196B639CBBC1
📦 Shipment Structure
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
💰 Server-Side Pricing

The platform does not trust customers to submit the final shipping price.

Instead, the final price is calculated by the backend using the active pricing configuration.

This provides centralized control over pricing and prevents clients from manipulating the final shipment cost through request payloads.

Pricing Architecture
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
              Calculated Price
🧮 Pricing Formula

The current pricing model follows:

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
⚡ Priority Multipliers
STANDARD → 1.0×
EXPRESS  → 1.5×
URGENT   → 2.0×
💵 Example Pricing Configuration
Base Charge  = ₹50
Per KG Rate  = ₹20
Per KM Rate  = ₹2

STANDARD     = 1.0×
EXPRESS      = 1.5×
URGENT       = 2.0×

COD Fee      = ₹30
🧮 Pricing Example

Input:

Weight   = 2.5 KG
Distance = 100 KM
Priority = STANDARD
COD      = No

Calculation:

₹50
+
(2.5 × ₹20)
+
(100 × ₹2)

= ₹300

The customer does not control the final price.

The server calculates the final price from the active pricing configuration.

⚙️ Admin Pricing Configuration

Administrators can configure the active pricing rules.

🟢 Implemented APIs
Method	Endpoint	Access
POST	/api/admin/pricing	ADMIN
GET	/api/admin/pricing/active	ADMIN

The active configuration is used by the pricing service for shipment calculations.

🧮 Price Estimation

Customers can estimate shipping costs before creating a shipment.

Endpoint
POST /api/shipments/estimate
Request
{
  "weight": 2.5,
  "distanceKm": 100,
  "priority": "STANDARD",
  "cod": false
}
Response
{
  "estimatedPrice": 300
}

The same centralized PricingService is used during shipment creation.

This prevents pricing logic from being duplicated between estimation and actual shipment creation.

🔄 Shipment Lifecycle

The primary shipment lifecycle is:

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
Exceptional States
CANCELLED
FAILED_DELIVERY
RETURNED
🧠 Shipment Status Transition Engine

The platform uses a centralized transition engine to prevent invalid shipment-state changes.

Valid Transitions
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
🔒 Terminal Shipment States

The following states are terminal:

DELIVERED
CANCELLED
RETURNED

Once a shipment reaches a terminal state, it cannot transition into another shipment status.

🟢 Status Engine Completed

-- ✅ Centralized transition validation
-- ✅ Invalid transition rejection
-- ✅ Terminal-state protection
-- ✅ Tracking-event creation for status changes
-- ✅ Status update API

Status Update Endpoint
PATCH /api/shipments/{shipmentId}/status

Example request:

{
  "status": "CONFIRMED"
}

Invalid transitions return a controlled 400 Bad Request.

📍 Shipment Tracking

The platform maintains a tracking history rather than storing only the latest shipment status.

Each tracking event can contain:

-- Status
-- Timestamp
-- Location
-- Description
-- Performed by
-- Notes

📍 Tracking Example
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
🔎 Tracking API
GET /api/shipments/tracking/{trackingNumber}/history

The tracking-history architecture provides the foundation for future operational visibility and real-time tracking integrations.

🔎 Shipment Retrieval
🟢 Implemented APIs
Method	Endpoint	Purpose
GET	/api/shipments/{id}	Get shipment by ID
GET	/api/shipments/tracking/{trackingNumber}	Get shipment by tracking number
GET	/api/shipments/tracking/{trackingNumber}/history	Get tracking history
GET	/api/shipments/my	Get customer's shipments
✏️ Shipment Updates

Customers can update shipment information during the permitted early shipment lifecycle.

Supported information includes:

-- Sender address
-- Receiver address
-- Package details
-- Priority

⏱️ Planned Improvements

-- ⏱️ Stronger state-based update restrictions
-- ⏱️ Automatic price re-estimation when price-affecting fields change
-- ⏱️ Audit logging
-- ⏱️ Field-level update rules

❌ Shipment Cancellation

Customers can cancel their own shipment while it is in:

CREATED
Cancellation Flow
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

CANCELLED is a terminal shipment state.

🚚 Delivery Agent Management

Delivery-agent operations are currently being expanded.

🟢 Completed
Delivery Agent Authentication

Delivery agents can authenticate using the existing JWT authentication system.

Assigned Shipment Retrieval
GET /api/delivery/shipments

The backend automatically identifies the authenticated delivery agent.

The delivery agent does not provide their own user ID in the request.

Only shipments assigned to the authenticated delivery agent are returned.

🛡️ Admin Shipment Assignment

Administrators can assign shipments to delivery agents.

POST /api/admin/shipments/{shipmentId}/assign

Example:

{
  "deliveryAgentId": "delivery-agent-user-id"
}
🔍 Assignment Validation

The backend validates:

-- ✅ Shipment exists
-- ✅ Delivery agent exists
-- ✅ Selected user has DELIVERY_AGENT role
-- ✅ Shipment is not already assigned
-- ✅ Shipment is in an assignable state
-- ✅ Assignment is performed by an authorized administrator

🔄 Current Assignment Flow
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
🚛 Delivery Agent Workflow
🟢 Completed
Delivery Agent Login
        ↓
View Assigned Shipments
        ↓
Admin Assignment
🔄 In Progress

The next operational stage focuses on turning an assigned shipment into an actual delivery workflow.

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
🚧 Delivery Operations
🔄 In Progress

-- 🔄 Delivery-agent accept/reject workflow
-- 🔄 Pickup workflow
-- 🔄 In-transit workflow
-- 🔄 Out-for-delivery workflow
-- 🔄 Delivery confirmation
-- 🔄 Failed-delivery workflow
-- 🔄 Delivery proof
-- 🔄 OTP verification
-- 🔄 COD collection

These features build on the already implemented shipment status-transition engine.

🏢 Hub Management

Hub operations are planned as the next major logistics module.

⏱️ Planned Capabilities

-- ⏱️ Hub CRUD
-- ⏱️ Hub operator role
-- ⏱️ Shipment arrival scanning
-- ⏱️ Shipment outbound scanning
-- ⏱️ Shipment routing
-- ⏱️ Local delivery assignment
-- ⏱️ Hub inventory
-- ⏱️ Hub-based shipment visibility

🏢 Planned Hub Workflow
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
💳 Payments & COD

The platform is designed to support both Cash on Delivery and online payments.

⏱️ Planned COD Lifecycle
COD_PENDING
     ↓
COD_COLLECTED
     ↓
SETTLED
⏱️ Planned Online Payment Lifecycle
PENDING
   ↓
PAID
   ↓
REFUNDED

Failed payments:

PENDING
   ↓
FAILED
🧩 Payment Abstraction

A payment abstraction is planned so the business layer does not become tightly coupled to one payment provider.

Conceptually:

PaymentService
      │
      ├── MockPaymentService
      │
      └── FuturePaymentGateway

This allows a real payment provider to be introduced later without redesigning the entire shipment business layer.

🔔 Notifications
⏱️ Planned Shipment Notifications

-- ⏱️ Shipment created
-- ⏱️ Price confirmed
-- ⏱️ Shipment picked up
-- ⏱️ Hub arrival
-- ⏱️ Out for delivery
-- ⏱️ Delivered
-- ⏱️ Failed delivery
-- ⏱️ Returned
-- ⏱️ Payment updates
-- ⏱️ COD updates

The initial notification architecture is planned around email notifications.

Future integrations may include:

-- ⏱️ SMS
-- ⏱️ Push notifications

📄 Invoice & Rating
⏱️ Invoice

Customers will eventually be able to download shipment invoices or receipts containing:

-- ⏱️ Shipment details
-- ⏱️ Tracking number
-- ⏱️ Customer information
-- ⏱️ Origin and destination
-- ⏱️ Package details
-- ⏱️ Priority
-- ⏱️ Shipping cost
-- ⏱️ COD/payment information
-- ⏱️ Invoice date

⭐ Delivery Rating

After successful delivery:

1–5 Star Rating
       +
Optional Feedback

The planned business rule is:

-- ⏱️ One rating per shipment
-- ⏱️ Rating available after successful delivery
-- ⏱️ Optional customer feedback

🔐 API Security

Role-based API protection is implemented using Spring Security.

API Access Structure
/auth/**          → Authentication
/api/customer/**  → CUSTOMER
/api/delivery/**  → DELIVERY_AGENT / ADMIN
/api/admin/**     → ADMIN

JWT authentication is applied to protected APIs.

Ownership-sensitive operations also validate the authenticated user before modifying or retrieving protected resources.

🧪 Validation & Error Handling

The platform uses request DTO validation for API input.

Validation includes:

-- ✅ Required fields
-- ✅ Indian phone-number validation
-- ✅ Indian PIN-code validation
-- ✅ Positive package dimensions
-- ✅ Positive package weight
-- ✅ Valid priority
-- ✅ Valid distance
-- ✅ Required shipment status

Validation failures are handled through centralized exception handling.

📋 Validation Error Example
{
  "message": "Validation Failed",
  "validationErrors": {
    "postalCode": "Invalid postal code"
  }
}

The API is designed to return controlled and structured validation responses instead of exposing internal application errors directly to clients.

🧪 Testing

Manual API testing is currently performed using Postman.

🟢 Tested

-- ✅ Customer registration
-- ✅ Customer login
-- ✅ Admin login
-- ✅ Delivery-agent login
-- ✅ JWT authentication
-- ✅ Role-based authorization
-- ✅ Shipment creation
-- ✅ Shipment retrieval
-- ✅ Shipment update
-- ✅ Shipment cancellation
-- ✅ Price estimation
-- ✅ Admin pricing configuration
-- ✅ Tracking history
-- ✅ Valid shipment status transitions
-- ✅ Invalid shipment status transitions
-- ✅ Admin → Delivery-agent assignment
-- ✅ Delivery-agent → assigned-shipment retrieval

🔬 End-to-End Assignment Test
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
📡 API Overview
🔐 Authentication APIs
POST /auth/register
POST /auth/login
📦 Customer Shipment APIs
POST   /api/shipments
POST   /api/shipments/estimate

GET    /api/shipments/{id}
GET    /api/shipments/my

GET    /api/shipments/tracking/{trackingNumber}
GET    /api/shipments/tracking/{trackingNumber}/history

PUT    /api/shipments/{id}
PATCH  /api/shipments/{id}/cancel

PATCH  /api/shipments/{shipmentId}/status
🛡️ Admin APIs
POST /api/admin/pricing
GET  /api/admin/pricing/active

POST /api/admin/shipments/{shipmentId}/assign
🚚 Delivery Agent APIs
GET /api/delivery/shipments

Additional delivery-agent APIs will be introduced as the operational workflow progresses.

📊 Development Status

The project uses three primary development states:

<div align="center">

Symbol	Meaning
🟢	Completed
🔄	In Progress
⏱️	Planned

</div>

🟢 Completed Features
Project Foundation

-- 🟢 Spring Boot project setup
-- 🟢 Maven configuration
-- 🟢 Java 21 configuration
-- 🟢 MongoDB configuration
-- 🟢 Layered architecture

Authentication

-- 🟢 User entity
-- 🟢 User repository
-- 🟢 Local registration
-- 🟢 Local login
-- 🟢 Username/email login
-- 🟢 BCrypt password hashing
-- 🟢 JWT access token
-- 🟢 JWT refresh token
-- 🟢 JWT authentication filter
-- 🟢 Role-based authorization
-- 🟢 Customer role
-- 🟢 Admin role
-- 🟢 Delivery-agent role
-- 🟢 Hub-operator role
-- 🟢 Google OAuth 2.0
-- 🟢 Current-user resolution

Shipment Management

-- 🟢 Shipment entity
-- 🟢 Shipment repository
-- 🟢 Shipment DTOs
-- 🟢 Address validation
-- 🟢 Package validation
-- 🟢 Shipment creation
-- 🟢 Tracking-number generation
-- 🟢 Shipment retrieval
-- 🟢 Customer shipment retrieval
-- 🟢 Shipment update
-- 🟢 Shipment cancellation

Pricing

-- 🟢 Pricing configuration
-- 🟢 Admin pricing API
-- 🟢 Price estimate API
-- 🟢 Server-side shipment pricing
-- 🟢 Centralized pricing service

Tracking & Workflow

-- 🟢 Tracking history
-- 🟢 Tracking-event creation
-- 🟢 Shipment status transition engine
-- 🟢 Invalid-transition validation
-- 🟢 Terminal-state protection
-- 🟢 Status update API

Delivery Operations

-- 🟢 Delivery-agent authentication
-- 🟢 Delivery-agent assigned shipments
-- 🟢 Admin shipment assignment
-- 🟢 Assignment validation
-- 🟢 Postman API testing

🔄 In Progress

The current development focus is the operational delivery workflow.

-- 🔄 Delivery-agent accept/reject
-- 🔄 Pickup workflow
-- 🔄 In-transit workflow
-- 🔄 Out-for-delivery workflow
-- 🔄 Delivery confirmation
-- 🔄 Failed-delivery workflow
-- 🔄 Delivery proof
-- 🔄 OTP verification
-- 🔄 COD collection

⏱️ Planned Features
User Management

-- ⏱️ Admin user management
-- ⏱️ User activation/deactivation APIs
-- ⏱️ Profile management
-- ⏱️ Password change
-- ⏱️ Account recovery
-- ⏱️ Advanced delivery-agent management

Shipment

-- ⏱️ Shipment pagination
-- ⏱️ Shipment search
-- ⏱️ Shipment filtering
-- ⏱️ Advanced ownership rules
-- ⏱️ Field-level update rules
-- ⏱️ Audit logging

Hub Operations

-- ⏱️ Hub management
-- ⏱️ Hub operators
-- ⏱️ Hub scan-in
-- ⏱️ Hub scan-out
-- ⏱️ Shipment routing
-- ⏱️ Hub inventory
-- ⏱️ Destination-hub operations

Payments

-- ⏱️ COD settlement
-- ⏱️ Online payments
-- ⏱️ Payment abstraction
-- ⏱️ Mock payment service
-- ⏱️ Refund workflow

Notifications

-- ⏱️ Email notifications
-- ⏱️ SMS notifications
-- ⏱️ Push notifications
-- ⏱️ Event-driven notification architecture

Documents

-- ⏱️ Invoice generation
-- ⏱️ PDF receipts
-- ⏱️ Delivery documents

Customer Experience

-- ⏱️ Delivery rating
-- ⏱️ Customer feedback
-- ⏱️ Shipment search
-- ⏱️ Advanced shipment filtering

Administration

-- ⏱️ Admin reports
-- ⏱️ Audit logs
-- ⏱️ Auto assignment
-- ⏱️ Pricing administration improvements
-- ⏱️ Operational dashboards

Infrastructure

-- ⏱️ Swagger / OpenAPI
-- ⏱️ Automated testing
-- ⏱️ Dockerization
-- ⏱️ Production deployment
-- ⏱️ Monitoring
-- ⏱️ Observability

Location & Logistics Intelligence

-- ⏱️ Maps integration
-- ⏱️ Geocoding
-- ⏱️ Distance calculation
-- ⏱️ ETA calculation
-- ⏱️ Route optimization

🗺️ Development Roadmap
Phase 1 — Foundation

Status: 🟢 Completed

-- 🟢 Project setup
-- 🟢 Java 21
-- 🟢 Spring Boot
-- 🟢 Maven
-- 🟢 MongoDB
-- 🟢 Spring Security
-- 🟢 JWT
-- 🟢 Google OAuth 2.0
-- 🟢 Role-based authorization

Phase 2 — Shipment Management

Status: 🟢 Completed

-- 🟢 Shipment entity
-- 🟢 Shipment CRUD
-- 🟢 Validation
-- 🟢 Tracking number
-- 🟢 Pricing
-- 🟢 Price estimation
-- 🟢 Cancellation
-- 🟢 Tracking history

Phase 3 — Shipment Workflow

Status: 🟢 Completed

-- 🟢 Status transition engine
-- 🟢 Status validation
-- 🟢 Terminal-state protection
-- 🟢 Delivery-agent role
-- 🟢 Admin assignment
-- 🟢 Assigned shipment retrieval

Phase 4 — Delivery Operations

Status: 🔄 In Progress

-- 🔄 Accept / Reject
-- 🔄 Pickup
-- 🔄 In Transit
-- 🔄 Out for Delivery
-- 🔄 Delivery Proof
-- 🔄 OTP
-- 🔄 Failed Delivery
-- 🔄 COD Collection

Phase 5 — Hub Operations

Status: ⏱️ Planned

-- ⏱️ Hub Management
-- ⏱️ Hub Operators
-- ⏱️ Shipment Routing
-- ⏱️ Scan-In
-- ⏱️ Scan-Out
-- ⏱️ Hub Inventory
-- ⏱️ Hub Visibility

Phase 6 — Platform Features

Status: ⏱️ Planned

-- ⏱️ Payments
-- ⏱️ COD Settlement
-- ⏱️ Notifications
-- ⏱️ Invoices
-- ⏱️ Ratings
-- ⏱️ Reports
-- ⏱️ Audit Logs

Phase 7 — Production Hardening

Status: ⏱️ Planned

-- ⏱️ Pagination
-- ⏱️ Search
-- ⏱️ Filtering
-- ⏱️ Swagger / OpenAPI
-- ⏱️ Automated Tests
-- ⏱️ Docker
-- ⏱️ Production Deployment
-- ⏱️ Monitoring
-- ⏱️ Observability

🧱 Production-Oriented Engineering

The project is being developed beyond simple CRUD implementation.

The primary engineering goals are:

-- 🟢 Layered architecture
-- 🟢 DTO-based API contracts
-- 🟢 Mapper-based entity conversion
-- 🟢 Centralized business logic
-- 🟢 Role-based authorization
-- 🟢 JWT security
-- 🟢 Server-side pricing
-- 🟢 State-transition validation
-- 🟢 Ownership validation
-- 🟢 Input validation
-- 🟢 Centralized exception handling
-- 🟢 Structured logging

Future engineering improvements include:

-- ⏱️ MongoDB indexing improvements
-- ⏱️ Pagination
-- ⏱️ Search and filtering
-- ⏱️ Automated testing
-- ⏱️ API documentation
-- ⏱️ Environment-based configuration
-- ⏱️ Secure secret management
-- ⏱️ Docker support
-- ⏱️ Production deployment
-- ⏱️ Monitoring and observability

⚙️ Local Setup
Prerequisites

Install the following:

-- ☕ Java 21
-- 📦 Maven
-- 🍃 MongoDB
-- 🐙 Git
-- 🧪 Postman
-- 🛠️ Spring Tool Suite
-- 🛠️ IntelliJ IDEA
-- 🛠️ Eclipse

📥 Clone Repository
git clone https://github.com/iLovishSaluja/logistics-platform.git
cd logistics-platform
🔐 Environment Configuration

Never commit real credentials or secrets to GitHub.

Use environment variables for sensitive configuration.

Example:

spring.data.mongodb.uri=${MONGODB_URI}

spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}

spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}

jwt.secret=${JWT_SECRET}
🔧 Application Port

The Logistics Platform currently runs on:

8081

Configuration:

server.port=8081
🏗️ Build Project

Using Maven Wrapper:

Windows
mvnw.cmd clean install
Linux / macOS
./mvnw clean install
▶️ Run Application
Windows
mvnw.cmd spring-boot:run
Linux / macOS
./mvnw spring-boot:run

Application:

http://localhost:8081
🧪 API Testing with Postman

The recommended development workflow is:

Start MongoDB
      ↓
Start Spring Boot Application
      ↓
Authenticate
      ↓
Copy Access Token
      ↓
Authorize Protected Requests
      ↓
Test APIs
      ↓
Verify MongoDB Data
🔑 Authentication Flow
Local Authentication
Register
   ↓
Login
   ↓
Access Token
   ↓
Protected API
Google Authentication
Google Login
     ↓
OAuth Callback
     ↓
User Resolution
     ↓
JWT Authentication
     ↓
Protected API
🛡️ Protected Request Flow
HTTP Request
     ↓
Authorization Header
     ↓
JWT Filter
     ↓
Token Validation
     ↓
User Resolution
     ↓
SecurityContext
     ↓
Role Validation
     ↓
Controller
     ↓
Service
     ↓
Repository
📦 Shipment Creation Flow
Customer
   ↓
POST /api/shipments
   ↓
Request Validation
   ↓
Authenticated User Check
   ↓
Shipment DTO
   ↓
Pricing Service
   ↓
Tracking Number Generation
   ↓
Shipment Creation
   ↓
Tracking Event
   ↓
MongoDB
   ↓
Response
💰 Pricing Flow
Shipment Request
       ↓
Pricing Configuration
       ↓
Base Charge
       ↓
Weight Charge
       ↓
Distance Charge
       ↓
Priority Multiplier
       ↓
COD Fee
       ↓
Final Price
       ↓
Shipment
🚚 Delivery Assignment Flow
ADMIN
  ↓
Select Shipment
  ↓
Select Delivery Agent
  ↓
Validate User Role
  ↓
Validate Shipment
  ↓
Validate Assignment State
  ↓
Save Agent ID
  ↓
Delivery Agent
  ↓
GET /api/delivery/shipments
🔄 Shipment State Flow
┌───────────┐
│  CREATED  │
└─────┬─────┘
      │
      ▼
┌────────────┐
│ CONFIRMED  │
└──────┬─────┘
       │
       ▼
┌────────────┐
│ PICKED_UP  │
└──────┬─────┘
       │
       ▼
┌────────────┐
│ IN_TRANSIT │
└──────┬─────┘
       │
       ▼
┌─────────────────┐
│ OUT_FOR_DELIVERY│
└───────┬─────────┘
        │
        ▼
┌───────────┐
│ DELIVERED │
└───────────┘
📍 Tracking Architecture

Tracking history is stored as part of the shipment lifecycle.

Conceptually:

Shipment
   │
   ├── Current Status
   │
   └── Tracking History
          │
          ├── CREATED
          ├── CONFIRMED
          ├── PICKED_UP
          ├── IN_TRANSIT
          ├── OUT_FOR_DELIVERY
          └── DELIVERED

This allows the system to retain the shipment journey instead of only the current state.

🔒 Security Principles

The backend follows several security principles.

-- 🟢 Passwords are hashed using BCrypt
-- 🟢 Protected APIs require authentication
-- 🟢 Role-based authorization is applied
-- 🟢 JWT tokens are used for API authentication
-- 🟢 OAuth 2.0 is used for Google authentication
-- 🟢 Ownership is checked for customer-sensitive operations
-- 🟢 Pricing is calculated server-side
-- 🟢 Clients cannot directly control final pricing
-- 🟢 Input validation is applied to request DTOs
-- ⏱️ Production secret-management improvements are planned

🧩 Business Rules

The platform uses backend-enforced business rules.

Shipment Ownership

A customer should only be able to operate on shipments belonging to that customer.

Pricing

Final shipment cost is calculated by the server.

Cancellation

Customer cancellation is restricted to the permitted shipment lifecycle state.

Status Transitions

Shipment states can only move through valid transitions.

Assignment

Only authorized administrators can assign shipments to delivery agents.

Terminal States

Delivered, cancelled and returned shipments cannot continue through the normal shipment lifecycle.

📊 Data Model Overview
User
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
Shipment
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
🗃️ MongoDB

MongoDB is used as the primary persistence layer.

The application uses repository abstractions for database access.

The shipment repository supports operations such as:

-- Find by tracking number
-- Check tracking-number existence
-- Find shipments by customer
-- Find shipments by delivery agent
-- Find shipments by status

🧠 Why MongoDB?

The logistics domain contains naturally evolving documents such as:

-- Shipment details
-- Nested addresses
-- Package information
-- Tracking history
-- Assignment information

MongoDB provides a document-oriented persistence model that fits these structures well.

📦 DTO Architecture

DTOs are used to keep API contracts separate from persistence entities.

Examples include:

AddressDto
PackageDetailsDto
ShipmentCreateRequestDto
ShipmentUpdateRequestDto

This approach helps prevent API clients from directly controlling persistence-layer models.

🛡️ Centralized Exception Handling

The application uses centralized exception handling to provide consistent API responses.

The objective is to avoid exposing raw framework exceptions to API clients.

Example validation response:

{
  "message": "Validation Failed",
  "validationErrors": {
    "postalCode": "Invalid postal code"
  }
}
📝 Logging

The project follows structured backend logging practices.

The logging layer uses:

SLF4J

The goal is to avoid uncontrolled console logging and move toward production-friendly application logging.

🧪 Testing Strategy
Current

-- 🟢 Manual API testing using Postman
-- 🟢 Authentication testing
-- 🟢 Authorization testing
-- 🟢 Shipment CRUD testing
-- 🟢 Pricing testing
-- 🟢 Tracking testing
-- 🟢 Status transition testing
-- 🟢 Assignment testing

Future

-- ⏱️ Unit tests
-- ⏱️ Service-layer tests
-- ⏱️ Controller tests
-- ⏱️ Repository tests
-- ⏱️ Integration tests
-- ⏱️ Security tests
-- ⏱️ End-to-end API tests

📖 API Design Principles

The API is designed around:

-- RESTful resource endpoints
-- HTTP methods appropriate to operations
-- DTO-based request contracts
-- Structured JSON responses
-- Authentication for protected resources
-- Role-based authorization
-- Validation before business processing
-- Centralized exception handling

🌐 Frontend Integration

The backend is designed to be consumed by a frontend client.

Potential frontend architecture:

React Application
       │
       │ HTTP / REST
       ▼
Spring Boot Backend
       │
       ▼
MongoDB

The React badge in this README represents the planned/client-side integration rather than an implemented frontend contained in the current backend repository.

🖥️ Planned React Client
⏱️ Planned

The future React client can provide separate interfaces for:

Customer

-- ⏱️ Registration
-- ⏱️ Login
-- ⏱️ Shipment creation
-- ⏱️ Price estimation
-- ⏱️ Shipment tracking
-- ⏱️ Shipment history
-- ⏱️ Cancellation
-- ⏱️ Delivery rating

Delivery Agent

-- ⏱️ Assigned shipments
-- ⏱️ Accept/reject
-- ⏱️ Pickup
-- ⏱️ Status updates
-- ⏱️ Delivery proof
-- ⏱️ COD collection

Hub Operator

-- ⏱️ Hub dashboard
-- ⏱️ Scan-in
-- ⏱️ Scan-out
-- ⏱️ Shipment routing
-- ⏱️ Hub inventory

Admin

-- ⏱️ User management
-- ⏱️ Pricing configuration
-- ⏱️ Shipment assignment
-- ⏱️ Reports
-- ⏱️ Operational monitoring

🏢 Future Hub Architecture

The planned hub system will introduce an additional operational layer.

Shipment
   ↓
Origin
   ↓
Origin Hub
   ↓
Transit Hub
   ↓
Destination Hub
   ↓
Delivery Agent
   ↓
Customer

Each hub can eventually maintain:

-- ⏱️ Incoming shipments
-- ⏱️ Outgoing shipments
-- ⏱️ Shipment scans
-- ⏱️ Routing information
-- ⏱️ Local inventory
-- ⏱️ Assigned operators

📊 Future Admin Capabilities

The administration layer is planned to eventually support:

-- ⏱️ User management
-- ⏱️ Delivery-agent management
-- ⏱️ Hub management
-- ⏱️ Pricing configuration
-- ⏱️ Shipment assignment
-- ⏱️ Reports
-- ⏱️ Audit logs
-- ⏱️ Stuck-shipment monitoring
-- ⏱️ Operational dashboards
-- ⏱️ System configuration

📈 Future Architecture

The current implementation intentionally follows a modular monolith architecture.

As the platform grows, individual capabilities could eventually be separated into independent services if operational requirements justify the added complexity.

Potential future architecture:

                         API Gateway
                              │
              ┌───────────────┼────────────────┐
              │               │                │
              ▼               ▼                ▼
       Authentication     Shipment         Pricing
          Service          Service          Service
              │               │                │
              └───────────────┼────────────────┘
                              │
              ┌───────────────┼────────────────┐
              │               │                │
              ▼               ▼                ▼
            Hub           Delivery          Payment
          Service          Service          Service
              │               │                │
              └───────────────┼────────────────┘
                              │
                              ▼
                       Notification
                          Service

For V1, these capabilities remain within a single Spring Boot application.

🚀 Production Readiness Roadmap

The long-term production-hardening plan includes:

-- ⏱️ Automated testing
-- ⏱️ API documentation
-- ⏱️ Pagination
-- ⏱️ Search and filtering
-- ⏱️ Database indexing
-- ⏱️ Secure secret management
-- ⏱️ Docker
-- ⏱️ CI/CD
-- ⏱️ Production deployment
-- ⏱️ Monitoring
-- ⏱️ Observability
-- ⏱️ Health checks
-- ⏱️ Structured logs
-- ⏱️ Metrics
-- ⏱️ Distributed tracing if required

🐳 Docker
⏱️ Planned

The project is planned to support containerized deployment.

Potential architecture:

┌───────────────────────┐
│    React Frontend     │
└───────────┬───────────┘
            │
            ▼
┌───────────────────────┐
│   Spring Boot API     │
└───────────┬───────────┘
            │
            ▼
┌───────────────────────┐
│       MongoDB         │
└───────────────────────┘
☁️ Production Deployment
⏱️ Planned

Potential deployment improvements include:

-- ⏱️ Cloud deployment
-- ⏱️ Environment-specific configuration
-- ⏱️ Secure environment variables
-- ⏱️ HTTPS
-- ⏱️ Database security
-- ⏱️ Health checks
-- ⏱️ Monitoring
-- ⏱️ Logging
-- ⏱️ Automated deployment

📊 Monitoring & Observability
⏱️ Planned

The platform can eventually introduce:

-- ⏱️ Application health monitoring
-- ⏱️ Metrics
-- ⏱️ Error tracking
-- ⏱️ Request tracing
-- ⏱️ Database monitoring
-- ⏱️ Shipment-processing monitoring
-- ⏱️ Stuck-shipment detection
-- ⏱️ Operational alerts

🧭 Current Project State

The project has progressed beyond basic authentication and CRUD.

Current implemented flow:

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
🔄 Current Development Direction

The next major development stage is:

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

This stage will convert the existing assignment infrastructure into a complete operational delivery workflow.

🧩 Feature Status Legend

Throughout this README:

🟢 Completed

The feature has been implemented and is part of the current project functionality.

🔄 In Progress

The feature is currently being developed or is the immediate development focus.

⏱️ Planned

The feature is part of the future roadmap and has not yet been implemented.

📌 Feature Summary
Module	Status
Project Setup	🟢 Completed
Java 21	🟢 Completed
Spring Boot	🟢 Completed
Maven	🟢 Completed
MongoDB	🟢 Completed
Spring Security	🟢 Completed
JWT	🟢 Completed
Google OAuth 2.0	🟢 Completed
User Authentication	🟢 Completed
Role-Based Authorization	🟢 Completed
Shipment CRUD	🟢 Completed
Shipment Validation	🟢 Completed
Server-Side Pricing	🟢 Completed
Price Estimation	🟢 Completed
Shipment Cancellation	🟢 Completed
Tracking History	🟢 Completed
Status Transition Engine	🟢 Completed
Delivery-Agent Assignment	🟢 Completed
Assigned Shipment Retrieval	🟢 Completed
Delivery Accept/Reject	🔄 In Progress
Pickup Workflow	🔄 In Progress
Delivery Proof	🔄 In Progress
COD Collection	🔄 In Progress
Hub Management	⏱️ Planned
Online Payments	⏱️ Planned
Notifications	⏱️ Planned
Invoices	⏱️ Planned
Ratings	⏱️ Planned
Pagination	⏱️ Planned
Search & Filtering	⏱️ Planned
Swagger / OpenAPI	⏱️ Planned
Automated Testing	⏱️ Planned
Docker	⏱️ Planned
Production Deployment	⏱️ Planned
Monitoring	⏱️ Planned
🧠 Engineering Philosophy

The project focuses on learning and applying production-oriented backend engineering principles rather than building only a basic CRUD application.

The core principles are:

-- Keep business logic inside services
-- Keep controllers lightweight
-- Keep persistence logic inside repositories
-- Use DTOs for API contracts
-- Validate input at the API boundary
-- Enforce authorization at the backend
-- Never trust client-controlled pricing
-- Validate state transitions centrally
-- Validate ownership for protected resources
-- Keep authentication separate from business logic
-- Prefer reusable services over duplicated logic
-- Build incrementally
-- Test every feature before moving forward
-- Keep the architecture extensible

🔍 Example Business Flow

A complete future shipment journey can eventually look like:

Customer
   │
   ▼
Create Shipment
   │
   ▼
Server Calculates Price
   │
   ▼
Shipment Created
   │
   ▼
Shipment Confirmed
   │
   ▼
Admin Assignment
   │
   ▼
Delivery Agent Accepts
   │
   ▼
Pickup
   │
   ▼
In Transit
   │
   ▼
Hub Operations
   │
   ▼
Out For Delivery
   │
   ▼
Delivery Verification
   │
   ▼
Delivered
   │
   ▼
Rating / Feedback
🔐 Security Architecture
                    Client
                      │
                      ▼
                Authentication
                      │
          ┌───────────┴───────────┐
          │                       │
          ▼                       ▼
       LOCAL                   GOOGLE
          │                       │
          └───────────┬───────────┘
                      ▼
                JWT Creation
                      │
                      ▼
               JWT Auth Filter
                      │
                      ▼
               Current User
                      │
                      ▼
                Role Check
                      │
                      ▼
              Protected API
💰 Pricing Security Model
Client
  │
  │ Shipment details
  ▼
Backend
  │
  ├── Weight
  ├── Distance
  ├── Priority
  └── COD
       │
       ▼
Pricing Configuration
       │
       ▼
Pricing Service
       │
       ▼
Final Price

The client provides shipment parameters.

The backend determines the final price.

🧪 Quality Goals

The project aims to progressively improve:

-- 🟢 Input validation
-- 🟢 Authentication
-- 🟢 Authorization
-- 🟢 Business-rule enforcement
-- 🟢 Centralized exception handling
-- 🟢 Structured logging
-- 🔄 Delivery workflow completeness
-- ⏱️ Automated test coverage
-- ⏱️ API documentation
-- ⏱️ Production deployment
-- ⏱️ Observability

📁 Suggested Project Structure
src/
└── main/
    ├── java/
    │   └── com/
    │       └── lovish/
    │           └── logistic/
    │               └── platform/
    │
    │                   ├── config/
    │                   ├── controller/
    │                   ├── dto/
    │                   ├── entity/
    │                   ├── enums/
    │                   ├── exception/
    │                   ├── mapper/
    │                   ├── repository/
    │                   ├── security/
    │                   └── service/
    │
    └── resources/
        ├── application.properties
        └── ...

The exact package structure may evolve as additional modules are introduced.

📝 Git Workflow

The project is developed incrementally.

Typical workflow:

Implement Feature
      ↓
Test Feature
      ↓
Fix Issues
      ↓
Verify APIs
      ↓
Update README
      ↓
Commit
      ↓
Push to GitHub

Recommended commit style:

feat: add delivery agent assignment
fix: validate shipment status transition
refactor: improve pricing service
docs: update README
test: add shipment service tests
🤝 Contributing

This project is primarily being developed as a portfolio and learning project focused on production-oriented Java backend engineering.

Suggestions, issues and improvements are welcome.

When contributing:

-- Keep changes focused
-- Follow the existing architecture
-- Avoid unnecessary complexity
-- Validate business rules server-side
-- Add tests where applicable
-- Update documentation for major features
-- Use meaningful commit messages

📄 License

This project is currently unlicensed and intended for:

-- Personal development
-- Educational purposes
-- Backend engineering practice
-- Portfolio demonstration

A formal open-source license such as MIT may be added in the future if the project is released for open-source contributions.

👤 Author

<div align="center">

Lovish Saluja
Java Backend Developer

☕ Java 21
🌱 Spring Boot
🔐 Spring Security
🍃 MongoDB
📡 REST APIs
🎟️ JWT
🔑 OAuth 2.0
📦 Maven

</div>

🚚 Logistics Platform

<div align="center">

Building a production-style logistics backend with Java & Spring Boot.

Authentication • Shipments • Pricing • Tracking • Delivery Operations

⭐ If you find the project interesting, consider giving the repository a star!
