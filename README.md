# TP-N1-Persistencia-Olea_Facundo
Repositorio perteneciente al trabajo práctico Nº1 de Persistencia de la materia Desarrollo de Software

# Trabajo completo
El trabajo completo se puede descargar como .rar desde [aquí](https://github.com/Facustriker/TP-N1-Persistencia-Olea_Facundo/raw/main/TP1_Persistencia.rar)

# Desarrollo del trabajo práctico
A continuación se van a detallar el desarrollo completo del trabajo realizado

## Mapeo de relaciones
Se ha utilizado el siguiente diagrama como base para realizar el trabajo: ![](https://raw.githubusercontent.com/Facustriker/TP-N1-Persistencia-Olea_Facundo/main/Assets/Diagrama%20Clase%20Utilizado.jpg)

A partir del mismo se hicieron las siguientes clases y paquetes:

### Dentro del paquete 'Entidades':
![](https://raw.githubusercontent.com/Facustriker/TP-N1-Persistencia-Olea_Facundo/main/Assets/EntidadesCreadas.jpg)

### Dentro del paquete 'Repositorios':
![](https://raw.githubusercontent.com/Facustriker/TP-N1-Persistencia-Olea_Facundo/main/Assets/RepositoriosCreados.jpg)

### Dentro del paquete 'Enumeraciones':
![](https://raw.githubusercontent.com/Facustriker/TP-N1-Persistencia-Olea_Facundo/main/Assets/EnumeracionesCreadas.jpg)

Una vez creadas las clases, se las completo con los atributos pedidos en el diagrama de clases.

### Repositorios
Los repositorios se implementaron usando las siguientes anotaciones:

`@Repository`: esta anotación hace que el ORM trabaje a esta clase como un repositorio

`extends JpaRepository<T, ID>`: esto hace que mi clase herede de JpaRepository todos los métodos, funciones y todo lo que necesite 
pasándole como parámetro la clase a la cual pertenece este repositorio (T) y la clave primaria de esa clase (ID)

### Clases
Las clases fueron implementadas usando las siguinetes anotaciones:

`@Entity`: Le estoy diciendo al ORM que trabaje esta clase como una Entidad

`@Data`: Al poner esto, Lombok me crea automaticamente los setter, getter, etc.

`@NoArgsConstructor`: Esto genera el constructor vacio

`@AllArgsConstructor`: Esto genera el constructor sobrecargado

`@Builder`: Este es un patrón de diseño que me permite armar el constructor que yo quiera como quiera (permutaciones, etc.)

También se creo una clase que es utilizada para que el resto herede las claves foráneas de aca y sean generadas por el propio motor, que utiliza
las siguientes anotaciones:

`@MappedSuperclass`: Esto hace que el ORM no me persista la clase porque yo la quiero para utilidad y comodidad solamente

`@Id`: Esto me hace Primary Key al atributo que se lo asigne

`@GeneratedValue(strategy = GenerationType.IDENTITY)`: Esto hace que el valor de mi Primary Key se genere automáticamente de manera numérica incremental

### Relaciones One to One
Las relaciones One to One fueron mapeadas utilizando las siguientes anotaciones:

`@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)`: Esta anotacion le dice al ORM que la relacion es One to One y me permite que cuando borre un objeto tambien se borre el objeto a lcual está vinculado y que en caso que haya un objeto huérfano (sin referencias) sea borrado también

`@JoinColumn`: Esta sirve para que la clave foránea quede en la clase que yo elija (a la que pertenece el atributo sobre el que se aplica la anotación)

### Relaciones One to Many
Las relaciones One to Many fueron mapeadas utilizando Arrays (debido a que pueden ser tantos objetos como el usuario quiera) y con las siguientes anotaciones:

`@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)`: Esta funciona igual que la de One to One con la diferencia que acá la relación es One to Many. El último parámetro es para que tipo de fetch sea ágil (ya que por defecto es perezoso).

`@JoinColumn`: Esta sirve para que la clave foránea quede en la clase que yo elija (a la que pertenece el atributo sobre el que se aplica la anotación)

`@Builder.Default`: Esto se utiliza para que no largue un error al compilar


## Funcionamiento del proyecto
A continuación se van a mostrar capturas de pantalla para comprobar el correcto funcionamiento del trabajo realizado, tanto por la consola como por las tablas de la base de datos H2

### A través de la consola
![](https://raw.githubusercontent.com/Facustriker/TP-N1-Persistencia-Olea_Facundo/main/Assets/ConsolaMessi.jpg)

### A través de la base de datos H2
A continuación se van a dar 3 ejemplos de consultas en SQL para comprobar el correcto funcionamiento de las bases de datos


#### FECHA Y TIPOS DE PRODUCTOS QUE HA PEDIDO MESSI

`SELECT DISTINCT C.APELLIDO, F.FECHA, PROD.TIPO`

`FROM CLIENTE AS C, PEDIDO AS P, FACTURA AS F, DETALLE_PEDIDO AS D, PRODUCTO AS PROD`

`WHERE C.APELLIDO LIKE 'Messi' AND P.CLIENTE_ID=C.ID AND P.ID=D.ID_PEDIDO AND D.ID=PROD.ID`

![](https://raw.githubusercontent.com/Facustriker/TP-N1-Persistencia-Olea_Facundo/main/Assets/SQL%201%20Messi.jpg)



#### NOMBRE Y APELLIDO DE LOS CLIENTES CUYA COMPRA TUVO UN SUBTOTAL MAYOR A 15.000

`SELECT DISTINCT C.NOMBRE, C.APELLIDO, D.SUBTOTAL`

`FROM CLIENTE AS C, PEDIDO AS P, DETALLE_PEDIDO AS D`

`WHERE C.ID=P.CLIENTE_ID AND P.ID=D.ID_PEDIDO AND D.SUBTOTAL > 15000`

![](https://raw.githubusercontent.com/Facustriker/TP-N1-Persistencia-Olea_Facundo/main/Assets/SQL%202%20Subtotal.jpg)



#### NOMBRE, APELLIDO, FECHA Y RUBRO ELEGIDO AL MOMENTO DE COMPRAR DE LAS PERSONAS QUE VIVEN EN QUILMES

`SELECT DISTINCT  C.NOMBRE, C.APELLIDO, R.DENOMINACION, DOM.LOCALIDAD`

`FROM CLIENTE AS C, PEDIDO AS P, DETALLE_PEDIDO AS D, PRODUCTO AS PROD, RUBRO AS R, DOMICILIO AS DOM`

`WHERE C.ID=P.CLIENTE_ID AND D.ID=PROD.ID AND PROD.RUBRO_ID=R.ID AND C.ID=DOM.CLIENTE_ID AND DOM.LOCALIDAD LIKE 'Quilmes'`

![](https://raw.githubusercontent.com/Facustriker/TP-N1-Persistencia-Olea_Facundo/main/Assets/SQL%203%20Nombre%20y%20Rubro%20de%20Quilmes.jpg)
