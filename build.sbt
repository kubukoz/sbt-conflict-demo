ThisBuild / libraryDependencySchemes += "io.circe" %% "circe-core" % "early-semver"

val core = project.settings(
  libraryDependencies ++= Seq(
    "co.fs2" %% "fs2-core" % "2.5.3",
    // conflicts with transitive version pulled in by fs2 (2.3.x)
    "org.typelevel" %% "cats-effect" % "3.0.0-RC2"
  )
)

val main = project
  .settings(
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-generic-extras" % "0.13.0",
      // conflicts with transitive veresion pulled in by circe-generic-extras (0.13.x)
      "io.circe" %% "circe-core" % "0.14.0-M4"
    )
  )
  .dependsOn(core)

val root = project.in(file(".")).aggregate(core, main)
