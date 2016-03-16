Repositorio para la tarea 4 de Conceptos avanzados de Ingeniería de Software

# Visualización en el navegador

1. Puede visualizar la aplicación en el navegador directamente sin desplegarla en Heroku accediendo al siguiente link en su navegador: http://agile-depths-61721.herokuapp.com/

# Desplegar en Heroku
# Proceso de instalación

1. Abra el terminal o la ventana de comandos de su sistema operativo.
2. Ubíquese sobre la carpeta en la que va a clonar el repositorio. (Ejemplo: cd /Users/David/Git)
3. Escriba el siguiente comando: git clone https://github.com/admojica/tarea_4.git
4. Se creará una carpeta denominada tarea_4, acceda a la carpeta por linea de comandos de la siguiente manera: cd tarea_4.

# Creación y despliegue de la aplicación en Heroku

1. Para desplegar la aplicación en Heroku escriba el siguiente comando en la carpeta que había quedado ubicado: heroku create.
2. Con este comando se crea una aplicación con un nombre aleatorio en su cuenta de Heroku.
3. Ahora despliegue el código: git push heroku master
4. Asegúrese de que al menos se esta ejecutando una instancia para poder correr el programa a través del siguiente comando: heroku ps:scale web=1
5. Una vez comprobado el paso anterior digite: heroku open
6. Esto abrirá automáticamente una ventana en su navegador con los resultados del programa.

# Ejecutar el programa localmente

1. Para ejecutar el proyecto localmente, es necesario desplegarlo en maven y ejecutarlo posteriormente, para esto ejecute el siguiente comando: mvm clean install.
2. Al ejecutar el comando se crea la carpeta target en la carpeta tarea_3 que se creo al bajar el repositorio; además se puede ver el resultado de los test de JUnit en consola.
3. Para ejecutar el programa localmente ejecute en la consola o el terminal: heroku local web
4. Una vez ejecutado el comando diríjase a su navegador y escriba en la barra de direcciones: localhost:5000
5. Presione enter y aparecerán los resultados del programa.
