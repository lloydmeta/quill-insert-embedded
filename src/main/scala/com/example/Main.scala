package com.example

import io.getquill._

@SuppressWarnings(
  Array("org.wartremover.warts.Product",
        "org.wartremover.warts.Serializable",
        "org.wartremover.warts.NonUnitStatements"))
object Main extends App {

  val ctx = new SqlMirrorContext[PostgresDialect, SnakeCase]

  import ctx._

  final case class Person(name: String, address: Address)

  final case class Address(value: String) extends Embedded

  val p = Person("Gott", Address("In dem Himmel"))

  // Doesn't work (uncomment to see)
//  val q = quote {
//    query[Person].insert(lift(p))
//  }
//  ctx.run(q)

  // works
  ctx.run {
    quote {
      query[Person].insert(lift(p))
    }
  }

}
