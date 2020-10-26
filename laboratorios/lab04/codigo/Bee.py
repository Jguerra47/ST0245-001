import pandas as pd

class Bee:
  def __init__(self, latitud: float, longitud: float, altitud: float):
    self.latitud = latitud
    self.longitud = longitud
    self.altitud = altitud

  def getLatitude(self):
    return self.latitud

  def getLongitude(self):
    return self.longitud

  def getAltitude(self):
    return self.altitud
  
  def toString(self):
    return str(self.latitude) + " " +  str(self.longitude) + " " + str(self.altitude)

  def crearAbejasPorTxt(nombreArchivo: str):
    dataset = pd.read_csv(nombreArchivo, sep=",", header=None)
    bees = []
    for i in range(1,len(dataset)):
      latitude = float(dataset[0][i])
      longitude = float(dataset[1][i])
      altitude = float(dataset[2][i])
      bees.append(Bee(latitude, longitude, altitude))
    return bees
  
  def getMins(arrayBees: list):
    if len(arrayBees) <= 0:
      return None
    minLatitud = arrayBees[0].getLatitude()
    minLongitude = arrayBees[0].getLongitude()
    minAltitude = arrayBees[0].getAltitude()

    for bee in arrayBees:
      minLatitud = min(minLatitud, bee.getLatitude())
      minLongitude = min(minLongitude, bee.getLongitude())
      minAltitude = min(minAltitude, bee.getAltitude())
    return (minLatitud, minLongitude, minAltitude)
  
  def getMaxs(arrayBees: list):
    if len(arrayBees) <= 0:
      return None
    maxLatitud = arrayBees[0].getLatitude()
    maxLongitude = arrayBees[0].getLongitude()
    maxAltitude = arrayBees[0].getAltitude()
    for bee in arrayBees:
      maxLatitud = max(maxLatitud, bee.getLatitude())
      maxLongitude = max(maxLongitude, bee.getLongitude())
      maxAltitude = max(maxAltitude, bee.getAltitude())
    return (maxLatitud, maxLongitude, maxAltitude)

  def __str__(self):
    return str(self.__dict__)