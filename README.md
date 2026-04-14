[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/hVbyY4UE)
# 🚀 Taller Programación III
## Sistema de Turnos con Colas (Queue - LinkedList)

---

## 🎯 Objetivo

Implementar un sistema de gestión de turnos utilizando la estructura de datos **Cola (Queue)** en Java, aplicando reglas de negocio y validaciones.

El sistema debe respetar el principio **FIFO (First In, First Out)**.

---

## 🧠 Contexto

Una empresa de soporte técnico necesita un sistema para registrar y atender turnos de clientes en orden de llegada.

Cada turno está compuesto por:

- Código del turno
- Descripción del problema

---

## ⚙️ Reglas de negocio

1. La cola tiene una capacidad máxima de **10 turnos**.
2. No se permiten códigos:
    - nulos
    - vacíos
    - con solo espacios
3. No se permiten problemas:
    - nulos
    - vacíos
    - con solo espacios
4. No se permiten **turnos duplicados** (mismo código).
5. La atención debe respetar el orden FIFO.

---

## 🧩 Métodos obligatorios

Debes implementar la clase:
SistemaTurnosSoporte

Con los siguientes métodos:

```java
public boolean registrarTurno(String codigo, String problema)

public String verSiguienteTurno()

public String atenderSiguienteTurno()

public int obtenerCantidadTurnos()

public int obtenerEspaciosDisponibles()

public String mostrarCola()

⚠️ Restricciones importantes
No modificar los archivos de pruebas (src/test)
No modificar el archivo pom.xml
No modificar el workflow de GitHub
Solo trabajar en:
src/main/java/SistemaTurnosSoporte.java
Y realizar la interfaz grafica del usuario para probar que todo funcione
Puedes revisar las pruebas test pero no modificarlas.
Ponderacion 
Test 7.5
Ventana 2.5
