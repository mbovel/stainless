
object IdentityRefinement {
  type Neg = { x: Int with x < 0 }

  def id[T](x: T): T = x

  def f() = id[{x: Int with x > 0}](1) + id[Neg](-1)
}

