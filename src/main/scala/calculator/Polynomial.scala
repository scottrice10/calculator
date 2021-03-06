package calculator

object Polynomial {
  def computeDelta(a: Signal[Double], b: Signal[Double],
      c: Signal[Double]): Signal[Double] = {
    Signal(b() * b() - 4 * a() * c())
  }

  def computeSolutions(a: Signal[Double], b: Signal[Double],
      c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {
    Signal {
      if (computeDelta(a, b, c)() >= 0) {
        Set(
          (-b() + math.sqrt(computeDelta(a, b, c)())) / (2 * a()),
          (-b() - math.sqrt(computeDelta(a, b, c)())) / (2 * a())
        )
      } else {
        Set()
      }
    }
  }
}
