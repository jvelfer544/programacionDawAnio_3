# DOCUMENTO DE PROCESO Y AUDITORÍA DE IA

Nombre del Proyecto: Juego del Ahorcado Web  
Asignatura: Desarrollo Asistido con IA (DAI)  
Curso: 2º G.D. C.F.G.S. D.A.W.  
Centro: IES Trafalgar  

## 1. Registro de Herramientas y Desglose de Contribución

### Herramientas Utilizadas

- Gemini 4 y Gemini notebook : Utilizado para la generación de la estructura HTML5, diseño y maquetación CSS3 responsiva, lógica de juego en JavaScript, y la implementación del motor de síntesis de audio con "Web Audio API".

### Estimación Porcentual del Código Final

- % Código / diseño propio: 10% (Maquetación manual, supervisión, prueba de usabilidad y parametrización de constantes de diseño y tiempos).
- % Código / diseño directo de IA: 55% (Estructura de maquetación, banco de palabras, eventos del DOM y lógica del sintetizador de audio).
- % Código / diseño refactorizado: 35% (Ajuste de tiempos de la música de Tetris, conversión del diseño a una sola línea para la palabra, implementación de Responsive CSS en móviles/tablets y lógica de revelación completa al perder).

## 2. Bitácora de Interacción (Muestra de Prompts Reales)

### Generación / Arquitectura

- Prompt de entrada enviado:
  "Diseña una página web similar a la práctica del ahorcado. Quiero que el diseño sea moderno con colores atractivos, con teclado virtual en pantalla, animación en las letras, dibujo dinámico en SVG del ahorcado y música de fondo estilo Tetris con sonidos adaptativos mediante Web Audio API."
- Código/Estructura devuelta:
  - Estructura modular dividida en `index.html`, `styles.css` y `script.js`.
  - Clase `SoundEngine` basada en `AudioContext` para sintetizar notas musicales sin necesidad de archivos MP3/WAV externos.
- Análisis: La arquitectura inicial funcionó perfectamente. Permitió separar responsabilidades y construir una interfaz fluida sin dependencias externas.

### Resolución de errores / Debugging

- Prompt de entrada enviado:
  > *"Quiero que si se pierde muestre un mensaje igual que cuando acierta la palabra y que muestre la palabra completa que había que adivinar."*
- Solución propuesta:
  - Modificación de la función `handleLetterGuess()` en `script.js` para que al llegar a 7 fallos se asigne `guessedWord = currentWord.split('')` antes de actualizar la UI y lanzar la ventana modal emergente.
- Evaluación: Solucionó el problema de inmediato, logrando una experiencia de usuario totalmente simétrica tanto al ganar como al perder.

### Detección de alucinaciones / Código erróneo

- Prompt de entrada enviado:
  "Quiero que la música de fondo del tetris sea completa."
- Caso detectado: La IA intentó cambiar de canciones basándose en el número de notas procesadas en lugar del tiempo real transcurrido, lo que hacía que en palabras con fallos la música fuese demasiado rápido.
- *xplicación del fallo y corrección: Se detectó que el tiempo musical dependía de la velocidad del bucle. Se corrigió forzando el uso de `performance.now()` para medir intervalos exactos de tiempo real en milisegundos (`MIN_TRACK_DURATION_MS`).

### Refactorización / Optimización

- **Prompt de entrada enviado:**
  > *"Quiero que me modifiques el CSS para que se pueda ver en pantallas de móviles y tablets además de portátiles y monitores, y que la palabra no haga saltos de línea."*
- **Código/CSS adaptado**:
  - Incorporación de `clamp()` para tipografías y tamaños de casillas adaptativos.
  - Inserción de `flex-wrap: nowrap` y `overflow-x: auto` en `.word-display`.
  - Definición de Media Queries (`@media (max-width: 850px)` y `@media (max-width: 480px)`).

## 3. Autoevaluación Crítica y Reflexión Personal

### 1. Productividad vs. Comprensión

La Inteligencia Artificial ha incrementado la velocidad de desarrollo en un **50%**, permitiendo implementar funcionalidades avanzadas como la síntesis de audio retro en tiempo récord. Sería capaz de explicar y defender **más del 90%** del código subido al repositorio, especialmente la manipulación del DOM, los manejadores de eventos, las reglas CSS Grid/Flexbox y la lógica del estado del juego. El codigo del archivo script.js, no.

### 2. Fricciones y Bloqueos

Los principales momentos de fricción ocurrieron al ajustar el comportamiento dinámico del motor de audio (tiempos de reproducción y ralentización del tempo), donde fue necesario iterar varias veces sobre la función `playTetrisMusic()` hasta dar con el ritmo exacto deseado.

### 3. Puntos Ciegos

En caso de tener que modificar el proyecto en vivo sin conexión ni asistentes, la principal debilidad radicaría en el cálculo matemático preciso de las frecuencias en hercios ($Hz$) para la síntesis de notas musicales en Web Audio API de memoria.

### 4. Impacto en el Flujo de Trabajo

El flujo de trabajo ha evolucionado de escribir sintaxis línea a línea a asumir un rol de **arquitecto y auditor de código**. Ahora el enfoque principal reside en saber descomponer el problema en requisitos técnicos claros, evaluar la calidad de las soluciones propuestas por la IA y refactorizar el código para garantizar la máxima usabilidad y accesibilidad.