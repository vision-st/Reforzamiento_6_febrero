# Simulador de Restaurante Concurrente 🍴

Este proyecto es una aplicación desarrollada en **Java** que simula el flujo de trabajo de un restaurante mediante **programación concurrente**[cite: 2, 28]. El sistema modela la interacción entre múltiples camareros (productores) y una cocina (consumidor) utilizando hilos y mecanismos avanzados de sincronización de la biblioteca `java.util.concurrent`[cite: 29, 31].

##  Descripción General
El simulador permite observar cómo se gestionan múltiples tareas en paralelo, asegurando que los pedidos se procesen según su nivel de urgencia y evitando conflictos de acceso a recursos compartidos[cite: 52, 111].

##  Estructura del Proyecto
El código está organizado en dos fases incrementales de aprendizaje según el programa académico[cite: 12]:

### Semana 4: Concurrencia Básica
Se implementan los fundamentos de la programación multihilo[cite: 51]:
* Hilos (Thread/Runnable):** Modelan el comportamiento independiente de camareros y cocineros[cite: 54, 101].
* PriorityBlockingQueue:** Estructura de datos que ordena automáticamente los pedidos por prioridad y gestiona el acceso sincronizado entre hilos[cite: 57, 103].
* AtomicInteger:** Garantiza que cada pedido tenga un identificador único de forma atómica y segura en un entorno multitarea[cite: 124, 196].

### Semana 5: Sincronización Avanzada
Se añaden capas de control para robustecer el sistema y evitar condiciones de carrera[cite: 374, 375]:
* ReentrantLock:** Controla el acceso exclusivo a la cocina, permitiendo gestionar una capacidad máxima de pedidos en espera y protegiendo secciones críticas[cite: 119, 441].
* Volatile:** Se utiliza en el monitor de estado para asegurar la visibilidad inmediata de los cambios de variables entre diferentes hilos[cite: 489, 698].
* Monitor en Tiempo Real:** Un hilo observador (MonitorEstado) que audita periódicamente la carga de la cocina sin interferir con los procesos de producción[cite: 435, 475].



##  Clases Principales
1.  `PrioridadPedido`**: Enumeración que define los niveles de urgencia: `ALTA`, `MEDIA` y `BAJA`[cite: 88, 134].
2.  `Pedido`**: Modelo de datos que implementa la interfaz `Comparable` para permitir el ordenamiento automático por prioridad[cite: 90, 143].
3.  `GestorPedidos` / `CocinaSincronizada`**: Actúan como el recurso compartido centralizado donde se depositan y retiran los pedidos[cite: 92, 410, 433].
4.  `Camarero`**: Clase que actúa como hilo productor, generando comandas de forma aleatoria y enviándolas al sistema[cite: 93, 167].
5.  `Cocina`**: Clase que actúa como hilo consumidor, procesando los platos según su prioridad y simulando tiempos de preparación[cite: 95, 203].
6.  `Main`**: Punto de entrada que utiliza `ExecutorService` para administrar el pool de hilos y gestionar el cierre controlado de la simulación[cite: 87, 228, 229].

##  Ejecución
Al iniciar el programa, el usuario encontrará un menú interactivo por consola para seleccionar la versión a ejecutar[cite: 530, 549]:
1.  Versión Básica (Semana 4):** Foco en la creación de hilos y uso de colas de prioridad sin restricciones de capacidad explícitas[cite: 552].
2.  Versión Avanzada (Semana 5):** Incorpora control de capacidad limitada, uso de bloqueos explícitos (`ReentrantLock`) y monitoreo de estado en tiempo real[cite: 553, 556].

---
*Este proyecto es parte de la asignatura Desarrollo Orientado a Objetos II - Duoc UC[cite: 4].*