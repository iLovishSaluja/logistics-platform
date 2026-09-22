# 🚚 Logistics Platform

### Production-Style Logistics & Shipment Management Backend

A production-oriented **Logistics and Shipment Management Platform** built with **Java 21, Spring Boot, Spring Security, JWT, OAuth 2.0 and MongoDB**.

The project models the backend operations of a modern logistics company, covering secure authentication, shipment management, server-side pricing, shipment tracking, controlled shipment lifecycle transitions, delivery-agent assignment and future delivery operations.

The primary goal of this project is to build a **realistic, secure and scalable backend system** rather than a simple CRUD application.

---

## 🧭 Project Overview

The Logistics Platform is being developed as a **modular monolith** representing the backend of a logistics company.

The platform is designed around four major operational roles:

| Role | Responsibility |
|---|---|
| 👤 `CUSTOMER` | Create and manage shipments, estimate prices and track deliveries |
| 🚚 `DELIVERY_AGENT` | Handle assigned shipments and perform delivery operations |
| 🏢 `HUB_OPERATOR` | Manage hub operations and shipment movement |
| 🛡️ `ADMIN` | Manage users, pricing, shipment assignments and operational configuration |

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

The first stages of this workflow are currently implemented, while the remaining delivery operations are being developed incrementally.

🛠️ Tech Stack
Technology	Purpose
☕ Java 21	Backend development
🌱 Spring Boot	Application framework
🔐 Spring Security	Authentication and authorization
🎟️ JWT	Access and refresh token authentication
🔑 OAuth 2.0	Google authentication
🍃 MongoDB	Database
📡 REST API	Client-server communication
📦 Maven	Dependency and build management
🧪 Postman	API testing
📝 SLF4J	Application logging
🏗️ Architecture

The project follows a layered backend architecture.

                    ┌──────────────────────┐
                    │       Client         │
                    │  Postman / Frontend  │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │     Controllers      │
                    │      REST APIs       │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │       Services       │
                    │                      │
                    │ Business Logic       │
                    │ Pricing              │
                    │ Shipment Workflow    │
                    │ Authentication       │
                    └──────────┬───────────┘
                               │
                ┌──────────────┼──────────────┐
                ▼              ▼              ▼
        ┌──────────────┐ ┌───────────┐ ┌──────────────┐
        │ Repositories │ │  Mappers  │ │   Security   │
        └──────┬───────┘ └───────────┘ └──────────────┘
               │
               ▼
        ┌──────────────┐
        │   MongoDB    │
        └──────────────┘
Layer Responsibilities
Controller
    ↓
Receives HTTP request
    ↓
Validates request
    ↓
Calls Service

Service
    ↓
Business rules
    ↓
Authorization / ownership checks
    ↓
Pricing / workflow logic
    ↓
Calls Repository

Repository
    ↓
MongoDB data access

DTOs and mappers are used to separate API contracts from persistence entities.

📁 Project Structure
src/
└── main/
    └── java/
        └── com/
            └── lovish/
                └── logistic/
                    └── platform/
                        │
                        ├── config/
                        ├── controller/
                        ├── dto/
                        ├── entity/
                        ├── enums/
                        ├── exception/
                        ├── mapper/
                        ├── oauth/
                        ├── repository/
                        ├── security/
                        ├── service/
                        └── util/
🔐 Authentication & Authorization

Security is implemented using Spring Security, JWT and OAuth 2.0.

Implemented Authentication Features
Customer registration
Local login
Login using username or email
BCrypt password hashing
JWT access tokens
JWT refresh tokens
JWT authentication filter
Google OAuth 2.0 login
Account enable/disable support
Authentication provider tracking
Role-based authorization
Current authenticated-user resolution
Supported Roles
CUSTOMER
DELIVERY_AGENT
HUB_OPERATOR
ADMIN
Authentication Providers
LOCAL
GOOGLE
JWT Authentication Flow
User Login
    ↓
Credentials Validated
    ↓
JWT Access Token Generated
    ↓
Client Sends:
Authorization: Bearer <token>
    ↓
JwtAuthenticationFilter
    ↓
Token Validated
    ↓
User Loaded
    ↓
SecurityContext
    ↓
