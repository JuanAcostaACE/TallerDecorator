# Wrappuccino
Es un sistema de pedidos de cafetería con el patrón Decorator
Implementa un sistema de pedidos de bebidas personalizables en Java
que demuestra el patrón de diseño Decorator. Cada bebida puede
ampliarse en tiempo de ejecución con extras combinables, y tanto la
descripción como el costo se calculan dinámicamente envolviendo objetos
en lugar de usar herencia.

Estructura del patrón Decorator:
- Beverage (interfaz): componente con getDescription() y getCost()
- Espresso, Tea: componentes concretos (bebidas base)
- BeverageDecorator (abstracta): envuelve un Beverage e implementa la
  misma interfaz, delegando en el objeto envuelto
- Size (Medium/Large), Milk (Whole/Oat/Almond), Syrup (Vanilla/Caramel/
  Hazelnut), ExtraShot: decoradores concretos que agregan su propio
  texto a la descripción y su propio precio al total

# Modelo de pedido:
- Order guarda las bebidas confirmadas, permite agregar, quitar y vaciar,
  y calcula el total del pedido

Interfaz Swing (MenuFrame):
- Menú interactivo para elegir bebida base, tamaño y extras
- Vista previa en vivo: la descripción y el precio se actualizan con
  cada cambio
- Vista de capas que muestra cada decorador anidado alrededor de la
  bebida base, con opción de quitar cualquier capa
- Panel de pedido con acciones para agregar, quitar, vaciar y confirmar
- Los extras se pueden apilar (por ejemplo, dos jarabes de vainilla más
  un shot extra)


 README.md hecho por Nicoll Lopez 
