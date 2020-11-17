"""
Proyecto de Estructuras de Datos y Algoritmos 1
Clase ArbolDecision
@author: Juan Sebastian Guerra y Jacobo Rave
"""

import csv
import Nodo
import time
import Gini
from secrets import randbelow

class ArbolDecision:
    
  """
  Con el constructor se busca generar de forma recursiva todo un arbol de decisión
  """ 
  def __init__(self, lista, posVariables, dataset, pregunta = None, altura = 0, alturaMaxima = 10):
    self.altura = altura
    self.dataset = dataset
    self.root = Nodo.nodo(lista)
    self.posVariables = posVariables.copy()
    self.impureza = Gini.impurezaG.impurezaDeGini(self.dataset, self.root.lista)
    if self.root.lista is None or len(self.posVariables) == 0 or self.impureza == 0 or self.altura == alturaMaxima:
      return

    self.nodos = self.dividirNodoMejorCondicion(self.root.lista, self.posVariables)
    
    
    self.pregunta = self.nodos[1]
    self.posVariables.remove(self.pregunta[0])

    try: 
      self.root.nodoIzq = ArbolDecision(self.nodos[0][0], self.posVariables, dataset, altura = self.altura+1, alturaMaxima = alturaMaxima)
    except:
      self.root.nodoIzq = None  
        
    try:
      self.root.nodoDer = ArbolDecision(self.nodos[0][1], self.posVariables, dataset, altura = self.altura+1, alturaMaxima = alturaMaxima)
    except:
      self.root.nodoDer = None
    
    
  """
  Con el metodo leerDataset obtenemos la informacion de los dataset
  """ 
  def leerDataset(archivo):
    with open(archivo, newline='', encoding="utf-8") as csvfile:
      lector = csv.reader(csvfile, delimiter=';')
      next(lector)
      datos = []
      for fila in lector:
        datos.append(fila)
      
    return datos

  """
  Con el metodo identificarTipoDato se define el tipo de dato de la columna
  """
  def identificarTipoDato(self, posVariable):
    i = 0
    auxCast = self.dataset[i][posVariable]
    for fila in self.dataset:
      if auxCast == "":
        i += 1
        auxCast = self.dataset[i][posVariable]      
      else:
        break     
    return auxCast

  """
  Con el metodo seleccionarMejorVar se calcula la condicion que mejor reduce la impureza de una columna
  """
  def seleccionarMejorVar(self, lista, posVariable): 
    auxCast = self.identificarTipoDato(posVariable)
    diccionarioVariables = {}
    for fila in lista:
      valor = self.dataset[fila][posVariable] 

      if diccionarioVariables.get(valor) is None:
        diccionarioVariables[valor] = [0,0]
        
      if int(self.dataset[fila][77]) == 1:
        diccionarioVariables[valor][0] += 1
      else:
        diccionarioVariables[valor][1] += 1
    #Si es un flotante
    try:
      float(auxCast)
      minimaPonderada = 1
      minimoValor = ""
      for valor in diccionarioVariables:
        if valor == "":
          continue
        variable1 = [0,0]
        variable2 = [0,0]
        for valor2 in diccionarioVariables:
          if float(valor) > float(valor2):
            variable1[0] += diccionarioVariables[valor2][0]
            variable1[1] += diccionarioVariables[valor2][1]
          else:
            variable2[0] += diccionarioVariables[valor2][0]
            variable2[1] += diccionarioVariables[valor2][1]
        impureza1 = (Gini.impurezaG.impurezaDeGiniAux(self.dataset, variable1[0], variable1[1]), variable1[0] + variable1[1])
        impureza2 = (Gini.impurezaG.impurezaDeGiniAux(self.dataset, variable2[0], variable2[1]), variable2[0] + variable2[1])
        ponderada = Gini.impurezaG.impurezaDeGiniPonderadaAux(self.dataset, impureza1[1], impureza2[1], impureza1[0], impureza2[0])

        if ponderada < minimaPonderada:
          minimaPonderada = ponderada
          minimoValor = valor
      return [minimaPonderada,minimoValor, posVariable]
    #Si es un String
    except:
      minimaPonderada = 1
      minimoValor = ""
      for valor in diccionarioVariables:
        if valor == "":
          continue
        variable1 = diccionarioVariables[valor]
        variable2 = [0,0]
        for valor2 in diccionarioVariables:
          if valor != valor2:
            variable2[0] += diccionarioVariables[valor2][0]
            variable2[1] += diccionarioVariables[valor2][1]

        impureza1 = (Gini.impurezaG.impurezaDeGiniAux(variable1[0], variable1[1]), variable1[0] + variable1[1])
        impureza2 = (Gini.impurezaG.impurezaDeGiniAux(variable2[0], variable2[1]), variable2[0] + variable2[1])
        ponderada = Gini.impurezaG.impurezaDeGiniPonderadaAux(impureza1[1], impureza2[1], impureza1[0], impureza2[0])

        if ponderada < minimaPonderada:
          minimaPonderada = ponderada
          minimoValor = valor
      return [minimaPonderada,minimoValor, posVariable]
    
  """
  Con el metodo dividirNodoMejorCondicion dividimos una lista de estudiantes segun la mejor condicion, guardandola luego
  para las datos de Test
  """
  def dividirNodoMejorCondicion(self, lista, listaVariables):
    minimaPonderada = 1
    minimoValor = ""
    minimaCondicion = None
    for i in listaVariables:
      condicion = self.seleccionarMejorVar(lista, i)
      ponderada = condicion[0]
      if ponderada < minimaPonderada:
        minimaPonderada = ponderada
        minimoValor = condicion[1]
        minimaCondicion = condicion[2]  
   
    listasDivididas = self.dividirNodo(lista, minimaCondicion, minimoValor)
    condicionConPregunta = (minimaCondicion, minimoValor)
    return (listasDivididas,condicionConPregunta)

  """
  Con el metodo dividirNodo dividimos dos listas segun una condicion dada
  """
  def dividirNodo(self, lista, posVariable, valor):
    auxCast = self.identificarTipoDato(posVariable)
    laVariableEsIgualAlValor = []
    laVariableNOEsIgualAlValor = []
    for fila in lista:
      try:
        float(auxCast)
        condicion = float(self.dataset[fila][posVariable]) >= valor  
      except:
        condicion =  self.dataset[fila][posVariable] == valor

      if condicion:
        laVariableEsIgualAlValor.append(fila)
      else:
        laVariableNOEsIgualAlValor.append(fila)
  
    listasDivididas = (laVariableEsIgualAlValor, laVariableNOEsIgualAlValor)
    return listasDivididas
   
  """
  Con el metodo testear verificamos el exito de un estudiante segun el arbol generado
  """
  def testear(self, datasetTest, estudiante, posVariables):  
    exito = None
    nodoActual = self.root
    pregunta = self.pregunta
    while(nodoActual.nodoIzq is not None and nodoActual.nodoDer is not None):
      if datasetTest[estudiante][pregunta[0]] == pregunta[1]:
        nodoActual = nodoActual.nodoIzq.root
        try:
          pregunta = nodoActual.nodoIzq.pregunta 
        except:
          continue
      else:   
        nodoActual = nodoActual.nodoDer.root
        try:
          pregunta = nodoActual.nodoDer.pregunta 
        except:
          continue
   
    porcentajeNodo = Gini.impurezaG.porcentajeDeExito(self.dataset, nodoActual.lista)   
    if porcentajeNodo > 99:    
      exito = 1
    else:
      exito = 0
    return exito

    """
  Con el metodo generarBosque realizamos la produccion de bosques segun la calibracion especificada y su respectiva evaluacion
  """
  def generarBosque(bosque, posVariables, datasetTrain, datasetTest, listaTest, listaTrain, cantArboles, sizeArbol, alturaMaxima):    
    tiempoInicial = time.time()
    while (len(bosque) < cantArboles):
      listaRef = []

      a = None
      for est in range(randbelow(sizeArbol)+10):
          listaRef.append(randbelow(len(listaTrain)))
          
      a = ArbolDecision(listaRef, posVariables, datasetTrain, alturaMaxima = randbelow(alturaMaxima) + 3)
      
      if a is not None:
          if a.root.lista is not None:
              try:
                  a.pregunta
                  bosque.append(a)
              except:
                  continue
    timpoFinal = time.time()
    print('Tiempo de creacion de arboles ' + str(timpoFinal - tiempoInicial))
  
    tiempoEvaluacionInicial = time.time()
    falsosPositivos = 0
    falsosNegativos = 0
    verdaderosPositivos = 0
    verdaderosNegativos = 0
    for estudiantes in listaTest:
      votoExito = 0
      votoNoExito = 0
      exito = None
      for arbol in bosque:
        opinion = arbol.testear(datasetTest, estudiantes, posVariables)      
        if opinion == 1:
            votoExito += 1
        else:
            votoNoExito += 1
            

      if votoExito > votoNoExito:
        exito = 1
      else:
        exito = 0
   
      if int(datasetTest[estudiantes][77]) == exito and exito  == 1:
   
          verdaderosPositivos += 1
      elif int(datasetTest[estudiantes][77]) == exito and exito  == 0:
          verdaderosNegativos += 1
      elif int(datasetTest[estudiantes][77]) != exito and exito  == 1:
          falsosPositivos += 1
      else:
          falsosNegativos += 1         

    
    tiempoEvaluacionFinal = time.time()
    print('Tiempo de evaluacion ' + str(tiempoEvaluacionFinal - tiempoEvaluacionInicial))

    print("Verdaderos Positivos: " + str(verdaderosPositivos))
    print("Verdaderos Negativos: " + str(verdaderosNegativos))
    print("Falsos Positivos: " + str(falsosPositivos))
    print("Falsos Negativos: " + str(falsosNegativos))
    print(f"Acurracy: {(verdaderosPositivos + verdaderosNegativos)/len(datasetTest):.2f}")
    print(f"Precision: {(verdaderosPositivos/(verdaderosPositivos+falsosPositivos)):.2f}")
    print(f"Recall: {(verdaderosPositivos/(verdaderosPositivos+falsosNegativos)):.2f}" )
    print('Respuesta basada en ' + str(len(bosque)) + ' arboles')