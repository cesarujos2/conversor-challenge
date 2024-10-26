# Conversor de Moneda

## Descripción

El **Conversor de Moneda** es una aplicación en Java que permite a los usuarios convertir entre varias monedas, incluyendo el Dólar, el Peso argentino, el Real brasileño y el Peso colombiano. Utiliza un cliente HTTP para obtener tasas de cambio en tiempo real y proporciona una interfaz de consola para facilitar la interacción del usuario.

## Funcionalidades

- Conversión entre diferentes monedas:
  - Dólar a Peso argentino
  - Peso argentino a Dólar
  - Dólar a Real brasileño
  - Real brasileño a Dólar
  - Dólar a Peso colombiano
  - Peso colombiano a Dólar
- Manejo de errores y validaciones de entrada
- Espera de 5 segundos entre las conversiones para mejorar la experiencia del usuario

## Requisitos

- Java 11 o superior
- Biblioteca [Gson](https://github.com/google/gson) para manejar JSON (puedes incluirla en tu proyecto mediante Maven o Gradle)

## Instalación

1. Clona este repositorio en tu máquina local:

   ```bash
   git clone https://github.com/tu-usuario/conversor-moneda.git