Protected Controller

The system uses the authenticated identity from the security context instead of trusting user IDs supplied by clients for ownership-sensitive operations.

👤 User Management

The platform maintains users with role and authentication-provider information.

User Model
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
Current Capabilities
Customer registration
Customer login
Admin authentication
Delivery Agent authentication
Google authentication
JWT authentication
Role-based authorization
Enabled/disabled accounts
Authentication provider tracking
Planned
Admin user management
User activation/deactivation APIs
Profile management
Password change
Account recovery
Delivery-agent management
📦 Shipment Management

Shipment management is one of the core modules of the platform.

A shipment contains:

Sender address
Receiver address
Sender contact information
Receiver contact information
Package weight
Package dimensions
Package description
Delivery priority
Distance
COD selection
Calculated shipping cost
Current shipment status
Tracking history
Assigned delivery agent

Every shipment receives a unique tracking number.

Example:

TRK-196B639CBBC1
Shipment Model
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
💰 Server-Side Pricing Engine

The platform does not allow customers to control or submit the final shipping price.

Instead, the server calculates the price using an active pricing configuration controlled by the logistics company.

Pricing Architecture
PricingConfig
      ↓
PricingConfigRepository
      ↓
PricingService
      ↓
DefaultPricingService
      ↓
Calculated Price
Pricing Formula
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
Priority Multipliers
STANDARD → 1.0×
EXPRESS  → 1.5×
URGENT   → 2.0×
Example Pricing Configuration
Base Charge      = ₹50
Per KG Rate      = ₹20
Per KM Rate      = ₹2
STANDARD         = 1.0×
EXPRESS          = 1.5×
URGENT           = 2.0×
COD Handling Fee = ₹30
Example Calculation
Weight   = 2.5 KG
Distance = 100 KM
Priority = STANDARD
COD      = No

₹50 + (2.5 × ₹20) + (100 × ₹2)

= ₹300

The pricing logic is centralized inside the pricing service so that shipment creation and price estimation use the same business rules.

⚙️ Admin Pricing Configuration

Administrators can configure the pricing rules used by the platform.

Implemented APIs
Method	Endpoint	Access
POST	/api/admin/pricing	ADMIN
GET	/api/admin/pricing/active	ADMIN

The active configuration is used by the server when calculating shipment prices.

🧮 Price Estimation

Customers can estimate shipping cost before creating a shipment.

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

The estimate is calculated entirely on the server.

📍 Shipment Tracking

The platform maintains a tracking history for each shipment rather than storing only its latest status.

Each tracking event can contain:

Status
Timestamp
Location
Description
Performed By
Notes
Example
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
Tracking API
GET /api/shipments/tracking/{trackingNumber}/history

This provides the foundation for customer-facing shipment tracking and future real-time logistics visibility.

🔄 Shipment Lifecycle

The shipment lifecycle is centrally controlled.

Main Lifecycle
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

A dedicated ShipmentStatusService controls valid status transitions.

This prevents clients or other components from directly moving shipments between arbitrary states.

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
Terminal States
DELIVERED
CANCELLED
RETURNED

These states cannot transition to another shipment state.

Implemented Status Workflow Features
Centralized transition validation
Invalid transition rejection
Terminal-state protection
Tracking event creation
Status update API
Controlled lifecycle progression
Status Update API
PATCH /api/shipments/{shipmentId}/status
Request
{
  "status": "CONFIRMED"
}

Invalid transitions are rejected with a controlled 400 Bad Request.

❌ Shipment Cancellation

Customers can cancel their own shipments only while the shipment is in:

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

CANCELLED is a terminal state.

🔎 Shipment APIs
Implemented
Method	Endpoint	Purpose
POST	/api/shipments	Create shipment
POST	/api/shipments/estimate	Estimate price
GET	/api/shipments/{id}	Get shipment
GET	/api/shipments/my	Get customer's shipments
GET	/api/shipments/tracking/{trackingNumber}	Get shipment by tracking number
GET	/api/shipments/tracking/{trackingNumber}/history	Get tracking history
PUT	/api/shipments/{id}	Update shipment
PATCH	/api/shipments/{id}/cancel	Cancel shipment
PATCH	/api/shipments/{shipmentId}/status	Update shipment status
🚚 Delivery Agent Management

