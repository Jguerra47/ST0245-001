"""
Proyecto de Estructuras de Datos y Algoritmos 1
Clase Main
@author: Juan Sebastian Guerra y Jacobo Rave
"""
import Arbol as al

"""
El metodo generarLista se encarga de inicializar las listas de referencia a los estudiantes
"""
def generarLista(dataset, lista):
  for i in range(len(dataset)):
      lista.append(i)

if __name__ == '__main__':
  posVariables = [9, 10, 13, 46, 47, 52, 53, 54, 55, 65, 66, 67,68,69,70,71,72,73,74,75,76]

  EntrenoDataset = al.ArbolDecision.leerDataset('4_train_balanced_135000.csv')
  PruebaDataset =  al.ArbolDecision.leerDataset('4_test_balanced_45000.csv')

  EntrenoLista = []
  PruebaLista = []
  
  generarLista(EntrenoDataset, EntrenoLista)
  generarLista(PruebaDataset, PruebaLista)

  bosque = []  
  #crear un solo arbol con todo el dataset:
  #arbolUnitario= Arbol.ArbolDecision(EntrenoLista, posVariables, EntrenarDataset, alturaMaxima = 10)
  #bosque.append(arbolUnitario)
  
  cantArboles = 1000
  TamañoArbol = 20
  rangoAltura = 4
  #Testear 25000 datos tiene una duracion estimada de 230 segundos
  al.ArbolDecision.generarBosque(bosque, posVariables, EntrenoDataset, PruebaDataset, PruebaLista, EntrenoLista, cantArboles, TamañoArbol, rangoAltura)