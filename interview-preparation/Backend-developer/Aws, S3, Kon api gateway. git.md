# 🚀 AWS, Docker, Kong & Git (Interview Ready)

## 📌 Table of Contents
1. [🧩 1. EC2 (Compute)](#-1-ec2-compute)
2. [🧩 2. S3 (Storage)](#-2-s3-storage)
3. [🧩 3. RDS (Database)](#-3-rds-database)
4. [🚀 🐳 Docker](#-docker)
5. [🚀 🌐 Kong API Gateway](#-kong-api-gateway)
6. [🚀 🔧 Git](#-git)
7. [🚀 🔥 Final Combined Interview Answer](#-final-combined-interview-answer)
8. [🎯 Q1: How would you deploy a Node.js application using AWS and Docker?](#-q1-how-would-you-deploy-a-nodejs-application-using-aws-and-docker)
9. [🎯 Q2: What is the role of an API Gateway like Kong?](#-q2-what-is-the-role-of-an-api-gateway-like-kong)
10. [🎯 Q3: Difference between EC2 and Docker?](#-q3-difference-between-ec2-and-docker)

---

## 🧩 1. EC2 (Compute)

### ✅ WHAT
> Amazon EC2 is a virtual server in the cloud used to run applications.

### ✅ WHY
*   **Host backend apps**: Reliable infrastructure for servers.
*   **Full control**: Direct access to the operating system.
*   **Scalable**: Easily increase or decrease resources.

### ✅ HOW
1.  Launch instance
2.  Install Node.js
3.  Deploy app

### 💡 EXAMPLE
`Frontend → EC2 (Node API) → Database`

### 💥 INTERVIEW ANSWER
> EC2 is used to host backend services. We can deploy Node.js applications on EC2 instances and scale them based on traffic.

---

## 🧩 2. S3 (Storage)

### ✅ WHAT
> Amazon S3 is an object storage service for storing files like images, videos, and backups.

### ✅ WHY
*   **Large file storage**: Optimized for static assets.
*   **Highly scalable**: Stores any amount of data.
*   **Durable**: 99.999999999% durability.

### ✅ HOW
1.  Upload files via API
2.  Store URL in DB

### 💡 EXAMPLE
`User uploads image → S3 → URL saved in DB`

### 💥 INTERVIEW ANSWER
> S3 is used for storing static assets like images and documents. It is highly scalable and integrates well with backend systems.

---

## 🧩 3. RDS (Database)

### ✅ WHAT
> Amazon RDS is a managed relational database service.

### ✅ WHY
*   **No DB maintenance**: AWS handles patching and backups.
*   **Automatic backups**: Easy disaster recovery.
*   **Scaling**: Scale storage and compute with a few clicks.

### ✅ HOW
1.  Create DB instance
2.  Connect via credentials

### 💡 EXAMPLE
`Backend → RDS (PostgreSQL)`

### 💥 INTERVIEW ANSWER
> RDS provides managed database services like PostgreSQL, allowing us to focus on application logic instead of database maintenance.

---

## 🚀 🐳 Docker

### 🧩 WHAT
> Docker is a platform to package applications into containers.

### ✅ WHY
*   **Same environment everywhere**: Works on dev, staging, and prod.
*   **Easy deployment**: Simplified CI/CD pipelines.
*   **Isolation**: Apps run independently of the host OS.

### ✅ HOW
```bash
docker build -t app .
docker run -p 3000:3000 app
```

### 💡 EXAMPLE
`App + Dependencies → Docker Container → Runs anywhere`

### 💥 INTERVIEW ANSWER
> Docker allows us to containerize applications with all dependencies, ensuring consistency across development and production environments.

### 🔥 FOLLOW-UP
👉 **“Difference between Docker and VM?”**

### ✅ Answer
> Docker shares the OS kernel (lightweight), while VMs run a full OS (heavy).

---

## 🚀 🌐 Kong API Gateway

### 🧩 WHAT
> Kong API Gateway is an API gateway that manages and routes requests to backend services.

### ✅ WHY
*   **Centralized authentication**: One place to secure all APIs.
*   **Rate limiting**: Protect services from abuse.
*   **Routing**: Direct traffic to the right microservice.
*   **Monitoring**: Unified logging and metrics.

### ✅ HOW
1.  Define routes
2.  Add plugins (JWT, CORS, rate limit)

### 💡 EXAMPLE
`Client → Kong → Multiple Services`

### 💥 INTERVIEW ANSWER
> Kong acts as a central API gateway that handles authentication, rate limiting, and routing, improving security and scalability.

### 🔥 FOLLOW-UP
👉 **“Why use Kong instead of backend logic?”**

### ✅ Answer
> It centralizes cross-cutting concerns like auth and rate limiting, reducing duplication across services.

---

## 🚀 🔧 Git

### 🧩 WHAT
> Git is a distributed version control system.

### ✅ WHY
*   **Track changes**: See history of every line of code.
*   **Collaboration**: Multiple developers on one project.
*   **Code history**: Roll back to any previous version.

### ✅ HOW
```bash
git add .
git commit -m "message"
git push
```

### 💡 EXAMPLE
`Feature branch → PR → Merge`

### 💥 INTERVIEW ANSWER
> Git is used for version control, enabling collaboration and tracking code changes efficiently through branching and merging strategies.

### 🔥 IMPORTANT CONCEPTS
*   **🔹 Branching**: `feature branch`, `main`.
*   **🔹 Merge vs Rebase**:
    *   👉 **Merge**: Keeps full history.
    *   👉 **Rebase**: Maintains clean/flat history.

---

## 🚀 🔥 Final Combined Interview Answer

> I have experience working with AWS services like EC2 for hosting backend applications, S3 for storing files, and RDS for managing PostgreSQL databases. I use Docker to containerize applications for consistent deployment across environments. I am also familiar with Kong API Gateway for handling authentication, rate limiting, and routing. For version control, I use Git for collaboration, branching, and managing code history efficiently.

---

## 🎯 Q1: How would you deploy a Node.js application using AWS and Docker?

### ❌ Weak Answer
> Use Docker and deploy on AWS. (Too vague.)

### ✅ Perfect Structured Answer

#### ✅ WHAT
Deploy a containerized Node.js app on cloud infrastructure.

#### ✅ HOW (Step-by-step)
1.  **Containerize** the application using Docker: `docker build -t my-app .`
2.  **Push** the image to a registry (e.g., Docker Hub or AWS ECR).
3.  **Launch** an Amazon EC2 instance.
4.  **Pull and run** the container on EC2: `docker run -p 3000:3000 my-app`
5.  **(Optional but strong 💥)**:
    *   Use Nginx as reverse proxy.
    *   Use Amazon RDS for DB.
    *   Use Amazon S3 for file storage.

### 💥 Final Answer (Interview Ready)
> I would first containerize the Node.js application using Docker and push the image to a registry. Then I would launch an EC2 instance, install Docker, and run the container. For production, I would use services like RDS for database management, S3 for storage, and optionally configure Nginx as a reverse proxy. This ensures scalability and consistency across environments.

---

## 🎯 Q2: What is the role of an API Gateway like Kong?

### ❌ Weak Answer
> It routes requests. (Not enough details.)

### ✅ Perfect Answer

#### ✅ WHAT
Kong API Gateway is a centralized layer that manages incoming API requests.

#### ✅ WHY
*   Centralized authentication.
*   Rate limiting.
*   Logging.
*   Routing.

#### ✅ HOW
`Client sends request → Kong → applies policies → forwards to service`

### 💡 EXAMPLE
`Client → Kong → Backend Services`

### 💥 Final Answer
> An API Gateway like Kong acts as a central entry point for all API requests. It handles cross-cutting concerns such as authentication, rate limiting, logging, and routing requests to appropriate backend services. This improves scalability, security, and maintainability by centralizing these functionalities instead of implementing them in each service.

---

## 🎯 Q3: Difference between EC2 and Docker?

### ❌ Weak Answer
> EC2 is server, Docker is container. (Too shallow.)

### ✅ Perfect Comparison

| Feature | Amazon EC2 | Docker |
| :--- | :--- | :--- |
| **Type** | Virtual machine | Container |
| **OS** | Full OS | Shares host OS |
| **Weight** | Heavy | Lightweight |
| **Startup** | Slow | Fast |
| **Use** | Infrastructure | App packaging |

### 💥 Final Answer
> EC2 is a virtual server that provides full infrastructure to run applications, while Docker is a containerization platform that packages applications with their dependencies. EC2 manages the server environment, whereas Docker ensures consistent application execution across environments. Typically, Docker containers are deployed on EC2 instances for scalable and portable deployments.

---

## 🚀 Final Feedback

### You’re now answering like:
*   ✅ Structured
*   ✅ Real-world
*   ✅ Production-aware

👉 **This is exactly what interviewers want.**