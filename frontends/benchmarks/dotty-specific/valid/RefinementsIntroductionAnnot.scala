import scala.annotation.refined
import stainless.annotation.extern
import stainless.io.{State, newState, StdIn}
import stainless.lang.{Option, Some, None}

@extern def assume(c: Boolean) = assert(c).ensuring(c)

def p(x: Int): Boolean = ???

def f(x: Int @refined(p)): Int = ???

def g(x: Int): Int @refined(p) =
    assume(p(x))
    val res = f(x)
    assume(p(res))
    res

given State = newState

/*
type Nat = Int @refined[Int](_ >= 0)

def readNatOption: Option[Nat] =
    val res = StdIn.readInt
    if res >= 0 then Some[Nat](res)
    else None[Nat]()

def testOption =
    val tmp: Option[Nat] = readNatOption
    if tmp.isDefined then tmp.get
    else 3

def testOption2 =
    tmp match
        case None[Nat]() => ()
        case Some[Nat](v) => assert(v >= 0)

class IllegalInputException(msg: String) extends Exception(msg)

def readNatException: Int @refined[Int](_ >= 0) =
    val res = StdIn.readInt
    if res >= 0 then res
    else throw IllegalInputException("Boom!")

object NotAnInt
type NotAnInt = NotAnInt.type
*/

/*
def readNatUnion: Int @refined[Int](_ >= 0) | NotAnInt =
    val res = StdIn.readInt
    if res >= 0 then res
    else NotAnInt
*/

enum MyNatOpt:
    case Some(v: Int @refined[Int](_ >= 0))
    case None()

def readNatEnum: MyNatOpt =
    val res = StdIn.readInt
    if res >= 0 then MyNatOpt.Some(res)
    else MyNatOpt.None()

def test =
    readNatEnum match
        case MyNatOpt.Some(v) => assert(v >= 0)
        case MyNatOpt.None() => ()
    