Delivery operations are now being introduced into the platform.

Delivery Agent Authentication

Delivery Agents use the same secure JWT authentication system.

After login, the authenticated Delivery Agent can access protected delivery APIs.

📦 View Assigned Shipments

A Delivery Agent can retrieve shipments assigned specifically to the currently authenticated agent.

API
GET /api/delivery/shipments
Authentication
Bearer <DELIVERY_AGENT_ACCESS_TOKEN>

The Delivery Agent does not send their own user ID.

The backend determines the authenticated user through:

JWT
 ↓
JwtAuthenticationFilter
 ↓
SecurityContext
 ↓
Authenticated Username
 ↓
UserRepository
 ↓
Delivery Agent ID
 ↓
Assigned Shipments
Example Response
[
  {
    "id": "6ab2c59a2c4cf640a0214a25",
    "trackingNumber": "TRK-196B639CBBC1",
    "status": "CREATED",
    "priority": "STANDARD",
    "cost": 500.00,
    "createdAt": "2026-09-22T23:44:50.355"
  }
]

If the agent has no assigned shipments:

[]
👨‍💼 Admin Shipment Assignment

Administrators can assign shipments to Delivery Agents.

API
POST /api/admin/shipments/{shipmentId}/assign
Request
{
  "deliveryAgentId": "delivery-agent-user-id"
}
Assignment Flow
ADMIN
  ↓
Shipment ID
  +
Delivery Agent ID
  ↓
Validate Shipment
  ↓
Validate User
  ↓
Validate DELIVERY_AGENT Role
  ↓
Validate Shipment Status
  ↓
Check Existing Assignment
  ↓
Save assignedDeliveryAgentId
Assignment Validation

The backend verifies:

Shipment exists
Delivery Agent exists
Selected user has DELIVERY_AGENT role
Shipment is not already assigned
Shipment is in an assignable state
Request is made by an authorized Admin

A shipment that is already assigned or has reached an invalid lifecycle state cannot be assigned.

For example, a DELIVERED shipment cannot be assigned to a Delivery Agent.

🚛 Current Delivery Workflow
Completed
Admin Assignment
       ↓
Delivery Agent
       ↓
View Assigned Shipments
Next
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
🚚 Planned Delivery Agent Features

The following delivery-agent capabilities are planned:

Accept assignment
Reject assignment
Pickup confirmation
In-transit status
Out-for-delivery status
Delivery confirmation
Delivery notes
Failed delivery reporting
Delivery proof
OTP verification
Signature proof
Photo proof
COD collection
Delivery-agent statistics
🏢 Hub Management

Hub operations are planned as a major logistics module.

Planned Capabilities
Hub CRUD
Hub Operator role
Shipment arrival scanning
Shipment outbound scanning
Shipment routing
Local delivery assignment
Hub inventory
Hub shipment visibility
Planned Shipment Flow
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

The initial hub architecture will remain intentionally simple, using a linear shipment route before introducing more advanced routing.

💳 Payments & COD

The platform is designed to support both Cash on Delivery and online payments.

Planned COD Lifecycle
COD_PENDING
     ↓
COD_COLLECTED
     ↓
SETTLED
Planned Online Payment Lifecycle
PENDING
   ↓
PAID
   ↓
REFUNDED

Failed payments:

PENDING
   ↓
FAILED

A PaymentGateway abstraction is planned so that real payment providers can be integrated later without tightly coupling payment logic to a specific provider.

🔔 Notifications

Future shipment notifications will include:

Shipment Created
Price Confirmed
Shipment Picked Up
Hub Arrival
Out For Delivery
Delivered
Failed Delivery
Returned
Payment Updates
COD Updates

The initial notification implementation is planned around email, with SMS and push notifications as future integrations.

📄 Invoice & Receipt

A future invoice module will allow customers to download shipment invoices/receipts.

The invoice is planned to contain:

Shipment details
Tracking number
Customer information
Origin
Destination
Package details
Priority
Shipping cost
COD information
Payment information
Invoice date
⭐ Delivery Rating

After a shipment is successfully delivered, customers will be able to submit:

