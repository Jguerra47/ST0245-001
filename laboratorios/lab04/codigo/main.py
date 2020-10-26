import Bee as b
import Octree as o

class main:
  def main():
    bees = b.Bee.crearAbejasPorTxt("ConjuntoDeDatosCon15abejas.txt")
    miOctree= o.Octree(bees)
    miOctree.choque() 
    return

if __name__ == "__main__":
	main.main()

