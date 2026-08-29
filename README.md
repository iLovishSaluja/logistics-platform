# 🚚 Logistics Platform

### Production-Style Logistics & Shipment Management Platform

A production-oriented backend platform designed to manage the complete logistics workflow — from customer registration and shipment creation to tracking, hub operations, delivery assignment, notifications, and final delivery.

Built with **Java, Spring Boot, Spring Security, JWT, OAuth 2.0, MongoDB and REST APIs**, with a strong focus on clean architecture, validation, security, business workflows, testing and maintainability.

---

## 📌 Project Overview

The Logistics Platform simulates a real-world shipment and delivery management system.

It provides different capabilities for:

- 👤 Customers
- 🛠️ Administrators
- 🚚 Delivery Agents
- 🏢 Logistics Hubs

The platform manages the complete shipment lifecycle:

```text
Customer
   │
   ▼
Create Shipment
   │
   ▼
Shipment Confirmed
   │
   ▼
Picked Up
   │
   ▼
In Transit
   │
   ▼
Hub Processing
   │
   ▼
Out for Delivery
   │
   ▼
Delivered
```

Exceptional shipment states are also supported:

```text
CANCELLED
FAILED_DELIVERY
RETURNED
```

---

## ✨ Key Features

### 🔐 Authentication & Authorization

- User registration
- User login
- Login using username or email
- JWT-based authentication
- Access tokens
- Refresh tokens
- Google OAuth 2.0 authentication
- BCrypt password hashing
- Role-based authorization
- Account enable/disable
- Authentication provider tracking
- Secure protected APIs

**Supported Roles**

```text
CUSTOMER
ADMIN
DELIVERY_AGENT
```

**Authentication Providers**

```text
LOCAL
GOOGLE
```

---

### 👤 User Management

Customers can:

- Create an account
- Login securely
- Login using Google
- View profile information
- Access authorized customer APIs

Administrators can manage users and operational access.

---

### 📦 Shipment Management

Customers will be able to create shipments containing:

- Pickup address
- Delivery address
- Sender details
- Receiver details
- Package type
- Package weight
- Package dimensions
- Delivery priority

Each shipment receives a unique tracking number.

Example:

```text
TRK-2026-8A72F
```

---

### 🔄 Shipment Lifecycle

Shipments follow a controlled business workflow.

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

Exceptional states:

```text
CANCELLED
FAILED_DELIVERY
RETURNED
```

Invalid status transitions will be prevented through backend business logic.

---

### 📍 Shipment Tracking

The platform maintains a complete tracking history instead of storing only the current shipment status.

Example:

```text
TRK-2026-8A72F

✓ Shipment Created
  21 Aug, 10:32 AM

✓ Pickup Completed
  21 Aug, 04:15 PM

✓ Arrived at Delhi Hub
  22 Aug, 08:40 AM

✓ In Transit
  22 Aug, 11:20 AM

○ Out for Delivery

○ Delivered
```

Each tracking event can contain:

- Status
- Timestamp
- Location
- Description
- Updated by

---

### 🏢 Hub & Warehouse Management

The platform will support logistics hubs through which shipments move.

Example:

```text
Yamunanagar Hub
      ↓
Chandigarh Hub
      ↓
Delhi Hub
      ↓
Destination Hub
```

Hub functionality will include:

- Hub creation
- Hub management
- Shipment assignment to hubs
- Shipment movement between hubs
- Hub-based tracking
- Operational shipment management

---

### 🚚 Delivery Agent Management

Administrators/operations staff can assign shipments to delivery agents.

Delivery agents will be able to:

- View assigned shipments
- Accept assignments
- Update shipment status
- Confirm pickup
- Mark shipment out for delivery
- Mark delivery successful
- Report failed delivery
- Add delivery notes

---

### 💰 Shipment Pricing

The platform will include a backend pricing engine.

Shipping cost can be calculated using:

```text
Base Charge
     +
Weight Charge
     +
Distance Charge
     +
Priority Charge
     =
Final Shipping Cost
```

The pricing logic will be implemented as reusable backend business logic rather than hardcoded inside controllers.

---

### 🗺️ Maps & Distance Integration

The platform will integrate with an external geocoding/distance service.

Workflow:

```text
Pickup Address
       ↓
Geocoding API
       ↓
Latitude / Longitude

Delivery Address
       ↓
Geocoding API
       ↓
Latitude / Longitude

       ↓
Distance Calculation
       ↓
Shipping Cost + ETA
```

This allows the system to calculate logistics information dynamically.

---

### ⏱️ Estimated Delivery Time

The platform will calculate an estimated delivery date/time based on factors such as:

- Shipment distance
- Delivery priority
- Current shipment status
- Hub processing
- Delivery workflow

---

### 📧 Notifications

Important shipment events will trigger notifications.

Examples:

