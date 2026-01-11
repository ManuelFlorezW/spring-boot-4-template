# Spring Boot 4 – Java 21 Template

Plantilla base para crear aplicaciones **Spring Boot 4** usando **Java 21** y **Gradle**.  
Ideal para APIs REST simples, pruebas con MockMvc y proyectos de aprendizaje o prototipos.

---

## 🧱 Stack tecnológico

- **Java:** 21 (LTS)
- **Framework:** Spring Boot 4.0.1
- **Build tool:** Gradle
- **Testing:** JUnit 5 + Spring MVC Test (MockMvc)
- **Gestión de dependencias:** Spring Dependency Management

---

## 📁 Estructura del proyecto

````angular2html
.
├── src
│ ├── main
│ │ └── java
│ │ └── com.example
│ │ └── demo
│ │ ├── DemoApplication.java
│ │ └── controllers
│ │ └── CoreController.java
│ └── test
│ └── java
│ └── com.example
│ └── demo
│ └── controllers
│ └── CoreControllerTest.java
├── build.gradle
├── settings.gradle
└── README.md
````

---

## ⚙️ Requisitos

- **JDK 21** (recomendado Temurin / OpenJDK)
- **Gradle Wrapper** (incluido)
- IDE recomendado: **IntelliJ IDEA**

---

## ▶️ Ejecutar la aplicación

```bash
./gradlew bootRun
```

La aplicación queda disponivle en

````
http://localhost:8080
````

Ejemplo de Endpoint

````http
GET /hello?name=World
````

Respuesta

````nginx
Hello World!
````

---

## 🧪 Ejecutar los tests

````bash
./gradlew test
````

- Usa JUnit 5
- Tests MVC con MockMvc
- No levanta el contexto completo (rápidos)

---

## 📦 Dependencias principales

````gradle
implementation 'org.springframework.boot:spring-boot-starter-webmvc'
testImplementation 'org.springframework.boot:spring-boot-starter-webmvc-test'
testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
````

## ℹ️ Nota: esta plantilla usa spring-boot-starter-webmvc en lugar del starter web completo para un control más explícito del stack MVC.

---

## 🧠 Convenciones del proyecto

- Controllers en el paquete controllers
- Tests MVC con @WebMvcTest
- No se fuerza cobertura sobre el método main
- Java moderno (records, switch, text blocks permitidos)

---

## 🧩 Ejemplo de Controller

````java
@RestController
public class CoreController {

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "World") String name) {
        return "Hello " + name + "!";
    }
}
````

---

## 🧪 Ejemplo de Test

````java
@WebMvcTest(CoreController.class)
class CoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloReturnsGreeting() throws Exception {
        mockMvc.perform(get("/hello"))
            .andExpect(status().isOk())
            .andExpect(content().string("Hello World!"));
    }
}

````

---

## 🧰 Personalización rápida

- Cambiar group, version y description en build.gradle
- Renombrar el paquete base (com.example)
- Agregar Spring Security, JPA, Actuator según necesidad

---

## 📄 Licencia

Este proyecto es una plantilla base.
Úsala libremente para proyectos personales, educativos o comerciales.

---

## 🚀 Próximos pasos sugeridos

- Agregar **Spring Security**
- Agregar **OpenAPI / Swagger**
- Agregar **JaCoCo** para cobertura
- Preparar **CI/CD** (GitHub Actions)

---

## ✅ 2️⃣ Endpoints disponibles por defecto

````bash
GET /actuator/health
````

Ejemplo:

````bash
curl http://localhost:8080/actuator/health
````

---

## Endpoints

| Endpoint              |       Uso        |
|-----------------------|:----------------:|
| /actuator/health      | Estado de la app |
| /actuator/info        |  Info del build  |
| /actuator/metrics     |     Métricas     |
| /actuator/env         |    Variables     |
| /actuator/loggers     |  Niveles de log  |
| /actuator/beans       |  Beans cargados  |

