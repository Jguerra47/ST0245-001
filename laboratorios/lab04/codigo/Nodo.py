class Nodo:
  def __init__(self, bees: list, mins: tuple, maxs: tuple):
    self.bees = bees
    self.mins = mins
    self.maxs  = maxs
    self.nodes = []
    
  def anadirHijo(self, nodo):
    self.nodes.append(nodo)
  
  def toStringss(self):
    for i in self.bees:
      print(i.toString())