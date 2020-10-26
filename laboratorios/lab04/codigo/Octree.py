import math
import Nodo as n
import Bee as b

class Octree:  
  def __init__(self, bees: list):
    self.arbol = n.Nodo(bees, b.Bee.getMins(bees), b.Bee.getMaxs(bees))
    self.choques = []
    midX = (self.arbol.mins[0] + self.arbol.maxs[0])/2
    midY = (self.arbol.mins[1] + self.arbol.maxs[1])/2
    midZ = (self.arbol.mins[2] + self.arbol.maxs[2])/2
    self.nuevosNodos(self.arbol, midX, midY, midZ) 
    
    
  def nuevosNodos(self, nodoPapa: n, midX: float, midY: float, midZ: float):  
    if len(nodoPapa.bees) < 2:
      return None
    condicion = magnitud(nodoPapa.mins, nodoPapa.maxs) 
    
    if (condicion <= 250):
      self.choques.append(nodoPapa.bees)
      return 0

    lista1 = []
    lista2 = []
    lista3 = []
    lista4 = []
    lista5 = []
    lista6 = []
    lista7 = []
    lista8 = []

    for bee in nodoPapa.bees:
      if bee.getLatitude() <= midX and bee.getLongitude() <= midY and bee.getAltitude() <= midZ:
        lista1.append(bee)
      elif bee.getLatitude() <= midX and bee.getLongitude() <= midY and bee.getAltitude() >= midZ:
        lista2.append(bee)
      elif bee.getLatitude() <= midX and bee.getLongitude() >= midY and bee.getAltitude() <= midZ:      
        lista3.append(bee)
      elif bee.getLatitude() <= midX and bee.getLongitude() >= midY and bee.getAltitude() >= midZ:
        lista4.append(bee)
      elif bee.getLatitude() >= midX and bee.getLongitude() <= midY and bee.getAltitude() <= midZ:
        lista5.append(bee)
      elif bee.getLatitude() >= midX and bee.getLongitude() <= midY and bee.getAltitude() >= midZ:
        lista6.append(bee)
      elif bee.getLatitude() >= midX and bee.getLongitude() >= midY and bee.getAltitude() <= midZ:
        lista7.append(bee)
      elif bee.getLatitude() >= midX and bee.getLongitude() >= midY and bee.getAltitude() >= midZ:
        lista8.append(bee)

    centro = (midX, midY, midZ)
    nodosHijos = [
      n.Nodo(lista1, nodoPapa.mins, centro),
      n.Nodo(lista2, (nodoPapa.mins[0], nodoPapa.mins[1], midZ), (midX, midY, nodoPapa.maxs[2])),
      n.Nodo(lista3, (nodoPapa.mins[0], midY, nodoPapa.mins[2]), (midX, nodoPapa.maxs[1], midZ)),
      n.Nodo(lista4, (nodoPapa.mins[0], midY, midZ), (midX, nodoPapa.maxs[1], nodoPapa.maxs[2])),
      n.Nodo(lista5, (midX, nodoPapa.mins[1], nodoPapa.mins[2]), (nodoPapa.maxs[0], midY, midZ)),
      n.Nodo(lista6, (midX, nodoPapa.mins[1], midZ), (nodoPapa.maxs[0], midY, nodoPapa.maxs[2])),
      n.Nodo(lista7, (midX, midY, nodoPapa.mins[2]), (nodoPapa.maxs[0], nodoPapa.maxs[1], midZ)),
      n.Nodo(lista8, centro, nodoPapa.maxs)
    ]

    for nodito in nodosHijos: 
      if(len(nodito.bees) == 0):
        continue
      else:
        nodoPapa.anadirHijo(nodito)
        centroNodito = midEjes(nodito.mins, nodito.maxs)
        self.nuevosNodos(nodito, centroNodito[0], centroNodito[1], centroNodito[2])

    return 0

  def choque(self):
    for bee in self.choques:
      print("Estas " + str(len(bee)) + " abejas chocan: ")
      print(*bee, sep = "\n")
      

def mit(p1: float, p2: float)->float:
  return p1 + p2 / 2

def midEjes(m: tuple, M: tuple):
  if m is None or M is None:
    return None

  res = (mit(M[0], m[0]), mit(M[1], m[1]), mit(M[2], m[2]))
  return res

def magnitud(m: tuple, M: tuple):
  if m is None or M is None:
    return None
  Vx = M[0]-m[0]
  Vy = M[1]-m[1]
  Vz = M[2]-m[2]
  res = math.sqrt((Vx**2) + (Vy**2) + (Vz**2))
  return res