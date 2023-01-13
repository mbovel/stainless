import scala.annotation.refined

object IdentityRefinementAnnot:
  type Neg = Int @refined[Int](it => it < 0)

  def id[T](x: T): T = x

  def test = id[Int @refined[Int](it => it > 0)](1) + id[Neg](-2)
