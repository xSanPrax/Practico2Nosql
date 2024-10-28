from locust import HttpUser, task, between
import random

class MedicalAPIUser(HttpUser):
    wait_time = between(1, 5)
    host = "http://localhost:5000"

    def on_start(self):
        self.example_patient = {
            "CI": str(random.randint(1000000, 9999999)),
            "Nombre": "PacienteNombre",
            "Apellido": "PacienteApellido",
            "Fecha de nacimiento": "1990-01-01",
            "Sexo": "M"
        }
        self.example_record = {
            "CI": self.example_patient["CI"],
            "Fecha": "2024-10-28",
            "Tipo": "Consulta",
            "Diagnóstico": "Diagnóstico de prueba",
            "Médico": "Dr. Ejemplo",
            "Institución": "Instituto de Pruebas",
            "Descripción": "Descripción de prueba",
            "Medicación": "Medicación de prueba"
        }

    @task
    def agregar_paciente(self):
        with self.client.post("/paciente", json=self.example_patient, catch_response=True) as response:
            if response.status_code == 401:
                response.success()  # Ignorar el error 401 en Locust, ya que se debe a duplicados

    @task
    def agregar_registro_medico(self):
        self.client.post("/registro", json=self.example_record)

    @task
    def consultar_historial_medico(self):
        ci = self.example_patient["CI"]
        with self.client.get(f"/historial/{ci}", catch_response=True) as response:
            if response.status_code == 404:
                response.success()  # Ignorar el error 404 en Locust

    @task
    def obtener_registros_por_criterio(self):
        criterio = "Tipo"
        valor = "Consulta"
        self.client.get(f"/registros?criterio={criterio}&valor={valor}")
