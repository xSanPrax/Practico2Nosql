import requests
import json
from pymongo import MongoClient

connection_string = "mongodb://mongo:27017/" #Esto es solo cuando se dockeriza
#connection_string = "mongodb://localhost:27017/"
client = MongoClient(connection_string)

# Selecciona la base de datos 'program'
db = client['program']
print("Conexión exitosa a la base de datos 'program'")

# Crear colecciones
datos_paciente = db['datos_paciente']
registro_medico = db['registro_medico']

def mostrar_menu():
    print("----- Menú -----")
    print("1. Agregar Paciente")
    print("2. Agregar Registro Médico")
    print("3. Consultar Historial Médico")
    print("4. Obtener Registros por Criterio")
    print("5. Salir")
    print("-----------------")

def agregar_paciente():
    ci = input("Ingrese la CI del paciente: ")
    nombre = input("Ingrese el nombre del paciente: ")
    apellido = input("Ingrese el apellido del paciente: ")
    fecha_nacimiento = input("Ingrese la fecha de nacimiento (YYYY-MM-DD): ")
    sexo = input("Ingrese el sexo del paciente: ")

    paciente = {
        "CI": ci,
        "Nombre": nombre,
        "Apellido": apellido,
        "Fecha de nacimiento": fecha_nacimiento,
        "Sexo": sexo
    }

    response = requests.post("http://localhost:5000/paciente", json=paciente)
    if response.status_code == 200:
        print(response.json())
    else:
        print(f"Error: {response.status_code} - {response.text}")

def agregar_registro_medico():
    ci = input("Ingrese la CI del paciente: ")
    fecha = input("Ingrese la fecha del registro (YYYY-MM-DD): ")
    tipo = input("Ingrese el tipo de registro (Consulta, Examen, Internacion): ")
    diagnostico = input("Ingrese el diagnóstico: ")
    medico = input("Ingrese el nombre del médico: ")
    institucion = input("Ingrese la institución: ")
    descripcion = input("Ingrese la descripción (opcional): ")
    medicacion = input("Ingrese la medicación (opcional): ")

    registro = {
        "CI": ci,
        "Fecha": fecha,
        "Tipo": tipo,
        "Diagnóstico": diagnostico,
        "Médico": medico,
        "Institución": institucion,
        "Descripción": descripcion,
        "Medicación": medicacion
    }

    response = requests.post("http://localhost:5000/registro", json=registro)
    if response.status_code == 200:
        print(response.json())
    else:
        print(f"Error: {response.status_code} - {response.text}")

def consultar_historial_medico():
    ci = input("Ingrese la CI del paciente: ")
    response = requests.get(f"http://localhost:5000/historial/{ci}")
    if response.status_code == 200:
        print(response.json())
    else:
        print(f"Error: {response.status_code} - {response.text}")

def obtener_registros_por_criterio():
    criterio = input("Ingrese el criterio de búsqueda (Tipo, Diagnostico, Médico, Institucion): ")
    valor = input(f"Ingrese el valor para {criterio}: ")
    response = requests.get(f"http://localhost:5000/registros?criterio={criterio}&valor={valor}")
    if response.status_code == 200:
        print(response.json())
    else:
        print(f"Error: {response.status_code} - {response.text}")

def main():
    while True:
        mostrar_menu()
        opcion = input("Seleccione una opción (1-5): ")
        
        if opcion == '1':
            agregar_paciente()
        elif opcion == '2':
            agregar_registro_medico()
        elif opcion == '3':
            consultar_historial_medico()
        elif opcion == '4':
            obtener_registros_por_criterio()
        elif opcion == '5':
            print("Saliendo...")
            break
        else:
            print("Opción inválida, por favor elija una opción del menú.")

if __name__ == "__main__":
    main()
