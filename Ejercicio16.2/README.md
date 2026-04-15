# Ejercicio16.2

Proyecto de automatización de pruebas con Selenium y JUnit 5.

## Estructura del proyecto

- `pom.xml` - configuración de Maven y dependencias.
- `src/main/java/pages` - páginas de prueba (`LoginPage`, `InventoryPage`).
- `src/test/java/tests` - casos de prueba (`BaseTest`, `LoginTest`, `InventoryTest`).

## Tecnologías

- Java 25
- Maven
- Selenium 4
- JUnit Jupiter 5
- WebDriverManager

## Ejecutar pruebas

Desde la raíz del proyecto:

```bash
mvn test
```

## Notas

- El proyecto usa `WebDriverManager` para administrar automáticamente los controladores de navegador.
- Ajusta los datos de usuario o la configuración de la URL en los tests si es necesario.
