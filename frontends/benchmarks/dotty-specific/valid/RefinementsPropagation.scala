import stainless.annotation.opaque

@opaque def getPos():  {it: Int with it > 0} = 2

@opaque def id[T](x: T): T = x

def main =
  val x: {it: Int with it > 0} = getPos()
  val x2: Int = x
  assert(x2 >= 0)

  val x3 = id(2)
  assert(x3 >= 0)

  val x4 = id[Int](2)
  assert(x4 >= 0)

  val x5 = id[{it: Int with it > 0}](2)
  assert(x5 >= 0)