```text
Shipment Created        → Notification
Shipment Picked Up      → Notification
Shipment Arrived at Hub → Notification
Out for Delivery        → Notification
Shipment Delivered      → Notification
```

Email notifications will be implemented first.

---

### 🛠️ Admin Operations

Administrators will have access to operational APIs for:

- User management
- Shipment management
- Hub management
- Delivery-agent management
- Shipment assignment
- Shipment monitoring
- Operational statistics

Admin APIs will be protected using role-based authorization.

---

### 🔎 Search & Filtering

Operations users will be able to search and filter shipments using:

- Tracking number
- Customer
- Shipment status
- Hub
- Delivery agent
- Date range

This will make the platform more suitable for real operational usage.

---

### ⏰ Scheduled Background Jobs

Spring scheduled jobs will be used for background operations such as:

- Detecting delayed shipments
- Detecting shipments stuck in a status
- Updating overdue shipments
- Sending delayed-shipment notifications
- Periodic ETA updates

---

## 🏗️ Architecture

The project follows a **modular monolithic architecture**.

```text
                    Client / Frontend
                           │
                           ▼
                       REST APIs
                           │
             ┌─────────────┴─────────────┐
             │                           │
      Authentication                 Logistics
             │                           │
      ┌──────┴──────┐          ┌─────────┴─────────┐
      │             │          │                   │
     JWT        Google OAuth  Shipment          Tracking
                               │                   │
                               ├── Hub             │
                               ├── Delivery        │
                               ├── Pricing         │
                               └── ETA             │
             │                           │
             └─────────────┬─────────────┘
                           │
                           ▼
                        MongoDB
                           │
              ┌────────────┼────────────┐
              ▼            ▼            ▼
            Users       Shipments      Hubs
```

The project intentionally uses a **modular monolith instead of microservices** for V1 to keep the system maintainable while still demonstrating real backend architecture.

---

## 🧩 Backend Architecture

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
Exception Handling
Security
Configuration
OAuth
Validation
```

---

## 📁 Project Structure

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

The structure will evolve as additional logistics modules are implemented.

---

## 🛡️ Security

Security is a major part of the platform.

Implemented/planned security mechanisms include:

- Spring Security
- JWT authentication
- JWT request filtering
- BCrypt password hashing
- OAuth 2.0
- Google authentication
- Role-based authorization
- Protected REST endpoints
- Input validation
- Global exception handling
- Environment-based secret configuration

Sensitive credentials are never intended to be committed to the repository.

Example:

```properties
spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}
spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}
```

---

## 🔑 JWT Authentication Flow

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

For protected requests:

```text
Client
  ↓
Authorization: Bearer <JWT>
  ↓
JWT Authentication Filter
  ↓
Validate Token
  ↓
Load User
  ↓
Check Role
  ↓
Allow / Reject Request
```

---

## 🌐 Google OAuth Flow

```text
Client
   ↓
/oauth2/authorization/google
   ↓
Google Authentication
   ↓
Google Callback
   ↓
GoogleOAuth2SuccessHandler
   ↓
Find Existing User
   │
   ├── Existing Google User
   │
   └── New Google User
            ↓
       Create User
            ↓
    GOOGLE + CUSTOMER
            ↓
       Generate JWT
            ↓
       Authentication
