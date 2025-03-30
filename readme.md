<div id="top">

<!-- HEADER STYLE: CLASSIC -->
<div align="center">


# MISO-DEVOPS

<em>SpringBoot Projects based off Devops course of Uniandes MISO</em>

<!-- BADGES -->
<img src="https://img.shields.io/github/license/MartinGalvanCastro/miso-devops?style=default&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
<img src="https://img.shields.io/github/last-commit/MartinGalvanCastro/miso-devops?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
<img src="https://img.shields.io/github/languages/top/MartinGalvanCastro/miso-devops?style=default&color=0080ff" alt="repo-top-language">
<img src="https://img.shields.io/github/languages/count/MartinGalvanCastro/miso-devops?style=default&color=0080ff" alt="repo-language-count">

<!-- default option, no dependency badges. -->


<!-- default option, no dependency badges. -->

</div>
<br>

---

## Table of Contents

<details>
<summary>Table of Contents</summary>

- [Table of Contents](#table-of-contents)
- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
    - [Project Index](#project-index)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Usage](#usage)
    - [Testing](#testing)
- [Roadmap](#roadmap)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

</details>

---

## Overview

Project based on the course **MISO-4102** of the **University of Los Andes**, focused on **DevOps** practices and principles. The project is designed to:
- manage email blacklisting efficiently, utilizing a microservices architecture with Spring Boot.

---

## Features

|      | Component       | Details                              |
| :--- | :-------------- | :----------------------------------- |
| ⚙️  | **Architecture**  | <ul><li>Microservices-based design</li><li>Utilizes Spring Boot framework</li><li>Configuration via YAML files</li></ul> |
| 🔩 | **Code Quality**  | <ul><li>Gradle for build automation</li><li>Spotless for code formatting</li><li>Lombok for reducing boilerplate code</li></ul> |
| 📄 | **Documentation** | <ul><li>Configuration files for environments (local, test, cloud)</li><li>README file for project overview</li></ul> |
| 🔌 | **Integrations**  | <ul><li>GitHub Actions for CI/CD</li><li>Docker Compose for container orchestration</li></ul> |
| 🧩 | **Modularity**    | <ul><li>Separation of concerns through multiple Gradle modules</li><li>Reusable components across services</li></ul> |
| 🧪 | **Testing**       | <ul><li>Test configurations in YAML</li><li>Integration tests supported via Gradle</li></ul> |
| ⚡️  | **Performance**   | <ul><li>Optimized build process with Gradle</li><li>Asynchronous processing capabilities</li></ul> |
| 🛡️ | **Security**      | <ul><li>Environment-specific configurations for sensitive data</li><li>Use of secure coding practices</li></ul> |
| 📦 | **Dependencies**  | <ul><li>Gradle dependencies defined in build.gradle</li><li>Version management via libs.versions.toml</li></ul> |
| 🚀 | **Scalability**   | <ul><li>Containerization with Docker for easy scaling</li><li>Microservices architecture allows independent scaling</li></ul> |
```

### Explanation of the Table Components:

- **Architecture**: Highlights the microservices approach and the use of Spring Boot, which is a common framework for building Java applications.
- **Code Quality**: Focuses on the tools used for maintaining code quality, such as Gradle for builds and Spotless for formatting.
- **Documentation**: Mentions the presence of configuration files and a README, which are essential for understanding the project setup.
- **Integrations**: Lists the CI/CD tools and container orchestration methods used, indicating a modern development workflow.
- **Modularity**: Emphasizes the separation of concerns and reusability of components, which is crucial for maintainability.
- **Testing**: Points out the testing configurations and support for integration tests, which are vital for ensuring code reliability.
- **Performance**: Discusses optimizations in the build process and asynchronous capabilities, which can enhance application responsiveness.
- **Security**: Notes the use of environment-specific configurations to manage sensitive data securely.
- **Dependencies**: Details how dependencies are managed, which is important for project stability and updates.
- **Scalability**: Highlights the benefits of containerization and microservices for scaling applications effectively.

---

## Project Structure

```sh
└── miso-devops/
    ├── .github
    │   └── workflows
    ├── blacklist-api
    │   ├── build.gradle
    │   └── src
    ├── build.gradle
    ├── compose.yaml
    ├── git-hooks
    │   └── pre-commit.sh
    ├── gradle
    │   ├── libs.versions.toml
    │   ├── spotless.gradle
    │   └── wrapper
    ├── gradlew
    ├── gradlew.bat
    └── settings.gradle
```

### Project Index

<details open>
	<summary><b><code>MISO-DEVOPS/</code></b></summary>
	<!-- __root__ Submodule -->
	<details>
		<summary><b>__root__</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ __root__</b></code>
			<table style='width: 100%; border-collapse: collapse;'>
			<thead>
				<tr style='background-color: #f8f9fa;'>
					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
					<th style='text-align: left; padding: 8px;'>Summary</th>
				</tr>
			</thead>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/compose.yaml'>compose.yaml</a></b></td>
					<td style='padding: 8px;'>- Defines a PostgreSQL service within the projects architecture, facilitating the setup of a relational database for application data storage<br>- It configures essential parameters such as database name, user credentials, and port mapping, while also ensuring data persistence through volume management<br>- Additionally, it incorporates a health check mechanism to monitor the databases readiness, contributing to the overall reliability and robustness of the application environment.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/gradlew.bat'>gradlew.bat</a></b></td>
					<td style='padding: 8px;'>- Facilitates the execution of Gradle tasks on Windows systems by providing a startup script that sets up the necessary environment variables and configurations<br>- It ensures that the Java runtime is correctly located and initialized, allowing seamless integration with the Gradle build system<br>- This script is essential for managing project dependencies and automating the build process within the overall codebase architecture.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/build.gradle'>build.gradle</a></b></td>
					<td style='padding: 8px;'>- Defines the build configuration for a multi-module Java project, integrating essential plugins for Spring Boot, dependency management, and Hibernate<br>- Establishes a standardized environment with a specified Java version and centralized dependency management, ensuring consistent library versions across subprojects<br>- Additionally, configures Git hooks for streamlined version control practices, enhancing collaboration and code quality within the development workflow.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/settings.gradle'>settings.gradle</a></b></td>
					<td style='padding: 8px;'>- Defines the root project name as proyecto-devops and includes the blacklist-api module, establishing a foundational structure for the overall codebase<br>- Facilitates dependency management by specifying Maven Central as the repository, ensuring that necessary libraries and dependencies are readily accessible for the project's components, thereby streamlining the development process and enhancing collaboration among team members.</td>
				</tr>
			</table>
		</blockquote>
	</details>
	<!-- gradle Submodule -->
	<details>
		<summary><b>gradle</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ gradle</b></code>
			<table style='width: 100%; border-collapse: collapse;'>
			<thead>
				<tr style='background-color: #f8f9fa;'>
					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
					<th style='text-align: left; padding: 8px;'>Summary</th>
				</tr>
			</thead>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/gradle/libs.versions.toml'>libs.versions.toml</a></b></td>
					<td style='padding: 8px;'>- Version management centralizes dependency and plugin specifications for the project, ensuring consistent and up-to-date libraries across the codebase<br>- By defining versions for key frameworks like Spring Boot, Hibernate, and PostgreSQL, it streamlines development and enhances maintainability<br>- This approach facilitates integration with various tools and libraries, ultimately supporting the overall architectures stability and scalability.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/gradle/spotless.gradle'>spotless.gradle</a></b></td>
					<td style='padding: 8px;'>- Enforces consistent code formatting across the project by applying the Spotless plugin<br>- It ensures Java files adhere to the Google Java Format standard while also managing formatting for various file types, including Gradle, Markdown, and YAML<br>- This contributes to improved code readability and maintainability, fostering a collaborative development environment within the overall codebase architecture.</td>
				</tr>
			</table>
		</blockquote>
	</details>
	<!-- blacklist-api Submodule -->
	<details>
		<summary><b>blacklist-api</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ blacklist-api</b></code>
			<table style='width: 100%; border-collapse: collapse;'>
			<thead>
				<tr style='background-color: #f8f9fa;'>
					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
					<th style='text-align: left; padding: 8px;'>Summary</th>
				</tr>
			</thead>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/build.gradle'>build.gradle</a></b></td>
					<td style='padding: 8px;'>- Defines the build configuration for the Blacklist API, leveraging Spring Boot and Hibernate to facilitate web services and data management<br>- It establishes essential dependencies for web functionality, security, and database interactions, while also enabling development tools and testing capabilities<br>- The configuration supports a layered JAR structure, optimizing deployment and enhancing application performance within the overall project architecture.</td>
				</tr>
			</table>
			<!-- src Submodule -->
			<details>
				<summary><b>src</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ blacklist-api.src</b></code>
					<!-- main Submodule -->
					<details>
						<summary><b>main</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ blacklist-api.src.main</b></code>
							<!-- java Submodule -->
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ blacklist-api.src.main.java</b></code>
									<!-- com Submodule -->
									<details>
										<summary><b>com</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ blacklist-api.src.main.java.com</b></code>
											<!-- example Submodule -->
											<details>
												<summary><b>example</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ blacklist-api.src.main.java.com.example</b></code>
													<!-- blacklistapi Submodule -->
													<details>
														<summary><b>blacklistapi</b></summary>
														<blockquote>
															<div class='directory-path' style='padding: 8px 0; color: #666;'>
																<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi</b></code>
															<table style='width: 100%; border-collapse: collapse;'>
															<thead>
																<tr style='background-color: #f8f9fa;'>
																	<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																	<th style='text-align: left; padding: 8px;'>Summary</th>
																</tr>
															</thead>
																<tr style='border-bottom: 1px solid #eee;'>
																	<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/BlacklistApiApplication.java'>BlacklistApiApplication.java</a></b></td>
																	<td style='padding: 8px;'>- Bootstrapping the Blacklist API application, the main entry point initializes the Spring Boot framework, enabling the application to run and serve requests<br>- It establishes the foundation for the entire codebase architecture, facilitating the integration of various components and services that manage and process blacklist data effectively within the broader system.</td>
																</tr>
															</table>
															<!-- application Submodule -->
															<details>
																<summary><b>application</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.application</b></code>
																	<!-- ports Submodule -->
																	<details>
																		<summary><b>ports</b></summary>
																		<blockquote>
																			<div class='directory-path' style='padding: 8px 0; color: #666;'>
																				<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.application.ports</b></code>
																			<!-- output Submodule -->
																			<details>
																				<summary><b>output</b></summary>
																				<blockquote>
																					<div class='directory-path' style='padding: 8px 0; color: #666;'>
																						<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.application.ports.output</b></code>
																					<table style='width: 100%; border-collapse: collapse;'>
																					<thead>
																						<tr style='background-color: #f8f9fa;'>
																							<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																							<th style='text-align: left; padding: 8px;'>Summary</th>
																						</tr>
																					</thead>
																						<tr style='border-bottom: 1px solid #eee;'>
																							<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/application/ports/output/BlacklistRepositoryPort.java'>BlacklistRepositoryPort.java</a></b></td>
																							<td style='padding: 8px;'>- Defines a repository port interface for managing blacklist entries within the application<br>- It facilitates the saving of blacklist entries and enables searching for entries by email address<br>- This abstraction allows for flexible implementation of data storage and retrieval mechanisms, ensuring that the application can effectively manage and query blacklist data as part of its overall architecture.</td>
																						</tr>
																					</table>
																				</blockquote>
																			</details>
																			<!-- input Submodule -->
																			<details>
																				<summary><b>input</b></summary>
																				<blockquote>
																					<div class='directory-path' style='padding: 8px 0; color: #666;'>
																						<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.application.ports.input</b></code>
																					<table style='width: 100%; border-collapse: collapse;'>
																					<thead>
																						<tr style='background-color: #f8f9fa;'>
																							<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																							<th style='text-align: left; padding: 8px;'>Summary</th>
																						</tr>
																					</thead>
																						<tr style='border-bottom: 1px solid #eee;'>
																							<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/application/ports/input/BlacklistServicePort.java'>BlacklistServicePort.java</a></b></td>
																							<td style='padding: 8px;'>- Defines the contract for managing email blacklisting operations within the application<br>- It facilitates adding emails to a blacklist and verifying their status, ensuring that users can effectively manage and respond to potential threats<br>- This interface plays a crucial role in the overall architecture by enabling communication between the application’s core logic and the external services that handle blacklist management.</td>
																						</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																	<!-- dto Submodule -->
																	<details>
																		<summary><b>dto</b></summary>
																		<blockquote>
																			<div class='directory-path' style='padding: 8px 0; color: #666;'>
																				<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.application.dto</b></code>
																			<table style='width: 100%; border-collapse: collapse;'>
																			<thead>
																				<tr style='background-color: #f8f9fa;'>
																					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																					<th style='text-align: left; padding: 8px;'>Summary</th>
																				</tr>
																			</thead>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/application/dto/ProblemDetailResponse.java'>ProblemDetailResponse.java</a></b></td>
																					<td style='padding: 8px;'>- ProblemDetailResponse serves as a structured representation of error information in compliance with RFC7807<br>- It encapsulates essential details about issues encountered within the application, including a problem type URI, a brief title, HTTP status code, a detailed explanation, and a specific instance reference<br>- This standardized format enhances error handling and communication, ensuring clarity and consistency across the codebases API responses.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/application/dto/BlacklistRequest.java'>BlacklistRequest.java</a></b></td>
																					<td style='padding: 8px;'>- Defines a Data Transfer Object for handling blacklist requests within the application<br>- It encapsulates essential information such as the email to be blacklisted, a unique application identifier, and an optional reason for the block<br>- This structure ensures data integrity and validation, facilitating seamless communication between different components of the codebase while adhering to established standards for input validation and documentation.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/application/dto/BlacklistResponse.java'>BlacklistResponse.java</a></b></td>
																					<td style='padding: 8px;'>- Provides a data transfer object for handling blacklist responses within the application<br>- It encapsulates essential information regarding an entitys blacklist status, including a boolean flag indicating whether the entity is blacklisted and a reason for that status<br>- This structure facilitates clear communication of blacklist information across different components of the codebase, enhancing the overall functionality and user experience of the blacklist API.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/application/dto/MessageResponse.java'>MessageResponse.java</a></b></td>
																					<td style='padding: 8px;'>- MessageResponse serves as a data transfer object within the blacklist API, encapsulating the response message returned to clients<br>- It enhances communication by providing a structured format for conveying success or error messages, thereby improving the overall user experience<br>- This component plays a crucial role in the APIs architecture by standardizing responses and facilitating seamless interaction between the application and its users.</td>
																				</tr>
																			</table>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
															<!-- infrastructure Submodule -->
															<details>
																<summary><b>infrastructure</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.infrastructure</b></code>
																	<!-- config Submodule -->
																	<details>
																		<summary><b>config</b></summary>
																		<blockquote>
																			<div class='directory-path' style='padding: 8px 0; color: #666;'>
																				<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.infrastructure.config</b></code>
																			<!-- openapi Submodule -->
																			<details>
																				<summary><b>openapi</b></summary>
																				<blockquote>
																					<div class='directory-path' style='padding: 8px 0; color: #666;'>
																						<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.infrastructure.config.openapi</b></code>
																					<table style='width: 100%; border-collapse: collapse;'>
																					<thead>
																						<tr style='background-color: #f8f9fa;'>
																							<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																							<th style='text-align: left; padding: 8px;'>Summary</th>
																						</tr>
																					</thead>
																						<tr style='border-bottom: 1px solid #eee;'>
																							<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/infrastructure/config/openapi/SwaggerConfig.java'>SwaggerConfig.java</a></b></td>
																							<td style='padding: 8px;'>- Configures the OpenAPI documentation for the Blacklist API, enhancing the projects architecture by providing a clear and structured representation of the APIs capabilities<br>- It defines essential metadata, including the API title, version, and contact information, while also establishing security protocols for authorization<br>- Additionally, it groups API endpoints related to blacklist management, facilitating easier navigation and understanding for developers and users alike.</td>
																						</tr>
																					</table>
																				</blockquote>
																			</details>
																			<!-- security Submodule -->
																			<details>
																				<summary><b>security</b></summary>
																				<blockquote>
																					<div class='directory-path' style='padding: 8px 0; color: #666;'>
																						<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.infrastructure.config.security</b></code>
																					<table style='width: 100%; border-collapse: collapse;'>
																					<thead>
																						<tr style='background-color: #f8f9fa;'>
																							<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																							<th style='text-align: left; padding: 8px;'>Summary</th>
																						</tr>
																					</thead>
																						<tr style='border-bottom: 1px solid #eee;'>
																							<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/infrastructure/config/security/SecurityConfig.java'>SecurityConfig.java</a></b></td>
																							<td style='padding: 8px;'>- Security configuration establishes the applications HTTP security filter chain, ensuring that requests to the blacklist endpoints are authenticated while allowing unrestricted access to other requests<br>- It integrates an OAuth2 resource server with a custom JWT decoder that validates tokens against a static value, enhancing security by preventing unauthorized access and managing authentication effectively within the overall architecture.</td>
																						</tr>
																						<tr style='border-bottom: 1px solid #eee;'>
																							<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/infrastructure/config/security/AuthEntryPoint.java'>AuthEntryPoint.java</a></b></td>
																							<td style='padding: 8px;'>- Handles unauthorized access by implementing an authentication entry point that intercepts authentication failures<br>- It constructs a standardized ProblemDetail response with a 401 Unauthorized status, ensuring users receive clear feedback when attempting to access secured resources without proper authentication<br>- This functionality enhances the overall security architecture of the application by providing informative error responses in a consistent format.</td>
																						</tr>
																					</table>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																	<!-- adapters Submodule -->
																	<details>
																		<summary><b>adapters</b></summary>
																		<blockquote>
																			<div class='directory-path' style='padding: 8px 0; color: #666;'>
																				<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.infrastructure.adapters</b></code>
																			<!-- output Submodule -->
																			<details>
																				<summary><b>output</b></summary>
																				<blockquote>
																					<div class='directory-path' style='padding: 8px 0; color: #666;'>
																						<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.infrastructure.adapters.output</b></code>
																					<!-- persistence Submodule -->
																					<details>
																						<summary><b>persistence</b></summary>
																						<blockquote>
																							<div class='directory-path' style='padding: 8px 0; color: #666;'>
																								<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.infrastructure.adapters.output.persistence</b></code>
																							<table style='width: 100%; border-collapse: collapse;'>
																							<thead>
																								<tr style='background-color: #f8f9fa;'>
																									<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																									<th style='text-align: left; padding: 8px;'>Summary</th>
																								</tr>
																							</thead>
																								<tr style='border-bottom: 1px solid #eee;'>
																									<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/infrastructure/adapters/output/persistence/JpaBlacklistRepositoryAdapter.java'>JpaBlacklistRepositoryAdapter.java</a></b></td>
																									<td style='padding: 8px;'>- JpaBlacklistRepositoryAdapter serves as a bridge between the application’s domain model and the underlying database, implementing the BlacklistRepositoryPort interface<br>- It facilitates the persistence and retrieval of blacklist entries through JPA, ensuring that domain objects are accurately mapped to and from their persistence representations<br>- This adapter enhances the codebases architecture by promoting separation of concerns and enabling efficient data access for blacklist management.</td>
																								</tr>
																							</table>
																							<!-- mapper Submodule -->
																							<details>
																								<summary><b>mapper</b></summary>
																								<blockquote>
																									<div class='directory-path' style='padding: 8px 0; color: #666;'>
																										<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.infrastructure.adapters.output.persistence.mapper</b></code>
																									<table style='width: 100%; border-collapse: collapse;'>
																									<thead>
																										<tr style='background-color: #f8f9fa;'>
																											<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																											<th style='text-align: left; padding: 8px;'>Summary</th>
																										</tr>
																									</thead>
																										<tr style='border-bottom: 1px solid #eee;'>
																											<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/infrastructure/adapters/output/persistence/mapper/BlacklistMapper.java'>BlacklistMapper.java</a></b></td>
																											<td style='padding: 8px;'>- BlacklistMapper serves as a crucial component in the architecture by facilitating the conversion between the domain model BlacklistEntry and the persistence entity BlacklistEntity<br>- This mapping ensures seamless data transfer and integrity between the applications core business logic and its underlying database structure, thereby enhancing the overall functionality and maintainability of the blacklist management system.</td>
																										</tr>
																									</table>
																								</blockquote>
																							</details>
																							<!-- entity Submodule -->
																							<details>
																								<summary><b>entity</b></summary>
																								<blockquote>
																									<div class='directory-path' style='padding: 8px 0; color: #666;'>
																										<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.infrastructure.adapters.output.persistence.entity</b></code>
																									<table style='width: 100%; border-collapse: collapse;'>
																									<thead>
																										<tr style='background-color: #f8f9fa;'>
																											<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																											<th style='text-align: left; padding: 8px;'>Summary</th>
																										</tr>
																									</thead>
																										<tr style='border-bottom: 1px solid #eee;'>
																											<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/infrastructure/adapters/output/persistence/entity/BlacklistEntity.java'>BlacklistEntity.java</a></b></td>
																											<td style='padding: 8px;'>- Represents an entry in the blacklist, capturing essential details about blacklisted emails within the application<br>- It includes unique identifiers, the reason for blocking, client IP address, and a timestamp for when the entry was created<br>- This entity plays a crucial role in managing and maintaining the integrity of the blacklist, ensuring that unauthorized access is effectively monitored and controlled.</td>
																										</tr>
																									</table>
																								</blockquote>
																							</details>
																							<!-- repository Submodule -->
																							<details>
																								<summary><b>repository</b></summary>
																								<blockquote>
																									<div class='directory-path' style='padding: 8px 0; color: #666;'>
																										<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.infrastructure.adapters.output.persistence.repository</b></code>
																									<table style='width: 100%; border-collapse: collapse;'>
																									<thead>
																										<tr style='background-color: #f8f9fa;'>
																											<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																											<th style='text-align: left; padding: 8px;'>Summary</th>
																										</tr>
																									</thead>
																										<tr style='border-bottom: 1px solid #eee;'>
																											<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/infrastructure/adapters/output/persistence/repository/JpaBlacklistRepository.java'>JpaBlacklistRepository.java</a></b></td>
																											<td style='padding: 8px;'>- JpaBlacklistRepository serves as a crucial component within the codebase architecture, enabling efficient CRUD operations on BlacklistEntity instances<br>- By extending JpaRepository, it simplifies data persistence while offering a specialized method to locate blacklist entries by email<br>- This functionality enhances the overall capability of the application to manage and query blacklist data effectively, supporting the projects goal of maintaining a robust blacklist management system.</td>
																										</tr>
																									</table>
																								</blockquote>
																							</details>
																						</blockquote>
																					</details>
																				</blockquote>
																			</details>
																			<!-- input Submodule -->
																			<details>
																				<summary><b>input</b></summary>
																				<blockquote>
																					<div class='directory-path' style='padding: 8px 0; color: #666;'>
																						<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.infrastructure.adapters.input</b></code>
																					<!-- rest Submodule -->
																					<details>
																						<summary><b>rest</b></summary>
																						<blockquote>
																							<div class='directory-path' style='padding: 8px 0; color: #666;'>
																								<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.infrastructure.adapters.input.rest</b></code>
																							<table style='width: 100%; border-collapse: collapse;'>
																							<thead>
																								<tr style='background-color: #f8f9fa;'>
																									<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																									<th style='text-align: left; padding: 8px;'>Summary</th>
																								</tr>
																							</thead>
																								<tr style='border-bottom: 1px solid #eee;'>
																									<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/infrastructure/adapters/input/rest/GlobalExceptionHandler.java'>GlobalExceptionHandler.java</a></b></td>
																									<td style='padding: 8px;'>- GlobalExceptionHandler serves as a centralized mechanism for managing and formatting errors within the REST API of the blacklist application<br>- It intercepts various exceptions, including validation errors and specific API exceptions, and returns standardized ProblemDetail responses<br>- This ensures consistent error handling and messaging across the application, enhancing the user experience and simplifying debugging for developers.</td>
																								</tr>
																								<tr style='border-bottom: 1px solid #eee;'>
																									<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/infrastructure/adapters/input/rest/BlacklistControllerV1.java'>BlacklistControllerV1.java</a></b></td>
																									<td style='padding: 8px;'>- Provides a RESTful interface for managing email blacklisting operations, enabling users to add emails to a blacklist and check their status<br>- It integrates with the BlacklistService for business logic and ensures secure access through bearer authentication<br>- The controller is designed to handle requests efficiently while offering clear responses and error handling, contributing to the overall functionality of the blacklist management system.</td>
																								</tr>
																							</table>
																						</blockquote>
																					</details>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
															<!-- domain Submodule -->
															<details>
																<summary><b>domain</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.domain</b></code>
																	<!-- model Submodule -->
																	<details>
																		<summary><b>model</b></summary>
																		<blockquote>
																			<div class='directory-path' style='padding: 8px 0; color: #666;'>
																				<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.domain.model</b></code>
																			<table style='width: 100%; border-collapse: collapse;'>
																			<thead>
																				<tr style='background-color: #f8f9fa;'>
																					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																					<th style='text-align: left; padding: 8px;'>Summary</th>
																				</tr>
																			</thead>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/domain/model/BlacklistEntry.java'>BlacklistEntry.java</a></b></td>
																					<td style='padding: 8px;'>- Represents an entry in the email blacklist, encapsulating essential information such as the blacklisted email address, application UUID, reason for blocking, client IP address, and creation timestamp<br>- This model serves as a foundational component within the blacklist API, facilitating the management and tracking of blacklisted emails to enhance application security and user protection against unwanted communications.</td>
																				</tr>
																			</table>
																		</blockquote>
																	</details>
																	<!-- service Submodule -->
																	<details>
																		<summary><b>service</b></summary>
																		<blockquote>
																			<div class='directory-path' style='padding: 8px 0; color: #666;'>
																				<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.domain.service</b></code>
																			<table style='width: 100%; border-collapse: collapse;'>
																			<thead>
																				<tr style='background-color: #f8f9fa;'>
																					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																					<th style='text-align: left; padding: 8px;'>Summary</th>
																				</tr>
																			</thead>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/domain/service/BlacklistService.java'>BlacklistService.java</a></b></td>
																					<td style='padding: 8px;'>- BlacklistService facilitates the management of email blacklisting within the application<br>- It enables the addition of emails to a blacklist while ensuring no duplicates exist, and provides functionality to verify if an email is blacklisted, along with the reason for its status<br>- This service plays a crucial role in maintaining application security and user integrity by preventing unwanted interactions from blacklisted emails.</td>
																				</tr>
																			</table>
																		</blockquote>
																	</details>
																	<!-- exception Submodule -->
																	<details>
																		<summary><b>exception</b></summary>
																		<blockquote>
																			<div class='directory-path' style='padding: 8px 0; color: #666;'>
																				<code><b>⦿ blacklist-api.src.main.java.com.example.blacklistapi.domain.exception</b></code>
																			<table style='width: 100%; border-collapse: collapse;'>
																			<thead>
																				<tr style='background-color: #f8f9fa;'>
																					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																					<th style='text-align: left; padding: 8px;'>Summary</th>
																				</tr>
																			</thead>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/domain/exception/ApiException.java'>ApiException.java</a></b></td>
																					<td style='padding: 8px;'>- Defines an abstract base class for API exceptions, establishing a framework for handling error scenarios within the application<br>- It encapsulates essential details such as an error message, HTTP status code, and application-specific error code, thereby promoting consistency and clarity in error management across the codebase<br>- This structure enhances the robustness of the blacklist API by facilitating effective error reporting and handling.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/domain/exception/EmailBlacklistedException.java'>EmailBlacklistedException.java</a></b></td>
																					<td style='padding: 8px;'>- EmailBlacklistedException serves as a custom exception within the blacklist API, specifically designed to indicate when an email address is blacklisted<br>- It enhances the overall error handling mechanism by providing a clear and informative message when a blacklisted email is encountered, ensuring that users are promptly notified of the issue<br>- This contributes to the robustness and user-friendliness of the application by managing email validation effectively.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/java/com/example/blacklistapi/domain/exception/NotAuthorizedException.java'>NotAuthorizedException.java</a></b></td>
																					<td style='padding: 8px;'>- NotAuthorizedException serves as a specialized error handler within the blacklist API, specifically addressing unauthorized access attempts<br>- By extending ApiException, it ensures that operations lacking proper authorization trigger a consistent response with an HTTP status of UNAUTHORIZED<br>- This enhances the overall security framework of the application, providing clear feedback to users regarding access control violations.</td>
																				</tr>
																			</table>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
							<!-- resources Submodule -->
							<details>
								<summary><b>resources</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ blacklist-api.src.main.resources</b></code>
									<table style='width: 100%; border-collapse: collapse;'>
									<thead>
										<tr style='background-color: #f8f9fa;'>
											<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
											<th style='text-align: left; padding: 8px;'>Summary</th>
										</tr>
									</thead>
										<tr style='border-bottom: 1px solid #eee;'>
											<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/resources/application-local.yml'>application-local.yml</a></b></td>
											<td style='padding: 8px;'>- Configures local development settings for the blacklist API, enabling seamless integration with a Dockerized PostgreSQL database<br>- It facilitates automatic schema updates and provides live reload capabilities for efficient development<br>- Additionally, it enhances logging for SQL operations, ensuring developers can easily monitor database interactions while working within a local environment.</td>
										</tr>
										<tr style='border-bottom: 1px solid #eee;'>
											<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/resources/lombok.config'>lombok.config</a></b></td>
											<td style='padding: 8px;'>- Configuring Lombok enhances the development experience by streamlining the code generation process within the project<br>- By enabling the generation of annotations and preventing bubbling of configuration errors, it ensures a cleaner and more efficient codebase<br>- This setup supports the overall architecture by promoting maintainability and reducing boilerplate code, allowing developers to focus on core functionality.</td>
										</tr>
										<tr style='border-bottom: 1px solid #eee;'>
											<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/resources/application-cloud.yml'>application-cloud.yml</a></b></td>
											<td style='padding: 8px;'>- Configures cloud deployment settings for the Blacklist API, ensuring optimal database connection management and Hibernate validation for production environments<br>- It establishes logging levels for different components and selectively exposes health management endpoints, enhancing the applications reliability and maintainability in cloud environments<br>- This configuration plays a crucial role in the overall architecture by facilitating seamless integration and performance monitoring.</td>
										</tr>
										<tr style='border-bottom: 1px solid #eee;'>
											<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/main/resources/application.yml'>application.yml</a></b></td>
											<td style='padding: 8px;'>- Defines essential configurations for the blacklist-api application, facilitating database connectivity, security settings, and server management<br>- It establishes parameters for the PostgreSQL datasource, JPA properties, and logging levels, while also configuring management endpoints for health checks and metrics<br>- This foundational setup ensures the application operates smoothly within its intended environment, promoting efficient resource management and security practices.</td>
										</tr>
									</table>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<!-- test Submodule -->
					<details>
						<summary><b>test</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ blacklist-api.src.test</b></code>
							<!-- java Submodule -->
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ blacklist-api.src.test.java</b></code>
									<!-- com Submodule -->
									<details>
										<summary><b>com</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ blacklist-api.src.test.java.com</b></code>
											<!-- example Submodule -->
											<details>
												<summary><b>example</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ blacklist-api.src.test.java.com.example</b></code>
													<!-- blacklistapi Submodule -->
													<details>
														<summary><b>blacklistapi</b></summary>
														<blockquote>
															<div class='directory-path' style='padding: 8px 0; color: #666;'>
																<code><b>⦿ blacklist-api.src.test.java.com.example.blacklistapi</b></code>
															<!-- infrastructure Submodule -->
															<details>
																<summary><b>infrastructure</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ blacklist-api.src.test.java.com.example.blacklistapi.infrastructure</b></code>
																	<!-- adapters Submodule -->
																	<details>
																		<summary><b>adapters</b></summary>
																		<blockquote>
																			<div class='directory-path' style='padding: 8px 0; color: #666;'>
																				<code><b>⦿ blacklist-api.src.test.java.com.example.blacklistapi.infrastructure.adapters</b></code>
																			<!-- output Submodule -->
																			<details>
																				<summary><b>output</b></summary>
																				<blockquote>
																					<div class='directory-path' style='padding: 8px 0; color: #666;'>
																						<code><b>⦿ blacklist-api.src.test.java.com.example.blacklistapi.infrastructure.adapters.output</b></code>
																					<!-- persistence Submodule -->
																					<details>
																						<summary><b>persistence</b></summary>
																						<blockquote>
																							<div class='directory-path' style='padding: 8px 0; color: #666;'>
																								<code><b>⦿ blacklist-api.src.test.java.com.example.blacklistapi.infrastructure.adapters.output.persistence</b></code>
																							<table style='width: 100%; border-collapse: collapse;'>
																							<thead>
																								<tr style='background-color: #f8f9fa;'>
																									<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																									<th style='text-align: left; padding: 8px;'>Summary</th>
																								</tr>
																							</thead>
																								<tr style='border-bottom: 1px solid #eee;'>
																									<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/test/java/com/example/blacklistapi/infrastructure/adapters/output/persistence/JpaBlacklistRepositoryAdapterTest.java'>JpaBlacklistRepositoryAdapterTest.java</a></b></td>
																									<td style='padding: 8px;'>- Unit tests validate the functionality of the JpaBlacklistRepositoryAdapter within the blacklist API project<br>- By ensuring that the adapter correctly saves and retrieves blacklist entries, it contributes to the overall reliability of the persistence layer<br>- These tests confirm that the mapping between domain models and database entities operates as intended, enhancing the robustness of the applications architecture.</td>
																								</tr>
																							</table>
																						</blockquote>
																					</details>
																				</blockquote>
																			</details>
																			<!-- input Submodule -->
																			<details>
																				<summary><b>input</b></summary>
																				<blockquote>
																					<div class='directory-path' style='padding: 8px 0; color: #666;'>
																						<code><b>⦿ blacklist-api.src.test.java.com.example.blacklistapi.infrastructure.adapters.input</b></code>
																					<!-- rest Submodule -->
																					<details>
																						<summary><b>rest</b></summary>
																						<blockquote>
																							<div class='directory-path' style='padding: 8px 0; color: #666;'>
																								<code><b>⦿ blacklist-api.src.test.java.com.example.blacklistapi.infrastructure.adapters.input.rest</b></code>
																							<table style='width: 100%; border-collapse: collapse;'>
																							<thead>
																								<tr style='background-color: #f8f9fa;'>
																									<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																									<th style='text-align: left; padding: 8px;'>Summary</th>
																								</tr>
																							</thead>
																								<tr style='border-bottom: 1px solid #eee;'>
																									<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/test/java/com/example/blacklistapi/infrastructure/adapters/input/rest/BlacklistControllerV1Tests.java'>BlacklistControllerV1Tests.java</a></b></td>
																									<td style='padding: 8px;'>- Unit tests for the BlacklistControllerV1 ensure the functionality and reliability of the REST API endpoints related to managing a blacklist of emails<br>- These tests validate various scenarios, including adding emails to the blacklist, checking their status, and handling errors such as invalid input and authorization issues<br>- By simulating requests and responses, they contribute to maintaining the integrity of the applications blacklist management features within the overall architecture.</td>
																								</tr>
																							</table>
																						</blockquote>
																					</details>
																				</blockquote>
																			</details>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
															<!-- domain Submodule -->
															<details>
																<summary><b>domain</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ blacklist-api.src.test.java.com.example.blacklistapi.domain</b></code>
																	<!-- service Submodule -->
																	<details>
																		<summary><b>service</b></summary>
																		<blockquote>
																			<div class='directory-path' style='padding: 8px 0; color: #666;'>
																				<code><b>⦿ blacklist-api.src.test.java.com.example.blacklistapi.domain.service</b></code>
																			<table style='width: 100%; border-collapse: collapse;'>
																			<thead>
																				<tr style='background-color: #f8f9fa;'>
																					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																					<th style='text-align: left; padding: 8px;'>Summary</th>
																				</tr>
																			</thead>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/test/java/com/example/blacklistapi/domain/service/BlacklistServiceTest.java'>BlacklistServiceTest.java</a></b></td>
																					<td style='padding: 8px;'>- Unit tests for the BlacklistService ensure the reliability and correctness of the email blacklisting functionality within the application<br>- By validating scenarios such as adding an email to the blacklist and checking its status, these tests confirm that the service behaves as expected, handling both successful operations and exceptions appropriately<br>- This contributes to the overall robustness of the blacklist management system in the codebase.</td>
																				</tr>
																			</table>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
							<!-- resources Submodule -->
							<details>
								<summary><b>resources</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ blacklist-api.src.test.resources</b></code>
									<table style='width: 100%; border-collapse: collapse;'>
									<thead>
										<tr style='background-color: #f8f9fa;'>
											<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
											<th style='text-align: left; padding: 8px;'>Summary</th>
										</tr>
									</thead>
										<tr style='border-bottom: 1px solid #eee;'>
											<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/blacklist-api/src/test/resources/application-test.yml'>application-test.yml</a></b></td>
											<td style='padding: 8px;'>- Configuration of security parameters for testing purposes enhances the overall functionality of the application<br>- By defining a static token, it facilitates the authentication process during test scenarios, ensuring that security measures are effectively validated<br>- This setup plays a crucial role in maintaining the integrity of the application while allowing for seamless testing within the broader codebase architecture.</td>
										</tr>
									</table>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
	<!-- git-hooks Submodule -->
	<details>
		<summary><b>git-hooks</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ git-hooks</b></code>
			<table style='width: 100%; border-collapse: collapse;'>
			<thead>
				<tr style='background-color: #f8f9fa;'>
					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
					<th style='text-align: left; padding: 8px;'>Summary</th>
				</tr>
			</thead>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/git-hooks/pre-commit.sh'>pre-commit.sh</a></b></td>
					<td style='padding: 8px;'>- Automates code formatting and quality checks before commits by executing Gradle tasks to apply and verify code style standards<br>- Ensures that only properly formatted and compliant code is added to the repository, enhancing overall code quality and consistency across the project<br>- This pre-commit hook plays a crucial role in maintaining a clean and maintainable codebase architecture.</td>
				</tr>
			</table>
		</blockquote>
	</details>
	<!-- .github Submodule -->
	<details>
		<summary><b>.github</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ .github</b></code>
			<!-- workflows Submodule -->
			<details>
				<summary><b>workflows</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ .github.workflows</b></code>
					<table style='width: 100%; border-collapse: collapse;'>
					<thead>
						<tr style='background-color: #f8f9fa;'>
							<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
							<th style='text-align: left; padding: 8px;'>Summary</th>
						</tr>
					</thead>
						<tr style='border-bottom: 1px solid #eee;'>
							<td style='padding: 8px;'><b><a href='https://github.com/MartinGalvanCastro/miso-devops/blob/master/.github/workflows/test.yml'>test.yml</a></b></td>
							<td style='padding: 8px;'>- Continuous Integration (CI) is established to ensure code quality and reliability within the project<br>- It triggers automated builds and tests on pushes and pull requests to the main branch<br>- By setting up the necessary environment and executing unit tests alongside code formatting checks, it maintains a robust codebase across all submodules, facilitating seamless collaboration and integration among developers.</td>
						</tr>
					</table>
				</blockquote>
			</details>
		</blockquote>
	</details>
</details>

---

## Getting Started

### Prerequisites

This project requires the following dependencies:

- **Programming Language:** Java
- **Package Manager:** Gradle

### Installation

Build miso-devops from the source and intsall dependencies:

1. **Clone the repository:**

    ```sh
    ❯ git clone https://github.com/MartinGalvanCastro/miso-devops
    ```

2. **Navigate to the project directory:**

    ```sh
    ❯ cd miso-devops
    ```

3. **Install the dependencies:**

<!-- SHIELDS BADGE CURRENTLY DISABLED -->
	<!-- [![gradle][gradle-shield]][gradle-link] -->
	<!-- REFERENCE LINKS -->
	<!-- [gradle-shield]: https://img.shields.io/badge/Gradle-02303A.svg?style={badge_style}&logo=gradle&logoColor=white -->
	<!-- [gradle-link]: https://gradle.org/ -->

	**Using [gradle](https://gradle.org/):**

	```sh
	❯ gradle build
	```

### Usage

Run the project with:

**Using [gradle](https://gradle.org/):**
```sh
gradle run
```

### Testing

Miso-devops uses the {__test_framework__} test framework. Run the test suite with:

**Using [gradle](https://gradle.org/):**
```sh
gradle test
```

---

## Roadmap

- [ ] **`Task 1`**: Add Integration Test with Cucumber
---


[back-to-top]: https://img.shields.io/badge/-BACK_TO_TOP-151515?style=flat-square


---
