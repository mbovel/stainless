import stainless.lang._

object ConstructorRefinement {

  case class Rectangle(
    x: { x: BigInt with x >= BigInt(0) },
    y: { y: BigInt with y >= BigInt(0) }
  )

  extension (r: Rectangle) def perimeter: BigInt = r.x * 2 + r.y * 2

  def test(rectangle: Rectangle) = {
    assert(rectangle.perimeter >= 0)
  }

}