Rating: 1–5 stars
Feedback: Optional

The system will enforce one rating per shipment.

🛡️ API Security

The application uses Spring Security for role-based API protection.

API Access Structure
/auth/**

Authentication endpoints
        ↓
Public
/api/admin/**

ADMIN only
/api/delivery/**

DELIVERY_AGENT
+
ADMIN
/api/customer/**

CUSTOMER
+
ADMIN

Other protected APIs require authentication.

🧪 Validation

Request DTOs use Jakarta Bean Validation.

Validation currently covers areas such as:

Required fields
Indian mobile number format
Indian six-digit PIN codes
Positive package dimensions
Positive package weight
Required priority
Non-negative distance
Required shipment status
Maximum text lengths
⚠️ Error Handling

The application uses centralized exception handling to provide structured API errors.

Example:

{
  "message": "Validation Failed",
  "validationErrors": {
    "postalCode": "Invalid postal code"
  }
}

Business-rule violations are also returned as structured errors.

Example:

{
  "status": 400,
  "error": "Bad Request",
  "message": "Shipment cannot be assigned in its current status: DELIVERED"
}
🧪 Testing

Postman is currently used for API-level testing.

Tested Authentication
Customer registration
Customer login
Admin login
Delivery Agent login
JWT authentication
Role-based authorization
Google OAuth authentication
Tested Shipment Features
Shipment creation
Shipment retrieval
Shipment update
Shipment cancellation
Price estimation
Admin pricing configuration
Tracking history
Status updates
Valid status transitions
Invalid status transitions
Tested Delivery Agent Features
Delivery Agent login
View assigned shipments
Admin shipment assignment
Delivery Agent assignment validation
Unauthorized access protection
Already-assigned shipment protection
Invalid shipment-state protection
🔬 Example End-to-End Assignment Test
1. Customer logs in
        ↓
2. Customer creates shipment
        ↓
3. Shipment starts as CREATED
        ↓
4. Admin logs in
        ↓
5. Admin assigns shipment to Delivery Agent
        ↓
6. assignedDeliveryAgentId is saved
        ↓
7. Delivery Agent logs in
        ↓
8. Delivery Agent calls:
   GET /api/delivery/shipments
        ↓
9. Assigned shipment is returned

This flow has been tested successfully using Postman.

📊 Development Status
🟢 Completed
Feature	Status
Spring Boot Project Setup	✅
Java 21 Configuration	✅
Maven Configuration	✅
MongoDB Configuration	✅
User Entity	✅
User Repository	✅
Local Registration	✅
Local Login	✅
Username / Email Login	✅
BCrypt Password Hashing	✅
JWT Access Token	✅
JWT Refresh Token	✅
JWT Authentication Filter	✅
Security Context Authentication	✅
Role-Based Authorization	✅
CUSTOMER Role	✅
DELIVERY_AGENT Role	✅
HUB_OPERATOR Role	✅
ADMIN Role	✅
Google OAuth 2.0	✅
Shipment Entity	✅
Shipment Repository	✅
Shipment DTOs	✅
Shipment Validation	✅
Shipment Creation	✅
Tracking Number Generation	✅
Shipment Retrieval	✅
Customer Shipment Retrieval	✅
Shipment Update	✅
Shipment Cancellation	✅
Pricing Configuration	✅
Admin Pricing API	✅
Price Estimate API	✅
Server-Side Pricing	✅
Tracking History	✅
Tracking Event Creation	✅
Shipment Status Transition Engine	✅
Valid Status Transition Validation	✅
Invalid Status Transition Protection	✅
Terminal State Protection	✅
Delivery Agent Authentication	✅
Delivery Agent Assigned Shipments	✅
Admin Shipment Assignment	✅
Assignment Validation	✅
Postman API Testing	✅
🚧 Currently In Development
Feature	Status
Accept / Reject Assignment	🚧 Next
Pickup Workflow	🚧 Next
In-Transit Workflow	🚧 Next
Out-for-Delivery Workflow	🚧 Next
Delivery Confirmation	🚧 Next
Failed Delivery Workflow	🚧 Next
Delivery Proof	🚧 Next
OTP Verification	🚧 Next
COD Collection	🚧 Next
🔵 Planned Modules
Module	Status
Hub Management	⬜ Planned
Hub Operator APIs	⬜ Planned
Shipment Hub Routing	⬜ Planned
Hub Scan-In / Scan-Out	⬜ Planned
Hub Inventory	⬜ Planned
Shipment Pagination	⬜ Planned
Shipment Search	⬜ Planned
Shipment Filtering	⬜ Planned
Swagger / OpenAPI	⬜ Planned
Automated Unit Tests	⬜ Planned
Integration Tests	⬜ Planned
COD Settlement	⬜ Planned
Online Payment Gateway	⬜ Planned
Payment Abstraction	⬜ Planned
Email Notifications	⬜ Planned
SMS Notifications	⬜ Planned
Push Notifications	⬜ Planned
Invoice / PDF Receipt	⬜ Planned
Delivery Rating	⬜ Planned
Admin Reports	⬜ Planned
Audit Logs	⬜ Planned
Automatic Agent Assignment	⬜ Planned
Maps / Geocoding	⬜ Planned
Distance Calculation	⬜ Planned
ETA Calculation	⬜ Planned
Scheduled Jobs	⬜ Planned
Dockerization	⬜ Planned
Production Deployment	⬜ Planned
Monitoring & Observability	⬜ Planned
🗺️ Development Roadmap
Phase 1 — Foundation
Project Setup
     ↓
Java 21
     ↓
Spring Boot
     ↓
MongoDB
     ↓
JWT Authentication
     ↓
Google OAuth
     ↓
Spring Security

Status: ✅ Completed

Phase 2 — Shipment Management
Shipment CRUD
     ↓
Validation
     ↓
Pricing
     ↓
Price Estimation
     ↓
Cancellation
     ↓
Tracking History

Status: ✅ Completed

Phase 3 — Shipment Workflow & Delivery Assignment
Status Transition Engine
     ↓
Delivery Agent
     ↓
Shipment Assignment
     ↓
Assigned Shipment Retrieval

Status: ✅ Completed

Phase 4 — Delivery Operations
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
Failed Delivery
     ↓
COD Collection

Status: 🚧 In Development

Phase 5 — Hub Operations
Hub Management
     ↓
Hub Operators
     ↓
Shipment Routing
     ↓
Scan-In / Scan-Out
     ↓
Hub Inventory

Status: ⬜ Planned

Phase 6 — Platform Services
Payments
     ↓
Notifications
     ↓
Invoices
     ↓
Ratings
     ↓
Reports
     ↓
Audit Logs

Status: ⬜ Planned

Phase 7 — Production Hardening
Pagination
     ↓
Search & Filtering
     ↓
Swagger / OpenAPI
     ↓
Automated Tests
     ↓
Docker
     ↓
Deployment
     ↓
Monitoring

Status: ⬜ Planned

🧱 Production-Oriented Engineering Goals

This project is intentionally being developed beyond basic CRUD operations.

The long-term engineering goals include:

Clean layered architecture
DTO-based API contracts
Entity/DTO separation
Mapper-based conversion
Centralized business logic
Role-based authorization
JWT authentication
OAuth 2.0
Server-side pricing
Shipment state-machine validation
Ownership validation
Input validation
Centralized exception handling
Structured logging
MongoDB indexes
Pagination
Search and filtering
Automated testing
API documentation
Environment-based configuration
Secure secret management
Docker support
Production deployment
Monitoring and observability
📈 Scalability Direction

The current system is intentionally designed as a modular monolith.

This keeps the architecture manageable while the platform is still being developed.

As the system grows, modules could eventually be separated into independent services if there is a genuine operational requirement.

Potential Future Architecture
                       API Gateway
                           │
          ┌────────────────┼────────────────┐
          │                │                │
          ▼                ▼                ▼
   Authentication      Shipment          Pricing
      Service           Service           Service
          │                │                │
          └────────────────┼────────────────┘
                           │
          ┌────────────────┼────────────────┐
          ▼                ▼                ▼
        Hub             Delivery          Payment
      Service            Service          Service
          │                │                │
          └────────────────┼────────────────┘
                           ▼
                    Notification
                       Service

For V1, these capabilities remain inside a single Spring Boot application to avoid unnecessary distributed-system complexity.

⚙️ Local Setup
Prerequisites

Install:

Java 21
Maven
MongoDB
Git
Postman
Spring Tool Suite / IntelliJ IDEA / Eclipse
📥 Clone Repository
git clone https://github.com/iLovishSaluja/logistics-platform.git
cd logistics-platform
🔧 Configuration

Do not commit real passwords, API keys, OAuth secrets or JWT secrets to GitHub.

Example environment-based configuration:

spring.data.mongodb.uri=${MONGODB_URI}

spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}

spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}

jwt.secret=${JWT_SECRET}
▶️ Run the Application

Using Maven Wrapper:

mvnw clean install

Windows:

mvnw.cmd clean install

Run:

mvnw spring-boot:run

Windows:

mvnw.cmd spring-boot:run

Application runs on:

http://localhost:8081
⚙️ Current Server Configuration

Development port:

server.port=8081

The project is designed so environment-specific configuration and secrets can be separated from source code as the application moves toward deployment.

📡 API Overview
Authentication
POST /auth/register
POST /auth/login
Shipment APIs
POST   /api/shipments
POST   /api/shipments/estimate

GET    /api/shipments/{id}
GET    /api/shipments/my

GET    /api/shipments/tracking/{trackingNumber}
GET    /api/shipments/tracking/{trackingNumber}/history

PUT    /api/shipments/{id}
PATCH  /api/shipments/{id}/cancel

PATCH  /api/shipments/{shipmentId}/status
Admin APIs
POST /api/admin/pricing
GET  /api/admin/pricing/active

POST /api/admin/shipments/{shipmentId}/assign
Delivery Agent APIs
GET /api/delivery/shipments

Additional Delivery Agent APIs will be introduced as the operational workflow is implemented.

🔒 Security Design Principles

The project follows several security principles:

1. Never trust client-provided ownership

For example, customers do not submit a customerId to retrieve their shipments.

The backend identifies the authenticated customer from the JWT/security context.

2. Server controls pricing

The client can request an estimate, but cannot dictate the final shipment price.

3. Role-based authorization

Different operational roles receive access only to their relevant API areas.

4. Business-state validation

Shipment status changes are controlled through a centralized transition engine.

5. Password security

Local passwords are stored using BCrypt hashing rather than plaintext.

6. OAuth identity separation

Google authentication is handled separately from local password authentication.

📚 Core Domain Concepts

The platform is being designed around these primary domain concepts:

User
 │
 ├── CUSTOMER
 ├── DELIVERY_AGENT
 ├── HUB_OPERATOR
 └── ADMIN

Shipment
 │
 ├── Address
 ├── PackageDetails
 ├── Pricing
 ├── Status
 ├── TrackingHistory
 └── DeliveryAgent Assignment

PricingConfig
 │
 ├── Base Charge
 ├── Per KG Rate
 ├── Per KM Rate
 ├── Priority Multipliers
 └── COD Fee

Future domain concepts:

Hub
Payment
Invoice
Rating
Notification
AuditLog
DeliveryProof
CODSettlement
📋 Current Project State

The project has progressed beyond a basic authentication + CRUD backend.

The currently implemented backend flow is:

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

The next major development stage is completing the delivery-agent operational workflow.

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
🤝 Development Philosophy

The project is being developed feature-by-feature with emphasis on:

Design
  ↓
Implementation
  ↓
Validation
  ↓
Business Rules
  ↓
Security
  ↓
API Testing
  ↓
Documentation

Each major feature is tested through the API before moving to the next stage.

The objective is to build a backend that demonstrates practical understanding of:

Java
Spring Boot
Spring Security
REST API design
MongoDB
Authentication
Authorization
Business-rule implementation
State-machine design
Service-layer architecture
DTOs and validation
Production-oriented backend engineering
👤 Author
Lovish Saluja
Java Backend Developer
Java
Spring Boot
Spring Security
MongoDB
REST APIs
JWT
OAuth 2.0
Maven
🚚 Logistics Platform
Building a production-style logistics backend with Java & Spring Boot.

⭐ If you find the project interesting, consider giving the repository a star.
