from flask import Flask, request, jsonify
from pymongo import MongoClient
from bson import ObjectId

# Configurar la aplicación Flask
app = Flask(__name__)

# Conectar a MongoDB
connection_string = "mongodb://localhost:27017/"
client = MongoClient(connection_string)
db = client['program']  # Cambia 'program' si es necesario
datos_paciente = db['datos_paciente']
registro_medico = db['registro_medico']

@app.route('/', methods=['GET'])
def home():
    return jsonify({"message": "Bienvenido a la API de Gestión Médica"}), 200

@app.route('/paciente', methods=['POST'])
def agregar_paciente():
    paciente = request.get_json()
    # Verifica si el paciente ya existe
    if datos_paciente.find_one({"CI": paciente["CI"]}):
        return jsonify({"error": "El paciente ya existe"}), 401

    # Agregar paciente a la base de datos
    datos_paciente.insert_one(paciente)
    return jsonify({"message": "Paciente agregado exitosamente"}), 200

@app.route('/registro', methods=['POST'])
def agregar_registro():
    registro = request.get_json()
    registro_medico.insert_one(registro)
    return jsonify({"message": "Registro médico agregado exitosamente"}), 200

@app.route('/historial/<ci>', methods=['GET'])
def consultar_historial_medico(ci):
    historial = list(registro_medico.find({"CI": ci}))
    # Convierte ObjectId a string
    for record in historial:
        record['_id'] = str(record['_id'])  # Convierte el ObjectId a string
    if not historial:
        return jsonify({"error": "No se encontraron registros para la CI proporcionada"}), 404
    return jsonify(historial), 200

@app.route('/registros', methods=['GET'])
def obtener_registros_por_criterio():
    criterio = request.args.get('criterio')
    valor = request.args.get('valor')

    if not criterio or not valor:
        return jsonify({"error": "Criterio y valor son necesarios"}), 400

    registros = list(registro_medico.find({criterio: valor}))
    # Convertir ObjectId a string
    for registro in registros:
        registro['_id'] = str(registro['_id'])
    return jsonify(registros), 200

if __name__ == '__main__':
    app.run(debug=True, host='127.0.0.1', port=5000)
