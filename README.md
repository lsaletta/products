# Get-Products with Spring-Boot

Este proyecto implementa una POC como micro-servicio (API) utilizando Spring-boot y Maven para la obtención de productos. 
Leer el [enunciado](https://github.com/lsaletta/products/blob/master/enunciado.md) para más
información.

## Como utilizar

Abrir una consola y ejecutar:

```
git clone https://github.com/lsaletta/products.git
cd products
mvn clean install
java -jar target/products-0.0.1-SNAPSHOT.jar
```

Despues de seguir los pasos anteriores, estará la API arrancada en: `http://localhost:8080`

Ejemplo de peticion:

#### Request:

`curl --location --request GET 'http://localhost:8080/inditex/products'`

#### Response:

```
[{"id":5,"sequence":6},{"id":1,"sequence":10},{"id":3,"sequence":15}]
```

## Preguntas

### Estructuras de datos utilizadas en el algoritmo
He utilizado listas y la API de Stream de Java. En este caso, he elegido esta solucion considerando el problema planteado 
y las ventajas que nos ofrece la API de Stream para poder manejar conjunto de datos ofrenciendo un buen rendimiento.

### Complejidad temporal del algoritmo
La estimada del algoritmo es O(n^3)

