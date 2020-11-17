"""
Proyecto de Estructuras de Datos y Algoritmos 1
Clase impurezaG
@author: Juan Sebastian Guerra y Jacobo Rave
"""

class impurezaG:
    
  """
  Con el metodo impurezaDeGini se calcula la impureza de una lista de referencias
  """
  def impurezaDeGini(dataset, lista):
    if lista is None:
        return None
    alumnosExitosos = 0
    alumnosNOExitosos = 0
    for estudiante in lista:
        if int(dataset[estudiante][77]) == 1:
          alumnosExitosos += 1
        else:
          alumnosNOExitosos += 1
    return impurezaG.impurezaDeGiniAux(alumnosExitosos, alumnosNOExitosos)

  """
  Con el metodo impurezaDeGiniAux se realizan los calculos de impureza
  """
  def impurezaDeGiniAux(alumnosExitosos, alumnosNOExitosos):
    if alumnosExitosos + alumnosNOExitosos == 0:
        return 0
    proporcionExitosos = alumnosExitosos / (alumnosExitosos + alumnosNOExitosos)
    proporcionNOExitosos = alumnosNOExitosos / (alumnosExitosos + alumnosNOExitosos)
    impureza = 1 - (proporcionExitosos**2 + proporcionNOExitosos**2)
    return impureza

  """
  Con el metodo impurezaDeGiniPonderada se calcula la impureza ponderada de dos listas
  """
  def impurezaDeGiniPonderada(dataset, lista1, lista2):
    impureza1 = impurezaG.impurezaDeGini(dataset, lista1)
    impureza2 = impurezaG.impurezaDeGini(dataset, lista2)
    tamaño1 = len(lista1)
    tamaño2 = len(lista2)
    return impurezaG.impurezaDeGiniPonderadaAux(dataset, tamaño1, tamaño2, impureza1, impureza2)

  """
  Con el metodo impurezaDeGiniPonderadaAux se realiza los calculos de la impureza ponderada
  """
  def impurezaDeGiniPonderadaAux(tamaño1, tamaño2, impureza1, impureza2):
    impurezaPonderada = ((tamaño1*impureza1)+(tamaño2*impureza2))/(tamaño1 + tamaño2)
    return impurezaPonderada

  """
  Con el metodo porcentajeDeExito se calcula la probabilidad de exito de una hoja
  """
  def porcentajeDeExito(dataset, lista):
    alumnosExitosos = 0
    for estudiante in lista:
        if int(dataset[estudiante][77]) == 1:
          alumnosExitosos += 1
    return (alumnosExitosos*100)/len(lista)