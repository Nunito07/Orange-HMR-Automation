#Autor: Juan Zuluaga
# language: es
Característica: Proceso de contratacion en OrangeHRM
  Como reclutador de la empresa
  Quiero agregar un nuevo candidato al sistema
  Para gestionar el proceso de contratacion

  Escenario: Agregar un nuevo candidato y verificar su contratacion
    Dado que el usuario ha iniciado sesion en OrangeHRM
    Cuando el usuario navega a la seccion de "Recruitment"
    Y hace clic en el botón "Add"
    Y completa el formulario de información del candidato con la vacante "Software Engineer"
    Y guarda la información del candidato
    Entonces el sistema debe mostrar el candidato en la lista de contrataciones
    Y el estado del candidato debe ser "Hired"
    Y los datos del candidato deben corresponder a los ingresados en el formulario