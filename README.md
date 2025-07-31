\# Servicio Web de Autenticación (Java - Spring Boot)



\## Evidencia: GA7-220501096-AA5-EV01 Diseño y Desarrollo de Servicios Web

Autor: Dirley Yurany Córdoba Diaz

Análisis y Desarrollo de Software

Ficha 2977429



---



\## 1. Descripción del Proyecto



API REST básica para \*\*registro\*\* e \*\*inicio de sesión\*\* de usuarios, desarrollada en \*\*Java con Spring Boot\*\*. Almacena usuarios en memoria para demostración.



---



\## 2. Tecnologías



\* \*\*Java\*\* (JDK 17+)

\* \*\*Spring Boot\*\* (3.x.x)

\* \*\*Maven\*\*

\* \*\*Git\*\* \& \*\*GitHub\*\*



---



\## 3. Endpoints de la API



Base URL: `http://localhost:8080/api`



\* \*\*`POST /api/registro`\*\*:

&nbsp;   \* \*\*Cuerpo (JSON):\*\* `{"usuario": "nombre", "password": "clave"}`

&nbsp;   \* \*\*Respuestas:\*\* `201 Created` (Éxito), `400 Bad Request` (Datos incompletos), `409 Conflict` (Usuario existente).



\* \*\*`POST /api/login`\*\*:

&nbsp;   \* \*\*Cuerpo (JSON):\*\* `{"usuario": "nombre", "password": "clave"}`

&nbsp;   \* \*\*Respuestas:\*\* `200 OK` (Éxito), `400 Bad Request` (Datos incompletos), `401 Unauthorized` (Credenciales inválidas).



---



\## 4. Repositorio GitHub

https://github.com/yurany637/servicio-web-autenticacion.git



---





