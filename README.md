# Conversor de Monedas 💰🌍

¡Bienvenido al **Conversor de Monedas**! Este proyecto te permite convertir una cantidad de dinero entre diferentes monedas. Utiliza tasas de cambio en tiempo real proporcionadas por una API, lo que garantiza que las conversiones sean precisas y actualizadas.

## 🔧 Funcionalidades

- **Conversión entre 3 monedas**: USD, EUR, COP.
- **Interfaz de usuario**: Puedes ingresar el monto que deseas convertir y elegir las monedas de origen y destino.
- **Tasas de cambio en tiempo real**: El conversor obtiene las tasas más recientes de una API confiable.
- **API Key segura**: La clave API está oculta para asegurar la privacidad.

## ⚙️ Tecnologías

- **Java**: El lenguaje principal utilizado para desarrollar el conversor.
- **Gson**: Librería para manejar y parsear respuestas JSON de la API.
- **API de ExchangeRate-API**: API que proporciona tasas de cambio en tiempo real.

## 💡 ¿Cómo usar?

1. Clona este repositorio a tu máquina local.
2. Abre el proyecto en tu IDE favorito (por ejemplo, IntelliJ IDEA).
3. Asegúrate de agregar tu archivo `config.properties` con tu **API Key** para acceder a la API de tasas de cambio.
4. Ejecuta la clase `Main` para empezar a realizar conversiones.
5. Introduce la cantidad de dinero que deseas convertir y elige las monedas de origen y destino.

## 🔑 Seguridad de la API Key

Para proteger tu clave de API, se utiliza el archivo `config.properties`, que **no está** incluido en el repositorio para evitar la exposición de la clave pública. Asegúrate de incluir este archivo en tu proyecto con tu propia clave API para que el conversor funcione correctamente.

### Ejemplo de `config.properties`:
API_KEY=tu_clave_api_aqui
