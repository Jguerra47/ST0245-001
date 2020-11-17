"""
Proyecto de Estructuras de Datos y Algoritmos 1
Clase Nodo
@author: Juan Sebastian Guerra y Jacobo Rave
"""
class nodo:
  def __init__(self, lista, nodoIzq = None, nodoDer = None):
    self.lista = lista
    if len(self.lista) == 0:
      self.lista = None
    self.nodoIzq = nodoIzq
    self.nodoDer = nodoDer
