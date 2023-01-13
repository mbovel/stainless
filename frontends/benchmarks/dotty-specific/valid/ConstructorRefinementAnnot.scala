import stainless.lang._
import scala.annotation.refined

object ConstructorRefinementAnnot:
  case class Rectangle(
    x: BigInt @refined[BigInt](it => it >= BigInt(0)),
    y: BigInt @refined[BigInt](_ >= BigInt(0))
  )

  extension (r: Rectangle) def perimeter: BigInt = r.x * 2 + r.y * 2

  def test(rectangle: Rectangle) =
    assert(rectangle.perimeter >= 0)
