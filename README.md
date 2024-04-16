## Reminder Architecture
This repository contains the Reminder Architecture project, which implements a reminder management system using a microservices architecture.

## Overview
The Reminder Architecture project consists of frontend (Angular), backend (Java Spring Boot), and associated microservices for handling reminder management tasks. It utilizes cloud services (AWS) for deployment and MongoDB for data persistence.

---
## Installation
To run the project locally, follow these steps:

Clone the repository:

```bash
git clone https://github.com/yourusername/reminder-architecture.git
```

Backend Setup:

Navigate to the backend directory:

```bash
cd reminder-architecture/backend
```

Install dependencies:

```bash
mvn clean install
```

Start the backend server:

```bash
mvn spring-boot:run
```

Frontend Setup:

Navigate to the frontend directory:

```bash
cd reminder-architecture/frontend
```

Install dependencies:

```bash
npm install
```

Start the frontend server:

```bash
npm start
```

Access the Application:

Open your browser and navigate to ```http://localhost:4200```. to access the Angular frontend.

---
## API Documentation
The API endpoints are documented using Swagger (OpenAPI). You can find the Swagger contract in the docs/swagger directory.

---
# Folder Structure
    backend: Contains the Java Spring Boot backend application.
    frontend: Contains the Angular frontend application.
    docs: Contains documentation related to the project.
    docs/diagrams: Architecture diagrams (context, container, component).
    docs/swagger: Swagger (OpenAPI) contract for the API.

---
## Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow these guidelines:

Fork the repository.

Create a new branch 
```git checkout -b feature/my-feature```.

Commit your changes 
```git commit -am 'Add new feature'```.

Push to the branch 
```git push origin feature/my-feature```.

Create a new Pull Request.

---
## License
This project is licensed under the MIT License.

