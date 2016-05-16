/**
 * Copyright © 2014, 2015 Typesafe, Inc. All rights reserved. [http://www.typesafe.com]
 */

import scala.Console
import scala.util.matching._

shellPrompt in ThisBuild := { state =>
  val base: File = Project.extract(state).get(sourceDirectory)
  val basePath: String = base + "/test/resources/README.md"
  val exercise = Console.BLUE + IO.readLines(new sbt.File(basePath)).head + Console.RESET
  val manRmnd = Console.RED + "man [e]" + Console.RESET
  val prjNbrNme = Project.extract(state).get(name)
  s"$manRmnd > $prjNbrNme > $exercise > "
}