```

---

## 🗄️ Database

### MongoDB

MongoDB is used as the primary database because the platform contains flexible logistics entities and event-oriented tracking information.

Planned core collections include:

```text
users
shipments
tracking_events
hubs
delivery_agents
notifications
```

The exact collection structure will evolve as the corresponding modules are implemented.

---

## 🛠️ Technology Stack

| Category | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot |
| Security | Spring Security |
| Authentication | JWT + OAuth 2.0 |
| OAuth Provider | Google |
| Database | MongoDB |
| Database Access | Spring Data MongoDB |
| API Style | REST |
| Validation | Jakarta Bean Validation |
| Password Hashing | BCrypt |
| Build Tool | Maven |
| API Testing | Postman |
| Testing | JUnit / Mockito / Spring Boot Test |
| Version Control | Git |
| Repository | GitHub |
| IDE | Spring Tool Suite / Eclipse |
| External Integration | Maps / Geocoding API |
| Notifications | Email |

---

## 📡 API Overview

### Authentication

| Method | Endpoint | Access | Status |
|---|---|---|---|
| POST | `/auth/register` | Public | ✅ Implemented |
| POST | `/auth/login` | Public | ✅ Implemented |
| GET | `/oauth2/authorization/google` | Public | ✅ Implemented |
| GET | `/login/oauth2/code/google` | Google OAuth | ✅ Implemented |

### Customer APIs

| Method | Endpoint | Access | Status |
|---|---|---|---|
| POST | `/api/customer/shipments` | CUSTOMER | ⬜ Planned |
| GET | `/api/customer/shipments` | CUSTOMER | ⬜ Planned |
| GET | `/api/customer/shipments/{id}` | CUSTOMER | ⬜ Planned |
| GET | `/api/customer/tracking/{trackingNumber}` | CUSTOMER | ⬜ Planned |

### Admin APIs

| Method | Endpoint | Access | Status |
|---|---|---|---|
| GET | `/api/admin/shipments` | ADMIN | ⬜ Planned |
| GET | `/api/admin/users` | ADMIN | ⬜ Planned |
| POST | `/api/admin/hubs` | ADMIN | ⬜ Planned |
| POST | `/api/admin/assign` | ADMIN | ⬜ Planned |

### Delivery APIs

| Method | Endpoint | Access | Status |
|---|---|---|---|
| GET | `/api/delivery/shipments` | DELIVERY_AGENT | ⬜ Planned |
| PUT | `/api/delivery/shipments/{id}/status` | DELIVERY_AGENT | ⬜ Planned |
| POST | `/api/delivery/shipments/{id}/notes` | DELIVERY_AGENT | ⬜ Planned |

> API endpoints will be updated as each module is implemented.

---

## 📊 Development Status

| Module | Status |
|---|---|
| Spring Boot Project Setup | ✅ Complete |
| MongoDB Configuration | ✅ Complete |
| User Entity | ✅ Complete |
| Local Registration | ✅ Complete |
| Local Login | ✅ Complete |
| BCrypt Password Hashing | ✅ Complete |
| JWT Access Token | ✅ Complete |
| JWT Refresh Token | ✅ Complete |
| Role-Based Authorization | ✅ Complete |
| `CUSTOMER` Role | ✅ Complete |
| `ADMIN` Role | ✅ Complete |
| `DELIVERY_AGENT` Role | ✅ Complete |
| `LOCAL` Auth Provider | ✅ Complete |
| Google OAuth | ✅ Complete |
| `GOOGLE` Auth Provider | ✅ Complete |
| Shipment Entity | ⬜ Upcoming |
| Shipment Creation | ⬜ Upcoming |
| Shipment Lifecycle | ⬜ Upcoming |
| Tracking Events | ⬜ Upcoming |
| Hub Management | ⬜ Upcoming |
| Delivery Assignment | ⬜ Upcoming |
| Pricing Engine | ⬜ Upcoming |
| Distance Integration | ⬜ Upcoming |
| ETA Calculation | ⬜ Upcoming |
| Email Notifications | ⬜ Upcoming |
| Search & Filtering | ⬜ Upcoming |
| Scheduled Jobs | ⬜ Upcoming |
| Global Exception Handling | 🚧 In Progress |
| Comprehensive Testing | 🚧 In Progress |
| API Documentation | 🚧 In Progress |
| Production Deployment | ⬜ Upcoming |

---

## 🧪 Testing Strategy

Testing will be performed throughout development rather than only at the end.

**Authentication Testing**
- Registration validation
- Duplicate username
- Duplicate email
- Invalid credentials
- JWT validation
- Expired JWT
- Role authorization
- Google OAuth
- Disabled users

**Shipment Testing**
- Valid shipment creation
- Invalid addresses
- Invalid package details
- Invalid status transitions
- Tracking number generation
- Shipment ownership

**Delivery Testing**
- Assignment validation
- Agent authorization
- Delivery status transitions
- Failed delivery
- Successful delivery

**Integration Testing**

The project will include tests for:

```text
Controller
   ↓
Service
   ↓
Repository
   ↓
MongoDB
```

---

## 📮 API Testing with Postman

Postman will be used for manual API testing during development.

Authentication example:

```http
POST /auth/register
POST /auth/login
```

Protected APIs will use:

```http
Authorization: Bearer <access-token>
```

Postman collections will be maintained as the API surface grows.

---

## ⚙️ Local Setup

### Prerequisites

Install the following before running the project:

- Java 21
- Maven
- MongoDB
- Git
- Postman
- IDE such as Spring Tool Suite / IntelliJ IDEA / Eclipse

### Clone the Repository

```bash
git clone https://github.com/<your-username>/logistics-platform.git
cd logistics-platform
```

### Configure Environment Variables

Create your MongoDB connection and Google OAuth credentials as environment variables (never commit real secrets):

```properties
spring.data.mongodb.uri=${MONGODB_URI}
spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}
spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}
jwt.secret=${JWT_SECRET}
```

### Build the Project

```bash
mvnw clean install
```

### Run the Project

```bash
mvnw spring-boot:run
```

The application will start on the configured port (default: `8080`).

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome. Feel free to check the [issues page](../../issues) or open a pull request.

---

## 📄 License

This project is currently unlicensed / for personal and educational use. Update this section with your chosen license (e.g., MIT) before making the repository public.

---

## 👤 Author

**Lovish**
Backend Developer — Java • Spring Boot • MongoDB

---

<p align="center">⭐ If you find this project interesting, consider giving it a star!</p>
